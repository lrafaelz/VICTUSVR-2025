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

public class NSTelaPos extends JFrame {

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
					NSTelaPos frame = new NSTelaPos("","","","",0,0,0);
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
	public NSTelaPos(String cardioPre, String respPre, String artePre, String cpfrg, int BpmMax, float VelMax, int EmgMax) {
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 621);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovaSessoDe = new JLabel("");
		lblNovaSessoDe.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\telapos.png"));
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNovaSessoDe.setBounds(435, 115, 422, 62);
		contentPane.add(lblNovaSessoDe);
		
		textField = new JTextField();
		textField.setBounds(425, 281, 256, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(425, 340, 256, 39);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(425, 400, 256, 39);
		contentPane.add(textField_2);
		
		JLabel lblFrequnciaCardaca = new JLabel("Frequ\u00EAncia Card\u00EDaca");
		lblFrequnciaCardaca.setForeground(Color.BLACK);
		lblFrequnciaCardaca.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblFrequnciaCardaca.setBounds(267, 286, 148, 27);
		contentPane.add(lblFrequnciaCardaca);
		
		JLabel lblFrequnciaRespiatria = new JLabel("Frequ\u00EAncia Respiat\u00F3ria");
		lblFrequnciaRespiatria.setForeground(Color.BLACK);
		lblFrequnciaRespiatria.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblFrequnciaRespiatria.setBounds(248, 352, 167, 27);
		contentPane.add(lblFrequnciaRespiatria);
		
		JLabel lblPressoArterial = new JLabel("Press\u00E3o Arterial");
		lblPressoArterial.setForeground(Color.BLACK);
		lblPressoArterial.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPressoArterial.setBounds(300, 412, 115, 27);
		contentPane.add(lblPressoArterial);
		
		JButton button = new JButton("Confirmar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    
				String cardio = textField.getText();
				String resp = textField_1.getText();
				String arte = textField_2.getText();
				
				NSTelaResultados fr = new NSTelaResultados(cardioPre, respPre, artePre,cardio, resp, arte, cpfrg, BpmMax, VelMax, EmgMax);
				fr.setLocationRelativeTo(null);
				fr.setVisible(true);
				setVisible(false);
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Calibri", Font.PLAIN, 24));
		button.setBackground(Color.BLACK);
		button.setBounds(649, 501, 191, 49);
		contentPane.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\logolaranja.png"));
		label.setBounds(116, 11, 309, 209);
		contentPane.add(label);
	}


}
