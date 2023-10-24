package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.UngVienView_Them;
import GUI.employeeForm3_Cart1;
import run.App;

public class cbbPhuongXaUngVien implements ActionListener{
	private App app;
	public cbbPhuongXaUngVien(App app) {
		this.app = app;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UngVienView_Them temp = app.getContent().getRecruitmentForm().getUngVienView().getUvv_t();
		int index_tp = temp.getCbbTinhThanhPho().getSelectedIndex();
		int index_qh = temp.getCbbQuanHuyen().getSelectedIndex();
		int index_px = temp.getCbbPhuongXa().getSelectedIndex();
		temp.setDataCbbDuong(app.getData().getDanhSachDiaChi().getList().get(index_tp).getDanhSachQuanHuyen().get(index_qh).getDanhSachPhuongXa().get(index_px).getDanhSachDuongString());
		
	}

}
