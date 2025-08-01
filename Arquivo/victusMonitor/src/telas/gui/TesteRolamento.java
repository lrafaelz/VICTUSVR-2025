package telas.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class TesteRolamento extends JFrame {

	private JPanel contentPane;
	private JFrame janela;
	private JPanel painel;
	private JScrollPane mouse;
	private JButton botao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		TesteRolamento rato = new TesteRolamento();
		//rato.TesteRolamento();
	}

	/**
	 * Create the frame.
	 */
	public TesteRolamento() {
		 janela = new JFrame("Janelinha");
		 janela.setSize(673, 500);
		 janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 janela.setResizable(true);
		 painel = new JPanel();
		 painel.setSize(500,500);
		 painel.setPreferredSize(new Dimension(0,1000));
		 janela.getContentPane().add(painel);
		 mouse = new JScrollPane(painel);
		 janela.getContentPane().add(mouse);
		 painel.setLayout(null);
		 botao = new JButton("teste");
		 botao.setBounds(10, 10, 100, 50);
		 painel.add(botao);
		 janela.setVisible(true);
}

}
