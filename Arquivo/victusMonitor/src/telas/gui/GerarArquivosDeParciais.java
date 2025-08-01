package telas.gui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GerarArquivosDeParciais {

	private String paciente;
	public String local = "C:\\Users\\Maurício Realan\\eclipse-workspace\\Victus Teste1\\arquivos\\";
	public String nomeArquivo;
	BufferedReader br;
	int i=0;
	String parciais = "";
	
	public void gerarCsv(String cpfrg, String bpm, String dis, String vel, String emg )
	   {
	    try
	    {
	      
	    	  paciente = "parciais" + cpfrg + ".csv";
	    	  nomeArquivo = local + paciente;
		    	
	    	FileWriter writer = new FileWriter(nomeArquivo, true);

	        writer.append(bpm);
	        writer.append(';');
	        writer.append(dis);
	        writer.append(';');
	        writer.append(vel);
	        writer.append(';');
	        writer.append(emg);
	        writer.append('\n');

	        writer.flush();
	        writer.close();
	    	
	    }
	    catch(IOException e)
	    {
	         e.printStackTrace();
	    } 
	  }
	
	public String lerCsv(String cpfrg)
	   {
	    try
	    {
	      
	    	  paciente = "parciais" + cpfrg + ".csv";
	    	  nomeArquivo = local + paciente;
	    	  String linha = "";

		  
	    	  String csvDivisor = ";";

	    	  br = new BufferedReader(new FileReader(nomeArquivo));
	    	        while ((linha = br.readLine()) != null) {

	    	           if(i == 0) {
	    	        	parciais = parciais + linha;
	    	           }

	    	           if(i > 0) {
	    	        	   parciais = parciais + ";" + linha;
	    	           }
	    	           
	    	            //System.out.println(parciais);
	    	            i++;

	    	        }

	    	    } catch (FileNotFoundException e) {
	    	        e.printStackTrace();
	    	    } catch (IOException e) {
	    	        e.printStackTrace();
	    	    } finally {
	    	        if (br != null) {
	    	            try {
	    	                br.close();
	    	            } catch (IOException e) {
	    	                e.printStackTrace();
	    	            }
	    	        }
	    	    

	    	   }
	    return parciais;
 }
}
