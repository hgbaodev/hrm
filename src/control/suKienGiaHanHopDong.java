package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import DAO.access_HOPDONGLAODONG;
import DTO.HOPDONGLAODONG;
import DTO.SUPPORT;
import GUI.ConTractForm1;
import GUI.ConTractForm2;
import run.App;

public class suKienGiaHanHopDong extends MouseAdapter {
	
	private App app;
	
	public suKienGiaHanHopDong(App app) {
		this.app = app;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		ConTractForm2 con2 = app.getContent().getContractForm().getConTractForm2();
		String maHopDong = con2.getTextFieldList().get(3).getText();
		String thongTinNhanVien = con2.getTextFieldList().get(0).getText() + " - "+ con2.getTextFieldList().get(1).getText();
		String thoiGianGiaHanThem = con2.getCbbGiaHan().getSelectedItem().toString().trim();
		int result = app.showOption("Bạn chắc chắn muốn gia hạn hợp đồng của nhân viên "+thongTinNhanVien+" thêm "+thoiGianGiaHanThem+" không?");
		
		if(result == 0) {
			String[] loaiHopDong = con2.getTextFieldList().get(6).getText().split(" ");
			
			String[] thoiGian = thoiGianGiaHanThem.split(" ");
			String loaiHopDongMoi = Integer.valueOf(loaiHopDong[0])+Integer.valueOf(thoiGian[0])+" năm";
			String denNgayCu = con2.getTextFieldList().get(5).getText();
			access_HOPDONGLAODONG.updateHopDong(SUPPORT.toLocalDate(denNgayCu).plusYears(Integer.valueOf(thoiGian[0])), loaiHopDongMoi, maHopDong);
			JOptionPane.showMessageDialog(app, "Gia hạn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			// lấy lại dữ liệu
			app.getData().getDanhSachHopDong().getDataFromDatabase();
			app.getContent().getContractForm().getConTractForm1().setData(timKiemHopDong.find(app, locHopDong.filter(app)).getObjectToRender());
			app.getContent().getContractForm().showFrame(0);
		}
		app.getContent().getContractForm().getConTractForm1().getOptionPanel().setVisible(false);	

	}
}
