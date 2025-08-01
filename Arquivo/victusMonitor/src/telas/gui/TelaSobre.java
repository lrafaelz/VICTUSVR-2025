package telas.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobre frame = new TelaSobre();
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
	public TelaSobre() {
		setBackground(Color.WHITE);
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 658);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Tela1 frame = new Tela1();
				frame.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnVoltar.setForeground(new Color(255, 153, 51));
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnVoltar.setBounds(830, 554, 155, 36);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaSobre.class.getResource("/SobreProjeto.png")));
		lblNewLabel.setBounds(38, 0, 1108, 619);
		contentPane.add(lblNewLabel);
	}
}
