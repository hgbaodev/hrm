package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.access_NHANVIEN;
import DTO.FORMAT;
import DTO.UNGVIEN;
import GUI.UngVienView;
import run.App;

public class UngVienView_Tuyen_HienThi_Action implements ActionListener{
	private App app;
	
	public UngVienView_Tuyen_HienThi_Action(App app) {
		this.app = app;
	}
	public void actionPerformed(ActionEvent e) {
		UngVienView temp = app.getContent().getRecruitmentForm().getUngVienView();
		int index = temp.getObjectTable().getSelectedRow();
		if(index<0) {
			app.showMessage("Chưa chọn ứng viên!");
			return;
		}
		String maUngVien = temp.getTableModel().getValueAt(index, 1).toString().split(" - ")[0];
		UNGVIEN ungVien = app.getData().getDanhsachungvien().getUngVien(maUngVien);
		if(!ungVien.getTrangThai().equals("Chưa tuyển")) {
			app.showMessage("Đã tuyển ứng viên này!");
			return;
		}
		String data[] = ungVien.getDataToTuyen();
		temp.getFormTuyenUngVien().setData(data);
		temp.getFormTuyenUngVien().setVisible(true);
	}

}
