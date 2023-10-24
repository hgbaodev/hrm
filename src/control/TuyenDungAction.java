package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import BUS.DANHSACHBAOCAOTUYENDUNG;
import DAO.access_TUYENDUNG;
import DTO.BAOCAOTUYENDUNG;
import DTO.CHECK;
import DTO.SUPPORT;
import GUI.TuyenDungView;
import GUI.TuyenDungView_Them;
//import model.ThreadOne;
import run.App;

public class TuyenDungAction implements ActionListener{
	private App trangchinh;
//	private ThreadOne a;
	public TuyenDungAction(App trangchinh) {
		this.trangchinh= trangchinh;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		TuyenDungView temp2 = trangchinh.getContent().getRecruitmentForm().getTuyenDungView();
		TuyenDungView_Them temp = trangchinh.getContent().getRecruitmentForm().getTuyenDungView().getTuyenDungView_Them();
		String str=e.getActionCommand();
		if(str.equals("Thêm")) {
			temp.setVisible(true);
		}
		else if(str.equals("Đóng")) {
			// ẩn form thêm bảng tuyển dụng
			temp.setVisible(false);
			// reset dữ liệu
			temp.getTextField_MaTuyenDung().setText("");
			temp.getTextField_MucLuongToiThieu().setText("");
			temp.getTextField_MucLuongToiDa().setText("");
			temp.getTextField_SoLuongTuyen().setText("");			
		}
		else if(str.equals("Lưu")) {
			String dataBCTD[] = temp.getDataToAdd();
			if(!CHECK.checkBaoCaoTuyenDungData((JFrame)temp,dataBCTD)) {
				return;
			}
			BAOCAOTUYENDUNG bctd= new BAOCAOTUYENDUNG();
			bctd.setMaTuyenDung(dataBCTD[0]);
			bctd.setHocVan(dataBCTD[3]);
			bctd.setGioiTinh(dataBCTD[4]);
			bctd.setDoTuoi(dataBCTD[5]);
			bctd.setSoLuongCanTuyen(Integer.valueOf(dataBCTD[2]));
			bctd.setHanNopHoSo(SUPPORT.toLocalDate(dataBCTD[8]));
			bctd.setMucLuongToiThieu(Double.parseDouble(dataBCTD[6]));
			bctd.setMucLuongToiDa(Double.parseDouble(dataBCTD[7]));
			bctd.setChucVu(dataBCTD[1]);
			
			trangchinh.getData().getDanhsachbaocaotuyendung().getList().add(bctd);
			temp2.setData(trangchinh.getData().getDanhsachbaocaotuyendung().getObject());
			trangchinh.getContent().getRecruitmentForm().getUngVienView().getComboBox_MaTuyenDung().addItem(bctd.getMaTuyenDung());
			access_TUYENDUNG.insertBaoCaoTuyenDung(bctd);
			temp.setVisible(false);
			temp.getTextField_MaTuyenDung().setText("");
			temp.getTextField_MucLuongToiThieu().setText("");
			temp.getTextField_MucLuongToiDa().setText("");
			temp.getTextField_SoLuongTuyen().setText("");			
			trangchinh.showMessage("Đã thêm thành công báo cáo tuyển dụng "+bctd.getMaTuyenDung()+"!");
		}
		else if(str.equals("Tìm kiếm")) {
			DANHSACHBAOCAOTUYENDUNG find= new DANHSACHBAOCAOTUYENDUNG();
			
			String a=temp2.getTuyenDung_Find().getText().trim().toLowerCase();
			for(BAOCAOTUYENDUNG i: trangchinh.getData().getDanhsachbaocaotuyendung().getList()) {
				if(i.getChucVu().toLowerCase().contains(a)||
				i.getMaTuyenDung().contains(temp2.getTuyenDung_Find().getText())||
				i.getDoTuoi().contains(temp2.getTuyenDung_Find().getText())||
				i.getGioiTinh().contains(temp2.getTuyenDung_Find().getText())||
				i.getMucLuongToiDa()==Double.parseDouble(temp2.getTuyenDung_Find().getText())||
				i.getMucLuongToiThieu()==Double.parseDouble(temp2.getTuyenDung_Find().getText())||
				i.getSoLuongCanTuyen()==Integer.parseInt(temp2.getTuyenDung_Find().getText())||
//				i.getHanNopHoSo().getYear()==Integer.parseInt(temp.getTuyenDung_Find().getText())||
//				i.getHanNopHoSo().getMonthValue()==Integer.parseInt(temp.getTuyenDung_Find().getText())||
//				i.getHanNopHoSo().getDayOfMonth()==Integer.parseInt(temp.getTuyenDung_Find().getText())||
				i.getHocVan().contains(temp2.getTuyenDung_Find().getText())) {
					find.getList().add(i);
				}
			}
			temp2.setData(find.getObject());
		}
		else if(str.equals("Xóa")){
			try {
				int row =temp2.getObjectTable().getSelectedRow();
				if(temp2.getObjectTable().getValueAt(row, 7).toString().equals("0")==false) {
					JOptionPane.showMessageDialog(trangchinh, "Không thể xóa vì "+ temp2.getObjectTable().getValueAt(row, 1).toString()+" đã có ứng viên nộp hồ sơ");
				}
				else {
					int a=JOptionPane.showConfirmDialog(trangchinh, "Bạn có muốn xóa báo cáo có mã "+ temp2.getObjectTable().getValueAt(row, 1).toString());
					if(a==0) {
						if(row==-1)
							return;
						else {
							trangchinh.getData().getDanhsachbaocaotuyendung().getList().remove(row);
							// Cập nhật vào database
							access_TUYENDUNG.deleteBaoCaoTuyenDung(temp2.getObjectTable().getValueAt(row, 1).toString());
							// đổi màu chữ xóa
							temp2.getButton_TuyenDung_Xoa().setForeground(new Color(128,128,128));
						
						}
						// Cập nhật lại bảng trên giao diện
						temp2.setData(trangchinh.getData().getDanhsachbaocaotuyendung().getObject());
						// Cập nhật lại giá trị ô JcomboBox của UngVienView
						trangchinh.getContent().getRecruitmentForm().getUngVienView().getComboBox_MaTuyenDung().removeItemAt(row);
					}
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(trangchinh, "Vui lòng chọn báo cáo cần xóa");
			}
			
		}
	}

}
