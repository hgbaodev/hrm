package control;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import DAO.access_HOPDONGLAODONG;
import DAO.access_NHANVIEN;
import DAO.access_TAIKHOAN;
import DTO.HOPDONGLAODONG;
import DTO.NHANVIEN;
import run.App;

public class showGiaHanHopDong extends MouseAdapter{
	private App app;
	public showGiaHanHopDong(App app) {
		this.app  =app;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int index = app.getContent().getContractForm().getConTractForm1().getTable().getSelectedRow();
		String data_column3 = (String)app.getContent().getContractForm().getConTractForm1().getModel().getValueAt(index, 1);
		String maNhanVien = data_column3.split(" - ")[0].trim();
		
		HOPDONGLAODONG x = app.getData().getDanhSachHopDong().getHopDongTheoMaNhanVien(maNhanVien);
		System.out.println(maNhanVien);
		System.out.println(x.getLuongCoBan());
		app.getContent().getContractForm().getConTractForm2().setData(x.getObjectToRender());
		app.getContent().getContractForm().getConTractForm2().setImageEmployee(access_TAIKHOAN.getAvatar(maNhanVien));
		app.getContent().getContractForm().showFrame(1);
	}
}
