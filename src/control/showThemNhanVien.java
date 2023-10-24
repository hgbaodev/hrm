package control;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GUI.employeeForm3_Cart1;
import run.App;

public class showThemNhanVien extends MouseAdapter{
	private App app;
	public showThemNhanVien(App app ) {
		this.app = app;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		app.getContent().getEmployeeForm().showFrame(2);
		app.getContent().getEmployeeForm().getEmployeeForm3().showCart(0);
		employeeForm3_Cart1 temp = app.getContent().getEmployeeForm().getEmployeeForm3().getCart1();
		
		temp.getComponentList().get(0).setEnabled(true);
		temp.getComponentList().get(14).setEnabled(true);
		temp.getBtnHuy().setVisible(false);
		temp.getBtnLuu().setVisible(false);
		temp.getBtnReset().setVisible(true);
		temp.getBtnThem().setVisible(true);
		temp.setEnableModeFix(true);
		temp.reset();
	}
	public void mouseEntered(MouseEvent e) {
		app.getContent().getEmployeeForm().getEmployeeForm1().getBtnThem().setBackground(Color.decode("#2980b9"));
	}
	public void mouseExited(MouseEvent e) {
		app.getContent().getEmployeeForm().getEmployeeForm1().getBtnThem().setBackground(Color.decode("#3498db"));
	}
}
