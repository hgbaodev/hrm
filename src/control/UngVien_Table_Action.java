package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import DTO.BAOCAOTUYENDUNG;
import DTO.FORMAT;
import DTO.SUPPORT;
import DTO.UNGVIEN;
import GUI.UngVienView;
import run.App;

public class UngVien_Table_Action extends MouseAdapter{
	private App trangchinh;
	public UngVien_Table_Action(App trangchinh) {
		this.trangchinh = trangchinh;
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		UngVienView temp = trangchinh.getContent().getRecruitmentForm().getUngVienView();
		int row= temp.getObjectTable().rowAtPoint(e.getPoint());
		
		// data tuyển dụng
		String maTuyenDung = temp.getObjectTable().getValueAt(row, 0).toString().trim();
		BAOCAOTUYENDUNG tuyenDung = trangchinh.getData().getDanhsachbaocaotuyendung().getBaoCaoTuyenDung(maTuyenDung);
		String dataTuyenDung[] = new String[] {
				tuyenDung.getChucVu(),tuyenDung.getGioiTinh(),tuyenDung.getDoTuoi(),SUPPORT.LocalDateToString(tuyenDung.getHanNopHoSo()),
				tuyenDung.getSoLuongNopHoSo()+"",tuyenDung.getSoLuongDaTuyen()+"",SUPPORT.changeSalaryToFormatString(tuyenDung.getMucLuongToiThieu()),SUPPORT.changeSalaryToFormatString(tuyenDung.getMucLuongToiDa())
		};
    	temp.setDataInfotuyenDung(dataTuyenDung);
    	// data ứng viên
		String maUngVien = temp.getObjectTable().getValueAt(row, 1).toString().split(" - ")[0];
		UNGVIEN ungVien = trangchinh.getData().getDanhsachungvien().getUngVien(maUngVien);
		String data[] = new String[] {
				ungVien.getHoTen(),ungVien.getGioiTinh(),SUPPORT.LocalDateToString(ungVien.getNgaySinh()),ungVien.getSdt(),ungVien.getEmail(),
				ungVien.getDiaChi().getSoNha(),ungVien.getDiaChi().getDuong(),ungVien.getDiaChi().getPhuongXa(),ungVien.getDiaChi().getQuanHuyen(),ungVien.getDiaChi().getTinhThanhPho(),
				ungVien.getCmnd().getSoCmnd(),ungVien.getTrinhDo().getTrinhDoChuyenMon()+" - "+ungVien.getTrinhDo().getChuyenNganh(),ungVien.getDanToc(),ungVien.getTonGiao(),ungVien.getTinhTrangHonNhan(),
		};
		temp.setDataInfoUngVien(data);
    	//đổi màu chữ "Xóa"
    	temp.getButton_UngVien_Xoa().setForeground(Color.black);
	}
	
}
