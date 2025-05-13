using System.Collections;
using System.Collections.Generic;
using UnityEngine;


public class barreiraCollision : MonoBehaviour{
    
    private GameObject Player;
    private GameObject controle;
    private Controle controleScript;
    public int barreiraValue = 100;

    private void Awake(){   
        Player = GameObject.Find("BMXBike");
        controle = GameObject.Find("GUIPartida");
        // Debug.Log("Player: " + Player.name);
    }
    private void OnCollisionEnter(Collision collision){
        if(collision.gameObject == Player){
            // Debug.Log("Collision with: " + collision.gameObject.name);
            Destroy(gameObject);
            controleScript = controle.GetComponent<Controle>();
            controleScript.barreiraScore = controleScript.barreiraScore + this.barreiraValue;
            print("Score: " + controleScript.barreiraScore);
        }
    }
    // IEnumerator wait(float sec){
    //     yield return new WaitForSeconds(sec);
    //     SetCollidersActive(false);
    // }

}