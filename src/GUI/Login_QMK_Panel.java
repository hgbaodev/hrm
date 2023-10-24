package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.access_CONNGUOI;

public class Login_QMK_Panel extends JPanel {
	private JLabel back;
	private JTextField textField;
	private JLabel lb2;
	private JButton btnClose;
	
	public JLabel getLb2() {
		return lb2;
	}
	public void setLb2(JLabel lb2) {
		this.lb2 = lb2;
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JLabel getBack() {
		return back;
	}
	public void setBack(JLabel back) {
		this.back = back;
	}
	public Login_QMK_Panel() {
		init();
	}
	public void init() {
		this.setBounds(600,0,400,550);
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setVisible(false);

		JLabel title= new JLabel("FORGOT PASSWORD");
		title.setFont(new Font("Arial",Font.PLAIN,23));
		title.setBounds(85,70,300,20);
		this.add(title);
		
		JLabel lb_qmk= new JLabel("<html>Vui lòng nhập email hoặc tên đăng nhập để tìm kiếm tài khoản của bạn.</html>");
		lb_qmk.setFont(new Font("Arial",0,14));
		lb_qmk.setForeground(new Color(160,160,160));
		lb_qmk.setBounds(50,180,320,60);
		this.add(lb_qmk);
		
		textField = new JTextField();
		textField.setBounds(50,240,300,34);
		textField.setFont(new Font("Arial",0,14));
		this.add(textField);
		

		
		back= new JLabel();
		back.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/arrow_left_login.jpg")).getImage().getScaledInstance(35, 35, Image.SCALE_AREA_AVERAGING)));
		back.setBounds(185,400,35,35);
		this.add(back);
		

		lb2 = new JLabel("XÁC NHẬN",JLabel.CENTER);
		lb2.setFont(new Font("Arial",Font.PLAIN,15));
		lb2.setOpaque(true);
		lb2.setForeground(Color.white);
		lb2.setBounds(50,300,300,40);
		lb2.setBackground(Color.decode("#4bcffa"));
		this.add(lb2);
		
		
		JLabel lb= new JLabel();
		lb.setIcon(new ImageIcon(getClass().getResource("/assets/img/close.png")));
		lb.setBounds(365,4,30,15);
		lb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(1);
			}

		});
		this.add(lb);
		


	
	}
}
