using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraCorrida : MonoBehaviour {

	public Transform player;
	public float fator;

	void LateUpdate () {
		Quaternion rotationPlayer = player.rotation;
		Quaternion rotation_delay = Quaternion.Lerp (rotationPlayer, player.rotation, fator);

		if (rotationPlayer.eulerAngles.y != rotation_delay.eulerAngles.y) {
			Vector3 rotation_temp;
			rotation_temp = Vector3.Lerp ((player.rotation.eulerAngles), new Vector3 ((player.rotation.eulerAngles.x), player.rotation.eulerAngles.y, (rotationPlayer.eulerAngles.y - rotation_delay.eulerAngles.y)), fator);


			// player.rotation.eulerAngles = rotation_temp;


		}
		Vector3 nova_rotation = new Vector3 (player.rotation.eulerAngles.x, player.rotation.eulerAngles.y, 0);
		//player.rotation.eulerAngles = Vector3.Lerp ((player.rotation.eulerAngles), nova_rotation, fator);

	}
}