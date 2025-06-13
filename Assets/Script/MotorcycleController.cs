// //********************** © KD-Studios 2023 ***************************\\
// //************* Desenvolvido Por: Atílio De Jesus *********************\\
// //******************* Bike System versão 0.1v **************************\\

using UnityEngine;
using System.Collections;
using System.Collections.Generic;
using UnityEditor;

namespace BikeSystem.controller
{
  public class MotorcycleController : MonoBehaviour
  {
    public int useSerial;
    public type TypeOfBike;
    public Transform SteerTransform;
    public WheelCollider frontWheel;
    public WheelCollider rearWheel;
    public Transform t_wheelR;
    public Transform t_wheelF;
    public float movementForce = 1000;
    public float steeringForce = 20;
    public float maxInclinationSet = 0.5f;
    public float ActualVelocity;
    [SerializeField] private Controle serial;

    [HideInInspector] public Rigidbody rigidbody;

    float maxInclination;
    float limitBike = 30;
    bool useLimit;
    public bool haveADriver;
    [HideInInspector] public AudioSource audio;
    public enum type
    {
      Motorcycle,
      Bike
    }

    private void Awake()
    {
      useSerial = PlayerPrefs.GetInt("WASD");
      Debug.Log("useSerial: " + useSerial);
      audio = GetComponent<AudioSource>();
      rigidbody = GetComponent<Rigidbody>();
      rigidbody.constraints = RigidbodyConstraints.FreezeRotationZ;

      // Ensure serial reference is set
      if (serial == null)
      {
        serial = FindObjectOfType<Controle>();
        if (serial == null)
        {
          Debug.LogError("Controle component not found in scene!");
        }
      }
    }

    private void Start()
    {
      if (TypeOfBike == type.Bike)
      {
        useLimit = true;
      }
      else
      {
        useLimit = false;
      }
      StartCoroutine("SetGame");
    }

    IEnumerator SetGame()
    {
      yield return new WaitForSeconds(0.5f);
    }

    void Update()
    {
      UpdatePos(frontWheel, t_wheelF);
      UpdatePos(rearWheel, t_wheelR);
      Tensor();
    }

