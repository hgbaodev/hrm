package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class SalaryForm extends JPanel{
	private SalaryForm1 salaryForm1;
	private SalaryForm2 salaryForm2;
	private SalaryForm4 salaryForm4;
	private SalaryForm3 salaryForm3;
	private JLabel lbtitle1;
	private JLabel lbtitle2;
	private JLabel lbtitle3;
	private JLabel lbtitle4;
	public SalaryForm() {
		init();
	}
	public void init() {
		this.setLayout(null);
		JPanel frame = new JPanel();
		frame.setBounds(10,10,1080,690);
		frame.setBackground(Color.white);
		frame.setLayout(null);
		this.add(frame);
		
		lbtitle1 = new JLabel("BẢNG LƯƠNG THÁNG");
		lbtitle1.setFont(new Font("Arial",1,13));
		lbtitle1.setBounds(10,5,150,30);
		lbtitle1.setForeground(new Color(0,0,0,140));
		frame.add(lbtitle1);
		
		lbtitle2 = new JLabel("LƯƠNG THƯỞNG");
		lbtitle2.setFont(new Font("Arial",1,13));
		lbtitle2.setBounds(170,5,110,30);
		lbtitle2.setForeground(new Color(0,0,0,60));
		frame.add(lbtitle2);
		lbtitle3 = new JLabel("PHỤ CẤP, KHOẢN TRỪ");
		lbtitle3.setFont(new Font("Arial",1,13));
		lbtitle3.setBounds(300,5,150,30);
		lbtitle3.setForeground(new Color(0,0,0,60));
		frame.add(lbtitle3);
		
		lbtitle4 = new JLabel("TĂNG LƯƠNG");
		lbtitle4.setFont(new Font("Arial",1,13));
		lbtitle4.setBounds(470,5,100,30);
		lbtitle4.setForeground(new Color(0,0,0,60));
		frame.add(lbtitle4);
		
		JPanel panelLineLight = new JPanel();
		panelLineLight.setBounds(5,35,lbtitle1.getWidth(),4);
		panelLineLight.setBackground(Color.decode("#00a8ff"));
		frame.add(panelLineLight);
		JPanel panelLine = new JPanel();
		panelLine.setBounds(0,35,1100,4);
		panelLine.setBackground(Color.decode("#ecf0f1"));
		frame.add(panelLine);
		
		JPanel frameContent = new JPanel();
		frameContent.setBounds(0,40,1080,650);
		frame.add(frameContent);
		frameContent.setLayout(new CardLayout());
		
		salaryForm1 = new SalaryForm1();
		frameContent.add(salaryForm1);
		
		salaryForm2 = new SalaryForm2();
		frameContent.add(salaryForm2);
		
		salaryForm3 = new SalaryForm3();
		frameContent.add(salaryForm3);
		
		salaryForm4 = new SalaryForm4();
		frameContent.add(salaryForm4);
		
		lbtitle1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showView(0);
				
				new Thread(new Runnable() {
					public void run() {
						for(int i=panelLineLight.getX();i>=5;i-=2) {
							panelLineLight.setBounds(i,35,lbtitle1.getWidth(),4);
							repaint();
							try {
								Thread.sleep(1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		});
		lbtitle2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showView(1);
				
				new Thread(new Runnable() {
					public void run() {
						if(panelLineLight.getX()>lbtitle2.getX()) {
							for(int i=panelLineLight.getX();i>=lbtitle2.getX();i-=2) {
								panelLineLight.setBounds(i,35,lbtitle2.getWidth(),4);
								repaint();
								try {
									Thread.sleep(1);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}else {
							for(int i=panelLineLight.getX();i<=lbtitle2.getX();i+=2) {
								panelLineLight.setBounds(i,35,lbtitle2.getWidth(),4);
								repaint();
								try {
									Thread.sleep(1);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}).start();
			}
		});
		lbtitle3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showView(2);
				new Thread(new Runnable() {
					public void run() {
						if(panelLineLight.getX()>lbtitle3.getX()) {
							for(int i=panelLineLight.getX();i>=lbtitle3.getX();i-=2) {
								panelLineLight.setBounds(i,35,lbtitle3.getWidth(),4);
								repaint();
								try {
									Thread.sleep(1);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}else {
							for(int i=panelLineLight.getX();i<=lbtitle3.getX();i+=2) {
								panelLineLight.setBounds(i,35,lbtitle3.getWidth(),4);
								repaint();
								try {
									Thread.sleep(1);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}).start();
			}
		});
		lbtitle4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showView(3);
				new Thread(new Runnable() {
					public void run() {
						for(int i=panelLineLight.getX();i<=lbtitle4.getX()-5;i+=2) {
							panelLineLight.setBounds(i,35,lbtitle4.getWidth(),4);
							repaint();
							try {
								Thread.sleep(1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		});
		showView(0);
		
	}
	public void showView(int index) {
		if(index==0) {
			salaryForm1.setVisible(true);
			salaryForm2.setVisible(false);
			salaryForm3.setVisible(false);
			salaryForm4.setVisible(false);
			lbtitle1.setForeground(new Color(0,0,0,140));
			lbtitle2.setForeground(new Color(0,0,0,60));
			lbtitle3.setForeground(new Color(0,0,0,60));
			lbtitle4.setForeground(new Color(0,0,0,60));
		}else if(index==1) {
			lbtitle1.setForeground(new Color(0,0,0,60));
			lbtitle2.setForeground(new Color(0,0,0,140));
			lbtitle3.setForeground(new Color(0,0,0,60));
			lbtitle4.setForeground(new Color(0,0,0,60));
			salaryForm1.setVisible(false);
			salaryForm2.setVisible(true);
			salaryForm3.setVisible(false);
			salaryForm4.setVisible(false);
		}else if(index==2) {
			salaryForm1.setVisible(false);
			salaryForm2.setVisible(false);
			salaryForm3.setVisible(true);
			salaryForm4.setVisible(false);
			lbtitle1.setForeground(new Color(0,0,0,60));
			lbtitle2.setForeground(new Color(0,0,0,60));
			lbtitle3.setForeground(new Color(0,0,0,140));
			lbtitle4.setForeground(new Color(0,0,0,60));
		}else {
			salaryForm1.setVisible(false);
			salaryForm2.setVisible(false);
			salaryForm3.setVisible(false);
			salaryForm4.setVisible(true);
			lbtitle1.setForeground(new Color(0,0,0,60));
			lbtitle2.setForeground(new Color(0,0,0,60));
			lbtitle3.setForeground(new Color(0,0,0,60));
			lbtitle4.setForeground(new Color(0,0,0,140));
		}
	}
	public SalaryForm1 getSalaryForm1() {
		return this.salaryForm1;
	}
	public SalaryForm2 getSalaryForm2() {
		return this.salaryForm2;
	}
	public SalaryForm4 getSalaryForm4() {
		return this.salaryForm4;
	}
	public SalaryForm3 getSalaryForm3() {
		return this.salaryForm3;
	}
	public JLabel getLb1() {
		return this.lbtitle1;
	}
	public JLabel getLb2() {
		return this.lbtitle2;
	}
	public JLabel getLb3() {
		return this.lbtitle3;
	}
	public JLabel getLb4() {
		return this.lbtitle4;
	}
}
