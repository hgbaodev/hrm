package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import DAO.access_TAIKHOAN;
import DTO.SUPPORT;
import GUI.login;

public class xacNhanDoiMatKhau extends MouseAdapter{
	private login dangNhap;
	public xacNhanDoiMatKhau(login dn) {
		this.dangNhap = dn;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		String matKhauMoi = dangNhap.getPanelDoiMatKhau().getTextField().getText().trim();
		
		if(!SUPPORT.checkMatKhau(matKhauMoi)) {
			JOptionPane.showMessageDialog(dangNhap, "Mật khẩu dài từ 6 - 12 kí tự và không được chứa kí tự khoảng trắng!");
			return;
		}
		String taiKhoan = dangNhap.getPanelDoiMatKhau().getTaiKhoan();
		if(taiKhoan.endsWith("gmail.com")) {
			access_TAIKHOAN.updatePassword(access_TAIKHOAN.getUsername(taiKhoan), matKhauMoi);
		}else {
			access_TAIKHOAN.updatePassword(taiKhoan, matKhauMoi);
		}
		dangNhap.showView(0);
		
	}

}
