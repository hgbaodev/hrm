package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import DAO.access_CHUCVU;
import DAO.access_CHUCVUCONGTY;
import DAO.access_NHANVIEN;
import DAO.access_PHONGBAN;
import DTO.CHUCVU;
import DTO.NHANVIEN;
import DTO.NHANVIENCHINHTHUC;
import DTO.NHANVIENTHUVIEC;
import DTO.PHONGBAN;
import GUI.departmentForm2;
import run.App;

public class dieuChinhNhanSuPhongBan extends MouseAdapter{
	private App app;
	public dieuChinhNhanSuPhongBan(App app) {
		this.app = app;
	}
	public void showDanhSachNhanVienPhongBan() {
		departmentForm2 temp =  app.getContent().getDepartmentForm().getDepartmentForm2();
		int index =temp.getTable().getSelectedRow();
		if(index<0) {
			return;
		}
		String maSo = app.getData().getDanhSachPhongBan().getList().get(index).getMaPhong();
		temp.setEmployeeData(access_PHONGBAN.getNhanVienCuaPhongBanData(maSo));
		temp.setTitleEmployee("Nhân viên - "+access_PHONGBAN.getTenTuMaSo(maSo));
	}
	public void thayDoiPhongBan(String phongmoi,String chucvucu) {
		
		departmentForm2 temp = app.getContent().getDepartmentForm().getDepartmentForm2();
		String maNhanVien = temp.getInfoEmployeeList().get(0).getText();
		
		String maPhongBanMoi = access_PHONGBAN.getMaSoTuTen(phongmoi);
		NHANVIEN nhanVien = app.getData().getDanhSachNhanVien().getNhanVien(maNhanVien);
		nhanVien.setMaPhong(maPhongBanMoi);
		access_NHANVIEN.thayDoiMaPhongBan(maNhanVien, maPhongBanMoi);
	}
	public boolean thayDoiChucVu(String chucvumoi) {
		departmentForm2 temp = app.getContent().getDepartmentForm().getDepartmentForm2();
		String maNhanVien  = temp.getInfoEmployeeList().get(0).getText();
		NHANVIEN nhanVien = app.getData().getDanhSachNhanVien().getNhanVien(maNhanVien);
		if(chucvumoi.equals("Trưởng phòng")) {
			System.out.println("Trưởng phòng");
			PHONGBAN phongBan = app.getData().getDanhSachPhongBan().getPhongBan(nhanVien.getMaPhong());
			if(!phongBan.getMaTruongPhong().equals("Chưa có") && !phongBan.getMaTruongPhong().equals("")) {
				int result  = app.showOption(phongBan.getTenPhong()+" đã có Trưởng phòng! Bạn có muốn thay đổi không?");
				if(result!=0) {
					app.showMessage("Không có thay đổi!");
					return false;
				}else {
					// đổi trưởng phòng cũ
					NHANVIEN truongPhongCu = app.getData().getDanhSachNhanVien().getNhanVien(phongBan.getMaTruongPhong());
					Object []thongTinChucVu = access_CHUCVUCONGTY.getChucVuCongTyTuTen("Phó phòng");
					truongPhongCu.getChucVu().setTenChucVu(thongTinChucVu[1].toString());
					truongPhongCu.getChucVu().setPhuCapChucVu(Double.valueOf(thongTinChucVu[2].toString()));
					truongPhongCu.getChucVu().setNgayNhanChuc(LocalDate.now());
					access_CHUCVU.updateChucVu(truongPhongCu.getChucVu());
					
					
				}
			}
			// set lại mã trưởng phòng cho phòng
			phongBan.setMaTruongPhong(nhanVien.getMaNhanVien());
			access_PHONGBAN.updatePhongBan(phongBan);
			app.getContent().getDepartmentForm().setDepartmentData(app.getData().getDanhSachPhongBan().getObjectToRender());
		}
		
		Object []thongTinChucVu = access_CHUCVUCONGTY.getChucVuCongTyTuTen(chucvumoi);
		
		nhanVien.getChucVu().setTenChucVu(thongTinChucVu[1].toString());
		nhanVien.getChucVu().setPhuCapChucVu(Double.valueOf(thongTinChucVu[2].toString()));
		nhanVien.getChucVu().setNgayNhanChuc(LocalDate.now());
		access_CHUCVU.updateChucVu(nhanVien.getChucVu());
		return true;
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("Điều chỉnh nhân sự");
		departmentForm2 temp = app.getContent().getDepartmentForm().getDepartmentForm2();
		String phongcu =temp.getInfoEmployeeList().get(6).getText();
		String phongmoi = temp.getCbbPhongBan().getSelectedItem().toString();
		String chucvucu = temp.getInfoEmployeeList().get(7).getText();
		String chucvumoi = temp.getCbbChucVu().getSelectedItem().toString();
		if(!phongcu.equalsIgnoreCase(phongmoi) && !chucvucu.equalsIgnoreCase(chucvumoi)) {
			// thay đổi cả hai
			if(chucvucu.equals("Trưởng phòng")) {
				PHONGBAN phongBanCu = app.getData().getDanhSachPhongBan().getPhongBan(access_PHONGBAN.getMaSoTuTen(phongcu));
				phongBanCu.setMaTruongPhong("Chưa có");
				access_PHONGBAN.updatePhongBan(phongBanCu);
			}
			if(chucvumoi.equals("Trưởng phòng")) {
				thayDoiChucVu("Phó phòng");
				chucvumoi = "Phó phòng";
			}else {
				thayDoiChucVu(chucvumoi);
			}
			thayDoiPhongBan(phongmoi,chucvucu);
			temp.changeEditType(0);
			temp.getInfoEmployeeList().get(6).setText(phongmoi);
			showDanhSachNhanVienPhongBan();
			app.getData().getDanhSachPhongBan().getDataFromDatabase();
			app.getContent().getDepartmentForm().setDepartmentData(app.getData().getDanhSachPhongBan().getObjectToRender());
			app.renderEmployeeTable();
			temp.getInfoEmployeeList().get(7).setText(chucvumoi);
			
			app.showMessage("Đã chuyển công tác nhân viên này sang phòng "+phongmoi+" với chức vụ "+chucvumoi+"!");
		}else if(!phongcu.equalsIgnoreCase(phongmoi) && chucvucu.equalsIgnoreCase(chucvumoi)){
			// thay đổi phòng ban
			if(chucvucu.equals("Trưởng phòng")) {
				thayDoiChucVu("Phó phòng");
				chucvumoi = "Phó phòng";
				PHONGBAN phongBanCu = app.getData().getDanhSachPhongBan().getPhongBan(access_PHONGBAN.getMaSoTuTen(phongcu));
				phongBanCu.setMaTruongPhong("Chưa có");
				access_PHONGBAN.updatePhongBan(phongBanCu);
			}
			thayDoiPhongBan(phongmoi,chucvucu);
			temp.changeEditType(0);
			temp.getInfoEmployeeList().get(6).setText(phongmoi);
			showDanhSachNhanVienPhongBan();
			app.getData().getDanhSachPhongBan().getDataFromDatabase();
			app.getContent().getDepartmentForm().setDepartmentData(app.getData().getDanhSachPhongBan().getObjectToRender());
			app.renderEmployeeTable();
			app.showMessage("Đã chuyển công tác nhân viên này sang "+phongmoi);
		}else if(phongcu.equalsIgnoreCase(phongmoi) && !chucvucu.equalsIgnoreCase(chucvumoi)){
			// thay đổi chức vụ
			if(thayDoiChucVu(chucvumoi)) {
				temp.changeEditType(0);
				temp.getInfoEmployeeList().get(7).setText(chucvumoi);
				showDanhSachNhanVienPhongBan();
				app.renderEmployeeTable();
				app.showMessage("Đã thay đổi chức vụ nhân viên này thành "+chucvumoi);
			}
			// render
			
		}else {
			// không thay đổi
			temp.changeEditType(0);
			app.showMessage("Không có sự thay đổi!");
		}
		
		// render lại dữ liệu
		
	}
}
