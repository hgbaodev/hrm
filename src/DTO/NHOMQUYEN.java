package DTO;

public class NHOMQUYEN {
	private String maNhomQuyen;
	private String tenNhomQuyen;
	private boolean[] mangChucNang;
	public NHOMQUYEN() {
		
		this.maNhomQuyen = "";
		this.tenNhomQuyen = "";
		this.mangChucNang = null;
	}
	public NHOMQUYEN(String maNhomQuyen,String tenNhomQuyen,boolean[] mangChucNang) {
		
		this.maNhomQuyen = maNhomQuyen;
		this.tenNhomQuyen = tenNhomQuyen;
		this.mangChucNang = mangChucNang;
	}
	public String getMaNhomQuyen() {
		return maNhomQuyen;
	}
	public void setMaNhomQuyen(String maNhomQuyen) {
		this.maNhomQuyen = maNhomQuyen;
	}
	public String getTenNhomQuyen() {
		return tenNhomQuyen;
	}
	public void setTenNhomQuyen(String tenNhomQuyen) {
		this.tenNhomQuyen = tenNhomQuyen;
	}
	public boolean[] getMangChucNang() {
		return mangChucNang;
	}
	public void setMangChucNang(boolean[] mangChucNang) {
		this.mangChucNang = mangChucNang;
	}
}
