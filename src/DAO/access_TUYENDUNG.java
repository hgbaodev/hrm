package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.BAOCAOTUYENDUNG;
import connection_database.connection;

public class access_TUYENDUNG {
	public static ArrayList<BAOCAOTUYENDUNG> getList(){
		ArrayList<BAOCAOTUYENDUNG> list= new ArrayList<>();
		// Tạo kết nối
 		Connection con = connection.getConnection();
 		Statement st;
 		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from BAOCAOTUYENDUNG order by maTuyenDung");
			while(rs.next()) {
				BAOCAOTUYENDUNG x = new BAOCAOTUYENDUNG();
				x.setMaTuyenDung(rs.getString("maTuyenDung"));
				x.setChucVu(rs.getString("chucVu"));
				x.setHocVan(rs.getString("hocVan"));
				x.setGioiTinh(rs.getString("yeuCauGioiTinh"));
				x.setDoTuoi(rs.getString("yeuCauDoTuoi"));;
				x.setSoLuongCanTuyen(Integer.parseInt(rs.getString(6)));
				x.setHanNopHoSo(rs.getDate("hanNopHoSo").toLocalDate().plusDays(2));
				x.setMucLuongToiThieu(rs.getDouble("mucLuongToiThieu"));
				x.setMucLuongToiDa(rs.getDouble("mucLuongToiDa"));
				Statement st1 = con.createStatement();
				ResultSet rs1 = st1.executeQuery("select COUNT(CMND) from UNGVIEN where maTuyenDung = '"+x.getMaTuyenDung()+"'");
				
				while(rs1.next()) {
					x.setSoLuongNopHoSo(Integer.parseInt(rs1.getString(1)));
				}
				Statement st2 = con.createStatement();
				ResultSet rs2 = st2.executeQuery("select count(maUngVien) from UNGVIEN uv join NHANVIEN nv on nv.CMND = uv.CMND where uv.maTuyenDung = '"+x.getMaTuyenDung()+"'");
				
				while(rs2.next()) {
					x.setSoLuongDaTuyen(Integer.parseInt(rs2.getString(1)));
				}
				list.add(x);
			}
			connection.closeConnection(con);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}public static String getChucVuTuyenDung(String maTuyenDung){
		// Tạo kết nối
 		Connection con = connection.getConnection();
 		PreparedStatement pst;
 		try {
 			String sql = "select chucVu from BAOCAOTUYENDUNG where maTuyenDung = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, maTuyenDung);
			ResultSet rs = pst.executeQuery();
			String chucVu = "";
			while(rs.next()) {
				chucVu = rs.getString(1);
			}
			connection.closeConnection(con);
			return chucVu;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void insertBaoCaoTuyenDung(BAOCAOTUYENDUNG x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("insert BAOCAOTUYENDUNG values(?,?,?,?,?,?,?,?,?)");
			pst.setString(1, x.getMaTuyenDung());
			pst.setString(2, x.getChucVu());
			pst.setString(3, x.getHocVan());
			pst.setString(4, x.getGioiTinh());
			pst.setString(5, x.getDoTuoi());
			pst.setInt(6, x.getSoLuongCanTuyen());
			pst.setDate(7, Date.valueOf(x.getHanNopHoSo()));
			pst.setDouble(8, x.getMucLuongToiThieu());
			pst.setDouble(9, x.getMucLuongToiDa());
			pst.executeUpdate();
			
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteBaoCaoTuyenDung(String maTuyenDung) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("delete BAOCAOTUYENDUNG where maTuyenDung = ?");
			pst.setString(1, maTuyenDung);
			pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static String[] getMaTuyenDung() {
		String data[] = null;
		Connection con = connection.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs  = st.executeQuery("select COUNT(DISTINCT maTuyenDung) from BAOCAOTUYENDUNG");
			while(rs.next()) {
				data = new String[rs.getInt(1)];
			}
			rs = st.executeQuery("select * from BAOCAOTUYENDUNG order by maTuyenDung");
			int count =0;
			while(rs.next()) {
				data[count] = rs.getString(1);
				count++;
			}
			connection.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	public static String[] getMaTuyenDungToFilter() {
		String data[] = null;
		Connection con = connection.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs  = st.executeQuery("select COUNT(DISTINCT maTuyenDung) from BAOCAOTUYENDUNG");
			while(rs.next()) {
				data = new String[rs.getInt(1)+1];
			}
			rs = st.executeQuery("select * from BAOCAOTUYENDUNG order by maTuyenDung");
			data[0] = "Mã tuyển dụng";
			int count =1;
			while(rs.next()) {
				data[count] = rs.getString(1);
				count++;
			}
			connection.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
