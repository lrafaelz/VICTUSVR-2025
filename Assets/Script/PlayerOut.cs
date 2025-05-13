using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerOut : MonoBehaviour
{
  public ControlOfIn control;

  [HideInInspector] public Animator animator;

  private void Start()
  {
    animator = GetComponent<Animator>();
  }

  void Update()
  {
    if (control.wait)
    {
      transform.position = control.target.position;
      transform.rotation = control.target.rotation;
    }
    animator.SetBool("In", control.wait);
  }
}
