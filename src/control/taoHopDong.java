package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import DAO.access_HOPDONGLAODONG;
import DAO.access_NHANVIEN;
import DTO.HOPDONGLAODONG;
import DTO.SUPPORT;
import GUI.ContractForm4;
import run.App;

public class taoHopDong extends MouseAdapter{
	private App app;
	public taoHopDong(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		
		ContractForm4 temp = app.getContent().getContractForm().getConTractForm4();
		if(temp.getListLabel().get(0).getText().contains("...")) {
			app.showMessage("Vui lòng chọn nhân viên để kí hợp đồng!");
			return;
		}
		String thoiHan = temp.getCbbThoiHanHopDong().getSelectedItem().toString();
		int flag = app.showOption("Bạn có chắc kí hợp đồng có thời hạn "+thoiHan+" với nhân viên "+temp.getListLabel().get(0).getText()+" không?");
		if(flag==0) {
			LocalDate tuNgay = SUPPORT.toLocalDate(temp.getTfNgayBatDau().getText());
			LocalDate denNgay = SUPPORT.toLocalDate(temp.getTfNgayKetThuc().getText());
			String maNhanVien = temp.getListLabel().get(0).getText().split(" - ")[0].trim();
			Double luongCoBan = SUPPORT.changeStringSalaryToDouble(temp.getListLabel().get(12).getText());
			HOPDONGLAODONG x = new HOPDONGLAODONG("HD"+maNhanVien, tuNgay, denNgay, thoiHan, luongCoBan);
			access_HOPDONGLAODONG.insertHOPDONGLAODONG(x);
			access_NHANVIEN.updateMaHopDong(maNhanVien, "HD"+maNhanVien);
			app.showMessage("Đã kí hợp đồng thành công với nhân viên "+ temp.getListLabel().get(0).getText()+"!");
			temp.setSalaryData(access_NHANVIEN.getDanhSachNhanVienThuViecToRender());
			app.repaint();
		}
		
	}
}
