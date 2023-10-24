package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import DAO.access_NHANVIEN;
import DTO.NHANVIEN;
import run.App;

public class xoaNhanVien implements MouseListener{
	private App app;
	public xoaNhanVien(App app) {
		this.app = app;
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
		String str[] = app.getContent().getEmployeeForm().getEmployeeForm1().getIDEmployeeToDelete();
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
		}
		if(str.length>1) {
			// xóa nhiều nhân viên
			int result = app.showOption("Bạn có muốn xóa các nhân viên này khỏi danh sách không?");
			if(result==0) {
				for(int i=0;i<str.length;i++) {
					app.getData().getDanhSachNhanVien().deleteByID(str[i]);
					access_NHANVIEN.hiddenNhanVien(str[i]);
				}
				
			}else {
				return;
			}
			
		}else {
			// xóa 1 nhân viên
			
			NHANVIEN x = app.getData().getDanhSachNhanVien().getNhanVien(str[0]);
			int result = app.showOption("Bạn có muốn xóa nhân viên "+x.getMaNhanVien()+" - "+x.getHoTen()+" khỏi danh sách không?");
			if(result==0) {
				access_NHANVIEN.hiddenNhanVien(str[0]);
				app.getData().getDanhSachNhanVien().deleteByID(str[0]);
			}
			
		}
		app.renderEmployeeTable();
		app.repaint();
		
		
	}

}
