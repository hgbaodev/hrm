package DTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class UNGVIEN extends CONNGUOI {

    public String maTuyenDung;
    public String maUngVien;
    public double mucLuongDeal;
    public TRINHDO trinhDo;
    public String chucVu;
    private String trangThai;


    
    public UNGVIEN(CMND cmnd,String hoTen,String gioiTinh,LocalDate ngaySinh,DIACHI diaChi,String sdt,String danToc,String tonGiao,String honNhan,String email,String maTuyenDung, String maUngVien, double mucLuongDeal, TRINHDO trinhDo, String chucVu,
			String trangThai) {
		super(cmnd, hoTen, gioiTinh, ngaySinh, diaChi, sdt, danToc, honNhan, tonGiao, email);
		this.maTuyenDung = maTuyenDung;
		this.maUngVien = maUngVien;
		this.mucLuongDeal = mucLuongDeal;
		this.trinhDo = trinhDo;
		this.chucVu = chucVu;
		this.trangThai = trangThai;
	}
	public UNGVIEN() {
        super();
        this.maTuyenDung = null;
        this.maUngVien = null;
        this.mucLuongDeal = 0;
        this.trinhDo = new TRINHDO();
    }
	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public void setMaTuyenDung(String maTuyenDung) {
        this.maTuyenDung = maTuyenDung;
    }

    public void setMaUngVien(String maUngVien) {
        this.maUngVien = maUngVien;
    }

    public void setMucLuongDeal(double mucLuongDeal) {
        this.mucLuongDeal = mucLuongDeal;
    }

    public void setTrinhDo(TRINHDO trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getMaTuyenDung() {
        return maTuyenDung;
    }

    public String getMaUngVien() {
        return maUngVien;
    }

    public double getMucLuongDeal() {
        return mucLuongDeal;
    }

    public TRINHDO getTrinhDo() {
        return trinhDo;
    }
    public String[] getDataToTuyen() {
    	String data[] = {this.getHoTen(),this.getGioiTinh(),SUPPORT.LocalDateToString(this.getNgaySinh()),
    			this.getSdt(),this.getTrinhDo().getTrinhDoHocVan(),this.getTrinhDo().getTrinhDoChuyenMon(),this.getTrinhDo().getChuyenNganh(),
    			this.getDiaChi().getSoNha(),this.getDiaChi().getDuong(),this.getDiaChi().getPhuongXa(),this.getDiaChi().getQuanHuyen(),this.getDiaChi().getTinhThanhPho(),
    			this.getDanToc(),this.getTonGiao(),this.getCmnd().getSoCmnd(),SUPPORT.LocalDateToString(this.getCmnd().getNgayCap()),this.getCmnd().getNoiCap(),this.getTinhTrangHonNhan(),this.getChucVu(),SUPPORT.changeSalaryToFormatString(this.getMucLuongDeal())
    			,this.getEmail(),this.getMaUngVien()
    	};
    	return data;
    }
   
}
