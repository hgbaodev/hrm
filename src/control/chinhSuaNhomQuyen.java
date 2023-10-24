package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import DAO.access_NHOMQUYEN;
import DAO.access_PHONGBAN;
import DTO.PHONGBAN;
import GUI.AccountForm;
import GUI.departmentForm2;
import run.App;

public class chinhSuaNhomQuyen extends MouseAdapter{
	private App app;
	public chinhSuaNhomQuyen(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		AccountForm temp = app.getContent().getAccountForm();
		if(temp.getTitleNhomQuyen().getText().equals("")) {
			app.showMessage("Vui lòng chọn nhóm quyền!");
		}
		String maNhomQuyen = temp.getTitleNhomQuyen().getText().split(" - ")[0];
		access_NHOMQUYEN.deleteCHITIETNHOMQUYEN(maNhomQuyen);
		boolean mang[] = temp.getMangChucNang();
		for(int i=0;i<mang.length;i++) {
			if(mang[i]) {
				access_NHOMQUYEN.insertCHITIETNHOMQUYEN(maNhomQuyen, i+1+"");
			}
		}
		app.getData().getDanhSachNhomQuyen().getDataFormDatabase();
		app.showMessage("Đã phân quyền thành công!");
	}
}
