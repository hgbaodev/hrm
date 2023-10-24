package control;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import DAO.access_NHANVIEN;
import DTO.NHANVIEN;
import run.App;

public class xemChiTietNhanVien extends MouseAdapter{
	private App app;
	public xemChiTietNhanVien(App app) {
		this.app  =app;
	}
	public void mouseClicked(MouseEvent e) {
		int index = app.getContent().getEmployeeForm().getEmployeeForm1().getTable().getSelectedRow();
		String data_column2 = (String)app.getContent().getEmployeeForm().getEmployeeForm1().getModel().getValueAt(index, 2);
		String maNhanVien = data_column2.split(",")[0];
		
		System.out.println(maNhanVien);
		NHANVIEN x = app.getData().getDanhSachNhanVien().getNhanVien(maNhanVien);
		app.getContent().getEmployeeForm().getEmployeeForm2().setData(x.getObjectToRender());
		app.getContent().getEmployeeForm().getEmployeeForm2().setImageEmployee(x.getTaiKhoan().getAvatarImg());
		app.getContent().getEmployeeForm().showFrame(1);
	}
}
