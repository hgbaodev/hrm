package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.login;

public class Login_QMK_back_Mouse implements MouseListener{
	private login login;
	
	public Login_QMK_back_Mouse(GUI.login login) {
		this.login = login;
	}

	public void mouseClicked(MouseEvent e) {
		login.getLlp().setVisible(true);
		login.getQmk().setVisible(false);
		login.getLop().setVisible(false);
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
