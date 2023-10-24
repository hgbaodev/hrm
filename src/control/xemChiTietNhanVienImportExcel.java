package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.access_NHANVIEN;
import DTO.NHANVIEN;
import GUI.emplopyeeForm3_Cart2;
import run.App;

public class xemChiTietNhanVienImportExcel extends MouseAdapter{
	private App app;
	public xemChiTietNhanVienImportExcel(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		emplopyeeForm3_Cart2 temp = app.getContent().getEmployeeForm().getEmployeeForm3().getCart2();
		int index = temp.getTable().getSelectedRow();
		if(index<0) {
			app.showMessage("Vui lòng chọn một nhân viên để xem thông tin!");
			return;
		}
		NHANVIEN x = temp.getDanhSachNhanVienImport().getList().get(index);
		app.getContent().getEmployeeForm().getEmployeeForm2().setData(x.getObjectToRender());
		app.getContent().getEmployeeForm().getEmployeeForm2().setImageEmployee(x.getTaiKhoan().getAvatarImg());
		app.getContent().getEmployeeForm().showFrame(1);
		temp.setFlag(true);
	}
}
