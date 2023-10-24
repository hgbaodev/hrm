package control;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import run.App;

public class departmentShowAction implements MouseListener{
	private App app;
	public departmentShowAction(App app) {
		this.app = app;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int i = app.getContent().getDepartmentForm().getDepartmentForm1().getTable().getSelectedRow();
		app.renderDepartmentShow(i);
		app.getContent().getDepartmentForm().getDepartmentForm1().showDetailPieChart(0);
		app.getContent().getDepartmentForm().getDepartmentForm1().getCbbPieChart().setSelectedIndex(0);
		app.repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}

}
