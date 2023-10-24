package control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import DTO.SendMail;
import GUI.login;
import run.run;

public class Login_OTP_XacThuc_mouse implements MouseListener{
	private login login;
	
	public Login_OTP_XacThuc_mouse(GUI.login login) {
		this.login = login;
	}

	public void mouseClicked(MouseEvent e) {
		String str= login.getLop().getA().getText()+ login.getLop().getA1().getText()+ login.getLop().getA2().getText()+ login.getLop().getA3().getText()+ login.getLop().getA4().getText()+ login.getLop().getA5().getText();
		if(str.equals(SendMail.getStr()) && !SendMail.getStr().equals("")) {
			login.setVisible(true);
			
			login.showView(3);
			return;
		}
		JOptionPane.showMessageDialog(login, "Mã OTP không chính xác");
	}
	public void mouseExited(MouseEvent e) {
		login.getLop().getLb2().setBackground(Color.decode("#4bcffa"));
	}
	public void mouseEntered(MouseEvent e) {
		login.getLop().getLb2().setBackground(Color.decode("#00a8ff"));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
