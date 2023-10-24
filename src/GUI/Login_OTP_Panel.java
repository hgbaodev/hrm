package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.access_CONNGUOI;
import DTO.SendMail;
import control.Login_Key;

public class Login_OTP_Panel extends JPanel{
	private Thread runTime;
	private JLabel a;
	private int dem=0;
	private ArrayList<JLabel> ArrLabel;
	private JLabel a5;
	private JLabel a4;
	private JLabel a2;
	private JLabel a1;
	private JLabel a3;
	private JButton btnClose;
	private JLabel ss;
	private JLabel lb2;
	private JPanel panelRunTime;
	
	public JLabel getLb2() {
		return lb2;
	}
	public void setLb2(JLabel lb2) {
		this.lb2 = lb2;
	}
	public JButton getBtnClose() {
		return btnClose;
	}
	public void setBtnClose(JButton btnClose) {
		this.btnClose = btnClose;
	}
	public JLabel getSs() {
		return ss;
	}
	public void setSs(JLabel ss) {
		this.ss = ss;
	}
	public ArrayList<JLabel> getArrLabel() {
		return ArrLabel;
	}
	public void setArrLabel(ArrayList<JLabel> arrLabel) {
		ArrLabel = arrLabel;
	}
	public JLabel getA() {
		return a;
	}
	public void setA(JLabel a) {
		this.a = a;
	}
	public JLabel getA5() {
		return a5;
	}
	public void setA5(JLabel a5) {
		this.a5 = a5;
	}
	public JLabel getA4() {
		return a4;
	}
	public void setA4(JLabel a4) {
		this.a4 = a4;
	}
	public JLabel getA2() {
		return a2;
	}
	public void setA2(JLabel a2) {
		this.a2 = a2;
	}
	public JLabel getA1() {
		return a1;
	}
	public void setA1(JLabel a1) {
		this.a1 = a1;
	}
	public JLabel getA3() {
		return a3;
	}
	public void setA3(JLabel a3) {
		this.a3 = a3;
	}
	public Login_OTP_Panel() {
		init();
	}
	public void init() {
		this.setLayout(null);
		ArrLabel = new ArrayList<JLabel>();
		this.setBackground(Color.white);
		Color backGroundOTP = Color.decode("#dfe4ea");
		a= new JLabel();
		a.setBounds(25, 110, 50, 70);
		a.setHorizontalAlignment(JTextField.CENTER);
		a.setOpaque(true);
		a.setBackground(backGroundOTP);
		a.setBorder(null);
		a.setForeground(Color.white);
		a.setFont(new Font("Arial",1,50));
		this.add(a);
		a.setName("1");
		
		
		a1= new JLabel();
		a1.setBounds(85, 110, 50, 70);
		a1.setHorizontalAlignment(JTextField.CENTER);
		a1.setOpaque(true);
		a1.setBackground(backGroundOTP);
		a1.setBorder(null);
		a1.setForeground(Color.white);
		a1.setFont(new Font("Arial",1,50));
		this.add(a1);
		a1.setName("2");

		
		a2= new JLabel();
		a2.setBounds(145, 110, 50, 70);
		a2.setHorizontalAlignment(JTextField.CENTER);
		a2.setOpaque(true);
		a2.setBackground(backGroundOTP);
		a2.setBorder(null);
		a2.setForeground(Color.white);
		a2.setFont(new Font("Arial",1,50));
		this.add(a2);
		a2.setName("3");

		
		a3= new JLabel();
		a3.setBounds(205, 110, 50, 70);
		a3.setHorizontalAlignment(JTextField.CENTER);
		a3.setOpaque(true);
		a3.setBackground(backGroundOTP);
		a3.setBorder(null);
		a3.setForeground(Color.white);
		a3.setFont(new Font("Arial",1,50));
		this.add(a3);
		a3.setName("4");

		
		a4= new JLabel();
		a4.setBounds(265, 110, 50, 70);
		a4.setHorizontalAlignment(JTextField.CENTER);
		a4.setOpaque(true);
		a4.setBackground(backGroundOTP);
		a4.setBorder(null);
		a4.setForeground(Color.white);
		a4.setFont(new Font("Arial",1,50));
		this.add(a4);
		a4.setName("5");

		
		a5= new JLabel();
		a5.setBounds(325, 110, 50, 70);
		a5.setHorizontalAlignment(JTextField.CENTER);
		a5.setOpaque(true);
		a5.setBackground(backGroundOTP);
		a5.setBorder(null);
		a5.setForeground(Color.white);
		a5.setFont(new Font("Arial",1,50));
		this.add(a5);
		a5.setName("5");

		ArrLabel.add(a);
		ArrLabel.add(a1);
		ArrLabel.add(a2);
		ArrLabel.add(a3);
		ArrLabel.add(a4);
		ArrLabel.add(a5);
		
				
		this.setBounds(400,200, 400, 300);
	
		JLabel title= new JLabel("XÁC THỰC OTP");
		title.setFont(new Font("Arial",Font.PLAIN,23));
		title.setBounds(100,40,300,30);
		this.add(title);
		
		ss= new JLabel("1s");
		ss.setBounds(330,186,300,30);
		ss.setForeground(new Color(0,0,0,160));
		this.add(ss);
		
		JPanel panelRunTimeFlatform = new JPanel();
		panelRunTimeFlatform.setBounds(80,200,240,5);
		this.add(panelRunTimeFlatform);
		panelRunTimeFlatform.setBackground(Color.gray);
		this.add(panelRunTimeFlatform);
		panelRunTimeFlatform.setLayout(null);
		panelRunTime = new JPanel();
		panelRunTime.setBounds(0,0,240,5);
		panelRunTimeFlatform.add(panelRunTime);
		panelRunTime.setBackground(Color.green);
		
		
		lb2 = new JLabel("XÁC THỰC",JLabel.CENTER);
		lb2.setFont(new Font("Arial",Font.PLAIN,15));
		lb2.setOpaque(true);
		lb2.setForeground(Color.white);
		lb2.setBounds(50,225,300,40);
		lb2.setBackground(Color.decode("#4bcffa"));
		
		this.add(lb2);
		this.setVisible(false);
		this.setFocusable(true);
		
		btnClose = new JButton();
		btnClose.setIcon(new ImageIcon(getClass().getResource("/assets/img/close.png")));
		btnClose.setBounds(375,4,15,15);
		btnClose.setBorderPainted(false);
		btnClose.setFocusPainted(false);
		btnClose.setBackground(Color.white);
		btnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(btnClose);
		
	}
	public void runtime() {
		runTime = new Thread(new Runnable() {
			public void run() {
				for(int i=1;i<=240;i++) {
					panelRunTime.setBounds(panelRunTime.getX(),panelRunTime.getY(),i,panelRunTime.getHeight());
					if(i%4==0) {
						ss.setText(i/4+"s");
					}
					try {
						Thread.sleep(250);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
				}
				System.out.println("Quá thời gian");
				SendMail.setStr("");
			}
		});
		runTime.start();
	}
	public void endrun() {
		runTime.interrupt();
	}
	

}

