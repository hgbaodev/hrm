package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import BUS.DANHSACHBANGDANHGIA;
import DTO.BAOCAOTUYENDUNG;
import DTO.DANHGIA;
import GUI.BangDanhGiaForm1;
import run.App;

public class TimKimDG_Key implements KeyListener{
	private App app;
	public TimKimDG_Key(App app) {
		this.app = app;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		BangDanhGiaForm1 temp = app.getContent().getDanhGiaForm();
		DANHSACHBANGDANHGIA ds = locXapSepDanhGia.loc(app);
		String find = temp.getTextFromFindField().toLowerCase();
		ArrayList<DANHGIA> arr = new ArrayList<>();
		for(DANHGIA i : ds.getList()) {
			if(i.getMaDanhGia().toLowerCase().contains(find) || i.getMaNhanVien().toLowerCase().contains(find) || i.getTenNhanVien().toLowerCase().contains(find) || i.getMaDanhGia().toLowerCase().contains(find) || i.getTenNguoiDanhGia().toLowerCase().contains(find) || i.getXepLoai().toLowerCase().equals(find)) {
				arr.add(i);
			}
		}
		ds = new DANHSACHBANGDANHGIA(arr);
		temp.setData(ds.getObjectToRender());	
	}

}