package telas.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class BancoMySql {

	String url = "jdbc:mysql://127.0.0.1:3306/novodb" + "?useSSL=false";
	// String url = "jdbc:mysql://127.0.0.1:3306/bancovictus"+"?useSSL=false";
	String usuario = "root";
	String senha = "/01bdvictus*";
	public Connection conexao = null;

	public void conectar() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conexao = DriverManager.getConnection(url, usuario, senha);
			// JOptionPane.showMessageDialog(null, "conectado no banco");
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "problema na coneção e driver do banco" + ex);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "problema ao se conectar no banco");
		}
	}

	public void desconectar() {
		try {
			this.conexao.close();
			JOptionPane.showMessageDialog(null, "desconectado com sucesso");
		} catch (SQLException ex) {
			// Logger.getLogger(bancomysql.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "problema ao se desconectar no banco");
		}
	}

}
