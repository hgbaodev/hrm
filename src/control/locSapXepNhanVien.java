package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import BUS.DANHSACHNHANVIEN;
import DAO.access_NHANVIEN;
import DAO.access_PHONGBAN;
import GUI.employeeForm1;
import run.App;

public class locSapXepNhanVien implements ActionListener{
	private App app;
	public locSapXepNhanVien(App app) {
		this.app = app;
	}
	public static DANHSACHNHANVIEN filter(App app) {
		employeeForm1 temp = app.getContent().getEmployeeForm().getEmployeeForm1();
		DANHSACHNHANVIEN danhSachLoc = null;
		// lọc phòng ban, giới tính, độ tuổi, loại hình
		if(temp.getCbbFilterPhongBan().getSelectedIndex()==0 && temp.getCbbFilterGioiTinh().getSelectedIndex()==0 && temp.getCbbFilterDoTuoi().getSelectedIndex()==0 && temp.getCbbFilterLoaiHinh().getSelectedIndex()==0) {
			danhSachLoc = app.getData().getDanhSachNhanVien();
		}
		String tenPhongban = temp.getCbbFilterPhongBan().getSelectedItem().toString();
		String gioiTinh = temp.getCbbFilterGioiTinh().getSelectedItem().toString();
		String doTuoi = temp.getCbbFilterDoTuoi().getSelectedItem().toString();
		String loaiHinh = temp.getCbbFilterLoaiHinh().getSelectedItem().toString();
		// lọc mức lương
				String mucLuong = temp.getCbbFilterMucLuong().getSelectedItem().toString();
		danhSachLoc = new DANHSACHNHANVIEN(access_NHANVIEN.getListFilterAndSort(tenPhongban, gioiTinh, doTuoi, loaiHinh,mucLuong));
		
		
		
		// sắp xếp
		int sortby = temp.getCbbSortBy().getSelectedIndex();
		int sortmode = temp.getCbbSortMode().getSelectedIndex();
		if(sortby==0) {
			danhSachLoc.sortByID(sortmode);
		}else if(sortby==1) {
			danhSachLoc.sortByName(sortmode);
		}else if(sortby==2){
			danhSachLoc.sortByAge(sortmode);
		}else {
			danhSachLoc.sortBySalary(sortmode);
		}
				
		temp.getCbbFilterPhongBan().setFocusable(false);
		temp.getCbbFilterGioiTinh().setFocusable(false);
		temp.getCbbFilterDoTuoi().setFocusable(false);
		return danhSachLoc;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DANHSACHNHANVIEN danhSachLoc = filter(app);
		danhSachLoc = timKiemNhanVien.find(app, danhSachLoc);
		app.getContent().getEmployeeForm().getEmployeeForm1().setData(danhSachLoc.getObjectToRender());
		app.getContent().getEmployeeForm().getEmployeeForm1().getScrollPane().getVerticalScrollBar().setValue(0);
	}

}
