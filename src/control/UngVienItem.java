package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import BUS.DANHSACHUNGVIEN;
import DTO.BAOCAOTUYENDUNG;
import DTO.FORMAT;
import DTO.SUPPORT;
import DTO.UNGVIEN;
import GUI.UngVienView;
import run.App;

public class UngVienItem implements ActionListener{
	private App trangchinh;
	
	public UngVienItem(App trangchinh) {
		this.trangchinh = trangchinh;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// Set lại giá trị của InFo_TuyenDung JPanel trong UngVienView khi thay đổi giá trị của ô JcomboBox
		UngVienView temp = trangchinh.getContent().getRecruitmentForm().getUngVienView();
		String maTuyenDung= temp.getComboBox_MaTuyenDung().getSelectedItem().toString();
		
		if(maTuyenDung.equals("Mã tuyển dụng")) {
			String dataTuyenDung[] = {"","","","","","","",""};
	    	temp.setDataInfotuyenDung(dataTuyenDung);
			temp.setData(trangchinh.getData().getDanhsachungvien().getObject());
			return;
		}
		else {
			BAOCAOTUYENDUNG tuyenDung = trangchinh.getData().getDanhsachbaocaotuyendung().getBaoCaoTuyenDung(maTuyenDung);
			String dataTuyenDung[] = new String[] {
					tuyenDung.getChucVu(),tuyenDung.getGioiTinh(),tuyenDung.getDoTuoi(),SUPPORT.LocalDateToString(tuyenDung.getHanNopHoSo()),
					tuyenDung.getSoLuongNopHoSo()+"",tuyenDung.getSoLuongDaTuyen()+"",SUPPORT.changeSalaryToFormatString(tuyenDung.getMucLuongToiThieu()),SUPPORT.changeSalaryToFormatString(tuyenDung.getMucLuongToiDa())
			};
	    	temp.setDataInfotuyenDung(dataTuyenDung);
					
//					set lại bảng giá trị 
			DANHSACHUNGVIEN dsuv= new DANHSACHUNGVIEN();
			for(UNGVIEN j: trangchinh.getData().getDanhsachungvien().getList()) {
				if(j.getMaTuyenDung().equals(tuyenDung.getMaTuyenDung())) {
					dsuv.getList().add(j);
				}
			}
			temp.setData(dsuv.getObject());
			return;
//					break;
			}
		}

}
