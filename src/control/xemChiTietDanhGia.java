package control;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JRadioButton;

import DAO.access_BANGDANHGIA;
import DTO.DANHGIA;
import DTO.SUPPORT;
import GUI.BangDanhGiaForm1;
import GUI.DanhGiaView;
import run.App;



public class xemChiTietDanhGia extends MouseAdapter{

	private App app;
	
	public xemChiTietDanhGia(App app) {
		this.app = app;
	}

	public void mouseClicked(MouseEvent e) {
		BangDanhGiaForm1 temp = app.getContent().getDanhGiaForm();
		int index = temp.getTable().getSelectedRow();
		if(index<0) {
			app.showMessage("Vui lòng chọn bảng đánh giá để xem chi tiết!");
			return;
		}
		String maDanhGia = temp.getTable().getValueAt(index, 1).toString().trim();
		DANHGIA x = app.getData().getDanhSachBangDanhGia().getDanhGia(maDanhGia);
		DanhGiaView dgv = app.getContent().getDanhGiaForm2();
		dgv.resetRadio();
		String arr[] = x.getChiTietDanhGia().split(",");
		ArrayList<JRadioButton> list = dgv.getRadioButtons();
		for(int i=0;i<list.size();i+=4) {
			int pos = i+Integer.valueOf(arr[i/4]);
			list.get(pos).setSelected(true);
		}
		dgv.getTfNgayDanhGia().setText(SUPPORT.LocalDateToString(x.getNgayDanhGia()));
		dgv.getLbDiem().setText(x.getDiemDanhGia()+"");
		dgv.getHoTen().setText(x.getMaNhanVien()+" - "+x.getTenNhanVien());
		Object[][] obj = new Object[][] {
			{"1",x.getMaNhanVien()+" - "+x.getTenNhanVien()}
		};
		dgv.setData(obj);
		app.getContent().showPage(9);
		dgv.getObjectTable().setRowSelectionInterval(0, 0);
	}
}
