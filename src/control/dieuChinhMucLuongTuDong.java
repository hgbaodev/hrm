package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.access_BANGDANHGIA;
import DAO.access_LUONG;
import DAO.access_NHANVIEN;
import GUI.SalaryForm4;
import run.App;

public class dieuChinhMucLuongTuDong extends MouseAdapter{
	private App app;
	public dieuChinhMucLuongTuDong(App app) {
		this.app =app;
	}
	public void mouseClicked(MouseEvent e) {
		SalaryForm4 temp = app.getContent().getSalaryForm().getSalaryForm4();
		String tangLuongGioi = temp.getCbbTangLuongGioi().getSelectedItem().toString();
		String tangLuongXuatSac = temp.getCbbTangLuongXuatSac().getSelectedItem().toString();
		int mucTangGioi = Integer.valueOf(tangLuongGioi.charAt(0)+"");
		int mucTangXS = Integer.valueOf(tangLuongXuatSac.charAt(0)+"");
		Object[][] obj = temp.getData();
		for(int i=0;i<obj.length;i++) {
			if(obj[i][5].toString().equals("Xuất sắc")) {
				System.out.println("Xuất sắc ->"+obj[i][1].toString());
				access_LUONG.tangLuongHangNam("HD" + obj[i][1].toString().split(" - ")[0], 1.0+mucTangXS/100.0);
				System.out.println(1+mucTangXS/100.0);
			}else if(obj[i][5].toString().equals("Giỏi")) {
				access_LUONG.tangLuongHangNam("HD" + obj[i][1].toString().split(" - ")[0], 1.0+mucTangGioi/100.0);
			}
		}
		temp.setDanhGiaData(access_BANGDANHGIA.getDanhSachDanhGiaTangLuong());
		app.showMessage("Tăng lương thành công!");
		System.out.println("Tăng lương hàng năm");
	}
}
