package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.CONNGUOI;
import connection_database.connection;

public class access_CONNGUOI {
	public static void insertCONNGUOI(CONNGUOI x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("insert CONNGUOI values(?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, x.getCmnd().getSoCmnd());
			pst.setString(2, x.getHoTen());
			pst.setString(3, x.getGioiTinh());
			pst.setDate(4, Date.valueOf(x.getNgaySinh()));
			pst.setString(5, x.getDiaChi().toString());
			pst.setString(6, x.getSdt());
			pst.setString(7, x.getTinhTrangHonNhan());
			pst.setString(8, x.getDanToc());
			pst.setString(9, x.getTonGiao());
			pst.setString(10, x.getEmail());
			pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateCONNGUOI(CONNGUOI x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("update CONNGUOI set hoTen = ? , gioiTinh = ? , ngaySinh = ? , diaChi = ? , SDT = ? , tinhTrangHonNhan = ? , danToc = ? , tonGiao = ? , email = ? where CMND = ?");
			pst.setString(1, x.getHoTen());
			pst.setString(2, x.getGioiTinh());
			pst.setDate(3, Date.valueOf(x.getNgaySinh()));
			pst.setString(4, x.getDiaChi().toString());
			pst.setString(5, x.getSdt());
			pst.setString(6, x.getTinhTrangHonNhan());
			pst.setString(7, x.getDanToc());
			pst.setString(8, x.getTonGiao());
			pst.setString(9, x.getEmail());
			pst.setString(10, x.getCmnd().getSoCmnd());
			pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

