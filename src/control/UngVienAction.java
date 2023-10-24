package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import BUS.DANHSACHUNGVIEN;
import DAO.access_TUYENDUNG;
import DAO.accsess_UNGVIEN;
import DTO.BAOCAOTUYENDUNG;
import DTO.CHECK;
import DTO.CMND;
import DTO.DIACHI;
import DTO.SUPPORT;
import DTO.TRINHDO;
import DTO.UNGVIEN;
import GUI.TuyenDungView;
import GUI.TuyenDungView_Them;
import GUI.UngVienView;
import GUI.UngVienView_Them;
import run.App;

public class UngVienAction implements ActionListener{
	private App app;
	public UngVienAction(App app) {
		this.app= app;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str=e.getActionCommand();
		UngVienView temp = app.getContent().getRecruitmentForm().getUngVienView();
		if(str.equals("Thêm")) {
			temp.getUvv_t().setDataCbbMaTuyenDung(access_TUYENDUNG.getMaTuyenDung());
			temp.getUvv_t().setVisible(true);
		}
		else if(str.equals("Đóng")) {
			temp.getUvv_t().setVisible(false);
			temp.getUvv_t().reset(); // reset lại dữ liệu thêm
		}
		else if(str.equals("Lưu")) {
			String ungVienData[] = temp.getUvv_t().getDataToAdd();
			if(!CHECK.checkUngVienData(ungVienData)){
				return;
			}else {
				double mucLuongDeal = Double.valueOf(ungVienData[21]);
				BAOCAOTUYENDUNG bctd = app.getData().getDanhsachbaocaotuyendung().getBaoCaoTuyenDung(ungVienData[0]);
				if(mucLuongDeal<bctd.getMucLuongToiThieu() ){
					JOptionPane.showMessageDialog(temp.getUvv_t(), "Mức lương thỏa thuận của ứng viên nhỏ hơn mức lương tối thiểu của đợt tuyển dụng này!");
					return;
				}else if(mucLuongDeal>bctd.getMucLuongToiDa()) {
					JOptionPane.showMessageDialog(temp.getUvv_t(), "Mức lương thỏa thuận của ứng viên lớn hơn mức lương tối đa của đợt tuyển dụng này!");
					return;
				}
				CMND cmnd = new CMND(ungVienData[7], ungVienData[9], SUPPORT.toLocalDate(ungVienData[8]));
				DIACHI dc = new DIACHI("TDUV"+ungVienData[16], ungVienData[15], ungVienData[14], ungVienData[13], ungVienData[12]);
				TRINHDO td = new TRINHDO("TDUV"+ungVienData[1], ungVienData[18], ungVienData[19], ungVienData[20]);
				UNGVIEN uv= new UNGVIEN(cmnd , ungVienData[2], ungVienData[3], SUPPORT.toLocalDate(ungVienData[4]), dc, ungVienData[5], ungVienData[10], ungVienData[11], ungVienData[17], ungVienData[6], ungVienData[0], ungVienData[1], mucLuongDeal, td, access_TUYENDUNG.getChucVuTuyenDung(ungVienData[0]), "Chưa tuyển");
				
				accsess_UNGVIEN.insertUngVien(uv);
				// đọc lại giá trị danh sách ứng viên
				app.getData().getDanhsachungvien().getList().add(uv);
				// đọc lại giá trị của bảng tuyển dụng
				app.getData().getDanhsachbaocaotuyendung().getDataFromDatabase();
				app.getContent().getRecruitmentForm().getTuyenDungView().setData(app.getData().getDanhsachbaocaotuyendung().getObject());
				String selectedItem = (String) temp.getComboBox_MaTuyenDung().getSelectedItem();
				
				if(selectedItem.equals("Mã tuyển dụng")) {
					temp.setData(app.getData().getDanhsachungvien().getObject());
				}else {
					DANHSACHUNGVIEN dsuv= new DANHSACHUNGVIEN(app.getData().getDanhsachungvien().getList(selectedItem));
					temp.setData(dsuv.getObject());
				}
				temp.getUvv_t().setVisible(false);
				temp.getUvv_t().reset(); // reset lại dữ liệu thêm
				return;
			}	
		}else if(str.equals("Xóa")){
			JTable table;
			int row =temp.getObjectTable().getSelectedRow();
		try {
			int a=JOptionPane.showConfirmDialog(app, "Bạn có muốn xóa ứng viên "+ temp.getObjectTable().getValueAt(row, 1).toString()+ " không?") ;
			if(a==0) {
				if(row==-1)
					return;
				else {
					// Cập nhật vào database
					table=temp.getObjectTable();
					for(UNGVIEN i: app.getData().getDanhsachungvien().getList()) {
						if(i.getMaUngVien().equals(table.getValueAt(row, 1).toString().split(" - ")[0])) {
							if(i.getTrangThai().equalsIgnoreCase("Đã tuyển")) {
								app.showMessage("Ứng viên đã tuyển, không thể xóa!");
								return;
							}else {
								accsess_UNGVIEN.deleteUngVien("TDUV"+i.getMaUngVien(),i.getCmnd().getSoCmnd(),i.getMaUngVien());
								// đổi màu chữ xóa
								temp.getButton_UngVien_Xoa().setForeground(new Color(128,128,128));
								app.getData().getDanhsachungvien().getDataFromDatabase();
								temp.setData(app.getData().getDanhsachungvien().getObject());
								return;
							}
							
						}
					} 
					
				}
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(app, "Vui lòng chọn ứng viên cần xóa");
		}
		}
	}
}
