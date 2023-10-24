package control;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import BUS.DANHSACHUNGVIEN;
import DTO.BAOCAOTUYENDUNG;
import DTO.NHANVIEN;
import DTO.UNGVIEN;
import run.App;

public class TimKiemUngVien_Key implements KeyListener{
	private App app;
	public TimKiemUngVien_Key(App app) {
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
		try {
				DANHSACHUNGVIEN find= new DANHSACHUNGVIEN();
				String a=app.getContent().getRecruitmentForm().getUngVienView().getUngVien_Find().getText().trim().toLowerCase();
				String maTuyenDung = app.getContent().getRecruitmentForm().getUngVienView().getComboBox_MaTuyenDung().getSelectedItem().toString();
				ArrayList<UNGVIEN> danhsach = null;
				if(maTuyenDung.equalsIgnoreCase("Mã tuyển dụng")) {
					 danhsach = app.getData().getDanhsachungvien().getList();
					
				}else {
					danhsach = app.getData().getDanhsachungvien().getList(maTuyenDung);
				}
				
				
				for(UNGVIEN i: danhsach){
					if(i.getChucVu().contains(a)||
						i.getTrinhDo().getTrinhDoHocVan().contains(a)||
						i.getTrinhDo().getTrinhDoChuyenMon().contains(a)||
						i.getTrinhDo().getChuyenNganh().contains(a)||
						i.getGioiTinh().contains(a)||
						i.getHoTen().toLowerCase().contains(a) ||
						i.getSdt().contains(a)||
						i.getEmail().contains(a)
					) 
					{
						find.getList().add(i);
					}
				}
				app.getContent().getRecruitmentForm().getUngVienView().setData(find.getObject());
		} catch (Exception e2) {
			e2.getMessage();
		}
		
	}

}