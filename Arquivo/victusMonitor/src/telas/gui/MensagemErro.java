package telas.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MensagemErro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MensagemErro frame = new MensagemErro();
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
	public MensagemErro() {
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovaSessoDe = new JLabel("Paciente N\u00E3o Cadastrado!");
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNovaSessoDe.setBounds(51, 203, 339, 39);
		contentPane.add(lblNovaSessoDe);
		
		JLabel lblDadosPr = new JLabel("Digite um Novo Nome ou");
		lblDadosPr.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDadosPr.setForeground(Color.BLACK);
		lblDadosPr.setBounds(86, 233, 333, 39);
		contentPane.add(lblDadosPr);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(NSTelaPre.class.getResource("/teste17.png")));
		label.setBounds(0, 0, 390, 200);
		contentPane.add(label);
		
		JLabel lblCadastreUmNovo = new JLabel("Cadastre um Novo Paciente");
		lblCadastreUmNovo.setForeground(Color.BLACK);
		lblCadastreUmNovo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCadastreUmNovo.setBounds(78, 264, 266, 30);
		contentPane.add(lblCadastreUmNovo);
		
		JButton btnNewButton = new JButton("OK");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				setVisible(false);
			}
		});
		
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(255, 153, 51));
		btnNewButton.setBounds(131, 305, 108, 31);
		contentPane.add(btnNewButton);
	}
}
