package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import run.App;

public class diChuyenOptionPanel extends MouseMotionAdapter{
	private JPanel panel;
	private int x;
	private int y;
	private int mouseX;
	private int mouseY;
	public diChuyenOptionPanel(JPanel panel) {
		this.panel = panel;
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
		x = panel.getX();
		y = panel.getY();
		mouseX = e.getX();
		mouseY = e.getY();
	}
	public void mouseDragged(MouseEvent e) {
		
		int tempX = e.getX();
		int tempY = e.getY();
		x += (tempX-mouseX);
		y+= (tempY-mouseY);
		panel.setBounds(x,y,panel.getWidth(),panel.getHeight());
		panel.repaint();
	}
}
