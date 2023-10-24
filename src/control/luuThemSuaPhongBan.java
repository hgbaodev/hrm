package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import DAO.access_NHANVIEN;
import DAO.access_PHONGBAN;
import DAO.access_THONGKE;
import DTO.CHECK;
import DTO.PHONGBAN;
import DTO.SUPPORT;
import GUI.departmentForm2;
import GUI.Department_Add.ACTION_TYPE;
import run.App;

public class luuThemSuaPhongBan implements ActionListener{
	private App app;
	public luuThemSuaPhongBan(App app) {
		this.app = app;
	}
	public void actionPerformed(ActionEvent e) {
		departmentForm2 temp = app.getContent().getDepartmentForm().getDepartmentForm2();
		String data[] = temp.getDepartmentAdd().getDataThemPhongBan();
		if(temp.getDepartmentAdd().getActionType()==ACTION_TYPE.ADD) {
			// thêm phòng ban
			if(CHECK.checkDepartmentData(app, data)) {
				PHONGBAN phongBan = new PHONGBAN(data[0], data[1],SUPPORT.toLocalDate(data[2]),"");
				access_PHONGBAN.insertPhongBan(phongBan);
				app.getData().getDanhSachPhongBan().getList().add(phongBan);
			}else {
				return;
			}
		}else {
			// sửa phòng ban
			System.out.println("Sửa phòng ban");
			int index = temp.getTable().getSelectedRow();
			if(index<0) {
				app.showMessage("Phòng ban này vừa bị xóa khỏi danh sách!");
				return;
			}
			String maSoPhongChuaSua =  app.getData().getDanhSachPhongBan().getList().get(index).getMaPhong();
			if(!maSoPhongChuaSua.equalsIgnoreCase(data[0])) {
				if(!CHECK.checkDepartmentData(app, data)) {
					return;
				}
				// có chỉnh sửa mã phòng
				int result = app.showOption("Chỉnh sửa mã phòng có thể dẫn đến các thay đổi khác! Bạn có muốn tiếp tục không?");
				if(result==0) {
					// yes
					new Thread(new Runnable() {
						public void run() {
							temp.getDepartmentAdd().setVisible(false);
						}
					}).start();
					// tạo phòng mới
					PHONGBAN phongBan = new PHONGBAN(data[0], data[1],SUPPORT.toLocalDate(data[2]),""); // tạo phòng ban mới
					access_PHONGBAN.insertPhongBan(phongBan);
					access_THONGKE.insertTHONGKE(phongBan.getMaPhong());
					
					// thay đổi mã phòng nhân viên
					access_NHANVIEN.thayDoiMaPhongBanAll(maSoPhongChuaSua, phongBan.getMaPhong());
					// xóa phòng cũ 
					app.getData().getDanhSachPhongBan().getList().remove(index);
					// thêm phòng ban mới
					app.getData().getDanhSachPhongBan().getList().add(phongBan);
					// sửa mã phòng nhân viên
					access_PHONGBAN.deletePhongBan(maSoPhongChuaSua);
					// lấy lại dữ liệu nhân viên
					app.getData().getDanhSachNhanVien().getDataFromDatabase();
				}else {
					return;
				}
			}else {
				// không sửa mã phòng
				if(CHECK.checkDepartmentData(app, new String[] {"---",data[1],data[2]})) {
					PHONGBAN phongBanSua = app.getData().getDanhSachPhongBan().getList().get(index);
					phongBanSua.setTenPhong(data[1]);
					phongBanSua.setNgayThanhLap(SUPPORT.toLocalDate(data[2]));
					access_PHONGBAN.updatePhongBan(phongBanSua);
				}else {
					return;
				}
			}
		}
		app.renderEmployeeTable();
		app.getContent().getDepartmentForm().setDepartmentData(app.getData().getDanhSachPhongBan().getObjectToRender());
		temp.getDepartmentAdd().setVisible(false);
		app.showMessage("Cập nhật thành công!");
	}

}
