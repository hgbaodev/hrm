package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.access_LUONG;
import GUI.SalaryForm1;
import GUI.SalaryForm2;
import run.App;

public class locLuongThuong implements ActionListener{
	private App app;
	public locLuongThuong(App app) {
		this.app = app;
	}
	public static Object[][] filter(App app) {
		SalaryForm2 temp = app.getContent().getSalaryForm().getSalaryForm2();
		String nam = temp.getCbbNam().getSelectedItem().toString();
		String thang = temp.getCbbThang().getSelectedItem().toString();
		String phong = temp.getCbbPhong().getSelectedItem().toString();
		int sort1 = temp.getCbbSort().getSelectedIndex();
		int sort2 = temp.getCbbSort2().getSelectedIndex();
		return access_LUONG.getDanhSachLuongThuongToRender(phong, thang, nam,sort1,sort2);
	}
	public void actionPerformed(ActionEvent e) {
		SalaryForm2 temp = app.getContent().getSalaryForm().getSalaryForm2();
		temp.setSalaryData(filter(app));
		// reset cbb focus
		temp.getCbbNam().setFocusable(false);
		temp.getCbbThang().setFocusable(false);
		temp.getCbbPhong().setFocusable(false);
		
	}

}
