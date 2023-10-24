package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DTO.TRINHDO;
import connection_database.connection;

public class access_TRINHDO {
	public static void insertTRINHDO(TRINHDO x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("insert TRINHDO values(?,?,?,?)");
			pst.setString(1, x.getMaTrinhDo());
			pst.setString(2, x.getTrinhDoHocVan());
			pst.setString(3, x.getTrinhDoChuyenMon());
			pst.setString(4, x.getChuyenNganh());
			pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void updateTRINHDO(TRINHDO x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("update TRINHDO set trinhDoHocVan = ? , trinhDoChuyenMon = ?, chuyenNganh = ? where maTrinhDo = ? ");
			pst.setString(1, x.getTrinhDoHocVan());
			pst.setString(2, x.getTrinhDoChuyenMon());
			pst.setString(3, x.getChuyenNganh());
			pst.setString(4, x.getMaTrinhDo());
			pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
