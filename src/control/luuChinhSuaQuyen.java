package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import DAO.access_NHANVIEN;
import DAO.access_NHOMQUYEN;
import DAO.access_PHONGBAN;
import DAO.access_TAIKHOAN;
import DTO.CHECK;
import DTO.PHONGBAN;
import DTO.SUPPORT;
import GUI.AccountForm;
import GUI.departmentForm2;
import GUI.Department_Add.ACTION_TYPE;
import run.App;

public class luuChinhSuaQuyen implements ActionListener{
	private App app;
	public luuChinhSuaQuyen(App app) {
		this.app = app;
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Chỉnh sửa quyền tài khoản");
		AccountForm temp = app.getContent().getAccountForm();
		String username = temp.getLabelChiTietTaiKhoan().getText().split(" - ")[0];
		String maNhomQuyen = temp.getCbbQuyen().getSelectedItem().toString();
		access_TAIKHOAN.UpdateQuyenTaiKhoan(username, maNhomQuyen);
		app.showMessage("Phân quyền thành công!");
		
		temp.setAccountData(access_TAIKHOAN.getObjectToRender(temp.getCbbPhongBan().getSelectedItem().toString()));
	}

}
