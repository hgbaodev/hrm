package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import DAO.access_BANGDANHGIA;
import DAO.access_NHANVIEN;
import DAO.access_PHONGBAN;
import DTO.CHECK;
import DTO.CONNGUOI;
import DTO.NHANVIEN;
import run.App;

public class themNhanVien extends MouseAdapter{
	private App app;
	public themNhanVien(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("Thêm");
		
		String arr[] = app.getContent().getEmployeeForm().getEmployeeForm3().getCart1().getDataFromForm();
		if(!CHECK.checkEmployeeData(app, arr)) {
			return;
		}
		app.getContent().getEmployeeForm().getEmployeeForm3().getCart1().loadImageIntoProject();
		arr = app.getContent().getEmployeeForm().getEmployeeForm3().getCart1().getDataFromForm();
		NHANVIEN x = app.getData().getDanhSachNhanVien().addEmployeeFromStringData(arr);
		access_NHANVIEN.insertNHANVIEN(x);
		app.renderEmployeeTable();
		app.getContent().getEmployeeForm().showFrame(0);
		app.repaint();
	}
}
