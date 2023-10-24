package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class myHeader extends JPanel{
	private myImageAvatar lbUser;

	public myHeader() {
		init();
	}
	
	public void init() {
		this.setLayout(null);
		this.setBackground(Color.decode("#2980b9"));
		JLabel lbUser1 = new JLabel();
		lbUser1.setBounds(2,2,55,40);
		lbUser1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/mylogo4.png")).getImage().getScaledInstance(lbUser1.getWidth(), lbUser1.getHeight(), Image.SCALE_DEFAULT)));
		this.add(lbUser1);
		
		JLabel l1 = new JLabel("HRMSystem");
		l1.setBounds(60,2,200,30);
		l1.setFont(new Font("Arial",1,18));
		l1.setForeground(new Color(255,255,255,240));
		this.add(l1);
		
		JLabel l2 = new JLabel("Version 1.0.2");
		l2.setBounds(60,20,100,30);
		l2.setFont(new Font("Arial",0,12));
		l2.setForeground(new Color(255,255,255,240));
		this.add(l2);
		
		
		lbUser = new myImageAvatar();
		lbUser.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/user_img/user11.jpg")).getImage().getScaledInstance(34,34,Image.SCALE_AREA_AVERAGING)));
		lbUser.setBounds(1245,5,34,34);
		lbUser.setBorderSize(2);
		this.add(lbUser);
		
		lbUser.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				System.out.println("User Setting....");
//				showUserSetting();
			}
		});
		
//		JLabel username = new JLabel("Quan Phat");
//		username.setBounds(950,4,76,20);
//		username.setFont(new Font("Arial",Font.BOLD,13));
//		this.add(username);
//		
//		JLabel descriptionUser = new JLabel("Admin");
//		descriptionUser.setBounds(980,20,100,20);
//		descriptionUser.setFont(new Font("Arial",Font.PLAIN,12));
//		descriptionUser.setForeground(Color.decode("#718093"));
//		this.add(descriptionUser);
		
		JPanel separate = new JPanel();
		separate.setBounds(1228,11,1,24);
		separate.setBackground(new Color(255,255,255,100));
		this.add(separate);
		 
		
		JLabel notification = new JLabel();
		notification.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/notification.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		notification.setBounds(1120,15,20,20);
		this.add(notification);
		
		
		JLabel message = new JLabel();
		message.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/message.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		message.setBounds(1175,15,20,20);
		this.add(message);
		
		myNotification numberOfMessage = new myNotification();
		numberOfMessage.setBounds(1180,10,17,17);
		numberOfMessage.setNumber(11);
		this.add(numberOfMessage);
		
		myNotification numberOfNotify = new myNotification();
		numberOfNotify.setBounds(1128,10,17,17);
		numberOfNotify.setNumber(6);
		this.add(numberOfNotify);
		JButton btnClose = new JButton();
		btnClose.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/close_app.png")).getImage().getScaledInstance(18, 18, Image.SCALE_AREA_AVERAGING)));
		btnClose.setBounds(1290,13,18,18);
		btnClose.setBackground(Color.white);
		btnClose.setBackground(this.getBackground());
		btnClose.setBorderPainted(false);
		btnClose.setFocusPainted(false);
		this.add(btnClose);
		btnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnClose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			public void mouseEntered(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/close_app_hover.png")).getImage().getScaledInstance(18, 18, Image.SCALE_AREA_AVERAGING)));
			}
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/close_app.png")).getImage().getScaledInstance(18, 18, Image.SCALE_AREA_AVERAGING)));
			}
		});
		this.setComponentZOrder(numberOfMessage, 0);
		this.setComponentZOrder(message, 1);
		this.setComponentZOrder(numberOfNotify, 1);
		this.setComponentZOrder(notification, 2);
	}
	public void changeAvatar(String file) {
		lbUser.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/user_img/"+file)).getImage().getScaledInstance(34,34,Image.SCALE_AREA_AVERAGING)));
	}
}
