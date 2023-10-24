package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import BUS.DANHSACHHOPDONG;
import DAO.access_HOPDONGLAODONG;
import GUI.ConTractForm3;
import run.App;

public class thongKeHopDong implements ActionListener{
	
	private App app;
	
	public thongKeHopDong(App app) {
		this.app = app;
	}

	public static DANHSACHHOPDONG thongKe(App app) {
		ConTractForm3 con3 = app.getContent().getContractForm().getConTractForm3();
		int select = con3.getCbbPhanLoai().getSelectedIndex();
		DANHSACHHOPDONG danhSach = null;

		if (select == 0) {
			danhSach = app.getData().getDanhSachHopDong();
			con3.getLabelSoLuong().setText("Số lượng: "+access_HOPDONGLAODONG.getSoLuongHopDong());
		}else if (select == 1) {
			danhSach = new DANHSACHHOPDONG(access_HOPDONGLAODONG.getHopDongMoiKy());
			con3.getLabelSoLuong().setText("Số lượng: "+access_HOPDONGLAODONG.getSoLuongHopDongMoiKy());
		}else if (select == 2) {
			danhSach = new DANHSACHHOPDONG(access_HOPDONGLAODONG.getHopDongSapHetHan());
			con3.getLabelSoLuong().setText("Số lượng: "+access_HOPDONGLAODONG.getSoLuongHopDongSapHetHan());
		}else {
			danhSach = new DANHSACHHOPDONG(access_HOPDONGLAODONG.getHopDongDaHetHan());
			con3.getLabelSoLuong().setText("Số lượng: "+access_HOPDONGLAODONG.getSoLuongHopDongDaHetHan());
		}
		
		return danhSach;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DANHSACHHOPDONG danhSach = thongKe(app);
		app.getContent().getContractForm().getConTractForm3().setConTractForm3Data(danhSach.getObjectToRender());		
	}
	
	
}
