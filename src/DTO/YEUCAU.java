package DTO;

import java.time.LocalDate;


public class YEUCAU {
    
    private String maYeuCau;
    private String maNguoiGui;
    private String thongTinYeuCau;
    private String lyDo;
    private LocalDate ngayGui;
    private String nguoiXacNhan;
    private TRANGTHAI trangThai;
    public YEUCAU(){
        this.maYeuCau = "";
        this.maNguoiGui = "";
        this.thongTinYeuCau = "";
        this.lyDo = "";
        this.ngayGui = null;
        this.nguoiXacNhan = "";
        this.trangThai = TRANGTHAI.CHUAXACNHAN;		
    }
    
    public YEUCAU(String maYeuCau, String maNguoiGui, String thongTinYeuCau, String lyDo, LocalDate ngayGui, String nguoiXacNhan,TRANGTHAI trangThai){
        this.maYeuCau = maYeuCau;
        this.maNguoiGui =  maNguoiGui;
        this.thongTinYeuCau = thongTinYeuCau;
        this.lyDo = lyDo;
        this.ngayGui = ngayGui;
        this.nguoiXacNhan = nguoiXacNhan;
        this.trangThai = trangThai;
    }

    public String getMaYeuCau() {
        return maYeuCau;
    }

    public void setMaYeuCau(String maYeuCau) {
        this.maYeuCau = maYeuCau;
    }

    public String getMaNguoiGui() {
        return maNguoiGui;
    }

    public void setMaNguoiGui(String maNguoiGui) {
        this.maNguoiGui = maNguoiGui;
    }

    public String getThongTinYeuCau() {
        return thongTinYeuCau;
    }

    public void setThongTinYeuCau(String thongTinYeuCau) {
        this.thongTinYeuCau = thongTinYeuCau;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public LocalDate getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(LocalDate ngayGui) {
        this.ngayGui = ngayGui;
    }

    public String getNguoiXacNhan() {
        return nguoiXacNhan;
    }

    public void setNguoiXacNhan(String nguoiXacNhan) {
        this.nguoiXacNhan = nguoiXacNhan;
    }

    public TRANGTHAI getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TRANGTHAI trangThai) {
        this.trangThai = trangThai;
    }
    public enum TRANGTHAI{
    	DANHXACNHAN,CHUAXACNHAN
    }
    
}

