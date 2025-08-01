package telas.gui;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NSTelaResultados extends JFrame {

	private JPanel contentPane;
    public String guardartexto;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    private JTextField textField_16;
    private JTextField textField_17;
    private JTextField textField_18;
    private JTextField textField_19;
    private JTextField textField_20;
    private JTextField textField_21;
    private JTextField textField_22;
    private JTextField textField_23;
    private JLabel lblBpm;
    private JLabel lblDistncia;
    private JLabel lblVelocidade;
    private JLabel lblEmg;
    private JTextField textField_24;
    private JTextField textField_25;
    private JTextField textField_26;
    private JTextField textField_27;
    private JTextField textField_28;
    private JTextField textField_29;
    private JTextField textField_30;
    private JTextField textField_31;
    private JTextField textField_32;
    private JTextField textField_33;
    private JTextField textField_34;
    private JTextField textField_35;
    private JTextField textField_36;
    private JTextField textField_37;
    private JTextField textField_38;
    private JTextField textField_39;
    private JTextField textField_40;
    private JTextField textField_41;
    private JTextField textField_42;
    private JTextField textField_43;
    private JTextField textField_44;
    private JTextField textField_45;
    private JTextField textField_46;
    private JTextField textField_47;
    private JTextField textField_48;
    private JTextField textField_49;
    private JTextField textField_50;
    private JTextField textField_51;
    private JTextField textField_52;
    private JTextField textField_53;
    private JTextField textField_54;
    private JTextField textField_55;
    private JTextField textField_56;
    private JTextField textField_57;
    private JTextField textField_58;
    private JTextField textField_59;
    private JTextField textField_60;
    private JTextField textField_61;
    private JTextField textField_62;
    private JTextField textField_63;
    private JTextField textField_64;
    private JTextField textField_65;
    private JTextField textField_66;
    private JTextField textField_67;
    private JTextField textField_68;
    private JTextField textField_69;
    private JTextField textField_70;
    private JTextField textField_71;
    private JLabel lblParcial;
    private JLabel lblParcial_1;
    private JLabel lblParcial_2;
    private JLabel lblParcial_3;
    private JLabel lblParcial_4;
    private JLabel lblParcial_5;
    private JLabel lblParcial_6;
    private JLabel lblParcial_7;
    private JLabel lblParcial_8;
    private JLabel lblParcial_9;
    private JLabel lblParcial_10;
    private JLabel lblParcial_11;
    private JLabel lblParcial_12;
    private JLabel lblParcial_13;
    private JLabel lblParcial_14;
    private JButton btnFinalizar;
    String[] parcial = new String[240];
    String[] dado = new String[20];
    private JTextField textField_72;
    private JTextField textField_73;
    private JTextField textField_74;
    private JTextField textField_75;
    private JTextField textField_76;
    private JTextField textField_77;
    private JTextField textField_78;
    private JTextField textField_79;
    private JTextField textField_80;
    private JTextField textField_81;
    private JTextField textField_82;
    private JTextField textField_83;
    private JTextField textField_84;
    private JTextField textField_85;
    private JTextField textField_86;
    private JTextField textField_87;
    private JTextField textField_88;
  //  public String colunas[]={" ", "Pré Sessão","Coleta Manula 1","Coleta Manual 2", "Coleta Manual 3", "Pós Sessão"};
    //public String dados[][]={
    //{"Frequência Cardíaca","19","Masculino", "0", "1" , "4"},
    //{"Freequência Respiratória", "0", "1", "1"},
    //{"Pressão Arterial","34","Feminino", "0", "1", "14"},
    //};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NSTelaResultados frame = new NSTelaResultados("","","","","","","",0,0,0);
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
	public NSTelaResultados(String cardioPre, String respPre, String artePre, String cardio, String resp, String arte, String cpfrg, 
							int BpmMax, float VelMax, int EmgMax) {
		
		String BpmMaxs = Integer.toString(BpmMax);
		String EmgMaxs = Integer.toString(EmgMax);
		String VelMaxs = Float.toString(VelMax);
		
		GerarArquivosDeParciais xrr = new GerarArquivosDeParciais();
		String conteudo = xrr.lerCsv(cpfrg);
		System.out.println(conteudo);
		String[] parciais = conteudo.split(";");
		/*System.out.println(parcial[0]);
		System.out.println(parcial[1]);
		System.out.println(parcial[2]);
		System.out.println(parcial[3]);
		System.out.println(parcial[4]);
		System.out.println(parcial[5]);
		System.out.println(parcial[6]);*/
		
		int tamanho = parciais.length;
		for (int fff = 0 ; fff < tamanho; fff++) {
			parcial[fff] = parciais[fff];
		}
		System.out.println(tamanho);
		String tam = Integer.toString(tamanho);
		
		for (int cont = tamanho ; cont < 240; cont ++) {
			parcial[cont] = "000";
		}
		// tem q pegar o numero de textefield, pegar sempre a parcial
		// e a partir dai ir colocando como vazio
		
		GerarColetaManual xfr = new GerarColetaManual();
		String coletas = xfr.lerCsv(cpfrg);
		System.out.println(coletas);
		String[] dados = coletas.split(";");
		int TAM = dados.length;
		for (int ff = 0 ; ff < TAM; ff++) {
			dado[ff] = dados[ff];
		}
		System.out.println(TAM);
		//String tamm = Integer.toString(tamanho);
		
		for (int cont2 = TAM ; cont2 < 20; cont2 ++) {
			dado[cont2] = "000";
		}
		
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 658);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNovaSessoDe = new JLabel("");
		lblNovaSessoDe.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\resultados.png"));
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNovaSessoDe.setBounds(368, 82, 262, 87);
		contentPane.add(lblNovaSessoDe);
		
		JButton btnNewButton = new JButton("Indicadores");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				
			}
		});
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnNewButton.setBounds(606, 544, 191, 49);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Gr\u00E1ficos");
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				NSTelaGraficos fr = new NSTelaGraficos(parcial,tam);
				fr.setLocationRelativeTo(null);
				fr.setVisible(true);
				setVisible(false);
			
			}
		});
		
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setBounds(361, 544, 191, 49);
		contentPane.add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\logolaranja.png"));
		label.setBounds(46, 11, 323, 200);
		contentPane.add(label);
		
		JLabel lblPrSesso = new JLabel("Pr\u00E9 Sess\u00E3o");
		lblPrSesso.setBounds(179, 253, 74, 14);
		contentPane.add(lblPrSesso);
		
		textField = new JTextField(cardioPre);
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(167, 267, 86, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(respPre);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setBounds(167, 294, 86, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(artePre);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setBounds(167, 320, 86, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFrequnciaCardaca = new JLabel("Frequ\u00EAncia Card\u00EDaca");
		lblFrequnciaCardaca.setFont(new Font("Calibri", Font.BOLD, 12));
		lblFrequnciaCardaca.setForeground(Color.BLACK);
		lblFrequnciaCardaca.setBounds(36, 273, 121, 14);
		contentPane.add(lblFrequnciaCardaca);
		
		JLabel lblFrequnciaRespiratria = new JLabel("Frequ\u00EAncia Respirat\u00F3ria");
		lblFrequnciaRespiratria.setForeground(Color.BLACK);
		lblFrequnciaRespiratria.setFont(new Font("Calibri", Font.BOLD, 12));
		lblFrequnciaRespiratria.setBounds(10, 300, 147, 14);
		contentPane.add(lblFrequnciaRespiratria);
		
		JLabel lblPressoArterial = new JLabel("Press\u00E3o Arterial");
		lblPressoArterial.setForeground(Color.BLACK);
		lblPressoArterial.setFont(new Font("Calibri", Font.BOLD, 12));
		lblPressoArterial.setBounds(51, 326, 106, 14);
		contentPane.add(lblPressoArterial);
		
		
		
		textField_3 = new JTextField(dado[1]);
		textField_3.setBounds(170, 385, 86, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField(dado[2]);
		textField_4.setBounds(170, 412, 86, 27);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField(dado[3]);
		textField_5.setBounds(170, 438, 86, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblColeta = new JLabel("Coleta 1");
		lblColeta.setBounds(192, 371, 64, 14);
		contentPane.add(lblColeta);
		
		textField_6 = new JTextField(dado[5]);
		textField_6.setBounds(255, 385, 86, 27);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField(dado[6]);
		textField_7.setBounds(255, 412, 86, 27);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField(dado[7]);
		textField_8.setBounds(255, 438, 86, 27);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField(cardio);
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_9.setBounds(255, 267, 86, 27);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField(arte);
		textField_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_10.setBounds(255, 320, 86, 27);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField(resp);
		textField_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_11.setBounds(255, 294, 86, 27);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblColeta_1 = new JLabel("Coleta 2");
		lblColeta_1.setBounds(274, 371, 55, 14);
		contentPane.add(lblColeta_1);
		
		JLabel lblPsSesso = new JLabel("P\u00F3s Sess\u00E3o");
		lblPsSesso.setBounds(266, 253, 81, 14);
		contentPane.add(lblPsSesso);
		
		textField_12 = new JTextField(parcial[1]);
		textField_12.setColumns(10);
		textField_12.setBounds(812, 49, 86, 27);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField(parcial[0]);
		textField_13.setColumns(10);
		textField_13.setBounds(727, 49, 86, 27);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField(parcial[4]);
		textField_14.setColumns(10);
		textField_14.setBounds(727, 76, 86, 27);
		contentPane.add(textField_14);
		
		textField_15 = new JTextField(parcial[8]);
		textField_15.setColumns(10);
		textField_15.setBounds(727, 102, 86, 27);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField(parcial[9]);
		textField_16.setColumns(10);
		textField_16.setBounds(812, 102, 86, 27);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField(parcial[5]);
		textField_17.setColumns(10);
		textField_17.setBounds(812, 76, 86, 27);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField(parcial[6]);
		textField_18.setColumns(10);
		textField_18.setBounds(897, 76, 86, 27);
		contentPane.add(textField_18);
		
		textField_19 = new JTextField(parcial[2]);
		textField_19.setColumns(10);
		textField_19.setBounds(897, 49, 86, 27);
		contentPane.add(textField_19);
		
		textField_20 = new JTextField(parcial[3]);
		textField_20.setColumns(10);
		textField_20.setBounds(981, 49, 86, 27);
		contentPane.add(textField_20);
		
		textField_21 = new JTextField(parcial[7]);
		textField_21.setColumns(10);
		textField_21.setBounds(981, 76, 86, 27);
		contentPane.add(textField_21);
		
		textField_22 = new JTextField(parcial[10]);
		textField_22.setBounds(897, 102, 86, 27);
		contentPane.add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField(parcial[11]);
		textField_23.setBounds(981, 102, 86, 27);
		contentPane.add(textField_23);
		textField_23.setColumns(10);
		
		lblBpm = new JLabel("BPM");
		lblBpm.setFont(new Font("Arial", Font.BOLD, 12));
		lblBpm.setBounds(751, 30, 46, 14);
		contentPane.add(lblBpm);
		
		lblDistncia = new JLabel("Dist\u00E2ncia");
		lblDistncia.setFont(new Font("Arial", Font.BOLD, 12));
		lblDistncia.setBounds(825, 30, 64, 14);
		contentPane.add(lblDistncia);
		
		lblVelocidade = new JLabel("Velocidade");
		lblVelocidade.setFont(new Font("Arial", Font.BOLD, 12));
		lblVelocidade.setBounds(910, 30, 64, 14);
		contentPane.add(lblVelocidade);
		
		lblEmg = new JLabel("EMG");
		lblEmg.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmg.setBounds(1003, 30, 55, 14);
		contentPane.add(lblEmg);
		
		textField_24 = new JTextField(parcial[13]);
		textField_24.setColumns(10);
		textField_24.setBounds(812, 126, 86, 27);
		contentPane.add(textField_24);
		
		textField_25 = new JTextField(parcial[12]);
		textField_25.setColumns(10);
		textField_25.setBounds(727, 126, 86, 27);
		contentPane.add(textField_25);
		
		textField_26 = new JTextField(parcial[16]);
		textField_26.setColumns(10);
		textField_26.setBounds(727, 153, 86, 27);
		contentPane.add(textField_26);
		
		textField_27 = new JTextField(parcial[20]);
		textField_27.setColumns(10);
		textField_27.setBounds(727, 179, 86, 27);
		contentPane.add(textField_27);
		
		textField_28 = new JTextField(parcial[21]);
		textField_28.setColumns(10);
		textField_28.setBounds(812, 179, 86, 27);
		contentPane.add(textField_28);
		
		textField_29 = new JTextField(parcial[17]);
		textField_29.setColumns(10);
		textField_29.setBounds(812, 153, 86, 27);
		contentPane.add(textField_29);
		
		textField_30 = new JTextField(parcial[14]);
		textField_30.setColumns(10);
		textField_30.setBounds(897, 126, 86, 27);
		contentPane.add(textField_30);
		
		textField_31 = new JTextField(parcial[18]);
		textField_31.setColumns(10);
		textField_31.setBounds(897, 153, 86, 27);
		contentPane.add(textField_31);
		
		textField_32 = new JTextField(parcial[22]);
		textField_32.setColumns(10);
		textField_32.setBounds(897, 179, 86, 27);
		contentPane.add(textField_32);
		
		textField_33 = new JTextField(parcial[23]);
		textField_33.setColumns(10);
		textField_33.setBounds(981, 179, 86, 27);
		contentPane.add(textField_33);
		
		textField_34 = new JTextField(parcial[19]);
		textField_34.setColumns(10);
		textField_34.setBounds(981, 153, 86, 27);
		contentPane.add(textField_34);
		
		textField_35 = new JTextField(parcial[15]);
		textField_35.setColumns(10);
		textField_35.setBounds(981, 126, 86, 27);
		contentPane.add(textField_35);
		
		textField_36 = new JTextField(parcial[25]);
		textField_36.setColumns(10);
		textField_36.setBounds(812, 201, 86, 27);
		contentPane.add(textField_36);
		
		textField_37 = new JTextField(parcial[24]);
		textField_37.setColumns(10);
		textField_37.setBounds(727, 201, 86, 27);
		contentPane.add(textField_37);
		
		textField_38 = new JTextField(parcial[28]);
		textField_38.setColumns(10);
		textField_38.setBounds(727, 228, 86, 27);
		contentPane.add(textField_38);
		
		textField_39 = new JTextField(parcial[32]);
		textField_39.setColumns(10);
		textField_39.setBounds(727, 254, 86, 27);
		contentPane.add(textField_39);
		
		textField_40 = new JTextField(parcial[33]);
		textField_40.setColumns(10);
		textField_40.setBounds(812, 254, 86, 27);
		contentPane.add(textField_40);
		
		textField_41 = new JTextField(parcial[29]);
		textField_41.setColumns(10);
		textField_41.setBounds(812, 228, 86, 27);
		contentPane.add(textField_41);
		
		textField_42 = new JTextField(parcial[26]);
		textField_42.setColumns(10);
		textField_42.setBounds(897, 201, 86, 27);
		contentPane.add(textField_42);
		
		textField_43 = new JTextField(parcial[30]);
		textField_43.setColumns(10);
		textField_43.setBounds(897, 228, 86, 27);
		contentPane.add(textField_43);
		
		textField_44 = new JTextField(parcial[34]);
		textField_44.setColumns(10);
		textField_44.setBounds(897, 254, 86, 27);
		contentPane.add(textField_44);
		
		textField_45 = new JTextField(parcial[35]);
		textField_45.setColumns(10);
		textField_45.setBounds(981, 254, 86, 27);
		contentPane.add(textField_45);
		
		textField_46 = new JTextField(parcial[31]);
		textField_46.setColumns(10);
		textField_46.setBounds(981, 228, 86, 27);
		contentPane.add(textField_46);
		
		textField_47 = new JTextField(parcial[27]);
		textField_47.setColumns(10);
		textField_47.setBounds(981, 201, 86, 27);
		contentPane.add(textField_47);
		
		textField_48 = new JTextField(parcial[37]);
		textField_48.setColumns(10);
		textField_48.setBounds(812, 281, 86, 27);
		contentPane.add(textField_48);
		
		textField_49 = new JTextField(parcial[36]);
		textField_49.setColumns(10);
		textField_49.setBounds(727, 281, 86, 27);
		contentPane.add(textField_49);
		
		textField_50 = new JTextField(parcial[40]);
		textField_50.setColumns(10);
		textField_50.setBounds(727, 308, 86, 27);
		contentPane.add(textField_50);
		
		textField_51 = new JTextField(parcial[44]);
		textField_51.setColumns(10);
		textField_51.setBounds(727, 334, 86, 27);
		contentPane.add(textField_51);
		
		textField_52 = new JTextField(parcial[45]);
		textField_52.setColumns(10);
		textField_52.setBounds(812, 334, 86, 27);
		contentPane.add(textField_52);
		
		textField_53 = new JTextField(parcial[41]);
		textField_53.setColumns(10);
		textField_53.setBounds(812, 308, 86, 27);
		contentPane.add(textField_53);
		
		textField_54 = new JTextField(parcial[38]);
		textField_54.setColumns(10);
		textField_54.setBounds(897, 281, 86, 27);
		contentPane.add(textField_54);
		
		textField_55 = new JTextField(parcial[42]);
		textField_55.setColumns(10);
		textField_55.setBounds(897, 308, 86, 27);
		contentPane.add(textField_55);
		
		textField_56 = new JTextField(parcial[46]);
		textField_56.setColumns(10);
		textField_56.setBounds(897, 334, 86, 27);
		contentPane.add(textField_56);
		
		textField_57 = new JTextField(parcial[47]);
		textField_57.setColumns(10);
		textField_57.setBounds(981, 334, 86, 27);
		contentPane.add(textField_57);
		
		textField_58 = new JTextField(parcial[43]);
		textField_58.setColumns(10);
		textField_58.setBounds(981, 308, 86, 27);
		contentPane.add(textField_58);
		
		textField_59 = new JTextField(parcial[39]);
		textField_59.setColumns(10);
		textField_59.setBounds(981, 281, 86, 27);
		contentPane.add(textField_59);
		
		textField_60 = new JTextField(parcial[49]);
		textField_60.setColumns(10);
		textField_60.setBounds(812, 359, 86, 27);
		contentPane.add(textField_60);
		
		textField_61 = new JTextField(parcial[48]);
		textField_61.setColumns(10);
		textField_61.setBounds(727, 359, 86, 27);
		contentPane.add(textField_61);
		
		textField_62 = new JTextField(parcial[52]);
		textField_62.setColumns(10);
		textField_62.setBounds(727, 386, 86, 27);
		contentPane.add(textField_62);
		
		textField_63 = new JTextField(parcial[56]);
		textField_63.setColumns(10);
		textField_63.setBounds(727, 412, 86, 27);
		contentPane.add(textField_63);
		
		textField_64 = new JTextField(parcial[57]);
		textField_64.setColumns(10);
		textField_64.setBounds(812, 412, 86, 27);
		contentPane.add(textField_64);
		
		textField_65 = new JTextField(parcial[53]);
		textField_65.setColumns(10);
		textField_65.setBounds(812, 386, 86, 27);
		contentPane.add(textField_65);
		
		textField_66 = new JTextField(parcial[50]);
		textField_66.setColumns(10);
		textField_66.setBounds(897, 359, 86, 27);
		contentPane.add(textField_66);
		
		textField_67 = new JTextField(parcial[54]);
		textField_67.setColumns(10);
		textField_67.setBounds(897, 386, 86, 27);
		contentPane.add(textField_67);
		
		textField_68 = new JTextField(parcial[58]);
		textField_68.setColumns(10);
		textField_68.setBounds(897, 412, 86, 27);
		contentPane.add(textField_68);
		
		textField_69 = new JTextField(parcial[59]);
		textField_69.setColumns(10);
		textField_69.setBounds(981, 412, 86, 27);
		contentPane.add(textField_69);
		
		textField_70 = new JTextField(parcial[55]);
		textField_70.setColumns(10);
		textField_70.setBounds(981, 386, 86, 27);
		contentPane.add(textField_70);
		
		textField_71 = new JTextField(parcial[51]);
		textField_71.setColumns(10);
		textField_71.setBounds(981, 359, 86, 27);
		contentPane.add(textField_71);
		
		lblParcial = new JLabel("Parcial 1");
		lblParcial.setBounds(663, 55, 64, 14);
		contentPane.add(lblParcial);
		
		lblParcial_1 = new JLabel("Parcial 2");
		lblParcial_1.setBounds(663, 82, 64, 14);
		contentPane.add(lblParcial_1);
		
		lblParcial_2 = new JLabel("Parcial 3");
		lblParcial_2.setBounds(663, 108, 64, 14);
		contentPane.add(lblParcial_2);
		
		lblParcial_3 = new JLabel("Parcial 4");
		lblParcial_3.setBounds(663, 132, 64, 14);
		contentPane.add(lblParcial_3);
		
		lblParcial_4 = new JLabel("Parcial 5");
		lblParcial_4.setBounds(663, 159, 64, 14);
		contentPane.add(lblParcial_4);
		
		lblParcial_5 = new JLabel("Parcial 6");
		lblParcial_5.setBounds(663, 185, 64, 14);
		contentPane.add(lblParcial_5);
		
		lblParcial_6 = new JLabel("Parcial 7");
		lblParcial_6.setBounds(663, 208, 64, 19);
		contentPane.add(lblParcial_6);
		
		lblParcial_7 = new JLabel("Parcial 8");
		lblParcial_7.setBounds(663, 228, 64, 27);
		contentPane.add(lblParcial_7);
		
		lblParcial_8 = new JLabel("Parcial 9");
		lblParcial_8.setBounds(663, 261, 64, 14);
		contentPane.add(lblParcial_8);
		
		lblParcial_9 = new JLabel("Parcial 10");
		lblParcial_9.setBounds(663, 287, 64, 14);
		contentPane.add(lblParcial_9);
		
		lblParcial_10 = new JLabel("Parcial 11");
		lblParcial_10.setBounds(663, 308, 64, 27);
		contentPane.add(lblParcial_10);
		
		lblParcial_11 = new JLabel("Parcial 12");
		lblParcial_11.setBounds(663, 334, 64, 27);
		contentPane.add(lblParcial_11);
		
		lblParcial_12 = new JLabel("Parcial 13");
		lblParcial_12.setBounds(663, 359, 64, 27);
		contentPane.add(lblParcial_12);
		
		lblParcial_13 = new JLabel("Parcial 14");
		lblParcial_13.setBounds(663, 386, 64, 27);
		contentPane.add(lblParcial_13);
		
		lblParcial_14 = new JLabel("Parcial 15");
		lblParcial_14.setBounds(663, 412, 64, 27);
		contentPane.add(lblParcial_14);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Tela1 fr = new Tela1();
				fr.setLocationRelativeTo(null);
				fr.setVisible(true);
				setVisible(false);
				
			}
		});
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnFinalizar.setBackground(Color.BLACK);
		btnFinalizar.setBounds(850, 544, 191, 49);
		contentPane.add(btnFinalizar);
		
		JLabel label_1 = new JLabel("Frequ\u00EAncia Card\u00EDaca");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Calibri", Font.BOLD, 12));
		label_1.setBounds(36, 398, 121, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Frequ\u00EAncia Respirat\u00F3ria");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Calibri", Font.BOLD, 12));
		label_2.setBounds(10, 425, 147, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Press\u00E3o Arterial");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Calibri", Font.BOLD, 12));
		label_3.setBounds(51, 451, 106, 14);
		contentPane.add(label_3);
		
		JLabel lblColeta_2 = new JLabel("Coleta 3");
		lblColeta_2.setBounds(361, 371, 64, 14);
		contentPane.add(lblColeta_2);
		
		textField_72 = new JTextField(dado[9]);
		textField_72.setColumns(10);
		textField_72.setBounds(339, 385, 86, 27);
		contentPane.add(textField_72);
		
		textField_73 = new JTextField(dado[10]);
		textField_73.setColumns(10);
		textField_73.setBounds(339, 412, 86, 27);
		contentPane.add(textField_73);
		
		textField_74 = new JTextField(dado[11]);
		textField_74.setColumns(10);
		textField_74.setBounds(339, 438, 86, 27);
		contentPane.add(textField_74);
		
		JLabel lblColeta_3 = new JLabel("Coleta 4");
		lblColeta_3.setBounds(443, 371, 55, 14);
		contentPane.add(lblColeta_3);
		
		textField_75 = new JTextField(dado[13]);
		textField_75.setColumns(10);
		textField_75.setBounds(424, 385, 86, 27);
		contentPane.add(textField_75);
		
		textField_76 = new JTextField(dado[14]);
		textField_76.setColumns(10);
		textField_76.setBounds(424, 412, 86, 27);
		contentPane.add(textField_76);
		
		textField_77 = new JTextField(dado[15]);
		textField_77.setColumns(10);
		textField_77.setBounds(424, 438, 86, 27);
		contentPane.add(textField_77);
		
		JLabel lblColeta_4 = new JLabel("Coleta 5");
		lblColeta_4.setBounds(527, 371, 55, 14);
		contentPane.add(lblColeta_4);
		
		textField_78 = new JTextField(dado[17]);
		textField_78.setColumns(10);
		textField_78.setBounds(508, 385, 86, 27);
		contentPane.add(textField_78);
		
		textField_79 = new JTextField(dado[18]);
		textField_79.setColumns(10);
		textField_79.setBounds(508, 412, 86, 27);
		contentPane.add(textField_79);
		
		textField_80 = new JTextField(dado[19]);
		textField_80.setColumns(10);
		textField_80.setBounds(508, 438, 86, 27);
		contentPane.add(textField_80);
		
		textField_81 = new JTextField(dado[4]);
		textField_81.setColumns(10);
		textField_81.setBounds(255, 464, 86, 27);
		contentPane.add(textField_81);
		
		JLabel lblTempoDeSesso = new JLabel("Tempo de Sess\u00E3o");
		lblTempoDeSesso.setForeground(Color.BLACK);
		lblTempoDeSesso.setFont(new Font("Calibri", Font.BOLD, 12));
		lblTempoDeSesso.setBounds(44, 477, 113, 14);
		contentPane.add(lblTempoDeSesso);
		
		textField_82 = new JTextField(dado[0]);
		textField_82.setColumns(10);
		textField_82.setBounds(170, 464, 86, 27);
		contentPane.add(textField_82);
		
		textField_83 = new JTextField(dado[8]);
		textField_83.setColumns(10);
		textField_83.setBounds(339, 464, 86, 27);
		contentPane.add(textField_83);
		
		textField_84 = new JTextField(dado[12]);
		textField_84.setColumns(10);
		textField_84.setBounds(424, 464, 86, 27);
		contentPane.add(textField_84);
		
		
		textField_85 = new JTextField(dado[16]);
		textField_85.setColumns(10);
		textField_85.setBounds(508, 464, 86, 27);
		contentPane.add(textField_85);
		
		if(tamanho > 60) {
		JButton btnOutrasParciais = new JButton("Outras Parciais");
		btnOutrasParciais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				NSTelaResultados2 fr = new NSTelaResultados2(parcial,tam);
				fr.setLocationRelativeTo(null);
				fr.setVisible(true);
				setVisible(false);
				
			}
		});
		btnOutrasParciais.setForeground(Color.WHITE);
		btnOutrasParciais.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnOutrasParciais.setBackground(Color.BLACK);
		btnOutrasParciais.setBounds(804, 450, 191, 27);
		contentPane.add(btnOutrasParciais);
        }
		
		JLabel lblBpmMximo = new JLabel("BPM M\u00E1ximo");
		lblBpmMximo.setForeground(Color.BLACK);
		lblBpmMximo.setFont(new Font("Calibri", Font.BOLD, 12));
		lblBpmMximo.setBounds(406, 276, 92, 14);
		contentPane.add(lblBpmMximo);
		
		JLabel lblEmgMximo = new JLabel("EMG M\u00E1ximo");
		lblEmgMximo.setForeground(Color.BLACK);
		lblEmgMximo.setFont(new Font("Calibri", Font.BOLD, 12));
		lblEmgMximo.setBounds(406, 303, 92, 14);
		contentPane.add(lblEmgMximo);
		
		JLabel lblVelocidadeMxima = new JLabel("Velocidade M\u00E1xima");
		lblVelocidadeMxima.setForeground(Color.BLACK);
		lblVelocidadeMxima.setFont(new Font("Calibri", Font.BOLD, 12));
		lblVelocidadeMxima.setBounds(392, 326, 106, 14);
		contentPane.add(lblVelocidadeMxima);
		
		textField_86 = new JTextField(VelMaxs);
		textField_86.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_86.setColumns(10);
		textField_86.setBounds(508, 320, 86, 27);
		contentPane.add(textField_86);
		
		textField_87 = new JTextField(EmgMaxs);
		textField_87.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_87.setColumns(10);
		textField_87.setBounds(508, 294, 86, 27);
		contentPane.add(textField_87);
		
		textField_88 = new JTextField(BpmMaxs);
		textField_88.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_88.setColumns(10);
		textField_88.setBounds(508, 267, 86, 27);
		contentPane.add(textField_88);
		
		JButton btnGerarRelatrioDa = new JButton("Gerar Relat\u00F3rio");
		btnGerarRelatrioDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				GerarRelatorios gr = new GerarRelatorios();
				gr.GerarPdf(cpfrg, parciais, cardioPre, respPre, artePre, cardio, resp, arte);
				
			}
		});
		btnGerarRelatrioDa.setForeground(Color.WHITE);
		btnGerarRelatrioDa.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnGerarRelatrioDa.setBackground(Color.BLACK);
		btnGerarRelatrioDa.setBounds(62, 544, 191, 49);
		contentPane.add(btnGerarRelatrioDa);
		
		
		
	}
}
