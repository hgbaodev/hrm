package DTO;


public class DIACHI {
	private String soNha;
	private String duong;
	private String phuongXa;
    private String quanHuyen;
    private String tinhThanhPho;
    
    public DIACHI(){
        this.soNha = "";
        this.duong = "";
        this.phuongXa = "";
        this.quanHuyen = "";
        this.tinhThanhPho = "";
    }
    
    public DIACHI(String soNha, String duong, String phuongXa, String quanHuyen, String tinhThanhPho){
        this.soNha = soNha;
        this.duong = duong;
        this.phuongXa = phuongXa;
        this.quanHuyen = quanHuyen;
    	this.tinhThanhPho = tinhThanhPho;
    }
    public String getSoNha() {
    	return this.soNha;
    }
    public void setSoNha(String soNha) {
    	this.soNha = soNha;
    }
    public String getTinhThanhPho() {
        return tinhThanhPho;
    }
    public void setTinhThanhPho(String tinhThanhPho) {
        this.tinhThanhPho = tinhThanhPho;
    }
    public String getQuanHuyen() {
        return quanHuyen;
    }
    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }
    public String getPhuongXa() {
        return phuongXa;
    }
    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }
    public String getDuong() {
        return duong;
    }
    public void setDuong(String duong) {
        this.duong = duong;
    }
    public String toString() {
    	return soNha+" "+duong+", "+phuongXa+", "+quanHuyen+", "+tinhThanhPho;
    }
}
