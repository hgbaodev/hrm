package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.access_NHANVIEN;
import GUI.ContractForm4;
import run.App;


public class sapXepNhanVienKiHopDong implements ActionListener{
	private App app;
	public sapXepNhanVienKiHopDong(App app) {
		this.app = app;
	}
	public void actionPerformed(ActionEvent e) {
		ContractForm4 temp = app.getContent().getContractForm().getConTractForm4();
		String tenPhong = temp.getCbbPhong().getSelectedItem().toString();
		int sort_by = temp.getCbbSort().getSelectedIndex();
		int sort_mode = temp.getCbbSort2().getSelectedIndex();
		temp.setSalaryData(access_NHANVIEN.getDanhSachNhanVienThuViecToRender(tenPhong, sort_by, sort_mode));
	}

}
