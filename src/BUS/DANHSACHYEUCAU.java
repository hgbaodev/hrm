package BUS;

import java.util.ArrayList;

import DTO.YEUCAU;

public class DANHSACHYEUCAU {
	private ArrayList<YEUCAU> list;
	public DANHSACHYEUCAU() {
		this.list = new ArrayList<>();
	}
	public DANHSACHYEUCAU(ArrayList<YEUCAU> list) {
		this.list = list;
	}
	public ArrayList<YEUCAU> getList(){
		return this.list;
	}
}
