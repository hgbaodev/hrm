package DTO;

public class QUYETDINHCHUCVU extends QUYETDINH {

    public String chucVuBanDau;
    public String chucVuSauQuyetDinh;
    public QUYETDINHCHUCVU() {
    	super();
    	this.chucVuBanDau = "";
    	this.chucVuSauQuyetDinh = "";
    }
    public QUYETDINHCHUCVU( String maQuyetDinh, String ngayQuyetDinh, String nguoiLapQuyetDinh, String lyDo,String chucVuBanDau, String chucVuSauQuyetDinh) {
        super(maQuyetDinh, ngayQuyetDinh, nguoiLapQuyetDinh, lyDo);
        this.chucVuBanDau = chucVuBanDau;
        this.chucVuSauQuyetDinh = chucVuSauQuyetDinh;
    }

    public void setChucVuBanDau(String chucVuBanDau) {
        this.chucVuBanDau = chucVuBanDau;
    }
    public void setChucVuSauQuyetDinh(String chucVuSauQuyetDinh) {
        this.chucVuSauQuyetDinh = chucVuSauQuyetDinh;
    }

    public String getChucVuBanDau() {
        return chucVuBanDau;
    }

    public String getChucVuSauQuyetDinh() {
        return chucVuSauQuyetDinh;
    }

}
