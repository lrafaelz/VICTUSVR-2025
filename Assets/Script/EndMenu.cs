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
        SceneManager.LoadScene("PISTA 1");
    }

    public void ShowHighscore()
    {
        highscorePanel.SetActive(true);
        endmenu.SetActive(false); // Esconde o menu principal
        Debug.Log("foi");  
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