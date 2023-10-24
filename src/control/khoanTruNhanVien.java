package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.access_LUONG;
import DTO.CHECK;
import GUI.SalaryForm3;
import run.App;

public class khoanTruNhanVien extends MouseAdapter{
	private App app;
	public khoanTruNhanVien(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		SalaryForm3 temp = app.getContent().getSalaryForm().getSalaryForm3();
		String data[] = temp.getDataKhoanTru();
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
			app.showMessage("Vui lòng nhập mức trừ!");
			return;
		}
		double mucTru = 0;
		try {
			mucTru = Double.valueOf(data[3]);
			if(mucTru<0) {
				app.showMessage("Vui lòng kiểm tra lại khoản trừ!");
				return;
			}
		} catch (Exception e2) {
			app.showMessage("Vui lòng kiểm tra lại khoản trừ!");
			return;
		}
		access_LUONG.khoanTruNhanVien(nam, thang, data[2], mucTru);
		temp.setData(locPhuCapKhoanTru.filter(app));
		
	}
	
}
