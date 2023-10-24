package DTO;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.access_CMND;
import DAO.access_NHANVIEN;
import DAO.access_PHONGBAN;
import DAO.access_TUYENDUNG;
import DAO.accsess_UNGVIEN;
import run.App;

public class CHECK {
	public static boolean checkMaNhanVienHopLe(String maNhanVien) {
		if(maNhanVien.contains(" ")) {
			return false;
		}
		return true;
	}
    public static boolean checkSoDienThoai(String sdt) {
		if(sdt.matches("[0]{1}[1-9]{1}[0-9]{7,9}")) {
			return true;
		}
		return false;
	}
	public static boolean checkEmail(String email) {
		if(email.endsWith("@gmail.com")) {
			if(email.length()>14) {
				return true;
			}
		}
		return false;
	}
	public static boolean checkHoTen(String hoTen) {
		hoTen = SUPPORT.convertHoTen(hoTen).toLowerCase();
		int size = hoTen.length();
		if(size<5) {
			return false;
		}
		String arr[] = hoTen.split(" ");
		if(arr.length<2) {
			return false;
		}
		for(int i=0;i<size;i++) {
			if(hoTen.charAt(i)<32) {
				return false;
			}
			if(hoTen.charAt(i)>=33 && hoTen.charAt(i)<=64) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkMaNhanVienTonTai(String maSo) {
		ArrayList<String> listMaSo = access_NHANVIEN.getDanhSachMaSo();
		for(String i : listMaSo) {
			if(i.equals(maSo)) {
				return true;
			}
		}
		return false;
	}
	public static boolean checkMaUngVienTonTai(String maSo) {
		ArrayList<String> listMaSo = accsess_UNGVIEN.getDanhSachMaSo();
		for(String i : listMaSo) {
			if(i.equals(maSo)) {
				return true;
			}
		}
		return false;
	}
	public static boolean checkCMNDTonTai(String cmnd) {
		ArrayList<String> listMaSo = access_CMND.getDanhSachMaSo();
		for(String i : listMaSo) {
			if(i.equals(cmnd)) {
				return true;
			}
		}
		return false;
	}
	public static boolean checkCMND(String cmnd) {
		int size = cmnd.length();
		if(size!=9) {
			return false;
		}
		for(int i=0;i<size;i++) {
			if(cmnd.charAt(i)<48 || cmnd.charAt(i)>57) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkNgaySinh(String ngaySinh) {
		LocalDate ngaySinhld = SUPPORT.toLocalDate(ngaySinh);
		
		LocalDate nowld = LocalDate.now();
		LocalDate sosanh = LocalDate.of(ngaySinhld.getYear(), nowld.getMonthValue(), nowld.getDayOfMonth());
		if(nowld.getYear()-ngaySinhld.getYear()<16 || nowld.getYear()-ngaySinhld.getYear()>65) {
			return false;
		}else if(nowld.getYear()-ngaySinhld.getYear()==16) {
			if(sosanh.compareTo(ngaySinhld)<0) {
				return false;
			}
			return true;
		}else if(nowld.getYear()-ngaySinhld.getYear()==65) {
			if(sosanh.compareTo(ngaySinhld)>=0) {
				return true;
			}
			return false;
		}else {
			return true;
		}
	}
	public static boolean checkSalary(String salary) {
		try {
			double value = Double.valueOf(salary);
			if(value<4000000)	return false;
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	public static boolean checkMaBCCTDTonTai(String maBTD) {
		String dsMaTuyenDung[] = access_TUYENDUNG.getMaTuyenDung();
		for(int i=0;i<dsMaTuyenDung.length;i++) {
			if(maBTD.equals(dsMaTuyenDung[i])) {
				return true;
			}
		}
		return false;
	}
	public static boolean checkBaoCaoTuyenDungData(JFrame app,String data[]) {
		if(data[0].equals("")) {
			JOptionPane.showMessageDialog(app, "Vui lòng nhập mã tuyển dụng!","Thông báo",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(data[2].equals("")) {
			JOptionPane.showMessageDialog(app, "Vui lòng nhập số lượng cần tuyển!","Thông báo",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(data[4].equals("")) {
			JOptionPane.showMessageDialog(app, "Vui lòng chọn yêu cầu giới tính!","Thông báo",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(data[6].equals("")) {
			JOptionPane.showMessageDialog(app, "Vui lòng nhập mức lương tối thiểu!","Thông báo",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(data[7].equals("")) {
			JOptionPane.showMessageDialog(app, "Vui lòng nhập mức lương tối đa!","Thông báo",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(checkMaBCCTDTonTai(data[0])) {
			JOptionPane.showMessageDialog(app, "Mã bảng tuyển dụng đã tồn tại trong danh sách!","Thông báo",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		// số lượng tuyển
		try {
			int soLuongTuyen = Integer.valueOf(data[2]);
			if(soLuongTuyen<1) {
				JOptionPane.showMessageDialog(app, "Số lượng tuyển dụng quá ít!","Thông báo",JOptionPane.WARNING_MESSAGE);
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(app, "Vui lòng kiểm tra lại số lượng tuyển dụng!","Thông báo",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		// tối thiểu
		try {
			double toithieu = Double.valueOf(data[6]);
			if(toithieu<4000000) {
				JOptionPane.showMessageDialog(app, "Mức lương tối thiểu phải lớn hơn hoặc bằng 4,000,000đ!","Thông báo",JOptionPane.WARNING_MESSAGE);
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(app, "Vui lòng kiểm tra lại mức lương tối thiểu!","Thông báo",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		// tối đa
		try {
			double toida = Double.valueOf(data[7]);
			if(toida<4000000) {
				JOptionPane.showMessageDialog(app, "Mức lương tối đa phải lớn hơn hoặc bằng 4,000,000đ!","Thông báo",JOptionPane.WARNING_MESSAGE);
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(app, "Vui lòng kiểm tra lại mức lương tối đa!","Thông báo",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		return true;
	}
	public static boolean checkEmployeeData( App app, String []arr) {
		if(arr[0].equals("")) {
			app.showMessage("Vui lòng nhập mã nhân viên!");
			return false;
		}
		if(arr[1].equals("")) {
			app.showMessage("Vui lòng nhập tên nhân viên!");
			return false;
		}
		if(arr[4].equals("")) {
			app.showMessage("Vui lòng nhập số điện thoại!");
			return false;
		}
		if(arr[5].equals("")) {
			app.showMessage("Vui lòng nhập email!");
			return false;
		}
		if(arr[6].equals("")) {
			app.showMessage("Vui lòng nhập số nhà cụ thể!");
			return false;
		}
		if(arr[14].equals("")) {
			app.showMessage("Vui lòng nhập số chứng minh thư!");
			return false;
		}
		if(arr[27].equals("")) {
			app.showMessage("Vui lòng nhập mức lương!");
			return false;
		}
		if(!CHECK.checkMaNhanVienHopLe(arr[0])) {
			app.showMessage("Mã nhân viên không được chứa kí tự khoảng trắng!");
			return false;
		}
		if(CHECK.checkMaNhanVienTonTai(arr[0])) {
			app.showMessage("Mã nhân viên này đã tồn tại! Vui lòng sử dụng một mã nhân viên khác!");
			return false;
		}
		if(!CHECK.checkHoTen(arr[1])) {
			app.showMessage("Vui lòng kiểm tra lại tên nhân viên!");
			return false;
		}
		if(!CHECK.checkNgaySinh(arr[3])) {
			app.showMessage("Nhân viên này không thuộc độ tuổi lao động!\nĐộ tuổi lao động từ 16 - 65!");
			return false;
		}
		if(!CHECK.checkSoDienThoai(arr[4])) {
			app.showMessage("Vui lòng kiểm tra lại số điện thoại!\n Số điện thoại có 9 - 11 chữ số!");
			return false;
		}
		if(!CHECK.checkEmail(arr[5])) {
			app.showMessage("Vui lòng kiểm tra lại email của nhân viên!\nEmail phải có dạng abcde@gmail.com!");
			return false;
		}
		if(CHECK.checkCMNDTonTai(arr[14])) {
			app.showMessage("Số chứng minh nhân dân này bị trùng với nhân viên khác!");
			return false;
		}
		if(!CHECK.checkCMND(arr[14])) {
			app.showMessage("Vui lòng kiểm tra lại số chứng minh nhân dân! \nChứng minh dân nhân có 9 chữ số!");
			return false;
		}
		if(!CHECK.checkSalary(arr[27])) {
			app.showMessage("Vui lòng kiểm tra lại mức lương! \nMức lương là các chữ số, tối thiểu 4,000,000đ!");
			return false;
		}
		return true;
	}
	public static boolean checkEmployeeDataImportExcel(String []arr) {
		if(arr[0].equals("")) {
			return false;
		}
		if(arr[1].equals("")) {
			return false;
		}
		if(arr[4].equals("")) {
			return false;
		}
		if(arr[5].equals("")) {
			return false;
		}
		if(arr[6].equals("")) {
			return false;
		}
		if(arr[14].equals("")) {
			return false;
		}
		if(arr[27].equals("")) {
			return false;
		}
		if(!CHECK.checkMaNhanVienHopLe(arr[0])) {
			return false;
		}
		if(!CHECK.checkHoTen(arr[1])) {
			return false;
		}
		if(!CHECK.checkNgaySinh(arr[3])) {
			return false;
		}
		if(!CHECK.checkSoDienThoai(arr[4])) {
			return false;
		}
		if(!CHECK.checkEmail(arr[5])) {
			return false;
		}
		if(!CHECK.checkCMND(arr[14])) {
			return false;
		}
		if(!CHECK.checkSalary(arr[27])) {
			return false;
		}
		return true;
	}
	public static boolean checkUngVienData( String []arr) {
		if(arr[1].equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa nhập mã ứng viên!");
			return false;
		}
		if(arr[2].equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa nhập tên ứng viên!");
			return false;
		}
		if(arr[5].equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa nhập số điện thoại ứng viên!");
			return false;
		}
		if(arr[6].equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa nhập email ứng viên!");
			return false;
		}
		if(arr[7].equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa nhập số chứng minh thư ứng viên!");
			return false;
		}
		if(arr[16].equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa nhập số nhà ứng viên!");
			return false;
		}
		if(arr[20].equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa nhập chuyên ngành ứng viên!");
			return false;
		}
		if(arr[21].equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa nhập mức lương deal ứng viên!");
			return false;
		}
		if(CHECK.checkMaUngVienTonTai(arr[1])) {
			JOptionPane.showMessageDialog(null, "Mã ứng viên tồn tại trong danh sách!");
			return false;
		}
		if(!CHECK.checkHoTen(arr[2])) {
			JOptionPane.showMessageDialog(null, "Tên ứng viên không hợp lệ!");
			return false;
		}
		if(!CHECK.checkSoDienThoai(arr[5])) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!");
			return false;
		}
		if(!CHECK.checkEmail(arr[6])) {
			JOptionPane.showMessageDialog(null, "Email không hợp lệ!\nEmail phải có dạng abc@gmail.com");
			return false;
		}
		
		if(!CHECK.checkCMND(arr[7])) {
			JOptionPane.showMessageDialog(null, "Số chứng minh nhân dân không hợp lệ! \n( Chứng minh dân nhân có 9 chữ số )");
			return false;
		}
		if(CHECK.checkCMNDTonTai(arr[7])) {
			JOptionPane.showMessageDialog(null, "Chứng minh nhân dân đã tồn tại!");
			return false;
		}
		if(!CHECK.checkSalary(arr[21])) {
			JOptionPane.showMessageDialog(null, "Mức lương không hợp lệ! \n( Mức lương là các chữ số! Tối thiểu 4,000,000 )");
			return false;
		}
		return true;
	}
	public static boolean checkMaPhongTonTai(String maSo) {
		ArrayList<String> list = access_PHONGBAN.getDanhSachMaSo();
		for(String i : list) {
			if(maSo.equals(i))	return true;
		}
		return false;
	}
	
	public static boolean checkDepartmentData(App app,String str[]) {
		if(str[0].equals("")) {
			app.showMessage("Chưa nhập mã phòng ban!");
			return false;
		}
		if(str[1].equals("")) {
			app.showMessage("Chưa nhập tên phòng ban!");
			return false;
		}
		if(checkMaPhongTonTai(str[0])) {
			app.showMessage("Mã phòng ban này đã tồn tại!");
			return false;
		}
		if(str[1].length()<5) {
			app.showMessage("Tên phòng ban quá ngắn!");
			return false;
		}
		
		return true;
	}
}
