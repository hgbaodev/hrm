package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DAO.access_TAIKHOAN;
import GUI.AccountForm;
import run.App;

public class locTaiKhoan implements ActionListener{
	private App app;
	public locTaiKhoan(App app) {
		this.app = app;
	}
	public void actionPerformed(ActionEvent e) {
		AccountForm temp = app.getContent().getAccountForm();
		String filterPhongBan = temp.getCbbPhongBan().getSelectedItem().toString();
		Object[][] data = access_TAIKHOAN.getObjectToRender(filterPhongBan);
		temp.setAccountData(data);
		temp.getCbbPhongBan().setFocusable(false);
		temp.getScrollPane().getVerticalScrollBar().setValue(0);
	}

}
