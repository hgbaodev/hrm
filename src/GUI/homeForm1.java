package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class homeForm1 extends JPanel{
	private int employeeData[];
	private int salaryData[];
	private JLabel labelChartValue;
	private ArrayList<JPanel> columnList;
	private Color color1 = Color.decode("#0984e3");
	private Color color2 = Color.decode("#4cd137");
	public homeForm1() {
		this.columnList = new ArrayList<>();
		this.employeeData = new int[] {120,160,140,170}; // max 180 ~ 600
		
		this.salaryData = new int[] {100,120,135,145}; // max 180 ~ 30
		init();
	}
	public void init() {
		this.setBounds(10,340,535,330);
		this.setBackground(Color.white);
		this.setLayout(null);
		// init column
		for(int i=0;i<8;i++) {
			JPanel pn = new JPanel();
			if(i<4) {
				pn.setBackground(color1);
			}else {
				pn.setBackground(color2);
			}
			this.add(pn);
			columnList.add(pn);
		}
		// init line
		for(int i=0;i<6;i++) {
			JPanel line = new JPanel();
			line.setBounds(45,90+i*30,440,1);
			line.setBackground(new Color(0,0,0,90));
			this.setComponentZOrder(line, 0);
			this.add(line);
			
		}
		JPanel line2 = new JPanel();
		line2.setBounds(45,270,440,1);
		line2.setBackground(new Color(0,0,0,255));
		this.add(line2);
		
		JLabel lb1 = new JLabel("0");
		lb1.setFont(new Font("Arial",Font.PLAIN,12));
		lb1.setBounds(26,260,100,20);
		this.add(lb1);
		JLabel lb11 = new JLabel("0");
		lb11.setFont(new Font("Arial",Font.PLAIN,12));
		lb11.setBounds(503,260,100,20);
		this.add(lb11);
		// sl
		for(int i=0;i<6;i++) {
			JLabel lb2 = new JLabel(10+i*10+"");
			lb2.setFont(new Font("Arial",Font.PLAIN,12));
			lb2.setBounds(13,230-i*30,100,20);
			this.add(lb2);
		}
		 // luong
		for(int i=0;i<6;i++) {
			JLabel lb2 = new JLabel(5+i*5+"");
			lb2.setFont(new Font("Arial",Font.PLAIN,12));
			lb2.setBounds(500,230-i*30,100,20);
			this.add(lb2);
		}

		for(int i=0;i<4;i++) {
			JLabel lb10 = new JLabel(LocalDate.now().getYear()-3+i+"");
			lb10.setFont(new Font("Arial",Font.PLAIN,12));
			lb10.setBounds(100+i*100,280,100,20);
			this.add(lb10);
		}
		
		
		
		
		
		JPanel mc2 = new JPanel();
		mc2.setBackground(color1);
		mc2.setBounds(355,42,13,13);
		this.add(mc2);
		JLabel lb15 = new JLabel("Số nhân viên");
		lb15.setFont(new Font("Arial",Font.PLAIN,12));
		lb15.setBounds(280,39,100,20);
		this.add(lb15);
		
		JPanel mc3 = new JPanel();
		mc3.setBackground(color2);
		mc3.setBounds(498,42,13,13);
		this.add(mc3);
		JLabel lb16 = new JLabel("Lương trung bình");
		lb16.setFont(new Font("Arial",Font.PLAIN,12));
		lb16.setBounds(400,39,100,20);
		this.add(lb16);
		JLabel titelLabel3 = new JLabel("Thống kê gần đây");
		titelLabel3.setForeground(new Color(0,0,0,140));
		titelLabel3.setFont(new Font("sansserif", 1, 15));
		titelLabel3.setBounds(12,15,200,24);
		this.add(titelLabel3);
	}
	public void setData(int employeeData[],int salaryData[]) {
		this.employeeData = employeeData;
		this.salaryData = salaryData;
	}
	public void runChart() {
			new Thread(new Runnable() {
				public void run() {
					for(int i=1;i<=employeeData[0];i++) {
						columnList.get(0).setBounds(89,270-i,20,i);
						repaint();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}	
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					for(int i=1;i<=employeeData[1];i++) {
						columnList.get(1).setBounds(188,270-i,20,i);
						repaint();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}	
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					for(int i=1;i<=employeeData[2];i++) {
						columnList.get(2).setBounds(287,270-i,20,i);
						repaint();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}	
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					for(int i=1;i<=employeeData[3];i++) {
						columnList.get(3).setBounds(386,270-i,20,i);
						repaint();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}	
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					for(int i=1;i<=salaryData[0];i++) {
						columnList.get(4).setBounds(124,270-i,20,i);
						repaint();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}	
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					for(int i=1;i<=salaryData[1];i++) {
						columnList.get(5).setBounds(223,270-i,20,i);
						repaint();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}	
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					for(int i=1;i<=salaryData[2];i++) {
						columnList.get(6).setBounds(322,270-i,20,i);
						repaint();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}	
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					for(int i=1;i<=salaryData[3];i++) {
						columnList.get(7).setBounds(421,270-i,20,i);
						repaint();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}	
				}
			}).start();
	}

}
