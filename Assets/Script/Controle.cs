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
  Thread IOThread = new Thread(DataThread);

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
  void Awake()
  {
    BMXScript = BMXBike.GetComponent<BikeSystem.controller.MotorcycleController>();
    this.pacientName = "TESTE";
  }

  private static void DataThread()
  {
    string correctPort = FindCorrectPort();
    if (string.IsNullOrEmpty(correctPort))
    {
      Debug.LogError("No valid COM port found with the expected data format!");
      return;
    }

    serial = new SerialPort(correctPort, 115200);
    serial.Open();
    Thread.Sleep(200);
  }

  private static string FindCorrectPort()
  {
    string[] ports = SerialPort.GetPortNames();
    Debug.Log("Available ports: " + string.Join(", ", ports));

    foreach (string port in ports)
    {
      try
      {
        using (SerialPort testPort = new SerialPort(port, 115200))
        {
          testPort.ReadTimeout = 1000; // 1 second timeout
          testPort.Open();

          // Try to read data
          string data = testPort.ReadLine();
          if (data.Contains("#"))
          {
            Debug.Log($"Found valid port: {port} with data: {data}");
            testPort.Close();
            return port;
          }

          testPort.Close();
        }
      }
      catch (Exception e)
      {
        Debug.Log($"Error testing port {port}: {e.Message}");
        continue;
      }
    }

    return null;
  }

  // private void OnDestroy(){
  // 	IOThread.Abort ();
  // 	serial.Close ();
  // }


  // Use this for initialization
  void Start()
  {
    if (BMXScript.useSerial == 1)
      IOThread.Start();
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

      // bike.Pause ();
      // musica.Pause ();
      //******INSTANTIATE OS SCORES
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
      Debug.Log("Scena Atual: " + scenaAtual);
      StartCoroutine(wait(5f));
      tempo += Time.deltaTime;
      tempoMinutos = (int)tempo / 60;
      tempoSegundos = (int)tempo % 60;
      displayContagem.text = tempoMinutos.ToString("00") + ":" + tempoSegundos.ToString("00");
      // Debug.Log("BarreiraScore: " + this.barreiraScore);
      this.score = trackWaypoints.waypointScore - this.barreiraScore;
      displayScore.text = "score: " + score.ToString();

      if (this.BMXScript.useSerial == 0)
      {
        this.velInt = (int)this.BMXScript.ActualVelocity;
        this.displayVelocidade.text = this.velInt.ToString();
        distanceTravelled = distanceTravelled + this.velInt * Time.deltaTime;
        this.displayDistance.text = distanceTravelled.ToString();

      }
      else
      {
        try
        {
          string[] valores = serial.ReadLine().Split('#'); // separador de valores
          // Debug.Log("Valores" + "#"+valores[0] +"#"+ valores[1] +"#"+ valores[2] + "#" + valores[3] );
          while (valores.Length < 5)
          { // to avoid errors
            valores = serial.ReadLine().Split('#'); // separador de valores
            serial.BaseStream.Flush(); //Clear the serial information so we assure we get new information.
          }
          this.bpm = valores[0];
          this.velocidade = float.Parse(valores[1], CultureInfo.InvariantCulture);
          this.emg = valores[2];
          this.direcao = int.Parse(valores[3]);
          this.distanceTravelled = float.Parse(valores[4], CultureInfo.InvariantCulture);

          //eixo = valores [3];
          // LerDadosDoSerial();
          Debug.Log("Valores" + "#" + this.bpm + "#" + this.velocidade + "#" + this.emg + "#" + this.direcao + "#" + this.distanceTravelled);
          displayBatimentos.text = this.bpm;
          displayEmg.text = "EMG: " + this.emg;
          // navmesh.speed = (float)(velocidade / 3.6);						
          this.velInt = (int)this.BMXScript.ActualVelocity;
          this.displayVelocidade.text = this.velInt.ToString();
          this.displayDistance.text = distanceTravelled.ToString();

          serial.BaseStream.Flush(); //Clear the serial information so we assure we get new information.
        }
        catch (Exception e)
        {
          Debug.LogError("Erro ao ler dados do dispositivo: " + e.Message);
          displayBatimentos.text = "Conecte os sensores";
          displayEmg.text = "Conecte o sensores";
          displayVelocidade.text = "0";
          displayDistance.text = "0";
        }
      }

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
      Debug.Log("Valores: " + bpm + "#" + velocidade + "#" + emg + "#" + distanceTravelled);
      serial.BaseStream.Flush(); //Clear the serial information so we assure we get new information.
      yield return new WaitForSeconds(0.3f); //tempo de leitura de novas informações

    }
  }

  public void SetaTempo()
  {
    if (Input.GetKeyDown(KeyCode.Return) || Input.GetKeyDown(KeyCode.KeypadEnter))
    {
      fimDaPartida = 60 * float.Parse(tempoFim.text);
      Time.timeScale = 1;
      Debug.Log("passei pelo setar tempo\n");
      entrada.SetActive(false);
      // musica.Play ();
      // bike.Play ();
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
    // Debug.Log("timestamp: " + data.date);
    Debug.Log("Pacient Name: " + this.pacientName);
    data.pacientName = this.pacientName;
    data.distanceTravelled = this.distanceTravelled;
    data.sessionTime = (int)this.fimDaPartida;
    data.score = this.score;
    data.velocity = this.velArray;
    data.BPMSensor = this.BPMArray;
    data.EMGSensor = this.EMGArray;

    string json = JsonUtility.ToJson(data, true);
    File.WriteAllText(Application.dataPath + "saves/sessionData.json", json);
    Debug.Log("Saved to: " + Application.dataPath + "saves/sessionData.json");
  }

  public void LoadFromJson()
  {
    string json = File.ReadAllText(Application.dataPath + "saves/sessionData.json");
    SessionData data = JsonUtility.FromJson<SessionData>(json);
  }

}