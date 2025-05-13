using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class spawnObstacle : MonoBehaviour
{
    public GameObject barreira;
    private Renderer barrierRenderer;
    private Collider barrierCollider;
    private bool isBarrierActive = true;


    private void Start(){
        for (int i = 0; i < transform.childCount; i++){
            if ( i % 2 != 0){
                Transform child = transform.GetChild(i);
                int childCount = child.childCount;
                if (childCount != 1){
                    int r = Random.Range(0, 5);
                    Transform grandChild = child.GetChild(r);
                    barreira = Instantiate(barreira, grandChild.position, grandChild.rotation)  as GameObject;
                    barreira.transform.SetParent(this.transform);
                    bool twoBarrier = Random.Range(0, 2) == 1;
                    if (twoBarrier == true){
                        int r2 = Random.Range(0, 5);
                        while(r2 == r){
                            r2 = Random.Range(0, 5);
                        }
                    grandChild = child.GetChild(r2);
                    barreira = Instantiate(barreira, grandChild.position, grandChild.rotation);
                    barreira.transform.SetParent(this.transform);
                    }
                }
            }
            
            // barreira = Instantiate(barreira, transform.GetChild(i).position, transform.GetChild(i)rotation);
            // isBarrierActive = !isBarrierActive;
            // barrierRenderer.enabled = isBarrierActive;
            // barrierCollider.enabled = isBarrierActive; // Toggle collider along with visibility
        }
    }

    private void Update()
    {
        if (Input.GetKeyDown(KeyCode.Space)){ // Change the input condition as needed
            int i = Random.Range(0, 5);
            barreira.transform.position = transform.GetChild(i).position;
        }
    }
}