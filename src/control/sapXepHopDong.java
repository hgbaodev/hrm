package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BUS.DANHSACHHOPDONG;
import GUI.ConTractForm1;
import run.App;

public class sapXepHopDong implements ActionListener{
	private App app;
	public sapXepHopDong(App app) {
		this.app = app;
	}
	
	public static DANHSACHHOPDONG sort(App app) {		
		ConTractForm1 temp = app.getContent().getContractForm().getConTractForm1();
		// lọc
		DANHSACHHOPDONG danhSachSapXep = null;
		
		if(temp.getEnable_find()) {
//			danhSachSapXep = timKiemHopDong.find(app);
		}else if(temp.getEnable_filter()) {
			danhSachSapXep = locHopDong.filter(app);
		}else {
			danhSachSapXep = app.getData().getDanhSachHopDong();
		}
		
		// sắp xếp
		int select1 = temp.getCbbSort().getSelectedIndex();
		int select2 = temp.getCbbSort_Asc_Desc().getSelectedIndex();
		if(select1==0) {
			danhSachSapXep.sortByID(select2);
		}else if(select1==1) {
			danhSachSapXep.sortByName(select2);
		}else if(select1==2) {
			danhSachSapXep.sortByLoaiHopDong(select2);
		}else if(select1==3) {
			danhSachSapXep.sortByTuNgay(select2);
		}else if(select1==4) {
			danhSachSapXep.sortByDenNgay(select2);
		}else if(select1==5) {
			danhSachSapXep.sortBySalary(select2);
		}
		temp.getCbbSort().setFocusable(false);
		temp.getCbbSort_Asc_Desc().setFocusable(false);
		return danhSachSapXep; 
	}
	
	public void actionPerformed(ActionEvent e) {
		DANHSACHHOPDONG danhSachSapXep = sort(app);		
		app.getContent().getContractForm().getConTractForm1().setData(danhSachSapXep.getObjectToRender());
		
//		app.repaint();	
		}

}

