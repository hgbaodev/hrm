package BUS;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.access_TUYENDUNG;
import DTO.BAOCAOTUYENDUNG;
import DTO.FORMAT;



public class DANHSACHBAOCAOTUYENDUNG {
	private ArrayList<BAOCAOTUYENDUNG> list= new ArrayList<BAOCAOTUYENDUNG>();
	public DANHSACHBAOCAOTUYENDUNG() {
		list  = new ArrayList<BAOCAOTUYENDUNG>();
	}
	public DANHSACHBAOCAOTUYENDUNG(ArrayList<BAOCAOTUYENDUNG> list) {
		this.list = list;
	}
	public ArrayList<BAOCAOTUYENDUNG> getList(){
		return this.list;
	}
	public void setList(ArrayList<BAOCAOTUYENDUNG> list) {
		this.list = list;
	}

	public void getDataFromDatabase() {
		list=access_TUYENDUNG.getList();
	}
	public Object[][] getObject(){
		Object[][] data = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            BAOCAOTUYENDUNG obj = list.get(i);
            data[i] = new Object[]{i+1,obj.getMaTuyenDung(), obj.getChucVu(),obj.getHocVan(),obj.getGioiTinh(),obj.getDoTuoi(),obj.getSoLuongCanTuyen(),obj.getSoLuongNopHoSo(),obj.getSoLuongDaTuyen(),obj.getHanNopHoSo(),FORMAT.vnd(obj.getMucLuongToiThieu()),FORMAT.vnd(obj.getMucLuongToiDa())};
        }
        return data;
	}
	public  ArrayList<String> setMaTuyenDung(){
		ArrayList<String> a= new ArrayList<String>();
		for(BAOCAOTUYENDUNG i: list) {
			a.add(i.getMaTuyenDung());
		}
		return a;
	}
	public BAOCAOTUYENDUNG getBaoCaoTuyenDung(String maBaoCao) {
		for(BAOCAOTUYENDUNG i : list) {
			if(i.getMaTuyenDung().equals(maBaoCao)) {
				return i;
			}
		}
		return null;
	}
}
