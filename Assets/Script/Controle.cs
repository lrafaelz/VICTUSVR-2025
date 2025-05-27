using System;
using System.IO;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI; //Elementos da Interface Gráfica
using UnityEngine.AI;
using System.IO.Ports; // Biblioteca para ler comunicação serial com Arduino
using System.Threading;
using System.Globalization;
using System.Linq;


public class Controle : MonoBehaviour
{

  BikeSystem.controller.MotorcycleController BMXScript;
  private static SerialPort serial;
  private static readonly object serialLock = new object();
  private static bool isSerialConnected = false;
  private static Thread IOThread;
  private static bool shouldStopThread = false;
  private static Queue<string> dataQueue = new Queue<string>();

  public string date;
  public string pacientName;
  public Text displayContagem, displayBatimentos, displayVelocidade, displayEmg, displayScore, displayDistance;
  public float tempoSegundos, tempoMinutos, tempo = 0.0f;
  public float fimDaPartida = 0.0f;
  public NavMeshAgent navmesh;
  public GameObject player;
  public Text tempoFim;
  public GameObject entrada, highscoreTable, BMXBike, endMenu;
  public AudioSource bike, musica;
  public GameObject InputField;

  public TrackWaypoints trackWaypoints;
  public int barreiraScore;
  public int score;

  string emg, bpm;// variáveis 
  public int velInt, direcao;
  public float velocidade, eixo, distanceTravelled;

  public int[] velArray, BPMArray, EMGArray;
  private int once = 0;
  private bool onceCoroutine = false;

  private DatabaseManager databaseManager;
  private bool isReconnecting = false;

  // Public getters for debug access
  public string GetBPM() { return bpm; }
  public string GetEMG() { return emg; }

  void Awake()
  {
    BMXScript = BMXBike.GetComponent<BikeSystem.controller.MotorcycleController>();
    this.pacientName = "TESTE";
  }

  private static string FindCorrectPort()
  {
    string[] ports = SerialPort.GetPortNames();
    Debug.Log("[FIND_PORT] Available ports: " + string.Join(", ", ports));

    if (ports.Length == 0)
    {
      Debug.LogWarning("[FIND_PORT] No COM ports available. Please check device connections.");
      return null;
    }

    // Reverse the array to start from the last port (usually newer connections)
    Array.Reverse(ports);

    foreach (string port in ports)
    {
      try
      {
        Debug.Log($"[FIND_PORT] Testing port: {port}");

        // Quick test with shorter timeout to avoid blocking
        using (SerialPort testPort = new SerialPort(port, 115200))
        {
          testPort.ReadTimeout = 500; // Increased timeout for testing
          testPort.WriteTimeout = 500;
          testPort.DtrEnable = true;
          testPort.RtsEnable = true;

          testPort.Open();
          Debug.Log($"[FIND_PORT] Port {port} opened successfully");

          // Wait a moment for potential data
          Thread.Sleep(200);

          // Check if there's data available
          int bytesAvailable = testPort.BytesToRead;
          Debug.Log($"[FIND_PORT] Port {port} has {bytesAvailable} bytes available");

          if (bytesAvailable > 0)
          {
            try
            {
              // Try to read a line first
              string line = testPort.ReadLine();
              Debug.Log($"[FIND_PORT] Read line from {port}: '{line}'");

              if (line.Contains("#"))
              {
                string[] parts = line.Split('#');
                Debug.Log($"[FIND_PORT] Found valid data on {port}: {parts.Length} parts - [{string.Join("] [", parts)}]");

                if (parts.Length >= 4) // At least 4 parts for basic validation
                {
                  Debug.Log($"[FIND_PORT] ✅ Port {port} is valid with proper data format");
                  testPort.Close();
                  return port;
                }
              }
            }
            catch (TimeoutException)
            {
              Debug.Log($"[FIND_PORT] Timeout reading from {port}");
              // Try reading existing data instead
              try
              {
                string existing = testPort.ReadExisting();
                Debug.Log($"[FIND_PORT] Read existing from {port}: '{existing}'");
                if (existing.Contains("#"))
                {
                  Debug.Log($"[FIND_PORT] ✅ Port {port} has data with # delimiter");
                  testPort.Close();
                  return port;
                }
              }
              catch (Exception ex)
              {
                Debug.Log($"[FIND_PORT] Error reading existing from {port}: {ex.Message}");
              }
            }
          }
          else
          {
            Debug.Log($"[FIND_PORT] No data available on {port}");
          }

          testPort.Close();
        }
      }
      catch (Exception e)
      {
        Debug.Log($"[FIND_PORT] Error testing port {port}: {e.Message}");
        continue;
      }
    }

    // If no port with data is found, return COM5 specifically if available (from your TeraTerm screenshot)
    if (ports.Contains("COM5"))
    {
      Debug.LogWarning($"[FIND_PORT] No valid data found, but using COM5 as it appeared in TeraTerm");
      return "COM5";
    }

    // Otherwise return the first available port as fallback
    Debug.LogWarning($"[FIND_PORT] No valid port found with expected data format. Using first available port: {ports[0]}");
    return ports[0];
  }

