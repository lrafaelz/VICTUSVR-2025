package telas.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

public class NSTelaMostrarPaciente extends JFrame {

	private JPanel contentPane;
	String TempoDeSessao;
	String NColetas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NSTelaMostrarPaciente frame = new NSTelaMostrarPaciente("","","","");
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
	public NSTelaMostrarPaciente(String CpfRg, String Senha, String Profissional, String data) {
		
		
		int c;
		int b = 0;
		
		/*BuscarArquivosDeCadastros px = new BuscarArquivosDeCadastros();
		String conteudo = px.lerCadastro(CpfRg,1);
		BuscarArquivosDeCadastros pxx = new BuscarArquivosDeCadastros();
		String cadProfissional = pxx.lerCadastro(Profissional,2);*/
		
		ManipularBD px = new ManipularBD();
		String conteudo = px.buscarPaciente(CpfRg);
		ManipularBD pxx = new ManipularBD();
		String cadProfissional = pxx.buscarProfissional(Profissional);
		
		//if(conteudo == "x" || dadosProfissional[6] != Senha) {
			//System.out.println(conteudo);
			//MensagemErro er = new MensagemErro();
			//er.setVisible(true);
			//setVisible(false);
		//}
		
		if(conteudo == "Nao encontrado") {
			//System.out.println(conteudo);
			MensagemErro er = new MensagemErro();
			er.setVisible(true);
			setVisible(false);
		}
		
		if(cadProfissional == "x") {
			//System.out.println(conteudo);
			MensagemErro er = new MensagemErro();
			er.setVisible(true);
			setVisible(false);
		}
		
		String[] dados = conteudo.split(";");
		String[] dadosProfissional = cadProfissional.split(";");
		System.out.println(dadosProfissional[1]);
		//String[] s = dadosProfissional[6].split(" ");
		
		if(!Senha.equals(dadosProfissional[1])) {
			b = 1;
			System.out.println(b);
		}
		
		if(b == 1) {
			//System.out.println(conteudo);
			System.out.println(b);
			MensagemErro er = new MensagemErro();
			er.setVisible(true);
			setVisible(false);
		}
		
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 621);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovaSessoDe = new JLabel("");
		lblNovaSessoDe.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\nova.png"));
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNovaSessoDe.setBounds(461, 117, 404, 49);
		contentPane.add(lblNovaSessoDe);
		
		JButton btnNewButton = new JButton("Continuar");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//LocalTime horarioDeEntrada;
				LocalTime horarioDeEntrada = LocalTime.now();
				System.out.println(horarioDeEntrada); 
				String hora = horarioDeEntrada.toString();
				System.out.println(hora);
				System.out.println(CpfRg);
				System.out.println(Profissional);
				System.out.println(NColetas);
				System.out.println(TempoDeSessao);
				
				ManipularBD mbd = new ManipularBD();
		        int idsessao = mbd.inserirSessao(CpfRg, Profissional, data, hora, TempoDeSessao, NColetas);
		        System.out.println("Sessao id" + idsessao);
		        
