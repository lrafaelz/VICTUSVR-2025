using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Firebase.Firestore;
using Firebase.Extensions;
using System.Threading.Tasks;
using System;

public class DatabaseManager : MonoBehaviour
{
  private static DatabaseManager instance;
  public static DatabaseManager Instance
  {
    get
    {
      if (instance == null)
      {
        instance = FindObjectOfType<DatabaseManager>();
        if (instance == null)
        {
          var go = new GameObject("DatabaseManager");
          instance = go.AddComponent<DatabaseManager>();
          if (Application.isPlaying)
            DontDestroyOnLoad(go);
        }
      }
      return instance;
    }
  }

  public FirebaseFirestore db;
  Controle controleScript;

  void Awake()
  {
    if (instance == null)
    {
      instance = this;
      if (Application.isPlaying)
        DontDestroyOnLoad(gameObject);
    }
    else if (instance != this)
    {
      Destroy(gameObject);
    }
  }

  public void InitializeFirestore()
  {
    try
    {
      Debug.Log("[DatabaseManager] Inicializando Firestore...");
      db = FirebaseFirestore.DefaultInstance;

      if (db == null)
      {
        Debug.LogError("[DatabaseManager] Erro: FirebaseFirestore.DefaultInstance retornou null!");
        return;
      }

      Debug.Log("[DatabaseManager] Firestore inicializado com sucesso!");
    }
    catch (Exception ex)
    {
      Debug.LogError("[DatabaseManager] Erro ao inicializar Firestore: " + ex.Message);
      if (ex.InnerException != null)
      {
        Debug.LogError("[DatabaseManager] Inner exception: " + ex.InnerException.Message);
      }
    }
  }

  // Start is called before the first frame update
  void Start()
  {

  }

  // Update is called once per frame
  public void saveFirebaseData(string date, string pacientName, float distanceTravelled, int sessionTime, int score, int[] velocity, int[] BPMSensor, int[] EMGSensor)
  {
    FirebaseData data = new FirebaseData
    {
      date = date,
      pacientName = pacientName,
      distanceTravelled = distanceTravelled,
      sessionTime = sessionTime,
      score = score,
      velocity = velocity,
      BPMSensor = BPMSensor,
      EMGSensor = EMGSensor
    };

    string therapistName = "Therapist1";

    add_instituition_therapists("SRF", "instituitionEmail", "instituitionPassword", therapistName, "therapistEmail", "therapistPassword");

    add_patient_sessions("SRF", pacientName, date, distanceTravelled, sessionTime, score, velocity, BPMSensor, EMGSensor);
  }

  public async Task add_instituition_therapists(string instituitionName, string instituitionEmail, string instituitionPassword, string therapistName, string therapistEmail, string therapistPassword)
  {
    DocumentReference srfRef = db.Collection("VictusExergame").Document(instituitionName);

    // Adicionando campos ao SRF
    Dictionary<string, object> fieldsToUpdate = new Dictionary<string, object>{
                { "email", instituitionEmail },
                { "password", instituitionPassword }
            };
    srfRef.SetAsync(fieldsToUpdate).ContinueWithOnMainThread(task =>
    {
      if (task.IsFaulted)
      {
        Debug.LogError("Erro ao atualizar o documento: " + task.Exception);
      }
      else
      {
        Debug.Log("Campos adicionados com sucesso.");
      }
    });
    CollectionReference therapistsRef = srfRef.Collection("Fisioterapeutas");
    therapistsRef.Document(therapistName).SetAsync(new Dictionary<string, object>{
                { "email", therapistEmail },
                { "password", therapistPassword }
            }).ContinueWithOnMainThread(task =>
            {
              if (task.IsFaulted)
              {
                Debug.LogError("Falha ao adicionar fisioterapeuta: " + task.Exception);
              }
              else
              {
                Debug.Log("Fisioterapeuta adicionado com sucesso.");
              }
            });
  }

  public async Task add_patient_sessions(string instituitionName, string patientName, string date, float distanceTravelled, int sessionTime, int score, int[] velocity, int[] BPMSensor, int[] EMGSensor)
  {

    DocumentReference patientRef = db.Collection("VictusExergame").Document(instituitionName).Collection("Pacientes").Document(patientName).Collection("Jogos").Document("VictusExergame");
    CollectionReference sessionsRef = patientRef.Collection("Sessoes");
    string sessionName = date.Replace("/", "-");
    sessionsRef.Document(sessionName).SetAsync(new Dictionary<string, object>
            {
                { "distancia", distanceTravelled },
                { "tempo de sessão", sessionTime },
                { "pontuacao", score },
                { "velocidade", velocity },
                { "BPM", BPMSensor },
                { "EMG", EMGSensor }
            }).ContinueWithOnMainThread(task =>
            {
              if (task.IsFaulted)
              {
                Debug.LogError("Falha ao adicionar sessão: " + task.Exception);
              }
              else
              {
                Debug.Log("Sessão adicionada com sucesso.");
              }
            });
  }

  public async Task<List<string>> GetPatientsList(string institutionName)
  {
    try
    {
      List<string> patients = new List<string>();

      // Referência para a coleção de pacientes
      CollectionReference patientsRef = db.Collection("VictusExergame")
          .Document(institutionName)
          .Collection("Pacientes");

      // Busca os documentos de forma assíncrona
      QuerySnapshot snapshot = await patientsRef.GetSnapshotAsync();

      // Processa os resultados na thread principal
      await UnityMainThreadDispatcher.Instance().EnqueueAsync(() =>
      {
        foreach (DocumentSnapshot document in snapshot.Documents)
        {
          if (document.Exists)
          {
            patients.Add(document.Id);
          }
        }
      });

      return patients;
    }
    catch (Exception e)
    {
      Debug.LogError($"Erro ao buscar pacientes: {e.Message}");
      return new List<string>();
    }
  }
}

