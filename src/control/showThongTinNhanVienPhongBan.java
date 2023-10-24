package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.access_NHANVIEN;
import DAO.access_PHONGBAN;
import DTO.NHANVIEN;
import GUI.departmentForm2;
import run.App;

public class showThongTinNhanVienPhongBan extends MouseAdapter{
	private App app;
	public showThongTinNhanVienPhongBan(App app) {
		this.app = app;
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("test");
		departmentForm2 temp = app.getContent().getDepartmentForm().getDepartmentForm2();
		int index = temp.getTableEmployee().getSelectedRow();
		String maSo = (String)temp.getModelEmployee().getValueAt(index, 1);
		String arr[] = maSo.split("-");
		maSo = arr[0].trim();
		System.out.println(maSo);
		NHANVIEN x = access_NHANVIEN.getNhanVien(maSo);
		temp.setImgEmployee(x.getTaiKhoan().getAvatarImg());
		temp.setInfoEmployeeData(x.getDataToRenderDepartmentDetailInfoEmployee());
		temp.changeEditType(0);
	}
}
