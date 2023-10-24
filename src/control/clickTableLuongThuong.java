package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import DAO.access_LUONG;
import GUI.SalaryForm1;
import GUI.SalaryForm2;
import run.App;

public class clickTableLuongThuong implements MouseListener{
	private App app;
	public clickTableLuongThuong(App app) {
		this.app = app;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		SalaryForm2 form2 = app.getContent().getSalaryForm().getSalaryForm2();
		if(form2.getCbbDonVi().getSelectedIndex()==2) {
			int selected_pos = form2.getObjectTable().getSelectedRow();
			String value[] = form2.getObjectTable().getValueAt(selected_pos, 1).toString().split(" - ");
			form2.getTfMaNhanVienThuong().setText(value[0]);
		}
		
		
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
