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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RELBuscar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RELBuscar frame = new RELBuscar();
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
	public RELBuscar() {
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 658);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(207, 307, 616, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDigiteONome = new JLabel("Digite o Nome do Paciente");
		lblDigiteONome.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDigiteONome.setBounds(225, 280, 226, 26);
		contentPane.add(lblDigiteONome);
		
		JLabel lblNovaSessoDe = new JLabel("Relat\u00F3rios");
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNovaSessoDe.setBounds(630, 80, 373, 49);
		contentPane.add(lblNovaSessoDe);
		
		JButton btnNewButton = new JButton("Gerar PDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String guardar = textField.getText();
				//GerarRelatorios x = new GerarRelatorios();
				//x.GerarPdf(guardar);
				Tela1 fr = new Tela1();
				fr.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 153, 51));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnNewButton.setBounds(721, 416, 191, 49);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Tela1 fr = new Tela1();
				fr.setVisible(true);
				setVisible(false);
			
			}
		});
		btnVoltar.setForeground(new Color(255, 153, 51));
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setBounds(507, 416, 191, 49);
		contentPane.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(NSTelaBusca.class.getResource("/teste17.png")));
		label.setBounds(69, 26, 403, 200);
		contentPane.add(label);
		
		JLabel lblSeleoDo = new JLabel("- Sele\u00E7\u00E3o do Paciente -");
		lblSeleoDo.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblSeleoDo.setBounds(586, 114, 257, 54);
		contentPane.add(lblSeleoDo);
	}

}
