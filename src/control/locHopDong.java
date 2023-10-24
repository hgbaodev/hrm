package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import BUS.DANHSACHHOPDONG;
import DAO.access_HOPDONGLAODONG;
import DAO.access_PHONGBAN;
import GUI.ConTractForm1;
import GUI.employeeForm1;
import run.App;

public class locHopDong implements ActionListener, KeyListener{
	private App app;
	private static access_HOPDONGLAODONG hd;
	public locHopDong(App app) {
		this.app = app;
	}
	
	
	public static DANHSACHHOPDONG filter(App app) {
		ConTractForm1 temp = app.getContent().getContractForm().getConTractForm1();
		String tenPhongban = temp.getCbbFilter().getSelectedItem().toString();
		
		String loaiHopDong = temp.getCbbFilter2().getSelectedItem().toString();
		DANHSACHHOPDONG danhSachLoc = app.getData().getDanhSachHopDong();
		if(!tenPhongban.equalsIgnoreCase("Phòng ban")) {
			danhSachLoc = new DANHSACHHOPDONG(app.getData().getDanhSachHopDong().getHopDongTheoTenPhong(tenPhongban));
		}
		if(!loaiHopDong.equalsIgnoreCase("Loại hợp đồng")) {
			danhSachLoc = new DANHSACHHOPDONG(danhSachLoc.getHopDongTheoLoaiHopDong(loaiHopDong));
		}
		if(!temp.getTextFromMinSalary().equalsIgnoreCase("")) {
			double minSalary = Double.parseDouble(temp.getTextFromMinSalary());
			danhSachLoc = new DANHSACHHOPDONG(danhSachLoc.getNhanVienByMinLuong(minSalary));
		}
		
		if(!temp.getTextFromMaxSalary().equalsIgnoreCase("")) {
			double maxSalary = Double.parseDouble(temp.getTextFromMaxSalary());
			danhSachLoc = new DANHSACHHOPDONG(danhSachLoc.getNhanVienByMaxLuong(maxSalary));
		}
		
		temp.getCbbFilter().setFocusable(false);
		temp.getCbbFilter2().setFocusable(false);
		return danhSachLoc;
	}
	
	public void keyReleased(KeyEvent e) {
		if((e.getKeyCode()<48 || e.getKeyCode()>59) && e.getKeyChar()!=8 && e.getKeyCode()!=127) {
			System.out.println("sai");
			app.getContent().getContractForm().getConTractForm1().getMinSalary().setText("");
			app.getContent().getContractForm().getConTractForm1().getMaxSalary().setText("");
			return;
		}
		DANHSACHHOPDONG danhSachLoc = filter(app);
		app.getContent().getContractForm().getConTractForm1().setData(danhSachLoc.getObjectToRender());
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DANHSACHHOPDONG danhSachLoc = filter(app);
		app.getContent().getContractForm().getConTractForm1().setData(danhSachLoc.getObjectToRender());
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
