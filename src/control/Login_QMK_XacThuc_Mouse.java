package control;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import DAO.access_CONNGUOI;
import DAO.access_TAIKHOAN;
import DTO.SendMail;
import GUI.login;

public class Login_QMK_XacThuc_Mouse extends MouseAdapter{
	private login login;
	public Login_QMK_XacThuc_Mouse(GUI.login login) {
		this.login = login;
	}

	public void mouseClicked(MouseEvent e) {
		String a[]=access_TAIKHOAN.getDanhSachEmailVaUsername();
		String input = login.getQmk().getTextField().getText().trim();
		for(int i=0;i<a.length;i++) {
			if(input.equals(a[i])) {
				login.getPanelDoiMatKhau().setTaiKhoan(input);
				login.getTimer().stop();
				login.showView(2);
				//Xử lý gửi gmail
				if(input.endsWith("@gmail.com")) {
					SendMail.send(input);
				}else {
					SendMail.send(access_TAIKHOAN.getEmail(input));
				}
				System.out.println("Gửi mail");

				login.getLop().runtime();
				return;
			}
		}
		JOptionPane.showMessageDialog(login, "Không tìm thấy tài khoản!");
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		login.getQmk().getLb2().setBackground(Color.decode("#00a8ff"));

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		login.getQmk().getLb2().setBackground(Color.decode("#4bcffa"));
	}
}
