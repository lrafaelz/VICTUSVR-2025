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

public class TelaEncerrando extends JFrame {

	private JPanel contentPane;
	public int ret;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEncerrando frame = new TelaEncerrando();
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
	public TelaEncerrando() {
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovaSessoDe = new JLabel("O Tempo Programado para a Sess\u00E3o Ainda N\u00E3o Acabou!");
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNovaSessoDe.setBounds(32, 213, 455, 61);
		contentPane.add(lblNovaSessoDe);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(NSTelaPre.class.getResource("/teste17.png")));
		label.setBounds(58, 0, 390, 200);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("SIM");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ret = 1;
				TelaObsEncerrar fr = new TelaObsEncerrar();
				fr.setVisible(true);
				setVisible(false);
			}
		});
		
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(255, 153, 51));
		btnNewButton.setBounds(103, 303, 108, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblDesejaEncerrarA = new JLabel("Deseja Encerrar a Sess\u00E3o Mesmo Assim?");
		lblDesejaEncerrarA.setForeground(Color.BLACK);
		lblDesejaEncerrarA.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDesejaEncerrarA.setBounds(81, 246, 383, 61);
		contentPane.add(lblDesejaEncerrarA);
		
		JButton btnNo = new JButton("N\u00C3O");
		
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				setVisible(false);
				
			}
		});
		
		btnNo.setForeground(new Color(255, 153, 51));
		btnNo.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnNo.setBackground(Color.BLACK);
		btnNo.setBounds(239, 303, 108, 31);
		contentPane.add(btnNo);
	}

	public int retorno() {
		System.out.println(3);
		System.out.println(ret);
		return ret;
	}
	
}
