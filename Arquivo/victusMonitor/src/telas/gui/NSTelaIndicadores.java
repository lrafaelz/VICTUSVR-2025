package telas.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class NSTelaIndicadores extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NSTelaIndicadores frame = new NSTelaIndicadores(null,null,null,null);
					//NSTelaIndicadores frame = new NSTelaIndicadores();
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
	public NSTelaIndicadores(int[] BPM, float[] DIS, float[] VEL, int[] EMG) {
		
		int contador = 0;
		int contador2 = 0;
		//int tamanho = Integer.parseInt(tam);
		
		float[] IBV = new float[BPM.length-1];
		float[] IEV = new float[BPM.length-1];
		float[] IEB = new float[BPM.length-1];
		
		for(int i = 0 ; i < IBV.length ; i++) {
			IBV[i] = (100-((BPM[i+1]*100)/BPM[i]))/ (100-((VEL[i+1]*100)/VEL[i]));}
		for(int i = 0 ; i < IEV.length ; i++) {
			IEV[i] = (100-((EMG[i+1]*100)/EMG[i]))/ (100-((VEL[i+1]*100)/VEL[i]));}
		for(int i = 0 ; i < IEB.length ; i++) {
			IEB[i] = (100-((EMG[i+1]*100)/EMG[i]))/ (100-((BPM[i+1]*100)/BPM[i]));}
		
		
	      JFrame window = new JFrame();
			window.setTitle("Victus Teste1");
			window.setSize(1200, 670);
			//window.setLayout(new BorderLayout());
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel topPanel = new JPanel();
			topPanel.setBackground(Color.WHITE);
		    
		  int t = 60;	
		  JPanel Panel1 = new JPanel();
		  Panel1.setBackground(Color.WHITE);
		  XYSeries series = new XYSeries("%BPM / %Velocidade");
		  XYSeriesCollection dataset = new XYSeriesCollection(series);
		  JFreeChart chart = ChartFactory.createXYLineChart("Indicador 1", "Tempo (segundos)", " ", dataset);
		  Panel1.setLayout(null);
		  ChartPanel chartpanel = new ChartPanel(chart);
		  chartpanel.setBounds(0, 5, 581, 200);
		  chartpanel.setPreferredSize(new java.awt.Dimension(300, 200));	    
		  Panel1.add(chartpanel);
	      for(int b = 0 ; b < IBV.length ; b++) {
		  series.add(t, IBV[b]);
		  t = t + 30;}
	      
	      int t2 = 60;
	      JPanel Panel2 = new JPanel();
	      Panel2.setBackground(Color.WHITE);
	      XYSeries series2 = new XYSeries("%EMG / %Velocidade");
		  XYSeriesCollection dataset2 = new XYSeriesCollection(series2);
		  JFreeChart chart2 = ChartFactory.createXYLineChart("Indicador 2", "Tempo (segundos)", " ", dataset2);
		  Panel2.setLayout(null);
		  ChartPanel chartpanel2 = new ChartPanel(chart2);
		  chartpanel2.setBounds(0, 5, 579, 200);
		  chartpanel2.setPreferredSize(new java.awt.Dimension(300, 200));
		  Panel2.add(chartpanel2);
		  for(int b = 0 ; b < IEV.length ; b++) {
		  series2.add(t2, IEV[b]);
		  t2 = t2 + 30;}
	      
		  int t3 = 60;
	      JPanel Panel3 = new JPanel();
	      Panel3.setBackground(Color.WHITE);
	      XYSeries series3 = new XYSeries("(EMG * CARGA) / BPM");
		  XYSeriesCollection dataset3 = new XYSeriesCollection(series3);
		  JFreeChart chart3 = ChartFactory.createXYLineChart("Indicador 3", "Tempo (segundos)", " ", dataset3);
		  Panel3.setLayout(null);
		  ChartPanel chartpanel3 = new ChartPanel(chart3);
		  chartpanel3.setBounds(0, 0, 579, 195);
		  Panel3.add(chartpanel3);
		  for(int b = 0 ; b < IEB.length ; b++) {
		  series3.add(t3, IEB[b]);
	      t3 = t3 + 30;}
	      
	      
	      JPanel Panel4 = new JPanel();
	      Panel4.setBackground(Color.WHITE);
	      
	      window.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
	      topPanel.setLayout(new GridLayout(0, 2, 0, 0));
		  
	      //topPanel.add(Panel1);
	      //topPanel.add(Panel2);
	      //topPanel.add(Panel3);
	      //topPanel.add(Panel4);
	      JPanel Panel5 = new JPanel();
	      Panel5.setBackground(Color.WHITE);
	      JPanel Panel6 = new JPanel();
	      Panel6.setBackground(Color.WHITE);
	      topPanel.add(Panel5);
	      topPanel.add(Panel4);
	      Panel4.setLayout(null);
	      
	      JLabel label_2 = new JLabel("");
	      label_2.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\Desktop\\logos\\bpm.png"));
	      label_2.setBounds(10, 73, 572, 126);
	      Panel4.add(label_2);
	      
	      JLabel label_1 = new JLabel("");
	      label_1.setBounds(162, 27, 291, 35);
	      label_1.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\Desktop\\logos\\ind.png"));
	      Panel4.add(label_1);
	      Panel5.setLayout(null);
	      
	      JLabel label = new JLabel("");
	      label.setIcon(new ImageIcon("C:\\Users\\Maur\u00EDcio Realan\\Desktop\\logos\\logovictus.png"));
	      label.setBounds(128, 0, 415, 210);
	      Panel5.add(label);
	      topPanel.add(Panel1);
	      topPanel.add(Panel2);
	      topPanel.add(Panel3);
	      topPanel.add(Panel6);
	      Panel6.setLayout(null);
	      
	      JButton btnFinalizar = new JButton("Finalizar");
	      
	      btnFinalizar.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	      	
	      		Tela1 fr = new Tela1();
				fr.setVisible(true);
				window.setVisible(false);
				
	      	}
	      });
	      
	      btnFinalizar.setForeground(Color.WHITE);
	      btnFinalizar.setFont(new Font("Calibri", Font.PLAIN, 24));
	      btnFinalizar.setBackground(Color.BLACK);
	      btnFinalizar.setBounds(212, 95, 185, 39);
	      Panel6.add(btnFinalizar);
		  window.getContentPane().add(topPanel);
	      window.setVisible(true);
	}
}
