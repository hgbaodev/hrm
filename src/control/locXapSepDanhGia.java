package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import BUS.DANHSACHBANGDANHGIA;
import DTO.SUPPORT;
import GUI.BangDanhGiaForm1;
import run.App;

public class locXapSepDanhGia implements ActionListener{
	private App app;
	public locXapSepDanhGia(App app) {
		this.app = app;
	}
	public static DANHSACHBANGDANHGIA loc(App app) {
		System.out.println("lọc");
		BangDanhGiaForm1 temp1 = app.getContent().getDanhGiaForm();
		String loaiDanhGia = temp1.getCbbLoaiDanhGia().getSelectedItem().toString();
		LocalDate ngayBatDau = SUPPORT.toLocalDate(temp1.getTfBatDau().getText());
		LocalDate ngayKetThuc = SUPPORT.toLocalDate(temp1.getTfKetThuc().getText());
		DANHSACHBANGDANHGIA ds = app.getData().getDanhSachBangDanhGia();
		if(!app.getMangChucNang()[35]) {
			ds = app.getData().getDanhSachBangDanhGia().getDANHSACHDANHGIATheoMaNhanVien(app.getTaiKhoanDangNhap().getUsername());
		}
		if(!loaiDanhGia.equalsIgnoreCase("Loại đánh giá")) {
			ds = ds.getDANHSACHBANGDANHGIA(loaiDanhGia,ngayBatDau,ngayKetThuc);
		}else {
			ds = ds.getDANHSACHBANGDANHGIA(ngayBatDau,ngayKetThuc);
		}
		int sort = temp1.getCbbSort().getSelectedIndex();
		int sort_mode = temp1.getCbbSort_Asc_Desc().getSelectedIndex();
		if(sort==0) {
			ds.sortByDay(sort_mode);
		}else {
			ds.sortByPoint(sort_mode);
		}
		return ds;
	}
	public void actionPerformed(ActionEvent e) {
		BangDanhGiaForm1 temp1 = app.getContent().getDanhGiaForm();
		DANHSACHBANGDANHGIA ds = loc(app);
		temp1.setData(ds.getObjectToRender());
	}
}
