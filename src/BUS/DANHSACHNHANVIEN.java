package BUS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import DAO.access_CHUCVUCONGTY;
import DAO.access_NHANVIEN;
import DAO.access_PHONGBAN;
import DTO.CHUCVU;
import DTO.CMND;
import DTO.DIACHI;
import DTO.HOPDONGLAODONG;
import DTO.NHANVIEN;
import DTO.NHANVIENCHINHTHUC;
import DTO.NHANVIENTHUVIEC;
import DTO.SUPPORT;
import DTO.TAIKHOAN;
import DTO.TRINHDO;
import GUI.EmployeeForm;

public class DANHSACHNHANVIEN {
	private ArrayList<NHANVIEN> list;
	public DANHSACHNHANVIEN() {
		list  = new ArrayList<NHANVIEN>();
	}
	public DANHSACHNHANVIEN(ArrayList<NHANVIEN> list) {
		this.list = list;
	}
	public ArrayList<NHANVIEN> getList(){
		return this.list;
	}
	
	
	public Object[][] getObjectToRender() {
		int n = list.size();
		Object[][] ob = new Object[n][];
		for(int i=0;i<n;i++) {
			NHANVIEN temp = list.get(i);
			String modeEmployee = "";
			double salary = 0;
			if(temp instanceof NHANVIENTHUVIEC) {
				modeEmployee = "Nhân viên thử việc";
				salary = ((NHANVIENTHUVIEC) temp).getLuongThuViec();
			}else {
				modeEmployee = "Nhân viên chính thức";
				salary = ((NHANVIENCHINHTHUC)temp).getHopDong().getLuongCoBan();
			}
			ob[i] = new Object[] {i+1+"",temp.getTaiKhoan().getAvatarImg(),temp.getMaNhanVien()+","+temp.getHoTen()+","+modeEmployee,temp.getGioiTinh(),temp.getNgaySinh().toString(),temp.getDiaChi().toString(),temp.getSdt(),access_PHONGBAN.getTenTuMaSo(temp.getMaPhong()),temp.getChucVu().getTenChucVu(),SUPPORT.changeSalaryToFormatString(salary)};
		}
		return ob;
	}
	public Object[][] getObjectToExportFile() {
		int n = list.size();
		Object[][] ob = new Object[n][];
		for(int i=0;i<n;i++) {
			NHANVIEN temp = list.get(i);
			String modeEmployee = "";
			double salary = 0;
			if(temp instanceof NHANVIENTHUVIEC) {
				modeEmployee = "Nhân viên thử việc";
				salary = ((NHANVIENTHUVIEC) temp).getLuongThuViec();
			}else {
				modeEmployee = "Nhân viên chính thức";
				salary = ((NHANVIENCHINHTHUC)temp).getHopDong().getLuongCoBan();
			}
			ob[i] = new Object[] {i+1+"",temp.getMaNhanVien(),temp.getHoTen(),temp.getGioiTinh(),SUPPORT.LocalDateToString(temp.getNgaySinh()),temp.getDiaChi().toString(),temp.getDanToc(),temp.getTonGiao(),temp.getTinhTrangHonNhan(),temp.getSdt(),temp.getEmail(),access_PHONGBAN.getTenTuMaSo(temp.getMaPhong()),temp.getChucVu().getTenChucVu(),SUPPORT.LocalDateToString(temp.getChucVu().getNgayNhanChuc()),SUPPORT.changeSalaryToFormatString(salary),modeEmployee};
		}
		return ob;
	}
	public ArrayList<NHANVIEN> findEmployee(String find) {
		ArrayList<NHANVIEN> arr = new ArrayList<>();
		find = find.trim().toLowerCase();
		for(NHANVIEN i : list) {
			if(i.getHoTen().toLowerCase().contains(find) || i.getMaNhanVien().contains(find) || i.getDiaChi().toString().contains(find)) {
				arr.add(i);
			}
		}
		return arr;
	}
	public void deleteByID(String id) {
		for(NHANVIEN i : list) {
			if(i.getMaNhanVien().equalsIgnoreCase(id)) {
				list.remove(i);
				return;
			}
		}
	}
	public NHANVIEN getNhanVien(String maNhanVien) {
		maNhanVien = maNhanVien.trim();
		for(NHANVIEN i : list) {
			if(i.getMaNhanVien().equalsIgnoreCase(maNhanVien)) {
				return i;
			}
		}
		return null;
	}
	public void getDataFromDatabase() {
		list = access_NHANVIEN.getList();
	}
	
