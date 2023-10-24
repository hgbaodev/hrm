package control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import DAO.access_BANGCHAMCONG;
import DTO.BANGCHAMCONG;
import GUI.BangChamCongForm3;
import run.App;

/**
 *
 * @author Jhin
 */
public class BCCSua implements MouseListener {

    @SuppressWarnings("FieldMayBeFinal")
    private App app;

    public BCCSua(App app) {
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    	//
    	
    	app.showMessage("Chức năng hiện đang gặp sự cố! Vui lòng xóa bảng chấm công và thực hiện chấm lại!");
    	return;
    }
    public void reset() {
    	BangChamCongForm3 temp= app.getContent().getBangChamCongForm().getForm3();
    	for(JLabel i: temp.getArr_1()) {
    		i.setBackground(Color.white);
    		i.setText("");
    		System.out.println("reset");
    	}

    }
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
