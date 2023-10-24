package run;

import java.awt.EventQueue;

import javax.swing.UIManager;

import GUI.login;
import control.Login_Key;
import control.Login_OTP_XacThuc_mouse;
import control.Login_OTP_close_mouse;
import control.Login_QMK_XacThuc_Mouse;
import control.Login_QMK_back_Mouse;
import control.Login_login_Mouse;
import control.dangNhap;
import control.diChuyenChuongTrinh;

public class run {
	private App frame;
	private login log;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					new run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public run() {
		init();
	}
	public void init() {
		frame = new App();
		frame.setUndecorated(true);
		frame.setVisible(false);
		
		log = new login();
		log.setVisible(true);
		dangNhap dn = new dangNhap(this);
		log.getBtnDangNhap().addMouseListener(dn);
	}
	
	public login getLogin() {
		return this.log;
	}
	public App getApp() {
		return this.frame;
	}
}
