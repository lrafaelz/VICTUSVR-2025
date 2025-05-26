
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class GerenciadordoGame : MonoBehaviour
{


  public static int[] historicoProg;
  public static float tempoSessao;

  public GameObject novaSessao;
  public GameObject buttons;

  public GameObject menu;

  public static GerenciadordoGame instancia;

  // IEnumerator Start()
  // {
  //   // yield return new WaitForSeconds(5);
  //   // SceneManager.LoadScene("Login", LoadSceneMode.Single);
  // }
  public static void FinalizarJogo()
  {

  }

  public static void Começar()
  {
    //quando o botão iniciar é pressionado
    //instancia novos botões com a fase e tempo de sessão
    Instantiate(instancia.novaSessao, instancia.buttons.transform.position, instancia.buttons.transform.rotation);
  }

  public void Sair()
  {
    //Application.Quit;
  }

  public void Sessao()
  {
    //dá início a sessão com o tempo estabelecido e com o level estabelecido

  }

  public void LoginSuccess()
  {
    SceneManager.LoadScene("MainMenu", LoadSceneMode.Single);
  }

  public void Pista1()
  {
    SceneManager.LoadScene("PISTA 1", LoadSceneMode.Single);
  }

  public void Pista2()
  {
    SceneManager.LoadScene("PISTA 2", LoadSceneMode.Single);
  }

  public void Pista3()
  {
    SceneManager.LoadScene("PISTA 3", LoadSceneMode.Single);
  }

}
