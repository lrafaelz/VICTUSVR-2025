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

public class NSTelaResultados2 extends JFrame {

	private JPanel contentPane;
    public String guardartexto;
    private JTable table;
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
    String[] parcial = new String[200];
    String[] dado = new String[20];
    private JLabel lblParcial_15;
    private JLabel lblParcial_16;
    private JLabel lblParcial_17;
    private JLabel lblParcial_18;
    private JLabel lblParcial_19;
    private JLabel lblParcial_20;
    private JLabel lblParcial_21;
    private JLabel lblParcial_22;
    private JLabel lblParcial_23;
    private JLabel lblParcial_24;
    private JLabel lblParcial_25;
    private JLabel lblParcial_26;
    private JLabel lblParcial_27;
    private JLabel lblParcial_28;
    private JLabel lblParcial_29;
    private JLabel label_15;
    private JLabel label_16;
    private JLabel label_17;
    private JLabel label_18;
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
    private JTextField textField_89;
    private JTextField textField_90;
    private JTextField textField_91;
    private JTextField textField_92;
    private JTextField textField_93;
    private JTextField textField_94;
    private JTextField textField_95;
    private JTextField textField_96;
    private JTextField textField_97;
    private JTextField textField_98;
    private JTextField textField_99;
    private JTextField textField_100;
    private JTextField textField_101;
    private JTextField textField_102;
    private JTextField textField_103;
    private JTextField textField_104;
    private JTextField textField_105;
    private JTextField textField_106;
    private JTextField textField_107;
    private JTextField textField_108;
    private JTextField textField_109;
    private JTextField textField_110;
    private JTextField textField_111;
    private JTextField textField_112;
    private JTextField textField_113;
    private JTextField textField_114;
    private JTextField textField_115;
    private JTextField textField_116;
    private JTextField textField_117;
    private JTextField textField_118;
    private JTextField textField_119;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JTextField textField_120;
    private JTextField textField_121;
    private JTextField textField_122;
    private JTextField textField_123;
    private JTextField textField_124;
    private JTextField textField_125;
    private JTextField textField_126;
    private JTextField textField_127;
    private JTextField textField_128;
    private JTextField textField_129;
    private JTextField textField_130;
    private JTextField textField_131;
    private JTextField textField_132;
    private JTextField textField_133;
    private JTextField textField_134;
    private JTextField textField_135;
    private JTextField textField_136;
    private JTextField textField_137;
    private JTextField textField_138;
    private JTextField textField_139;
    private JTextField textField_140;
    private JTextField textField_141;
    private JTextField textField_142;
    private JTextField textField_143;
    private JTextField textField_144;
    private JTextField textField_145;
    private JTextField textField_146;
    private JTextField textField_147;
    private JTextField textField_148;
    private JTextField textField_149;
    private JTextField textField_150;
    private JTextField textField_151;
    private JTextField textField_152;
    private JTextField textField_153;
    private JTextField textField_154;
    private JTextField textField_155;
    private JTextField textField_156;
    private JTextField textField_157;
    private JTextField textField_158;
    private JTextField textField_159;
    private JTextField textField_160;
    private JTextField textField_161;
    private JTextField textField_162;
    private JTextField textField_163;
    private JTextField textField_164;
    private JTextField textField_165;
    private JTextField textField_166;
    private JTextField textField_167;
    private JTextField textField_168;
    private JTextField textField_169;
    private JTextField textField_170;
    private JTextField textField_171;
    private JTextField textField_172;
    private JTextField textField_173;
    private JTextField textField_174;
    private JTextField textField_175;
    private JTextField textField_176;
    private JTextField textField_177;
    private JTextField textField_178;
    private JTextField textField_179;
    private JLabel lblParcial_30;
    private JLabel lblParcial_31;
    private JLabel lblParcial_32;
    private JLabel lblParcial_33;
    private JLabel lblParcial_34;
    private JLabel lblParcial_35;
    private JLabel lblParcial_36;
    private JLabel lblParcial_37;
    private JLabel lblParcial_38;
    private JLabel lblParcial_39;
    private JLabel lblParcial_40;
    private JLabel lblParcial_41;
    private JLabel lblParcial_42;
    private JLabel lblParcial_43;
    private JLabel lblParcial_44;
    private JLabel lblNewLabel;
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
					NSTelaResultados2 frame = new NSTelaResultados2(null,"");
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
	public NSTelaResultados2(String[] parcial, String tam) {
		
	/*	GerarArquivosDeParciais xrr = new GerarArquivosDeParciais();
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
		/*
		int tamanho = parciais.length;
		for (int fff = 0 ; fff < tamanho; fff++) {
			parcial[fff] = parciais[fff];
		}
		System.out.println(tamanho);
		String tam = Integer.toString(tamanho);
		
		for (int cont = tamanho ; cont < 200; cont ++) {
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
		}*/
		
		setTitle("Victus Teste1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 658);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNovaSessoDe = new JLabel("");
		lblNovaSessoDe.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\resultados.png"));
		lblNovaSessoDe.setForeground(Color.BLACK);
		lblNovaSessoDe.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNovaSessoDe.setBounds(556, -2, 262, 87);
		contentPane.add(lblNovaSessoDe);
		
		JButton btnNewButton = new JButton("Indicadores");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				
			}
		});
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnNewButton.setBounds(588, 536, 191, 49);
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
		btnVoltar.setBounds(287, 536, 191, 49);
		contentPane.add(btnVoltar);
		
		textField_12 = new JTextField(parcial[62]);
		textField_12.setColumns(10);
		textField_12.setBounds(593, 105, 86, 27);
		contentPane.add(textField_12);
		
		textField_13 = 	new JTextField(parcial[61]);
		textField_13.setColumns(10);
		textField_13.setBounds(508, 105, 86, 27);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField(parcial[65]);
		textField_14.setColumns(10);
		textField_14.setBounds(508, 132, 86, 27);
		contentPane.add(textField_14);
		
		textField_15 = new JTextField(parcial[69]);
		textField_15.setColumns(10);
		textField_15.setBounds(508, 158, 86, 27);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField(parcial[70]);
		textField_16.setColumns(10);
		textField_16.setBounds(593, 158, 86, 27);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField(parcial[66]);
		textField_17.setColumns(10);
		textField_17.setBounds(593, 132, 86, 27);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField(parcial[67]);
		textField_18.setColumns(10);
		textField_18.setBounds(678, 132, 86, 27);
		contentPane.add(textField_18);
		
		textField_19 = new JTextField(parcial[63]);
		textField_19.setColumns(10);
		textField_19.setBounds(678, 105, 86, 27);
		contentPane.add(textField_19);
		
		textField_20 = new JTextField(parcial[64]);
		textField_20.setColumns(10);
		textField_20.setBounds(762, 105, 86, 27);
		contentPane.add(textField_20);
		
		textField_21 = new JTextField(parcial[68]);
		textField_21.setColumns(10);
		textField_21.setBounds(762, 132, 86, 27);
		contentPane.add(textField_21);
		
		textField_22 = new JTextField(parcial[71]);
		textField_22.setBounds(678, 158, 86, 27);
		contentPane.add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField(parcial[72]);
		textField_23.setBounds(762, 158, 86, 27);
		contentPane.add(textField_23);
		textField_23.setColumns(10);
		
		lblBpm = new JLabel("BPM");
		lblBpm.setFont(new Font("Arial", Font.BOLD, 12));
		lblBpm.setBounds(532, 86, 46, 14);
		contentPane.add(lblBpm);
		
		lblDistncia = new JLabel("Dist\u00E2ncia");
		lblDistncia.setFont(new Font("Arial", Font.BOLD, 12));
		lblDistncia.setBounds(606, 86, 64, 14);
		contentPane.add(lblDistncia);
		
		lblVelocidade = new JLabel("Velocidade");
		lblVelocidade.setFont(new Font("Arial", Font.BOLD, 12));
		lblVelocidade.setBounds(691, 86, 64, 14);
		contentPane.add(lblVelocidade);
		
		lblEmg = new JLabel("EMG");
		lblEmg.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmg.setBounds(784, 86, 55, 14);
		contentPane.add(lblEmg);
		
		textField_24 = new JTextField(parcial[74]);
		textField_24.setColumns(10);
		textField_24.setBounds(593, 182, 86, 27);
		contentPane.add(textField_24);
		
		textField_25 = new JTextField(parcial[73]);
		textField_25.setColumns(10);
		textField_25.setBounds(508, 182, 86, 27);
		contentPane.add(textField_25);
		
		textField_26 = new JTextField(parcial[77]);
		textField_26.setColumns(10);
		textField_26.setBounds(508, 209, 86, 27);
		contentPane.add(textField_26);
		
		textField_27 = new JTextField(parcial[81]);
		textField_27.setColumns(10);
		textField_27.setBounds(508, 235, 86, 27);
		contentPane.add(textField_27);
		
		textField_28 = new JTextField(parcial[82]);
		textField_28.setColumns(10);
		textField_28.setBounds(593, 235, 86, 27);
		contentPane.add(textField_28);
		
		textField_29 = new JTextField(parcial[78]);
		textField_29.setColumns(10);
		textField_29.setBounds(593, 209, 86, 27);
		contentPane.add(textField_29);
		
		textField_30 = new JTextField(parcial[75]);
		textField_30.setColumns(10);
		textField_30.setBounds(678, 182, 86, 27);
		contentPane.add(textField_30);
		
		textField_31 = new JTextField(parcial[79]);
		textField_31.setColumns(10);
		textField_31.setBounds(678, 209, 86, 27);
		contentPane.add(textField_31);
		
		textField_32 = new JTextField(parcial[83]);
		textField_32.setColumns(10);
		textField_32.setBounds(678, 235, 86, 27);
		contentPane.add(textField_32);
		
		textField_33 = new JTextField(parcial[84]);
		textField_33.setColumns(10);
		textField_33.setBounds(762, 235, 86, 27);
		contentPane.add(textField_33);
		
		textField_34 = new JTextField(parcial[80]);
		textField_34.setColumns(10);
		textField_34.setBounds(762, 209, 86, 27);
		contentPane.add(textField_34);
		
		textField_35 = new JTextField(parcial[76]);
		textField_35.setColumns(10);
		textField_35.setBounds(762, 182, 86, 27);
		contentPane.add(textField_35);
		
		textField_36 = new JTextField(parcial[86]);
		textField_36.setColumns(10);
		textField_36.setBounds(593, 257, 86, 27);
		contentPane.add(textField_36);
		
		textField_37 = new JTextField(parcial[85]);
		textField_37.setColumns(10);
		textField_37.setBounds(508, 257, 86, 27);
		contentPane.add(textField_37);
		
		textField_38 = new JTextField(parcial[89]);
		textField_38.setColumns(10);
		textField_38.setBounds(508, 284, 86, 27);
		contentPane.add(textField_38);
		
		textField_39 = new JTextField(parcial[93]);
		textField_39.setColumns(10);
		textField_39.setBounds(508, 310, 86, 27);
		contentPane.add(textField_39);
		
		textField_40 = new JTextField(parcial[94]);
		textField_40.setColumns(10);
		textField_40.setBounds(593, 310, 86, 27);
		contentPane.add(textField_40);
		
		textField_41 = new JTextField(parcial[90]);
		textField_41.setColumns(10);
		textField_41.setBounds(593, 284, 86, 27);
		contentPane.add(textField_41);
		
		textField_42 = new JTextField(parcial[87]);
		textField_42.setColumns(10);
		textField_42.setBounds(678, 257, 86, 27);
		contentPane.add(textField_42);
		
		textField_43 = new JTextField(parcial[91]);
		textField_43.setColumns(10);
		textField_43.setBounds(678, 284, 86, 27);
		contentPane.add(textField_43);
		
		textField_44 = new JTextField(parcial[95]);
		textField_44.setColumns(10);
		textField_44.setBounds(678, 310, 86, 27);
		contentPane.add(textField_44);
		
		textField_45 = new JTextField(parcial[96]);
		textField_45.setColumns(10);
		textField_45.setBounds(762, 310, 86, 27);
		contentPane.add(textField_45);
		
		textField_46 = new JTextField(parcial[92]);
		textField_46.setColumns(10);
		textField_46.setBounds(762, 284, 86, 27);
		contentPane.add(textField_46);
		
		textField_47 = new JTextField(parcial[88]);
		textField_47.setColumns(10);
		textField_47.setBounds(762, 257, 86, 27);
		contentPane.add(textField_47);
		
		textField_48 = new JTextField(parcial[98]);
		textField_48.setColumns(10);
		textField_48.setBounds(593, 337, 86, 27);
		contentPane.add(textField_48);
		
		textField_49 = new JTextField(parcial[97]);
		textField_49.setColumns(10);
		textField_49.setBounds(508, 337, 86, 27);
		contentPane.add(textField_49);
		
		textField_50 = new JTextField(parcial[101]);
		textField_50.setColumns(10);
		textField_50.setBounds(508, 364, 86, 27);
		contentPane.add(textField_50);
		
		textField_51 = new JTextField(parcial[105]);
		textField_51.setColumns(10);
		textField_51.setBounds(508, 390, 86, 27);
		contentPane.add(textField_51);
		
		textField_52 = new JTextField(parcial[106]);
		textField_52.setColumns(10);
		textField_52.setBounds(593, 390, 86, 27);
		contentPane.add(textField_52);
		
		textField_53 = new JTextField(parcial[102]);
		textField_53.setColumns(10);
		textField_53.setBounds(593, 364, 86, 27);
		contentPane.add(textField_53);
		
		textField_54 = new JTextField(parcial[99]);
		textField_54.setColumns(10);
		textField_54.setBounds(678, 337, 86, 27);
		contentPane.add(textField_54);
		
		textField_55 = new JTextField(parcial[103]);
		textField_55.setColumns(10);
		textField_55.setBounds(678, 364, 86, 27);
		contentPane.add(textField_55);
		
		textField_56 = new JTextField(parcial[107]);
		textField_56.setColumns(10);
		textField_56.setBounds(678, 390, 86, 27);
		contentPane.add(textField_56);
		
		textField_57 = new JTextField(parcial[108]);
		textField_57.setColumns(10);
		textField_57.setBounds(762, 390, 86, 27);
		contentPane.add(textField_57);
		
		textField_58 = new JTextField(parcial[104]);
		textField_58.setColumns(10);
		textField_58.setBounds(762, 364, 86, 27);
		contentPane.add(textField_58);
		
		textField_59 = new JTextField(parcial[100]);
		textField_59.setColumns(10);
		textField_59.setBounds(762, 337, 86, 27);
		contentPane.add(textField_59);
		
		textField_60 = new JTextField(parcial[110]);
		textField_60.setColumns(10);
		textField_60.setBounds(593, 415, 86, 27);
		contentPane.add(textField_60);
		
		textField_61 = new JTextField(parcial[109]);
		textField_61.setColumns(10);
		textField_61.setBounds(508, 415, 86, 27);
		contentPane.add(textField_61);
		
		textField_62 = new JTextField(parcial[113]);
		textField_62.setColumns(10);
		textField_62.setBounds(508, 442, 86, 27);
		contentPane.add(textField_62);
		
		textField_63 = new JTextField(parcial[117]);
		textField_63.setColumns(10);
		textField_63.setBounds(508, 468, 86, 27);
		contentPane.add(textField_63);
		
		textField_64 = new JTextField(parcial[118]);
		textField_64.setColumns(10);
		textField_64.setBounds(593, 468, 86, 27);
		contentPane.add(textField_64);
		
		textField_65 = new JTextField(parcial[114]);
		textField_65.setColumns(10);
		textField_65.setBounds(593, 442, 86, 27);
		contentPane.add(textField_65);
		
		textField_66 = new JTextField(parcial[111]);
		textField_66.setColumns(10);
		textField_66.setBounds(678, 415, 86, 27);
		contentPane.add(textField_66);
		
		textField_67 = new JTextField(parcial[115]);
		textField_67.setColumns(10);
		textField_67.setBounds(678, 442, 86, 27);
		contentPane.add(textField_67);
		
		textField_68 = new JTextField(parcial[119]);
		textField_68.setColumns(10);
		textField_68.setBounds(678, 468, 86, 27);
		contentPane.add(textField_68);
		
		textField_69 = new JTextField(parcial[120]);
		textField_69.setColumns(10);
		textField_69.setBounds(762, 468, 86, 27);
		contentPane.add(textField_69);
		
		textField_70 = new JTextField(parcial[116]);
		textField_70.setColumns(10);
		textField_70.setBounds(762, 442, 86, 27);
		contentPane.add(textField_70);
		
		textField_71 = new JTextField(parcial[112]);
		textField_71.setColumns(10);
		textField_71.setBounds(762, 415, 86, 27);
		contentPane.add(textField_71);
		
		lblParcial = new JLabel("Parcial 31");
		lblParcial.setBounds(444, 111, 64, 14);
		contentPane.add(lblParcial);
		
		lblParcial_1 = new JLabel("Parcial 32");
		lblParcial_1.setBounds(444, 138, 64, 14);
		contentPane.add(lblParcial_1);
		
		lblParcial_2 = new JLabel("Parcial 33");
		lblParcial_2.setBounds(444, 164, 64, 14);
		contentPane.add(lblParcial_2);
		
		lblParcial_3 = new JLabel("Parcial 34");
		lblParcial_3.setBounds(444, 188, 64, 14);
		contentPane.add(lblParcial_3);
		
		lblParcial_4 = new JLabel("Parcial 35");
		lblParcial_4.setBounds(444, 215, 64, 14);
		contentPane.add(lblParcial_4);
		
		lblParcial_5 = new JLabel("Parcial 36");
		lblParcial_5.setBounds(444, 241, 64, 14);
		contentPane.add(lblParcial_5);
		
		lblParcial_6 = new JLabel("Parcial 37");
		lblParcial_6.setBounds(444, 264, 64, 19);
		contentPane.add(lblParcial_6);
		
		lblParcial_7 = new JLabel("Parcial 38");
		lblParcial_7.setBounds(444, 284, 64, 27);
		contentPane.add(lblParcial_7);
		
		lblParcial_8 = new JLabel("Parcial 39");
		lblParcial_8.setBounds(444, 317, 64, 14);
		contentPane.add(lblParcial_8);
		
		lblParcial_9 = new JLabel("Parcial 40");
		lblParcial_9.setBounds(444, 343, 64, 14);
		contentPane.add(lblParcial_9);
		
		lblParcial_10 = new JLabel("Parcial 41");
		lblParcial_10.setBounds(444, 364, 64, 27);
		contentPane.add(lblParcial_10);
		
		lblParcial_11 = new JLabel("Parcial 42");
		lblParcial_11.setBounds(444, 390, 64, 27);
		contentPane.add(lblParcial_11);
		
		lblParcial_12 = new JLabel("Parcial 43");
		lblParcial_12.setBounds(444, 415, 64, 27);
		contentPane.add(lblParcial_12);
		
		lblParcial_13 = new JLabel("Parcial 44");
		lblParcial_13.setBounds(444, 442, 64, 27);
		contentPane.add(lblParcial_13);
		
		lblParcial_14 = new JLabel("Parcial 45");
		lblParcial_14.setBounds(444, 468, 64, 27);
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
		btnFinalizar.setBounds(891, 536, 191, 49);
		contentPane.add(btnFinalizar);
		
		lblParcial_15 = new JLabel("Parcial 16");
		lblParcial_15.setBounds(30, 111, 64, 14);
		contentPane.add(lblParcial_15);
		
		lblParcial_16 = new JLabel("Parcial 17");
		lblParcial_16.setBounds(30, 138, 64, 14);
		contentPane.add(lblParcial_16);
		
		lblParcial_17 = new JLabel("Parcial 18");
		lblParcial_17.setBounds(30, 164, 64, 14);
		contentPane.add(lblParcial_17);
		
		lblParcial_18 = new JLabel("Parcial 19");
		lblParcial_18.setBounds(30, 188, 64, 14);
		contentPane.add(lblParcial_18);
		
		lblParcial_19 = new JLabel("Parcial 20");
		lblParcial_19.setBounds(30, 215, 64, 14);
		contentPane.add(lblParcial_19);
		
		lblParcial_20 = new JLabel("Parcial 21");
		lblParcial_20.setBounds(30, 241, 64, 14);
		contentPane.add(lblParcial_20);
		
		lblParcial_21 = new JLabel("Parcial 22");
		lblParcial_21.setBounds(30, 264, 64, 19);
		contentPane.add(lblParcial_21);
		
		lblParcial_22 = new JLabel("Parcial 23");
		lblParcial_22.setBounds(30, 284, 64, 27);
		contentPane.add(lblParcial_22);
		
		lblParcial_23 = new JLabel("Parcial 24");
		lblParcial_23.setBounds(30, 317, 64, 14);
		contentPane.add(lblParcial_23);
		
		lblParcial_24 = new JLabel("Parcial 25");
		lblParcial_24.setBounds(30, 343, 64, 14);
		contentPane.add(lblParcial_24);
		
		lblParcial_25 = new JLabel("Parcial 26");
		lblParcial_25.setBounds(30, 364, 64, 27);
		contentPane.add(lblParcial_25);
		
		lblParcial_26 = new JLabel("Parcial 27");
		lblParcial_26.setBounds(30, 390, 64, 27);
		contentPane.add(lblParcial_26);
		
		lblParcial_27 = new JLabel("Parcial 28");
		lblParcial_27.setBounds(30, 415, 64, 27);
		contentPane.add(lblParcial_27);
		
		lblParcial_28 = new JLabel("Parcial 29");
		lblParcial_28.setBounds(30, 442, 64, 27);
		contentPane.add(lblParcial_28);
		
		lblParcial_29 = new JLabel("Parcial 30");
		lblParcial_29.setBounds(30, 468, 64, 27);
		contentPane.add(lblParcial_29);
		
		label_15 = new JLabel("BPM");
		label_15.setFont(new Font("Arial", Font.BOLD, 12));
		label_15.setBounds(118, 86, 46, 14);
		contentPane.add(label_15);
		
		label_16 = new JLabel("Dist\u00E2ncia");
		label_16.setFont(new Font("Arial", Font.BOLD, 12));
		label_16.setBounds(192, 86, 64, 14);
		contentPane.add(label_16);
		
		label_17 = new JLabel("Velocidade");
		label_17.setFont(new Font("Arial", Font.BOLD, 12));
		label_17.setBounds(277, 86, 64, 14);
		contentPane.add(label_17);
		
		label_18 = new JLabel("EMG");
		label_18.setFont(new Font("Arial", Font.BOLD, 12));
		label_18.setBounds(370, 86, 55, 14);
		contentPane.add(label_18);
		
		textField = new JTextField(parcial[60]);
		textField.setColumns(10);
		textField.setBounds(94, 105, 86, 27);
		contentPane.add(textField);
		
		textField_1 = new JTextField(parcial[61]);
		textField_1.setColumns(10);
		textField_1.setBounds(179, 105, 86, 27);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField(parcial[62]);
		textField_2.setColumns(10);
		textField_2.setBounds(264, 105, 86, 27);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField(parcial[63]);
		textField_3.setColumns(10);
		textField_3.setBounds(348, 105, 86, 27);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField(parcial[64]);
		textField_4.setColumns(10);
		textField_4.setBounds(94, 132, 86, 27);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField(parcial[68]);
		textField_5.setColumns(10);
		textField_5.setBounds(94, 158, 86, 27);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField(parcial[69]);
		textField_6.setColumns(10);
		textField_6.setBounds(179, 158, 86, 27);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField(parcial[65]);
		textField_7.setColumns(10);
		textField_7.setBounds(179, 132, 86, 27);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField(parcial[66]);
		textField_8.setColumns(10);
		textField_8.setBounds(264, 132, 86, 27);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField(parcial[67]);
		textField_9.setColumns(10);
		textField_9.setBounds(348, 132, 86, 27);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField(parcial[70]);
		textField_10.setColumns(10);
		textField_10.setBounds(264, 158, 86, 27);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField(parcial[71]);
		textField_11.setColumns(10);
		textField_11.setBounds(348, 158, 86, 27);
		contentPane.add(textField_11);
		
		textField_72 = new JTextField(parcial[75]);
		textField_72.setColumns(10);
		textField_72.setBounds(348, 182, 86, 27);
		contentPane.add(textField_72);
		
		textField_73 = new JTextField(parcial[74]);
		textField_73.setColumns(10);
		textField_73.setBounds(264, 182, 86, 27);
		contentPane.add(textField_73);
		
		textField_74 = new JTextField(parcial[73]);
		textField_74.setColumns(10);
		textField_74.setBounds(179, 182, 86, 27);
		contentPane.add(textField_74);
		
		textField_75 = new JTextField(parcial[72]);
		textField_75.setColumns(10);
		textField_75.setBounds(94, 182, 86, 27);
		contentPane.add(textField_75);
		
		textField_76 = new JTextField(parcial[76]);
		textField_76.setColumns(10);
		textField_76.setBounds(94, 209, 86, 27);
		contentPane.add(textField_76);
		
		textField_77 = new JTextField(parcial[77]);
		textField_77.setColumns(10);
		textField_77.setBounds(179, 209, 86, 27);
		contentPane.add(textField_77);
		
		textField_78 = new JTextField(parcial[78]);
		textField_78.setColumns(10);
		textField_78.setBounds(264, 209, 86, 27);
		contentPane.add(textField_78);
		
		textField_79 = new JTextField(parcial[79]);
		textField_79.setColumns(10);
		textField_79.setBounds(348, 209, 86, 27);
		contentPane.add(textField_79);
		
		textField_80 = new JTextField(parcial[80]);
		textField_80.setColumns(10);
		textField_80.setBounds(94, 235, 86, 27);
		contentPane.add(textField_80);
		
		textField_81 = new JTextField(parcial[81]);
		textField_81.setColumns(10);
		textField_81.setBounds(179, 235, 86, 27);
		contentPane.add(textField_81);
		
		textField_82 = new JTextField(parcial[82]);
		textField_82.setColumns(10);
		textField_82.setBounds(264, 235, 86, 27);
		contentPane.add(textField_82);
		
		textField_83 = new JTextField(parcial[83]);
		textField_83.setColumns(10);
		textField_83.setBounds(348, 235, 86, 27);
		contentPane.add(textField_83);
		
		textField_84 = new JTextField(parcial[84]);
		textField_84.setColumns(10);
		textField_84.setBounds(94, 257, 86, 27);
		contentPane.add(textField_84);
		
		textField_85 = new JTextField(parcial[85]);
		textField_85.setColumns(10);
		textField_85.setBounds(179, 257, 86, 27);
		contentPane.add(textField_85);
		
		textField_86 = new JTextField(parcial[86]);
		textField_86.setColumns(10);
		textField_86.setBounds(264, 257, 86, 27);
		contentPane.add(textField_86);
		
		textField_87 = new JTextField(parcial[87]);
		textField_87.setColumns(10);
		textField_87.setBounds(348, 257, 86, 27);
		contentPane.add(textField_87);
		
		textField_88 = new JTextField(parcial[91]);
		textField_88.setColumns(10);
		textField_88.setBounds(348, 284, 86, 27);
		contentPane.add(textField_88);
		
		textField_89 = new JTextField(parcial[90]);
		textField_89.setColumns(10);
		textField_89.setBounds(264, 284, 86, 27);
		contentPane.add(textField_89);
		
		textField_90 = new JTextField(parcial[89]);
		textField_90.setColumns(10);
		textField_90.setBounds(179, 284, 86, 27);
		contentPane.add(textField_90);
		
		textField_91 = new JTextField(parcial[88]);
		textField_91.setColumns(10);
		textField_91.setBounds(94, 284, 86, 27);
		contentPane.add(textField_91);
		
		textField_92 = new JTextField(parcial[92]);
		textField_92.setColumns(10);
		textField_92.setBounds(94, 310, 86, 27);
		contentPane.add(textField_92);
		
		textField_93 = new JTextField(parcial[93]);
		textField_93.setColumns(10);
		textField_93.setBounds(179, 310, 86, 27);
		contentPane.add(textField_93);
		
		textField_94 = new JTextField(parcial[94]);
		textField_94.setColumns(10);
		textField_94.setBounds(264, 310, 86, 27);
		contentPane.add(textField_94);
		
		textField_95 = new JTextField(parcial[95]);
		textField_95.setColumns(10);
		textField_95.setBounds(348, 310, 86, 27);
		contentPane.add(textField_95);
		
		textField_96 = new JTextField(parcial[99]);
		textField_96.setColumns(10);
		textField_96.setBounds(348, 337, 86, 27);
		contentPane.add(textField_96);
		
		textField_97 = new JTextField(parcial[98]);
		textField_97.setColumns(10);
		textField_97.setBounds(264, 337, 86, 27);
		contentPane.add(textField_97);
		
		textField_98 = new JTextField(parcial[97]);
		textField_98.setColumns(10);
		textField_98.setBounds(179, 337, 86, 27);
		contentPane.add(textField_98);
		
		textField_99 = new JTextField(parcial[96]);
		textField_99.setColumns(10);
		textField_99.setBounds(94, 337, 86, 27);
		contentPane.add(textField_99);
		
		textField_100 = new JTextField(parcial[100]);
		textField_100.setColumns(10);
		textField_100.setBounds(94, 364, 86, 27);
		contentPane.add(textField_100);
		
		textField_101 = new JTextField(parcial[101]);
		textField_101.setColumns(10);
		textField_101.setBounds(179, 364, 86, 27);
		contentPane.add(textField_101);
		
		textField_102 = new JTextField(parcial[102]);
		textField_102.setColumns(10);
		textField_102.setBounds(264, 364, 86, 27);
		contentPane.add(textField_102);
		
		textField_103 = new JTextField(parcial[103]);
		textField_103.setColumns(10);
		textField_103.setBounds(348, 364, 86, 27);
		contentPane.add(textField_103);
		
		textField_104 = new JTextField(parcial[107]);
		textField_104.setColumns(10);
		textField_104.setBounds(348, 390, 86, 27);
		contentPane.add(textField_104);
		
		textField_105 = new JTextField(parcial[106]);
		textField_105.setColumns(10);
		textField_105.setBounds(264, 390, 86, 27);
		contentPane.add(textField_105);
		
		textField_106 = new JTextField(parcial[105]);
		textField_106.setColumns(10);
		textField_106.setBounds(179, 390, 86, 27);
		contentPane.add(textField_106);
		
		textField_107 = new JTextField(parcial[104]);
		textField_107.setColumns(10);
		textField_107.setBounds(94, 390, 86, 27);
		contentPane.add(textField_107);
		
		textField_108 = new JTextField(parcial[108]);
		textField_108.setColumns(10);
		textField_108.setBounds(94, 415, 86, 27);
		contentPane.add(textField_108);
		
		textField_109 = new JTextField(parcial[109]);
		textField_109.setColumns(10);
		textField_109.setBounds(179, 415, 86, 27);
		contentPane.add(textField_109);
		
		textField_110 = new JTextField(parcial[110]);
		textField_110.setColumns(10);
		textField_110.setBounds(264, 415, 86, 27);
		contentPane.add(textField_110);
		
		textField_111 = new JTextField(parcial[111]);
		textField_111.setColumns(10);
		textField_111.setBounds(348, 415, 86, 27);
		contentPane.add(textField_111);
		
		textField_112 = new JTextField(parcial[115]);
		textField_112.setColumns(10);
		textField_112.setBounds(348, 442, 86, 27);
		contentPane.add(textField_112);
		
		textField_113 = new JTextField(parcial[114]);
		textField_113.setColumns(10);
		textField_113.setBounds(264, 442, 86, 27);
		contentPane.add(textField_113);
		
		textField_114 = new JTextField(parcial[113]);
		textField_114.setColumns(10);
		textField_114.setBounds(179, 442, 86, 27);
		contentPane.add(textField_114);
		
		textField_115 = new JTextField(parcial[112]);
		textField_115.setColumns(10);
		textField_115.setBounds(94, 442, 86, 27);
		contentPane.add(textField_115);
		
		textField_116 = new JTextField(parcial[116]);
		textField_116.setColumns(10);
		textField_116.setBounds(94, 468, 86, 27);
		contentPane.add(textField_116);
		
		textField_117 = new JTextField(parcial[117]);
		textField_117.setColumns(10);
		textField_117.setBounds(179, 468, 86, 27);
		contentPane.add(textField_117);
		
		textField_118 = new JTextField(parcial[118]);
		textField_118.setColumns(10);
		textField_118.setBounds(264, 468, 86, 27);
		contentPane.add(textField_118);
		
		textField_119 = new JTextField(parcial[119]);
		textField_119.setColumns(10);
		textField_119.setBounds(348, 468, 86, 27);
		contentPane.add(textField_119);
		
		label = new JLabel("BPM");
		label.setFont(new Font("Arial", Font.BOLD, 12));
		label.setBounds(946, 86, 46, 14);
		contentPane.add(label);
		
		label_1 = new JLabel("Dist\u00E2ncia");
		label_1.setFont(new Font("Arial", Font.BOLD, 12));
		label_1.setBounds(1020, 86, 64, 14);
		contentPane.add(label_1);
		
		label_2 = new JLabel("Velocidade");
		label_2.setFont(new Font("Arial", Font.BOLD, 12));
		label_2.setBounds(1105, 86, 64, 14);
		contentPane.add(label_2);
		
		label_3 = new JLabel("EMG");
		label_3.setFont(new Font("Arial", Font.BOLD, 12));
		label_3.setBounds(1198, 86, 55, 14);
		contentPane.add(label_3);
		
		textField_120 = new JTextField((String) null);
		textField_120.setColumns(10);
		textField_120.setBounds(922, 105, 86, 27);
		contentPane.add(textField_120);
		
		textField_121 = new JTextField((String) null);
		textField_121.setColumns(10);
		textField_121.setBounds(1007, 105, 86, 27);
		contentPane.add(textField_121);
		
		textField_122 = new JTextField((String) null);
		textField_122.setColumns(10);
		textField_122.setBounds(1092, 105, 86, 27);
		contentPane.add(textField_122);
		
		textField_123 = new JTextField((String) null);
		textField_123.setColumns(10);
		textField_123.setBounds(1176, 105, 86, 27);
		contentPane.add(textField_123);
		
		textField_124 = new JTextField((String) null);
		textField_124.setColumns(10);
		textField_124.setBounds(1176, 132, 86, 27);
		contentPane.add(textField_124);
		
		textField_125 = new JTextField((String) null);
		textField_125.setColumns(10);
		textField_125.setBounds(1092, 132, 86, 27);
		contentPane.add(textField_125);
		
		textField_126 = new JTextField((String) null);
		textField_126.setColumns(10);
		textField_126.setBounds(1007, 132, 86, 27);
		contentPane.add(textField_126);
		
		textField_127 = new JTextField((String) null);
		textField_127.setColumns(10);
		textField_127.setBounds(922, 132, 86, 27);
		contentPane.add(textField_127);
		
		textField_128 = new JTextField((String) null);
		textField_128.setColumns(10);
		textField_128.setBounds(922, 158, 86, 27);
		contentPane.add(textField_128);
		
		textField_129 = new JTextField((String) null);
		textField_129.setColumns(10);
		textField_129.setBounds(1007, 158, 86, 27);
		contentPane.add(textField_129);
		
		textField_130 = new JTextField((String) null);
		textField_130.setColumns(10);
		textField_130.setBounds(1092, 158, 86, 27);
		contentPane.add(textField_130);
		
		textField_131 = new JTextField((String) null);
		textField_131.setColumns(10);
		textField_131.setBounds(1176, 158, 86, 27);
		contentPane.add(textField_131);
		
		textField_132 = new JTextField((String) null);
		textField_132.setColumns(10);
		textField_132.setBounds(1176, 182, 86, 27);
		contentPane.add(textField_132);
		
		textField_133 = new JTextField((String) null);
		textField_133.setColumns(10);
		textField_133.setBounds(1092, 182, 86, 27);
		contentPane.add(textField_133);
		
		textField_134 = new JTextField((String) null);
		textField_134.setColumns(10);
		textField_134.setBounds(1007, 182, 86, 27);
		contentPane.add(textField_134);
		
		textField_135 = new JTextField((String) null);
		textField_135.setColumns(10);
		textField_135.setBounds(922, 182, 86, 27);
		contentPane.add(textField_135);
		
		textField_136 = new JTextField((String) null);
		textField_136.setColumns(10);
		textField_136.setBounds(922, 209, 86, 27);
		contentPane.add(textField_136);
		
		textField_137 = new JTextField((String) null);
		textField_137.setColumns(10);
		textField_137.setBounds(1007, 209, 86, 27);
		contentPane.add(textField_137);
		
		textField_138 = new JTextField((String) null);
		textField_138.setColumns(10);
		textField_138.setBounds(1092, 209, 86, 27);
		contentPane.add(textField_138);
		
		textField_139 = new JTextField((String) null);
		textField_139.setColumns(10);
		textField_139.setBounds(1176, 209, 86, 27);
		contentPane.add(textField_139);
		
		textField_140 = new JTextField((String) null);
		textField_140.setColumns(10);
		textField_140.setBounds(1176, 235, 86, 27);
		contentPane.add(textField_140);
		
		textField_141 = new JTextField((String) null);
		textField_141.setColumns(10);
		textField_141.setBounds(1092, 235, 86, 27);
		contentPane.add(textField_141);
		
		textField_142 = new JTextField((String) null);
		textField_142.setColumns(10);
		textField_142.setBounds(1007, 235, 86, 27);
		contentPane.add(textField_142);
		
		textField_143 = new JTextField((String) null);
		textField_143.setColumns(10);
		textField_143.setBounds(922, 235, 86, 27);
		contentPane.add(textField_143);
		
		textField_144 = new JTextField((String) null);
		textField_144.setColumns(10);
		textField_144.setBounds(922, 257, 86, 27);
		contentPane.add(textField_144);
		
		textField_145 = new JTextField((String) null);
		textField_145.setColumns(10);
		textField_145.setBounds(1007, 257, 86, 27);
		contentPane.add(textField_145);
		
		textField_146 = new JTextField((String) null);
		textField_146.setColumns(10);
		textField_146.setBounds(1092, 257, 86, 27);
		contentPane.add(textField_146);
		
		textField_147 = new JTextField((String) null);
		textField_147.setColumns(10);
		textField_147.setBounds(1176, 257, 86, 27);
		contentPane.add(textField_147);
		
		textField_148 = new JTextField((String) null);
		textField_148.setColumns(10);
		textField_148.setBounds(1176, 284, 86, 27);
		contentPane.add(textField_148);
		
		textField_149 = new JTextField((String) null);
		textField_149.setColumns(10);
		textField_149.setBounds(1092, 284, 86, 27);
		contentPane.add(textField_149);
		
		textField_150 = new JTextField((String) null);
		textField_150.setColumns(10);
		textField_150.setBounds(1007, 284, 86, 27);
		contentPane.add(textField_150);
		
		textField_151 = new JTextField((String) null);
		textField_151.setColumns(10);
		textField_151.setBounds(922, 284, 86, 27);
		contentPane.add(textField_151);
		
		textField_152 = new JTextField((String) null);
		textField_152.setColumns(10);
		textField_152.setBounds(922, 310, 86, 27);
		contentPane.add(textField_152);
		
		textField_153 = new JTextField((String) null);
		textField_153.setColumns(10);
		textField_153.setBounds(1007, 310, 86, 27);
		contentPane.add(textField_153);
		
		textField_154 = new JTextField((String) null);
		textField_154.setColumns(10);
		textField_154.setBounds(1092, 310, 86, 27);
		contentPane.add(textField_154);
		
		textField_155 = new JTextField((String) null);
		textField_155.setColumns(10);
		textField_155.setBounds(1176, 310, 86, 27);
		contentPane.add(textField_155);
		
		textField_156 = new JTextField((String) null);
		textField_156.setColumns(10);
		textField_156.setBounds(1176, 337, 86, 27);
		contentPane.add(textField_156);
		
		textField_157 = new JTextField((String) null);
		textField_157.setColumns(10);
		textField_157.setBounds(1092, 337, 86, 27);
		contentPane.add(textField_157);
		
		textField_158 = new JTextField((String) null);
		textField_158.setColumns(10);
		textField_158.setBounds(1007, 337, 86, 27);
		contentPane.add(textField_158);
		
		textField_159 = new JTextField((String) null);
		textField_159.setColumns(10);
		textField_159.setBounds(922, 337, 86, 27);
		contentPane.add(textField_159);
		
		textField_160 = new JTextField((String) null);
		textField_160.setColumns(10);
		textField_160.setBounds(922, 364, 86, 27);
		contentPane.add(textField_160);
		
		textField_161 = new JTextField((String) null);
		textField_161.setColumns(10);
		textField_161.setBounds(1007, 364, 86, 27);
		contentPane.add(textField_161);
		
		textField_162 = new JTextField((String) null);
		textField_162.setColumns(10);
		textField_162.setBounds(1092, 364, 86, 27);
		contentPane.add(textField_162);
		
		textField_163 = new JTextField((String) null);
		textField_163.setColumns(10);
		textField_163.setBounds(1176, 364, 86, 27);
		contentPane.add(textField_163);
		
		textField_164 = new JTextField((String) null);
		textField_164.setColumns(10);
		textField_164.setBounds(1176, 390, 86, 27);
		contentPane.add(textField_164);
		
		textField_165 = new JTextField((String) null);
		textField_165.setColumns(10);
		textField_165.setBounds(1092, 390, 86, 27);
		contentPane.add(textField_165);
		
		textField_166 = new JTextField((String) null);
		textField_166.setColumns(10);
		textField_166.setBounds(1007, 390, 86, 27);
		contentPane.add(textField_166);
		
		textField_167 = new JTextField((String) null);
		textField_167.setColumns(10);
		textField_167.setBounds(922, 390, 86, 27);
		contentPane.add(textField_167);
		
		textField_168 = new JTextField((String) null);
		textField_168.setColumns(10);
		textField_168.setBounds(922, 415, 86, 27);
		contentPane.add(textField_168);
		
		textField_169 = new JTextField((String) null);
		textField_169.setColumns(10);
		textField_169.setBounds(1007, 415, 86, 27);
		contentPane.add(textField_169);
		
		textField_170 = new JTextField((String) null);
		textField_170.setColumns(10);
		textField_170.setBounds(1092, 415, 86, 27);
		contentPane.add(textField_170);
		
		textField_171 = new JTextField((String) null);
		textField_171.setColumns(10);
		textField_171.setBounds(1176, 415, 86, 27);
		contentPane.add(textField_171);
		
		textField_172 = new JTextField((String) null);
		textField_172.setColumns(10);
		textField_172.setBounds(1176, 442, 86, 27);
		contentPane.add(textField_172);
		
		textField_173 = new JTextField((String) null);
		textField_173.setColumns(10);
		textField_173.setBounds(1092, 442, 86, 27);
		contentPane.add(textField_173);
		
		textField_174 = new JTextField((String) null);
		textField_174.setColumns(10);
		textField_174.setBounds(1007, 442, 86, 27);
		contentPane.add(textField_174);
		
		textField_175 = new JTextField((String) null);
		textField_175.setColumns(10);
		textField_175.setBounds(922, 442, 86, 27);
		contentPane.add(textField_175);
		
		textField_176 = new JTextField((String) null);
		textField_176.setColumns(10);
		textField_176.setBounds(922, 468, 86, 27);
		contentPane.add(textField_176);
		
		textField_177 = new JTextField((String) null);
		textField_177.setColumns(10);
		textField_177.setBounds(1007, 468, 86, 27);
		contentPane.add(textField_177);
		
		textField_178 = new JTextField((String) null);
		textField_178.setColumns(10);
		textField_178.setBounds(1092, 468, 86, 27);
		contentPane.add(textField_178);
		
		textField_179 = new JTextField((String) null);
		textField_179.setColumns(10);
		textField_179.setBounds(1176, 468, 86, 27);
		contentPane.add(textField_179);
		
		lblParcial_30 = new JLabel("Parcial 46");
		lblParcial_30.setBounds(858, 111, 64, 14);
		contentPane.add(lblParcial_30);
		
		lblParcial_31 = new JLabel("Parcial 47");
		lblParcial_31.setBounds(858, 138, 64, 14);
		contentPane.add(lblParcial_31);
		
		lblParcial_32 = new JLabel("Parcial 48");
		lblParcial_32.setBounds(858, 164, 64, 14);
		contentPane.add(lblParcial_32);
		
		lblParcial_33 = new JLabel("Parcial 49");
		lblParcial_33.setBounds(858, 188, 64, 14);
		contentPane.add(lblParcial_33);
		
		lblParcial_34 = new JLabel("Parcial 50");
		lblParcial_34.setBounds(858, 215, 64, 14);
		contentPane.add(lblParcial_34);
		
		lblParcial_35 = new JLabel("Parcial 51");
		lblParcial_35.setBounds(858, 241, 64, 14);
		contentPane.add(lblParcial_35);
		
		lblParcial_36 = new JLabel("Parcial 52");
		lblParcial_36.setBounds(858, 264, 64, 19);
		contentPane.add(lblParcial_36);
		
		lblParcial_37 = new JLabel("Parcial 53");
		lblParcial_37.setBounds(858, 284, 64, 27);
		contentPane.add(lblParcial_37);
		
		lblParcial_38 = new JLabel("Parcial 54");
		lblParcial_38.setBounds(858, 317, 64, 14);
		contentPane.add(lblParcial_38);
		
		lblParcial_39 = new JLabel("Parcial 55");
		lblParcial_39.setBounds(858, 343, 64, 14);
		contentPane.add(lblParcial_39);
		
		lblParcial_40 = new JLabel("Parcial 56");
		lblParcial_40.setBounds(858, 364, 64, 27);
		contentPane.add(lblParcial_40);
		
		lblParcial_41 = new JLabel("Parcial 57");
		lblParcial_41.setBounds(858, 390, 64, 27);
		contentPane.add(lblParcial_41);
		
		lblParcial_42 = new JLabel("Parcial 58");
		lblParcial_42.setBounds(858, 415, 64, 27);
		contentPane.add(lblParcial_42);
		
		lblParcial_43 = new JLabel("Parcial 59");
		lblParcial_43.setBounds(858, 442, 64, 27);
		contentPane.add(lblParcial_43);
		
		lblParcial_44 = new JLabel("Parcial 60");
		lblParcial_44.setBounds(858, 468, 64, 27);
		contentPane.add(lblParcial_44);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\Desktop\\logos\\logoresultados.png"));
		lblNewLabel.setBounds(30, -2, 269, 89);
		contentPane.add(lblNewLabel);
		
		
		
		
	}
}
