package DTO;

public class GIAHANHOPDONG extends QUYETDINH {

    public double thoiGianGiaHan;

    public GIAHANHOPDONG() {
        super();
        this.thoiGianGiaHan = 0;
    }

    public GIAHANHOPDONG(double thoiGianGiaHan, String maQuyetDinh, String ngayQuyetDinh, String nguoiLapQuyetDinh, String lyDo) {
        super(maQuyetDinh, ngayQuyetDinh, nguoiLapQuyetDinh, lyDo);
        this.thoiGianGiaHan = thoiGianGiaHan;
    }

    public void setThoiGianGiaHan(double thoiGianGiaHan) {
        this.thoiGianGiaHan = thoiGianGiaHan;
    }

    public double getThoiGianGiaHan() {
        return thoiGianGiaHan;
    }

}
