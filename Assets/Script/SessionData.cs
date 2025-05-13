// this object will hold all the session data that is going to be saved in the database
// the array variables are going to register the data of the sensors at each 5 seconds of the session

[System.Serializable]
public class SessionData{
    public string date;
    public string pacientName;
    public float distanceTravelled;
    public int sessionTime;
    public int score;
    public int[] velocity;
    public int[] BPMSensor;
    public int[] EMGSensor;
}