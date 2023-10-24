package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login_login_Panel extends JPanel{
	private JButton btn;
	private JLabel lb1;
	private TextField username;
	private JTextField pass;
	private JButton btnClose;
	
	public TextField getUsername() {
		return username;
	}
	public void setUsername(TextField username) {
		this.username = username;
	}
	public JTextField getPass() {
		return pass;
	}
	public void setPass(TextField pass) {
		this.pass = pass;
	}
	public JLabel getLb1() {
		return lb1;
	}
	public void setLb1(JLabel lb1) {
		this.lb1 = lb1;
	}
	public JButton getBtnClose() {
		return btnClose;
	}
	public void setBtnClose(JButton btnClose) {
		this.btnClose = btnClose;
	}
	public Login_login_Panel() {
		init();
	}
	
	public JButton getBtn() {
		return btn;
	}
	public void setBtn(JButton btn) {
		this.btn = btn;
	}
	public void init() {
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(600, 0, 400, 550);
		this.setBackground(Color.white);
		
		JLabel label = new JLabel("LOGIN");
		label.setFont(new Font("Arial",Font.PLAIN,23));
		label.setBounds(160,70,200,20);
		this.add(label);
		
		username = new TextField();
		username.setLabelText("Username");
		username.setBounds(50,180,300,50);
		this.add(username);
		
		pass = new PasswordField();
		((PasswordField)pass).setLabelText("Password");
		pass.setBounds(50,240,300,50);
		this.add(pass);

		
		
		btn = new JButton("LOGIN");
		btn.setFont(new Font("Arial",Font.PLAIN,15));
		btn.setForeground(Color.white);
		btn.setBounds(50,340,300,40);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setBackground(Color.decode("#4bcffa"));
		btn.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				btn.setBackground(Color.decode("#4bcffa"));
			}
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(Color.decode("#00a8ff"));
			}

		});
		this.add(btn);
		
		
//		lb1 = new JLabel("Quên mật khẩu ?");
//		lb1.setBounds(160,440,100,20);
//		lb1.setFont(new Font("Arial",Font.PLAIN,13));
//		lb1.setForeground(new Color(0,0,0,100));
//		lb1.addMouseListener(new MouseAdapter() {
//			public void mouseExited(MouseEvent e) {
//				lb1.setForeground(new Color(0,0,0,100));
//				repaint();
//			}
//			public void mouseEntered(MouseEvent e) {
//				lb1.setForeground(Color.decode("#00a8ff"));
//				repaint();
//			}
//		});
//		this.add(lb1);

		
		btnClose = new JButton();
		btnClose.setIcon(new ImageIcon(getClass().getResource("/assets/img/close.png")));
		btnClose.setBounds(375,4,15,15);
		btnClose.setBorderPainted(false);
		btnClose.setFocusPainted(false);
		btnClose.setBackground(Color.white);
		btnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnClose.addMouseListener(new  MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(1);
			}
		});
		this.add(btnClose);
		
		
		
	}
}
