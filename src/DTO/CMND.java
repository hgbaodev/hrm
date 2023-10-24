package DTO;

import java.time.LocalDate;


public class CMND {
    
    private String soCmnd;
    private String noiCap;
    private LocalDate ngayCap;
    
    public CMND(){
        
    }
    
    public CMND(String soCmnd, String noiCap, LocalDate ngayCap){
        this.soCmnd = soCmnd;
        this.noiCap = noiCap;
        this.ngayCap = ngayCap;
    }

    public String getSoCmnd() {
        return soCmnd;
    }

    public void setSoCmnd(String soCmnd) {
        this.soCmnd = soCmnd;
    }

    public String getNoiCap() {
        return noiCap;
    }

    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }

    public LocalDate getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(LocalDate ngayCap) {
        this.ngayCap = ngayCap;
    }
}
