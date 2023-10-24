package control;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GUI.Login_OTP_Panel;
import GUI.login;

public class Login_Key implements KeyListener {
	 private login login; 
	

    public Login_Key(login login) {
		this.login = login;
	}
	int dem=0;
	public void keyPressed(KeyEvent e) {
		System.out.println(1);
		if(!login.getLop().isVisible()) {
			return;
		}
//		try {
			char c= e.getKeyChar();
			// xóa
	        if(e.getKeyCode()==8 || e.getKeyCode()== 127) {
	        	dem--;
	        	if(dem>=0) {
	        		login.getLop().getArrLabel().get(dem).setText(" ");
	        		login.getLop().getArrLabel().get(dem).setBackground(Color.decode("#dfe4ea"));
	        		
	        	}
	            return;
	        }
	        // enter
	        if(e.getKeyCode()==10) {
	        	if(dem<6) {
	        		JOptionPane.showMessageDialog(login, "Mã OTP chưa đủ 6 số");
	        	}
	        }
	        if(dem>=6) {
	        	return;
	        }
	        if(e.getKeyCode()>=48 && e.getKeyCode()<=57) {
	        	if(dem<0) {
	        		dem = 0;
	        	}
	        	login.getLop().getArrLabel().get(dem).setText(c+"");
	        	login.getLop().getArrLabel().get(dem).setBackground(Color.decode("#45aaf2"));
	            dem++;
	            return;
	        }
//		} catch (Exception e2) {
//			// TODO: handle exception
//		}
//        
     }

	

    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {

    }
}
