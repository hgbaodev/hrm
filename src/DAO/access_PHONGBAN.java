package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.NHANVIEN;
import DTO.PHONGBAN;
import DTO.SUPPORT;
import connection_database.connection;

public class access_PHONGBAN {
	public static ArrayList<PHONGBAN> getList(){
		ArrayList<PHONGBAN> list = new ArrayList<>();
 		Connection con = connection.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from PHONGBAN order by tenPhong");
			while(rs.next()) {
				PHONGBAN x = new PHONGBAN();
				x.setMaPhong(rs.getString("maPhong"));
				x.setTenPhong(rs.getString("tenPhong"));
				x.setNgayThanhLap(rs.getDate("ngayThanhLap").toLocalDate().plusDays(2));
				if(rs.getString("maTruongPhong")==null) {
					x.setMaTruongPhong("Chưa có");
				}else {
					x.setMaTruongPhong(rs.getString("maTruongPhong"));
				}
				list.add(x);
			}
			connection.closeConnection(con);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String getMaSoTuTen(String tenPhong) {
		Connection con = connection.getConnection();
		try {
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery("select * from PHONGBAN where tenPhong = N'"+tenPhong+"'");
			while(rs.next()) {
				return rs.getString("maPhong");
			}
			connection.closeConnection(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.closeConnection(con);
		return null;
	}
	public static String getTenTuMaSo(String maPhong) {
		Connection con = connection.getConnection();
		try {
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery("select * from PHONGBAN where maPhong = N'"+maPhong+"'");
			while(rs.next()) {
				return rs.getString("tenPhong");
			}
			connection.closeConnection(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.closeConnection(con);
		return null;
	}
	public static int getSoLuongNhanVien(String maPhongBan) {
		Connection con = connection.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select COUNT(maNhanVien) from NHANVIEN where NHANVIEN.trangThai=1 and maPhong = '"+maPhongBan+"'");
			while(rs.next()) {
				return rs.getInt(1);
			}
			connection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	public static double[] getAverageSalaryData(String maPhongBan) {
		double data[] = new double[3];
		Connection con = connection.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select COUNT(maNhanVien), SUM(luongThuViec) , SUM(luongCoBan) from NHANVIEN left join HOPDONGLAODONG on NHANVIEN.maHopDong = HOPDONGLAODONG.maHopDong where maPhong = '"+maPhongBan+"'");
			
			while(rs.next()) {
				data[0] = rs.getInt(1);
				data[1] = rs.getDouble(2);
				data[2] = rs.getDouble(3);
			}
			connection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	public static Object[][] getNhanVienCuaPhongBanData(String maPhong) {
		Object[][] data = null;
		Connection con = connection.getConnection();
		Statement st;
		Statement st1;
		try {
			st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery("select COUNT(maNhanVien) from NHANVIEN where trangThai=1 and maPhong = '"+maPhong+"'");
			while(rs1.next()) {
				data = new Object[rs1.getInt(1)][];
			}
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from CONNGUOI join NHANVIEN on CONNGUOI.CMND = NHANVIEN.CMND join CHUCVU on CHUCVU.maChucVu = NHANVIEN.maChucVu where NHANVIEN.trangThai=1 and maPhong = '"+maPhong+"'");
			int count = 0;
			while(rs.next()) {
				String loaiHinh = "Chính thức";
				if(rs.getString("maHopDong")==null) {
					loaiHinh = "Thử việc";
				}
				data[count] =new String[] {"   "+(count+1),rs.getString("maNhanVien")+" - "+rs.getString("hoTen"),loaiHinh,rs.getString("tenChucVu")};
				count++;
			}
			connection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	public static ArrayList<String> getDanhSachMaSo() {
		ArrayList<String> data = new ArrayList<>();
		Connection con = connection.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from PHONGBAN");
			while(rs.next()) {
				data.add(rs.getString(1));
			}
			connection.closeConnection(con);
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void insertPhongBan(PHONGBAN x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("insert PHONGBAN values(?,?,?,?)");
			pst.setString(1, x.getMaPhong());
			pst.setString(2, x.getTenPhong());
			pst.setDate(3, Date.valueOf(x.getNgayThanhLap()));
			if(x.getMaTruongPhong().equals("Chưa có") || x.getMaTruongPhong().equals("")) {
				pst.setString(4, null);
			}else {
				pst.setString(4, x.getMaTruongPhong());
			}
			int rs = pst.executeUpdate();
			
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void deletePhongBan(String maSo) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("delete PHONGBAN where maPhong = ?");
			pst.setString(1, maSo);
			int rs = pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void updatePhongBan(PHONGBAN x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("update PHONGBAN set tenPhong = ?, ngayThanhLap = ?, maTruongPhong = ? where maPhong = ?");
			pst.setString(1, x.getTenPhong());
			pst.setDate(2, Date.valueOf(x.getNgayThanhLap()));
			if(x.getMaTruongPhong().equals("Chưa có") || x.getMaTruongPhong().equals("")) {
				pst.setString(3, null);
			}else {
				pst.setString(3, x.getMaTruongPhong());
			}
			pst.setString(4, x.getMaPhong());
			int rs = pst.executeUpdate();
			
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<Object[]> getDuLieuChucVuThongKe(String maPhong) {
		Connection con = connection.getConnection();
		
		try {
			PreparedStatement pst = con.prepareStatement("select top 5 cv.tenChucVu,count(nv.maNhanVien) sl from CHUCVU cv join NHANVIEN nv on nv.maChucVu = cv.maChucVu join PHONGBAN pb on nv.maPhong = pb.maPhong where nv.trangThai=1 and pb.maPhong = ? group by cv.tenChucVu order by sl desc");
			pst.setString(1, maPhong);
			ResultSet rs = pst.executeQuery();
			int count = 0;
			Object [][] data = new Object[5][];
			while(rs.next()) {
				data[count] = new Object[] {rs.getString(1),rs.getInt(2)};
				count++;
			}
			ArrayList<Object[]> list = new ArrayList<>();
			for(int i=0;i<count;i++) {
				list.add(data[i]);
			}
			connection.closeConnection(con);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static int[] getDuLieuGioiTinhThongKe(String maPhong) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("select cn.gioiTinh, count(nv.maNhanVien) from NHANVIEN nv join CONNGUOI cn on nv.CMND = cn.CMND join PHONGBAN pb on nv.maPhong = pb.maPhong where nv.trangThai=1 and  pb.maPhong = ? group by cn.gioiTinh");
			pst.setString(1, maPhong);
			ResultSet rs = pst.executeQuery();
			Object[][] data = new Object[2][];
			int count= 0;
			while(rs.next()) {
				data[count] = new Object[] {rs.getString(1),rs.getInt(2)};
				count++;
			}
			
			connection.closeConnection(con);
			if(count==2) {
				if(((String)data[0][0]).equals("Nam")) {
					return new int[] {(int)data[0][1],(int)data[1][1]};
				}else {
					return new int[] {(int)data[1][1],(int)data[0][1]};
				}
			}else if(count==1) {
				if(((String)data[0][0]).equals("Nam")) {
					return new int[] {(int)data[0][1],0};
				}else {
					return new int[] {0,(int)data[0][1]};
				}
			}else {
				return new int[] {0,0};
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static int[] getDuLieuDoTuoiThongKe(String maPhong) {
		Connection con = connection.getConnection();
		int data[] = new int[4];
		try {
			int count = 0;
			PreparedStatement pst = con.prepareStatement("select COUNT(maNhanVien)  from NHANVIEN join CONNGUOI on CONNGUOI.CMND = NHANVIEN.CMND  where DATEDIFF(YEAR,CONNGUOI.ngaySinh,GETDATE())>=16 and DATEDIFF(YEAR,CONNGUOI.ngaySinh,GETDATE())<=25  and NHANVIEN.trangThai=1 and maPhong='"+maPhong+"'");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				data[0] = rs.getInt(1);
				if(data[0]>0)	count++;
			}
			pst = con.prepareStatement("select COUNT(maNhanVien)  from NHANVIEN join CONNGUOI on CONNGUOI.CMND = NHANVIEN.CMND  where DATEDIFF(YEAR,CONNGUOI.ngaySinh,GETDATE())>25 and DATEDIFF(YEAR,CONNGUOI.ngaySinh,GETDATE())<=40 and NHANVIEN.trangThai=1 and maPhong='"+maPhong+"'");
			rs = pst.executeQuery();
			while(rs.next()) {
				data[1] = rs.getInt(1);
				if(data[1]>0)	count++;
			}
			pst = con.prepareStatement("select COUNT(maNhanVien)  from NHANVIEN join CONNGUOI on CONNGUOI.CMND = NHANVIEN.CMND  where DATEDIFF(YEAR,CONNGUOI.ngaySinh,GETDATE())>40 and DATEDIFF(YEAR,CONNGUOI.ngaySinh,GETDATE())<=55 and NHANVIEN.trangThai=1 and maPhong='"+maPhong+"'");
			rs = pst.executeQuery();
			while(rs.next()) {
				data[2] = rs.getInt(1);
				if(data[2]>0)	count++;
			}
			pst = con.prepareStatement("select COUNT(maNhanVien)  from NHANVIEN join CONNGUOI on CONNGUOI.CMND = NHANVIEN.CMND  where DATEDIFF(YEAR,CONNGUOI.ngaySinh,GETDATE())>55 and DATEDIFF(YEAR,CONNGUOI.ngaySinh,GETDATE())<=65 and NHANVIEN.trangThai=1 and maPhong='"+maPhong+"'");
			rs = pst.executeQuery();
			while(rs.next()) {
				data[3] = rs.getInt(1);
				if(data[3]>0)	count++;
			}
			connection.closeConnection(con);
			if(count<4) {
				int data2[] = new int[count];
				int k = 0;
				for(int i=0;i<4;i++) {
					if(data[i]>0) {
						data2[k] = data[i];
						k++;
					}
				}
				return data2;
			}
			
			return data;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<Object[]> getDanhSachTenVaSoLuongNhanVienPhongBan() {
		Connection con = connection.getConnection();
		
				try {
					PreparedStatement pst = con.prepareStatement("select top 5 pb.tenPhong, count(maNhanVien) sl from PHONGBAN pb join NHANVIEN nv on pb.maPhong = nv.maPhong where nv.trangThai=1 group by pb.maPhong, pb.tenPhong order by sl desc");
					ResultSet rs = pst.executeQuery();
					int count = 0;
					Object [][] data = new Object[5][];
					while(rs.next()) {
						data[count] = new Object[] {rs.getString(1),rs.getInt(2)};
						count++;
					}
					ArrayList<Object[]> list = new ArrayList<>();
					for(int i=0;i<count;i++) {
						list.add(data[i]);
					}
					if(count==5) {
						list.add(new Object[] {"Các phòng khác",2});
					}
					connection.closeConnection(con);
					return list;
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return null;
	}
	public static String[] getDanhSachPhongBan() {
		String data[] = null;
		Connection con = connection.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs  = st.executeQuery("select COUNT(maPhong) from PHONGBAN");
			while(rs.next()) {
				data = new String[rs.getInt(1)];
			}
			rs = st.executeQuery("select * from PHONGBAN order by maPhong");
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
}
