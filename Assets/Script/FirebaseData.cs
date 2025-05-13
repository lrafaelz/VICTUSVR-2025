using Firebase.Firestore;

[FirestoreData]
public struct FirebaseData{
    [FirestoreProperty]
    public string date { get; set;}
    [FirestoreProperty]
    public string pacientName { get; set;}
    [FirestoreProperty]
    public float distanceTravelled { get; set;}
    [FirestoreProperty]
    public int sessionTime { get; set;}
    [FirestoreProperty]
    public int score { get; set;}
    [FirestoreProperty]
    public int[] velocity { get; set;}
    [FirestoreProperty]
    public int[] BPMSensor { get; set;}
    [FirestoreProperty]
    public int[] EMGSensor { get; set;}
}