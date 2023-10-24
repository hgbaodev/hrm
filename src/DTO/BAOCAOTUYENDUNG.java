package DTO;

import java.time.LocalDate;


public class BAOCAOTUYENDUNG {
    
    private String maTuyenDung;
    private String chucVu;
    private String hocVan;
    private String gioiTinh;
    private String doTuoi;
    private int soLuongCanTuyen;
    private LocalDate hanNopHoSo;
    private double mucLuongToiThieu;
    private double mucLuongToiDa;
    private int soLuongNopHoSo;
    private int soLuongDaTuyen;
    
    public BAOCAOTUYENDUNG(){
    }
    public BAOCAOTUYENDUNG(String maTuyenDung, String chucVu, String hocVan, String gioiTinh, String doTuoi, int soLuongCanTuyen, LocalDate hanNopHoSo, double mucLuongToiThieu, double mucLuongToiDa,int soLuongNopHoSo,int soLuongDaTuyen){
        this.maTuyenDung = maTuyenDung;
        this.chucVu = chucVu;
        this.hocVan = hocVan;
        this.gioiTinh = gioiTinh;
        this.doTuoi = doTuoi;
        this.soLuongCanTuyen = soLuongCanTuyen;
        this.hanNopHoSo = hanNopHoSo;
        this.mucLuongToiThieu = mucLuongToiThieu;
        this.mucLuongToiDa = mucLuongToiDa;
        this.soLuongNopHoSo= soLuongNopHoSo;
        this.soLuongDaTuyen= soLuongDaTuyen;

    }

	public int getSoLuongNopHoSo() {
		return soLuongNopHoSo;
	}
	public void setSoLuongNopHoSo(int soLuongNopHoSo) {
		this.soLuongNopHoSo = soLuongNopHoSo;
	}
	public int getSoLuongDaTuyen() {
		return soLuongDaTuyen;
	}
	public void setSoLuongDaTuyen(int soLuongDaTuyen) {
		this.soLuongDaTuyen = soLuongDaTuyen;
	}
	public String getMaTuyenDung() {
        return maTuyenDung;
    }

    public void setMaTuyenDung(String maTuyenDung) {
        this.maTuyenDung = maTuyenDung;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getHocVan() {
        return hocVan;
    }

    public void setHocVan(String hocVan) {
        this.hocVan = hocVan;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDoTuoi() {
        return doTuoi;
    }

    public void setDoTuoi(String doTuoi) {
        this.doTuoi = doTuoi;
    }

    public int getSoLuongCanTuyen() {
        return soLuongCanTuyen;
    }

    public void setSoLuongCanTuyen(int soLuongCanTuyen) {
        this.soLuongCanTuyen = soLuongCanTuyen;
    }

    public LocalDate getHanNopHoSo() {
        return hanNopHoSo;
    }

    public void setHanNopHoSo(LocalDate localDate) {
        this.hanNopHoSo = localDate;
    }

    public double getMucLuongToiThieu() {
        return mucLuongToiThieu;
    }

    public void setMucLuongToiThieu(double mucLuongToiThieu) {
        this.mucLuongToiThieu = mucLuongToiThieu;
    }

    public double getMucLuongToiDa() {
        return mucLuongToiDa;
    }

    public void setMucLuongToiDa(double mucLuongToiDa) {
        this.mucLuongToiDa = mucLuongToiDa;
    }
    
    

    
}
