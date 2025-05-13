using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class sideBarrier : MonoBehaviour{

    public GameObject Player;
    public GameObject TeleportTo;
    public GameObject stopWall;

    private Collider[] wallColliders;
    private bool areCollidersActive = true;
    // public MotorcycleController motorcycleController;
 
    private IEnumerator OnTriggerEnter(Collider collision)
    {
        if(collision.gameObject == Player){
            // wait for 3 seconds
            yield return new WaitForSeconds(1);
            Player.transform.position = TeleportTo.transform.position;
            Player.transform.rotation = TeleportTo.transform.rotation;
            Physics.SyncTransforms();
            // Stop bike
            SetCollidersActive(true);
            // MotorcycleController bikeController = Player.GetComponent<MotorcycleController>();
            // wait a second
            StartCoroutine(wait(0.5f));
        }
    }


    IEnumerator wait(float sec){
        yield return new WaitForSeconds(sec);
        SetCollidersActive(false);
    }

    private void SetCollidersActive(bool active)
    {
        foreach (var collider in wallColliders)
        {
            collider.enabled = active;
        }
    }

    private MeshRenderer meshRenderer;
    TrackWaypoints waypoints;
    private void Awake(){
        meshRenderer = GetComponent<MeshRenderer>();
        wallColliders = stopWall.GetComponentsInChildren<Collider>();
        SetCollidersActive(false);
    }

    private void Start(){
        // Debug.Log("wallColliders: " + wallColliders.Length);
        Hide();
    }

    public void Show(){
        meshRenderer.enabled = true;
    }

    public void Hide(){
        meshRenderer.enabled = false;
    }
}
 