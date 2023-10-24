package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.access_NHANVIEN;
import DAO.access_PHONGBAN;
import DTO.CHECK;
import DTO.CMND;
import DTO.DIACHI;
import DTO.NHANVIEN;
import DTO.PHONGBAN;
import DTO.SUPPORT;
import DTO.TRINHDO;
import run.App;

public class suaNhanVien extends MouseAdapter{
	private App app;
	public suaNhanVien(App app) {
		this.app = app;
	}
	public boolean checkDuLieu() {
		// check dữ liệu
		String str[] = app.getContent().getEmployeeForm().getEmployeeForm3().getCart1().getDataFromForm();
		if(str[1].equals("")) {
			app.showMessage("Chưa nhập tên nhân viên");
			return false;
		}
		if(str[4].equals("")) {
			app.showMessage("Chưa nhập số điện thoại!");
			return false;
		}
		if(str[5].equals("")) {
			app.showMessage("Chưa nhập email!");
			return false;
		}
		if(str[6].equals("")) {
			app.showMessage("Chưa nhập số nhà!");
			return false;
		}
		if(str[27].equals("")) {
			app.showMessage("Chưa nhập mức lương!");
			return false;
		}
		if(!CHECK.checkHoTen(str[1])) {
			app.showMessage("Tên nhân viên không hợp lệ!");
			return false;
		}
		if(!CHECK.checkSoDienThoai(str[4])) {
			app.showMessage("Số điện thoại không hợp lệ!");
			return false;
		}
		if(!CHECK.checkEmail(str[5])) {
			app.showMessage("Email không hợp lệ!");
			return false;
		}
		if(!CHECK.checkSalary(str[27])) {
			app.showMessage("Mức lương không hợp lệ! \n( Mức lương là các chữ số! Tối thiểu 4,000,000 )");
			return false;
		}
		app.getContent().getEmployeeForm().getEmployeeForm3().getCart1().loadImageIntoProject();
		return true;
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("Sửa nhân viên");
		
		String maNhanVien =   app.getContent().getEmployeeForm().getEmployeeForm3().getCart1().getMaNhanVienSua();
		NHANVIEN x = app.getData().getDanhSachNhanVien().getNhanVien(maNhanVien);
		if(!checkDuLieu()) {
			return;
		}
		String str[] = app.getContent().getEmployeeForm().getEmployeeForm3().getCart1().getDataFromForm();
		
		
		
		
		if(str[14].equals(x.getCmnd().getSoCmnd()) && str[0].equals(maNhanVien)) {
			// không sửa số cmnd và mã nhân viên
			x.setHoTen(str[1]);
			x.setGioiTinh(str[2]);
			x.setNgaySinh(SUPPORT.toLocalDate(str[3]));
			x.setSdt(str[4]);
			x.setEmail(str[5]);
			x.setDiaChi(new DIACHI(str[6],str[7],str[8],str[9],str[10]));
			x.setTrinhDo(new TRINHDO(x.getTrinhDo().getMaTrinhDo(),str[11],str[12],str[13]));
			x.setCmnd(new CMND(x.getCmnd().getSoCmnd(),str[16],SUPPORT.toLocalDate(str[15])));
			x.setDanToc(str[17]);
			x.setTonGiao(str[18]);
			x.setTinhTrangHonNhan(str[19]);
			x.getTaiKhoan().setAvatarImg(str[28]);
			access_NHANVIEN.updateNHANVIEN(x);
			
		}
		app.renderEmployeeTable();
		app.getContent().getEmployeeForm().showFrame(0);
		app.getContent().getEmployeeForm().getEmployeeForm1().getOptionPanel().setVisible(false);
		app.showMessage("Đã sửa thành công!");
	}
}
