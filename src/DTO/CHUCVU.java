package DTO;

import java.time.LocalDate;

public class CHUCVU {
	private String maChucVu;
	private String tenChucVu;
	private double phuCapChucVu;
	private LocalDate ngayNhanChuc;
	public CHUCVU() {
		this.maChucVu = "";
		this.tenChucVu = "";
		this.phuCapChucVu = 0;
		this.ngayNhanChuc = null;
	}
	public CHUCVU(String maChucVu, String tenChucVu, double phuCapChucVu, LocalDate ngayNhanChuc) {
		super();
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
		this.phuCapChucVu = phuCapChucVu;
		this.ngayNhanChuc = ngayNhanChuc;
	}
	public String getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	public double getPhuCapChucVu() {
		return phuCapChucVu;
	}
	public void setPhuCapChucVu(double phuCapChucVu) {
		this.phuCapChucVu = phuCapChucVu;
	}
	public LocalDate getNgayNhanChuc() {
		return ngayNhanChuc;
	}
	public void setNgayNhanChuc(LocalDate ngayNhanChuc) {
		this.ngayNhanChuc = ngayNhanChuc;
	}
	
}
