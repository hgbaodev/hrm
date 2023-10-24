package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.access_BANGDANHGIA;
import DAO.access_NHANVIEN;
import DTO.CHECK;
import GUI.SalaryForm4;
import run.App;

public class dieuChinhMucLuong extends MouseAdapter{
	private App app;
	public dieuChinhMucLuong(App app) {
		this.app =app;
	}
	public void mouseClicked(MouseEvent e) {
		SalaryForm4 temp = app.getContent().getSalaryForm().getSalaryForm4();
		String maNhanVien = temp.getTfMaNhanVien().getText().trim();
		String mucLuongDC = temp.getTfMucTang().getText().trim();
		if(maNhanVien.equals("")) {
			app.showMessage("Vui lòng nhập mã nhân viên!");
			return;
		}
		if(mucLuongDC.equals("")) {
			app.showMessage("Vui lòng nhập mức lương!");
			return;
		}
		if(!CHECK.checkMaNhanVienTonTai(maNhanVien)) {
			app.showMessage("Mã nhân viên này không tồn tại!");
			return;
		}
		double mucLuongDieuChinh = 0;
		try {
			mucLuongDieuChinh = Double.valueOf(mucLuongDC);
			if(mucLuongDieuChinh<0) {
				app.showMessage("Vui lòng kiểm tra lại mức lương điều chỉnh!");
				return;
			}
		} catch (Exception e2) {
			app.showMessage("Vui lòng kiểm tra lại mức lương điều chỉnh!");
			return;
		}
		access_NHANVIEN.dieuChinhLuong(maNhanVien, mucLuongDieuChinh);
		temp.setDanhGiaData(access_BANGDANHGIA.getDanhSachDanhGiaTangLuong());
		app.showMessage("Điều chỉnh lương thành công!");
	}
}
