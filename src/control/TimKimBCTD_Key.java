package control;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import BUS.DANHSACHBAOCAOTUYENDUNG;
import DTO.BAOCAOTUYENDUNG;
import DTO.NHANVIEN;
import run.App;

public class TimKimBCTD_Key implements KeyListener{
	private App trangchinh;
	public TimKimBCTD_Key(App app) {
		this.trangchinh = app;
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
		try {
			DANHSACHBAOCAOTUYENDUNG find= new DANHSACHBAOCAOTUYENDUNG();
			String a=trangchinh.getContent().getRecruitmentForm().getTuyenDungView().getTuyenDung_Find().getText().trim().toLowerCase();
			for(BAOCAOTUYENDUNG i: trangchinh.getData().getDanhsachbaocaotuyendung().getList()) {
				if(i.getChucVu().toLowerCase().contains(a)||
					i.getMaTuyenDung().toLowerCase().contains(a)||
					i.getDoTuoi().toLowerCase().contains(a)||
					i.getGioiTinh().toLowerCase().contains(a)||
					i.getHocVan().toLowerCase().contains(a)
				)
					find.getList().add(i);
			}
			trangchinh.getContent().getRecruitmentForm().getTuyenDungView().setData(find.getObject());
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}

}