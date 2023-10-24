package BUS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import DAO.access_CHUCVUCONGTY;
import DAO.access_HOPDONGLAODONG;
import DAO.access_NHANVIEN;
import DAO.access_PHONGBAN;
import DTO.HOPDONGLAODONG;
import DTO.NHANVIENCHINHTHUC;
import DTO.SUPPORT;
import connection_database.connection;

public class DANHSACHHOPDONG {

	private access_HOPDONGLAODONG hd;
	private ArrayList<HOPDONGLAODONG> list;

	public void getDataFromDatabase() {
		list = access_HOPDONGLAODONG.getList();
	}

	public DANHSACHHOPDONG() {
		this.list = new ArrayList<HOPDONGLAODONG>();
	}

	public DANHSACHHOPDONG(ArrayList<HOPDONGLAODONG> list) {
		this.list = list;
	}

	public ArrayList<HOPDONGLAODONG> getList() {
		return this.list;
	}
	

	public Object[][] getObjectToRender() {
			int n = list.size();
			Object[][] ob = new Object[n][];
			for (int i = 0; i < n; i++) {
				HOPDONGLAODONG temp = list.get(i);
				if (!temp.getLoaiHopDong().contains("năm")) {
					temp.setLoaiHopDong(temp.getLoaiHopDong() + " năm");
				}
				ob[i] = new Object[] { i + 1 + "", temp.getMaNhanVien()+" - "+temp.getTenNhanVien(),
						temp.getPhongBan(), SUPPORT.LocalDateToString(temp.getTuNgay()),
						SUPPORT.LocalDateToString(temp.getDenNgay()), temp.getLoaiHopDong(),
						"  " + SUPPORT.changeSalaryToFormatString(temp.getLuongCoBan()) };
			}
			return ob;
	}

	public ArrayList<HOPDONGLAODONG> findEmployee(String find) {
		ArrayList<HOPDONGLAODONG> arr = new ArrayList<>();
		find = find.trim().toLowerCase();
		int n = list.size();
		for (HOPDONGLAODONG i : list) {
			if (i.getMaHopDong().toLowerCase().contains(find) || i.getTenNhanVien().toLowerCase().contains(find) || i.getMaNhanVien().contains(find) || i.getLoaiHopDong().contains(find)) {
				arr.add(i);
			}
		}
		return arr;
	}

	public NHANVIENCHINHTHUC getNhanVienByMaNV(String maNhanVien) {
		ArrayList<NHANVIENCHINHTHUC> arr = new ArrayList<>();
		maNhanVien = maNhanVien.trim();
		for (NHANVIENCHINHTHUC i : arr) {
			if (i.getMaNhanVien().equalsIgnoreCase(maNhanVien)) {
				return i;
			}
		}
		return null;
	}

	public void sortByName(int type) {
		list.sort((o1, o2) -> SUPPORT.soSanhChuoiUTF8(SUPPORT.convertNameToSort(o1.getTenNhanVien()),
				SUPPORT.convertNameToSort(o2.getTenNhanVien())));
		if (type != 0) {
			Collections.reverse(list);
		}
	}

	public void sortByID(int type) {
		list.sort((o1, o2) -> o1.getMaHopDong().compareTo(o2.getMaHopDong()));
		if (type != 0) {
			Collections.reverse(list);
		}
	}

	public void sortByLoaiHopDong(int type) {
		list.sort((o1, o2) -> SUPPORT.compareDouble(Integer.valueOf(o1.getLoaiHopDong().split(" ")[0]),Integer.valueOf(o2.getLoaiHopDong().split(" ")[0])));
		if (type != 0) {
			Collections.reverse(list);
		}
	}
	public void sortByTuNgay(int type) {
		list.sort((o1, o2) -> (o1.getTuNgay().compareTo(o2.getTuNgay())));
		if (type != 0) {
			Collections.reverse(list);
		}
	}
	public void sortByDenNgay(int type) {
		list.sort((o1, o2) -> (o1.getDenNgay().compareTo(o2.getDenNgay())));
		if (type != 0) {
			Collections.reverse(list);
		}
	}
	

	public void sortBySalary(int type) {
		list.sort((o1, o2) -> SUPPORT.compareDouble(o1.getLuongCoBan(), o2.getLuongCoBan()));
		if (type != 0) {
			Collections.reverse(list);
		}
	}
//	public ArrayList<HOPDONGLAODONG> getNhanVienByMaHD(String maHopDong){
//		ArrayList<HOPDONGLAODONG> arr = new ArrayList<>();
//		for(HOPDONGLAODONG i : list) {
//			if(i.getMaHopDong().equalsIgnoreCase(maHopDong)) {
//				arr.add(i);
//			}
//		}
//		return arr;
//	}
//	
	public HOPDONGLAODONG getHopDongTheoMaNhanVien(String maNhanVien) {
		
		for (HOPDONGLAODONG i : list) {
			if (i.getMaNhanVien().equals(maNhanVien)) {
				return i;
			}
		}
		return null;
	}
	public ArrayList<HOPDONGLAODONG> getNhanVienByMinLuong(double minSalary) {
		ArrayList<HOPDONGLAODONG> arr = new ArrayList<>();
		for (HOPDONGLAODONG i : list) {
			if (i.getLuongCoBan() >= minSalary) {
				arr.add(i);
			}
		}
		return arr;
	}

	public ArrayList<HOPDONGLAODONG> getNhanVienByMaxLuong(double maxSalary) {
		ArrayList<HOPDONGLAODONG> arr = new ArrayList<>();
		for (HOPDONGLAODONG i : list) {
			if (i.getLuongCoBan() <= maxSalary) {
				arr.add(i);
			}
		}
		return arr;
	}
	public ArrayList<HOPDONGLAODONG> getHopDongTheoTenPhong(String tenPhong) {
		ArrayList<HOPDONGLAODONG> arr = new ArrayList<>();
		for (HOPDONGLAODONG i : list) {
			if (i.getPhongBan().equals(tenPhong) ) {
				arr.add(i);
			}
		}
		return arr;
	}

	public ArrayList<HOPDONGLAODONG> getHopDongTheoLoaiHopDong(String loaiHopDong) {
		if(loaiHopDong.equalsIgnoreCase("trên 10 năm")) {
			return getHopDongTren10Nam();
		}
		ArrayList<HOPDONGLAODONG> arr = new ArrayList<>();
		for (HOPDONGLAODONG i : list) {
			if (i.getLoaiHopDong().equalsIgnoreCase(loaiHopDong)) {
				arr.add(i);
			} 
		}
		return arr;
	}
	public ArrayList<HOPDONGLAODONG> getHopDongTren10Nam() {
		ArrayList<HOPDONGLAODONG> arr = new ArrayList<>();
		for (HOPDONGLAODONG i : list) {
			int thoiHan = Integer.valueOf(i.getLoaiHopDong().split(" ")[0]);
			if (thoiHan>10) {
				arr.add(i);
			} 
		}
		return arr;
	}
}
