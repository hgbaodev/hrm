package DAO;


import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.PHUONGXA;
import DTO.QUANHUYEN;
import DTO.TINHTHANHPHO;
import connection_database.connection;

public class access_DIACHI {
	public static ArrayList<TINHTHANHPHO> getList() {
		Connection conn = connection.getConnection();
		ArrayList<TINHTHANHPHO> list = new ArrayList<>();
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from TINHTHANHPHO order by tenTinhThanhPho");
			while(rs.next()) {
				
				TINHTHANHPHO x = new TINHTHANHPHO();
				x.setTenTinhThanhPho(rs.getString("tenTinhThanhPho"));
				Statement st1 = conn.createStatement();
				ResultSet rs1 = st1.executeQuery("select * from QUANHUYEN where maTinhThanhPho = '"+rs.getString(1)+"' order by tenQuanHuyen");
				while(rs1.next()) {
					QUANHUYEN qh = new QUANHUYEN();
					qh.setTenQuanHuyen(rs1.getString("tenQuanHuyen"));
					
					Statement st2 = conn.createStatement();
					ResultSet rs2 = st2.executeQuery("select * from PHUONGXA where maQuanHuyen = '"+rs1.getString(1)+"' order by tenPhuongXa");
					while(rs2.next()) {
						PHUONGXA px =new PHUONGXA();
						px.setTenPhuongXa(rs2.getString("tenPhuongXa"));
						Statement st3 = conn.createStatement();
						ResultSet rs3 = st3.executeQuery("select * from DUONG where maPhuongXa = '"+rs2.getString(1)+"' order by tenDuong");
						while(rs3.next()) {
							px.getDanhSachDuong().add(rs3.getString("tenDuong"));
						}
						qh.getDanhSachPhuongXa().add(px);
					}
					x.getDanhSachQuanHuyen().add(qh);
					
				}
				list.add(x);
				
			}
			connection.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
