package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import run.App;

public class huyTuyenUngVien extends MouseAdapter{
	private App app;
	public huyTuyenUngVien(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		app.getContent().getRecruitmentForm().getUngVienView().getFormTuyenUngVien().setVisible(false);
	}
}
