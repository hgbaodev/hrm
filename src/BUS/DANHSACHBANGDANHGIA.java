package BUS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import DAO.access_BANGDANHGIA;
import DTO.DANHGIA;
import DTO.SUPPORT;


public class DANHSACHBANGDANHGIA {
	private ArrayList<DANHGIA> list= new ArrayList<DANHGIA>();
	public DANHSACHBANGDANHGIA() {
		list  = new ArrayList<DANHGIA>();
	}
	public DANHSACHBANGDANHGIA(ArrayList<DANHGIA> list) {
		this.list = list;
	}
	public ArrayList<DANHGIA> getList(){
		return this.list;
	}
	public void setList(ArrayList<DANHGIA> list) {
		this.list = list;
	}

	public void getDataFromDatabase() {
		list=access_BANGDANHGIA.getList();
	}
	
	public DANHSACHBANGDANHGIA getDANHSACHDANHGIATheoMaNhanVien(String maNhanVien){
		DANHSACHBANGDANHGIA data = new DANHSACHBANGDANHGIA();
        for(DANHGIA i : list) {
        	if(i.getMaNhanVien().equals(maNhanVien)) {
        		data.getList().add(i);
        	}
        }
        return data;
	}
	public Object[][] getObjectToRender(){
		Object[][] obj = new Object[list.size()][];
		for(int i=0;i<list.size();i++) {
			obj[i] = new Object[] {
				i+1, list.get(i).getMaDanhGia(),	list.get(i).getMaNhanVien()+" - "+list.get(i).getTenNhanVien(), SUPPORT.LocalDateToString(list.get(i).getNgayDanhGia()),
				list.get(i).getMaNguoiDanhGia()+" - "+list.get(i).getTenNguoiDanhGia(),list.get(i).getDiemDanhGia(),list.get(i).getXepLoai(),list.get(i).getLoaiDanhGia()
			};
		}
		
		return obj;
	}
	public DANHGIA getDanhGia(String maDanhGia) {
		for(DANHGIA i : list) {
			if(i.getMaDanhGia().equals(maDanhGia)) {
				return i;
			}
		}
		return null;
	}
	public DANHSACHBANGDANHGIA getDANHSACHBANGDANHGIA(String loaiDanhGia,LocalDate batDau,LocalDate ketThuc) {
		ArrayList<DANHGIA> arr = new ArrayList<>();
		for(DANHGIA i : list) {
			if(i.getLoaiDanhGia().equalsIgnoreCase(loaiDanhGia) && i.getNgayDanhGia().compareTo(batDau)>=0 && i.getNgayDanhGia().compareTo(ketThuc)<=0) {
				arr.add(i);
			}
		}
		return new DANHSACHBANGDANHGIA(arr);
	}
	public DANHSACHBANGDANHGIA getDANHSACHBANGDANHGIA(LocalDate batDau,LocalDate ketThuc) {
		ArrayList<DANHGIA> arr = new ArrayList<>();
		for(DANHGIA i : list) {
			if( i.getNgayDanhGia().compareTo(batDau)>=0 && i.getNgayDanhGia().compareTo(ketThuc)<=0) {
				arr.add(i);
			}
		}
		return new DANHSACHBANGDANHGIA(arr);
	}
	public void sortByPoint(int type) {
		list.sort((o1,o2) -> o1.getDiemDanhGia()-o2.getDiemDanhGia());
		if(type==0) {
			Collections.reverse(list);
		}
	}
	public void sortByDay(int type) {
		list.sort((o1,o2) -> o1.getNgayDanhGia().compareTo(o2.getNgayDanhGia()));
		if(type==0) {
			Collections.reverse(list);
		}
	}
}
