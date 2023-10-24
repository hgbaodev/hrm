package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;import javax.swing.JFrame;

import GUI.login;

public class Login_login_Mouse extends MouseAdapter{
	private login login;
	public Login_login_Mouse(login login) {
		this.login = login;
	}
	public void mouseClicked(MouseEvent e) {
		login.showView(1);
		System.out.println(1);
	}


}
