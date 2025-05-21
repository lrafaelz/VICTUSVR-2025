using System.Collections;
using UnityEngine;
using Firebase;
using Firebase.Auth;
using TMPro;
using System.Threading.Tasks;
using UnityEngine.SceneManagement;
using System;

public class AuthManager : MonoBehaviour
{
  //Firebase variables
  [Header("Firebase")]
  public DependencyStatus dependencyStatus;
  public FirebaseAuth auth;
  public FirebaseUser User;
  private bool firebaseInitialized = false;

  //Login variables
  [Header("Login")]
  public TMP_InputField emailLoginField;
  public TMP_InputField passwordLoginField;
  public TMP_Text warningLoginText;
  public TMP_Text confirmLoginText;

  [Header("Select Patient")]

  public TMP_InputField patientNameInputField;

  public TMP_Text warningSelectPatientText;

  [Header("UI References")]
  public GameObject loginUI;
  public GameObject selectPatientUI;

  public GameObject StartGameButton;


  void Awake()
  {
    Debug.Log("[AuthManager] Awake chamado - Unity Thread ID: " + System.Threading.Thread.CurrentThread.ManagedThreadId);
    // Garante que apenas um AuthManager existe
    if (FindObjectsOfType<AuthManager>().Length > 1)
    {
      Destroy(gameObject);
      return;
    }

    InitializeFirebaseWithCheck();
  }

  private async void InitializeFirebaseWithCheck()
  {
    try
    {
      // Check que todas as dependências necessárias do Firebase estão no sistema
      Debug.Log("[AuthManager] Verificando dependências do Firebase...");
      DependencyStatus result = await FirebaseApp.CheckAndFixDependenciesAsync();

      // Este callback é executado na thread principal
      UnityMainThreadDispatcher.Instance().EnqueueAsync(() =>
      {
        Debug.Log("[AuthManager] Callback do CheckAndFixDependenciesAsync na thread: " + System.Threading.Thread.CurrentThread.ManagedThreadId);
        if (result == DependencyStatus.Available)
        {
          Debug.Log("[AuthManager] Firebase dependencies available");
          InitializeFirebase();
          firebaseInitialized = true;
        }
        else
        {
          Debug.LogError("[AuthManager] Could not resolve all Firebase dependencies: " + result);
        }
      }).ConfigureAwait(false);
    }
    catch (Exception ex)
    {
      Debug.LogError("[AuthManager] Error in InitializeFirebaseWithCheck: " + ex.Message);
    }
  }

  private void InitializeFirebase()
  {
    try
    {
      Debug.Log("[AuthManager] Setting up Firebase Auth");
      auth = FirebaseAuth.DefaultInstance;
      Debug.Log("[AuthManager] Firebase Auth initialized successfully");
    }
    catch (Exception ex)
    {
      Debug.LogError("[AuthManager] Error initializing Firebase Auth: " + ex.Message);
    }
  }

  //Function for the login button
  public void LoginButton()
  {
    if (!firebaseInitialized)
    {
      Debug.LogError("[AuthManager] Firebase não inicializado! Tentando inicializar novamente...");
      InitializeFirebaseWithCheck();
      return;
    }

    //Call the login coroutine passing the email and password
    StartCoroutine(Login(emailLoginField.text, passwordLoginField.text));
  }

  public void SelectPatientButton()
  {
    Debug.Log($"SelectPatientButton: {patientNameInputField.text}");
    StartCoroutine(SelectPatient(patientNameInputField.text));
  }

  private IEnumerator Login(string _email, string _password)
  {
    Debug.Log("[AuthManager] Iniciando login...");
    //Call the Firebase auth signin function passing the email and password
    Task<AuthResult> LoginTask = auth.SignInWithEmailAndPasswordAsync(_email, _password);
    //Wait until the task completes
    yield return new WaitUntil(predicate: () => LoginTask.IsCompleted);

    if (LoginTask.Exception != null)
    {
      //If there are errors handle them
      Debug.LogWarning(message: $"Failed to register task with {LoginTask.Exception}");
      FirebaseException firebaseEx = LoginTask.Exception.GetBaseException() as FirebaseException;
      AuthError errorCode = (AuthError)firebaseEx.ErrorCode;

      string message = "Login Failed!";
      switch (errorCode)
      {
        case AuthError.MissingEmail:
          message = "Missing Email";
          break;
        case AuthError.MissingPassword:
          message = "Missing Password";
          break;
        case AuthError.WrongPassword:
          message = "Wrong Password";
          break;
        case AuthError.InvalidEmail:
          message = "Invalid Email";
          break;
        case AuthError.UserNotFound:
          message = "Account does not exist";
          break;
      }
      warningLoginText.text = message;
    }
    else
    {
      //User is now logged in
      //Now get the result
      User = LoginTask.Result.User;
      Debug.LogFormat("[AuthManager] User signed in successfully: {0} ({1})", User.DisplayName, User.Email);
      warningLoginText.text = "";
      confirmLoginText.text = "Logged In";

      // Inicialize o Firestore aqui!
      try
      {
        Debug.Log("[AuthManager] Inicializando Firestore após login bem-sucedido...");
        DatabaseManager.Instance.InitializeFirestore();
        Debug.Log("[AuthManager] Firestore inicializado após login!");
      }
      catch (Exception ex)
      {
        Debug.LogError("[AuthManager] Erro ao inicializar Firestore: " + ex.Message);
        warningLoginText.text = "Erro ao conectar ao banco de dados. Tente novamente.";
        yield break; // Interrompe a coroutine em caso de erro
      }

      // Espere um momento para garantir que a inicialização seja concluída
      yield return new WaitForSeconds(0.5f);

      // Switch to select patient
      loginUI.SetActive(false);
      selectPatientUI.SetActive(true);
    }
  }

  private IEnumerator SelectPatient(string _patientName)
  {
    Debug.Log("[AuthManager] SelectPatient, _patientName: " + _patientName);
    if (_patientName == "")
    {
      warningSelectPatientText.text = "Preencha o nome do paciente";
    }
    else
    {
      warningSelectPatientText.text = "";
      yield return new WaitForSeconds(1f);
      SceneManager.LoadScene("MainMenu");
    }
  }
}