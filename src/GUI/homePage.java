package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class homePage extends JPanel{
	private JPanel column1;
	private JPanel column2;
	private JPanel column3;
	private JPanel column4;
	private JPanel column5;
	private JPanel column6;
	private JPanel column7;
	private JPanel column8;
	private JPanel column9;
	private JPanel column10;
	public homePage() {
		init();
	}
	public void init() {
		this.setBackground(Color.decode("#130f40"));
		this.setLayout(null);
		
		// first cart -----------------------------
		JPanel firtsCart = new JCart(Color.decode("#12CBC4"),Color.decode("#0652DD"));   
		firtsCart.setBounds(10, 10, 350, 180);
		firtsCart.setLayout(null);
		this.add(firtsCart);
		JLabel labelicon_1 = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/8.png")).getImage().getScaledInstance(38, 38, Image.SCALE_DEFAULT)));
		labelicon_1.setBounds(16,16,38,38);
		firtsCart.add(labelicon_1);
		
		JLabel labeltext_1 = new JLabel("Number of personel");
		labeltext_1.setFont(new Font("sansserif",1,18));
		labeltext_1.setForeground(Color.white);
		labeltext_1.setBounds(20,60,250,40);
		firtsCart.add(labeltext_1);
		
		JLabel labeltext_2 = new JLabel("2.000.000");
		labeltext_2.setFont(new Font("sansserif",1,20));
		labeltext_2.setForeground(Color.white);
		labeltext_2.setBounds(20,100,180,40);
		firtsCart.add(labeltext_2);
		
		JLabel labeltext_3 = new JLabel("Increased by 60%");
		labeltext_3.setFont(new Font("sansserif",0,15));
		labeltext_3.setForeground(Color.white);
		labeltext_3.setBounds(20,136,180,40);
		firtsCart.add(labeltext_3);
		JCart secondCart = new JCart(Color.decode("#C4E538"),Color.decode("#009432"));
		secondCart.setLayout(null);
		secondCart.setBounds(369, 10, 350, 180);
		this.add(secondCart);
		
		JLabel labelicon_1_1 = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/stock.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		labelicon_1_1.setBounds(16,16,35,35);
		secondCart.add(labelicon_1_1);
		
		JLabel labeltext_1_1 = new JLabel("Number of department");
		labeltext_1_1.setFont(new Font("sansserif",1,18));
		labeltext_1_1.setForeground(Color.white);
		labeltext_1_1.setBounds(20,60,250,40);
		secondCart.add(labeltext_1_1);
		
		JLabel labeltext_2_1 = new JLabel("245");
		labeltext_2_1.setFont(new Font("sansserif",1,20));
		labeltext_2_1.setForeground(Color.white);
		labeltext_2_1.setBounds(20,100,180,40);
		secondCart.add(labeltext_2_1);
		
		JLabel labeltext_3_1 = new JLabel("Increased by 60%");
		labeltext_3_1.setFont(new Font("sansserif",0,15));
		labeltext_3_1.setForeground(Color.white);
		labeltext_3_1.setBounds(20,136,180,40);
		secondCart.add(labeltext_3_1);
		
		
		
		
		
																											// last cart
		JCart lastCart = new JCart(Color.decode("#FFC312"),Color.decode("#EA2027"));
		lastCart.setLayout(null);
		lastCart.setBounds(728, 10, 350, 180);
		this.add(lastCart);
		
		
		JLabel labelicon_1_2 = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/profit.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		labelicon_1_2.setBounds(16,16,35,35);
		lastCart.add(labelicon_1_2);
		
		JLabel labeltext_1_2 = new JLabel("Average Salary");
		labeltext_1_2.setFont(new Font("sansserif",1,18));
		labeltext_1_2.setForeground(Color.white);
		labeltext_1_2.setBounds(20,60,180,40);
		lastCart.add(labeltext_1_2);
		
		JLabel labeltext_2_2 = new JLabel("$15000");
		labeltext_2_2.setFont(new Font("sansserif",1,22));
		labeltext_2_2.setForeground(Color.white);
		labeltext_2_2.setBounds(20,100,180,40);
		lastCart.add(labeltext_2_2);
		
		JLabel labeltext_3_2 = new JLabel("Increased by 60%");
		labeltext_3_2.setFont(new Font("sansserif",0,15));
		labeltext_3_2.setForeground(Color.white);
		labeltext_3_2.setBounds(20,136,180,40);
		lastCart.add(labeltext_3_2);
		

																								// chart
		JPanelOval paneltemp = new JPanelOval();
		paneltemp.setLayout(null);
		paneltemp.setBounds(10, 200, 1100-32, 470);
		this.add(paneltemp);
		
		
		JPanel line = new JPanel();
		line.setBounds(20,430,paneltemp.getWidth()-50,1);
		paneltemp.add(line);
		
		
		column1 = new myColumnChart(Color.decode("#fff200"),Color.decode("#b71540"));
		column1.setBounds(135,100,24,330);
		column1.setBackground(Color.green);
		paneltemp.add(column1);
		
		
		column2 = new myColumnChart(Color.decode("#0fbcf9"),Color.decode("#1B1464"));
		column2.setBounds(169,100,24,330);
		column2.setBackground(Color.red);
		paneltemp.add(column2);
		
		column3 = new myColumnChart(Color.decode("#fff200"),Color.decode("#b71540"));
		column3.setBounds(328,100,24,330);
		column3.setBackground(Color.green);
		paneltemp.add(column3);
		
		column4 = new myColumnChart(Color.decode("#0fbcf9"),Color.decode("#1B1464"));
		column4.setBounds(362,100,24,330);
		column4.setBackground(Color.red);
		paneltemp.add(column4);
		
		column5 = new myColumnChart(Color.decode("#fff200"),Color.decode("#b71540"));
		column5.setBounds(497,100,24,330);
		column5.setBackground(Color.green);
		paneltemp.add(column5);
		
		column6 = new myColumnChart(Color.decode("#0fbcf9"),Color.decode("#1B1464"));
		column6.setBounds(531,100,24,330);
		column6.setBackground(Color.red);
		paneltemp.add(column6);
		
		
		column7 = new myColumnChart(Color.decode("#fff200"),Color.decode("#b71540"));
		column7.setBounds(690,100,24,330);
		column7.setBackground(Color.green);
		paneltemp.add(column7);
		
		
		column8 = new myColumnChart(Color.decode("#0fbcf9"),Color.decode("#1B1464"));
		column8.setBounds(724,100,24,330);
		column8.setBackground(Color.red);
		paneltemp.add(column8);
		
		column9 = new myColumnChart(Color.decode("#fff200"),Color.decode("#b71540"));
		column9.setBounds(883,100,24,330);
		column9.setBackground(Color.green);
		paneltemp.add(column9);
		
		
		column10 = new myColumnChart(Color.decode("#0fbcf9"),Color.decode("#1B1464"));
		column10.setBounds(917,100,24,330);
		column10.setBackground(Color.red);
		paneltemp.add(column10);
		
		
		Font fontFotTitleColumnChart = new Font("Arial",Font.BOLD,13);
		JLabel lbtitleChart = new JLabel("2019");
		lbtitleChart.setBounds(150,400,100,100);
		lbtitleChart.setFont(fontFotTitleColumnChart);
		lbtitleChart.setForeground(Color.white);
		paneltemp.add(lbtitleChart);
		
		
		JLabel lbtitleChart1 = new JLabel("2020");
		lbtitleChart1.setBounds(344,400,100,100);
		lbtitleChart1.setFont(fontFotTitleColumnChart);
		lbtitleChart1.setForeground(Color.white);
		paneltemp.add(lbtitleChart1);
		
		
		JLabel lbtitleChart2 = new JLabel("2021");
		lbtitleChart2.setBounds(513,400,100,100);
		lbtitleChart2.setFont(new Font("Arial",Font.BOLD,13));
		lbtitleChart2.setForeground(Color.white);
		paneltemp.add(lbtitleChart2);
		
		
		JLabel lbtitleChart3 = new JLabel("2022");
		lbtitleChart3.setBounds(708,400,100,100);
		lbtitleChart3.setFont(new Font("Arial",Font.BOLD,13));
		lbtitleChart3.setForeground(Color.white);
		paneltemp.add(lbtitleChart3);
		
		JLabel lbtitleChart4 = new JLabel("2023");
		lbtitleChart4.setBounds(900,400,100,100);
		lbtitleChart4.setFont(new Font("Arial",Font.BOLD,13));
		lbtitleChart4.setForeground(Color.white);
		paneltemp.add(lbtitleChart4);
		
		
		myCircle circle1 = new myCircle(Color.decode("#fff200"),Color.decode("#b71540"));
		circle1.setBounds(1030,20,12,12);
		paneltemp.add(circle1);
		
		myCircle circle2 = new myCircle(Color.decode("#0fbcf9"),Color.decode("#1B1464"));
		circle2.setBounds(1030,50,12,12);
		paneltemp.add(circle2);
		
		JLabel lbcolumn1 = new JLabel("Investment");
		lbcolumn1.setForeground(Color.white);
		lbcolumn1.setFont(fontFotTitleColumnChart);
		lbcolumn1.setBounds(930,20,100,12);
		paneltemp.add(lbcolumn1);
		
		JLabel lbcolumn2 = new JLabel("Profit");
		lbcolumn2.setForeground(Color.white);
		lbcolumn2.setFont(fontFotTitleColumnChart);
		lbcolumn2.setBounds(930,50,100,12);
		paneltemp.add(lbcolumn2);
		
		
	}
	public void chart() {
		Random rd = new Random();
		int arr[] = new int[10];
		for(int i=0;i<10;i++) {
			arr[i] = rd.nextInt(280)+50;
		}
		new Thread(new Runnable() {
			public void run() {
				for(int value=0;value<=arr[0];value++) {
					
					try {
						column1.setBounds(column1.getX(),430-value,column1.getWidth(),value);
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				for(int value=0;value<=arr[1];value++) {
					
					try {
						column2.setBounds(column2.getX(),430-value,column2.getWidth(),value);
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				for(int value=0;value<=arr[2];value++) {
					
					try {
						column3.setBounds(column3.getX(),430-value,column3.getWidth(),value);
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				for(int value=0;value<=arr[3];value++) {
					
					try {
						column4.setBounds(column4.getX(),430-value,column4.getWidth(),value);
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				for(int value=0;value<=arr[4];value++) {
					
					try {
						column5.setBounds(column5.getX(),430-value,column5.getWidth(),value);
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				for(int value=0;value<=arr[5];value++) {
					
					try {
						column6.setBounds(column6.getX(),430-value,column6.getWidth(),value);
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				for(int value=0;value<=arr[6];value++) {
					
					try {
						column7.setBounds(column7.getX(),430-value,column7.getWidth(),value);
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				for(int value=0;value<=arr[7];value++) {
					
					try {
						column8.setBounds(column8.getX(),430-value,column8.getWidth(),value);
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				for(int value=0;value<=arr[8];value++) {
					
					try {
						column9.setBounds(column9.getX(),430-value,column9.getWidth(),value);
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				for(int value=0;value<=arr[9];value++) {
					
					try {
						column10.setBounds(column10.getX(),430-value,column10.getWidth(),value);
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		
	}

	
}
