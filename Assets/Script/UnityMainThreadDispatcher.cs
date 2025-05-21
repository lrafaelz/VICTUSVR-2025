using UnityEngine;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Threading.Tasks;

public class UnityMainThreadDispatcher : MonoBehaviour
{
  private static UnityMainThreadDispatcher instance;
  private readonly Queue<Action> executionQueue = new Queue<Action>();

  public static UnityMainThreadDispatcher Instance()
  {
    if (instance == null)
    {
      instance = FindObjectOfType<UnityMainThreadDispatcher>();
      if (instance == null)
      {
        var go = new GameObject("UnityMainThreadDispatcher");
        instance = go.AddComponent<UnityMainThreadDispatcher>();
        DontDestroyOnLoad(go);
      }
    }
    return instance;
  }

  void Awake()
  {
    if (instance == null)
    {
      instance = this;
      DontDestroyOnLoad(gameObject);
    }
  }

  void Update()
  {
    lock (executionQueue)
    {
      while (executionQueue.Count > 0)
      {
        executionQueue.Dequeue().Invoke();
      }
    }
  }

  public async Task EnqueueAsync(Action action)
  {
    var tcs = new TaskCompletionSource<bool>();

    lock (executionQueue)
    {
      executionQueue.Enqueue(() =>
      {
        try
        {
          action();
          tcs.SetResult(true);
        }
        catch (Exception ex)
        {
          tcs.SetException(ex);
        }
      });
    }

    await tcs.Task;
  }
}