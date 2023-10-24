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
    	
//    	reset();
//    	BangChamCongForm3 temp= app.getContent().getBangChamCongForm().getForm3();
//        int index = app.getContent().getBangChamCongForm().getForm1().getTable().getSelectedRow();
//        String maBCC = (String) app.getContent().getBangChamCongForm().getForm1().getModel().getValueAt(index, 1);
//        String ma_Ten = (String) app.getContent().getBangChamCongForm().getForm1().getModel().getValueAt(index, 2);
//        String thangNam = (String) app.getContent().getBangChamCongForm().getForm1().getModel().getValueAt(index, 3);
//        temp.getArr_lb().get(0).setText(maBCC);
//        temp.getArr_lb().get(1).setText(ma_Ten);
//        temp.getArr_lb().get(2).setText("Tháng "+thangNam);
//        
//        // Cập nhật lại ô chấm công phù hợp với tháng
//        int thang= Integer.parseInt(thangNam.split("/")[0]);
//        if(thang==2) {
//        	temp.getArr_1().get(28).setVisible(false);
//        	temp.getArr_1().get(29).setVisible(false);
//        	temp.getArr_1().get(30).setVisible(false);
//		}
//		if(thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang==12) {
//			temp.getArr_1().get(28).setVisible(true);
//			temp.getArr_1().get(29).setVisible(true);
//			temp.getArr_1().get(30).setVisible(true);
//		}
//		if(thang == 4 || thang == 6 || thang == 9 || thang ==11) {
//			temp.getArr_1().get(28).setVisible(true);
//			temp.getArr_1().get(29).setVisible(true);
//			temp.getArr_1().get(30).setVisible(false);
//		}
//		
//        BANGCHAMCONG x = access_BANGCHAMCONG.getBangChamCongTuMa(maBCC);
//        System.out.println(x.getChiTiet());
//        if(!x.getChiTiet().equals("")) {
//            String d[]= x.getChiTiet().split(",");
//            for(int i=0;i<d.length;i++) {
//            	xuLy(d[i]);
//            }        
//        }
//
//        app.getContent().getBangChamCongForm().show(2);
//    }
//    
//    //Tô màu các ô
//    public void xuLy(String chiTiet) {
//    	BangChamCongForm3 temp= app.getContent().getBangChamCongForm().getForm3();
//    	String a=chiTiet.split("-")[0];
//		String b=chiTiet.split("-")[1];
//		int c=Integer.parseInt(b.split("/")[0]);
//    	if(a.equals("N")) {
//    		temp.getArr_1().get(c-1).setBackground(temp.color_Nghi);
//    		temp.getArr_1().get(c-1).setText("NGHỈ");
//    	}
//    	else if(a.equals("T")) {
//    		temp.getArr_1().get(c-1).setBackground(temp.color_Tre);
//    		temp.getArr_1().get(c-1).setText("TRỄ");
//    	}
//    	else if(a.equals("TC")) {
//    		temp.getArr_1().get(c-1).setBackground(temp.color_TangCa);
//    		temp.getArr_1().get(c-1).setText("<html> TĂNG CA <br> "+chiTiet.split("-")[2]+" giờ </html>");
//
//    	}
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
