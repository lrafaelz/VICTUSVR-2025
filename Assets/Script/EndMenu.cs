using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class EndMenu : MonoBehaviour
{
  public GameObject highscorePanel, endmenu;

  public void PlayAgain()
  {
    SceneManager.LoadScene(UnityEngine.SceneManagement.SceneManager.GetActiveScene().name);
  }
  public void ShowHighscore()
  {
    highscorePanel.SetActive(true);
    endmenu.SetActive(false);
  }

  public void LoadMainMenu()
  {
    SceneManager.LoadScene("MainMenu");
  }

  public void ReturnendMenu()
  {
    highscorePanel.SetActive(false);
    endmenu.SetActive(true);
  }
}