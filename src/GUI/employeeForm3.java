package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class employeeForm3 extends JPanel{
	private JButton btnBack;
	private employeeForm3_Cart1 cart1;
	private emplopyeeForm3_Cart2 cart2;
	
	private JPanel cart3;
	public employeeForm3() {
		init();
	}
	public void init() {
		this.setLayout(null);
		
		JPanel panelFeature2 = new JPanel();
		panelFeature2.setBounds(10,10,1080,40);
		panelFeature2.setBackground(Color.white);
		this.add(panelFeature2);
		panelFeature2.setLayout(null);

		btnBack= new JButton("Quay lại");
		btnBack.setIcon(new ImageIcon(getClass().getResource("/assets/img/al.png")));
		btnBack.setBounds(5,5,120,30);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		btnBack.setFont(new Font("arial",0,14));
		btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelFeature2.add(btnBack);
		
		
		

		
		JPanel panelFrame = new JPanel();
		panelFrame.setBounds(10,60,1080,645);
		panelFrame.setBackground(Color.white);
		panelFrame.setLayout(null);
		this.add(panelFrame);
		
		JLabel lb1 = new JLabel("NHẬP LIỆU");
		lb1.setFont(new Font("Arial",1,13));
		lb1.setBounds(20,5,90,30);
		lb1.setForeground(new Color(0,0,0,140));
		panelFrame.add(lb1);
		
		JLabel lb2 = new JLabel("IMPORT EXCEL");
		lb2.setFont(new Font("Arial",1,13));
		lb2.setBounds(115,5,110,30);
		lb2.setForeground(new Color(0,0,0,60));
		panelFrame.add(lb2);
		

		
		JPanel panelLineLight = new JPanel();
		panelLineLight.setBounds(15,35,lb1.getWidth(),4);
		panelLineLight.setBackground(Color.decode("#00a8ff"));
		panelFrame.add(panelLineLight);
		JPanel panelLine = new JPanel();
		panelLine.setBounds(0,35,1100,4);
		panelLine.setBackground(Color.decode("#ecf0f1"));
		panelFrame.add(panelLine);
		
		
		JPanel panelFrame2 =  new JPanel();
		panelFrame2.setBounds(0,40,1080,640);
		panelFrame.add(panelFrame2);
		panelFrame2.setLayout(new CardLayout());
		
		cart1 = new employeeForm3_Cart1();
		
		panelFrame2.add(cart1,0);
		
		cart2 = new emplopyeeForm3_Cart2();
		panelFrame2.add(cart2,1);
		
		cart3 = new JPanel();
		cart3.setBackground(Color.green);
		panelFrame2.add(cart3,2);
		
		lb1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showCart(0);
				lb1.setForeground(new Color(0,0,0,140));
				lb2.setForeground(new Color(0,0,0,60));
				new Thread(new Runnable() {
					public void run() {
						for(int i=panelLineLight.getX();i>=15;i-=2) {
							panelLineLight.setBounds(i,35,lb1.getWidth()-10,4);
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
				showCart(1);
				lb1.setForeground(new Color(0,0,0,60));
				lb2.setForeground(new Color(0,0,0,140));
				new Thread(new Runnable() {
					public void run() {
						for(int i=panelLineLight.getX();i<lb2.getX();i+=2) {
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
		showCart(0);
		
	}
	public void showCart(int index) {
		if(index==0) {
			cart1.setVisible(true);
			cart2.setVisible(false);
			cart3.setVisible(false);
		}else if(index==1) {
			cart1.setVisible(false);
			cart2.setVisible(true);
			cart3.setVisible(false);
		}else {
			cart1.setVisible(false);
			cart2.setVisible(false);
			cart3.setVisible(true);
		}
		repaint();
	}
	public JButton getBtnBack() {
		return this.btnBack;
	}
	public employeeForm3_Cart1 getCart1() {
		return this.cart1;
	}
	public emplopyeeForm3_Cart2 getCart2() {
		return this.cart2;
	}
	
	
}
