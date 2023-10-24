package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.access_NHANVIEN;
import GUI.ContractForm4;
import run.App;

public class showNhanVienKiHopDong extends MouseAdapter{
	private App app;
	public showNhanVienKiHopDong(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		ContractForm4 temp = app.getContent().getContractForm().getConTractForm4();
		int index = temp.getTable().getSelectedRow();
		String maNhanVien = temp.getModel().getValueAt(index, 1).toString().split(" - ")[0].trim();
		String data[] = access_NHANVIEN.getThongTinNhanVienKiHopDong(maNhanVien);
		temp.setDataNhanVienKiHopDong(data);
	}
}
