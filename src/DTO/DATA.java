package DTO;

import BUS.DANHSACHBANGCHAMCONG;
import BUS.DANHSACHBANGDANHGIA;
import BUS.DANHSACHBAOCAOTUYENDUNG;
import BUS.DANHSACHDIACHI;
import BUS.DANHSACHHOPDONG;
import BUS.DANHSACHLUONG;
import BUS.DANHSACHNHANVIEN;
import BUS.DANHSACHNHOMQUYEN;
import BUS.DANHSACHPHONGBAN;
import BUS.DANHSACHUNGVIEN;

public class DATA {
	private DANHSACHNHANVIEN danhSachNhanVien;
	private DANHSACHPHONGBAN danhSachPhongBan;
	private DANHSACHDIACHI danhSachDiaChi;
	private DANHSACHLUONG danhSachLuong;
	private DANHSACHBAOCAOTUYENDUNG danhsachbaocaotuyendung;
	private DANHSACHUNGVIEN danhsachungvien;
	private  DANHSACHBANGDANHGIA danhSachBanDanhGia;
	private DANHSACHHOPDONG danhSachHopDong;
	private DANHSACHBANGCHAMCONG danhSachBangChamCong;
	private DANHSACHNHOMQUYEN danhSachNhomQuyen;
	public DATA() {
		danhSachNhanVien = new DANHSACHNHANVIEN();
		danhSachPhongBan = new DANHSACHPHONGBAN();
		danhSachHopDong = new DANHSACHHOPDONG();
		danhSachBangChamCong = new DANHSACHBANGCHAMCONG();
		danhSachDiaChi = new DANHSACHDIACHI();
		danhSachLuong = new DANHSACHLUONG();
		danhSachBanDanhGia = new DANHSACHBANGDANHGIA();
		danhsachbaocaotuyendung= new DANHSACHBAOCAOTUYENDUNG();
		danhsachungvien= new DANHSACHUNGVIEN();
		
		danhSachNhomQuyen = new DANHSACHNHOMQUYEN();
	}
	public DANHSACHHOPDONG getDanhSachHopDong() {
		return this.danhSachHopDong;
	}
	public DANHSACHNHANVIEN getDanhSachNhanVien() {
		return this.danhSachNhanVien;
	}
	public DANHSACHPHONGBAN getDanhSachPhongBan() {
		return this.danhSachPhongBan; 
	}
	public DANHSACHDIACHI getDanhSachDiaChi() {
		return this.danhSachDiaChi;
	}
	public DANHSACHUNGVIEN getDanhsachungvien() {
		return danhsachungvien;
	}
	public DANHSACHBANGCHAMCONG getDanhSachBangChamCong() {
		return danhSachBangChamCong;
	}
	public void setDanhsachungvien(DANHSACHUNGVIEN danhsachungvien) {
		this.danhsachungvien = danhsachungvien;
	}
	public DANHSACHBAOCAOTUYENDUNG getDanhsachbaocaotuyendung() {
		return danhsachbaocaotuyendung;
	}
	public DANHSACHLUONG getDanhSachLuong() {
		return this.danhSachLuong;
	}

	public void setDanhsachbaocaotuyendung(DANHSACHBAOCAOTUYENDUNG danhsachbaocaotuyendung) {
		this.danhsachbaocaotuyendung = danhsachbaocaotuyendung;
	}
	public DANHSACHBANGDANHGIA getDanhSachBangDanhGia() {
		return this.danhSachBanDanhGia;
	}
	public DANHSACHNHOMQUYEN getDanhSachNhomQuyen() {
		return this.danhSachNhomQuyen;
	}
}
