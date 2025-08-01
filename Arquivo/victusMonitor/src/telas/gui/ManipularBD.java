package telas.gui;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class ManipularBD {

	public void inserirParciais(String tempoParcial, int numparcial, int ParcialBpm, float ParcialDis, float ParcialVel,
			int ParcialEmg, int sessaoid) { // recebe um objeto cliente

		float temp = 0;
		try {
			String sql = "INSERT INTO monitor (monitor_tempoparcial,monitor_parcialnum,monitor_bpm,monitor_dis,monitor_vel,monitor_emg,monitor_indicador01,monitor_indicador02,monitor_indicador03,sessao_sessao_id,monitor_observacao )"
					+ "values(?,?,?,?,?,?,?,?,?,?,?)"; // string de comando sql

			BancoMySql objbanco = new BancoMySql(); // cria um objeto de banco de dados
			objbanco.conectar();// usar o objeto de banco de dados para conectar

			PreparedStatement objpat = objbanco.conexao.prepareStatement(sql);
			ResultSet RS;

			// seta os valores no banco
			// objpat.setString(1, "1");
			objpat.setString(1, tempoParcial);
			objpat.setInt(2, numparcial);
			objpat.setInt(3, ParcialBpm);
			objpat.setFloat(4, ParcialDis);
			objpat.setFloat(5, ParcialVel);
			objpat.setInt(6, ParcialEmg);
			objpat.setFloat(7, temp);
			objpat.setFloat(8, temp);
			objpat.setFloat(9, temp);
			objpat.setInt(10, sessaoid);
			objpat.setString(11, "nenhuma observação");

			objpat.executeUpdate();

			// JOptionPane.showMessageDialog(null, "parcial gravada no banco com sucesso");

			objpat.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "erro \n inserir" + ex.getMessage());
			// Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void inserirColetas(String tempocoleta, int numcoleta, int cardioi, String resp, String arte, int sessaoid) { // recebe
																															// um
																															// objeto
																															// cliente

		try {

			String sql = "INSERT INTO coleta (coleta_tempo,coleta_numero,coleta_fc,coleta_fr,coleta_pa,sessao_sessao_id )"
					+ "values(?,?,?,?,?,?)"; // string de comando sql

			BancoMySql objbanco = new BancoMySql(); // cria um objeto de banco de dados
			objbanco.conectar();// usar o objeto de banco de dados para conectar

			PreparedStatement objpat = objbanco.conexao.prepareStatement(sql);
			ResultSet RS;

			// seta os valores no banco
			// objpat.setString(1, "1");
			objpat.setString(1, tempocoleta);
			objpat.setInt(2, numcoleta);
			objpat.setInt(3, cardioi);
			objpat.setString(4, resp);
			objpat.setString(5, arte);
			objpat.setInt(6, sessaoid);

			objpat.executeUpdate();

			JOptionPane.showMessageDialog(null, "Coleta gravada no banco com sucesso");

			objpat.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "erro \n inserir" + ex.getMessage());
			// Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void inserirPaciente(String[] dadosPaciente, String[] dadosAmputacao) { // recebe um objeto cliente

		try {
			String sql = "INSERT INTO pacientes (paciente_cpf,paciente_nome,paciente_data,paciente_altura,paciente_peso,paciente_registro,paciente_sexo,paciente_cor,paciente_email,paciente_telefone,paciente_nivel,paciente_tipo,paciente_lado )"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)"; // string de comando sql

			BancoMySql objbanco = new BancoMySql(); // cria um objeto de banco de dados
			objbanco.conectar();// usar o objeto de banco de dados para conectar

			PreparedStatement objpat = objbanco.conexao.prepareStatement(sql);
			ResultSet RS;

			// seta os valores no banco
			// objpat.setString(1, "1");
			objpat.setString(1, dadosPaciente[2]);
			objpat.setString(2, dadosPaciente[0]);
			objpat.setString(3, dadosPaciente[1]);
			objpat.setString(4, dadosPaciente[3]);
			objpat.setString(5, dadosPaciente[4]);
			objpat.setString(6, dadosPaciente[5]);
			objpat.setString(7, dadosPaciente[8]);
			objpat.setString(8, dadosPaciente[9]);
			objpat.setString(9, dadosPaciente[7]);
			objpat.setString(10, dadosPaciente[6]);
			objpat.setString(11, dadosAmputacao[0]);
			objpat.setString(12, dadosAmputacao[1]);
			objpat.setString(13, dadosAmputacao[2]);

			objpat.executeUpdate();

			JOptionPane.showMessageDialog(null, "cliente gravado no banco com sucesso");

			objpat.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "erro \n inserir" + ex.getMessage());
			// Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void inserirProfissional(String[] dadosProfissional) { // recebe um objeto cliente

		try {

			String sql = "INSERT INTO profissional (profissional_cpf,profissional_nome,profissional_email,profissional_especialidade,profissional_senha )"
					+ "values(?,?,?,?,?)"; // string de comando sql

			BancoMySql objbanco = new BancoMySql(); // cria um objeto de banco de dados
			objbanco.conectar();// usar o objeto de banco de dados para conectar

			PreparedStatement objpat = objbanco.conexao.prepareStatement(sql);
			ResultSet RS;

			// seta os valores no banco
			// objpat.setString(1, "1");
			objpat.setString(1, dadosProfissional[2]);
			objpat.setString(2, dadosProfissional[0]);
			objpat.setString(3, dadosProfissional[5]);
			objpat.setString(4, dadosProfissional[3]);
			objpat.setString(5, dadosProfissional[6]);

			objpat.executeUpdate();

			JOptionPane.showMessageDialog(null, "cliente gravado no banco com sucesso");

			objpat.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "erro \n inserir" + ex.getMessage());
			// Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	int inserirSessao(String pacienteCPF, String profissionalCPF, String data, String hora, String tempo,
			String coletas) { // recebe um objeto cliente
		int lastId = 0;
		try {

			String sql = "INSERT INTO sessao (sessao_data,sessao_hora,sessao_tempo,sessao_coletas,pacientes_paciente_cpf,profissional_profissional_cpf )"
					+ "values(?,?,?,?,?,?)"; // string de comando sql

			BancoMySql objbanco = new BancoMySql(); // cria um objeto de banco de dados
			objbanco.conectar();// usar o objeto de banco de dados para conectar

			PreparedStatement objpat = objbanco.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// ResultSet rs = objpat.getGeneratedKeys();
			// seta os valores no banco
			// objpat.setString(1, "1");
			objpat.setString(1, data); // data da sessao
			objpat.setString(2, hora); // hora da sessao
			objpat.setString(3, tempo); // tempo de sessao
			objpat.setString(4, coletas); // numero de coletas
			objpat.setString(5, pacienteCPF); // paciente cpf
			objpat.setString(6, profissionalCPF); // profissional cpf

			objpat.executeUpdate();

			ResultSet rs = objpat.getGeneratedKeys();

			if (rs.next()) {
				lastId = rs.getInt(1);
			}
			System.out.println("sessao id : " + lastId);

			JOptionPane.showMessageDialog(null, "sessao gravada com sucesso");

			objpat.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "erro \n inserir" + ex.getMessage());
			// Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}

		return lastId;
	}

	String buscarPaciente(String cpfPaciente) {
		String p = "Paciente de Teste 1";
		String sqlSelect = "SELECT * FROM pacientes WHERE paciente_cpf =" + cpfPaciente;
		PreparedStatement stm = null;
		ResultSet rs = null;
		String cpf = " ", nome = " ", nivel = " ", tipo = " ", lado = " ";

		try {
			BancoMySql objbanco = new BancoMySql(); // cria um objeto de banco de dados
			objbanco.conectar();// usar o objeto de banco de dados para conectar

			stm = objbanco.conexao.prepareStatement(sqlSelect);
			rs = stm.executeQuery();

			if (rs.next()) {
				cpf = rs.getString(2);
				nome = rs.getString(3);
				String data = rs.getString(4);
				String altura = rs.getString(5);
				String peso = rs.getString(6);
				String cor = rs.getString(7);
				String registro = rs.getString(8);
				String sexo = rs.getString(9);
				String email = rs.getString(10);
				String telefone = rs.getString(11);
				nivel = rs.getString(12);
				tipo = rs.getString(13);
				lado = rs.getString(14);

				System.out.println(nome);
				System.out.println(cpf);
				System.out.println(nivel);
				System.out.println(tipo);
				System.out.println(lado);
				// System.out.println(cor);
				// System.out.println(reg);
				stm.close();
				// return cpf+";"+nome+";"+nivel+";"+tipo+";"+lado;
			}
			// return cpf+";"+nome+";"+nivel+";"+tipo+";"+lado;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro na busca");
			return "Nao encontrado";
		}

		return cpf + ";" + nome + ";" + nivel + ";" + tipo + ";" + lado;
		// return cpf;
	}

	String buscarProfissional(String cpfProfissional) {
		String p = "Paciente de Teste 1";
		String sqlSelect = "SELECT * FROM profissional WHERE profissional_cpf =" + cpfProfissional;
		PreparedStatement stm = null;
		ResultSet rs = null;
		String cpf = " ", senha = " ";

		try {
			BancoMySql objbanco = new BancoMySql(); // cria um objeto de banco de dados
			objbanco.conectar();// usar o objeto de banco de dados para conectar

			stm = objbanco.conexao.prepareStatement(sqlSelect);
			rs = stm.executeQuery();

			if (rs.next()) {
				cpf = rs.getString(2);
				String nome = rs.getString(3);
				String email = rs.getString(4);
				String especialidade = rs.getString(5);
				senha = rs.getString(6);

				System.out.println(senha);
				System.out.println(cpf);
				// System.out.println(cor);
				// System.out.println(reg);
				stm.close();
				// return cpf+";"+nome+";"+nivel+";"+tipo+";"+lado;
			}
			// return cpf+";"+nome+";"+nivel+";"+tipo+";"+lado;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro na busca");
			return "Nao encontrado";
		}

		return cpf + ";" + senha;
		// return cpf;
	}

	String buscarSessao(String cpfPaciente, String cpfProfissional, String dataSessao) {
		String p = "Paciente de Teste 1";
		String sqlSelect = "SELECT * FROM sessao WHERE pacientes_paciente_cpf =" + cpfPaciente
				+ "AND profissional_profissional_cpf =" + cpfProfissional + "AND sessao_data =" + dataSessao;
		PreparedStatement stm = null;
		ResultSet rs = null;
		int sessaoId = 0;
		String sessaoData = " ", sessaoHora = " ", sessaoTempo = " ", sessaoColetas = " ";
		String sessaoPaciente = " ", sessaoProfissional = " ";

		try {
			BancoMySql objbanco = new BancoMySql(); // cria um objeto de banco de dados
			objbanco.conectar();// usar o objeto de banco de dados para conectar

			stm = objbanco.conexao.prepareStatement(sqlSelect);
			rs = stm.executeQuery();

			if (rs.next()) {
				sessaoId = rs.getInt(1);
				sessaoData = rs.getString(2);
				sessaoHora = rs.getString(3);
				sessaoTempo = rs.getString(4);
				sessaoColetas = rs.getString(5);
				sessaoPaciente = rs.getString(6);
				sessaoProfissional = rs.getString(7);

				stm.close();
				// return cpf+";"+nome+";"+nivel+";"+tipo+";"+lado;
			}
			// return cpf+";"+nome+";"+nivel+";"+tipo+";"+lado;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro na busca");
			return "Nao encontrado";
		}

		return Integer.toString(sessaoId) + ";" + sessaoHora;
		// return cpf;
	}

	String buscarParciais(String sessaoId) {
		String p = "Paciente de Teste 1";
		String sqlSelect = "SELECT * FROM monitor WHERE sessao_sessao_id =" + sessaoId;
		PreparedStatement stm = null;
		ResultSet rs = null;
		String tempoParcial = " ", numParcial = " ", observacao = " ";
		int bpm = 0, emg = 0;
		float dis = 0, vel = 0, i1 = 0, i2 = 0, i3 = 0;

		try {
			BancoMySql objbanco = new BancoMySql(); // cria um objeto de banco de dados
			objbanco.conectar();// usar o objeto de banco de dados para conectar

			stm = objbanco.conexao.prepareStatement(sqlSelect);
			rs = stm.executeQuery();

			if (rs.next()) {
				tempoParcial = rs.getString(2);
				numParcial = rs.getString(3);
				bpm = rs.getInt(4);
				dis = rs.getFloat(5);
				vel = rs.getFloat(6);
				emg = rs.getInt(7);
				i1 = rs.getFloat(8);
				i2 = rs.getFloat(9);
				i3 = rs.getFloat(10);
				sessaoId = rs.getString(11);
				observacao = rs.getString(12);

				stm.close();
				// return cpf+";"+nome+";"+nivel+";"+tipo+";"+lado;
			}
			// return cpf+";"+nome+";"+nivel+";"+tipo+";"+lado;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro na busca");
			return "Nao encontrado";
		}

		return Integer.toString(bpm) + ";" + Float.toString(dis) + ";" + Float.toString(vel) + ";"
				+ Integer.toString(emg);
		// return cpf;
	}

	String buscarColetas(String sessaoId) {
		String p = "Paciente de Teste 1";
		String sqlSelect = "SELECT * FROM coleta WHERE sessao_sessao_id =" + sessaoId;
		PreparedStatement stm = null;
		ResultSet rs = null;
		String tempoColeta = " ", numColeta = " ", fr = " ", pa = " ";
		int fc = 0;

		try {
			BancoMySql objbanco = new BancoMySql(); // cria um objeto de banco de dados
			objbanco.conectar();// usar o objeto de banco de dados para conectar

			stm = objbanco.conexao.prepareStatement(sqlSelect);
			rs = stm.executeQuery();

			if (rs.next()) {
				tempoColeta = rs.getString(2);
				numColeta = rs.getString(3);
				fc = rs.getInt(4);
				fr = rs.getString(5);
				pa = rs.getString(6);

				stm.close();
				// return cpf+";"+nome+";"+nivel+";"+tipo+";"+lado;
			}
			// return cpf+";"+nome+";"+nivel+";"+tipo+";"+lado;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro na busca");
			return "Nao encontrado";
		}

		return Integer.toString(fc) + ";" + fr + ";" + pa;
		// return cpf;
	}

}
