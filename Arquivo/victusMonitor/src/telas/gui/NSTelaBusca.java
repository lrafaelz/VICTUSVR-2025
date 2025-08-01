package telas.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class NSTelaBusca extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
    public String guardartexto;
    private JTextField textField_1;
    private JTextField textField_2;
    private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NSTelaBusca frame = new NSTelaBusca();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NSTelaBusca() {
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 621);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LocalDate data = LocalDate.now();
		String datases = data.toString();
		String[] conteudo = datases.split("-");
		String datarealizacao = conteudo[2] + "/" + conteudo[1] + "/" + conteudo[0];
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\novasesao.png"));
		label_1.setBounds(418, 103, 460, 95);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(139, 307, 297, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDigiteONome = new JLabel("Digite o CPF/RG do Paciente");
		lblDigiteONome.setForeground(Color.BLACK);
		lblDigiteONome.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDigiteONome.setBounds(157, 280, 226, 26);
		contentPane.add(lblDigiteONome);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String guardar = textField.getText();
				String profissional = textField_2.getText();
				String data = textField_1.getText();
				String senha = new String(passwordField.getPassword());
				//GerarArquivos x = new GerarArquivos();
				//x.gerarCsv(guardar, 1, "", "", "", "", "");
				NSTelaMostrarPaciente fr = new NSTelaMostrarPaciente(guardar, senha, profissional, data);
				fr.setLocationRelativeTo(null);
				fr.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnNewButton.setBounds(717, 500, 191, 49);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Tela1 fr = new Tela1();
				fr.setVisible(true);
				setVisible(false);
			
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setBounds(503, 500, 191, 49);
		contentPane.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\logolaranja.png"));
		label.setBounds(68, 32, 327, 200);
		contentPane.add(label);
		
		JLabel lblDigiteAData = new JLabel("Digite a Data");
		lblDigiteAData.setForeground(Color.BLACK);
		lblDigiteAData.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDigiteAData.setBounds(511, 280, 279, 26);
		contentPane.add(lblDigiteAData);
		
		textField_1 = new JTextField(datarealizacao);
		textField_1.setColumns(10);
		textField_1.setBounds(493, 307, 297, 39);
		contentPane.add(textField_1);
		
		JLabel lblDigiteOCpfrg = new JLabel("Digite o CPF/RG do Profissional");
		lblDigiteOCpfrg.setForeground(Color.BLACK);
		lblDigiteOCpfrg.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDigiteOCpfrg.setBounds(157, 365, 279, 26);
		contentPane.add(lblDigiteOCpfrg);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(139, 392, 297, 39);
		contentPane.add(textField_2);
		
		JLabel lblDigiteASenha = new JLabel("Digite a Senha");
		lblDigiteASenha.setForeground(Color.BLACK);
		lblDigiteASenha.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDigiteASenha.setBounds(511, 365, 279, 26);
		contentPane.add(lblDigiteASenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(496, 392, 294, 39);
		contentPane.add(passwordField);
	}
}
