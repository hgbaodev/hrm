package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.NHANVIEN;
import GUI.employeeForm1;
import run.App;

public class showSuaNhanVien extends MouseAdapter{
	private App app;
	public showSuaNhanVien(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		
		employeeForm1 temp = app.getContent().getEmployeeForm().getEmployeeForm1();
		int index = temp.getTable().getSelectedRow();
		String maNhanVien = (temp.getModel().getValueAt(index,2)+"").split(",")[0];
		System.out.println("Sửa nhân viên "+maNhanVien);
		app.getContent().getEmployeeForm().getEmployeeForm3().getCart1().setMaNhanVienSua(maNhanVien);
		app.getContent().getEmployeeForm().showFrame(2);
		app.getContent().getEmployeeForm().getEmployeeForm3().getCart1().getComponentList().get(0).setEnabled(false);
		app.getContent().getEmployeeForm().getEmployeeForm3().getCart1().getComponentList().get(14).setEnabled(false);
		NHANVIEN nhanVien = app.getData().getDanhSachNhanVien().getNhanVien(maNhanVien);
		app.getContent().getEmployeeForm().getEmployeeForm3().getCart1().setDataToFix(nhanVien.getDataToFix());
	}
}
