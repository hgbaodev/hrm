package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.access_LUONG;
import GUI.SalaryForm1;
import run.App;

public class locLuong implements ActionListener{
	private App app;
	public locLuong(App app) {
		this.app = app;
	}
	public void actionPerformed(ActionEvent e) {
		SalaryForm1 temp = app.getContent().getSalaryForm().getSalaryForm1();
		String nam = temp.getCbbNam().getSelectedItem().toString();
		String thang = temp.getCbbThang().getSelectedItem().toString();
		String phong = temp.getCbbPhong().getSelectedItem().toString();
		int sort1 = temp.getCbbSort().getSelectedIndex();
		int sort2 = temp.getCbbSort2().getSelectedIndex();
		// check xem lương cá nhân
		String maNhanVien = null;
		if(!app.getMangChucNang()[29]) {
			maNhanVien = app.getTaiKhoanDangNhap().getUsername();
		}
		temp.setSalaryData(access_LUONG.getObjectToRender(phong, thang, nam,sort1,sort2,maNhanVien));
		// reset cbb focus
		temp.getCbbNam().setFocusable(false);
		temp.getCbbThang().setFocusable(false);
		temp.getCbbPhong().setFocusable(false);
		
	}

}
