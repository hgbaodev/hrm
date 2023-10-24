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
import run.App;

public class clickTablePhuCapKhoanTru implements MouseListener{
	private App app;
	public clickTablePhuCapKhoanTru(App app) {
		this.app = app;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		SalaryForm3 form3 = app.getContent().getSalaryForm().getSalaryForm3();
		int selected_pos = form3.getTable().getSelectedRow();
		String value[] = form3.getTable().getValueAt(selected_pos, 1).toString().split(" - ");
		String value_time[] = form3.getTable().getValueAt(selected_pos, 2).toString().split("/");
		form3.getTfMaNhanVienTru().setText(value[0]);
		form3.getTfMaNhanVienPhuCap().setText(value[0]);
		LocalDate date = LocalDate.now();
		form3.getCbbNamPhuCap().setSelectedIndex(Integer.valueOf(date.getYear() - Integer.valueOf(value_time[1]) + 1));
		form3.getCbbNamTru().setSelectedIndex(Integer.valueOf(date.getYear() - Integer.valueOf(value_time[1]) + 1));
		form3.getCbbThangPhuCap().setSelectedIndex(Integer.valueOf(value_time[0]));
		form3.getCbbThangTru().setSelectedIndex(Integer.valueOf(value_time[0]));
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
