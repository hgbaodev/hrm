package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;

import DAO.access_BANGDANHGIA;
import run.App;

public class showDanhGiaForm2 implements ActionListener{
	private App  app;
	public showDanhGiaForm2(App app) {
		this.app = app;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		app.getContent().getDanhGiaForm2().setData(access_BANGDANHGIA.getListNhanVien());
		app.getContent().showPage(9);
		System.out.println("thisssssss");
		// thiết lập đánh giá mặc định
		ArrayList<JRadioButton> list = app.getContent().getDanhGiaForm2().getRadioButtons();
		for(int i=0;i<list.size();i+=4) {
			int pos = i+3;
			list.get(pos).setSelected(true);
		}
		// tính điểm mặc định
		app.getContent().getDanhGiaForm2().getLbDiem().setText("120");
	}

}
