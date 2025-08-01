package telas.gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GerarArquivosDeCadastros {

	
	public String local = "C:\\Users\\Maurício Realan\\eclipse-workspace\\Victus Teste1\\cadastros\\";
	public String local2 = "C:\\Users\\Maurício Realan\\eclipse-workspace\\Victus Teste1\\profissionais\\";
	
	public void GerarCadastro(String[] DadosPaciente, String[] DadosAmputacao) throws IOException {
	
		String nomeArquivo = local + DadosPaciente[2] + ".txt";
		
		FileWriter writer = new FileWriter(nomeArquivo, true);
		//BufferedWriter bw = new BufferedWriter(writer);
		
		System.out.println(DadosPaciente[0]);
		
		writer.write(DadosPaciente[0]);
		writer.write("\r\n");
		writer.write(DadosPaciente[1]);
		writer.write("\r\n");
		writer.write(DadosPaciente[2]);
		writer.write("\r\n");
		writer.write(DadosPaciente[3]);
		writer.write("\r\n");
		writer.write(DadosPaciente[4]);
		writer.write("\r\n");
		writer.write(DadosPaciente[5]);
		writer.write("\r\n");
		writer.write(DadosPaciente[6]);
		writer.write("\r\n");
		writer.write(DadosPaciente[7]);
		writer.write("\r\n");
		writer.write(DadosPaciente[8]);
		writer.write("\r\n");
		writer.write(DadosPaciente[9]);
		writer.write("\r\n");
		writer.write(DadosAmputacao[0]);
		writer.write("\r\n");
		writer.write(DadosAmputacao[1]);
		writer.write("\r\n");
		writer.write(DadosAmputacao[2]);
		writer.write("\r\n");
		
		//Criando o conteúdo do arquivo
		writer.flush();
		//Fechando conexão e escrita do arquivo.
		writer.close();
		//System.out.println("Arquivo gravado em: " + path);
	
	}
	
	public void GerarCadastroProfissional(String[] DadosPaciente) throws IOException {
		
		String nomeArquivo = local2 + DadosPaciente[2] + ".txt";
		
		FileWriter writer = new FileWriter(nomeArquivo, true);
		//BufferedWriter bw = new BufferedWriter(writer);
		
		System.out.println(DadosPaciente[0]);
		
		writer.write(DadosPaciente[0]);
		writer.write("\r\n");
		writer.write(DadosPaciente[1]);
		writer.write("\r\n");
		writer.write(DadosPaciente[2]);
		writer.write("\r\n");
		writer.write(DadosPaciente[3]);
		writer.write("\r\n");
		writer.write(DadosPaciente[4]);
		writer.write("\r\n");
		writer.write(DadosPaciente[5]);
		writer.write("\r\n");
		writer.write(DadosPaciente[6]);
		writer.write("\r\n");
		
		//Criando o conteúdo do arquivo
		writer.flush();
		//Fechando conexão e escrita do arquivo.
		writer.close();
		//System.out.println("Arquivo gravado em: " + path);
	
	}
}
