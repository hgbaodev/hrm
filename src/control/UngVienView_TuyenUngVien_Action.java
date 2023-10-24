package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import DAO.access_BANGDANHGIA;
import DAO.access_CHUCVUCONGTY;
import DAO.access_NHANVIEN;
import DAO.access_TUYENDUNG;
import DAO.accsess_UNGVIEN;
import DTO.BAOCAOTUYENDUNG;
import DTO.CHECK;
import DTO.CHUCVU;
import DTO.CMND;
import DTO.DIACHI;
import DTO.HOPDONGLAODONG;
import DTO.NHANVIEN;
import DTO.NHANVIENCHINHTHUC;
import DTO.NHANVIENTHUVIEC;
import DTO.SUPPORT;
import DTO.TAIKHOAN;
import DTO.TRINHDO;
import DTO.UNGVIEN;
import GUI.UngVIenView_TuyenUngVien;
import GUI.UngVienView;
import run.App;

public class UngVienView_TuyenUngVien_Action implements ActionListener{
	private App trangchinh;
	
	public UngVienView_TuyenUngVien_Action(App trangchinh) {
		this.trangchinh = trangchinh;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str= e.getActionCommand();
		UngVienView temp = trangchinh.getContent().getRecruitmentForm().getUngVienView();
		
		if(str.equals("Lưu")) {
			String dataBoSung[] = temp.getFormTuyenUngVien().getDataBoSung();
			if(dataBoSung[1].equals("")) {
				temp.getFormTuyenUngVien().showMessage("Bạn chưa nhập mã nhân viên cho ứng viên này!");
				return;
			}
			if(CHECK.checkMaNhanVienTonTai(dataBoSung[1])) {
				temp.getFormTuyenUngVien().showMessage("Mã nhân viên "+dataBoSung[1]+" đã tồn tại trong danh sách nhân viên!");
				return;
			}
			String dataUngVien[] = temp.getFormTuyenUngVien().getData();
			for(int i=0;i<dataUngVien.length;i++) {
				System.out.println(i+" /  "+dataUngVien[i]);
			}
			String maNhanVien = dataBoSung[1];
			int thoiHanHopDong = Integer.valueOf(dataBoSung[4].split(" ")[0]);	
			LocalDate ngayBatdau = SUPPORT.toLocalDate(dataBoSung[3]);
			LocalDate ngayKetThuc = LocalDate.of(ngayBatdau.getYear()+thoiHanHopDong, ngayBatdau.getMonthValue(), ngayBatdau.getDayOfMonth());
			HOPDONGLAODONG hd = new HOPDONGLAODONG("HD"+maNhanVien, ngayBatdau, ngayKetThuc, dataBoSung[4], SUPPORT.changeStringSalaryToDouble(dataUngVien[19]));
			TAIKHOAN tk = new TAIKHOAN(maNhanVien, maNhanVien, null, "none_user.jpg");
			DIACHI dc = new DIACHI(dataUngVien[7], dataUngVien[8], dataUngVien[9], dataUngVien[10], dataUngVien[11]);
			CMND cmnd = new CMND(dataUngVien[14], dataUngVien[16], SUPPORT.toLocalDate(dataUngVien[15]));
			TRINHDO td = new TRINHDO("TD"+maNhanVien, dataUngVien[4], dataUngVien[5], dataUngVien[6]);
			
			Object chucVuCongTy[] = access_CHUCVUCONGTY.getChucVuCongTyTuTen(dataUngVien[18]);
			CHUCVU cv =new CHUCVU("CV"+maNhanVien, chucVuCongTy[1].toString(), Double.valueOf(chucVuCongTy[2].toString()), LocalDate.now());
			NHANVIEN nhanVien = null;
			String maPhong = trangchinh.getData().getDanhSachPhongBan().getMaPhong(dataBoSung[2]);
			if(dataBoSung[0].equalsIgnoreCase("Nhân viên chính thức")) {
				// NHÂN VIÊN CHÍNH THỨC
				nhanVien = new NHANVIENCHINHTHUC(hd, maNhanVien,tk , dataUngVien[0], dataUngVien[1], SUPPORT.toLocalDate(dataUngVien[2]), dc, dataUngVien[3], cmnd, dataUngVien[12], dataUngVien[17], dataUngVien[13], dataUngVien[20], maPhong, td, cv);
			}else {
				// NHÂN VIÊN THỬ VIỆC
				LocalDate ngaybd = SUPPORT.toLocalDate(dataBoSung[5]);
				LocalDate ngaykt = SUPPORT.toLocalDate(dataBoSung[6]);
				nhanVien = new NHANVIENTHUVIEC(maNhanVien, dataUngVien[0], dataUngVien[1], SUPPORT.toLocalDate(dataUngVien[2]), dc,dataUngVien[3], cmnd, dataUngVien[12], dataUngVien[17], dataUngVien[13], dataUngVien[20], maPhong, td, cv, tk, ngaybd, ngaykt, SUPPORT.changeStringSalaryToDouble(dataUngVien[19])*0.8);
			}
			// lưu nhân viên
			access_NHANVIEN.insertNHANVIENfromUNGVIEN(nhanVien);
			accsess_UNGVIEN.updateTrangThai(dataUngVien[21], "Đã tuyển");
			temp.getFormTuyenUngVien().setVisible(false);
			trangchinh.getData().getDanhsachungvien().getDataFromDatabase();
			temp.setData(trangchinh.getData().getDanhsachungvien().getObject());
			trangchinh.showMessage("Đã thêm ứng viên thành công!");
			trangchinh.getData().getDanhSachNhanVien().getDataFromDatabase();
			trangchinh.getContent().getEmployeeForm().getEmployeeForm1().reset();
			trangchinh.getContent().getEmployeeForm().getEmployeeForm1().setData(trangchinh.getData().getDanhSachNhanVien().getObjectToRender());
		}
		else if(str.equals("Đóng")) {
			temp.getFormTuyenUngVien().setVisible(false);
		}
	}

}