    private void FixedUpdate()
    {
      if (useSerial == 0)
      {
        SteerBase();
        AccelBase();
        Debug.Log($"[MOTORCYCLE] Modo WASD - Velocidade: {ActualVelocity:F1} km/h");
      }
      else
      {
        this.limitBike = serial.getVelocidade() + 3;
        SteerSerial();
        AccelSerial();

      }

      LerpSteerDecrementalL();
      LerpSteerDecrementalR();
      LerpSteerIncrementalL();
      LerpSteerIncrementalR();
      //   if (serial != null)
      //   {
      //     bool isConnected = serial.IsSerialConnected();
      //     float velocidade = serial.getVelocidade();
      //     int direcao = serial.getDirecao();
      //     string bpm = serial.GetBPM();
      //     string emg = serial.GetEMG();

      //     // Log detailed info every 5 seconds to avoid spam
      //     if (Time.fixedTime % 5 < 0.02f)
      //     {
      //       Debug.Log($"[MOTORCYCLE] Vel:{velocidade:F1} Dir:{direcao} BPM:{bpm} EMG:{emg}");
      //     }

      //     // Apply steering with mapping
      //     float mappedDirection = Map(direcao, 0, 255, -1, 1);
      //     frontWheel.steerAngle = mappedDirection * steeringForce;

      //     // Apply acceleration based on velocity from serial
      //     if (velocidade > 0)
      //     {
      //       if (useLimit && velocidade < limitBike)
      //       {
      //         rearWheel.motorTorque = velocidade * movementForce;
      //         rearWheel.brakeTorque = 0;
      //         if (Time.fixedTime % 2 < 0.02f)
      //           Debug.Log($"[MOTORCYCLE] ✅ Acelerando com limite - Vel:{velocidade} Torque: {rearWheel.motorTorque:F0}");
      //       }
      //       else if (!useLimit)
      //       {
      //         rearWheel.motorTorque = velocidade * movementForce;
      //         rearWheel.brakeTorque = 0;
      //         if (Time.fixedTime % 2 < 0.02f)
      //           Debug.Log($"[MOTORCYCLE] ✅ Acelerando sem limite - Vel:{velocidade} Torque: {rearWheel.motorTorque:F0}");
      //       }
      //       else
      //       {
      //         rearWheel.motorTorque = 0;
      //         if (Time.fixedTime % 2 < 0.02f)
      //           Debug.Log($"[MOTORCYCLE] ⚠️ Velocidade no limite - Vel:{velocidade} >= {limitBike}");
      //       }
      //     }
      //     else
      //     {
      //       rearWheel.motorTorque = 0;
      //       rearWheel.brakeTorque = 100; // Light braking when no velocity
      //       if (Time.fixedTime % 2 < 0.02f)
      //         Debug.Log($"[MOTORCYCLE] 🛑 Velocidade zero - Freando");
      //     }

      //     // Update smooth steering based on mapped direction
      //     if (mappedDirection > 0.1f && ActualVelocity >= 5)
      //     {
      //       if (smoothSteerR < 1)
      //       {
      //         smoothSteerR = smoothSteerR + 0.02f;
      //       }
      //       else
      //       {
      //         smoothSteerR = 1;
      //       }
      //       Debug.Log($"[MOTORCYCLE] Virando direita - smoothSteerR: {smoothSteerR:F3}");
      //     }
      //     else if (mappedDirection < -0.1f && ActualVelocity >= 5)
      //     {
      //       if (smoothSteerL < 1)
      //       {
      //         smoothSteerL = smoothSteerL + 0.02f;
      //       }
      //       else
      //       {
      //         smoothSteerL = 1;
      //       }
      //       Debug.Log($"[MOTORCYCLE] Virando esquerda - smoothSteerL: {smoothSteerL:F3}");
      //     }
      //     else
      //     {
      //       // Decrease steering smoothly when no input
      //       if (smoothSteerR > 0.01f)
      //       {
      //         smoothSteerR = smoothSteerR - 0.01f;
      //       }
      //       else
      //       {
      //         smoothSteerR = 0;
      //       }

      //       if (smoothSteerL > 0.01f)
      //       {
      //         smoothSteerL = smoothSteerL - 0.01f;
      //       }
      //       else
      //       {
      //         smoothSteerL = 0;
      //       }
      //       Debug.Log($"[MOTORCYCLE] Centro - R:{smoothSteerR:F3} L:{smoothSteerL:F3}");
      //     }
      //   }
      //   else
      //   {
      //     Debug.LogWarning("[MOTORCYCLE] Serial controller not found!");
      //     rearWheel.motorTorque = 0;
      //     rearWheel.brakeTorque = 100;
      //   }
      // }

      // // Apply the smoothing functions for keyboard input when not using serial
      // if (useSerial == 0)
      // {
      //   LerpSteerDecrementalR();
      //   LerpSteerDecrementalL();
      //   LerpSteerIncrementalR();
      //   LerpSteerIncrementalL();
      // }

      // // Update visual elements
      // SteerTransform.localEulerAngles = new Vector3(
      //   SteerTransform.localEulerAngles.x,
      //   steeringForce * (smoothSteerR - smoothSteerL),
      //   SteerTransform.localEulerAngles.z
      // );

      // if (!hit)
      // {
      //   transform.localEulerAngles = new Vector3(
      //     transform.localEulerAngles.x,
      //     transform.localEulerAngles.y,
      //     maxInclination * (smoothSteerR - smoothSteerL)
      //   );
      // }

      // ActualVelocity = (rigidbody.linearVelocity.magnitude * 3.6f); // Convert to km/h
      // rigidbody.solverIterations = 100;

      // // Log velocidade atual periodicamente
      // if (Time.fixedTime % 2 < 0.02f) // A cada 2 segundos aproximadamente
      // {
      //   Debug.Log($"[MOTORCYCLE] Velocidade Atual: {ActualVelocity:F1} km/h | Modo: {(useSerial == 0 ? "WASD" : "SERIAL")}");
      // }
    }

    void UpdatePos(WheelCollider wheel, Transform wheelTrans)
    {
      Vector3 pos;
      Quaternion quaternion;
      wheel.GetWorldPose(out pos, out quaternion);
      wheelTrans.position = pos;
      wheelTrans.rotation = quaternion;
    }

