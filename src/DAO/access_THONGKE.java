package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.PHONGBAN;
import connection_database.connection;

public class access_THONGKE {
	public static int[] thongKeTrangChuForm3_soLuongNhanVien(){
		ArrayList<PHONGBAN> list = new ArrayList<>();
 		Connection con = connection.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			int temp = 0;
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select count(nv.maNhanVien) from NHANVIEN nv where nv.trangThai =1");
			while(rs.next()) {
				temp = rs.getInt(1);
			}
			rs = st.executeQuery("select * from THONGKE where maDonVi='CONGTY'");
			int[] obj = null;
			while(rs.next()) {
				obj = new int[] {
						(int)(rs.getInt("slnvNam1")*180/60),
						(int)(rs.getInt("slnvNam2")*180/60),
						(int)(rs.getInt("slnvNam3")*180/60),
						(int)(temp*180/60),
				};
			}
			
			connection.closeConnection(con);
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int[] thongKeTrangChuForm3_mucLuongTB(){
		ArrayList<PHONGBAN> list = new ArrayList<>();
 		Connection con = connection.getConnection();
 		
		Statement st;
		try {
			int temp = 0;
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select avg(nv.luongThuViec+hd.luongCoBan) from NHANVIEN nv left join HOPDONGLAODONG hd \r\n"
					+ " 		on nv.maHopDong = hd.maHopDong\r\n"
					+ " 		where nv.trangThai =1");
			while(rs.next()) {
				temp = rs.getInt(1);
			}
			rs = st.executeQuery("select * from THONGKE where maDonVi='CONGTY'");
			int[] obj = null;
			while(rs.next()) {
				obj = new int[] {
						(int)(rs.getDouble("luongTbNam1")/1000000*180/30),
						(int)(rs.getDouble("luongTbNam2")/1000000*180/30),
						(int)(rs.getDouble("luongTbNam3")/1000000*180/30),
						(int)(temp/1000000*180/30),
				};
			}
			
			connection.closeConnection(con);
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static int[] thongKePhongBan_soLuongNhanVien(String maPhong){
		ArrayList<PHONGBAN> list = new ArrayList<>();
 		Connection con = connection.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			int temp = 0;
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select count(nv.maNhanVien) from NHANVIEN nv where nv.trangThai =1 and nv.maPhong=N'"+maPhong+"'");
			while(rs.next()) {
				temp = rs.getInt(1);
			}
			rs = st.executeQuery("select * from THONGKE where maDonVi=N'"+maPhong+"'");
			int[] obj = null;
			while(rs.next()) {
				obj = new int[] {
						(int)(rs.getInt("slnvNam1")*180/60),
						(int)(rs.getInt("slnvNam2")*180/60),
						(int)(rs.getInt("slnvNam3")*180/60),
						(int)(temp*180/60),
				};
			}
			
			connection.closeConnection(con);
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static int[] thongKePhongBan_mucLuongTB(String maPhong){
		ArrayList<PHONGBAN> list = new ArrayList<>();
 		Connection con = connection.getConnection();
 		
		Statement st;
		try {
			int temp = 0;
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select avg(nv.luongThuViec+hd.luongCoBan) from NHANVIEN nv left join HOPDONGLAODONG hd \r\n"
					+ " 		on nv.maHopDong = hd.maHopDong\r\n"
					+ " 		where nv.trangThai =1 and nv.maPhong=N'"+maPhong+"'");
			while(rs.next()) {
				temp = rs.getInt(1);
			}
			rs = st.executeQuery("select * from THONGKE where maDonVi=N'"+maPhong+"'");
			int[] obj = null;
			while(rs.next()) {
				obj = new int[] {
						(int)(rs.getDouble("luongTbNam1")/1000000*180/30),
						(int)(rs.getDouble("luongTbNam2")/1000000*180/30),
						(int)(rs.getDouble("luongTbNam3")/1000000*180/30),
						(int)(temp/1000000*180/30),
				};
			}
			
			connection.closeConnection(con);
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void insertTHONGKE(String maPhong){
 		Connection con = connection.getConnection();
 		
		PreparedStatement st;
		try {
			String sql = "insert THONGKE values(?,?,?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setString(1, maPhong);
			st.setInt(2, 0);
			st.setInt(3, 0);
			st.setInt(4, 0);
			st.setInt(5, 0);
			st.setInt(6, 0);
			st.setInt(7, 0);
			
			st.executeUpdate();
			
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void deleteTHONGKE(String maPhong) {
		Connection con = connection.getConnection();
 		
		PreparedStatement st;
		try {
			String sql = "delete THONGKE where maDonVi=?";
			st = con.prepareStatement(sql);
			st.setString(1, maPhong);
			st.executeUpdate();
			
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
