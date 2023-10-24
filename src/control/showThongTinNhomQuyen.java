package control;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.NHOMQUYEN;
import GUI.AccountForm;
import run.App;

public class showThongTinNhomQuyen extends MouseAdapter{
	private App app;
	public showThongTinNhomQuyen(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		AccountForm temp = app.getContent().getAccountForm();
		int index = temp.getTableNhomQuyen().getSelectedRow();
		NHOMQUYEN x = app.getData().getDanhSachNhomQuyen().getList().get(index);
		temp.showThongTinNhomQuyen(x.getMangChucNang());
		temp.getTitleNhomQuyen().setText(x.getMaNhomQuyen()+" - "+x.getTenNhomQuyen());
	}

}
