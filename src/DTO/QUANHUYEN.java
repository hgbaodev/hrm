package DTO;

import java.util.ArrayList;

public class QUANHUYEN {
	private String tenQuanHuyen;
	private ArrayList<PHUONGXA> danhSachPhuongXa;
	public QUANHUYEN() {
		tenQuanHuyen = "";
		danhSachPhuongXa = new ArrayList<>();
	}
	public String getTenQuanHuyen() {
		return tenQuanHuyen;
	}
	public void setTenQuanHuyen(String tenQuanHuyen) {
		this.tenQuanHuyen = tenQuanHuyen;
	}
	public ArrayList<PHUONGXA> getDanhSachPhuongXa() {
		return danhSachPhuongXa;
	}
	public void setDanhSachPhuongXa(ArrayList<PHUONGXA> danhSachPhuongXa) {
		this.danhSachPhuongXa = danhSachPhuongXa;
	}
	public String [] getDanhSachPhuongXaString() {
		String [] list = new String[danhSachPhuongXa.size()];
		for(int i=0;i<danhSachPhuongXa.size();i++) {
			list[i] = danhSachPhuongXa.get(i).getTenPhuongXa();
		}
		return list;
	}
}