    //Função que controla o movimento da moto/bike
    private void AccelBase()
    {
      float InputAccel = Input.GetAxis("Vertical"); // Obtém a entrada vertical do teclado para acelerar ou frear
      // float InputAccel = serial.velocidade > 0 ? 1 : -1; // (Comentado) Se a velocidade recebida da serial for maior que 0, InputAccel será 1; caso contrário, será -1.

      if (InputAccel <= -0.2f) // Se a entrada vertical for menor ou igual a -0.2f (pressionando a tecla "S" ou indicando desaceleração pela serial)
      {
        rearWheel.motorTorque = InputAccel * (movementForce - (movementForce / 4)); // Aplica um torque de motor para frear gradualmente a roda traseira
      }
      else // Caso contrário
      {
        if (useLimit) // Se o uso de limite estiver ativado (useLimit é verdadeiro)
        {
          if (ActualVelocity < limitBike) // Se a velocidade atual for menor que o limite configurado (limitBike)
          {
            rearWheel.motorTorque = InputAccel * movementForce; // Aplica um torque de motor para acelerar a roda traseira
          }
          else // Caso contrário (velocidade atual é maior ou igual ao limite)
          {
            rearWheel.motorTorque = 0; // Define o torque de motor como zero para manter a velocidade constante (bicicleta não acelera além do limite)
          }
        }
        else // Se o uso de limite não estiver ativado (useLimit é falso)
        {
          rearWheel.motorTorque = InputAccel * movementForce; // Aplica um torque de motor para acelerar a roda traseira sem restrições de limite
        }
      }
      ActualVelocity = (rigidbody.linearVelocity.magnitude / 5) * 15; // Calcula a velocidade atual da bicicleta com base na magnitude da velocidade do Rigidbody

      if (InputAccel == 0 || (rearWheel.rpm > 5 && InputAccel <= -0.2f)) // Se a entrada vertical for igual a zero ou (a rotação da roda traseira for maior que 5 e a entrada vertical for menor ou igual a -0.2f)
      {
        rearWheel.brakeTorque = 25; // Aplica um torque de frenagem na roda traseira para desacelerar ou parar a bicicleta
      }
      else
      {
        rearWheel.brakeTorque = 0; // Define o torque de frenagem como zero para liberar a roda traseira e permitir aceleração
      }
    }
    // Função que controla a bike por meio da entrada serial
    private void AccelSerial()
    {
      // ActualVelocity = serial.getVelocidade(); // Mantém a entrada vertical do teclado para acelerar ou frear
      if (ActualVelocity == 0)
      {
        rearWheel.motorTorque = 100;
        rearWheel.brakeTorque = 0; // Aplica um torque de frenagem na roda traseira para desacelerar ou parar a bicicleta

      }
      else
      {
        rearWheel.brakeTorque = 0;
        if (useLimit)
        {
          if (ActualVelocity < limitBike)
          { // Se a velocidade atual for menor que o limite configurado (limitBike)
            rearWheel.motorTorque = 1 * movementForce; // Aplica um torque de motor para acelerar a roda traseira
          }
          else
          {// Caso contrário (velocidade atual é maior ou igual ao limite)
            rearWheel.motorTorque = 0; // Define o torque de motor como zero para manter a velocidade constante (bicicleta não acelera além do limite)
            // rearWheel.brakeTorque = 100; // Aplica um torque de frenagem na roda traseira para desacelerar ou parar a bicicleta
          }
          if (limitBike == 0)
          {
            rearWheel.brakeTorque = 300;
          }
        }
        else
        {
          rearWheel.motorTorque = 1 * movementForce; // Aplica um torque de motor para acelerar a roda traseira sem restrições de limite
        }
      }
      ActualVelocity = (rigidbody.linearVelocity.magnitude / 5) * 15; // Calcula a velocidade atual da bicicleta com base na magnitude da velocidade do Rigidbody
      int ActualVelocityInt = (int)ActualVelocity;
      serial.displayVelocidade.text = ActualVelocityInt.ToString();
    }

    float valueToFix = 0;
    [HideInInspector] public float smoothSteerR;
    [HideInInspector] public float smoothSteerL;

    [HideInInspector] public bool hit;


    private void SteerBase()
    {
      float InputSteer = Input.GetAxis("Horizontal");
      float InputAccel = Input.GetAxis("Vertical");
      frontWheel.steerAngle = InputSteer * steeringForce;

      SteerTransform.localEulerAngles = new Vector3(SteerTransform.localEulerAngles.x, steeringForce * (smoothSteerR - smoothSteerL), SteerTransform.localEulerAngles.z);

      if (hit)
      {
        transform.localEulerAngles = new Vector3(transform.localEulerAngles.x, transform.localEulerAngles.y, transform.localEulerAngles.z);
      }
      else
      {
        transform.localEulerAngles = new Vector3(transform.localEulerAngles.x, transform.localEulerAngles.y, maxInclination * (smoothSteerR - smoothSteerL));
      }
      rigidbody.solverIterations = 100;
      rigidbody.solverIterations = 100;
    }

