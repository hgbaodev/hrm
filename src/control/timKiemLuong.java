package control;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import org.apache.poi.hpsf.Array;

import DAO.access_LUONG;
import GUI.SalaryForm1;
import GUI.employeeForm1;
import run.App;

public class timKiemLuong implements KeyListener{
	private App app;
	public timKiemLuong(App app) {
		this.app = app;
	}
	
	public void keyTyped(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
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
		ArrayList<Object[]> listtemp = new ArrayList<>();
		Object[][] objecttemp = access_LUONG.getObjectToRender(phong, thang, nam,sort1,sort2,maNhanVien);
		String find = temp.getTfFind().getText().trim();
		for(int i=0;i<objecttemp.length;i++) {
			if(objecttemp[i][1].toString().toLowerCase().contains(find.toLowerCase())) {
				listtemp.add(objecttemp[i]);
			}
		}
		objecttemp = new Object[listtemp.size()][];
		for(int i=0;i<listtemp.size();i++) {
			objecttemp[i] = listtemp.get(i);
		}
		temp.setSalaryData(objecttemp);
		
	}
	public void keyPressed(KeyEvent e) {
	}

}
