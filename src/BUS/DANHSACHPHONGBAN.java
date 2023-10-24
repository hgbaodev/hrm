package BUS;


import java.time.LocalDate;
import java.util.ArrayList;

import DAO.access_NHANVIEN;
import DAO.access_PHONGBAN;
import DTO.PHONGBAN;
import DTO.SUPPORT;

public class DANHSACHPHONGBAN {
	private ArrayList<PHONGBAN> list;
	public DANHSACHPHONGBAN() {
		this.list = new ArrayList<>();
		
	}
	public DANHSACHPHONGBAN(ArrayList<PHONGBAN> list) {
		this.list = list;
	}
	public ArrayList<PHONGBAN> getList(){
		return this.list;
	}
	public Object[][] getObjectToRender() {
		Object[][] ob = new Object[list.size()][];
		for(int i=0;i<list.size();i++) {
			PHONGBAN temp = list.get(i);
			// lấy tên trưởng phòng
			String tenTruongPhong = "Chưa có";
			if(!temp.getMaTruongPhong().equals("Chưa có") && !temp.getMaTruongPhong().equals("")) {
				tenTruongPhong = access_NHANVIEN.getTenNhanVien(temp.getMaTruongPhong());
			}
			// lấy ngày nhận chức
			String ngayNhanChuc = "";
			try {
				ngayNhanChuc = SUPPORT.LocalDateToString(access_NHANVIEN.getNhanVien(temp.getMaTruongPhong()).getChucVu().getNgayNhanChuc());
			}catch(Exception e) {
				ngayNhanChuc = "Chưa có";
			}
			ob[i] = new Object[]{"  "+(i+1),temp.getMaPhong()+" - "+temp.getTenPhong(),"  "+SUPPORT.LocalDateToString(temp.getNgayThanhLap()),"  "+tenTruongPhong,"  "+ngayNhanChuc,"  "+access_PHONGBAN.getSoLuongNhanVien(temp.getMaPhong()),"  "+SUPPORT.changeSalaryToFormatString(temp.getAverageSalaryDepartment())};
		}
		return ob;
	}
	public void getDataFromDatabase() {
		this.list = access_PHONGBAN.getList();
	}
	
	public String[] getDanhSachTenPhongBan() {
		String []data = new String[this.list.size()];
		for(int i=0;i<list.size();i++) {
			data[i] = list.get(i).getTenPhong();
		}
		return data;
	}
	public String[] getDanhSachTenPhongBanDeLoc() {
		String []data = new String[this.list.size()+1];
		data[0] = "Phòng ban";
		for(int i=0;i<list.size();i++) {
			data[i+1] = list.get(i).getTenPhong();
		}
		return data;
	}
	public PHONGBAN getPhongBan(String maPhong) {
		for(PHONGBAN i : list) {
			if(i.getMaPhong().equals(maPhong)) {
				return i;
			}
		}
		return null;
	}
	public String getMaPhong(String tenPhong) {
		for(PHONGBAN i : list) {
			if(i.getTenPhong().equalsIgnoreCase(tenPhong)) {
				return i.getMaPhong();
			}
		}
		return "";
	}
}
