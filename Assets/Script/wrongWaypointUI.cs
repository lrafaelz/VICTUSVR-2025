using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class wrongWaypointUI : MonoBehaviour{

    [SerializeField] private TrackWaypoints TrackWaypoints;

    private void Start(){
        TrackWaypoints.OnPlayerCorrectWaypoint += TrackWaypoints_OnPlayerCorrectWaypoint;
        TrackWaypoints.OnPlayerWrongWaypoint += TrackWaypoints_OnPlayerWrongWaypoint;
        Hide();
    }

    private void TrackWaypoints_OnPlayerCorrectWaypoint(object sender, System.EventArgs e){
        Hide();
    }

    private void TrackWaypoints_OnPlayerWrongWaypoint(object sender, System.EventArgs e){
        Show();
    }

    private void Show(){
        gameObject.SetActive(true);
    }

    private void Hide(){
        gameObject.SetActive(false);
    }
}
