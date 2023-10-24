package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.UngVienView;
import GUI.UngVienView_Them;
import GUI.employeeForm3_Cart1;
import run.App;

public class cbbQuanHuyenUngVien implements ActionListener{
	private App app;
	public cbbQuanHuyenUngVien(App app) {
		this.app = app;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UngVienView_Them temp = app.getContent().getRecruitmentForm().getUngVienView().getUvv_t();
		int index_tp = temp.getCbbTinhThanhPho().getSelectedIndex();
		int index_qh = temp.getCbbQuanHuyen().getSelectedIndex();
		temp.setDataCbbPhuongXa(app.getData().getDanhSachDiaChi().getList().get(index_tp).getDanhSachQuanHuyen().get(index_qh).getDanhSachPhuongXaString());
		temp.setDataCbbDuong(app.getData().getDanhSachDiaChi().getList().get(index_tp).getDanhSachQuanHuyen().get(index_qh).getDanhSachPhuongXa().get(0).getDanhSachDuongString());
		
	}

}
