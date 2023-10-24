package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection_database.connection;

public class access_CHUCVUCONGTY {
	public static String[] getDanhSachTenChucVuCongTy() {
		String data[] = null;
		Connection con = connection.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs  = st.executeQuery("select COUNT(tenChucVu) from CHUCVUCONGTY");
			while(rs.next()) {
				data = new String[rs.getInt(1)];
			}
			rs = st.executeQuery("select * from CHUCVUCONGTY order by phuCapChucVu desc");
			int count =0;
			while(rs.next()) {
				data[count] = rs.getString("tenChucVu");
				count++;
			}
			connection.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	public static Object[] getChucVuCongTyTuTen(String tenChucVu) {
		Object data[] = new Object[3];
		Connection con = connection.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs  = st.executeQuery("select * from CHUCVUCONGTY where tenChucVu = N'"+tenChucVu+"'");
			while(rs.next()) {
				data[0] = rs.getString("maChucVu");
				data[1] = rs.getString("tenChucVu");
				data[2] = rs.getDouble("phuCapChucVu");
			}
			connection.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	public static double getPhuCapChucVuCongTy(String tenChucVu) {
		Connection con = connection.getConnection();
		double value = 0;
		try {
			Statement st = con.createStatement();
			ResultSet rs  = st.executeQuery("select * from CHUCVUCONGTY where tenChucVu = N'"+tenChucVu+"'");
			while(rs.next()) {
				value = rs.getDouble("phuCapChucVu");
			}
			connection.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
