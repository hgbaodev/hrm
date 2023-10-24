package DTO;
public class QUYETDINHLUONG extends QUYETDINH{
	private double mucLuongBanDau;
	private double mucLuongSauQuyetDinh;
	public QUYETDINHLUONG() {
		super();
		this.mucLuongBanDau = 0;
		this.mucLuongSauQuyetDinh = 0;
	}
	public QUYETDINHLUONG(double mucLuongBanDau, double mucLuongSauQuyetDinh) {
		super();
		this.mucLuongBanDau = mucLuongBanDau;
		this.mucLuongSauQuyetDinh = mucLuongSauQuyetDinh;
	}
	public double getMucLuongBanDau() {
		return mucLuongBanDau;
	}
	public void setMucLuongBanDau(double mucLuongBanDau) {
		this.mucLuongBanDau = mucLuongBanDau;
	}
	public double getMucLuongSauQuyetDinh() {
		return mucLuongSauQuyetDinh;
	}
	public void setMucLuongSauQuyetDinh(double mucLuongSauQuyetDinh) {
		this.mucLuongSauQuyetDinh = mucLuongSauQuyetDinh;
	}
}
