package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import DAO.access_NHANVIEN;
import DAO.access_NHOMQUYEN;
import DAO.access_PHONGBAN;
import DTO.CHECK;
import DTO.PHONGBAN;
import DTO.SUPPORT;
import GUI.AccountForm;
import GUI.departmentForm2;
import GUI.Department_Add.ACTION_TYPE;
import run.App;

public class luuThemNhomQuyen implements ActionListener{
	private App app;
	public luuThemNhomQuyen(App app) {
		this.app = app;
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Lưu thêm nhóm quyền");
		AccountForm temp = app.getContent().getAccountForm();
		String maNhomQuyen = temp.getTfMaNhomQuyen().getText().trim();
		String tenNhomQuyen = temp.getTfTenNhomQuyen().getText().trim();
		if(maNhomQuyen.equals("")) {
			app.showMessage("Vui lòng nhập mã nhóm quyền!");
			return;
		}else if(tenNhomQuyen.equals("")) {
			app.showMessage("Vui lòng nhập tên nhóm quyền!");
			return;
		}
		
		if(access_NHOMQUYEN.insertNHOMQUYEN(maNhomQuyen, tenNhomQuyen)) {
			app.showMessage("Thêm nhóm quyền thành công!");
			app.getData().getDanhSachNhomQuyen().getDataFormDatabase();
			temp.setDataNhomQuyen(app.getData().getDanhSachNhomQuyen().getObjectToRender());
			temp.setModelCbbQuyen(app.getData().getDanhSachNhomQuyen().getMaNhomQuyenForCBB());
			temp.showFrame(0);
		}else {
			app.showMessage("Vui lòng kiểm tra lại thông tin!");
		}
	}

}
