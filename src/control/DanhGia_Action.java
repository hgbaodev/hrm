package control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JRadioButton;

import DAO.access_BANGDANHGIA;
import DTO.DANHGIA;
import DTO.SUPPORT;
import GUI.DanhGiaView;
import run.App;



public class DanhGia_Action implements ActionListener{

	private App trangchinh;
	
	public DanhGia_Action(App trangchinh) {
		this.trangchinh = trangchinh;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DanhGiaView form2 = trangchinh.getContent().getDanhGiaForm2();
		String str= e.getActionCommand();
		if(str.equals("Lưu")) {
			int index = trangchinh.getContent().getDanhGiaForm2().getObjectTable().getSelectedRow();
			if(index<0) {
				trangchinh.showMessage("Chưa chọn nhân viên");
				return;
			}
			String str2 = form2.getSelectedBangDanhGia();
			if(str2.length()<59) {
				trangchinh.showMessage("Vui lòng đánh giá đủ các tiêu chí!");
				return;
			}
			String maNhanVien = form2.getTableModel().getValueAt(index, 1).toString().split(" - ")[0];
			String maNguoiDanhGia = trangchinh.getTaiKhoanDangNhap().getUsername();
			LocalDate ngayDanhGia = SUPPORT.toLocalDate(form2.getTfNgayDanhGia().getText());
			String maDanhGia = "DG"+maNhanVien+SUPPORT.localDatetoStringDanhGia(SUPPORT.toLocalDate(form2.getTfNgayDanhGia().getText())) +maNguoiDanhGia;
			int diem = Integer.valueOf(form2.getLbDiem().getText());
			String xepLoai = "";
			if(diem>=110) {
				xepLoai = "Xuất sắc";
			}else if(diem>= 90) {
				xepLoai = "Giỏi";
			}else if(diem>=70) {
				xepLoai = "Khá";
			}else if(diem>=50) {
				xepLoai = "Trung bình";
			}else {
				xepLoai = "Điểm";
			}
			String loaiDanhGia = "";
			if(maNhanVien.equals(maNguoiDanhGia)) {
				loaiDanhGia = "Tự đánh giá";
			}else {
				loaiDanhGia = "Được đánh giá";
			}
			DANHGIA danhGia = new DANHGIA(maDanhGia, maNhanVien, "", maNguoiDanhGia, "", SUPPORT.toLocalDate(form2.getTfNgayDanhGia().getText()), diem, xepLoai, str2, "", loaiDanhGia);
			if(access_BANGDANHGIA.insertBangDanhGia(danhGia)) {
				
				
			}else {
				access_BANGDANHGIA.deleteBangDanhGia(danhGia.getMaDanhGia());
				access_BANGDANHGIA.insertBangDanhGia(danhGia);
			}
			trangchinh.getData().getDanhSachBangDanhGia().getDataFromDatabase();
			trangchinh.getContent().getDanhGiaForm().setData(trangchinh.getData().getDanhSachBangDanhGia().getObjectToRender());
			trangchinh.showMessage("Đã lưu vào danh sách đánh giá!");
		}
	}

}
