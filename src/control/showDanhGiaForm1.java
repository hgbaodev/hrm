package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import run.App;

public class showDanhGiaForm1 implements ActionListener{
	private App  app;
	public showDanhGiaForm1(App app) {
		this.app = app;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		app.getContent().showPage(7);
	}

}
