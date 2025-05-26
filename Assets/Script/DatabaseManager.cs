using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Firebase;
using Firebase.Firestore;
using Firebase.Extensions;
using System.Threading.Tasks;
using System;
using System.Linq;

public class DatabaseManager : MonoBehaviour
{
  public static DatabaseManager Instance { get; private set; }
  public FirebaseFirestore db;
  public bool IsReady { get; private set; }
  Controle controleScript;

  void Awake()
  {
    if (Instance == null)
    {
      Instance = this;
      DontDestroyOnLoad(gameObject);

      InitializeFirestore();
    }
    else if (Instance != this)
    {
      Destroy(gameObject);
      return;
    }
  }


  public void InitializeFirestore()
  {
    Firebase.FirebaseApp.CheckAndFixDependenciesAsync().ContinueWithOnMainThread(task =>
        {
          if (task.Result == Firebase.DependencyStatus.Available)
          {
            db = FirebaseFirestore.DefaultInstance;
            IsReady = true;
            Debug.Log("[DatabaseManager] Firestore pronto.");
          }
          else
          {
            Debug.LogError("[DatabaseManager] Falha nas dependências Firebase: " + task.Result);
          }
        });
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

    CollectionReference trackRef = db.Collection("VictusExergame").Document(instituitionName).Collection("Pacientes").Document(patientName).Collection(UnityEngine.SceneManagement.SceneManager.GetActiveScene().name);
    string sessionName = date.Replace("/", "-");
    trackRef.Document(sessionName).SetAsync(new Dictionary<string, object>
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
      CollectionReference patientsRef = db.Collection("VictusExergame")
          .Document(institutionName)
          .Collection("Pacientes");

      Debug.Log("[DatabaseManager] PacientesRef: " + patientsRef.Path);

      QuerySnapshot snapshot = await patientsRef.GetSnapshotAsync();

      Debug.Log("[DatabaseManager] Snapshot tem " + snapshot.Documents.Count() + " documentos");

      foreach (DocumentSnapshot document in snapshot.Documents)
      {
        if (document.Exists)
          patients.Add(document.Id);
      }

      Debug.Log("[DatabaseManager] Lista final: " + string.Join(", ", patients));
      return patients;
    }
    catch (Exception e)
    {
      Debug.LogError($"[DatabaseManager] Erro ao buscar pacientes: {e}");
      return new List<string>();
    }

  }

}

