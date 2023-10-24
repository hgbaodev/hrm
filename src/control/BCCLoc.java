package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BUS.DANHSACHBANGCHAMCONG;
import DAO.access_BANGCHAMCONG;
import GUI.BangChamCongForm1;
import run.App;

/**
 *
 * @author Jhin
 */
public class BCCLoc implements ActionListener {

    private App app;
    static Boolean check = false;


	private static access_BANGCHAMCONG bcc;

    public BCCLoc(App app) {
        this.app = app;
    }

    @SuppressWarnings("null")
    public static DANHSACHBANGCHAMCONG filter(App app) {
        BangChamCongForm1 temp = app.getContent().getBangChamCongForm().getForm1();
        DANHSACHBANGCHAMCONG danhSachLoc;

        String tenPB = temp.getCbbFilterPhong().getSelectedItem().toString();
        // Lọc tên
        
        
        if (tenPB.equalsIgnoreCase("Phòng ban")) {
            danhSachLoc = app.getData().getDanhSachBangChamCong();
        	check=false;
        } else {
        	check=true;
            String maPhongBan = access_BANGCHAMCONG.getMaPBTuTen(tenPB);
            danhSachLoc = new DANHSACHBANGCHAMCONG(access_BANGCHAMCONG.getBangChamCongTheoMaPhong(maPhongBan));
        }
     // check xem chấm công cá nhân
        if(!app.getMangChucNang()[24]) {
        	danhSachLoc = new DANHSACHBANGCHAMCONG(danhSachLoc.getBangChamCongTheoMaNV(app.getTaiKhoanDangNhap().getUsername()));
        }
        
         String thang = temp.getCbbFilterMonth().getSelectedItem().toString();
        // Lọc tháng
        if (!thang.equals("Tháng")) {
        	check=true;
        	thang  = thang.split(" ")[1];
            danhSachLoc = new DANHSACHBANGCHAMCONG(danhSachLoc.getBangChamCongTheoThang(thang));
        }
        
        // Lọc năm
        String nam = temp.getCbbFilterYear().getSelectedItem().toString();
        if (!nam.equals("Năm")) {
        	check=true;
            danhSachLoc = new DANHSACHBANGCHAMCONG(danhSachLoc.getBangChamCongTheoNam(nam));
        }
        if(tenPB.equals("Phòng ban") && thang.equals("Tháng") && nam.equals("Năm")) {
        	check= false;
        }
        int select1 = temp.getCbbSort().getSelectedIndex();
        int select2 = temp.getCbbSort_Asc_Desc().getSelectedIndex();

        switch (select1) {
            case 0 ->{
            	danhSachLoc.sortMaBCC(select2);
                check=true;
            }
            case 1 ->{
            	danhSachLoc.sortMaNV(select2);
                check=true;
            }
            case 2 ->{
            	danhSachLoc.sortThoiGianChamCong(select2);
                check=true;
            }
        }
        return danhSachLoc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DANHSACHBANGCHAMCONG danhSachLoc  = filter(app);
        danhSachLoc = BCCTimKiem.find(app,danhSachLoc);
        app.getContent().getBangChamCongForm().getForm1().setData(danhSachLoc.getObjectseToRender());
    }

}
