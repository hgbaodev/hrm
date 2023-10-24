package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.access_PHONGBAN;
import DAO.access_THONGKE;
import DTO.PHONGBAN;
import GUI.departmentForm2;
import run.App;

public class xoaPhongBan implements ActionListener{
	private App app;
	public xoaPhongBan(App app) {
		this.app = app;
	}
	
	public void actionPerformed(ActionEvent e) {
		departmentForm2 temp = app.getContent().getDepartmentForm().getDepartmentForm2();
		int index = temp.getTable().getSelectedRow();
		if(index<0) {
			app.showMessage("Hãy chọn phòng ban mà bạn muốn xóa!");
			return;
		}
		int result = app.showOption("Bạn có chắc chắn muốn xóa phòng ban này không?");
		// xóa phòng ban
		if(result==0) {
			// xóa khỏi database
			PHONGBAN phongBan = app.getData().getDanhSachPhongBan().getList().get(index);
			int soLuongNhanVien = access_PHONGBAN.getSoLuongNhanVien(phongBan.getMaPhong());
			if(soLuongNhanVien>0) {
				app.showMessage("Phòng ban này hiện có "+soLuongNhanVien+ " nhân viên! Tạm thời không thể xóa!");
				return;
			}
			access_PHONGBAN.deletePhongBan(phongBan.getMaPhong());
			access_THONGKE.deleteTHONGKE(phongBan.getMaPhong());
			// xóa khỏi danh sách
			app.getData().getDanhSachPhongBan().getList().remove(index);
			app.getContent().getDepartmentForm().setDepartmentData(app.getData().getDanhSachPhongBan().getObjectToRender());			
			app.repaint();
		}
		
	}
}
