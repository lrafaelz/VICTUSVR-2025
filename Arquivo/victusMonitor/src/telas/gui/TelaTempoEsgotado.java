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

public class TelaTempoEsgotado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTempoEsgotado frame = new TelaTempoEsgotado();
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
	public TelaTempoEsgotado() {
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovaSessoDe = new JLabel("O Tempo Programado para a Sess\u00E3o Esgotou!");
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNovaSessoDe.setBounds(68, 216, 397, 61);
		contentPane.add(lblNovaSessoDe);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\logolaranja.png"));
		label.setBounds(97, 5, 390, 200);
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
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(180, 288, 108, 31);
		contentPane.add(btnNewButton);
	}

}
