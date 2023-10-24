package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
import run.App;

/**
 *
 * @author Jhin
 */
public class BCCRightClick implements MouseListener {

    private App app;

    public BCCRightClick(App app) {
        this.app = app;
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
        	if(!app.getMangChucNang()[26]) {
        		return;
        	}
        	int value = e.getY();
            app.getContent().getBangChamCongForm().getForm1().getOptionPanel().setBounds(e.getX(), value, 189, 70);
            value /= 40;
            if (app.getContent().getBangChamCongForm().getForm1().getTable().getSelectedRowCount() > 1) {
                int arr[] = app.getContent().getBangChamCongForm().getForm1().getTable().getSelectedRows();
                app.getContent().getBangChamCongForm().getForm1().getTable().setRowSelectionInterval(arr[0], arr[arr.length - 1]);
            } else {
                app.getContent().getBangChamCongForm().getForm1().getTable().setRowSelectionInterval(value, value);
            }
            app.getContent().getBangChamCongForm().getForm1().getOptionPanel().setVisible(true);
            return;
            
        }
        app.getContent().getBangChamCongForm().getForm1().getOptionPanel().setVisible(false);
    }
}
