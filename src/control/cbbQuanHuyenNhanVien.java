package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.employeeForm3_Cart1;
import run.App;

public class cbbQuanHuyenNhanVien implements ActionListener{
	private App app;
	public cbbQuanHuyenNhanVien(App app) {
		this.app = app;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		employeeForm3_Cart1 temp = app.getContent().getEmployeeForm().getEmployeeForm3().getCart1();
		int index_tp = temp.getCbbTinhThanhPho().getSelectedIndex();
		int index_qh = temp.getCbbQuanHuyen().getSelectedIndex();
		app.showQuanHuyen(index_tp, index_qh);
		app.repaint();
		
	}

}
