package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.BAOCAOTUYENDUNG;
import DTO.DANHGIA;
import DTO.SUPPORT;
import connection_database.connection;

public class access_BANGDANHGIA {
	
	
	
	public static ArrayList<DANHGIA> getList(){
		ArrayList<DANHGIA> list= new ArrayList<>();
		// Tạo kết nối
 		Connection con = connection.getConnection();
 		Statement st;
 		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select dg.maDanhGia, nv.maNhanVien,cn.hoTen as tenNhanVien,dg.ngayDanhGia ,\r\n"
					+ "dg.nguoiDanhGia ,cn2.hoTen as tenNguoiDanhGia,dg.diemDanhGia,dg.xepLoaiDanhGia,\r\n"
					+ "dg.chiTietDanhGia,dg.loaiDanhGia,dg.ghiChu\r\n"
					+ "from CONNGUOI cn join NHANVIEN nv on cn.CMND = nv.CMND\r\n"
					+ "join BANGDANHGIA dg on dg.maNhanVien = nv.maNhanVien\r\n"
					+ "join NHANVIEN nv2 on dg.nguoiDanhGia=nv2.maNhanVien\r\n"
					+ "join CONNGUOI cn2 on cn2.CMND = nv2.CMND order by dg.ngayDanhGia desc");
			while(rs.next()) {
				DANHGIA x = new DANHGIA();
				x.setMaDanhGia(rs.getString("maDanhGia"));
				x.setMaNhanVien(rs.getString("maNhanVien"));
				x.setMaNguoiDanhGia(rs.getString("nguoiDanhGia"));
				x.setTenNhanVien(rs.getString("tenNhanVien"));
				x.setTenNguoiDanhGia(rs.getString("tenNguoiDanhGia"));
				x.setChiTietDanhGia(rs.getString("chiTietDanhGia"));
				x.setXepLoai(rs.getString("xepLoaiDanhGia"));
				x.setDiemDanhGia(rs.getInt("diemDanhGia"));
				x.setLoaiDanhGia(rs.getString("loaiDanhGia"));
				x.setLyDo(rs.getString("ghiChu"));
				x.setNgayDanhGia(rs.getDate("ngayDanhGia").toLocalDate().plusDays(2));
				x.setLyDo(null);
				list.add(x);
				System.out.println(x.getTenNguoiDanhGia());
			}
			connection.closeConnection(con);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object[][] getListNhanVien() {
		
		// Tạo kết nối
 		Connection con = connection.getConnection();
 		Statement st;
 		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select count(*) from CONNGUOI cn join NHANVIEN nv on cn.CMND=nv.CMND where nv.trangThai=1");
			Object[][] obj = null;
			while(rs.next()) {
				obj = new Object[rs.getInt(1)][];
			}
			rs = st.executeQuery("select * from CONNGUOI cn join NHANVIEN nv on cn.CMND=nv.CMND where nv.trangThai=1");
			int count = 0;
			while(rs.next()) {
				obj[count] = new Object[] {
						count+1+"",rs.getString("maNhanVien")+" - "+rs.getString("hoTen")
				};
				count++;
			}
			connection.closeConnection(con);
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public static boolean insertBangDanhGia(DANHGIA x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("insert BANGDANHGIA values (?,?,?,?,?,?,?,?,?)");
			pst.setString(1, x.getMaDanhGia());
			pst.setString(2, x.getMaNhanVien());
			pst.setString(3, x.getMaNguoiDanhGia());
			pst.setDate(4, Date.valueOf(x.getNgayDanhGia()));
			pst.setInt(5, x.getDiemDanhGia());
			pst.setString(6, x.getXepLoai());
			pst.setString(7, x.getChiTietDanhGia());
			pst.setString(8,x.getLoaiDanhGia());
			pst.setString(9,x.getLyDo());
			pst.executeUpdate();
			connection.closeConnection(con);
			return true;
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("Không thể lưu bảng đánh giá");
			return false;
		}
	}
	public static boolean deleteBangDanhGia(String maDanhGia) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("delete BANGDANHGIA where maDanhGia=?");
			pst.setString(1, maDanhGia);
			pst.executeUpdate();
			connection.closeConnection(con);
			return true;
		} catch (SQLException e) {
			System.out.println("Không thể xóa bảng đánh giá");
			return false;
		}
	}
	
	public static Object[][] getDanhSachDanhGiaTangLuong() {
		Connection con = connection.getConnection();
		try {
			String sql = "select nv.maNhanVien,cn.hoTen,pb.tenPhong, hd.luongCoBan, avg(dg.diemDanhGia) as diem from BANGDANHGIA dg join NHANVIEN nv \r\n"
					+ "	on dg.maNhanVien = nv.maNhanVien\r\n"
					+ "	join CONNGUOI cn on cn.CMND = nv.CMND\r\n"
					+ "	join PHONGBAN pb on nv.maPhong = pb.maPhong\r\n"
					+ "	join HOPDONGLAODONG hd on nv.maHopDong = hd.maHopDong\r\n"
					+ "	where YEAR(dg.ngayDanhGia) = YEAR(GETDATE())\r\n"
					+ "	group by nv.maNhanVien,cn.hoTen, pb.tenPhong, hd.luongCoBan order by diem desc";
//			select nv.maNhanVien,cn.hoTen,pb.tenPhong, hd.luongCoBan, avg(dg.diemDanhGia)
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			Object[][] obj = null;
			int dem=0;
			while(rs.next()) {
				dem++;
			}
			obj = new Object[dem][];
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			int count=0;
			while(rs.next()) {
				String loai = "";
				if(rs.getInt("diem")>=110) {
					loai = "Xuất sắc";
				}else if(rs.getInt("diem")>=90) {
					loai = "Giỏi";
				}else if(rs.getInt("diem")>=70) {
					loai = "Khá";
				}else if(rs.getInt("diem")>=50) {
					loai = "Trung bình";
				}else {
					loai = "Yếu";
				}
				obj[count] = new Object[] {
					count+1+"",rs.getString("maNhanVien")+" - "+rs.getString("hoTen"),rs.getString("tenPhong"),SUPPORT.changeSalaryToFormatString(rs.getDouble("luongCoBan")),rs.getInt("diem")+"",loai	
				};
				count++;
			}
			connection.closeConnection(con);
			return obj;
		} catch (SQLException e) {
			System.out.println("Không thể xóa bảng đánh giá");
			e.printStackTrace();
			return null;
		}
	}
//
}
