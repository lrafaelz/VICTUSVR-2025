package telas.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.fazecast.jSerialComm.SerialPort;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class NSTelaMonitoramento extends JFrame {

	private JPanel contentPane;

	int ret;
	static SerialPort chosenPort;
	static int x = 0;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	String textobpm = "0";
	String textodis = "0";
	String textovel = "0";
	String textoemg = "0";
	String textotempo = "0";
	int[] BPM = new int[300];
	float[] DIS = new float[300];
	float[] VEL = new float[300];
	int[] EMG = new int[300];
	int i = 0;
	int Pbpm = 0;
	float Pdis = 0;
	float Pvel = 0;
	int Pemg = 0;
	int ParcialBpm = 0;
	float ParcialDis = 0;
	float ParcialVel = 0;
	int ParcialEmg = 0;
	int ncoletas;
	String tempo;
	int contadorDecoletas = 0;
	int minutos;
	int tempodesessao;
	int BpmMax = 0;
	float VelMax = 0;
	int EmgMax = 0;
	int numparcial = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		NSTelaMonitoramento window = new NSTelaMonitoramento("","", "", "","","",0);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Create the frame.
	 */
	public NSTelaMonitoramento(String cpfrg, String cardio, String resp, String arte, String NColetas, String TempoDeSessao, int sessaoid) {
		JFrame window = new JFrame();
		window.setTitle("Victus Teste1");
		window.setSize(1200, 670);
		//window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create a drop-down box and connect button, then place them at the top of the window
				JComboBox<String> portList = new JComboBox<String>();
				//JButton connectButton = new JButton("Connect");
				//connectButton.setBounds(0, 0, 0, 0);
				//JButton cButton = new JButton("Teste");
				//cButton.setBounds(0, 0, 0, 0);
				JPanel topPanel = new JPanel();
				GridLayout grid1 = new GridLayout(3,3,5,5);
				topPanel.setBackground(Color.WHITE);
				//topPanel.setOpaque(false);
			    topPanel.setLayout(grid1);
				//topPanel.add(portList);
				//topPanel.add(connectButton);
				//topPanel.add(cButton);
				JPanel Panel1 = new JPanel();
				Panel1.setBackground(new Color(192, 192, 192));
				Panel1.setLayout(null);
				JPanel Panel4 = new JPanel();
				Panel4.setBackground(new Color(255, 255, 255));
				topPanel.add(Panel4);
				Panel4.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\logolaranja.png"));
				lblNewLabel.setBounds(35, 0, 302, 200);
				Panel4.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\monitoramento.png"));
				lblNewLabel_1.setBounds(321, 74, 245, 30);
				Panel4.add(lblNewLabel_1);
				JPanel Panel3 = new JPanel();
				Panel3.setBackground(Color.WHITE);
				//topPanel.add(Panel3);
				JButton connectButton = new JButton("Iniciar");
				connectButton.setForeground(Color.WHITE);
				connectButton.setBackground(Color.BLACK);
				connectButton.setFont(new Font("Calibri", Font.BOLD, 16));
				connectButton.setBounds(107, 42, 147, 35);
				JButton cButton = new JButton("Cancelar");
				
				
				if(!TempoDeSessao.equals("Livre") ) {
					
					tempodesessao = Integer.parseInt(TempoDeSessao);
					
				}
				
				if (tempodesessao <= minutos) {
					
					TelaTempoEsgotado rf = new TelaTempoEsgotado();
					rf.setLocationRelativeTo(null);
					rf.setVisible(true);
					NSTelaPos fr = new NSTelaPos(cardio, resp, arte, cpfrg, BpmMax, VelMax, EmgMax);
					fr.setLocationRelativeTo(null);
					fr.setVisible(true);
					window.setVisible(false);
					
				}
				
					
					
					
				if(!NColetas.equals("Livre") && !NColetas.equals("Nenhuma")) {
					
					ncoletas = Integer.parseInt(NColetas);
					
				}
				
				if(NColetas.equals("Livre")) {
					
					ncoletas = 10;
					
				}
				
				if(NColetas.equals("Nenhuma")) {
					
					ncoletas = 0;
					
				}
				
				cButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Tela1 fr = new Tela1();
						fr.setLocationRelativeTo(null);
						fr.setVisible(true);
						window.setVisible(false);
						
					}
				});
				
				cButton.setForeground(Color.WHITE);
				cButton.setBackground(Color.BLACK);
				cButton.setFont(new Font("Calibri", Font.BOLD, 16));
				cButton.setBounds(336, 116, 147, 35);
				Panel1.add(connectButton);
				Panel1.add(cButton);
				JPanel Panel2 = new JPanel();
				Panel2.setBackground(Color.WHITE);
				Panel2.setLayout(null);
				JButton IniButton = new JButton("Coleta Manual");
				
				IniButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						if((ncoletas == 0) || (contadorDecoletas > ncoletas)) {
							TelaAvisoColetas fr = new TelaAvisoColetas(cpfrg, tempo);
							fr.setLocationRelativeTo(null);
							fr.setVisible(true);
						}
				       	
						else {
						NSTelaColetaManual fr = new NSTelaColetaManual(cpfrg, tempo);
						fr.setLocationRelativeTo(null);
						fr.setVisible(true);
						contadorDecoletas++;
						}
						
					}
				});
				
				IniButton.setForeground(Color.WHITE);
				IniButton.setBackground(Color.BLACK);
				IniButton.setFont(new Font("Calibri", Font.BOLD, 16));
				IniButton.setBounds(336, 42, 147, 35);
				Panel1.add(IniButton);
				JButton EncButton = new JButton("Encerrar");
				
				EncButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
						if (tempodesessao > minutos) {
							
							//TelaEncerrando yrf = new TelaEncerrando();
							//yrf.setLocationRelativeTo(null);
							//yrf.setVisible(true);
							//TelaEncerrando xyrf = new TelaEncerrando();
							//ret = xyrf.retorno();//NSTelaPos fr = new NSTelaPos(cardio, resp, arte, cpfrg);
							//fr.setVisible(true);
							//System.out.println("1");
							//System.out.println(ret);
							//window.setVisible(false);
							//if(ret == 1) {
								//System.out.println("2");
								//System.out.println(ret);
								NSTelaPos fr = new NSTelaPos(cardio, resp, arte, cpfrg,BpmMax, VelMax, EmgMax);
								fr.setLocationRelativeTo(null);
								fr.setVisible(true);
								window.setVisible(false);
									//}
						}
						
					}
				});
				
				EncButton.setForeground(Color.WHITE);
				EncButton.setBackground(Color.BLACK);
				EncButton.setFont(new Font("Calibri", Font.BOLD, 16));
				EncButton.setBounds(107, 116, 147, 35);
				Panel1.add(EncButton);
				//topPanel.add(Panel1);
				//topPanel.add(Panel2);
				//window.add(topPanel, BorderLayout.NORTH);
				
				// populate the drop-down box
				SerialPort[] portNames = SerialPort.getCommPorts();
				for(int i = 0; i < portNames.length; i++)
					portList.addItem(portNames[i].getSystemPortName());
				
				// create the line graph
				XYSeries series = new XYSeries("Frequência Cardíaca");
				XYSeriesCollection dataset = new XYSeriesCollection(series);
				JFreeChart chart = ChartFactory.createXYLineChart("Gráfico BPM", "Tempo (segundos)", "BPM", dataset);
				ChartPanel chartpanel = new ChartPanel(chart);
				chartpanel.setPreferredSize(new java.awt.Dimension(300, 200));
				topPanel.add(chartpanel);
				
				topPanel.add(Panel3);
				Panel3.setLayout(null);
				
				JLabel lblMonitoramento = new JLabel("- Monitoramento -");
				lblMonitoramento.setForeground(Color.BLACK);
				lblMonitoramento.setFont(new Font("Arial", Font.BOLD, 16));
				lblMonitoramento.setBounds(10, 11, 164, 24);
				Panel3.add(lblMonitoramento);
				
				textField = new JTextField(textobpm);
				textField.setFont(new Font("Calibri", Font.PLAIN, 24));
				textField.setBounds(255, 56, 86, 40);
				Panel3.add(textField);
				textField.setColumns(10);
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(NSTelaMonitoramento.class.getResource("/botao1.png")));
				label.setBounds(10, 40, 235, 72);
				Panel3.add(label);
				
				JLabel label_1 = new JLabel("");
				label_1.setIcon(new ImageIcon(NSTelaMonitoramento.class.getResource("/botao3.png")));
				label_1.setBounds(10, 134, 226, 66);
				Panel3.add(label_1);
				
				textField_1 = new JTextField();
				textField_1.setFont(new Font("Calibri", Font.PLAIN, 24));
				textField_1.setBounds(255, 145, 86, 40);
				Panel3.add(textField_1);
				textField_1.setColumns(10);
				
				JEditorPane editorPane = new JEditorPane();
				editorPane.setFont(new Font("Calibri", Font.PLAIN, 14));
				editorPane.setBackground(Color.LIGHT_GRAY);
				editorPane.setBounds(377, 40, 190, 145);
				Panel3.add(editorPane);
				
				JLabel lblObservaes = new JLabel("- Observa\u00E7\u00F5es -");
				lblObservaes.setForeground(Color.BLACK);
				lblObservaes.setFont(new Font("Arial", Font.BOLD, 16));
				lblObservaes.setBounds(377, 21, 140, 19);
				Panel3.add(lblObservaes);
				
				//topPanel.add(Panel2);
				
				XYSeries series2 = new XYSeries("Força Muscular");
				XYSeriesCollection dataset2 = new XYSeriesCollection(series2);
				JFreeChart chart2 = ChartFactory.createXYLineChart("Gráfico EMG", "Tempo (segundos)", "Amplitude", dataset2);
				ChartPanel chartpanel2 = new ChartPanel(chart2);
				chartpanel2.setPreferredSize(new java.awt.Dimension(300, 200));
				//window.add(chartpanel2, BorderLayout.SOUTH);
				topPanel.add(chartpanel2);
				topPanel.add(Panel2);
				
				JLabel label_2 = new JLabel("");
				label_2.setIcon(new ImageIcon(NSTelaMonitoramento.class.getResource("/botao4.png")));
				label_2.setBounds(10, 11, 229, 70);
				Panel2.add(label_2);
				
				textField_2 = new JTextField();
				textField_2.setFont(new Font("Calibri", Font.PLAIN, 24));
				textField_2.setBounds(255, 27, 86, 38);
				Panel2.add(textField_2);
				textField_2.setColumns(10);
				
				JLabel label_3 = new JLabel("");
				label_3.setIcon(new ImageIcon(NSTelaMonitoramento.class.getResource("/botao2.png")));
				label_3.setBounds(10, 92, 229, 70);
				Panel2.add(label_3);
				
				textField_3 = new JTextField();
				textField_3.setFont(new Font("Calibri", Font.PLAIN, 24));
				textField_3.setBounds(255, 109, 86, 38);
				Panel2.add(textField_3);
				textField_3.setColumns(10);
				
				JLabel lblTempoDe = new JLabel("- Tempo de Sess\u00E3o -");
				lblTempoDe.setForeground(Color.BLACK);
				lblTempoDe.setFont(new Font("Arial", Font.BOLD, 16));
				lblTempoDe.setBounds(385, 46, 164, 26);
				Panel2.add(lblTempoDe);
				
				textField_4 = new JTextField();
				textField_4.setFont(new Font("Calibri", Font.BOLD, 25));
				textField_4.setBounds(398, 76, 129, 50);
				Panel2.add(textField_4);
				textField_4.setColumns(10);
				topPanel.add(Panel1);
				
				JLabel lblOpes = new JLabel("- Op\u00E7\u00F5es -");
				lblOpes.setForeground(Color.BLACK);
				lblOpes.setFont(new Font("Arial", Font.BOLD, 16));
				lblOpes.setBounds(33, 11, 109, 20);
				Panel1.add(lblOpes);
				
				window.getContentPane().add(topPanel, BorderLayout.NORTH);
				
				window.setVisible(true);
				// configure the connect button and use another thread to listen for data
			
				connectButton.addActionListener(new ActionListener(){
					@Override public void actionPerformed(ActionEvent arg0) {
						
						if(connectButton.getText().equals("Iniciar")) {
							// attempt to connect to the serial port
							chosenPort = SerialPort.getCommPort(portList.getSelectedItem().toString());
							chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
							if(chosenPort.openPort()) {
								connectButton.setText("Pausar");
								portList.setEnabled(false);
							}
							
							// create a new thread that listens for incoming text and populates the graph
							Thread thread = new Thread(){
								@Override public void run() {
									/*try {
										Thread.sleep(1000);
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} */
									Scanner scanner = new Scanner(chosenPort.getInputStream());
									while(scanner.hasNextLine()) {
										try {
										//	System.out.println("lendo");
											//arrayList.clear();
											//arrayList = null;
											String line = scanner.nextLine();
											String[] textoSeparado = line.split("#");
											//String bmp = textoSeparado[0];
											//System.out.println("split");
											//System.out.println(textoSeparado[0]);
											//System.out.println(textoSeparado[1]);
											//System.out.println(textoSeparado[2]);
											//System.out.println(textoSeparado[3]);
											Random ran = new Random();
											int xxx = ran.nextInt(1201);
											Random ran2 = new Random();
											int xvx = ran2.nextInt(7);
											float velteste = Float.parseFloat(textoSeparado[2]);
											velteste = velteste - xvx;
											//VEL[i] = velteste;
											//EMG[i] = xxx;
											
											BPM[i] = Integer.parseInt(textoSeparado[0]);
											DIS[i] = Float.parseFloat(textoSeparado[1]);
											VEL[i] = Float.parseFloat(textoSeparado[2]);
											EMG[i] = Integer.parseInt(textoSeparado[3]);
										
											if(BpmMax < BPM[i]) {
												BpmMax = BPM[i];
											}
											if(VelMax < VEL[i]) {
												VelMax = VEL[i];
											}
											if(EmgMax < EMG[i]) {
												EmgMax = EMG[i];
											}
											//System.out.println("armazena");
											Pbpm = Pbpm + BPM[i];
											Pdis = DIS[i];
											Pvel = Pvel + VEL[i];
											Pemg = Pemg + EMG[i];
											//BPM = null;
											//DIS = null;
											//VEL = null;
											//EMG = null;
											//System.out.println("antes do tempo");
											//String textoemg = Integer.toString(EMG[i]);
											textobpm = textoSeparado[0];
											textField.setText(textoSeparado[0]);
											textField_1.setText(textoSeparado[1]);
											textField_2.setText(textoSeparado[2]);
											textField_3.setText(textoSeparado[3]);
											tempo = "0" + textoSeparado[4] + ":" + textoSeparado[5];
											textField_4.setText(tempo);
											minutos = Integer.parseInt(textoSeparado[4]);
											//textoSeparado.flush();
											//System.out.println(tempo);
											GerarArquivos frr = new GerarArquivos();
											frr.gerarCsv(cpfrg, tempo, textoSeparado[0], textoSeparado[1], textoSeparado[2], textoSeparado[3]);
											int number = Integer.parseInt(textoSeparado[0]);
											int seg = Integer.parseInt(textoSeparado[5]);
											series.add(x++, number);
											//series.add(seg, number);
											window.repaint();
											int number2 = Integer.parseInt(textoSeparado[3]);
											//series2.add(x, number2);
											series2.add(x, xxx); //COMENTAR AQUI
											window.repaint();
											
											if (tempodesessao <= minutos) {
												
												NSTelaPos fr = new NSTelaPos(cardio, resp, arte, cpfrg,BpmMax, VelMax, EmgMax);
												fr.setVisible(true);
												TelaTempoEsgotado rf = new TelaTempoEsgotado();
												rf.setVisible(true);
												window.setVisible(false);
												tempodesessao = 50;
											}
											
											i++;
											if(seg == 30 || seg == 60) {
												
					                           ParcialBpm = Pbpm / 30;
					                           ParcialDis = Pdis;
					                           ParcialVel = Pvel / 30;
					                           ParcialEmg = Pemg / 30;
					                        
					                           String pbpm = Integer.toString(ParcialBpm);
					                           String pdis = Float.toString(ParcialDis);
					                           String pvel = Float.toString(ParcialVel);
					                           String pemg = Integer.toString(ParcialEmg);
					                           System.out.println(pemg);
					                           
					                    GerarArquivosDeParciais xrr = new GerarArquivosDeParciais();
										xrr.gerarCsv(cpfrg, pbpm, pdis, pvel, pemg);
											
										ManipularBD mbd = new ManipularBD();
								        mbd.inserirParciais(tempo, numparcial, ParcialBpm, ParcialDis, ParcialVel, ParcialEmg, sessaoid);
										numparcial++;
					                           //System.out.println(ParcialBpm);
					                           //System.out.println(ParcialDis);
					                           Pbpm = 0;
					                           Pdis = 0;
					                           Pvel = 0;
					                           Pemg = 0;
					                           i = 0;
					                           
											}
											
											//i++;
											
										} catch(Exception e) {}
									}
									scanner.close();
								}
							};
							thread.start();
						} else {
							// disconnect from the serial port
							chosenPort.closePort();
							portList.setEnabled(true);
							connectButton.setText("Connect");
							series.clear();
							x = 0;
							//NSTelaPos fr = new NSTelaPos(cardio, resp, arte);
							//fr.setVisible(true);
							//window.setVisible(false);
						}
					}
				});
				
		
		//window.setVisible(true);
		
	}
	

}
//}
