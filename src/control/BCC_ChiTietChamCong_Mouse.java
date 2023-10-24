package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import org.apache.poi.util.SystemOutLogger;

import DTO.BANGCHAMCONG;
import GUI.BangChamCongForm;
import GUI.BangChamCongForm1;
import GUI.BangChamCongForm2_1;
import run.App;

public class BCC_ChiTietChamCong_Mouse implements MouseListener {
    private App app;

    public BCC_ChiTietChamCong_Mouse(App app) {
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        BangChamCongForm1 temp = app.getContent().getBangChamCongForm().getForm1();
        int row= temp.getTable().rowAtPoint(e.getPoint());
		String maBCC= temp.getTable().getValueAt(row, 1).toString();
		for(BANGCHAMCONG i: app.getData().getDanhSachBangChamCong().getList()) {
			if(i.getMaBangChamCong().equals(maBCC)) {
				for(JLabel k: temp.getArr()) {
					k.setText("");
				}
				if(i.getChiTiet()==null) {
					System.out.println("null");
				}
				else {
					String[] a= i.getChiTiet().split(",");
					for(int j=0; j<a.length;j++) {
						String c = null;
						String[] b= a[j].split("-");
						if(b[0].equals("N")) {
							c=b[1]+": "+" Nghỉ";
						}
						else if(b[0].equals("T"))
							c=b[1]+": "+" Đi trễ";
						else if(b[0].equals("TC"))
							c = b[1]+": "+"Tăng ca "+ b[2] +" Giờ";
						temp.getArr().get(j).setText(c);
					}
				}


			}
		}
		System.out.println("Clicked");
    }

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
