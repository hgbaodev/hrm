package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BUS.DANHSACHBANGCHAMCONG;
import GUI.BangChamCongForm1;
import run.App;

/**
 *
 * @author Jhin
 */
public class BCCSapXep implements ActionListener {
	static Boolean check=false;
    private App app;

    public BCCSapXep(App app) {
        this.app = app;
    }

    public static DANHSACHBANGCHAMCONG sort(App app ) {
        BangChamCongForm1 temp = app.getContent().getBangChamCongForm().getForm1();

        // lọc
        DANHSACHBANGCHAMCONG danhSachSapXep = app.getData().getDanhSachBangChamCong();

            

        // sắp xếp
        int select1 = temp.getCbbSort().getSelectedIndex();
        int select2 = temp.getCbbSort_Asc_Desc().getSelectedIndex();

        switch (select1) {
            case 0 ->{
                danhSachSapXep.sortMaBCC(select2);
                check=true;
            }

            case 1 ->{
                danhSachSapXep.sortMaNV(select2);
                check=true;
            }

            case 2 ->{
                danhSachSapXep.sortThoiGianChamCong(select2);
                check=true;
            }
        }

        temp.setData(danhSachSapXep.getObjectseToRender());
        temp.getCbbSort().setFocusable(false);
        temp.getCbbSort_Asc_Desc().setFocusable(false);

        return danhSachSapXep;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DANHSACHBANGCHAMCONG danhSachSapXep = sort(app);
        app.getContent().getBangChamCongForm().getForm1().setData(danhSachSapXep.getObjectseToRender());

//		app.repaint();	
    }
}
