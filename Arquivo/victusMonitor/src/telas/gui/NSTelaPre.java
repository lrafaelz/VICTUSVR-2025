package telas.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class NSTelaPre extends JFrame {

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
					NSTelaPre frame = new NSTelaPre("","","",0);
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
	public NSTelaPre(String CPFrg, String NColetas, String TempoDeSessao,int sessaoid) {
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 621);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovaSessoDe = new JLabel("");
		lblNovaSessoDe.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\telapre.png"));
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNovaSessoDe.setBounds(464, 95, 414, 69);
		contentPane.add(lblNovaSessoDe);
		
		textField = new JTextField();
		textField.setBounds(423, 280, 256, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(423, 339, 256, 39);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(423, 399, 256, 39);
		contentPane.add(textField_2);
		
		JLabel lblFrequnciaCardaca = new JLabel("Frequ\u00EAncia Card\u00EDaca");
		lblFrequnciaCardaca.setForeground(Color.BLACK);
		lblFrequnciaCardaca.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblFrequnciaCardaca.setBounds(265, 285, 148, 27);
		contentPane.add(lblFrequnciaCardaca);
		
		JLabel lblFrequnciaRespiatria = new JLabel("Frequ\u00EAncia Respiat\u00F3ria");
		lblFrequnciaRespiatria.setForeground(Color.BLACK);
		lblFrequnciaRespiatria.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblFrequnciaRespiatria.setBounds(246, 351, 167, 27);
		contentPane.add(lblFrequnciaRespiatria);
		
		JLabel lblPressoArterial = new JLabel("Press\u00E3o Arterial");
		lblPressoArterial.setForeground(Color.BLACK);
		lblPressoArterial.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPressoArterial.setBounds(298, 411, 115, 27);
		contentPane.add(lblPressoArterial);
		
		JButton button = new JButton("Confirmar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String cardio = textField.getText();
				String resp = textField_1.getText();
				String arte = textField_2.getText();
				
				int cardioi = Integer.parseInt(cardio);
				
				ManipularBD mbd = new ManipularBD();
		        mbd.inserirColetas("00:00", 1, cardioi, resp, arte, sessaoid);
				
				NSTelaMonitoramento fr = new NSTelaMonitoramento(CPFrg, cardio, resp, arte, NColetas, TempoDeSessao,sessaoid);
				fr.setLocationRelativeTo(null);
				fr.setVisible(true);
				setVisible(false);
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Calibri", Font.PLAIN, 24));
		button.setBackground(Color.BLACK);
		button.setBounds(688, 501, 191, 49);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Voltar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				NSTelaBusca fr = new NSTelaBusca();
				fr.setVisible(true);
				setVisible(false);
			
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Calibri", Font.PLAIN, 24));
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(474, 501, 191, 49);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\logolaranja.png"));
		label.setBounds(128, 11, 326, 209);
		contentPane.add(label);
	}

}
