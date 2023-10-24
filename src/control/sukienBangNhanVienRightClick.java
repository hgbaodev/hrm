package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import run.App;

public class sukienBangNhanVienRightClick implements MouseListener{
	private App app;
	public sukienBangNhanVienRightClick(App app) {
		this.app = app;
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isRightMouseButton(e)) {
			int value = e.getY();
			System.out.println(value);
			app.getContent().getEmployeeForm().getEmployeeForm1().getOptionPanel().setBounds(e.getX(),value,140,100);
			value /= 60;
			if(app.getContent().getEmployeeForm().getEmployeeForm1().getTable().getSelectedRowCount()>1) {
				int arr[] = app.getContent().getEmployeeForm().getEmployeeForm1().getTable().getSelectedRows();
				app.getContent().getEmployeeForm().getEmployeeForm1().getTable().setRowSelectionInterval(arr[0],arr[arr.length-1]);
			}else {
				app.getContent().getEmployeeForm().getEmployeeForm1().getTable().setRowSelectionInterval(value,value);
			}
			app.getContent().getEmployeeForm().getEmployeeForm1().getOptionPanel().setVisible(true);
			return;
		}
		app.getContent().getEmployeeForm().getEmployeeForm1().getOptionPanel().setVisible(false);
	}

}
