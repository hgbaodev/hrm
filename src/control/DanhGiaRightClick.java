package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
import run.App;

/**
 *
 * @author Jhin
 */
public class DanhGiaRightClick extends MouseAdapter {

    private App app;

    public DanhGiaRightClick(App app) {
        this.app = app;
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
//        	if(!app.getMangChucNang()[26]) {
//        		return;
//        	}
        	int value = e.getY();
            app.getContent().getDanhGiaForm().getOptionPanel().setBounds(e.getX(), value, 189, 70);
            value /= 40;
            if (app.getContent().getDanhGiaForm().getTable().getSelectedRowCount() > 1) {
                int arr[] = app.getContent().getBangChamCongForm().getForm1().getTable().getSelectedRows();
                app.getContent().getDanhGiaForm().getTable().setRowSelectionInterval(arr[0], arr[arr.length - 1]);
            } else {
                app.getContent().getDanhGiaForm().getTable().setRowSelectionInterval(value, value);
            }
            app.getContent().getDanhGiaForm().getOptionPanel().setVisible(true);
            return;
            
        }
        app.getContent().getDanhGiaForm().getOptionPanel().setVisible(false);
    }
}
