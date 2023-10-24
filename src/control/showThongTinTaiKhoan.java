package control;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.NHOMQUYEN;
import GUI.AccountForm;
import run.App;

public class showThongTinTaiKhoan extends MouseAdapter{
	private App app;
	public showThongTinTaiKhoan(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		AccountForm temp = app.getContent().getAccountForm();
		int index = temp.getTableAccount().getSelectedRow();
		String thongtin = temp.getModelAccount().getValueAt(index, 1).toString();
		String quyenTaiKhoan;
		try {
			quyenTaiKhoan = temp.getModelAccount().getValueAt(index, 2).toString();
		} catch (Exception e1) {
			quyenTaiKhoan = "NULL";
		}
		temp.getLabelChiTietTaiKhoan().setText(thongtin);
		String [] modelCbbQuyen = temp.getModelCbbQuyen();
		for(int i=0;i<modelCbbQuyen.length;i++) {
			if(modelCbbQuyen[i].equals(quyenTaiKhoan)) {
				temp.getCbbQuyen().setSelectedIndex(i);
			}
		}
		System.out.println("Show thông tin tài khoản");
	}

}
