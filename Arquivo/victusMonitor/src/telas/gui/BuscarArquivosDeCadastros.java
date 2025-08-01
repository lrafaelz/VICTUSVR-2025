package telas.gui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class BuscarArquivosDeCadastros {

	private String paciente;
	public String local = "C:\\Users\\Maurício Realan\\eclipse-workspace\\Victus Teste1\\cadastros\\";
	public String local2 = "C:\\Users\\Maurício Realan\\eclipse-workspace\\Victus Teste1\\profissionais\\";
	public String nomeArquivo;
	BufferedReader br;
	int i = 0;
	String conteudo = "";
	String linha = "";
	String[] c = new String[13];
	int flag = 0;

	public String lerCadastro(String cpfRG, int tipo) {
		try {

			if (tipo == 1) {
				paciente = cpfRG + ".txt";
				nomeArquivo = local + "CPF-RG - " + paciente;
			}

			if (tipo == 2) {
				paciente = cpfRG + ".txt";
				nomeArquivo = local2 + "CPF-RG - " + paciente;
			}

			System.out.println(nomeArquivo);

			String csvDivisor = ";";

			br = new BufferedReader(new FileReader(nomeArquivo));
			while ((linha = br.readLine()) != null) {

				c[i] = linha;
				System.out.println(c[i]);
				i++;

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// JOptionPane.showMessageDialog(null, "Cadastro Não Encontrado !!!\nDigite Um
			// Novo Nome!", "ERRO!", JOptionPane.ERROR_MESSAGE);
			// CADTelaBuscar rr = new CADTelaBuscar();
			// rr.setVisible(true);
			flag = 1;
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

		if (flag == 1) {
			conteudo = "x";
		} else
			conteudo = c[0] + ";" + c[1] + ";" + c[2] + ";" + c[3] + ";" + c[4] + ";" + c[5] + ";" + c[6] + ";" + c[7]
					+ ";" + c[8] + ";" + c[9] + ";" + c[10] + ";" + c[11] + ";" + c[12];

		return conteudo;
	}

}
