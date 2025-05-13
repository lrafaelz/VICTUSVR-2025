// //********************** © KD-Studios 2023 ***************************\\
// //************* Desenvolvido Por: Atílio De Jesus *********************\\
// //******************* Bike System versão 0.1v **************************\\

using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using BikeSystem.controller;

namespace BikeSystem
{
  public class SelectControlle : MonoBehaviour
  {

    public MotorcycleController[] list;
    [HideInInspector] public int index;

    void Update()
    {
      SelectMethod();
    }

    private void SelectMethod()
    {
      for (int o = 0; o < list.Length; o++)
      {
        if (index == o)
        {
          list[index].enabled = true;
          list[index].audio.enabled = true;
        }
        else
        {
          list[o].enabled = false;
          list[o].audio.enabled = false;
        }
      }
    }

    public void Add(int value)
    {
      if (value == 1 && index + value < list.Length)
      {
        index = index + value;
      }
      if (value == -1 && index + value >= 0)
      {
        index = index + value;
      }
    }
  }
}