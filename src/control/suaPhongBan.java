package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.PHONGBAN;
import DTO.SUPPORT;
import GUI.departmentForm2;
import GUI.Department_Add.ACTION_TYPE;
import run.App;

public class suaPhongBan implements ActionListener{
	private App app;
	public suaPhongBan(App app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Sua phong ban");
		departmentForm2 temp = app.getContent().getDepartmentForm().getDepartmentForm2();
		int index = temp.getTable().getSelectedRow();
		System.out.println(index);
		if(index<0) {
			app.showMessage("Hãy chọn phòng ban bạn muốn sửa");
			return;
		}
		PHONGBAN x = app.getData().getDanhSachPhongBan().getList().get(index);
		temp.getDepartmentAdd().setDataToEdit(new String[] {x.getMaPhong(),x.getTenPhong(),SUPPORT.LocalDateToString(x.getNgayThanhLap())});
		temp.getDepartmentAdd().setType(ACTION_TYPE.EDIT);
		temp.getDepartmentAdd().showOn();
		
	}
}
