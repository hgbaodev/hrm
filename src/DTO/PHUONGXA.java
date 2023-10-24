package DTO;

import java.util.ArrayList;

public class PHUONGXA {
	private String tenPhuongXa;
	private ArrayList<String> danhSachDuong;
	public PHUONGXA() {
		tenPhuongXa = "";
		danhSachDuong = new ArrayList<>();
	}
	public String getTenPhuongXa() {
		return tenPhuongXa;
	}
	public void setTenPhuongXa(String tenPhuongXa) {
		this.tenPhuongXa = tenPhuongXa;
	}
	public ArrayList<String> getDanhSachDuong() {
		return danhSachDuong;
	}
	public void setDanhSachDuong(ArrayList<String> danhSachDuong) {
		this.danhSachDuong = danhSachDuong;
	}
	public String[] getDanhSachDuongString() {
		String list[] = new String[danhSachDuong.size()];
		for(int i=0;i<danhSachDuong.size();i++) {
			list[i] = danhSachDuong.get(i);
		}
		return list;
	}
}
