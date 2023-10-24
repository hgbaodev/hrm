package DTO;

import java.time.LocalDate;
import java.util.Random;

import DAO.access_PHONGBAN;


public class PHONGBAN {
    
    private String maPhong;
    private String tenPhong;
    private LocalDate ngayThanhLap;
    private String maTruongPhong;
    
    public PHONGBAN(){
        maPhong = "";
        tenPhong = "";
        ngayThanhLap = null;
        maTruongPhong = "";
    }
    
    public PHONGBAN(String maPhong, String tenPhong, LocalDate ngayThanhLap, String maTruongPhong){
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.ngayThanhLap = ngayThanhLap;
        this.maTruongPhong = maTruongPhong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public LocalDate getNgayThanhLap() {
        return ngayThanhLap;
    }

    public void setNgayThanhLap(LocalDate ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }

    public String getMaTruongPhong() {
        return maTruongPhong;
    }

    public void setMaTruongPhong(String maTruongPhong) {
        this.maTruongPhong = maTruongPhong;
    }
    public int[] getSalaryData() {
    	Random rd = new Random();
    	return new int[] {rd.nextInt(155)+50,rd.nextInt(155)+50,rd.nextInt(155)+50,rd.nextInt(155)+50};
    }
    public int[] getEmployeeCount() {
    	Random rd = new Random();
    	return new int[] {rd.nextInt(155)+50,rd.nextInt(155)+50,rd.nextInt(155)+50,rd.nextInt(155)+50};
    }
    public int[] getAgeCount() {
    	Random rd = new Random();
    	return new int[] {rd.nextInt(155)+50,rd.nextInt(155)+50,rd.nextInt(155)+50,rd.nextInt(155)+50};
    }
    public int[] getPositionCount() {
    	Random rd = new Random();
    	return new int[] {rd.nextInt(155)+50,rd.nextInt(155)+50,rd.nextInt(155)+50,rd.nextInt(155)+50,rd.nextInt(155)+50};
    }
    public int[] getGenderCount() {
    	Random rd = new Random();
    	return new int[] {rd.nextInt(155)+50,rd.nextInt(155)+50};
    }
    public double getAverageSalaryDepartment() {
    	double data[] = access_PHONGBAN.getAverageSalaryData(this.maPhong);
    	double value = (data[1]+data[2])/data[0];
    	return value;
    }
    
}