    //Função que controla a direção da moto/bike
    private void SteerSerial()
    {
      float direcao = serial.getDirecao();
      Debug.Log($"Direção recebida: {direcao}");
      float InputSteer = Map(direcao, 0, 255, -1, 1);
      if (direcao >= 116 && direcao <= 122)
      {
        InputSteer = 0;
      }
      Debug.Log($"Direção mapeada: {InputSteer}");

      frontWheel.steerAngle = InputSteer * steeringForce;
      Debug.Log($"Ângulo da roda: {frontWheel.steerAngle}");

      SteerTransform.localEulerAngles = new Vector3(SteerTransform.localEulerAngles.x, steeringForce * (smoothSteerR - smoothSteerL), SteerTransform.localEulerAngles.z);

      if (hit)
      {
        transform.localEulerAngles = new Vector3(transform.localEulerAngles.x, transform.localEulerAngles.y, transform.localEulerAngles.z);
      }
      else
      {
        transform.localEulerAngles = new Vector3(transform.localEulerAngles.x, transform.localEulerAngles.y, maxInclination * (smoothSteerR - smoothSteerL));
      }
      rigidbody.solverIterations = 100;
    }

    //Suavizadores do movimento da moto/bike
    private void LerpSteerDecrementalR()
    {
      if (Input.GetAxis("Horizontal") == 0 || Input.GetAxis("Horizontal") < 0)
      {
        if (smoothSteerR > 0.01f)
        {
          smoothSteerR = smoothSteerR - 0.01f;
        }
        else if (smoothSteerR <= 0.01f)
        {
          smoothSteerR = 0;
        }
      }
    }


    private void LerpSteerDecrementalL()
    {
      if (Input.GetAxis("Horizontal") == 0 || Input.GetAxis("Horizontal") > 0)
      {
        if (smoothSteerL > 0.01f)
        {
          smoothSteerL = smoothSteerL - 0.01f;
        }
        else if (smoothSteerL <= 0.01f)
        {
          smoothSteerL = 0;
        }
      }
    }

    void LerpSteerIncrementalR()
    {
      if (Input.GetAxis("Horizontal") > 0 && ActualVelocity >= 5)
      {
        if (smoothSteerR < 1)
        {
          smoothSteerR = smoothSteerR + 0.02f;
        }
        else if (smoothSteerR >= 1f)
        {
          smoothSteerR = 1;
        }
      }
    }
    void LerpSteerIncrementalL()
    {
      if (Input.GetAxis("Horizontal") < 0 & ActualVelocity >= 5)
      {
        if (smoothSteerL < 1)
        {
          smoothSteerL = smoothSteerL + 0.1f;
        }
        else if (smoothSteerL >= 1f)
        {
          smoothSteerL = 1;
        }
      }
    }


    //Função que controla situações de acidente da moto/bike
    private void OnCollisionEnter()
    {
      if ((transform.rotation.x > 90 || transform.rotation.x < -90))
      {
        hit = true;
        rigidbody.constraints = RigidbodyConstraints.None;
      }
    }

    //Função que faz o Reset da moto/bike
    void RestBike()
    {
      transform.rotation = Quaternion.identity;
      hit = false;
      rigidbody.constraints = RigidbodyConstraints.FreezeRotationZ;

      if (haveADriver)
      {
        RagdollDriver.DestroRagdoll();
      }
    }


    private void OnGUI()
    {
      if (GUILayout.Button("Reset The Bike"))
      {
        RestBike();
      }
    }

    //Medidor de estabilidade
    void Tensor()
    {
      /* if (transform.localRotation.y > 100 || transform.localRotation.y < -100)
       {
         maxInclination = maxInclinationSet;
       }
       else*/
      {
        maxInclination = -maxInclinationSet;
      }
    }




    float Map(float value, float inMin, float inMax, float outMin, float outMax)
    {
      return (value - inMin) * (outMax - outMin) / (inMax - inMin) + outMin;
    }
  }

}