  private static void DataThread()
  {
    string connectedPort = null;

    while (!shouldStopThread)
    {
      try
      {
        // Only find port if we're not connected
        if (!isSerialConnected)
        {
          Debug.Log("Procurando porta serial disponível...");
          connectedPort = FindCorrectPort();

          if (!string.IsNullOrEmpty(connectedPort))
          {
            lock (serialLock)
            {
              try
              {
                if (serial != null)
                {
                  CloseSerialPort();
                }

                serial = new SerialPort(connectedPort, 115200);
                serial.ReadTimeout = 3000; // Increased timeout to 3 seconds
                serial.WriteTimeout = 3000;
                serial.DtrEnable = true; // Enable DTR
                serial.RtsEnable = true; // Enable RTS
                serial.Open();

                // Wait a bit for the connection to stabilize
                Thread.Sleep(1000); // Increased wait time

                isSerialConnected = true;
                Debug.Log($"Successfully connected to port {connectedPort}");
              }
              catch (Exception e)
              {
                Debug.LogError($"Failed to connect to {connectedPort}: {e.Message}");
                isSerialConnected = false;
                Thread.Sleep(2000); // Wait before trying again
                continue;
              }
            }
          }
          else
          {
            Debug.LogWarning("Nenhuma porta serial encontrada. Tentando novamente em 5 segundos...");
            Thread.Sleep(5000);
            continue;
          }
        }

        // Main reading loop - only execute if connected
        if (isSerialConnected)
        {
          try
          {
            lock (serialLock)
            {
              if (serial != null && serial.IsOpen)
              {
                // Check if data is available without blocking
                if (serial.BytesToRead > 0)
                {
                  string data = serial.ReadLine().Trim();

                  if (!string.IsNullOrEmpty(data) && data.Contains("#"))
                  {
                    string[] parts = data.Split('#');
                    Debug.Log($"[DATATHREAD] Partes divididas: {parts.Length} - [{string.Join("] [", parts)}]");

                    if (parts.Length >= 4)
                    {
                      lock (dataQueue)
                      {
                        dataQueue.Enqueue(data);
                        // Debug.Log($"[DATATHREAD] Dados adicionados à queue! Tamanho atual: {dataQueue.Count}"); // Log frequente removido

                        // Keep only the latest 5 readings to prevent lag
                        while (dataQueue.Count > 10) // Aumentado para 10 para ter um buffer maior
                        {
                          string removed = dataQueue.Dequeue();
                          // Debug.Log($"[DATATHREAD] Removido da queue: '{removed}'"); // Log frequente removido
                        }
                      }
                    }
                    else
                    {
                      Debug.LogWarning($"[DATATHREAD] Dados incompletos: {parts.Length} partes, esperado pelo menos 4. Data: '{data}'");
                    }
                  }
                  else
                  {
                    // Debug.LogWarning($"[DATATHREAD] Dados inválidos (sem #): '{data}'"); // Log de dados invalidos pode ser demais
                  }
                }
                // Removido log que usava Time.time
              }
              else
              {
                Debug.LogWarning("[DATATHREAD] Porta serial fechou inesperadamente");
                isSerialConnected = false;
              }
            }

            Thread.Sleep(16); // ~60Hz reading rate
          }
          catch (System.TimeoutException)
          {
            // Timeout is normal when no data is available, continue
            Debug.Log("[DATATHREAD] Timeout na leitura (normal)");
            Thread.Sleep(100);
          }
          catch (System.IO.IOException e)
          {
            Debug.LogError($"[DATATHREAD] IO Error reading from serial: {e.Message}");
            isSerialConnected = false;
            Thread.Sleep(1000);
          }
          catch (Exception e)
          {
            Debug.LogError($"[DATATHREAD] Unexpected error reading from serial: {e.Message}");
            Debug.LogError($"[DATATHREAD] Stack trace: {e.StackTrace}");
            isSerialConnected = false;
            Thread.Sleep(1000);
          }
        }
      }
      catch (Exception e)
      {
        Debug.LogError($"Error in DataThread main loop: {e.Message}");
        isSerialConnected = false;
        Thread.Sleep(2000);
      }
    }

    // Cleanup when thread is stopping
    Debug.Log("DataThread parando, fechando conexão serial...");
    CloseSerialPort();
  }

  private static void CloseSerialPort()
  {
    try
    {
      if (serial != null)
      {
        if (serial.IsOpen)
        {
          serial.Close();
        }
        serial.Dispose();
        serial = null;
      }
      isSerialConnected = false;
    }
    catch (Exception e)
    {
      Debug.LogError($"Error closing serial port: {e.Message}");
    }
  }

