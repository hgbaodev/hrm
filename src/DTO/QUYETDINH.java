package DTO;

public class QUYETDINH {

    private String maQuyetDinh;
    private String maNhanVien;
    private String ngayQuyetDinh;
    private String nguoiLapQuyetDinh;
    private String lyDo;
    public QUYETDINH() {
        this.maQuyetDinh = null;
        this.ngayQuyetDinh = null;
        this.nguoiLapQuyetDinh = null;
        this.lyDo = null;
    }

    public QUYETDINH(String maQuyetDinh, String ngayQuyetDinh, String nguoiLapQuyetDinh, String lyDo) {
        this.maQuyetDinh = maQuyetDinh;
        this.ngayQuyetDinh = ngayQuyetDinh;
        this.nguoiLapQuyetDinh = nguoiLapQuyetDinh;
        this.lyDo = lyDo;
    }

    public void setMaQuyetDinh(String maQuyetDinh) {
        this.maQuyetDinh = maQuyetDinh;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setNgayQuyetDinh(String ngayQuyetDinh) {
        this.ngayQuyetDinh = ngayQuyetDinh;
    }

    public void setNguoiLapQuyetDinh(String nguoiLapQuyetDinh) {
        this.nguoiLapQuyetDinh = nguoiLapQuyetDinh;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getMaQuyetDinh() {
        return maQuyetDinh;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getNgayQuyetDinh() {
        return ngayQuyetDinh;
    }

    public String getNguoiLapQuyetDinh() {
        return nguoiLapQuyetDinh;
    }

    public String getLyDo() {
        return lyDo;
    }

}
