package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import BUS.DANHSACHBANGCHAMCONG;
import GUI.BangChamCongForm1;
import run.App;

/**
 *
 * @author Jhin
 */
public class BCCTimKiem implements KeyListener {

    @SuppressWarnings("FieldMayBeFinal")
    private App app;
    static Boolean check=false;

    public BCCTimKiem(App app) {
        this.app = app;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        DANHSACHBANGCHAMCONG danhSachTimKiem = find(app,BCCLoc.filter(app));
        app.getContent().getBangChamCongForm().getForm1().setData(danhSachTimKiem.getObjectseToRender());
		app.getContent().getBangChamCongForm().getForm1().getJsp1().getVerticalScrollBar().setValue(0);
    }

    public static DANHSACHBANGCHAMCONG find(App app, DANHSACHBANGCHAMCONG data) {
        String find = app.getContent().getBangChamCongForm().getForm1().getTextFromFindField();
        DANHSACHBANGCHAMCONG danhSachTimKiem = new DANHSACHBANGCHAMCONG(data.timBangChamCong(find));
        BangChamCongForm1 temp = app.getContent().getBangChamCongForm().getForm1();

        int select1 = temp.getCbbSort().getSelectedIndex();
        int select2 = temp.getCbbSort_Asc_Desc().getSelectedIndex();

        switch (select1) {
            case 0 ->{
            	danhSachTimKiem.sortMaBCC(select2);
                check=true;
            }

            case 1 ->{
            	danhSachTimKiem.sortMaNV(select2);
                check=true;
            }

            case 2 ->{
            	danhSachTimKiem.sortThoiGianChamCong(select2);
                check=true;
            }
        }
        return danhSachTimKiem;
    }
}
