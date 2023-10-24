package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class DepartmentForm extends JPanel{
	
	private departmentForm1 phongBanForm ;
	private departmentForm2 quanlyForm;
	private JLabel lb1;
	private JLabel lb2;
	
	public DepartmentForm() {
		init();
	}
	/**
	 * 
	 */
	public void init() {
		this.setLayout(null);
		JPanel frame = new JPanel();
		frame.setBounds(10,10,1080,697);
		frame.setBackground(Color.white);
		frame.setLayout(null);
		this.add(frame);
		
		lb1 = new JLabel("THỐNG KÊ");
		lb1.setFont(new Font("Arial",1,13));
		lb1.setBounds(20,5,80,30);
		lb1.setForeground(new Color(0,0,0,140));
		frame.add(lb1);
		
		lb2 = new JLabel("QUẢN LÝ");
		lb2.setFont(new Font("Arial",1,13));
		lb2.setBounds(110,5,70,30);
		lb2.setForeground(new Color(0,0,0,60));
		frame.add(lb2);
		
		
		JPanel panelLineLight = new JPanel();
		panelLineLight.setBounds(15,35,lb1.getWidth(),4);
		panelLineLight.setBackground(Color.decode("#00a8ff"));
		frame.add(panelLineLight);
		JPanel panelLine = new JPanel();
		panelLine.setBounds(0,35,1100,4);
		panelLine.setBackground(Color.decode("#ecf0f1"));
		frame.add(panelLine);
		
		JPanel frameContent = new JPanel();
		frameContent.setBounds(0,40,1065,659);
		frame.add(frameContent);
		frameContent.setLayout(new CardLayout());
																									// phòng ban
		phongBanForm = new departmentForm1();
		frameContent.add(phongBanForm,0);
		
		quanlyForm = new departmentForm2();
		frameContent.add(quanlyForm,1);
		
		showForm(0);
		
		lb1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showForm(0);
				lb1.setForeground(new Color(0,0,0,140));
				lb2.setForeground(new Color(0,0,0,60));
				new Thread(new Runnable() {
					public void run() {
						for(int i=panelLineLight.getX();i>=15;i-=2) {
							panelLineLight.setBounds(i,35,lb1.getWidth(),4);
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
		lb2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				lb2.setForeground(new Color(0,0,0,140));
				lb1.setForeground(new Color(0,0,0,60));
				new Thread(new Runnable() {
					public void run() {
							showForm(1);
							for(int i=panelLineLight.getX();i<=lb2.getX()-5;i+=2) {
								panelLineLight.setBounds(i,35,lb2.getWidth(),4);
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
	}
	public void showForm(int index) {
		if(index==0) {
			phongBanForm.setVisible(true);
			quanlyForm.setVisible(false);
		}else {
			phongBanForm.setVisible(false);
			quanlyForm.setVisible(true);
		}
	}
	public departmentForm1 getDepartmentForm1() {
		return this.phongBanForm;
	}
	public departmentForm2 getDepartmentForm2() {
		return this.quanlyForm;
	}
	public void setDepartmentData(Object[][] data) {
		this.getDepartmentForm1().setDepartmentData(data);
		this.getDepartmentForm2().setDepartmentData(data);
	}
	public JLabel getLb1() {
		return this.lb1;
	}
	public JLabel getLb2() {
		return this.lb2;
	}
}
