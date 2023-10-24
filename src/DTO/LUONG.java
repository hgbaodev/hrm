package DTO;

public class LUONG {

    public String maLuong;
    public String maBangChamCong;
    public double luongThuong;
    public double luongThucTe;
    public double phuCapChucVu;
    public double phuCapKhac;
    public double khoanTruBaoHiem;
    public double khoanTruKhac;
    public double thue;
    public double thucLanh;

    public LUONG() {
        this.maLuong = "";
        this.maBangChamCong=  "";
        this.luongThuong = 0;
        this.luongThucTe = 0;
        this.phuCapChucVu = 0;
        this.phuCapKhac = 0;
        this.khoanTruBaoHiem = 0;
        this.khoanTruKhac = 0;
        this.thue = 0;
        this.thucLanh = 0;
    }
    
    public LUONG(String maLuong, String maBangChamCong, double luongThucTe, double luongThuong, double phuCapChucVu,double phuCapKhac,double khoanTruBaoHiem,double khoanTruKhac, double thue, double thucLanh) {
        this.maLuong = maLuong;
        this.luongThucTe = luongThucTe;
        this.maBangChamCong = maBangChamCong;
        this.luongThuong = luongThuong;
       this.phuCapChucVu = phuCapChucVu;
       this.phuCapKhac = phuCapKhac;
       this.khoanTruBaoHiem = khoanTruBaoHiem;
       this.khoanTruKhac = khoanTruKhac;
        this.thue = thue;
        this.thucLanh = thucLanh;
    }

    public void setMaLuong(String maLuong) {
        this.maLuong = maLuong;
    }
    public double getLuongThucTe() {
    	return this.luongThucTe;
    }
    public void setMaBangChamCong(String maBangChamCong) {
        this.maBangChamCong = maBangChamCong;
    }

    public void setLuongThuong(double luongThuong) {
        this.luongThuong = luongThuong;
    }

    public void setPhuCapChucVu(double phuCap) {
        this.phuCapChucVu = phuCap;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    public void setThucLanh(double thucLanh) {
        this.thucLanh = thucLanh;
    }

    public String getMaLuong() {
        return maLuong;
    }

    public String getMaBangChamCong() {
        return maBangChamCong;
    }

    public double getLuongThuong() {
        return luongThuong;
    }

    public double getPhuCapChucVu() {
        return phuCapChucVu;
    }

    public double getThue() {
        return thue;
    }

    public double getThucLanh() {
        return thucLanh;
    }
    public void setKhoanTruBaoHiem(double khoanTru) {
    	this.khoanTruBaoHiem = khoanTru;
    }
    public double getKhoanTruBaoHiem() {
    	return this.khoanTruBaoHiem;
    }

	public double getPhuCapKhac() {
		return phuCapKhac;
	}

	public void setPhuCapKhac(double phuCapKhac) {
		this.phuCapKhac = phuCapKhac;
	}

	public double getKhoanTruKhac() {
		return khoanTruKhac;
	}

	public void setKhoanTruKhac(double khoanTruKhac) {
		this.khoanTruKhac = khoanTruKhac;
	}
	public void setLuongThucTe(double luongThucTe) {
		this.luongThucTe = luongThucTe;
	}
    
}
