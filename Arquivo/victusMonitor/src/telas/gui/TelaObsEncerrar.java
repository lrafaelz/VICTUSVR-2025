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
import javax.swing.JTextArea;

public class TelaObsEncerrar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaObsEncerrar frame = new TelaObsEncerrar();
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
	public TelaObsEncerrar() {
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 507);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovaSessoDe = new JLabel("Informe o Motivo do Encerramento da Sess\u00E3o:");
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNovaSessoDe.setBounds(58, 224, 390, 45);
		contentPane.add(lblNovaSessoDe);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(NSTelaPre.class.getResource("/teste17.png")));
		label.setBounds(58, 0, 390, 200);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Encerrar");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//NSTelaColetaManual fr = new NSTelaColetaManual(cpfrg, tempo);
				//fr.setVisible(true);
				setVisible(false);
			}
		});
		
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(255, 153, 51));
		btnNewButton.setBounds(175, 409, 108, 31);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 153, 51));
		textArea.setBounds(42, 269, 406, 114);
		contentPane.add(textArea);
	}
}
