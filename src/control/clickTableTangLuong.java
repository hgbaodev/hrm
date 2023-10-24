package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import javax.print.attribute.standard.DateTimeAtCompleted;

import DAO.access_LUONG;
import GUI.SalaryForm1;
import GUI.SalaryForm2;
import GUI.SalaryForm3;
import GUI.SalaryForm4;
import run.App;

public class clickTableTangLuong implements MouseListener{
	private App app;
	public clickTableTangLuong(App app) {
		this.app = app;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		SalaryForm4 form4 = app.getContent().getSalaryForm().getSalaryForm4();
		int selected_pos = form4.getTable().getSelectedRow();
		String value[] = form4.getTable().getValueAt(selected_pos, 1).toString().split(" - ");
		form4.getTfMaNhanVien().setText(value[0]);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