				NSTelaPre fr = new NSTelaPre(CpfRg, NColetas, TempoDeSessao,idsessao);
				fr.setLocationRelativeTo(null);
				fr.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnNewButton.setBounds(721, 522, 191, 49);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				NSTelaBusca xp = new NSTelaBusca();
				xp.setVisible(true);
				setVisible(false);
			
			}
		});
		
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setBounds(520, 522, 191, 49);
		contentPane.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\logolaranja.png"));
		label.setBounds(131, 16, 288, 200);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(629, 252, 247, 241);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNenhuma = new JRadioButton("Nenhuma");
		rdbtnNenhuma.setForeground(Color.BLACK);
		rdbtnNenhuma.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnNenhuma.setBounds(70, 190, 109, 23);
		panel.add(rdbtnNenhuma);
		
		JRadioButton radioButton_5 = new JRadioButton("4");
		radioButton_5.setForeground(Color.BLACK);
		radioButton_5.setFont(new Font("Calibri", Font.PLAIN, 14));
		radioButton_5.setBounds(70, 169, 109, 23);
		panel.add(radioButton_5);
		
		JRadioButton rdbtnLivre_1 = new JRadioButton("Livre");
		rdbtnLivre_1.setForeground(Color.BLACK);
		rdbtnLivre_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnLivre_1.setBounds(70, 211, 109, 23);
		panel.add(rdbtnLivre_1);
		
		JLabel lblTempoDeSesso = new JLabel("Tempo de Sess\u00E3o");
		lblTempoDeSesso.setFont(new Font("Calibri", Font.BOLD, 16));
		lblTempoDeSesso.setForeground(Color.BLACK);
		lblTempoDeSesso.setBounds(10, 11, 130, 14);
		panel.add(lblTempoDeSesso);
		
		JRadioButton rdbtnMinutos = new JRadioButton("5 minutos");
		rdbtnMinutos.setForeground(Color.BLACK);
		rdbtnMinutos.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnMinutos.setBounds(6, 32, 109, 23);
		panel.add(rdbtnMinutos);
		
		JRadioButton radioButton = new JRadioButton("10 minutos");
		radioButton.setForeground(Color.BLACK);
		radioButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		radioButton.setBounds(6, 53, 109, 23);
		panel.add(radioButton);
		
		JRadioButton rdbtnMinutos_1 = new JRadioButton("15 minutos");
		rdbtnMinutos_1.setForeground(Color.BLACK);
		rdbtnMinutos_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnMinutos_1.setBounds(6, 75, 109, 23);
		panel.add(rdbtnMinutos_1);
		
		JRadioButton rdbtnMinutos_2 = new JRadioButton("20 minutos");
		rdbtnMinutos_2.setForeground(Color.BLACK);
		rdbtnMinutos_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnMinutos_2.setBounds(6, 99, 109, 23);
		panel.add(rdbtnMinutos_2);
		
		JRadioButton rdbtnLivre = new JRadioButton("Livre");
		rdbtnLivre.setForeground(Color.BLACK);
		rdbtnLivre.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnLivre.setBounds(6, 122, 109, 23);
		panel.add(rdbtnLivre);
		
		rdbtnMinutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				radioButton.setSelected(false);
				rdbtnMinutos_1.setSelected(false);
				rdbtnMinutos_2.setSelected(false);
				rdbtnLivre.setSelected(false);
				TempoDeSessao = "5";
				
			}
		});
		
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				rdbtnMinutos.setSelected(false);
				rdbtnMinutos_1.setSelected(false);
				rdbtnMinutos_2.setSelected(false);
				rdbtnLivre.setSelected(false);
				TempoDeSessao = "10";
				
			}
		});
		
		rdbtnMinutos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				rdbtnMinutos.setSelected(false);
				radioButton.setSelected(false);
				rdbtnMinutos_2.setSelected(false);
				rdbtnLivre.setSelected(false);
				TempoDeSessao = "15";
				
			}
		});
		
		rdbtnMinutos_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				rdbtnMinutos.setSelected(false);
				radioButton.setSelected(false);
				rdbtnMinutos_1.setSelected(false);
				rdbtnLivre.setSelected(false);
				TempoDeSessao = "20";
				
			}
		});
		
		rdbtnLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				rdbtnMinutos.setSelected(false);
				radioButton.setSelected(false);
				rdbtnMinutos_2.setSelected(false);
				rdbtnMinutos_1.setSelected(false);
				TempoDeSessao = "Livre";
				
			}
		});
		
		JLabel lblChecagemManual = new JLabel("N\u00FAmero de Coletas Manuais");
		lblChecagemManual.setForeground(Color.BLACK);
		lblChecagemManual.setFont(new Font("Calibri", Font.BOLD, 16));
		lblChecagemManual.setBounds(10, 148, 198, 14);
		panel.add(lblChecagemManual);
		
		JRadioButton radioButton_1 = new JRadioButton("1");
		radioButton_1.setForeground(Color.BLACK);
		radioButton_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		radioButton_1.setBounds(6, 169, 62, 23);
		panel.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("2");
		radioButton_2.setForeground(Color.BLACK);
		radioButton_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		radioButton_2.setBounds(6, 190, 50, 23);
		panel.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("3");
		radioButton_3.setForeground(Color.BLACK);
		radioButton_3.setFont(new Font("Calibri", Font.PLAIN, 14));
		radioButton_3.setBounds(6, 211, 50, 23);
		panel.add(radioButton_3);
		
		JLabel lblDadosDoPaciente = new JLabel("Dados do Paciente");
		lblDadosDoPaciente.setForeground(Color.BLACK);
		lblDadosDoPaciente.setFont(new Font("Arial", Font.BOLD, 18));
		lblDadosDoPaciente.setBounds(58, 237, 216, 30);
		contentPane.add(lblDadosDoPaciente);
		
		JLabel lblConfiguraoDaSesso = new JLabel("Configura\u00E7\u00E3o da Sess\u00E3o");
		lblConfiguraoDaSesso.setForeground(Color.BLACK);
		lblConfiguraoDaSesso.setFont(new Font("Arial", Font.BOLD, 18));
		lblConfiguraoDaSesso.setBounds(639, 221, 232, 30);
		contentPane.add(lblConfiguraoDaSesso);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 266, 561, 227);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFichaDoPaciente = new JLabel(dados[1]);
		lblFichaDoPaciente.setBounds(83, 0, 492, 37);
		panel_1.add(lblFichaDoPaciente);
		lblFichaDoPaciente.setForeground(Color.BLACK);
		lblFichaDoPaciente.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JLabel lblTipo = new JLabel(dados[2]);
		lblTipo.setBounds(83, 46, 527, 37);
		panel_1.add(lblTipo);
		lblTipo.setForeground(Color.BLACK);
		lblTipo.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JLabel lblLado = new JLabel(dados[3]);
		lblLado.setBounds(82, 93, 420, 37);
		panel_1.add(lblLado);
		lblLado.setForeground(Color.BLACK);
		lblLado.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JLabel lblCausa = new JLabel(dados[4]);
		lblCausa.setBounds(83, 137, 600, 37);
		panel_1.add(lblCausa);
		lblCausa.setForeground(Color.BLACK);
		lblCausa.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JLabel lblCpfrg = new JLabel(dados[0]);
		lblCpfrg.setBounds(83, 185, 264, 37);
		panel_1.add(lblCpfrg);
		lblCpfrg.setForeground(Color.BLACK);
		lblCpfrg.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JLabel lblNome = new JLabel("Nome -");
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Arial", Font.BOLD, 18));
		lblNome.setBounds(10, 2, 74, 30);
		panel_1.add(lblNome);
		
		JLabel lblNvel = new JLabel("N\u00EDvel -");
		lblNvel.setForeground(Color.BLACK);
		lblNvel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNvel.setBounds(10, 48, 74, 30);
		panel_1.add(lblNvel);
		
		JLabel lblCausa_1 = new JLabel("Causa -");
		lblCausa_1.setForeground(Color.BLACK);
		lblCausa_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblCausa_1.setBounds(10, 96, 74, 30);
		panel_1.add(lblCausa_1);
		
		JLabel lblLado_1 = new JLabel("Lado -");
		lblLado_1.setForeground(Color.BLACK);
		lblLado_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblLado_1.setBounds(10, 139, 74, 30);
		panel_1.add(lblLado_1);
		
		JLabel lblCpf = new JLabel("CPF -");
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("Arial", Font.BOLD, 18));
		lblCpf.setBounds(10, 187, 74, 30);
		panel_1.add(lblCpf);
		
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 radioButton_2.setSelected(false);
				 radioButton_3.setSelected(false);
				 rdbtnNenhuma.setSelected(false);
				 radioButton_5.setSelected(false);
				 rdbtnLivre_1.setSelected(false);
				NColetas = "1";
				
			}
		});
		
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 radioButton_1.setSelected(false);
				 radioButton_3.setSelected(false);
				 rdbtnNenhuma.setSelected(false);
				 radioButton_5.setSelected(false);
				 rdbtnLivre_1.setSelected(false);
				NColetas = "2";
				
			}
		});
		
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 radioButton_2.setSelected(false);
				 radioButton_1.setSelected(false);
				 rdbtnNenhuma.setSelected(false);
				 radioButton_5.setSelected(false);
				 rdbtnLivre_1.setSelected(false);
				NColetas = "3";
				
			}
		});
		
		rdbtnNenhuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 radioButton_2.setSelected(false);
				 radioButton_3.setSelected(false);
				 radioButton_1.setSelected(false);
				 radioButton_5.setSelected(false);
				 rdbtnLivre_1.setSelected(false);
				NColetas = "Nenhuma";
				
			}
		});
		
		radioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 radioButton_2.setSelected(false);
				 radioButton_3.setSelected(false);
				 rdbtnNenhuma.setSelected(false);
				 radioButton_1.setSelected(false);
				 rdbtnLivre_1.setSelected(false);
				NColetas = "4";
				
			}
		});
		
		rdbtnLivre_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 radioButton_2.setSelected(false);
				 radioButton_3.setSelected(false);
				 rdbtnNenhuma.setSelected(false);
				 radioButton_5.setSelected(false);
				 radioButton_1.setSelected(false);
				NColetas = "Livre";
				
			}
		});
		
		
		
	}
}
