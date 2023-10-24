package BUS;

import java.util.ArrayList;

import DAO.access_DIACHI;
import DTO.TINHTHANHPHO;

public class DANHSACHDIACHI {
	private ArrayList<TINHTHANHPHO> list;
	public DANHSACHDIACHI() {
		list = new ArrayList<>();
	}
	public ArrayList<TINHTHANHPHO> getList(){
		return this.list;
	}
	public void getDataFromDataBase() {
		this.list = access_DIACHI.getList();
	}
	public String[] getDanhSachTinhThanhPhoString() {
		String str[] = new String[list.size()];
		for(int i=0;i<list.size();i++) {
			str[i] = list.get(i).getTenTinhThanhPho();
		}
		return str;
	}
}
