using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Firebase.Firestore;
using Firebase.Extensions;
using System.Threading.Tasks;

public class DatabaseManager : MonoBehaviour
{   
   FirebaseFirestore db;
   Controle controleScript;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    public void saveFirebaseData(string date, string pacientName, float distanceTravelled, int sessionTime, int score, int[] velocity, int[] BPMSensor, int[] EMGSensor){
        db = FirebaseFirestore.DefaultInstance;
        FirebaseData data = new FirebaseData{
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

    public async Task add_instituition_therapists(string instituitionName, string instituitionEmail, string instituitionPassword, string therapistName, string therapistEmail, string therapistPassword){
        DocumentReference srfRef = db.Collection("PhysioGames").Document(instituitionName);

        // Adicionando campos ao SRF
        Dictionary<string, object> fieldsToUpdate = new Dictionary<string, object>{
            { "email", instituitionEmail },
            { "password", instituitionPassword }
        };
        srfRef.SetAsync(fieldsToUpdate).ContinueWithOnMainThread(task => {
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
        }).ContinueWithOnMainThread(task => {
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

    public async Task add_patient_sessions(string instituitionName, string patientName, string date, float distanceTravelled, int sessionTime, int score, int[] velocity, int[] BPMSensor, int[] EMGSensor){

        DocumentReference patientRef = db.Collection("PhysioGames").Document(instituitionName).Collection("Pacientes").Document(patientName).Collection("Jogos").Document("VictusExergame");
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
}

