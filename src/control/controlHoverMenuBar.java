package control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import DAO.access_BANGDANHGIA;
import DAO.access_LUONG;
import DAO.access_PHONGBAN;
import DAO.access_THONGKE;
import GUI.HomeForm;
import GUI.myPanelAnimation;
import run.App;


public class controlHoverMenuBar implements MouseListener{
	private static int selected;
	private App app;
	private int index;
	private myPanelAnimation panel;
	public controlHoverMenuBar(App app,myPanelAnimation panel,int index, int selected) {
		this.app = app;
		this.panel = panel;
		controlHoverMenuBar.selected= selected;
		this.index = index;
	}
	public void mouseReleased(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {
		if(selected!=index) {
			panel.setColor(new Color(255,255,255,0));
			panel.setColorText(new Color(0,0,0,160));
			panel.useIconNormal();
			app.myRepaint();
		}
	}
	public void mouseEntered(MouseEvent e) {	
//		panel.setColor(new Color(255,255,255,40));
		panel.setColor(new Color(52, 152, 219,200));
		panel.setColorText(Color.white);
		panel.useIconSpecial();
		app.myRepaint();
	}
	public void mouseClicked(MouseEvent e) {
		String chon = app.getMenu().getListMenuItem().get(index).getTitle();
		switch (chon) {
		case "Trang chủ":
			app.getContent().showPage(0);
			app.getContent().getHomePage().getHomeForm1().setData(access_THONGKE.thongKeTrangChuForm3_soLuongNhanVien(), access_THONGKE.thongKeTrangChuForm3_mucLuongTB());
			app.getContent().getHomePage().getHomeForm2().setData(access_PHONGBAN.getDanhSachTenVaSoLuongNhanVienPhongBan());
			app.getContent().getHomePage().getHomeForm3().setTableData(app.getData().getDanhSachPhongBan().getObjectToRender());
			((HomeForm)app.getContent().getHomePage()).getHomeForm2().ani();
			((HomeForm)app.getContent().getHomePage()).getHomeForm1().runChart();
			break;
		case "Tuyển dụng":
			app.getContent().showPage(1);
			break;
		case "Nhân viên":
			app.getContent().showPage(2);
			break;
		case "Hợp đồng":
			app.getContent().showPage(3);
			break;
		case "Phòng ban":
			app.getContent().showPage(4);
			break;
		case "Chấm công":
			app.getContent().showPage(5);
			break;
		case "Lương thưởng":
			app.getContent().showPage(6);
			if(!app.getMangChucNang()[29]) {
				app.getContent().getSalaryForm().getSalaryForm1().setSalaryData(access_LUONG.getObjectToRender(app.getTaiKhoanDangNhap().getUsername()));
			}else {
				app.getContent().getSalaryForm().getSalaryForm1().setSalaryData(access_LUONG.getObjectToRender());
			}
			app.getContent().getSalaryForm().getSalaryForm4().setDanhGiaData(access_BANGDANHGIA.getDanhSachDanhGiaTangLuong());
			break;
			
		case "Đánh giá":
			app.getContent().showPage(7);
			app.getData().getDanhSachBangDanhGia().getDataFromDatabase();
			app.getContent().getDanhGiaForm().setData(locXapSepDanhGia.loc(app).getObjectToRender());
			break;
		case "Tài khoản":
			app.getContent().showPage(8);
			break;
		default:
			app.getContent().showPage(0);
			break;
		}
		
		selected = index;
		app.getMenu().setSelected(selected);
		app.getMenu().draw(selected);
	}
}
