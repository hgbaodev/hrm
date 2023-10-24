package control;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import DTO.SUPPORT;
import GUI.DanhGiaView;
import run.App;



public class showDanhGia extends MouseAdapter{

	private App app;
	
	public showDanhGia(App trangchinh) {
		this.app = trangchinh;
	}

	public void mouseClicked(MouseEvent e) {
		DanhGiaView temp = app.getContent().getDanhGiaForm2();
		int index = temp.getObjectTable().getSelectedRow();	
		String  nhanVien = temp.getTableModel().getValueAt(index, 1).toString();
		temp.getHoTen().setText(nhanVien);
		LocalDate d = LocalDate.now();
		temp.getTfNgayDanhGia().setText(SUPPORT.LocalDateToString(d));
		
	}
}
