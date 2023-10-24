package control;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import run.App;

public class showNhapFileNhanVien extends MouseAdapter{
	private App app;
	public showNhapFileNhanVien(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		app.getContent().getEmployeeForm().showFrame(2);
		app.getContent().getEmployeeForm().getEmployeeForm3().showCart(1);
	}
	public void mouseEntered(MouseEvent e) {
		app.getContent().getEmployeeForm().getEmployeeForm1().getBtnImport().setBackground(Color.decode("#2980b9"));
	}
	public void mouseExited(MouseEvent e) {
		app.getContent().getEmployeeForm().getEmployeeForm1().getBtnImport().setBackground(Color.decode("#3498db"));
	}
}
