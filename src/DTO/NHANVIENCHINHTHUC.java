package DTO;

import java.time.LocalDate;

public class NHANVIENCHINHTHUC extends NHANVIEN {

    public HOPDONGLAODONG hopDong;

    public NHANVIENCHINHTHUC() {
        super();
        this.hopDong = null;
    }

    public NHANVIENCHINHTHUC(HOPDONGLAODONG maHD, String maNhanVien, TAIKHOAN taiKhoan, String hoTen, String gioiTinh, LocalDate ngaySinh, DIACHI diaChi, String sdt,CMND cmnd,String danToc, String tinhTrangHonNhan, String tonGiao, String email,String maPhong, TRINHDO trinhDo, CHUCVU chucVu ) {
        super(maNhanVien, hoTen, gioiTinh, ngaySinh, diaChi, sdt, cmnd,danToc, tinhTrangHonNhan, tonGiao, email, maPhong, trinhDo, chucVu, taiKhoan);
        this.hopDong = maHD;
    }

    public void setHOPDONG(HOPDONGLAODONG maHD) {
        this.hopDong = maHD;
    }

    public HOPDONGLAODONG getHopDong() {
        return hopDong;
    }

}
