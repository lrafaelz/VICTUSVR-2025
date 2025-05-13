using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Barreira : MonoBehaviour {

	public List<Transform> obstaculos = new List<Transform> ();
	public Text descObjetivo; //elemento da interface que descreve o objetivo
	public Text descDistancia;//UI distancia
	public Text descBPM;//calcular batimentos
	public int barreiras=0;// calcula quantas barreiras foram rompidas
	public int localObjetivo;// é o indice do local onde instanciar o objetivo
	public float tempoObjetivo;// conta 30 segundos pra calcular o objetivo
	public GameObject objetivo; //objeto com sinal de chegada e programado
	public GameObject objetivoAtual;
	public bool habilita_objetivo=true; //enquanto um objetivo não for cumprido nenhum outro é instanciado
	public float tempolimite; //tempo pra vencer o objetivo fazer contagem regressiva
	public int c_func; //coeficiente funcional setado no inicio da sessão
	public int bpm_max;//batimentos máximo calculados através da idade
	public int idade;
	public int barreiras_obj; //distancia pra calcular o objetivo
	public int[] media_bpm = new int[5]; // faz um get do texto bpm e faz a média pra gerar alerta e calcular objetivo
	public float[] rendimento = new float[3]; // histórico dos ultimos objetivos
	float rendimento_media; // média do rendimento
	public Text pontuacao; // soma pontos os segundo restantes * 10
	public int pontos;
	int i, j; // indices para os vetores
	int estrela;


	// Use this for initialization
	void Start () {
		tempoObjetivo = 0;// tempo zerado no início
		// descObjetivo.text = " ";
		i = 0;
		j = 0;
		pontos = 0;
		estrela = 0;
		barreiras_obj = 0;
		bpm_max = (int)(208 - 0.7 * 27); // @@@@@@@@@@@@@@ na verdade vezes a idade
	}
	
	// Update is called once per frame
	void Update () {
		tempoObjetivo += Time.deltaTime;//soma cada segundo
		if (tempoObjetivo > 30 && habilita_objetivo) {
			CalculaObjetivo ();//quando ultrapassa 30segundo chama a função de calcular o objetivo
			// descObjetivo.text="Novo Objetivo!";
			tempoObjetivo = -30;
			habilita_objetivo = false;
			tempolimite = 60;
		}
		// descDistancia.text = "Distância Percorrida:" + barreiras * 10 + "m";
		tempolimite-= Time.deltaTime;//contagem regressiva
		/* TRECHO Q N ENTENDI 
		if (media_bpm [j] != int.Parse (descBPM.text.ToString())) {
            Debug.Log(descBPM);
			if (j < 4) { 
				media_bpm [j] = int.Parse (descBPM.text.ToString());
				j++;
			} else {
				media_bpm [j] = int.Parse (descBPM.text.ToString());
				j = 0;
			}
		}
		// até aqui */
		if ( ((media_bpm[0]+media_bpm[1]+media_bpm[2]+media_bpm[3]+media_bpm[4]) /5) > bpm_max){
			Time.timeScale = 0;
			//@@@@@@@@@ instancia alerta para a partida
		}

	}



	void OnTriggerEnter (Collider col){// detecta colisão e soma como barreira rompida
		if (col.tag == "Barreira") {
			barreiras++;
			barreiras_obj++;
		} else if (col.tag == "Finish") {
			if (tempolimite > 0) {
				descObjetivo.text = "Objetivo Concluído!";
				habilita_objetivo = true;
				//*********** ATIVA SOM VITÓRIA
				rendimento [i] = tempolimite; // pega o tempo restante dele para calcular objetivos
				pontos = (int)(pontos + tempolimite * 10); // soma pontos
				pontuacao.text = pontos.ToString();//atribui texto da pontuação
				tempolimite = 0;
				estrela++;

				if (i > 2) {
					i = 0;
				} else {
					i++;
				}

				Destroy (objetivoAtual);
			} else {
				descObjetivo.text = "Objetivo Falhou";
				habilita_objetivo = true;
				estrela--;
				// @@@@@@@@@@@ ativa som derrota
			}
		}
	}

	public void CalculaObjetivo(){
        double mediaBPM = (media_bpm[0] + media_bpm[1] + media_bpm[2] + media_bpm[3] + media_bpm[4])/5;
        int localObjetivo = (int)(barreiras_obj *2 +((rendimento[0]+rendimento[1]+rendimento[2])/15)+ (bpm_max*0.8 - mediaBPM));//@@@ add score funcional
		barreiras_obj = 0; // zera a distancia depois de calcular o objetivo
		habilita_objetivo = false;

		if (localObjetivo > obstaculos.Count) {
			localObjetivo = localObjetivo % obstaculos.Count;
		}
		objetivoAtual = Instantiate(objetivo, obstaculos[localObjetivo]);
	}

}
