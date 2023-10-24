package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import run.App;

public class troVeTrangNhanVien1 implements ActionListener{
	private App app;
	public troVeTrangNhanVien1(App app) {
		this.app = app;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(app.getContent().getEmployeeForm().getEmployeeForm3().getCart2().getFlag()) { // kiểm tra đang show nhân viên chính hay show nhân viên import
			app.getContent().getEmployeeForm().showFrame(3);
			app.getContent().getEmployeeForm().getEmployeeForm3().getCart2().setFlag(false);
			return;
		}
		app.getContent().getEmployeeForm().showFrame(0);
		app.getContent().getEmployeeForm().getEmployeeForm1().getOptionPanel().setVisible(false);
	}

}
