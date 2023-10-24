package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import run.App;

public class troVeTrangHopDong implements ActionListener{
	private App app;
	public troVeTrangHopDong(App app) {
		this.app = app;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		app.getContent().getContractForm().showFrame(0);
		app.getContent().getContractForm().getConTractForm1().getOptionPanel().setVisible(false);
		app.repaint();
	}

}
