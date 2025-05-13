// //********************** © KD-Studios 2023 ***************************\\
// //************* Desenvolvido Por: Atílio De Jesus *********************\\
// //******************* Bike System versão 0.1v **************************\\

using System.Collections;
using System.Collections.Generic;
using UnityEngine;

namespace BikeSystem
{
  public class RagdollDriver : MonoBehaviour
  {
    static Transform baseD;

    private void Update()
    {
      baseD = transform;
    }

    public static void DestroRagdoll()
    {
      Destroy(baseD.gameObject, 0.001f);
    }
  }
}
