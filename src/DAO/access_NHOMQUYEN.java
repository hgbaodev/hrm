package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.NHOMQUYEN;
import connection_database.connection;

public class access_NHOMQUYEN {
	public static boolean[] getChucNangTaiKhoan(String username) {
		boolean[] mangChucNang = new boolean[38];
		for(int i=0;i<38;i++) {
			mangChucNang[i] = false;
		}
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("select * from TAIKHOAN tk \r\n"
					+ "join CHITIETNHOMQUYEN ct on tk.maNhomQuyen = ct.maNhomQuyen where tk.username = ?");
			pst.setString(1, username);
			 ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int index = Integer.valueOf(rs.getString("maChucNang"));
				mangChucNang[index-1] = true;
			}
			connection.closeConnection(con);
			return mangChucNang;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static ArrayList<NHOMQUYEN> getDanhSachNhomQuyen() {
		ArrayList<NHOMQUYEN> list = new ArrayList<>();
		Connection con = connection.getConnection();
		try {
			
			PreparedStatement pst = con.prepareStatement("select * from NHOMQUYEN");
			PreparedStatement pst2;
			ResultSet rs2;
			 ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				NHOMQUYEN x = new NHOMQUYEN(rs.getString("maNhomQuyen"),rs.getString("tenNhomQuyen"),null);
				boolean mangChucNang[] = new boolean[38];
				for(int i=0;i<38;i++) {
					mangChucNang[i] = false;
				}
				pst2 = con.prepareStatement("select * from NHOMQUYEN nq join CHITIETNHOMQUYEN ct on nq.maNhomQuyen = ct.maNhomQuyen where nq.maNhomQuyen = ?");
				pst2.setString(1, rs.getString("maNhomQuyen"));
				rs2 = pst2.executeQuery();
				while(rs2.next()) {
					int index = Integer.valueOf(rs2.getString("maChucNang"));
					mangChucNang[index-1] = true;
				}
				x.setMangChucNang(mangChucNang);
				list.add(x);
			}
			connection.closeConnection(con);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static boolean insertNHOMQUYEN(String maNhomQuyen, String tenNhomQuyen) {
		Connection con = connection.getConnection();
		try {
			
			PreparedStatement pst = con.prepareStatement("insert NHOMQUYEN values(?,?)");
			pst.setString(1, maNhomQuyen);
			pst.setString(2, tenNhomQuyen);
			int flag = pst.executeUpdate();
			connection.closeConnection(con);
			if(flag==0) {
				return false;
			}else {
				return true;
			}
			
		} catch (SQLException e) {
			return false;
		}
	}
	public static boolean deleteNHOMQUYEN(String maNhomQuyen) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("select count(*) from TAIKHOAN where maNhomQuyen = ?");
			pst.setString(1, maNhomQuyen);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int value = rs.getInt(1);
				if(value>0) {
					return false;
				}
			}
			pst = con.prepareStatement("delete CHITIETNHOMQUYEN where maNhomQuyen = ?");
			pst.setString(1, maNhomQuyen);
			pst.executeUpdate();
			
			pst = con.prepareStatement("delete NHOMQUYEN where maNhomQuyen = ?");
			pst.setString(1, maNhomQuyen);
			int flag = pst.executeUpdate();
			connection.closeConnection(con);
			if(flag==0) {
				return false;
			}else {
				return true;
			}
			
		} catch (SQLException e) {
			return false;
		}
	}
	public static void deleteCHITIETNHOMQUYEN(String maNhomQuyen) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("delete CHITIETNHOMQUYEN where maNhomQuyen = ?");
			pst.setString(1, maNhomQuyen);
			pst.executeUpdate();
			
		} catch (SQLException e) {
		}
	}
	public static void insertCHITIETNHOMQUYEN(String maNhomQuyen,String maChucNang) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("insert CHITIETNHOMQUYEN values(?,?)");
			pst.setString(1, maNhomQuyen);
			pst.setString(2, maChucNang);
			pst.executeUpdate();
			
		} catch (SQLException e) {
		}
	}
}
