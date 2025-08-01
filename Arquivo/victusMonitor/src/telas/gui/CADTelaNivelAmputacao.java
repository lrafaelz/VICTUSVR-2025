package telas.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CADTelaNivelAmputacao extends JFrame {

	private JPanel contentPane;
	String tipo;
	String causa;
	String lado;
	String[] dadosAmputacao = new String[3];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CADTelaNivelAmputacao frame = new CADTelaNivelAmputacao(null);
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
	public CADTelaNivelAmputacao(String[] DadosPaciente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 621);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNovaSessoDe = new JLabel("");
		lblNovaSessoDe.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\cadastros.png"));
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNovaSessoDe.setBounds(522, 105, 396, 102);
		contentPane.add(lblNovaSessoDe);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dadosAmputacao[0] = tipo;
				dadosAmputacao[1] = causa;
				dadosAmputacao[2] = lado;
				for(int k = 0 ; k < 3 ; k++) {
					System.out.println(dadosAmputacao[k]);}
				
				ManipularBD mbd2 = new ManipularBD();
		        mbd2.inserirPaciente(DadosPaciente,dadosAmputacao);
				
			/*	GerarArquivosDeCadastros cd = new GerarArquivosDeCadastros();
				try {
					cd.GerarCadastro(DadosPaciente, dadosAmputacao);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				CADTela1 rr = new CADTela1();
				rr.setVisible(true);
				setVisible(false);
			
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnNewButton.setBounds(666, 476, 191, 49);
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
		btnVoltar.setBounds(452, 476, 191, 49);
		contentPane.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\logolaranja.png"));
		label.setBounds(178, 33, 353, 200);
		contentPane.add(label);
		
		JLabel lblFichaDoPaciente = new JLabel("N\u00EDvel de Amputa\u00E7\u00E3o");
		lblFichaDoPaciente.setFont(new Font("Calibri", Font.BOLD, 20));
		lblFichaDoPaciente.setBounds(54, 240, 343, 37);
		contentPane.add(lblFichaDoPaciente);
		
		
		
		JRadioButton rdbtnMasculino = new JRadioButton("Transfemural");
		rdbtnMasculino.setForeground(Color.BLACK);
		rdbtnMasculino.setFont(new Font("Calibri", Font.BOLD, 15));
		rdbtnMasculino.setBounds(54, 295, 147, 23);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("1/3 Inferior");
		rdbtnFeminino.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnFeminino.setBounds(68, 327, 105, 23);
		contentPane.add(rdbtnFeminino);
		
		JRadioButton rdbtnMdio = new JRadioButton("1/3 M\u00E9dio");
		rdbtnMdio.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnMdio.setBounds(68, 354, 105, 23);
		contentPane.add(rdbtnMdio);
		
		JRadioButton rdbtnSuperior = new JRadioButton("1/3 Superior");
		rdbtnSuperior.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnSuperior.setBounds(68, 380, 105, 23);
		contentPane.add(rdbtnSuperior);
		
		JRadioButton rdbtnTranstibial = new JRadioButton("Transtibial");
		rdbtnTranstibial.setForeground(Color.BLACK);
		rdbtnTranstibial.setFont(new Font("Calibri", Font.BOLD, 15));
		rdbtnTranstibial.setBounds(231, 295, 147, 23);
		contentPane.add(rdbtnTranstibial);
		
		JRadioButton radioButton_1 = new JRadioButton("1/3 Inferior");
		radioButton_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		radioButton_1.setBounds(245, 327, 105, 23);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("1/3 M\u00E9dio");
		radioButton_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		radioButton_2.setBounds(245, 354, 105, 23);
		contentPane.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("1/3 Superior");
		radioButton_3.setFont(new Font("Calibri", Font.PLAIN, 14));
		radioButton_3.setBounds(245, 380, 105, 23);
		contentPane.add(radioButton_3);
		
		JRadioButton rdbtnDesarticulaoDeJoelho = new JRadioButton("Desarticula\u00E7\u00E3o de Joelho");
		rdbtnDesarticulaoDeJoelho.setForeground(Color.BLACK);
		rdbtnDesarticulaoDeJoelho.setFont(new Font("Calibri", Font.BOLD, 15));
		rdbtnDesarticulaoDeJoelho.setBounds(56, 432, 220, 23);
		contentPane.add(rdbtnDesarticulaoDeJoelho);
		
		rdbtnMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnTranstibial.setSelected(false);
				rdbtnDesarticulaoDeJoelho.setSelected(false);
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				
			}
		});
		
		rdbtnFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				tipo = "Transfemural - 1/3 Inferior";
				rdbtnMdio.setSelected(false);
				rdbtnSuperior.setSelected(false);
				rdbtnTranstibial.setSelected(false);
				rdbtnDesarticulaoDeJoelho.setSelected(false);
				
			}
		});
		
		rdbtnMdio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				tipo = "Transfemural - 1/3 Médio";
				rdbtnFeminino.setSelected(false);
				rdbtnSuperior.setSelected(false);
				rdbtnTranstibial.setSelected(false);
				rdbtnDesarticulaoDeJoelho.setSelected(false);
				
			}
		});
		
		rdbtnSuperior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				tipo = "Transfemural - 1/3 Superior";
				rdbtnFeminino.setSelected(false);
				rdbtnMdio.setSelected(false);
				rdbtnTranstibial.setSelected(false);
				rdbtnDesarticulaoDeJoelho.setSelected(false);
				
			}
		});
		
		rdbtnTranstibial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnMasculino.setSelected(false);
				rdbtnDesarticulaoDeJoelho.setSelected(false);
				rdbtnMdio.setSelected(false);
				rdbtnSuperior.setSelected(false);
				rdbtnFeminino.setSelected(false);
			
			}
		});
		
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				tipo = "Transtibial - 1/3 Inferior";
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				rdbtnMasculino.setSelected(false);
				rdbtnDesarticulaoDeJoelho.setSelected(false);
				
			}
		});
		
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				tipo = "Transtibial - 1/3 Médio";
				radioButton_1.setSelected(false);
				radioButton_3.setSelected(false);
				rdbtnMasculino.setSelected(false);
				rdbtnDesarticulaoDeJoelho.setSelected(false);
			
			}
		});
		
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				tipo = "Transtibial - 1/3 Superior";
				radioButton_2.setSelected(false);
				radioButton_1.setSelected(false);
				rdbtnMasculino.setSelected(false);
				rdbtnDesarticulaoDeJoelho.setSelected(false);
				
			}
		});
		
		rdbtnDesarticulaoDeJoelho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnMasculino.setSelected(false);
				rdbtnTranstibial.setSelected(false);
				rdbtnMdio.setSelected(false);
				rdbtnSuperior.setSelected(false);
				rdbtnFeminino.setSelected(false);
				radioButton_1.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				
			}
		});
		
		JLabel lblCausaDaAmputao = new JLabel("Causa da Amputa\u00E7\u00E3o");
		lblCausaDaAmputao.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCausaDaAmputao.setBounds(504, 240, 343, 37);
		contentPane.add(lblCausaDaAmputao);
		
		JRadioButton rdbtnTraumtica = new JRadioButton("Traum\u00E1tica");
		rdbtnTraumtica.setForeground(Color.BLACK);
		rdbtnTraumtica.setFont(new Font("Calibri", Font.BOLD, 15));
		rdbtnTraumtica.setBounds(527, 295, 147, 23);
		contentPane.add(rdbtnTraumtica);
		
		JRadioButton rdbtnAdquirida = new JRadioButton("Adquirida");
		rdbtnAdquirida.setForeground(Color.BLACK);
		rdbtnAdquirida.setFont(new Font("Calibri", Font.BOLD, 15));
		rdbtnAdquirida.setBounds(753, 295, 147, 23);
		contentPane.add(rdbtnAdquirida);
		
		JRadioButton rdbtnAcidenteAutomobilistico = new JRadioButton("Acidente Automobil\u00EDstico");
		rdbtnAcidenteAutomobilistico.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnAcidenteAutomobilistico.setBounds(541, 327, 173, 23);
		contentPane.add(rdbtnAcidenteAutomobilistico);
		
		JRadioButton rdbtnDiabetes = new JRadioButton("Diabetes");
		rdbtnDiabetes.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnDiabetes.setBounds(767, 327, 133, 23);
		contentPane.add(rdbtnDiabetes);
		
		JRadioButton rdbtnAcidenteDeTrabalho = new JRadioButton("Acidente de Trabalho");
		rdbtnAcidenteDeTrabalho.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnAcidenteDeTrabalho.setBounds(541, 354, 173, 23);
		contentPane.add(rdbtnAcidenteDeTrabalho);
		
		JRadioButton rdbtnDoenaVascular = new JRadioButton("Doen\u00E7a Vascular");
		rdbtnDoenaVascular.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnDoenaVascular.setBounds(767, 354, 133, 23);
		contentPane.add(rdbtnDoenaVascular);
		
		JRadioButton rdbtnLesoPorArma = new JRadioButton("Les\u00E3o por Arma de Fogo");
		rdbtnLesoPorArma.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnLesoPorArma.setBounds(541, 380, 173, 23);
		contentPane.add(rdbtnLesoPorArma);
		
		JRadioButton rdbtnOsteossarcoma = new JRadioButton("Osteossarcoma");
		rdbtnOsteossarcoma.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnOsteossarcoma.setBounds(767, 380, 133, 23);
		contentPane.add(rdbtnOsteossarcoma);
		
		JRadioButton rdbtnOutra = new JRadioButton("Outra");
		rdbtnOutra.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnOutra.setBounds(541, 406, 173, 23);
		contentPane.add(rdbtnOutra);
		
		JRadioButton rdbtnOutra_1 = new JRadioButton("Outra");
		rdbtnOutra_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnOutra_1.setBounds(767, 406, 133, 23);
		contentPane.add(rdbtnOutra_1);
		
		JLabel lblLadoDaAmputao = new JLabel("Lado da Amputa\u00E7\u00E3o");
		lblLadoDaAmputao.setFont(new Font("Calibri", Font.BOLD, 20));
		lblLadoDaAmputao.setBounds(70, 476, 343, 37);
		contentPane.add(lblLadoDaAmputao);
		
		rdbtnTraumtica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnAdquirida.setSelected(false);
				rdbtnOutra_1.setSelected(false);
				rdbtnOsteossarcoma.setSelected(false);
				rdbtnDoenaVascular.setSelected(false);
				rdbtnDiabetes.setSelected(false);
				
			}
		});
		
		rdbtnAcidenteAutomobilistico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnAdquirida.setSelected(false);
				rdbtnOutra_1.setSelected(false);
				rdbtnOsteossarcoma.setSelected(false);
				rdbtnDoenaVascular.setSelected(false);
				rdbtnDiabetes.setSelected(false);
				rdbtnAcidenteDeTrabalho.setSelected(false);
				rdbtnOutra.setSelected(false);
				rdbtnLesoPorArma.setSelected(false);
				causa = "Traumática - Acidente Automobilistico";
				
			}
		});
		
		rdbtnAcidenteDeTrabalho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnAdquirida.setSelected(false);
				rdbtnOutra_1.setSelected(false);
				rdbtnOsteossarcoma.setSelected(false);
				rdbtnDoenaVascular.setSelected(false);
				rdbtnDiabetes.setSelected(false);
				rdbtnAcidenteAutomobilistico.setSelected(false);
				rdbtnOutra.setSelected(false);
				rdbtnLesoPorArma.setSelected(false);
				causa = "Traumática - Acidente de Trabalho";
				
			}
		});
		
		rdbtnLesoPorArma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnAdquirida.setSelected(false);
				rdbtnOutra_1.setSelected(false);
				rdbtnOsteossarcoma.setSelected(false);
				rdbtnDoenaVascular.setSelected(false);
				rdbtnDiabetes.setSelected(false);
				rdbtnAcidenteAutomobilistico.setSelected(false);
				rdbtnOutra.setSelected(false);
				rdbtnAcidenteDeTrabalho.setSelected(false);
				causa = "Traumática - Lesão por Arma de Fogo";
				
			}
		});
		
		rdbtnOutra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnAdquirida.setSelected(false);
				rdbtnOutra_1.setSelected(false);
				rdbtnOsteossarcoma.setSelected(false);
				rdbtnDoenaVascular.setSelected(false);
				rdbtnDiabetes.setSelected(false);
				rdbtnAcidenteAutomobilistico.setSelected(false);
				rdbtnLesoPorArma.setSelected(false);
				rdbtnAcidenteDeTrabalho.setSelected(false);
				causa = "Traumática - Outra Causa";
			
			}
		});
		
		rdbtnAdquirida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnTraumtica.setSelected(false);
				rdbtnAcidenteAutomobilistico.setSelected(false);
				rdbtnAcidenteDeTrabalho.setSelected(false);
				rdbtnOutra.setSelected(false);
				rdbtnLesoPorArma.setSelected(false);
				
			}
		});
		
		rdbtnDiabetes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnTraumtica.setSelected(false);
				rdbtnAcidenteAutomobilistico.setSelected(false);
				rdbtnAcidenteDeTrabalho.setSelected(false);
				rdbtnOutra.setSelected(false);
				rdbtnLesoPorArma.setSelected(false);
				rdbtnOutra_1.setSelected(false);
				rdbtnOsteossarcoma.setSelected(false);
				rdbtnDoenaVascular.setSelected(false);
				causa = "Adquirida - Diabetes";
			
			}
		});
		
		rdbtnDoenaVascular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnTraumtica.setSelected(false);
				rdbtnAcidenteAutomobilistico.setSelected(false);
				rdbtnAcidenteDeTrabalho.setSelected(false);
				rdbtnOutra.setSelected(false);
				rdbtnLesoPorArma.setSelected(false);
				rdbtnOutra_1.setSelected(false);
				rdbtnOsteossarcoma.setSelected(false);
				rdbtnDiabetes.setSelected(false);
				causa = "Adquirida - Doença Vascular";
			
			}
		});
		
		rdbtnOsteossarcoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnTraumtica.setSelected(false);
				rdbtnAcidenteAutomobilistico.setSelected(false);
				rdbtnAcidenteDeTrabalho.setSelected(false);
				rdbtnOutra.setSelected(false);
				rdbtnLesoPorArma.setSelected(false);
				rdbtnOutra_1.setSelected(false);
				rdbtnDoenaVascular.setSelected(false);
				rdbtnDiabetes.setSelected(false);
				causa = "Adquirida - Osteossarcoma";
			
			}
		});
		
		rdbtnOutra_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnTraumtica.setSelected(false);
				rdbtnAcidenteAutomobilistico.setSelected(false);
				rdbtnAcidenteDeTrabalho.setSelected(false);
				rdbtnOutra.setSelected(false);
				rdbtnLesoPorArma.setSelected(false);
				rdbtnOsteossarcoma.setSelected(false);
				rdbtnDoenaVascular.setSelected(false);
				rdbtnDiabetes.setSelected(false);
				causa = "Adquirida - Outra Causa";
			
			}
		});
		
		JRadioButton rdbtnDireito = new JRadioButton("Direito");
		rdbtnDireito.setForeground(Color.BLACK);
		rdbtnDireito.setFont(new Font("Calibri", Font.BOLD, 15));
		rdbtnDireito.setBounds(93, 531, 147, 23);
		contentPane.add(rdbtnDireito);
		
		JRadioButton rdbtnEsquerdo = new JRadioButton("Esquerdo");
		rdbtnEsquerdo.setForeground(Color.BLACK);
		rdbtnEsquerdo.setFont(new Font("Calibri", Font.BOLD, 15));
		rdbtnEsquerdo.setBounds(270, 531, 147, 23);
		contentPane.add(rdbtnEsquerdo);
		
		rdbtnDireito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnEsquerdo.setSelected(false);
				lado = "Direito";
			
			}
		});
		
		rdbtnEsquerdo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnDireito.setSelected(false);
				lado = "Esquerdo";
			
			}
		});
		
	}

}
