using UnityEngine;
using UnityEngine.UI;

public class SerialDebugger : MonoBehaviour
{
  public Text debugText;
  public Controle controle;

  private float updateInterval = 1f;
  private float lastUpdate = 0f;

  void Start()
  {
    if (controle == null)
      controle = FindObjectOfType<Controle>();

    Debug.Log("[SERIAL_DEBUGGER] SerialDebugger iniciado");
    if (controle != null)
      Debug.Log("[SERIAL_DEBUGGER] Controle encontrado");
    else
      Debug.LogError("[SERIAL_DEBUGGER] Controle NÃO encontrado!");
  }

  void Update()
  {
    if (Time.time - lastUpdate > updateInterval)
    {
      UpdateDebugInfo();
      lastUpdate = Time.time;
    }
  }

  void UpdateDebugInfo()
  {
    if (controle != null && debugText != null)
    {
      bool isConnected = controle.IsSerialConnected();
      int queueCount = controle.GetQueueCount();
      string bpm = controle.GetBPM();
      float velocidade = controle.getVelocidade();
      int direcao = controle.getDirecao();
      string emg = controle.GetEMG();
      float distancia = controle.distanceTravelled;

      string debugInfo = $"Serial Status: {(isConnected ? "Connected" : "Disconnected")}\n";
      debugInfo += $"Queue Count: {queueCount}\n";
      debugInfo += $"BPM: {bpm}\n";
      debugInfo += $"Velocidade: {velocidade}\n";
      debugInfo += $"Direção: {direcao}\n";
      debugInfo += $"EMG: {emg}\n";
      debugInfo += $"Distância: {distancia:F2}\n";

      debugText.text = debugInfo;

      // Log detalhado para debug
      Debug.Log($"[SERIAL_DEBUGGER] Status:{(isConnected ? "ON" : "OFF")} Queue:{queueCount} BPM:{bpm} Vel:{velocidade} Dir:{direcao} EMG:{emg} Dist:{distancia:F1}");
    }
    else
    {
      if (controle == null)
        Debug.LogWarning("[SERIAL_DEBUGGER] Controle é null!");
      if (debugText == null)
        Debug.LogWarning("[SERIAL_DEBUGGER] debugText é null!");
    }
  }
}