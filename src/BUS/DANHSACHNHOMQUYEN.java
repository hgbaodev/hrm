package BUS;


import java.util.ArrayList;

import DAO.access_NHOMQUYEN;
import DTO.NHOMQUYEN;

public class DANHSACHNHOMQUYEN {
	private ArrayList<NHOMQUYEN> list;
	public DANHSACHNHOMQUYEN() {
		this.list = new ArrayList<>();
	}
	public  ArrayList<NHOMQUYEN> getList(){
		return this.list;
	}
	public void getDataFormDatabase() {
		this.list = access_NHOMQUYEN.getDanhSachNhomQuyen();
	}
	public Object[][] getObjectToRender(){
		Object[][] ob = new Object[list.size()][];
		for(int i=0;i<list.size();i++) {
			ob[i] = new Object[] { i+"", list.get(i).getMaNhomQuyen()+" - "+list.get(i).getTenNhomQuyen()};
		}
		return ob;
	}
	public String[] getMaNhomQuyenForCBB(){
		String[] ob = new String[list.size()];
		for(int i=0;i<list.size();i++) {
			ob[i] = list.get(i).getMaNhomQuyen();
		}
		return ob;
	} 
}
