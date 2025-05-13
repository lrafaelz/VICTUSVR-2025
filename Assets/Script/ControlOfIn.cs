using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Events;
public class ControlOfIn : MonoBehaviour
{
  public UnityEvent toActive;
  public UnityEvent toDesative;
  public GameObject player;
  public Transform target;
  public bool inTrigger;

  public bool wait;
  public bool wait1;
  [HideInInspector] public bool inVehicle;
  void Update()
  {
    if (inTrigger)
    {
      if (Input.GetKey("f") && !inVehicle && !wait)
      {
        StartCoroutine("LetIn");
        wait = true;
      }
    }
    if (Input.GetKey("g") && inVehicle && !wait1)
    {
      StartCoroutine("LetOut");
    }
  }

  IEnumerator LetIn()
  {
    yield return new WaitForSeconds(1.5f);
    toActive.Invoke();
    inVehicle = true;
    inTrigger = false;
    yield return new WaitForSeconds(0.01f);
    wait = false;
  }
  IEnumerator LetOut()
  {
    yield return new WaitForSeconds(1.5f);
    toDesative.Invoke();
    player.transform.position = target.position;
    inVehicle = false;
    yield return new WaitForSeconds(0.01f);
    wait1 = false;
  }

  private void OnTriggerEnter(Collider other)
  {
    if (other.gameObject.tag == "Player")
    {
      inTrigger = true;
    }
  }
  private void OnTriggerExit(Collider other)
  {
    inTrigger = false;
  }
}
