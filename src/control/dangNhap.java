package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import DAO.access_NHOMQUYEN;
import DAO.access_TAIKHOAN;
import DTO.TAIKHOAN;
import run.run;
public class dangNhap extends MouseAdapter{
	private run r;
	public dangNhap(run r) {
		this.r = r;
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("Đăng nhập");
		String arr[]= r.getLogin().getData();
		ArrayList<TAIKHOAN> danhSachTaiKhoan = access_TAIKHOAN.getList();
		for(TAIKHOAN i : danhSachTaiKhoan) {
			if(i.getUsername().equals(arr[0])) {
				System.out.println("Đúng username!");
				if(i.getPass().equals(arr[1])) {
					System.out.println("Đúng password!");
					// cập nhật phiên đăng nhập
					r.getApp().setTaiKhoanDangNhap(i);
					r.getApp().setMangChucNang(access_NHOMQUYEN.getChucNangTaiKhoan(i.getUsername()));
					// tiền xử lý giao diện
					r.getApp().tienXuLy();
					r.getApp().setVisible(true);
					r.getLogin().setVisible(false);
					r.getApp().getContent().getHomePage().getHomeForm2().ani();
					r.getApp().getContent().getHomePage().getHomeForm1().runChart();
					// dừng tiến trình trang login
					r.getLogin().getTimer().stop();
					return;
				}
				r.getApp().showMessage("Mật khẩu không đúng");
				return;
			}
			
		}
		r.getApp().showMessage("Tên đăng nhập không tồn tại!");
	}
}
