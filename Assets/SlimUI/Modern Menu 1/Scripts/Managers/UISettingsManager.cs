using UnityEngine;
using UnityEngine.SceneManagement;
using System.Collections;
using UnityEngine.UI;
using TMPro;

namespace SlimUI.ModernMenu
{
  public class UISettingsManager : MonoBehaviour
  {

    public enum Platform { Desktop, Mobile };
    public Platform platform;

    [Header("GAME SETTINGS")]
    public GameObject difficultynormaltext;
    public GameObject difficultynormaltextLINE;
    public GameObject difficultyhardcoretext;
    public GameObject difficultyhardcoretextLINE;
    // public GameObject

    // sliders
    public GameObject musicSlider;

    private float sliderValue = 0.0f;
    private float sliderValueXSensitivity = 0.0f;
    private float sliderValueYSensitivity = 0.0f;
    private float sliderValueSmoothing = 0.0f;

    public void Awake()
    {
      PlayerPrefs.SetInt("WASD", 1);
    }


    public void Start()
    {
      // Set default values if they don't exist
      if (!PlayerPrefs.HasKey("NormalDifficulty"))
      {
        PlayerPrefs.SetInt("NormalDifficulty", 1);
      }


      // check difficulty
      if (PlayerPrefs.GetInt("NormalDifficulty") == 1)
      {
        difficultynormaltextLINE.gameObject.SetActive(true);
        difficultyhardcoretextLINE.gameObject.SetActive(false);
      }
      else
      {
        difficultyhardcoretextLINE.gameObject.SetActive(true);
        difficultynormaltextLINE.gameObject.SetActive(false);
      }

      // check slider values
      musicSlider.GetComponent<Slider>().value = PlayerPrefs.GetFloat("MusicVolume");
    }

    public void Update()
    {
      //sliderValue = musicSlider.GetComponent<Slider>().value;
    }

    public void MusicSlider()
    {
      //PlayerPrefs.SetFloat("MusicVolume", sliderValue);
      PlayerPrefs.SetFloat("MusicVolume", musicSlider.GetComponent<Slider>().value);
    }

    public void NormalDifficulty()
    {
      difficultyhardcoretextLINE.gameObject.SetActive(false);
      difficultynormaltextLINE.gameObject.SetActive(true);
      PlayerPrefs.SetInt("NormalDifficulty", 1);
      PlayerPrefs.SetInt("HardCoreDifficulty", 0);
    }

    public void HardcoreDifficulty()
    {
      difficultyhardcoretextLINE.gameObject.SetActive(true);
      difficultynormaltextLINE.gameObject.SetActive(false);
      PlayerPrefs.SetInt("NormalDifficulty", 0);
      PlayerPrefs.SetInt("HardCoreDifficulty", 1);
    }

    public void setControls(int val)
    {
      Debug.Log("setControls: " + val);

      if (val == 0)
      {
        Debug.Log("Sensoriamento");
        PlayerPrefs.SetInt("WASD", 1);
      }
      if (val == 1)
      {
        Debug.Log("WASD");
        PlayerPrefs.SetInt("WASD", 0);
      }

      Debug.Log(PlayerPrefs.GetInt("WASD"));
    }

    public void Pista1()
    {
      SceneManager.LoadScene("PISTA 1", LoadSceneMode.Single);
    }

    public void Pista2()
    {
      SceneManager.LoadScene("PISTA 2", LoadSceneMode.Single);
    }
  }
}