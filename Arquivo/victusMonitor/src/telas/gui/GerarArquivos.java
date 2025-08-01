package telas.gui;

import java.io.FileWriter;
import java.io.IOException;

public class GerarArquivos {

	private String paciente;
	public String local = "C:\\Users\\Maurício Realan\\eclipse-workspace\\Victus Teste1\\arquivos\\";
	public String nomeArquivo;
	
	/*public void nomePaciente(String nome) 
		{
		
		String tec = nome;
		paciente = tec;
		System.out.println(paciente);
		//arquivo = local + paciente;
		
		}*/
	
	/**classe para tal coissa
	 * 
	 * @param cpfrg 
	 * @param tempo
	 * @param bpm
	 * @param dis
	 * @param vel
	 * @param emg
	 */
	public void gerarCsv(String cpfrg, String tempo, String bpm, String dis, String vel, String emg )
	   {
	    try
	    {
	      
	    	  paciente = cpfrg + ".csv";
	    		nomeArquivo = local + paciente;
		    	
	    	FileWriter writer = new FileWriter(nomeArquivo, true);

	        writer.append(tempo);
	        writer.append(';');
	        writer.append(bpm);
	        writer.append(';');
	        writer.append(dis);
	        writer.append(';');
	        writer.append(vel);
	        writer.append(';');
	        writer.append(emg);
	        writer.append('\n');
/*
	        writer.append("MKYONG");
	        writer.append(';');
	        writer.append("26");
	        writer.append('\n');

	        writer.append("YOUR NAME");
	        writer.append(';');
	        writer.append("29");
	        writer.append('\n');
*/
	        //generate whatever data you want

	        writer.flush();
	        writer.close();
	    	
	    }
	    catch(IOException e)
	    {
	         e.printStackTrace();
	    } 
	    }
	    
	}
	
