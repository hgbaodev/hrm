package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.BAOCAOTUYENDUNG;
import DTO.CONNGUOI;
import DTO.DIACHI;
import DTO.UNGVIEN;
import connection_database.connection;

public class accsess_UNGVIEN {
	public static ArrayList<UNGVIEN> getList(){
		ArrayList<UNGVIEN> list= new ArrayList<>();
		// Tạo kết nối
 		Connection con = connection.getConnection();
 		Statement st;
 		try {
			st = con.createStatement();
			// chuc vu, tai khoan
			ResultSet rs = st.executeQuery("select * from UNGVIEN join CONNGUOI on UNGVIEN.CMND=CONNGUOI.CMND join CMND on UNGVIEN.CMND= CMND.soCMND join TRINHDO on TRINHDO.maTrinhDo=UNGVIEN.maTrinhDo");
			while(rs.next()) {
				UNGVIEN x = new UNGVIEN();
				x.setMaTuyenDung(rs.getString("maTuyenDung"));
				x.setMaUngVien(rs.getString("maUngVien"));
				x.setHoTen(rs.getString("hoTen"));
				x.setNgaySinh(rs.getDate("ngaySinh").toLocalDate().plusDays(2));
				x.setGioiTinh(rs.getString("gioiTinh"));
				x.setSdt(rs.getString("SDT"));
				x.setTinhTrangHonNhan(rs.getString("tinhTrangHonNhan"));
				String str = rs.getString("diaChi");
				String arr[] = str.split(",");
				String arr2[] = arr[0].split(" ");
				String temp ="";
				for(int i=1;i<arr2.length;i++) {
					temp+=arr2[i]+" ";
				}
				temp = temp.trim();
				x.setDanToc(rs.getString("danToc"));
				x.getCmnd().setSoCmnd(rs.getString("CMND"));
				x.getCmnd().setNoiCap(rs.getString("noiCap"));
				x.getCmnd().setNgayCap(rs.getDate("ngayCap").toLocalDate().plusDays(2));
				x.setDiaChi(new DIACHI(arr2[0],temp, arr[1], arr[2], arr[3]));
				x.setEmail(rs.getString("email"));
				x.setTrangThai(rs.getString("trangThai"));
				x.setTonGiao(rs.getString("tonGiao"));
				x.getTrinhDo().setMaTrinhDo(rs.getString("maTrinhDo"));
				x.getTrinhDo().setTrinhDoHocVan(rs.getString("trinhDoHocVan"));
				x.getTrinhDo().setTrinhDoChuyenMon(rs.getString("trinhdoChuyenMon"));
				x.getTrinhDo().setChuyenNganh(rs.getString("chuyenNganh"));
				x.setChucVu(rs.getString("tenChucVu"));
				x.setMucLuongDeal(Double.parseDouble(rs.getString("mucLuongDeal")));
				list.add(x);
			}
			connection.closeConnection(con);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void insertUngVien(UNGVIEN x) {
		Connection con = connection.getConnection();
		try {
			access_TRINHDO.insertTRINHDO(x.getTrinhDo());
			access_CMND.insertCMND(x.getCmnd());
			access_CONNGUOI.insertCONNGUOI((CONNGUOI)x);
			PreparedStatement pst = con.prepareStatement("insert UNGVIEN values(?,?,?,?,?,?,?)");
			pst.setString(1, x.getMaTuyenDung());
			pst.setString(2, x.getMaUngVien());
			pst.setString(3, x.getCmnd().getSoCmnd());
			pst.setDouble(4, x.getMucLuongDeal());
			pst.setString(5, x.getTrinhDo().getMaTrinhDo());
			pst.setString(6, x.getChucVu());
			pst.setString(7, x.getTrangThai());
			pst.executeUpdate();

			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteUngVien(String maTrinhDo, String soCMND, String maUngVien) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("delete UNGVIEN where maUngVien = ?");
			pst.setString(1, maUngVien);
			pst.executeUpdate();
			
			pst = con.prepareStatement("delete CONNGUOI where CMND = ?");
			pst.setString(1, soCMND);
			pst.executeUpdate();
			
			pst = con.prepareStatement("delete CMND where soCMND = ?");
			pst.setString(1, soCMND);
			pst.executeUpdate();
			
			pst = con.prepareStatement("delete TRINHDO where maTrinhDo = ?");
			pst.setString(1, maTrinhDo);
			pst.executeUpdate();
			
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteUngVienDaTuyen(String maTrinhDo, String maUngVien) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("delete UNGVIEN where maUngVien = ?");
			pst.setString(1, maUngVien);
			pst.executeUpdate();
			pst = con.prepareStatement("delete TRINHDO where maTrinhDo = ?");
			pst.setString(1, maTrinhDo);
			pst.executeUpdate();
			
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateTrangThai(String maUngVien,String trangThai) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("update UNGVIEN set trangThai=?  where maUngVien = ?");
			pst.setString(1, trangThai);
			pst.setString(2, maUngVien);
			pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<String> getDanhSachMaSo() {
		Connection con = connection.getConnection();
		try {
			ArrayList<String> list =new ArrayList<>();
			PreparedStatement pst = con.prepareStatement("select * from UNGVIEN");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				  list.add(rs.getString("maUngVien")); 
			}
			connection.closeConnection(con);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
