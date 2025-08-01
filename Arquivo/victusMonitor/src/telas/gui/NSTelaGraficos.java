package telas.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class NSTelaGraficos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		NSTelaGraficos window = new NSTelaGraficos(null, "");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Create the frame.
	 */
	public NSTelaGraficos( String[] Parcial, String tam)
	   {
	      //super(applicationTitle);
		int contador = 0;
		int contador2 = 0;
		int tamanho = Integer.parseInt(tam);
		int t1 = 30;
		int t2 = 30;
		int t3 = 30;
		int t4 = 30;
		
		/*int PBpm1 = Integer.parseInt(Parcial[0]);
		int PBpm2 = Integer.parseInt(Parcial[4]);
		float PDis1 = Float.parseFloat(Parcial[1]);
		float PDis2 = Float.parseFloat(Parcial[5]);
		float PVel1 = Float.parseFloat(Parcial[2]);
		float PVel2 = Float.parseFloat(Parcial[6]);
		int PEmg1 = Integer.parseInt(Parcial[3]);
		int PEmg2 = Integer.parseInt(Parcial[7]);
	//*/
		int cont = tamanho/4;
		
		int[] BPM = new int[30];
		float[] DIS = new float[30];
		float[] VEL = new float[30];
		int[] EMG = new int[30];
				
		
		while (contador2 <= tamanho) {
			BPM[contador] = Integer.parseInt(Parcial[contador2]);
			DIS[contador] = Float.parseFloat(Parcial[contador2 + 1]);
			VEL[contador] = Float.parseFloat(Parcial[contador2 + 2]);
			EMG[contador] = Integer.parseInt(Parcial[contador2 + 3]);
			contador++;
			contador2 = contador2 + 4;
		}
		
		
		/*
		int PBpm1 = 85;
		int PBpm2 = 94;
		float PDis1 = 70;
		float PDis2 = 120;
		float PVel1 = 17;
		float PVel2 = 19;
		float PEmg1 = 700;
		float PEmg2 = 600;
		//*/
		
	      JFrame window = new JFrame();
			window.setTitle("Victus Teste1");
			window.setSize(1200, 670);
			//window.setLayout(new BorderLayout());
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel topPanel = new JPanel();
			topPanel.setBackground(Color.WHITE);
		    
		    JPanel Panel1 = new JPanel();
		    Panel1.setBackground(Color.WHITE);
		  XYSeries series = new XYSeries("Frequência Cardíaca");
		  XYSeriesCollection dataset = new XYSeriesCollection(series);
		  JFreeChart chart = ChartFactory.createXYLineChart("Gráfico BPM", "Tempo (segundos)", "BPM", dataset);
		  Panel1.setLayout(null);
		  ChartPanel chartpanel = new ChartPanel(chart);
		  chartpanel.setBounds(0, 5, 581, 200);
		  chartpanel.setPreferredSize(new java.awt.Dimension(300, 200));	    
		  Panel1.add(chartpanel);
		  for(int b = 0 ; b < cont; b++) {
	      series.add(t1, BPM[b]);
	      t1 = t1 + 30;}
	      //series.add(60, PBpm2);
	      
	      JPanel Panel2 = new JPanel();
	      Panel2.setBackground(Color.WHITE);
	      XYSeries series2 = new XYSeries("Distância");
		  XYSeriesCollection dataset2 = new XYSeriesCollection(series2);
		  JFreeChart chart2 = ChartFactory.createXYLineChart("Distância Percorrida", "Tempo (segundos)", "Metros", dataset2);
		  Panel2.setLayout(null);
		  ChartPanel chartpanel2 = new ChartPanel(chart2);
		  chartpanel2.setBounds(0, 5, 579, 200);
		  chartpanel2.setPreferredSize(new java.awt.Dimension(300, 200));
		  Panel2.add(chartpanel2);
		  for(int d = 0 ; d < cont; d++) {
		      series2.add(t2, DIS[d]);
		      t2 = t2 + 30;}
		 // series2.add(30, PDis1);
	      //series2.add(60, PDis2);
		  
	      JPanel Panel3 = new JPanel();
	      Panel3.setBackground(Color.WHITE);
	      XYSeries series3 = new XYSeries("Velocidade");
		  XYSeriesCollection dataset3 = new XYSeriesCollection(series3);
		  JFreeChart chart3 = ChartFactory.createXYLineChart("Velocidade Média", "Tempo (segundos)", "Km / h", dataset3);
		  Panel3.setLayout(null);
		  ChartPanel chartpanel3 = new ChartPanel(chart3);
		  chartpanel3.setBounds(0, 0, 579, 195);
		  Panel3.add(chartpanel3);
		  for(int v = 0 ; v < cont; v++) {
		      series3.add(t3, VEL[v]);
		      t3 = t3 + 30;}
		  //series3.add(30, PVel1);
	      //series3.add(60, PVel2);
	      
	      JPanel Panel4 = new JPanel();
	      Panel4.setBackground(Color.WHITE);
	      XYSeries series4 = new XYSeries("Força Muscular");
		  XYSeriesCollection dataset4 = new XYSeriesCollection(series4);
		  JFreeChart chart4 = ChartFactory.createXYLineChart("Gráfico EMG", "Tempo (segundos)", "Amplitude", dataset4);
		  Panel4.setLayout(null);
		  ChartPanel chartpanel4 = new ChartPanel(chart4);
		  chartpanel4.setForeground(Color.BLACK);
		  chartpanel4.setBounds(0, 5, 582, 205);
		  Panel4.add(chartpanel4);
		  for(int e = 0 ; e < cont; e++) {
		      series4.add(t4, EMG[e]);
		      t4 = t4 + 30;}
		  //series4.add(30, PEmg1);
	      //series4.add(60, PEmg2);
	      
	      window.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
	      topPanel.setLayout(new GridLayout(0, 2, 0, 0));
		  
	      topPanel.add(Panel1);
	      topPanel.add(Panel2);
	      topPanel.add(Panel3);
	      topPanel.add(Panel4);
	      JPanel Panel5 = new JPanel();
	      Panel5.setBackground(Color.WHITE);
	      JPanel Panel6 = new JPanel();
	      Panel6.setBackground(Color.WHITE);
	      topPanel.add(Panel5);
	      Panel5.setLayout(null);
	      
	      JLabel label = new JLabel("");
	      label.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\logolaranja.png"));
	      label.setBounds(47, 0, 323, 210);
	      Panel5.add(label);
	      
	      JLabel lblNewLabel = new JLabel("l");
	      lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\eclipse-workspace\\Victus Teste1\\src\\telas\\gui\\graficos.png"));
	      lblNewLabel.setBounds(391, 43, 128, 115);
	      Panel5.add(lblNewLabel);
	      topPanel.add(Panel6);
	      Panel6.setLayout(null);
	      
	      JButton button = new JButton("Indicadores");
	      
	      button.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	      	
	      		NSTelaIndicadores ni = new NSTelaIndicadores(BPM, DIS, VEL, EMG);
	      		ni.setLocationRelativeTo(null);
	      		ni.setVisible(true);
				window.setVisible(false);
	      		
	      	}
	      });
	      
	      button.setBounds(57, 90, 201, 39);
	      button.setForeground(Color.WHITE);
	      button.setFont(new Font("Calibri", Font.PLAIN, 24));
	      button.setBackground(Color.BLACK);
	      Panel6.add(button);
	      
	      JButton btnFinalizar = new JButton("Finalizar");
	      
	      btnFinalizar.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	      	
	      		Tela1 fr = new Tela1();
	      		fr.setLocationRelativeTo(null);
	      		fr.setVisible(true);
				window.setVisible(false);
				
	      	}
	      });
	      
	      btnFinalizar.setForeground(Color.WHITE);
	      btnFinalizar.setFont(new Font("Calibri", Font.PLAIN, 24));
	      btnFinalizar.setBackground(Color.BLACK);
	      btnFinalizar.setBounds(325, 90, 147, 39);
	      Panel6.add(btnFinalizar);
		  window.getContentPane().add(topPanel);
	      window.setVisible(true);
	   }
}
