package DTO;

public class TAIKHOAN {
    
    private String username;
    private String pass;
    private String maNhomQuyen;
    private String avatarImg;
    
    public TAIKHOAN(){
        this.username = "";
        this.pass = "";
        this.maNhomQuyen = "";
        this.avatarImg = "";
    }
    
    

	public TAIKHOAN(String username, String pass,String maNhomQuyen, String avatarImg){
        this.username = username;
        this.pass = pass;
        this.avatarImg = avatarImg;
        this.maNhomQuyen = maNhomQuyen;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

   

    public String getAvatarImg() {
        return avatarImg;
    }

    public void setAvatarImg(String avatarImg) {
        this.avatarImg = avatarImg;
    }
    public String getMaNhomQuyen() {
    	return this.maNhomQuyen;
    }
    public void setMaNhomQuyen(String maNhomQuyen) {
    	this.maNhomQuyen = maNhomQuyen;
    }
   
   
}
