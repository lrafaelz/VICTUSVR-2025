#pragma strict
var velocidade: float;

function Start () {

 velocidade=5;

}

function Update () {

	if (Input.GetKey("w")){
		transform.Translate(0,0,velocidade*Time.deltaTime);
	}

	if (Input.GetKey("s")){
		transform.Translate(0,0,-velocidade*Time.deltaTime);
	}

	if (Input.GetKey("a")){
		transform.Translate(-velocidade*Time.deltaTime,0,0);
	}

	if (Input.GetKey("d")){
		transform.Translate(velocidade*Time.deltaTime,0,0);
	}

}