	public NHANVIEN addEmployeeFromStringData(String arr[]) {
		NHANVIEN x;
		if(arr[23].equalsIgnoreCase("Nhân viên chính thức") || arr[23].equalsIgnoreCase("Chính thức")) {
			x = new NHANVIENCHINHTHUC();
			((NHANVIENCHINHTHUC)x).setHOPDONG(new HOPDONGLAODONG("HD"+arr[0], SUPPORT.toLocalDate(arr[24]), SUPPORT.toLocalDate(arr[24]).plusYears(Integer.valueOf(arr[25].split(" ")[0])), arr[25], Double.valueOf(arr[27])));
		}else {
			x = new NHANVIENTHUVIEC();
			((NHANVIENTHUVIEC)x).setNgayBatDauThuViec(SUPPORT.toLocalDate(arr[24]));
			((NHANVIENTHUVIEC)x).setNgayKetThucThuViec(SUPPORT.toLocalDate(arr[26]));
			((NHANVIENTHUVIEC)x).setLuongThuViec(Double.valueOf(arr[27]));
		}
		x.setMaNhanVien(arr[0].trim());
		x.setHoTen(SUPPORT.convertHoTen(arr[1].trim()));
		x.setGioiTinh(arr[2]);
		x.setNgaySinh(SUPPORT.toLocalDate(arr[3]));
		x.setSdt(arr[4]);
		x.setEmail(arr[5]);
		DIACHI diaChi = new DIACHI(arr[6].trim(), arr[7].trim(), arr[8].trim(), arr[9].trim(), arr[10].trim());
		x.setDiaChi(diaChi);
		TRINHDO trinhDo = new TRINHDO("TD"+arr[0].trim(), arr[11].trim(), arr[12].trim(), arr[13].trim());
		x.setTrinhDo(trinhDo);
		CMND cmnd = new CMND(arr[14], arr[16],SUPPORT.toLocalDate(arr[15]));
		x.setCmnd(cmnd);
		x.setDanToc(arr[17]);
		x.setTonGiao(arr[18]);
		x.setTinhTrangHonNhan(arr[19]);
		x.setMaPhong(access_PHONGBAN.getMaSoTuTen(arr[20]));
		CHUCVU cv =new CHUCVU("CV"+arr[0], arr[21], access_CHUCVUCONGTY.getPhuCapChucVuCongTy(arr[21]), SUPPORT.toLocalDate(arr[22]));
		x.setChucVu(cv);
		
		TAIKHOAN tk = new TAIKHOAN(arr[0].trim(), arr[0].trim(), null, arr[28].trim());
		x.setTaiKhoan(tk);
		list.add(x);
		return x;
		
	}
	public void sortByName(int type) {
		list.sort((o1, o2) -> SUPPORT.soSanhChuoiUTF8(SUPPORT.convertNameToSort(o1.getHoTen()),SUPPORT.convertNameToSort(o2.getHoTen())));
		if(type!=0) {
			Collections.reverse(list);
		}
    }
	public void sortByID(int type) {
		list.sort((o1,o2) -> o1.getMaNhanVien().compareTo(o2.getMaNhanVien()) );
		if(type!=0) {
			Collections.reverse(list);
		}
	}
	public void sortByAge(int type) {
		list.sort((o1,o2) -> o1.getNgaySinh().compareTo(o2.getNgaySinh()));
		if(type==0) {
			Collections.reverse(list);
		}
	}
	public void sortBySalary(int type) {
		list.sort((o1,o2) -> SUPPORT.compareDouble(o1.getMucLuongChung(), o2.getMucLuongChung()));
		if(type!=0) {
			Collections.reverse(list);
		}
	}
	public ArrayList<NHANVIEN> getNhanVienPhongBan(String maPhong){
		ArrayList<NHANVIEN> arr = new ArrayList<>();
		for(NHANVIEN i : list) {
			if(i.getMaPhong().equalsIgnoreCase(maPhong)) {
				arr.add(i);
			}
		}
		return arr;
	}
	public ArrayList<NHANVIEN> getNhanVienTheoGioiTinh(String gioiTinh){
		ArrayList<NHANVIEN> arr = new ArrayList<>();
		for(NHANVIEN i : list) {
			if(i.getGioiTinh().equalsIgnoreCase(gioiTinh)) {
				arr.add(i);
			}
		}
		return arr;
	}
	public ArrayList<NHANVIEN> getNhanVienTheoDoTuoi(int min, int max){
		ArrayList<NHANVIEN> arr = new ArrayList<>();
		for(NHANVIEN i : list) {
			if(i.getTuoi()>=min && i.getTuoi()<=max) {
				arr.add(i);
			}
		}
		return arr;
	}
	public ArrayList<NHANVIEN> getNhanVienTheoLoaiHinh(String loaiHinh){
		if(loaiHinh.equalsIgnoreCase("Chính thức") || loaiHinh.equalsIgnoreCase("Nhân viên chính thức")) {
			ArrayList<NHANVIEN> arr = new ArrayList<>();
			for(NHANVIEN i : list) {
				if(i instanceof NHANVIENCHINHTHUC) {
					arr.add(i);
				}
			}
			return arr;
		}else {
			ArrayList<NHANVIEN> arr = new ArrayList<>();
			for(NHANVIEN i : list) {
				if(i instanceof NHANVIENTHUVIEC) {
					arr.add(i);
				}
			}
			return arr;
		}
		
	}
	public Object[][] getObjectseToRender_Them() {
        int n = this.list.size();
        Object[][] obj = new Object[n][];
        for (int i = 0; i < n; i++) {
            NHANVIEN temp = list.get(i);
            obj[i] = new Object[]{i + 1 + "", access_NHANVIEN.getTen(temp.getMaNhanVien()),"Chưa chấm công"};
        }
        return obj;
    }
}
