package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.HOPDONGLAODONG;
import DTO.SUPPORT;
import connection_database.connection;

public class access_HOPDONGLAODONG {
	
	public static void insertHOPDONGLAODONG(HOPDONGLAODONG x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("insert HOPDONGLAODONG values(?,?,?,?,?)");
			pst.setString(1, x.getMaHopDong());
			pst.setDate(2, Date.valueOf(x.getTuNgay()));
			pst.setDate(3, Date.valueOf(x.getDenNgay()));
			pst.setString(4, x.getLoaiHopDong());
			pst.setDouble(5,x.getLuongCoBan());
			pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	public static void updateHOPDONGLAODONG(HOPDONGLAODONG x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("update HOPDONGLAODONG set tuNgay = ? , denNgay = ? , loaiHopDong = ? , luongCoBan = ? where maHopDong = ?");
			
			pst.setDate(1, Date.valueOf(x.getTuNgay()));
			pst.setDate(2, Date.valueOf(x.getDenNgay()));
			pst.setString(3, x.getLoaiHopDong());
			pst.setDouble(4,x.getLuongCoBan());
			pst.setString(5, x.getMaHopDong());
			pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	

	

	
	public static ArrayList<HOPDONGLAODONG> getHopDongSapHetHan() {
		Connection con = connection.getConnection();
		try {
			ArrayList<HOPDONGLAODONG> list = new ArrayList<>();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from HOPDONGLAODONG hd join NHANVIEN nv on hd.maHopDong=nv.maHopDong join CONNGUOI cn on cn.CMND=nv.CMND join PHONGBAN pb on pb.maPhong=nv.maPhong where nv.trangThai=1 and DATEDIFF(DAY, GETDATE(), denNgay) < 180 and DATEDIFF(DAY, GETDATE(), denNgay) > 0");
			while (rs.next()) {
				HOPDONGLAODONG x = new HOPDONGLAODONG();
				x.setMaHopDong(rs.getString("maHopDong"));
				x.setTenNhanVien(rs.getString("hoTen"));
				x.setMaNhanVien(rs.getString("maNhanVien"));
				x.setPhongBan(rs.getString("tenPhong"));
				x.setTuNgay(rs.getDate("tuNgay").toLocalDate().plusDays(2));
				x.setDenNgay(rs.getDate("denNgay").toLocalDate().plusDays(2));
				x.setLoaiHopDong(rs.getString("loaiHopDong"));
				x.setLuongCoBan(rs.getDouble("luongCoBan"));
				list.add(x);
			}
			connection.closeConnection(con);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<HOPDONGLAODONG> getHopDongDaHetHan() {
		Connection con = connection.getConnection();
		try {
			ArrayList<HOPDONGLAODONG> list = new ArrayList<>();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from HOPDONGLAODONG hd join NHANVIEN nv on hd.maHopDong=nv.maHopDong join CONNGUOI cn on cn.CMND=nv.CMND join PHONGBAN pb on pb.maPhong=nv.maPhong where nv.trangThai=1 and DATEDIFF(DAY, GETDATE(), denNgay) <= 0");
			while (rs.next()) {
				HOPDONGLAODONG x = new HOPDONGLAODONG();
				x.setMaHopDong(rs.getString("maHopDong"));
				x.setTenNhanVien(rs.getString("hoTen"));
				x.setMaNhanVien(rs.getString("maNhanVien"));
				x.setPhongBan(rs.getString("tenPhong"));
				x.setTuNgay(rs.getDate("tuNgay").toLocalDate().plusDays(2));
				x.setDenNgay(rs.getDate("denNgay").toLocalDate().plusDays(2));
				x.setLoaiHopDong(rs.getString("loaiHopDong"));
				x.setLuongCoBan(rs.getDouble("luongCoBan"));
				list.add(x);
			}
			connection.closeConnection(con);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<HOPDONGLAODONG> getList() {
		Connection con = connection.getConnection();

		try {
			ArrayList<HOPDONGLAODONG> list = new ArrayList<>();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from HOPDONGLAODONG hd \r\n"
					+ "join NHANVIEN nv on hd.maHopDong = nv.maHopDong \r\n"
					+ "join CONNGUOI cn on nv.CMND = cn.CMND\r\n"
					+ "join PHONGBAN pb on nv.maPhong = pb.maPhong where nv.trangThai=1");
			while (rs.next()) {
				HOPDONGLAODONG x = new HOPDONGLAODONG();
				x.setMaHopDong(rs.getString(1));
				x.setMaNhanVien(rs.getString("maNhanVien"));
				x.setTenNhanVien(rs.getString("hoTen"));
				x.setPhongBan(rs.getString("tenPhong"));
				x.setTuNgay(rs.getDate(2).toLocalDate().plusDays(2));
				x.setDenNgay(rs.getDate(3).toLocalDate().plusDays(2));
				x.setLoaiHopDong(rs.getString(4));
				x.setLuongCoBan(rs.getDouble(5));
				list.add(x);
			}
			connection.closeConnection(con);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<HOPDONGLAODONG> getHopDongTheoTenPhong(String tenPhong) {
		Connection con = connection.getConnection();

		try {
			ArrayList<HOPDONGLAODONG> list = new ArrayList<>();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"select * from HOPDONGLAODONG HD join NHANVIEN NV on HD.maHopDong = NV.maHopDong join PHONGBAN PB on NV.maPhong = PB.maPhong where NV.trangThai=1 and PB.tenPhong = N'"
							+ tenPhong + "'");
			while (rs.next()) {
				HOPDONGLAODONG x = new HOPDONGLAODONG();
				x.setMaHopDong(rs.getString(1));
				x.setTuNgay(rs.getDate(2).toLocalDate().plusDays(2));
				x.setDenNgay(rs.getDate(3).toLocalDate().plusDays(2));
				x.setLoaiHopDong(rs.getString(4));
				x.setLuongCoBan(rs.getDouble(5));
				list.add(x);
			}
			connection.closeConnection(con);
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<HOPDONGLAODONG> getHopDongMoiKy() {
		Connection con = connection.getConnection();
		try {
			ArrayList<HOPDONGLAODONG> list = new ArrayList<>();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from HOPDONGLAODONG hd join NHANVIEN nv on hd.maHopDong=nv.maHopDong join CONNGUOI cn on cn.CMND= nv.CMND join PHONGBAN pb on pb.maPhong=nv.maPhong where nv.trangThai=1 and DATEDIFF(DAY, tuNgay, GETDATE()) < 186");
			while (rs.next()) {
				HOPDONGLAODONG x = new HOPDONGLAODONG();
				x.setMaHopDong(rs.getString("maHopDong"));
				x.setTenNhanVien(rs.getString("hoTen"));
				x.setMaNhanVien(rs.getString("maNhanVien"));
				x.setPhongBan(rs.getString("tenPhong"));
				x.setTuNgay(rs.getDate("tuNgay").toLocalDate().plusDays(2));
				x.setDenNgay(rs.getDate("denNgay").toLocalDate().plusDays(2));
				x.setLoaiHopDong(rs.getString("loaiHopDong"));
				x.setLuongCoBan(rs.getDouble("luongCoBan"));
				list.add(x);
			}
			connection.closeConnection(con);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int getSoLuongHopDong(){
		Connection con = connection.getConnection();
		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery("select COUNT(*) from HOPDONGLAODONG hd join NHANVIEN nv on hd.maHopDong=nv.maHopDong where nv.trangThai=1");
			int sum = 0;
			while (rs.next()) {
				sum = rs.getInt(1);
			}
			connection.closeConnection(con);
			return sum;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int getSoLuongHopDongMoiKy(){
		Connection con = connection.getConnection();
		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery("select COUNT(*) from HOPDONGLAODONG hd join NHANVIEN nv on hd.maHopDong=nv.maHopDong where nv.trangThai=1 and DATEDIFF(DAY, tuNgay, GETDATE()) < 180");
			int sum = 0;
			while (rs.next()) {
				sum = rs.getInt(1);
			}
			connection.closeConnection(con);
			return sum;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void updateHopDong(LocalDate denNgay ,String loaiHopDong, String maHopDong) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("update HOPDONGLAODONG set denNgay = ?, loaiHopDong = ? where maHopDong = ?");
			pst.setDate(1, Date.valueOf(denNgay));
			pst.setString(2, loaiHopDong);
			pst.setString(3, maHopDong);
			pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static String getLoaiHopDong(String maHopDong) {
		Connection con = connection.getConnection();
		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery("select * from HOPDONGLAODONG where maHopDong ='" + maHopDong + "'");
			String loaiHopDong = "";
			while (rs.next()) {
				loaiHopDong = (rs.getString(4));
			}
			connection.closeConnection(con);
			return loaiHopDong;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static int getSoLuongHopDongSapHetHan(){
		Connection con = connection.getConnection();
		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery("select COUNT(*) from HOPDONGLAODONG hd join NHANVIEN nv on hd.maHopDong=nv.maHopDong where nv.trangThai=1 and DATEDIFF(DAY, GETDATE(), denNgay) < 180 and DATEDIFF(DAY, GETDATE(), denNgay) > 0");
			int sum = 0;
			while (rs.next()) {
				sum = rs.getInt(1);
			}
			connection.closeConnection(con);
			return sum;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static int getSoLuongHopDongDaHetHan(){
		Connection con = connection.getConnection();
		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery("select COUNT(*) from HOPDONGLAODONG hd join NHANVIEN nv on hd.maHopDong=nv.maHopDong where nv.trangThai=1 and DATEDIFF(DAY, GETDATE(), denNgay) <= 0");
			int sum = 0;
			while (rs.next()) {
				sum = rs.getInt(1);
			}
			connection.closeConnection(con);
			return sum;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static int[] getThongKeTiLeLoaiHopDong() {
		Connection con = connection.getConnection();
		int []data = new int[5];
		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery("select COUNT(*) from HOPDONGLAODONG hd join NHANVIEN nv on hd.maHopDong=nv.maHopDong where nv.trangThai=1 and DATEDIFF(YEAR, tuNgay, denNgay) <=2");
			while (rs.next()) {
				data[0] = rs.getInt(1);
			}
			rs = ps.executeQuery("select COUNT(*) from HOPDONGLAODONG hd join NHANVIEN nv on hd.maHopDong=nv.maHopDong where nv.trangThai=1 and DATEDIFF(YEAR, tuNgay, denNgay) >2 and DATEDIFF(YEAR, tuNgay, denNgay) <=5");
			while (rs.next()) {
				data[1] = rs.getInt(1);
			}
			rs = ps.executeQuery("select COUNT(*) from HOPDONGLAODONG hd join NHANVIEN nv on hd.maHopDong=nv.maHopDong where nv.trangThai=1 and DATEDIFF(YEAR, tuNgay, denNgay) >5 and DATEDIFF(YEAR, tuNgay, denNgay) <=8");
			while (rs.next()) {
				data[2] = rs.getInt(1);
			}
			rs = ps.executeQuery("select COUNT(*) from HOPDONGLAODONG hd join NHANVIEN nv on hd.maHopDong=nv.maHopDong where nv.trangThai=1 and DATEDIFF(YEAR, tuNgay, denNgay) >8 and DATEDIFF(YEAR, tuNgay, denNgay) <=10");
			while (rs.next()) {
				data[3] = rs.getInt(1);
			}
			rs = ps.executeQuery("select COUNT(*) from HOPDONGLAODONG hd join NHANVIEN nv on hd.maHopDong=nv.maHopDong where nv.trangThai=1 and DATEDIFF(YEAR, tuNgay, denNgay) >10");
			while (rs.next()) {
				data[4] = rs.getInt(1);
			}
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static int[] getSoLuongHopDongHetHanVaKiTrongNam(int nam) {
		Connection con = connection.getConnection();
		int []data = new int[2];
		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery("select COUNT(*) from HOPDONGLAODONG where tuNgay like '%"+nam+"%'");
			while (rs.next()) {
				data[0] = rs.getInt(1);
			}
			rs = ps.executeQuery("select COUNT(*) from HOPDONGLAODONG where denNgay like '%"+nam+"%'");
			while (rs.next()) {
				data[1] = rs.getInt(1);
			}
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
}
