package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import DTO.CHUCVU;
import connection_database.connection;

public class access_CHUCVU {
	public static void deleteChucVu(String maChucVu) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement st = con.prepareStatement("delete CHUCVU where maChucVu = ?");
			st.setString(1, maChucVu);
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insertChucVu(CHUCVU chucVu) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement st = con.prepareStatement("insert CHUCVU values(?,?,?,?)");
			st.setString(1, chucVu.getMaChucVu());
			st.setString(2, chucVu.getTenChucVu());
			st.setDouble(3, chucVu.getPhuCapChucVu());
			st.setDate(4, Date.valueOf(chucVu.getNgayNhanChuc()));
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void updateChucVu(CHUCVU chucVu) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement st = con.prepareStatement("update CHUCVU set tenChucVu = ?, phuCapChucVu = ?,ngayNhanChuc = ? where maChucVu = ?");
			st.setString(1, chucVu.getTenChucVu());
			st.setDouble(2, chucVu.getPhuCapChucVu());
			st.setDate(3, Date.valueOf(chucVu.getNgayNhanChuc()));
			st.setString(4, chucVu.getMaChucVu());
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