  private void OnDestroy()
  {
    shouldStopThread = true;
    if (IOThread != null && IOThread.IsAlive)
    {
      IOThread.Join(2000); // Wait up to 2 seconds
    }
    CloseSerialPort();
  }

  // Use this for initialization
  void Start()
  {
    if (BMXScript.useSerial == 1)
    {
      shouldStopThread = false;
      IOThread = new Thread(DataThread);
      IOThread.IsBackground = true;
      IOThread.Start();
    }
    Time.timeScale = 0;
    // serial.ReadTimeout = -1;
    // navmesh = player.GetComponent<NavMeshAgent> ();
    //StartCoroutine (LerDadosDoSerial ());// começa o loop
    displayVelocidade.text = "0";
    displayBatimentos.text = " ";
    //fimDaPartida = getda interface

    databaseManager = DatabaseManager.Instance;

    // Pega o paciente selecionado do dropdown
    string pacienteSelecionado = AdvancedDropdown.PacienteSelecionado;
    if (!string.IsNullOrEmpty(pacienteSelecionado))
    {
      this.pacientName = pacienteSelecionado;
    }
  }

  private IEnumerator ReconnectSerialPort()
  {
    if (isReconnecting) yield break;

    isReconnecting = true;
    Debug.LogWarning("Forçando reconexão serial...");

    yield return new WaitForSeconds(1f);

    try
    {
      // Simply signal disconnection - DataThread will handle reconnection
      lock (serialLock)
      {
        isSerialConnected = false;
      }
    }
    catch (Exception e)
    {
      Debug.LogError("Erro ao forçar reconexão: " + e.Message);
    }
    finally
    {
      isReconnecting = false;
    }
  }

  // Update is called once per frame
  void Update()
  {
    if (tempo >= fimDaPartida)
    {
      //fim da partida
      displayScore.text = "Acabou a sessão!";
      Time.timeScale = 0;
      highscoreTable.SetActive(true);
      if (BMXScript.useSerial == 1)
        getArrayValues();

      if (once == 0)
      {
        this.SaveToJson();
        databaseManager.saveFirebaseData(date, pacientName, distanceTravelled, (int)fimDaPartida, score, velArray, BPMArray, EMGArray);
      }
      once++;
    }
    else
    {
      string scenaAtual = UnityEngine.SceneManagement.SceneManager.GetActiveScene().name;
      if (Time.time % 5 < 0.1f) // Log scene every 5 seconds
      {
        Debug.Log($"[CONTROLE_UPDATE] Scena: {scenaAtual}, useSerial: {BMXScript.useSerial}");
      }

      StartCoroutine(wait(5f));
      tempo += Time.deltaTime;
      tempoMinutos = (int)tempo / 60;
      tempoSegundos = (int)tempo % 60;
      displayContagem.text = tempoMinutos.ToString("00") + ":" + tempoSegundos.ToString("00");
      this.score = trackWaypoints.waypointScore - this.barreiraScore;
      displayScore.text = "score: " + score.ToString();

      if (this.BMXScript.useSerial == 0)
      {
        this.velInt = (int)this.BMXScript.ActualVelocity;
        this.displayVelocidade.text = this.velInt.ToString();
        distanceTravelled = distanceTravelled + this.velInt * Time.deltaTime;
        this.displayDistance.text = distanceTravelled.ToString();

        if (Time.time % 3 < 0.1f) // Log WASD mode every 3 seconds
        {
          Debug.Log($"[CONTROLE_UPDATE] Modo WASD - Vel: {this.velInt}, Dist: {distanceTravelled:F1}");
        }
      }
      else
      {
        Debug.Log($"[CONTROLE_UPDATE] Modo SERIAL - Chamando ProcessSerialData()");
        // Process serial data from queue
        ProcessSerialData();
      }
    }
  }

  private void ProcessSerialData()
  {
    try
    {
      string latestData = null;

      lock (dataQueue)
      {
        if (dataQueue.Count > 0)
        {
          latestData = dataQueue.Dequeue();
        }
      }

      if (latestData != null)
      {
        string[] valores = latestData.Split('#');

        if (valores.Length >= 4)
        {
          // Parse the 4 main values: BPM#VEL#EMG#DIR
          this.bpm = valores[0];
          float.TryParse(valores[1], NumberStyles.Any, CultureInfo.InvariantCulture, out this.velocidade);
          this.emg = valores[2];
          int.TryParse(valores[3], out this.direcao);

          // Calculate distance based on velocity and time
          this.distanceTravelled += this.velocidade * Time.deltaTime;

          // Update UI
          displayBatimentos.text = this.bpm;
          displayEmg.text = "EMG: " + this.emg;
          this.velInt = (int)this.BMXScript.ActualVelocity;
          this.displayVelocidade.text = this.velInt.ToString();
          this.displayDistance.text = distanceTravelled.ToString("F1");

          // Log only every 5 seconds to reduce overhead
          if (Time.time % 5 < 0.02f)
          {
            Debug.Log($"[CONTROLE] Serial: BPM:{this.bpm} Vel:{this.velocidade:F1} EMG:{this.emg} Dir:{this.direcao} Dist:{this.distanceTravelled:F1}");
          }
        }
      }
      else if (!isSerialConnected)
      {
        displayBatimentos.text = "Conecte os sensores";
        displayEmg.text = "Conecte os sensores";
      }
    }
    catch (Exception e)
    {
      Debug.LogError($"[CONTROLE] Erro processamento: {e.Message}");
    }
  }

