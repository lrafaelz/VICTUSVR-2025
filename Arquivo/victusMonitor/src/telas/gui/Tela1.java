package telas.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.DocumentException;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 frame = new Tela1();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela1() {
		setBackground(Color.WHITE);
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 958, 621);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Nova Sess\u00E3o");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				NSTelaBusca fr = new NSTelaBusca();
				fr.setLocationRelativeTo(null);
				fr.setVisible(true);
				setVisible(false);
			
			}
		});
		
		JButton btnCadastros = new JButton("Pacientes");
		btnCadastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				CADTela1 rr = new CADTela1();
				rr.setLocationRelativeTo(null);
				rr.setVisible(true);
				setVisible(false);
			
			}
		});
		
		JButton btnSobreOProjeto = new JButton("O Projeto");
		
		btnSobreOProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				TelaSobre rr = new TelaSobre();
				rr.setLocationRelativeTo(null);
				rr.setVisible(true);
				setVisible(false);
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\logotela1.png"));
		lblNewLabel.setBounds(24, 78, 586, 427);
		contentPane.add(lblNewLabel);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Calibri", Font.BOLD, 28));
		btnSair.setBackground(Color.BLACK);
		btnSair.setBounds(697, 465, 199, 51);
		contentPane.add(btnSair);
		
		JButton btnProfissionais = new JButton("Profissionais");
		
		btnProfissionais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				ProTela1 rr = new ProTela1();
				rr.setLocationRelativeTo(null);
				rr.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnProfissionais.setForeground(Color.WHITE);
		btnProfissionais.setFont(new Font("Calibri", Font.BOLD, 28));
		btnProfissionais.setBackground(Color.BLACK);
		btnProfissionais.setBounds(645, 227, 199, 51);
		contentPane.add(btnProfissionais);
		
		btnSobreOProjeto.setForeground(Color.WHITE);
		btnSobreOProjeto.setFont(new Font("Calibri", Font.BOLD, 28));
		btnSobreOProjeto.setBackground(Color.BLACK);
		btnSobreOProjeto.setBounds(664, 385, 199, 51);
		contentPane.add(btnSobreOProjeto);
		
		JButton btnRelatrios = new JButton("Relat\u00F3rios");
		
		btnRelatrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//RELBuscar g = new RELBuscar();
				//g.setVisible(true);
				//setVisible(false);
				/*BancoMySql bd = new BancoMySql();
				try {
					bd.conectar();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				ManipularBD mbd = new ManipularBD();
		          mbd.inserirSessao(" ", " ", " ", " ", " ", " ");
		         //ManipularBD mbd2 = new ManipularBD();
		           //mbd2.inserirProfissional();
		         //ManipularBD mmbd = new ManipularBD();
		          // mmbd.buscar();
			}
		});
		
		btnRelatrios.setForeground(Color.WHITE);
		btnRelatrios.setFont(new Font("Calibri", Font.BOLD, 28));
		btnRelatrios.setBackground(Color.BLACK);
		btnRelatrios.setBounds(645, 308, 199, 51);
		contentPane.add(btnRelatrios);
		btnCadastros.setForeground(Color.WHITE);
		btnCadastros.setFont(new Font("Calibri", Font.BOLD, 28));
		btnCadastros.setBackground(Color.BLACK);
		btnCadastros.setBounds(664, 148, 199, 51);
		contentPane.add(btnCadastros);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 28));
		btnNewButton.setBounds(697, 66, 199, 51);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.WHITE);
		label.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\teste3.png"));
		label.setBounds(143, 28, 768, 522);
		contentPane.add(label);
		//ImageIcon img = new ImageIcon("teste1.png");
		//JLabel label = new JLabel();
		//label.setIcon(teste1.png);
		//label.setBounds(100, 100, 450, 300);
	}
}
