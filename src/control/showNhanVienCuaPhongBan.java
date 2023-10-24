package control;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.access_PHONGBAN;
import GUI.departmentForm2;
import run.App;

public class showNhanVienCuaPhongBan extends MouseAdapter {
	private App app;
	public showNhanVienCuaPhongBan(App app) {
		this.app = app;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		departmentForm2 temp = app.getContent().getDepartmentForm().getDepartmentForm2();
		int index = temp.getTable().getSelectedRow();
		String maSo = app.getData().getDanhSachPhongBan().getList().get(index).getMaPhong();
		temp.setEmployeeData(access_PHONGBAN.getNhanVienCuaPhongBanData(maSo));
		temp.setTitleEmployee("Nhân viên - "+access_PHONGBAN.getTenTuMaSo(maSo));
		
	}



}
