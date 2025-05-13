using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerCam : MonoBehaviour
{
  [Header("Player & Bike: Sendo Player o 1° Item a Moto o 2°")]
  public Transform[] target;

  public ControlOfIn control;
  int index;
  void Update()
  {
    if (control.inVehicle)
    {
      index = 1;
    }
    else if (!control.inVehicle)
    {
      index = 0;
    }
    transform.position = target[index].position;
    transform.localEulerAngles = new Vector3(transform.localEulerAngles.x, target[index].localEulerAngles.y, transform.localEulerAngles.z);
  }
}
