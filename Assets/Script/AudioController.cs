using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AudioController : MonoBehaviour
{
  float pitch;
  AudioSource audio;
  float velocity;
  float[] velocitiesBox = { 45, 80, 120, 170 };
  Rigidbody rb;
  int index = 1;
  private void Start()
  {
    rb = GetComponent<Rigidbody>();
    audio = GetComponent<AudioSource>();
    pitch = 0.2f;
  }
  void Update()
  {
    AudioControllerBase();
  }

  private void AudioControllerBase()
  {
    audio.pitch = pitch;
    velocity = rb.linearVelocity.magnitude * 3.6f;
    float velocityCheck = (rb.linearVelocity.magnitude / 5) * 15;
    transmissionController(velocityCheck);
    pitch = 0.2f + velocity / (60 * index);
  }

  private void transmissionController(float velocityCheck)
  {
    if (velocityCheck < velocitiesBox[0])
    {
      index = 1;
    }
    else if (velocityCheck < velocitiesBox[1] && velocityCheck > velocitiesBox[0])
    {
      index = 2;
    }
    else if (velocityCheck < velocitiesBox[2] && velocityCheck > velocitiesBox[1])
    {
      index = 3;
    }
    else if (velocityCheck < velocitiesBox[3] && velocityCheck > velocitiesBox[2])
    {
      index = 4;
    }
  }
}
