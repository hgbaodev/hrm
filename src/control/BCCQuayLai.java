package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.BangChamCongForm;
import run.App;

/**
 *
 * @author Jhin
 */
public class BCCQuayLai implements MouseListener {

    private App app;

    public BCCQuayLai(App app) {
        this.app = app;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        BangChamCongForm form = app.getContent().getBangChamCongForm();
        app.getContent().getBangChamCongForm().getForm1().getOptionPanel().setVisible(false);
        form.show(0);
    }

    @Override
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
