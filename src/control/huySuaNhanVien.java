package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import run.App;

public class huySuaNhanVien extends MouseAdapter{
	private App app;
	public huySuaNhanVien(App app ) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		app.getContent().getEmployeeForm().showFrame(0);
		app.getContent().getEmployeeForm().getEmployeeForm1().getOptionPanel().setVisible(false);
	}
}
