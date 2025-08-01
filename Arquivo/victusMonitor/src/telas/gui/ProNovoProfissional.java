package telas.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ProNovoProfissional extends JFrame {

	//private JPanel contentPane;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	public ButtonGroup grupo1, grupo2;
	//private RadioButtonHandler handler;
	String[] dadosProfissional = new String[10];
	String sexo;
	String Cor;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProNovoProfissional frame = new ProNovoProfissional();
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
	public ProNovoProfissional() {
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 621);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNovaSessoDe = new JLabel("");
		lblNovaSessoDe.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\cadastrosprof.png"));
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNovaSessoDe.setBounds(506, 76, 401, 98);
		contentPane.add(lblNovaSessoDe);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				String text1 = textField.getText();
				String text2 = textField_1.getText();
				String text3 = textField_2.getText();
				String text6 = textField_5.getText();
				String text7 = textField_6.getText();
				String text8 = textField_7.getText();
				String text9 = textField_3.getText();
				
				/*dadosProfissional[0] = "NOME - " + text1;
				dadosProfissional[1] = "DATA DE NASCIMENTO - " + text2;
				dadosProfissional[2] = "CPF-RG - " + text3;
				dadosProfissional[3] = "ESPECIALIDADE - " + text6;
				dadosProfissional[4] = "TELEFONE - " + text7;
				dadosProfissional[5] = "EMAIL - " + text8;
				dadosProfissional[6] = "SENHA - " + text9;*/
				
				dadosProfissional[0] = text1;
				dadosProfissional[1] = text2;
				dadosProfissional[2] = text3;
				dadosProfissional[3] = text6;
				dadosProfissional[4] = text7;
				dadosProfissional[5] = text8;
				dadosProfissional[6] = text9;
				
				for(int k = 0 ; k < 10 ; k++) {
				System.out.println(dadosProfissional[k]);}
				
				/*GerarArquivosDeCadastros cd = new GerarArquivosDeCadastros();
				try {
					cd.GerarCadastroProfissional(dadosProfissional);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
				ManipularBD mbd2 = new ManipularBD();
		        mbd2.inserirProfissional(dadosProfissional);
				
				CADTela1 rr = new CADTela1();
				rr.setLocationRelativeTo(null);
				rr.setVisible(true);
				setVisible(false);
			
				
			}
		});
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnNewButton.setBounds(689, 522, 191, 49);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				CADTela1 fr = new CADTela1();
				fr.setLocationRelativeTo(null);
				fr.setVisible(true);
				setVisible(false);
			
			}
		});
		
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setBounds(475, 522, 191, 49);
		contentPane.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\logolaranja.png"));
		label.setBounds(148, 11, 327, 200);
		contentPane.add(label);
		
		JLabel lblFichaDoPaciente = new JLabel("Nome");
		lblFichaDoPaciente.setFont(new Font("Calibri", Font.BOLD, 20));
		lblFichaDoPaciente.setBounds(154, 237, 76, 37);
		contentPane.add(lblFichaDoPaciente);
		
		textField = new JTextField();
		textField.setBounds(212, 242, 574, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Calibri", Font.BOLD, 20));
		lblDataDeNascimento.setBounds(154, 286, 185, 37);
		contentPane.add(lblDataDeNascimento);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(334, 291, 185, 28);
		contentPane.add(textField_1);
		
		JLabel lblCpfrg = new JLabel("CPF/RG");
		lblCpfrg.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCpfrg.setBounds(543, 286, 185, 37);
		contentPane.add(lblCpfrg);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(621, 291, 165, 28);
		contentPane.add(textField_2);
		
		JLabel lblRegistro = new JLabel("Especialidade");
		lblRegistro.setFont(new Font("Calibri", Font.BOLD, 20));
		lblRegistro.setBounds(154, 338, 321, 37);
		contentPane.add(lblRegistro);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(273, 343, 226, 28);
		contentPane.add(textField_5);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Calibri", Font.BOLD, 20));
		lblTelefone.setBounds(529, 341, 185, 37);
		contentPane.add(lblTelefone);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(621, 343, 165, 28);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(212, 391, 574, 28);
		contentPane.add(textField_7);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 20));
		lblEmail.setBounds(154, 386, 76, 37);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Calibri", Font.BOLD, 20));
		lblSenha.setBounds(349, 435, 241, 37);
		contentPane.add(lblSenha);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(410, 440, 226, 28);
		contentPane.add(textField_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(135, 224, 666, 265);
		contentPane.add(panel);
	}
}
