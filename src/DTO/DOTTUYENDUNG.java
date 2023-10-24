package DTO;

import java.time.LocalDate;


public class DOTTUYENDUNG {
    
    private String maTuyenDung;
    private String maNhanVien;
    private LocalDate ngayTuyenDung;
    
    public DOTTUYENDUNG(){
        this.maTuyenDung = "";
        this.maNhanVien = "";
        this.ngayTuyenDung = null;
    }
    
    public DOTTUYENDUNG(String maTuyenDung, String maNhanVien, LocalDate ngayTuyenDung){
        this.maTuyenDung = maTuyenDung;
        this.maNhanVien = maNhanVien;
        this.ngayTuyenDung = ngayTuyenDung;
    }

    public String getMaTuyenDung() {
        return maTuyenDung;
    }

    public void setMaTuyenDung(String maTuyenDung) {
        this.maTuyenDung = maTuyenDung;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public LocalDate getNgayTuyenDung() {
        return ngayTuyenDung;
    }

    public void setNgayTuyenDung(LocalDate ngayTuyenDung) {
        this.ngayTuyenDung = ngayTuyenDung;
    }
    
    
}
