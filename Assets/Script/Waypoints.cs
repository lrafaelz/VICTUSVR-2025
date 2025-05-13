using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Waypoints : MonoBehaviour{

    private TrackWaypoints trackWaypoints;
    private MeshRenderer meshRenderer;
    private int difficulty;

    private void Awake(){
        meshRenderer = GetComponent<MeshRenderer>();
        // Obter os valores de dificuldade preenchidos no menu de configurações
        this.difficulty = PlayerPrefs.GetInt("HardCoreDifficulty");
    }

    private void Start(){
        Hide();
    }

    private void OnTriggerEnter(Collider other){
        if(other.tag.Equals("BMXBike")){
            Debug.Log("Player passou pelo waypoint: " + name);
            trackWaypoints.PlayerThroughtCheckpoint(this);
        }
    }

    public void SetTrackWaypoints(TrackWaypoints trackWaypoints){
        this.trackWaypoints = trackWaypoints;
    }

    public void Show(){
        meshRenderer.enabled = true;
    }

    public void Hide(){
        meshRenderer.enabled = false;
    }
}
