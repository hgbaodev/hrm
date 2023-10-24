package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.Department_Add;

public class huyThemPhongBan implements ActionListener{
	private Department_Add app;
	public huyThemPhongBan(Department_Add app) {
		this.app = app;
	}
	public void actionPerformed(ActionEvent e) {
		app.setVisible(false);
		
	}
}
