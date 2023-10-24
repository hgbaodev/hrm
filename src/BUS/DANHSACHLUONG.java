package BUS;

import java.util.ArrayList;

import DAO.access_LUONG;
import DTO.LUONG;

public class DANHSACHLUONG {
	private ArrayList<LUONG> list;
	public DANHSACHLUONG() {
		list = new ArrayList<>();
	}
	public void getDataFromDatabase() {
		list = access_LUONG.getList();
	}
	public ArrayList<LUONG> getList() {
		return this.list;
	}
	public void getObjectToRender() {
	}
}