  public int getDirecao()
  {
    return direcao;
  }

  public float getVelocidade()
  {
    return velocidade;
  }

  public bool IsSerialConnected()
  {
    return isSerialConnected;
  }

  public int GetQueueCount()
  {
    lock (dataQueue)
    {
      return dataQueue.Count;
    }
  }

  IEnumerator LerDadosDoSerial()
  {
    while (true)
    {
      string[] valores = serial.ReadLine().Split('#'); // separador de valores BPM#Vel#EMG
      bpm = valores[0];
      velocidade = float.Parse(valores[1]);
      emg = valores[2];
      distanceTravelled = float.Parse(valores[3]);

      //eixo = ventradaalores [3];
      Debug.Log("[CONTROLE] Valores: " + bpm + "#" + velocidade + "#" + emg + "#" + distanceTravelled);
      serial.BaseStream.Flush(); //Clear the serial information so we assure we get new information.
      yield return new WaitForSeconds(0.3f); //tempo de leitura de novas informações

    }
  }

  public void SetaTempo()
  {
    try
    {
      if (Input.GetKeyDown(KeyCode.Return) || Input.GetKeyDown(KeyCode.KeypadEnter))
      {
        if (!string.IsNullOrEmpty(tempoFim.text) && float.TryParse(tempoFim.text, out float tempo))
        {
          fimDaPartida = 60 * tempo;
          Time.timeScale = 1;
          Debug.Log("[CONTROLE] Tempo da sessão definido para: " + fimDaPartida + " segundos");
          entrada.SetActive(false);
          // musica.Play ();
          // bike.Play ();
        }
        else
        {
          Debug.LogWarning("[CONTROLE] Tempo inválido inserido: " + tempoFim.text);
        }
      }
    }
    catch (Exception e)
    {
      Debug.LogError("[CONTROLE] Erro ao definir tempo: " + e.Message);
    }
  }

  IEnumerator wait(float sec)
  {
    if (onceCoroutine == false)
    {
      onceCoroutine = true;
      yield return new WaitForSeconds(sec);
      getArrayValues();
      onceCoroutine = false;
    }
  }

  public void getArrayValues()
  {
    // Initialize arrays if they're null
    if (velArray == null) velArray = new int[0];
    if (BPMArray == null) BPMArray = new int[0];
    if (EMGArray == null) EMGArray = new int[0];

    // Add velocity value if it exists
    if (velInt != 0)
    {
      velArray = velArray.Append(velInt).ToArray();
    }

    // Add BPM value if it exists and can be parsed
    if (!string.IsNullOrEmpty(bpm) && int.TryParse(bpm, out int bpmValue))
    {
      BPMArray = BPMArray.Append(bpmValue).ToArray();
    }

    // Add EMG value if it exists and can be parsed
    if (!string.IsNullOrEmpty(emg) && int.TryParse(emg, out int emgValue))
    {
      EMGArray = EMGArray.Append(emgValue).ToArray();
    }
  }

  public void SaveToJson()
  {
    SessionData data = new SessionData();
    date = DateTime.Now.ToString();
    data.date = date;
    // Debug.Log("[CONTROLE] timestamp: " + data.date);
    Debug.Log("[CONTROLE] Pacient Name: " + this.pacientName);
    data.pacientName = this.pacientName;
    data.distanceTravelled = this.distanceTravelled;
    data.sessionTime = (int)this.fimDaPartida;
    data.score = this.score;
    data.velocity = this.velArray;
    data.BPMSensor = this.BPMArray;
    data.EMGSensor = this.EMGArray;

    string json = JsonUtility.ToJson(data, true);
    File.WriteAllText(Application.dataPath + "saves/sessionData.json", json);
    Debug.Log("[CONTROLE] Saved to: " + Application.dataPath + "saves/sessionData.json");
  }

  public void LoadFromJson()
  {
    string json = File.ReadAllText(Application.dataPath + "saves/sessionData.json");
    SessionData data = JsonUtility.FromJson<SessionData>(json);
  }

}