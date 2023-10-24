package DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import DAO.access_NHANVIEN;

public class SUPPORT {
	public static boolean checkMatKhau(String matKhau) {
		if(matKhau.length()<6 || matKhau.length()>12 ) {
			return false;
		}
		if(matKhau.contains(" ")) {
			return false;
		}
		return true;
	}
	public static LocalDate toLocalDate(String str) {
		LocalDate localDate4 = LocalDate.parse(str,DateTimeFormatter.ofPattern("dd-LL-yyyy"));
		return localDate4;
	}
	public static String changeSalaryToFormatString(double value) {
		long temp = (long)value;
        String s = String.valueOf(temp);
        
        int n = s.length(), count = 0;
        for(int i=n-1;i>=0;i--){
            if(count==3){
                s = s.substring(0, i+1) +","+ s.substring(i+1);
                count = 0;
            }
            count++; 
        }
        return s;
	}
	public static Double changeStringSalaryToDouble(String value) {
		String arr[] = value.split(",");
		String s  ="";
		for(int i=0;i<arr.length;i++) {
			s = s + arr[i];
		}
		return Double.valueOf(s);
	}
	public static String convertHoTen(String hoTen) {
    	
    	hoTen = hoTen.toLowerCase();
    	String arr[] = hoTen.split(" ");
    	String temp = "";
    	for(int i=0;i<arr.length;i++) {
    		temp+=(arr[i].charAt(0)+"").toUpperCase() + arr[i].substring(1) +" ";
    	}
    	return temp;
    }
	public static String LocalDateToString(LocalDate date) {
		String arr[] = date.toString().split("-");
		return arr[2]+"-"+arr[1]+"-"+arr[0];
		
	}
	public static String convertNameToSort(String name) {
		String arr[] = name.split(" ");
		String temp = "";
		for(int i=arr.length-1;i>=0;i--) {
			temp = temp + arr[i] +" ";
		}
		
		
		return temp.trim().toLowerCase();
	}
	public static String localDatetoStringDanhGia(LocalDate date) {
		String d,m,y;
		if(date.getDayOfMonth()<9) {
			d = "0"+date.getDayOfMonth();
		}else {
			d = date.getDayOfMonth()+"";
		}
		if(date.getMonthValue()<9) {
			m = "0"+date.getMonthValue();
		}else {
			m = date.getMonthValue()+"";
		}
		if(date.getYear()<9) {
			y = "0"+date.getYear();
		}else {
			y = date.getYear()+"";
		}
		
		return d+m+y;
	}
	
	public static int getValueOfCharVietnamese(String vietnamese) {
		switch(vietnamese) {
			case "a":
				return 1;
			case "ă":
				return 2;
			case "â":
				return 3;
			case "b":
				return 4;
			case "c":
				return 5;
			case "d":
				return 6;
			case "đ":
				return 7;
			case "e":
				return 8;
			case "ê":
				return 9;
			case "g":
				return 10;
			case "h":
				return 11;
			case "i":
				return 12;
			case "k":
				return 13;
			case "l":
				return 14;
			case "m":
				return 15;
			case "n":
				return 16;
			case "o":
				return 17;
			case "ô":
				return 18;
			case "ơ":
				return 19;
			case "q":
				return 20;
			case "p":
				return 21;
			case "r":
				return 22;
			case "s":
				return 23;
			case "t":
				return 24;
			case "u":
				return 25;
			case "ư":
				return 26;
			case "v":
				return 27;
			case "x":
				return 28;
			case "y":
				return 29;
			default: 
				return -1;
		}
	}
	public static int soSanhChuoiUTF8(String str1, String str2) {
		int size = (str1.length()<str2.length())?str1.length():str2.length();
		for(int i=0;i<size;i++) {
			if(getValueOfCharVietnamese(str1.charAt(i)+"")<getValueOfCharVietnamese(str2.charAt(i)+"")) {
				return -1;
			}else if(getValueOfCharVietnamese(str1.charAt(i)+"")>getValueOfCharVietnamese(str2.charAt(i)+"")) {
				return 1;
			}
		}
		return 0;
	}
	public static int compareDouble(double a,double b) {
		if(a==b) {
			return 0;
		}
		return (a>b)?1:-1;
	}
	public static int compareInteger(int a,int b) {
		if(a==b) {
			return 0;
		}
		return (a>b)?1:-1;
	}
	public static String ranDomString(int length) {
		Random rd = new Random();
		String s = "";
		for(int i=0;i<length;i++) {
			s+= rd.nextInt(9);
		}
		return s;
	}
	public static String changeSalaryToFormatStringToFix(double value) {
		long temp = (long)value;
        String s = String.valueOf(temp);
        
        int n = s.length(), count = 0;
        String kq = "";
        for(int i=0;i<n;i++){
            kq+= s.charAt(i)+"";
        }
        return kq;
	}
	public static LUONG chuyenBangChamCongSangLuong(BANGCHAMCONG bcc,double thuong,double phucapkhac,double khoantrukhac) {
		LUONG x = new LUONG();
		x.setMaLuong("L"+bcc.getMaBangChamCong().substring(3));
		x.setMaBangChamCong(bcc.getMaBangChamCong());
		double dulieu[] = access_NHANVIEN.getLuongNhanVien(bcc.getMaNV());
		double luongThucTe = Math.round(dulieu[0]/26*bcc.getSoNgayLamViec() + dulieu[0]/26/8*bcc.getSoGioLamThem());
		double phuCap = Math.round(dulieu[0]*dulieu[1]/100);
		double truBaoHiem = Math.round(dulieu[0]*0.06);
		double luongTruocThue = luongThucTe+phuCap+phucapkhac-truBaoHiem-khoantrukhac+thuong;
		double thue = 0;
		if(luongTruocThue<=5000000) {
			thue = 0;
		}else if(luongTruocThue>5000000 && luongTruocThue<=10000000) {
			thue = 250000+(luongTruocThue-5000000)*0.1;
		}else if(luongTruocThue>10000000 && luongTruocThue<=18000000) {
			thue = 750000+(luongTruocThue-10000000)*0.15;
		}else if(luongTruocThue>18000000 && luongTruocThue<=32000000) {
			thue = 1850000+(luongTruocThue-18000000)*0.2;
		}else if(luongTruocThue>32000000 && luongTruocThue<=52000000) {
			thue = 4750000+(luongTruocThue-32000000)*0.25;
		}else {
			thue = 9750000+(luongTruocThue-52000000)*0.3;
		}
		thue = Math.round(thue);
		double thucLanh = Math.round(luongTruocThue - thue);
		x.setLuongThucTe(luongThucTe);
		x.setPhuCapChucVu(phuCap);
		x.setPhuCapKhac(phucapkhac);
		x.setKhoanTruBaoHiem(truBaoHiem);
		x.setKhoanTruKhac(khoantrukhac);
		x.setLuongThuong(thuong);
		x.setThue(thue);
		x.setThucLanh(thucLanh);
		return x;
	}
}
