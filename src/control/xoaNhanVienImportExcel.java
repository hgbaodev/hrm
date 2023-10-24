package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.access_NHANVIEN;
import DTO.NHANVIEN;
import GUI.emplopyeeForm3_Cart2;
import run.App;

public class xoaNhanVienImportExcel extends MouseAdapter{
	private App app;
	public xoaNhanVienImportExcel(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		emplopyeeForm3_Cart2 temp = app.getContent().getEmployeeForm().getEmployeeForm3().getCart2();
		int index = temp.getTable().getSelectedRow();
		if(index<0) {
			app.showMessage("Vui lòng chọn nhân viên để xóa!");
			return;
		}
		if(temp.getTable().getSelectedRowCount()>1) {
			// xóa nhiều nhân viên
			int listindex[] = temp.getTable().getSelectedRows();
			for(int i=0;i<listindex.length;i++) {
				temp.getDanhSachNhanVienImport().getList().remove(listindex[0]);
			}
		}else {
			// xóa 1 nhân viên
			temp.getDanhSachNhanVienImport().getList().remove(index);
		}			
		
		temp.setData(temp.getDanhSachNhanVienImport().getObjectToRender());
		app.showMessage("Đã xóa nhân viên ra khỏi danh sách import!");
	}
}
