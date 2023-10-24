package control;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import DAO.access_HOPDONGLAODONG;
import DAO.access_NHANVIEN;
import DAO.access_TAIKHOAN;
import DTO.HOPDONGLAODONG;
import DTO.NHANVIEN;
import run.App;

public class huyHopDong extends MouseAdapter{
	private App app;
	public huyHopDong(App app) {
		this.app  =app;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int index = app.getContent().getContractForm().getConTractForm1().getTable().getSelectedRow();
		String nhanVien = app.getContent().getContractForm().getConTractForm1().getModel().getValueAt(index, 1).toString();
		int result = app.showOption("Bạn có chắc hủy hợp đồng với nhân viên "+nhanVien+" không?");
		if(result==0) {
			access_NHANVIEN.hiddenNhanVien(nhanVien.split("-")[0].trim());
			app.getContent().getContractForm().getConTractForm1().getModel().removeRow(index);
			app.getContent().getContractForm().getConTractForm1().getOptionPanel().setVisible(false);
			app.showMessage("Đã hủy hợp đồng với nhân viên "+nhanVien+"!");
		}
		
	}
}
