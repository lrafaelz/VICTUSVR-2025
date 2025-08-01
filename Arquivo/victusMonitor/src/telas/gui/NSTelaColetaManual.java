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

public class NSTelaColetaManual extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NSTelaColetaManual frame = new NSTelaColetaManual("","");
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
	public NSTelaColetaManual(String cpfrg, String tempo) {
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 658);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovaSessoDe = new JLabel("");
		lblNovaSessoDe.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\coletamanul.png"));
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNovaSessoDe.setBounds(99, 231, 423, 68);
		contentPane.add(lblNovaSessoDe);
		
		textField = new JTextField();
		textField.setBounds(305, 328, 115, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(305, 380, 115, 39);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(305, 430, 115, 39);
		contentPane.add(textField_2);
		
		JLabel lblFrequnciaCardaca = new JLabel("Frequ\u00EAncia Card\u00EDaca");
		lblFrequnciaCardaca.setForeground(Color.BLACK);
		lblFrequnciaCardaca.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblFrequnciaCardaca.setBounds(133, 333, 148, 27);
		contentPane.add(lblFrequnciaCardaca);
		
		JLabel lblFrequnciaRespiatria = new JLabel("Frequ\u00EAncia Respiat\u00F3ria");
		lblFrequnciaRespiatria.setForeground(Color.BLACK);
		lblFrequnciaRespiatria.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblFrequnciaRespiatria.setBounds(114, 385, 167, 27);
		contentPane.add(lblFrequnciaRespiatria);
		
		JLabel lblPressoArterial = new JLabel("Press\u00E3o Arterial");
		lblPressoArterial.setForeground(Color.BLACK);
		lblPressoArterial.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPressoArterial.setBounds(166, 435, 115, 27);
		contentPane.add(lblPressoArterial);
		
		JButton button = new JButton("Confirmar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String cardio = textField.getText();
				String resp = textField_1.getText();
				String arte = textField_2.getText();
				GerarColetaManual fr = new GerarColetaManual();
				fr.gerarCsv(cpfrg,tempo,cardio,resp,arte);
				//NSTelaMonitoramento fr = new NSTelaMonitoramento();
				//fr.setVisible(true);
				setVisible(false);
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Calibri", Font.PLAIN, 24));
		button.setBackground(Color.BLACK);
		button.setBounds(305, 524, 148, 49);
		contentPane.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\logolaranja.png"));
		label.setBounds(147, 11, 390, 209);
		contentPane.add(label);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				setVisible(false);
				
			}
		});
		
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(Color.BLACK);
		btnCancelar.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnCancelar.setBounds(133, 524, 138, 49);
		contentPane.add(btnCancelar);
	}
}
