// //********************** © KD-Studios 2023 ***************************\\
// //************* Desenvolvido Por: Atílio De Jesus *********************\\
// //******************* Bike System versão 0.1v **************************\\

using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using BikeSystem.controller;

namespace BikeSystem
{
  public class DriverScript : MonoBehaviour
  {
    public MotorcycleController system;
    public GameObject set;
    public GameObject ragdoll;


    void Update()
    {
      DriverController();
    }
    bool cancel;

    //Função que controla o condutor da moto
    private void DriverController()
    {
      set.gameObject.SetActive(!system.hit);
      transform.localEulerAngles = new Vector3(transform.localEulerAngles.x, (system.steeringForce / 2.5f) * (system.smoothSteerR - system.smoothSteerL), transform.localEulerAngles.z);

      if (system.hit && !cancel)
      {
        Instantiate(ragdoll, transform.position, transform.rotation);
        cancel = true;
      }
      else if (!system.hit)
      {
        cancel = false;
      }
    }
  }
}