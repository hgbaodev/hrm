package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import run.App;

public class cbbTinhThanhPhoUngVien implements ActionListener{
	private App app;
	public cbbTinhThanhPhoUngVien(App app) {
		this.app = app;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int index = app.getContent().getRecruitmentForm().getUngVienView().getUvv_t().getCbbTinhThanhPho().getSelectedIndex();
		app.getContent().getRecruitmentForm().getUngVienView().getUvv_t().setDataCbbQuanHuyen(app.getData().getDanhSachDiaChi().getList().get(index).getDanhSachQuanHuyenString());
		app.getContent().getRecruitmentForm().getUngVienView().getUvv_t().setDataCbbPhuongXa(app.getData().getDanhSachDiaChi().getList().get(index).getDanhSachQuanHuyen().get(0).getDanhSachPhuongXaString());
		app.getContent().getRecruitmentForm().getUngVienView().getUvv_t().setDataCbbDuong(app.getData().getDanhSachDiaChi().getList().get(index).getDanhSachQuanHuyen().get(0).getDanhSachPhuongXa().get(0).getDanhSachDuongString());
		app.repaint();
		
	}

}
