package DTO;


import java.util.ArrayList;

public class TINHTHANHPHO {
	private String tenTinhThanhPho;
	private ArrayList<QUANHUYEN> danhSachQuanHuyen;
	public TINHTHANHPHO() {
		tenTinhThanhPho = "";
		danhSachQuanHuyen = new ArrayList<>();
	}
	public String getTenTinhThanhPho() {
		return tenTinhThanhPho;
	}
	public void setTenTinhThanhPho(String tenTinhThanhPho) {
		this.tenTinhThanhPho = tenTinhThanhPho;
	}
	public ArrayList<QUANHUYEN> getDanhSachQuanHuyen() {
		return danhSachQuanHuyen;
	}
	public void setDanhSachQuanHuyen(ArrayList<QUANHUYEN> danhSachQuanHuyen) {
		this.danhSachQuanHuyen = danhSachQuanHuyen;
	}
	public String[] getDanhSachQuanHuyenString() {
		String[] list = new String[danhSachQuanHuyen.size()];
		for(int i=0;i<danhSachQuanHuyen.size();i++) {
			list[i] = danhSachQuanHuyen.get(i).getTenQuanHuyen();
		}
		return list;
	}
}
