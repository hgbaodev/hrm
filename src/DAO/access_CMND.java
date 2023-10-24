package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.CMND;
import connection_database.connection;

public class access_CMND {
	public static ArrayList<String> getDanhSachMaSo(){
		ArrayList<String> dsMaso = new ArrayList<>();
		Connection con = connection.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from CMND");
			while(rs.next()) {
				dsMaso.add(rs.getString("soCMND"));
			}
			connection.closeConnection(con);
			return dsMaso;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static void insertCMND(CMND x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("insert CMND values(?,?,?)");
			pst.setString(1, x.getSoCmnd());
			pst.setString(2, x.getNoiCap());
			pst.setDate(3, Date.valueOf(x.getNgayCap()));
			pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateCMND(CMND x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("update CMND set noiCap = ? , ngayCap = ? where soCMND = ?");
			pst.setString(1, x.getNoiCap());
			pst.setDate(2, Date.valueOf(x.getNgayCap()));
			pst.setString(3, x.getSoCmnd());
			pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
