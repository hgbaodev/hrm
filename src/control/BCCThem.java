package control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import DAO.access_BANGCHAMCONG;
import DAO.access_LUONG;
import DTO.BANGCHAMCONG;
import DTO.SUPPORT;
import GUI.BangChamCongForm2_1;
import GUI.BangChamCongForm3;
import run.App;

/**
 *
 * @author Jhin
 */
public class BCCThem implements MouseListener {

    @SuppressWarnings("FieldMayBeFinal")
    private App app;

    public BCCThem(App app) {
        this.app = app;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        app.getData().getDanhSachBangChamCong();
        BangChamCongForm2_1 temp = app.getContent().getBangChamCongForm().getForm2();
        int row= temp.getObjectTable().getSelectedRow();
        if(temp.getObjectTable().getValueAt(row, 2).toString().equals("Đã chấm công")) {
        	JOptionPane.showMessageDialog(temp,"Nhân viên "+ temp.getObjectTable().getValueAt(row, 1).toString()+temp.getThang().getSelectedItem()+"/"+temp.getNam().getSelectedItem()+" đã được chấm công!! Vui lòng chọn nhân viên khác");
        }
        else {
        	String[] a= temp.getThang().getSelectedItem().toString().split(" ");
            int thang = Integer.parseInt(a[1]) ;
            int nam = Integer.parseInt(temp.getNam().getSelectedItem().toString());

            String[] b= temp.getMa_Ten().getText().split(" ");
            String maNV = b[0];
            
            String maBCC = "BCC" + temp.gettMaNV().getText() + thang + nam + maNV;
            

            
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
            	if(j.getBackground() == Color.white || j.getBackground() == color_TangCa || j.getBackground() == color_Tre) {
            		if(j.isVisible()) {
            			soNgayLam++;
            		}
            	}
            	if(j.getBackground().equals(color_Nghi)) {
            		 soNgayNghi++;
            		 chiTiet= chiTiet+ "N-"+o+"/"+thang+"/"+nam+",";
            	}
            	else if(j.getBackground().equals(color_Tre)) {
            		soNgayTre++;
           		 	chiTiet= chiTiet+ "T-"+o+"/"+thang+"/"+nam+",";
            	} 
            	else if(j.getBackground().equals(color_TangCa)) {
            		String[] c= j.getText().split(" ");
            		 soGioLamThem += Integer.parseInt(c[4]);
            		 chiTiet= chiTiet+ "TC-"+o+"/"+thang+"/"+nam+"-"+c[4]+",";

            	}
            	o++;
            }
            // Them vao list
            BANGCHAMCONG them = new BANGCHAMCONG(maBCC, maNV, thang, nam, soNgayLam, soNgayNghi, soNgayTre, soGioLamThem,chiTiet,"");
            
            // Them vao database
            access_BANGCHAMCONG.insertBCC(them);
            // tạo lương
            access_LUONG.insertLUONG(SUPPORT.chuyenBangChamCongSangLuong(them,0,0,0));
           app.getData().getDanhSachBangChamCong().getDataFromDatabase();
            app.renderBCCTable();
            temp.CapNhatTrangThai();
            reset();
            
            // Tìm và trỏ chuột đến nhân viên chưa chấm công
            int row_num= temp.getObjectTable().getRowCount();
            for(int i=0; i<row_num; i++) {
            	if(temp.getObjectTable().getValueAt(i, 2).equals("Chưa chấm công")) {
            		temp.getObjectTable().setRowSelectionInterval(i, i);
            		temp.getMa_Ten().setText(temp.getObjectTable().getValueAt(i, 1).toString());
            		break;
            	}
            }
        }
        
    }
    public void reset() {
    	BangChamCongForm2_1 temp= app.getContent().getBangChamCongForm().getForm2();
    	for(JLabel i: temp.getArr_1()) {
    		i.setBackground(Color.white);
    		i.setText("");
    	}
    	

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
