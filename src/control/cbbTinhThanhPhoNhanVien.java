package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import run.App;

public class cbbTinhThanhPhoNhanVien implements ActionListener{
	private App app;
	public cbbTinhThanhPhoNhanVien(App app) {
		this.app = app;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int index = app.getContent().getEmployeeForm().getEmployeeForm3().getCart1().getCbbTinhThanhPho().getSelectedIndex();
		app.showTinhThanhPho(index);
		app.repaint();
		
	}

}
