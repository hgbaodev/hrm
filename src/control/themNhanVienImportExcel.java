package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.access_BANGDANHGIA;
import DAO.access_NHANVIEN;
import DTO.CHECK;
import DTO.NHANVIEN;
import GUI.emplopyeeForm3_Cart2;
import run.App;

public class themNhanVienImportExcel extends MouseAdapter{
	private App app;
	public themNhanVienImportExcel(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		emplopyeeForm3_Cart2 temp = app.getContent().getEmployeeForm().getEmployeeForm3().getCart2();
		int index = temp.getTable().getSelectedRow();
		if(index<0) {
			app.showMessage("Vui lòng chọn nhân viên để thêm!");
			return;
		}
		// kiểm tra dữ liệu
		NHANVIEN x = temp.getDanhSachNhanVienImport().getList().get(index);
		if(!CHECK.checkMaNhanVienTonTai(x.getMaNhanVien())) {
			if(!CHECK.checkCMNDTonTai(x.getCmnd().getSoCmnd())) {
				access_NHANVIEN.insertNHANVIEN(x);
				// xóa 1 nhân viên
				temp.getDanhSachNhanVienImport().getList().remove(temp.getTable().getSelectedRow());
				temp.setData(temp.getDanhSachNhanVienImport().getObjectToRender());
				app.showMessage("Đã thêm thành công nhân viên vào danh sách nhân viên chính thức");
				return;
				
			}
			app.showMessage("Số chứng minh thư trùng với nhân viên khác! Không thể thêm nhân viên này!");
			return;
			
		}
		app.showMessage("Mã nhân viên trùng với nhân viên khác! Không thể thêm nhân viên này!");
		
		
	}
}
