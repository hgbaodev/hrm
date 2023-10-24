package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import GUI.Department_Add;

public class diChuyenDepartmentAdd extends MouseMotionAdapter{
	private Department_Add app;
	private int x;
	private int y;
	private int mouseX;
	private int mouseY;
	public diChuyenDepartmentAdd(Department_Add app) {
		this.app = app;
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		x = app.getX();
		y = app.getY();
		mouseX = e.getX();
		mouseY = e.getY();
	}
	public void mouseDragged(MouseEvent e) {
		
		int tempX = e.getX();
		int tempY = e.getY();
		x += (tempX-mouseX);
		y+= (tempY-mouseY);
		app.setBounds(x,y,app.getWidth(),app.getHeight());
		app.repaint();
	}
}
