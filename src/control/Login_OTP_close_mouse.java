package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.login;

public class Login_OTP_close_mouse implements MouseListener{
	private login login;
	
	public Login_OTP_close_mouse(GUI.login login) {
		this.login = login;
	}

	public void mouseClicked(MouseEvent e) {
//		login.getLqxm().getA1().stop();
		login.getLop().setVisible(false);
		System.out.println("top");
		login.getLop().endrun();
		System.out.println("Bottom");
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
