using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using BikeSystem.controller;

public class PlayerInside : MonoBehaviour
{
  [HideInInspector] public Animator animator;
  public MotorcycleController controller;
  private void Start()
  {
    animator = GetComponent<Animator>();
  }

  bool idle;
  bool move;
  bool rearMove;

  void Update()
  {
    if (Input.GetAxis("Vertical") >= 1)
    {
      move = true;
      idle = false;
      rearMove = false;
    }
    else if ((Input.GetAxis("Vertical") <= 0.1f && Input.GetAxis("Vertical") >= -0.01f) && (controller.ActualVelocity <= 0.5f && controller.ActualVelocity >= -0.0011f))
    {
      move = false;
      idle = true;
      rearMove = false;
    }
    else if (Input.GetAxis("Vertical") < -0.1f && controller.rigidbody.linearVelocity.z < -0.1f && controller.ActualVelocity <= 10)
    {
      move = false;
      idle = false;
      rearMove = true;
    }

    animator.SetBool("Move", move);
    animator.SetBool("Idle", idle);
    animator.SetBool("Rear", rearMove);
  }
}
