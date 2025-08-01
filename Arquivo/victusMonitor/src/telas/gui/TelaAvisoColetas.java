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

public class TelaAvisoColetas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAvisoColetas frame = new TelaAvisoColetas("","");
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
	public TelaAvisoColetas(String cpfrg, String tempo) {
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovaSessoDe = new JLabel("O n\u00FAmero de coletas manuais programadas j\u00E1 foi alcan\u00E7ado!");
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNovaSessoDe.setBounds(10, 196, 477, 61);
		contentPane.add(lblNovaSessoDe);
		
		JLabel lblDadosPr = new JLabel("Deseja continuar mesmo assim?");
		lblDadosPr.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDadosPr.setForeground(Color.BLACK);
		lblDadosPr.setBounds(115, 238, 333, 39);
		contentPane.add(lblDadosPr);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(NSTelaPre.class.getResource("/teste17.png")));
		label.setBounds(58, 0, 390, 200);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("SIM");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				NSTelaColetaManual fr = new NSTelaColetaManual(cpfrg, tempo);
				fr.setVisible(true);
				setVisible(false);
			}
		});
		
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(255, 153, 51));
		btnNewButton.setBounds(108, 288, 108, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNo = new JButton("N\u00C3O");
		
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				setVisible(false);
				
			}
		});
		
		btnNo.setForeground(new Color(255, 153, 51));
		btnNo.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnNo.setBackground(Color.BLACK);
		btnNo.setBounds(246, 288, 108, 31);
		contentPane.add(btnNo);
	}
}
