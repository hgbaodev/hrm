package control;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import BUS.DANHSACHNHANVIEN;
import GUI.employeeForm1;
import run.App;

public class timKiemNhanVien implements KeyListener{
	private App app;
	public timKiemNhanVien(App app) {
		this.app = app;
	}
	public static DANHSACHNHANVIEN find(App app, DANHSACHNHANVIEN data) {
		employeeForm1 temp = app.getContent().getEmployeeForm().getEmployeeForm1();
		String find = temp.getFindText();
		DANHSACHNHANVIEN list = new DANHSACHNHANVIEN(data.findEmployee(find));
		return list;
	}
	public void keyTyped(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		employeeForm1 temp = app.getContent().getEmployeeForm().getEmployeeForm1();
		DANHSACHNHANVIEN list = find(app, locSapXepNhanVien.filter(app));
		temp.setData(list.getObjectToRender());
		app.getContent().getEmployeeForm().getEmployeeForm1().getScrollPane().getVerticalScrollBar().setValue(0);
	}
	public void keyPressed(KeyEvent e) {
	}

}
