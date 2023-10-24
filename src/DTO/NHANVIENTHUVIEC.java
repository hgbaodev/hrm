package DTO;

import java.time.LocalDate;

public class NHANVIENTHUVIEC extends NHANVIEN {

    public LocalDate ngayBatDauThuViec;
    public LocalDate ngayKetThucThuViec;
    public double luongThuViec;

    public NHANVIENTHUVIEC() {
        super();
        this.ngayBatDauThuViec = null;
        this.ngayKetThucThuViec = null;
        this.luongThuViec = 0;
    }

    public NHANVIENTHUVIEC( String maNhanVien,String hoTen,    String gioiTinh, LocalDate ngaySinh, DIACHI diaChi,  String sdt,CMND cmnd,String danToc, String tinhTrangHonNhan, String tonGiao, String email,String maPhong,TRINHDO trinhDo, CHUCVU chucVu, TAIKHOAN taiKhoan,LocalDate ngayBatDauThuViec, LocalDate ngayKetThucThuViec, double luongThuViec) {
        super(maNhanVien, hoTen, gioiTinh, ngaySinh, diaChi, sdt, cmnd,danToc, tinhTrangHonNhan, tonGiao, email, maPhong, trinhDo, chucVu, taiKhoan);
        this.ngayBatDauThuViec = ngayBatDauThuViec;
        this.ngayKetThucThuViec = ngayKetThucThuViec;
        this.luongThuViec = luongThuViec;
    }

	public LocalDate getNgayBatDauThuViec() {
		return ngayBatDauThuViec;
	}

	public void setNgayBatDauThuViec(LocalDate ngayBatDauThuViec) {
		this.ngayBatDauThuViec = ngayBatDauThuViec;
	}

	public LocalDate getNgayKetThucThuViec() {
		return ngayKetThucThuViec;
	}

	public void setNgayKetThucThuViec(LocalDate ngayKetThucThuViec) {
		this.ngayKetThucThuViec = ngayKetThucThuViec;
	}

	public double getLuongThuViec() {
		return this.luongThuViec;
	}

	public void setLuongThuViec(double luongThuViec) {
		this.luongThuViec = luongThuViec;
	}

}
