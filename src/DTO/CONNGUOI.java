package DTO;

import java.time.LocalDate;

public class CONNGUOI {
	private CMND cmnd;
    private String hoTen;
    private String gioiTinh;
    private LocalDate ngaySinh;
    private DIACHI diaChi;
    private String sdt;
    private String tinhTrangHonNhan;
    private String danToc;
    

	private String tonGiao;
    private String email;

    public CONNGUOI() {
        this.hoTen = null;
        this.gioiTinh = null;
        this.ngaySinh = LocalDate.now();
        this.diaChi = new DIACHI();
        this.cmnd = new CMND();
        this.sdt = null;
        this.tinhTrangHonNhan = null;
        this.tonGiao = null;
        this.email = null;
    }

    public CONNGUOI(CMND cmnd,String hoTen, String gioiTinh, LocalDate ngaySinh, DIACHI diaChi, String sdt,String danToc, String tinhTrangHonNhan, String tonGiao, String email) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.tinhTrangHonNhan = tinhTrangHonNhan;
        this.tonGiao = tonGiao;
        this.danToc =danToc;
        this.email = email;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setDiaChi(DIACHI diaChi) {
        this.diaChi = diaChi;
    }

    public void setCmnd(CMND cmnd) {
        this.cmnd = cmnd;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setTinhTrangHonNhan(String tinhTrangHonNhan) {
        this.tinhTrangHonNhan = tinhTrangHonNhan;
    }

    public void setTonGiao(String tonGiao) {
        this.tonGiao = tonGiao;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public DIACHI getDiaChi() {
        return diaChi;
    }

    public CMND getCmnd() {
        return cmnd;
    }

    public String getSdt() {
        return sdt;
    }
    public String getDanToc() {
		return danToc;
	}

	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}
    public String getTinhTrangHonNhan() {
        return tinhTrangHonNhan;
    }

    public String getTonGiao() {
        return tonGiao;
    }

    public String getEmail() {
        return email;
    }
    public int getTuoi() {
    	LocalDate hienTai = LocalDate.now();
    	if(hienTai.getMonthValue()>ngaySinh.getMonthValue()) {
    		return hienTai.getYear() - ngaySinh.getYear();
    	}else if(hienTai.getMonthValue()==ngaySinh.getMonthValue()) {
    		if(hienTai.getDayOfMonth()>ngaySinh.getDayOfMonth()) {
    			return hienTai.getYear() - ngaySinh.getYear();
    		}else {
    			return hienTai.getYear() - ngaySinh.getYear() -1;
    		}
    	}else {
    		return hienTai.getYear() - ngaySinh.getYear() - 1;
    	}
    }
    
}


