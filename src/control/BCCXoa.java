package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import DAO.access_BANGCHAMCONG;
import DAO.access_LUONG;
import run.App;

/**
 *
 * @author Jhin
 */
public class BCCXoa implements MouseListener {

    private App app;

    public BCCXoa(App app) {
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int index = app.getContent().getBangChamCongForm().getForm1().getTable().getSelectedRow();
        String column1 = app.getContent().getBangChamCongForm().getForm1().getModel().getValueAt(index, 1).toString().trim();
        int res = app.showOption("Bạn có chắc xóa bảng chấm công "+column1+" không?");
        if(res==0) {
        	access_LUONG.deleteLUONG("L"+column1.substring(3));
            access_BANGCHAMCONG.xoaBangChamCongTheoMa(column1);
            app.getData().getDanhSachBangChamCong().getDataFromDatabase();
            app.getContent().getBangChamCongForm().getForm1().setData(app.getData().getDanhSachBangChamCong().getObjectseToRender());
            
        }
        app.getContent().getBangChamCongForm().getForm1().getOptionPanel().setVisible(false);
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
