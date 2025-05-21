using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;
using UnityEngine.SceneManagement;

public class ChangeUI : MonoBehaviour
{
  #region Singleton
  public static ChangeUI instance;
  void Awake()
  {
    if (instance == null)
    {
      instance = this;
    }
    else
    {
      Destroy(gameObject);
    }
  }
  #endregion

  public GameObject loginScreenPanel, gameStartPanel;
  public TMP_InputField field1, field2;
  public Button startButton;
  bool loginActive = true;

  public void ChangeBetweenLoginAndGameStart()
  {
    loginActive = !loginActive;
    loginScreenPanel.SetActive(loginActive);
    gameStartPanel.SetActive(!loginActive);
  }

  public void StartGame()
  {
    // Get values from the two fields
    string value1 = field1.text;
    string value2 = field2.text;

    // You can save these values or use them as needed
    PlayerPrefs.SetString("Field1Value", value1);
    PlayerPrefs.SetString("Field2Value", value2);

    // Load the game scene - replace "GameScene" with your actual game scene name
    SceneManager.LoadScene("PISTA 1");
  }
}
