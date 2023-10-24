package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import run.App;

public class suKienFormHopDong1 implements MouseListener{
	private App app;
	public suKienFormHopDong1(App app) {
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
			if(!app.getMangChucNang()[14]) {
				return;
			}
			int value = e.getY();
			System.out.println(value);
			app.getContent().getContractForm().getConTractForm1().getOptionPanel().setBounds(e.getX(),value,189,70);
			value /= 40;
			if(app.getContent().getContractForm().getConTractForm1().getTable().getSelectedRowCount()>1) {
				int arr[] = app.getContent().getContractForm().getConTractForm1().getTable().getSelectedRows();
				app.getContent().getContractForm().getConTractForm1().getTable().setRowSelectionInterval(arr[0],arr[arr.length-1]);
			}else {
				app.getContent().getContractForm().getConTractForm1().getTable().setRowSelectionInterval(value,value);
			}
			app.getContent().getContractForm().getConTractForm1().getOptionPanel().setVisible(true);
			return;
		}
		app.getContent().getContractForm().getConTractForm1().getOptionPanel().setVisible(false);
	}

}
