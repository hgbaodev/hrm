package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.access_LUONG;
import DTO.CHECK;
import GUI.SalaryForm3;
import run.App;

public class phuCapNhanVien extends MouseAdapter{
	private App app;
	public phuCapNhanVien(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		SalaryForm3 temp = app.getContent().getSalaryForm().getSalaryForm3();
		String data[] = temp.getDataPhuCap();
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
		if(data[2].equals("")) {
			app.showMessage("Vui lòng nhập mã nhân viên!");
			return;
		}
		if(!CHECK.checkMaNhanVienTonTai(data[2])) {
			app.showMessage("Mã nhân viên này không tồn tại trong danh sách nhân viên!");
			return;
		}
		if(data[3].equals("")) {
			app.showMessage("Vui lòng nhập mức phụ cấp!");
			return;
		}
		double mucPhuCap = 0;
		try {
			mucPhuCap = Double.valueOf(data[3]);
			if(mucPhuCap<0) {
				app.showMessage("Vui lòng kiểm tra lại mức phụ cấp!");
				return;
			}
		} catch (Exception e2) {
			app.showMessage("Vui lòng kiểm tra lại mức phụ cấp!");
			return;
		}
		access_LUONG.phuCapNhanVien(nam, thang, data[2], mucPhuCap);
		temp.setData(locPhuCapKhoanTru.filter(app));
		
	}
	
}
