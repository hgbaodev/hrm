package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.access_NHOMQUYEN;
import DAO.access_PHONGBAN;
import DTO.PHONGBAN;
import GUI.AccountForm;
import GUI.departmentForm2;
import run.App;

public class xoaNhomQuyen extends MouseAdapter{
	private App app;
	public xoaNhomQuyen(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		AccountForm temp = app.getContent().getAccountForm();
		int index = temp.getTableNhomQuyen().getSelectedRow();
		if(index<0) {
			app.showMessage("Vui lòng chọn nhóm quyền bạn muốn xóa!");
			return;
		}
		int result = app.showOption("Bạn có chắc chắn muốn xóa nhóm quyền này không?");
		// xóa phòng ban
		if(result==0) {
			// xóa khỏi database
			String maNhomQuyen = temp.getModelNhomQuyen().getValueAt(index, 1).toString().split("-")[0].trim();
			if(access_NHOMQUYEN.deleteNHOMQUYEN(maNhomQuyen)) {
				app.showMessage("Đã xóa thành công!");
				
				
				app.getData().getDanhSachNhomQuyen().getDataFormDatabase();
				temp.setDataNhomQuyen(app.getData().getDanhSachNhomQuyen().getObjectToRender());
				temp.getTitleNhomQuyen().setText("");
				temp.setModelCbbQuyen(app.getData().getDanhSachNhomQuyen().getMaNhomQuyenForCBB());
			}else {
				app.showMessage("Nhóm quyền đang được sử dụng, không thể xóa!");
			}
		}
	}
}
