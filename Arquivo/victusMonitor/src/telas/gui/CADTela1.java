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

public class CADTela1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CADTela1 frame = new CADTela1();
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
	public CADTela1() {
		setBackground(Color.WHITE);
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 621);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltarAoMenu = new JButton("Voltar");

		btnVoltarAoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Tela1 mr = new Tela1();
				mr.setLocationRelativeTo(null);
				mr.setVisible(true);
				setVisible(false);

			}
		});

		JLabel label = new JLabel("");
		label.setBackground(Color.WHITE);
		label.setIcon(new ImageIcon(
				"C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\logotela1.png"));
		label.setBounds(10, 21, 609, 522);
		contentPane.add(label);

		btnVoltarAoMenu.setForeground(Color.WHITE);
		btnVoltarAoMenu.setFont(new Font("Calibri", Font.BOLD, 24));
		btnVoltarAoMenu.setBackground(Color.BLACK);
		btnVoltarAoMenu.setBounds(661, 400, 230, 53);
		contentPane.add(btnVoltarAoMenu);

		JButton btnExcluirCadastro = new JButton("Excluir Cadastro");
		btnExcluirCadastro.setForeground(Color.WHITE);
		btnExcluirCadastro.setFont(new Font("Calibri", Font.BOLD, 24));
		btnExcluirCadastro.setBackground(Color.BLACK);
		btnExcluirCadastro.setBounds(646, 322, 230, 53);
		contentPane.add(btnExcluirCadastro);

		JButton btnBuscarCadastro = new JButton("Buscar Cadastro");

		btnBuscarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CADTelaBuscar rr = new CADTelaBuscar();
				rr.setLocationRelativeTo(null);
				rr.setVisible(true);
				setVisible(false);

			}
		});

		btnBuscarCadastro.setForeground(Color.WHITE);
		btnBuscarCadastro.setFont(new Font("Calibri", Font.BOLD, 24));
		btnBuscarCadastro.setBackground(Color.BLACK);
		btnBuscarCadastro.setBounds(646, 243, 230, 53);
		contentPane.add(btnBuscarCadastro);

		JButton btnNewButton = new JButton("Novo Cadastro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CADTelaNovaFicha rr = new CADTelaNovaFicha();
				rr.setLocationRelativeTo(null);
				rr.setVisible(true);
				setVisible(false);

			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 24));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(661, 163, 230, 53);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\teste3.png"));
		lblNewLabel.setBounds(158, 49, 761, 522);
		contentPane.add(lblNewLabel);
		// ImageIcon img = new ImageIcon("teste1.png");
		// JLabel label = new JLabel();
		// label.setIcon(teste1.png);
		// label.setBounds(100, 100, 450, 300);
	}
}
