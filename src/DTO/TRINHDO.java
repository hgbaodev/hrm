package DTO;


public class TRINHDO {
    
    private String maTrinhDo;
    private String trinhDoHocVan;
    private String trinhDoChuyenMon;
    private String chuyenNganh;
    
    public TRINHDO(){
        
    }
    
    public TRINHDO(String maTrinhDo, String trinhDoHocVan, String trinhDoChuyenMon, String chuyenNganh){
        this.maTrinhDo = maTrinhDo;
        this.trinhDoHocVan = trinhDoHocVan;
        this.trinhDoChuyenMon = trinhDoChuyenMon;
        this.chuyenNganh = chuyenNganh;
    }

    public String getMaTrinhDo() {
        return maTrinhDo;
    }

    public void setMaTrinhDo(String maTrinhDo) {
        this.maTrinhDo = maTrinhDo;
    }

    public String getTrinhDoHocVan() {
        return trinhDoHocVan;
    }

    public void setTrinhDoHocVan(String trinhDoHocVan) {
        this.trinhDoHocVan = trinhDoHocVan;
    }

    public String getTrinhDoChuyenMon() {
        return trinhDoChuyenMon;
    }

    public void setTrinhDoChuyenMon(String trinhDoChuyenMon) {
        this.trinhDoChuyenMon = trinhDoChuyenMon;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }
    
    
}
