package telas.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

public class CADTelaNovaFicha extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	public ButtonGroup grupo1, grupo2;
	// private RadioButtonHandler handler;
	String[] dadosPaciente = new String[10];
	String sexo;
	String Cor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CADTelaNovaFicha frame = new CADTelaNovaFicha();
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
	public CADTelaNovaFicha() {
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 621);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNovaSessoDe = new JLabel("");
		lblNovaSessoDe.setIcon(new ImageIcon(
				"C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\cadastros.png"));
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNovaSessoDe.setBounds(524, 68, 395, 95);
		contentPane.add(lblNovaSessoDe);

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String text1 = textField.getText();
				String text2 = textField_1.getText();
				String text3 = textField_2.getText();
				String text4 = textField_3.getText();
				String text5 = textField_4.getText();
				String text6 = textField_5.getText();
				String text7 = textField_6.getText();
				String text8 = textField_7.getText();

				/*
				 * dadosPaciente[0] = "NOME - " + text1; dadosPaciente[1] =
				 * "DATA DE NASCIMENTO - " + text2; dadosPaciente[2] = "CPF-RG - " + text3;
				 * dadosPaciente[3] = "ALTURA - " + text4; dadosPaciente[4] = "PESO - " + text5;
				 * dadosPaciente[5] = "REGISTRO - " + text6; dadosPaciente[6] = "TELEFONE - " +
				 * text7; dadosPaciente[7] = "EMAIL - " + text8; dadosPaciente[8] = "SEXO - " +
				 * sexo; dadosPaciente[9] = "COR - " + Cor;
				 */
				dadosPaciente[0] = text1;
				dadosPaciente[1] = text2;
				dadosPaciente[2] = text3;
				dadosPaciente[3] = text4;
				dadosPaciente[4] = text5;
				dadosPaciente[5] = text6;
				dadosPaciente[6] = text7;
				dadosPaciente[7] = text8;
				dadosPaciente[8] = sexo;
				dadosPaciente[9] = Cor;

				for (int k = 0; k < 10; k++) {
					System.out.println(dadosPaciente[k]);
				}

				CADTelaNivelAmputacao fr = new CADTelaNivelAmputacao(dadosPaciente);
				fr.setLocationRelativeTo(null);
				fr.setVisible(true);
				setVisible(false);

			}
		});

		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnNewButton.setBounds(703, 510, 191, 49);
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
		btnVoltar.setBounds(489, 510, 191, 49);
		contentPane.add(btnVoltar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\logolaranja.png"));
		label.setBounds(152, 11, 330, 200);
		contentPane.add(label);

		JLabel lblFichaDoPaciente = new JLabel("Nome");
		lblFichaDoPaciente.setFont(new Font("Calibri", Font.BOLD, 20));
		lblFichaDoPaciente.setBounds(79, 237, 76, 37);
		contentPane.add(lblFichaDoPaciente);

		textField = new JTextField();
		textField.setBounds(137, 242, 574, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Calibri", Font.BOLD, 20));
		lblDataDeNascimento.setBounds(79, 286, 185, 37);
		contentPane.add(lblDataDeNascimento);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(259, 291, 185, 28);
		contentPane.add(textField_1);

		JLabel lblCpfrg = new JLabel("CPF/RG");
		lblCpfrg.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCpfrg.setBounds(468, 286, 185, 37);
		contentPane.add(lblCpfrg);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(546, 291, 165, 28);
		contentPane.add(textField_2);

		JLabel lblSexo = new JLabel(" Sexo");
		lblSexo.setFont(new Font("Arial", Font.BOLD, 20));
		lblSexo.setBounds(750, 241, 76, 37);
		contentPane.add(lblSexo);

		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnMasculino.setBounds(750, 274, 109, 23);
		// grupo1 = new ButtonGroup();
		// grupo1.add(rdbtnMasculino);
		contentPane.add(rdbtnMasculino);

		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				rdbtnMasculino.setSelected(false);
				sexo = "Feminino";

			}
		});
		rdbtnFeminino.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnFeminino.setBounds(750, 300, 109, 23);
		contentPane.add(rdbtnFeminino);
		// contentPane.add(grupo1);

		rdbtnMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				rdbtnFeminino.setSelected(false);
				sexo = "Masculino";

			}
		});

		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAltura.setBounds(79, 341, 321, 37);
		contentPane.add(lblAltura);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(140, 346, 165, 28);
		contentPane.add(textField_3);

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Calibri", Font.BOLD, 20));
		lblPeso.setBounds(352, 341, 301, 37);
		contentPane.add(lblPeso);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(413, 346, 298, 28);
		contentPane.add(textField_4);

		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Calibri", Font.BOLD, 20));
		lblRegistro.setBounds(79, 389, 321, 37);
		contentPane.add(lblRegistro);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(167, 394, 257, 28);
		contentPane.add(textField_5);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Calibri", Font.BOLD, 20));
		lblTelefone.setBounds(454, 392, 185, 37);
		contentPane.add(lblTelefone);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(546, 394, 165, 28);
		contentPane.add(textField_6);

		JLabel lblCor = new JLabel("Cor da Pele");
		lblCor.setFont(new Font("Arial", Font.BOLD, 20));
		lblCor.setBounds(750, 341, 126, 37);
		contentPane.add(lblCor);

		JRadioButton rdbtnCaucasiano = new JRadioButton("Caucasiana");
		rdbtnCaucasiano.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnCaucasiano.setBounds(750, 373, 109, 23);
		contentPane.add(rdbtnCaucasiano);

		JRadioButton rdbtnParda = new JRadioButton("Parda");
		rdbtnParda.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnParda.setBounds(750, 397, 109, 23);
		contentPane.add(rdbtnParda);

		JRadioButton rdbtnNegra = new JRadioButton("Negra");
		rdbtnNegra.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnNegra.setBounds(750, 423, 109, 23);
		contentPane.add(rdbtnNegra);

		rdbtnCaucasiano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				rdbtnParda.setSelected(false);
				rdbtnNegra.setSelected(false);
				Cor = "Caucasiana";

			}
		});

		rdbtnParda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				rdbtnCaucasiano.setSelected(false);
				rdbtnNegra.setSelected(false);
				Cor = "Parda";

			}
		});

		rdbtnNegra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				rdbtnCaucasiano.setSelected(false);
				rdbtnParda.setSelected(false);
				Cor = "Negra";

			}
		});

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(137, 442, 574, 28);
		contentPane.add(textField_7);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 20));
		lblEmail.setBounds(79, 437, 76, 37);
		contentPane.add(lblEmail);

		JPanel panel = new JPanel();
		panel.setBounds(67, 229, 657, 253);
		contentPane.add(panel);
	}
}
