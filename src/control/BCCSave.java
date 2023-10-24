package control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import DAO.access_BANGCHAMCONG;
import DAO.access_LUONG;
import DTO.BANGCHAMCONG;
import DTO.LUONG;
import DTO.SUPPORT;
import GUI.BangChamCongForm2_1;
import GUI.BangChamCongForm3;
import run.App;

/**
 *
 * @author Jhin
 */
public class BCCSave implements MouseListener {

    @SuppressWarnings("FieldMayBeFinal")
    private App app;

    public BCCSave(App app) {
        this.app = app;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        BangChamCongForm3 temp = app.getContent().getBangChamCongForm().getForm3();
        String[] a = temp.getArr_lb().get(2).getText().split(" ");
        int thang = Integer.parseInt(a[1].split("/")[0]) ;
        int nam = Integer.parseInt(a[1].split("/")[1]);

        String[] b= temp.getArr_lb().get(1).getText().split(" ");
        String maNV = b[0];
        
        String maBCC = temp.getArr_lb().get(0).getText();
       
        int soNgayLam =0;
        int soNgayNghi =0;
        int soNgayTre=0;
        int soGioLamThem=0; 
        String chiTiet="";
    	Color color_Nghi = temp.color_Nghi;
    	Color color_TangCa = temp.color_TangCa;
    	Color color_Tre = temp.color_Tre;
        int o=1;
        for(JLabel j: temp.getArr_1()) {
        	if(j.getBackground() == Color.white || j.getBackground() == color_Tre || j.getBackground() == color_TangCa ) {
        		if(j.isVisible()) {
        			soNgayLam++;
        		}
        	}
        	if(j.getBackground().equals(color_Nghi)) {
        		 soNgayNghi++;
        		 chiTiet= chiTiet+ "N-"+o+"/"+thang+"/"+nam+",";
        	}
        	if(j.getBackground().equals(color_Tre)) {
        		soNgayTre++;
       		 	chiTiet= chiTiet+ "T-"+o+"/"+thang+"/"+nam+",";
        	} 
        	if(j.getBackground().equals(color_TangCa)) {
        		 String[] c= j.getText().split(" ");
        		 soGioLamThem += Integer.parseInt(c[4]);
        		 chiTiet= chiTiet+ "TC-"+o+"/"+thang+"/"+nam+"-"+c[4]+",";

        	}
        	o++;
        }
	//      // Them vao database
	      BANGCHAMCONG temp_1 = new BANGCHAMCONG(maBCC, maNV, thang, nam, soNgayLam, soNgayNghi, soNgayTre, soGioLamThem,chiTiet,"");
	      access_BANGCHAMCONG.updateBANGCHAMCONG(temp_1);
	      access_LUONG.deleteLUONG("L"+maBCC.substring(3));
	      LUONG l = SUPPORT.chuyenBangChamCongSangLuong(temp_1, 0, 0, 0);
	      access_LUONG.insertLUONG(l);
	      
	      // Them vao list
	      for(BANGCHAMCONG i: app.getData().getDanhSachBangChamCong().getList()) {
	    	  if(i.getMaBangChamCong().equals(temp_1.getMaBangChamCong())) {
	    		  app.getData().getDanhSachBangChamCong().getList().remove(i);
	    		  break;
	    	  }
	      }
	      app.showMessage("Chỉnh sửa thành công!");
	      app.getData().getDanhSachBangChamCong().getDataFromDatabase();
	      app.renderBCCTable();
	        
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
