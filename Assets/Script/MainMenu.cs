using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class MainMenu : MonoBehaviour
{
    public GameObject settingsM, mainM;

    public void GoMain()
    {
       settingsM.SetActive(false);
      mainM.SetActive(true);
    }

    public void GoSettings()
    {
       settingsM.SetActive(true);
        mainM.SetActive(false);
    }
}