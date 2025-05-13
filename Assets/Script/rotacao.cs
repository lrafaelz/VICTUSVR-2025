// CÓDIGO ANTIGO

using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class rotacao : MonoBehaviour {

	public float velocidade = 2f;
	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		transform.Rotate (new Vector3(0,velocidade,0));
	}
}
