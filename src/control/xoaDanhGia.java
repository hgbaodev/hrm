package control;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import DAO.access_BANGDANHGIA;
import DTO.SUPPORT;
import GUI.BangDanhGiaForm1;
import GUI.DanhGiaView;
import run.App;



public class xoaDanhGia extends MouseAdapter{

	private App app;
	
	public xoaDanhGia(App app) {
		this.app = app;
	}

	public void mouseClicked(MouseEvent e) {
		BangDanhGiaForm1 temp = app.getContent().getDanhGiaForm();
		int index = temp.getTable().getSelectedRow();
		if(index<0) {
			app.showMessage("Vui lòng chọn bảng đánh giá để xóa!");
			return;
		}
		String maDanhGia = temp.getTable().getValueAt(index, 1).toString().trim();
		int res = app.showOption("Bạn có muốn xóa bảng đánh giá "+maDanhGia+" không?");
		if(res==0) {
			access_BANGDANHGIA.deleteBangDanhGia(maDanhGia);
			
			app.getData().getDanhSachBangDanhGia().getDataFromDatabase();
			temp.setData(app.getData().getDanhSachBangDanhGia().getObjectToRender());
			app.showMessage("Đã xóa bảng đánh giá "+maDanhGia+"!");
		}
		
		
	}
}
