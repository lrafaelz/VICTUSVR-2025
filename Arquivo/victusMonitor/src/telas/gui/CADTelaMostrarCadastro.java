package telas.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CADTelaMostrarCadastro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CADTelaMostrarCadastro frame = new CADTelaMostrarCadastro("");
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
	public CADTelaMostrarCadastro(String cpfrg) {
		
		BuscarArquivosDeCadastros px = new BuscarArquivosDeCadastros();
		String conteudo = px.lerCadastro(cpfrg,1);
		
		if(conteudo == "x") {
			//System.out.println(conteudo);
			MensagemErro er = new MensagemErro();
			er.setVisible(true);
			setVisible(false);
		}
		
		String[] dados = conteudo.split(";");
		
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 658);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovaSessoDe = new JLabel("Cadastros");
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNovaSessoDe.setBounds(699, 55, 373, 49);
		contentPane.add(lblNovaSessoDe);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.setForeground(new Color(255, 153, 51));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnNewButton.setBounds(825, 532, 191, 49);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				CADTela1 xp = new CADTela1();
				xp.setVisible(true);
				setVisible(false);
			
			}
		});
		
		btnVoltar.setForeground(new Color(255, 153, 51));
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setBounds(611, 532, 191, 49);
		contentPane.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(NSTelaBusca.class.getResource("/teste17.png")));
		label.setBounds(69, 26, 403, 200);
		contentPane.add(label);
		
		JLabel lblSeleoDo = new JLabel("- Novo Paciente -");
		lblSeleoDo.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblSeleoDo.setBounds(678, 94, 257, 54);
		contentPane.add(lblSeleoDo);
		
		JLabel lblFichaDoPaciente = new JLabel(dados[0]);
		lblFichaDoPaciente.setFont(new Font("Calibri", Font.BOLD, 20));
		lblFichaDoPaciente.setBounds(42, 250, 492, 37);
		contentPane.add(lblFichaDoPaciente);
		
		JLabel lblDataDeNascimento = new JLabel(dados[1]);
		lblDataDeNascimento.setFont(new Font("Calibri", Font.BOLD, 20));
		lblDataDeNascimento.setBounds(578, 250, 543, 37);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblCpfrg = new JLabel(dados[2]);
		lblCpfrg.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCpfrg.setBounds(433, 295, 264, 37);
		contentPane.add(lblCpfrg);
		
		JLabel lblSexo = new JLabel(dados[8]);
		lblSexo.setFont(new Font("Calibri", Font.BOLD, 20));
		lblSexo.setBounds(42, 343, 229, 37);
		contentPane.add(lblSexo);
		
		JLabel lblAltura = new JLabel(dados[3]);
		lblAltura.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAltura.setBounds(42, 295, 321, 37);
		contentPane.add(lblAltura);
	
		JLabel lblPeso = new JLabel(dados[4]);
		lblPeso.setFont(new Font("Calibri", Font.BOLD, 20));
		lblPeso.setBounds(233, 295, 301, 37);
		contentPane.add(lblPeso);
		
		JLabel lblRegistro = new JLabel(dados[5]);
		lblRegistro.setFont(new Font("Calibri", Font.BOLD, 20));
		lblRegistro.setBounds(42, 391, 321, 37);
		contentPane.add(lblRegistro);
		
		JLabel lblTelefone = new JLabel(dados[6]);
		lblTelefone.setFont(new Font("Calibri", Font.BOLD, 20));
		lblTelefone.setBounds(233, 391, 328, 37);
		contentPane.add(lblTelefone);
		
		JLabel lblCor = new JLabel(dados[9]);
		lblCor.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCor.setBounds(281, 343, 348, 37);
		contentPane.add(lblCor);
		
		JLabel lblEmail = new JLabel(dados[7]);
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 20));
		lblEmail.setBounds(571, 391, 364, 37);
		contentPane.add(lblEmail);
		
		JLabel lblTipo = new JLabel(dados[10]);
		lblTipo.setFont(new Font("Calibri", Font.BOLD, 20));
		lblTipo.setBounds(42, 439, 527, 37);
		contentPane.add(lblTipo);
		
		JLabel lblLado = new JLabel(dados[12]);
		lblLado.setFont(new Font("Calibri", Font.BOLD, 20));
		lblLado.setBounds(42, 483, 420, 37);
		contentPane.add(lblLado);
		
		JLabel lblCausa = new JLabel(dados[11]);
		lblCausa.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCausa.setBounds(472, 483, 600, 37);
		contentPane.add(lblCausa);
		
		
		
	}

}
