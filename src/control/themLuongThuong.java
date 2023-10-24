package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.access_LUONG;
import DAO.access_PHONGBAN;
import DTO.CHECK;
import GUI.SalaryForm2;
import run.App;

public class themLuongThuong extends MouseAdapter{
	private App app;
	public themLuongThuong(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("thưởng");
		SalaryForm2 temp = app.getContent().getSalaryForm().getSalaryForm2();
		String data[] = temp.getDataThemLuongThuong();
		// kiểm tra dữ liệu
		int nam;
		try {
			nam = Integer.valueOf(data[0].split(" ")[1]);
		} catch (Exception e2) {
			app.showMessage("Vui lòng chọn năm!");
			return;
		}
		int thang;
		try {
			thang = Integer.valueOf(data[1].split(" ")[1]);
		} catch (Exception e2) {
			app.showMessage("Vui lòng chọn tháng!");
			return;
		}
		int loaiThuong =Integer.valueOf(data[2]); 
		if(loaiThuong==2) {
			if(data[4].equals("")) {
				app.showMessage("Vui lòng nhập mã nhân viên");
				return;
			}
			if(!CHECK.checkMaNhanVienTonTai(data[4])) {
				app.showMessage("Mã nhân viên không tồn tại!");
				return;
			}
		}
		int mucThuong;
		if(data[5].equals("")) {
			app.showMessage("Vui lòng nhập mức thưởng!");
			return;
		}
		try {
			mucThuong = Integer.valueOf(data[5]);
			if(mucThuong<0) {
				app.showMessage("Vui lòng kiểm tra lại mức thưởng!");
				return;
			}
		} catch (Exception e2) {
			app.showMessage("Vui lòng kiểm tra lại mức thưởng!");
			return;
		}
		// xử lý thưởng
		if(loaiThuong==0) {
			// thưởng tất cả nhân viên
			access_LUONG.thuongTatCaNhanVien(nam, thang, mucThuong);
		}else if(loaiThuong==1) {
			// thưởng theo phòng ban
			access_LUONG.thuongNhanVienTheoPhongBan(nam, thang, mucThuong, access_PHONGBAN.getMaSoTuTen(data[3]));
		}else {
			access_LUONG.thuongNhanVien(nam, thang, mucThuong, data[4]);
		}
		temp.setSalaryData(locLuongThuong.filter(app));
	}
}
