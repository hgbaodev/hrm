 package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.TAIKHOAN;
import connection_database.connection;

public class access_TAIKHOAN {
	
	public static void insertTAIKHOAN(TAIKHOAN x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("insert TAIKHOAN values(?,?,?,?)");
			pst.setString(1, x.getUsername());
			pst.setString(2, x.getPass());
			pst.setString(3, x.getMaNhomQuyen());
			pst.setString(4, x.getAvatarImg());
			
			pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateTAIKHOAN(TAIKHOAN x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("update TAIKHOAN set pass = ? , maNhomQuyen = ? , avatar = ? where username = ?");
			
			pst.setString(1, x.getPass());
			pst.setString(2, x.getMaNhomQuyen());
			pst.setString(3, x.getAvatarImg());
			
			pst.setString(4, x.getUsername());
			pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static TAIKHOAN getTAIKHOAN(String username) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("select * from TAIKHOAN where username = ?");
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			TAIKHOAN x = null;
			while(rs.next()) {
				x = new TAIKHOAN(rs.getString("username"), rs.getString("pass"), rs.getString("maNhomQuyen"), rs.getString("avatar"));
			}
			connection.closeConnection(con);
			return x;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String getAvatar(String username) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("select avatar from TAIKHOAN where username = ?");
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			String x = "";
			while(rs.next()) {
				x = rs.getString(1);
			}
			connection.closeConnection(con);
			return x;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<TAIKHOAN> getList() {
		ArrayList<TAIKHOAN> list = new ArrayList<>();
		Connection con = connection.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs  = st.executeQuery("select * from TAIKHOAN join NHANVIEN on NHANVIEN.maNhanVien=TAIKHOAN.username ");
			//where NHANVIEN.trangThai=1
			while(rs.next()) {
				
				TAIKHOAN x = new TAIKHOAN(rs.getString("username"),rs.getString("pass"),rs.getString("maNhomQuyen"), rs.getString("avatar"));
				list.add(x);
			}
			connection.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static Object[][] getObjectToRender() {
		Connection con = connection.getConnection();
		ArrayList<Object[]> list = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select nv.maNhanVien, cn.hoTen ,tk.username, tk.pass, tk.maNhomQuyen  from CONNGUOI cn join NHANVIEN nv on cn.CMND = nv.CMND join CHUCVU cv on nv.maChucVu = cv.maChucVu join TAIKHOAN tk on nv.maNhanVien = tk.username where nv.trangThai=1");
			int count = 0;
			while(rs.next()) {
				
				Object[] ob = new Object[] {count+1+"", rs.getString("maNhanVien")+" - "+rs.getString("hoTen"),rs.getString("maNhomQuyen")};
				
				list.add(ob);
				count++;
			}
			Object[][] object = new Object[list.size()][];
			for(int i=0;i<list.size();i++) {
				object[i] = list.get(i);
			}
			con.close();
			return object;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Object[][] getObjectToRender(String tenPhong) {
		Connection con = connection.getConnection();
		ArrayList<Object[]> list = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			String sql = "select nv.maNhanVien, cn.hoTen ,cv.tenChucVu ,tk.username, tk.pass, tk.maNhomQuyen from CONNGUOI cn join NHANVIEN nv on cn.CMND = nv.CMND \r\n"
					+ "join CHUCVU cv on nv.maChucVu = cv.maChucVu \r\n"
					+ "join TAIKHOAN tk on nv.maNhanVien = tk.username\r\n"
					+ "join PHONGBAN pb on nv.maPhong = pb.maPhong where nv.trangThai=1 ";
			
			if(!tenPhong.equalsIgnoreCase("Phòng ban")) {
				sql+="and pb.tenPhong = N'"+tenPhong+"'";
			}
			
			ResultSet rs = st.executeQuery(sql);
			int count = 0;
			while(rs.next()) {
				
				Object[] ob = new Object[] {count+1+"", rs.getString("maNhanVien")+" - "+rs.getString("hoTen"),rs.getString("maNhomQuyen")};
				
				list.add(ob);
				count++;
			}
			Object[][] object = new Object[list.size()][];
			for(int i=0;i<list.size();i++) {
				object[i] = list.get(i);
			}
			con.close();
			return object;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String[] getDanhSachEmailVaUsername() {
		String data[] = null;
		Connection con = connection.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs  = st.executeQuery("select count(maNhanVien) from CONNGUOI cn join NHANVIEN nv on cn.CMND = nv.CMND where nv.trangThai=1");
			while(rs.next()) {
				data = new String[rs.getInt(1)*2];
			}
			rs = st.executeQuery("select * from CONNGUOI cn join NHANVIEN nv on cn.CMND = nv.CMND where nv.trangThai=1");
			int count =0;
			while(rs.next()) {
				data[count] = rs.getString("email");
				data[count+1] = rs.getString("maNhanVien");
				count+=2;
			}
			connection.closeConnection(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	public static String getEmail(String username) {
		Connection con = connection.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs  = st.executeQuery("select cn.email from CONNGUOI cn join NHANVIEN nv on cn.CMND = nv.CMND where nv.maNhanVien = '"+username+"'");
			String email = "";
			while(rs.next()) {
				email = rs.getString("email");
			}
			connection.closeConnection(con);
			return email;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String getUsername(String email) {
		Connection con = connection.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs  = st.executeQuery("select tk.username from CONNGUOI cn join NHANVIEN nv on cn.CMND = nv.CMND join TAIKHOAN tk on tk.username=nv.maNhanVien where cn.email = N'"+email+"'");
			String user = "";
			while(rs.next()) {
				user = rs.getString(1);
			}
			connection.closeConnection(con);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void updatePassword(String username,  String pass) {
		Connection con = connection.getConnection();
		String sql = "update TAIKHOAN set pass=? where username=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, pass);
			pst.setString(2, username);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void UpdateQuyenTaiKhoan(String username, String maNhomQuyen) {
		Connection con = connection.getConnection();
		String sql = "update TAIKHOAN set maNhomQuyen=? where username=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, maNhomQuyen);
			pst.setString(2, username);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
