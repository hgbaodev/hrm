package DTO;

import java.time.LocalDate;

public class DANHGIA {
    
    private String maDanhGia;
    private String maNhanVien;
    private String tenNhanVien;
    private String maNguoiDanhGia;
    private String tenNguoiDanhGia;
    private LocalDate ngayDanhGia;
    private int diemDanhGia;
    private String xepLoai;
    private String chiTietDanhGia;
    private String ghiChu;
    private String loaiDanhGia;
    
	public DANHGIA() {
    	this.maDanhGia="";
    	this.maNhanVien="";
    	this.tenNhanVien = "";
    	this.ngayDanhGia=null;
    	this.maNguoiDanhGia="";
    	this.tenNguoiDanhGia="";
    	this.diemDanhGia=0;
    	this.xepLoai="";
    	this.chiTietDanhGia="";
    	this.loaiDanhGia = "";
    	this.ghiChu="";
    }
	
	public DANHGIA(String maDanhGia, String maNhanVien, String tenNhanVien, String maNguoiDanhGia,
			String tenNguoiDanhGia, LocalDate ngayDanhGia, int diemDanhGia, String xepLoai, String chiTietDanhGia,
			String ghiChu, String loaiDanhGia) {
		super();
		this.maDanhGia = maDanhGia;
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.maNguoiDanhGia = maNguoiDanhGia;
		this.tenNguoiDanhGia = tenNguoiDanhGia;
		this.ngayDanhGia = ngayDanhGia;
		this.diemDanhGia = diemDanhGia;
		this.xepLoai = xepLoai;
		this.chiTietDanhGia = chiTietDanhGia;
		this.ghiChu = ghiChu;
		this.loaiDanhGia = loaiDanhGia;
	}

	public String getLoaiDanhGia() {
		return loaiDanhGia;
	}

	public void setLoaiDanhGia(String loaiDanhGia) {
		this.loaiDanhGia = loaiDanhGia;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getMaNguoiDanhGia() {
		return maNguoiDanhGia;
	}
	public void setMaNguoiDanhGia(String maNguoiDanhGia) {
		this.maNguoiDanhGia = maNguoiDanhGia;
	}
	public String getTenNguoiDanhGia() {
		return tenNguoiDanhGia;
	}
	public void setTenNguoiDanhGia(String tenNguoiDanhGia) {
		this.tenNguoiDanhGia = tenNguoiDanhGia;
	}
	public String getLyDo() {
		return ghiChu;
	}
	public void setLyDo(String lyDo) {
		this.ghiChu = lyDo;
	}
	public String getMaDanhGia() {
		return maDanhGia;
	}
	public void setMaDanhGia(String maDanhGia) {
		this.maDanhGia = maDanhGia;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public LocalDate getNgayDanhGia() {
		return ngayDanhGia;
	}
	public void setNgayDanhGia(LocalDate ngayDanhGia) {
		this.ngayDanhGia = ngayDanhGia;
	}
	public int getDiemDanhGia() {
		return diemDanhGia;
	}
	public void setDiemDanhGia(int diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}
	public String getXepLoai() {
		return xepLoai;
	}
	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}
	public String getChiTietDanhGia() {
		return chiTietDanhGia;
	}
	public void setChiTietDanhGia(String chiTietDanhGia) {
		this.chiTietDanhGia = chiTietDanhGia;
	}
    






}