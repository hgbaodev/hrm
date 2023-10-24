package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.BangChamCongForm;
import run.App;

/**
 *
 * @author Jhin
 */
public class BCCDenFormThem implements ActionListener {

    private App app;

    public BCCDenFormThem(App app) {
        this.app = app;
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		BangChamCongForm form = app.getContent().getBangChamCongForm();
        form.show(1);
        form.getForm2().CapNhatTrangThai();
		form.getForm2().getObjectTable().setRowSelectionInterval(0, 0);
		form.getForm2().getMa_Ten().setText(form.getForm2().getObjectTable().getValueAt(0, 1).toString());
		
	}

}
