using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[ExecuteInEditMode]
public class waypoint : MonoBehaviour {

	public List<Transform> waypoints = new List<Transform> ();
	int index = 0;
	public bool disableInGame;
	// Update is called once per frame
	void Update () {
		if (disableInGame) {
			Transform[] tem = GetComponentsInChildren<Transform> ();
			index = 0;
			if (tem.Length > 0) {
				waypoints.Clear ();
				foreach (Transform t in tem) {
					if (t != transform) {
					
						t.name = "Way" + index.ToString ();
						waypoints.Add (t);
						index++;
					}
				}
			}
		}
	}


	void OnDrawGizmos(){
		
		Gizmos.color = Color.green;

		if (waypoints.Count > 0) {
			foreach (Transform t in waypoints)
				Gizmos.DrawSphere (t.position, 1f);
		

			Gizmos.color = Color.red;
			for (int a = 0; a <( waypoints.Count - 1); a++) {
				Gizmos.DrawLine (waypoints [a].position, waypoints [a + 1].position);
			}
		
		}
	}
}
