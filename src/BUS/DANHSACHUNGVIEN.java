package BUS;

import java.util.ArrayList;

import DAO.accsess_UNGVIEN;
import DTO.FORMAT;
import DTO.UNGVIEN;



public class DANHSACHUNGVIEN {
	private ArrayList<UNGVIEN> list;
	public DANHSACHUNGVIEN() {
		list = new ArrayList<>();
	}
	public DANHSACHUNGVIEN(ArrayList<UNGVIEN> list) {
		this.list = list;
	}
	public ArrayList<UNGVIEN> getList(){
		return this.list;
	}
	public void getDataFromDatabase() {
		list=accsess_UNGVIEN.getList();
	}
	public Object[][] getObject(){
		Object[][] data = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
        	UNGVIEN obj = list.get(i);
            data[i] = new Object[]{obj.getMaTuyenDung(), obj.getMaUngVien()+" - "+obj.getHoTen(),obj.getSdt(),obj.getEmail(),obj.getChucVu(),obj.getTrinhDo().getTrinhDoHocVan(),FORMAT.vnd(obj.getMucLuongDeal()),obj.getTrangThai()};
        }
        return data;
	}
	public ArrayList<UNGVIEN> getList(String maBCTD){
		ArrayList<UNGVIEN> temp = new ArrayList<>();
		for(UNGVIEN i : list) {
			if(i.getMaTuyenDung().equals(maBCTD)) {
				temp.add(i);
			}
		}
		return temp;
	}
	public UNGVIEN getUngVien(String maUngVien) {
		for(UNGVIEN i : list) {
			if(i.getMaUngVien().equals(maUngVien)) {
				return i;
			}
		}
		return null;
	}
}
