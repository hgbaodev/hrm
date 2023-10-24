package DAO;

import java.util.ArrayList;

import DTO.BANGCHAMCONG;
import connection_database.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jhin
 */
public class access_BANGCHAMCONG {

    // Lay danh sach bang cham cong
    public static ArrayList<BANGCHAMCONG> getList() {
        Connection conn = connection.getConnection();

        try {
            ArrayList<BANGCHAMCONG> list = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from BANGCHAMCONG");

            while (rs.next()) {
                BANGCHAMCONG temp = new BANGCHAMCONG();

                temp.setMaBangChamCong(rs.getString("maBangChamCong"));
                temp.setMaNV(rs.getString("maNhanVien"));
                temp.setThangChamCong(Integer.parseInt(rs.getString("thangChamCong")));
                temp.setNamChamCong(Integer.parseInt(rs.getString("namChamCong")));
                temp.setSoNgayLamViec(Integer.parseInt(rs.getString("soNgayLamViec")));
                temp.setSoNgayNghi(Integer.parseInt(rs.getString("soNgayNghi")));
                temp.setSoNgayTre(Integer.parseInt(rs.getString("soNgayTre")));
                temp.setSoGioLamThem(Integer.parseInt(rs.getString("soGioLamThem")));
                temp.setChiTiet(rs.getString("chiTiet"));
                list.add(temp);
            }

            connection.closeConnection(conn);
            return list;
        } catch (SQLException e) {
        }
        return null;
    }


    // Delete bảng chấm công theo mã
    public static void xoaBangChamCongTheoMa(String maBCC) {
        Connection con = connection.getConnection();

        try {
            PreparedStatement pst = con.prepareStatement("delete BANGCHAMCONG where BANGCHAMCONG.maBangChamCong = ?");
            pst.setString(1, maBCC);
            pst.executeUpdate();

            System.out.println(1);
            connection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* --------------------------------------------------------------------------------------------------- */
    // Lay BangChamCong tu ma BCC
    public static BANGCHAMCONG getBangChamCongTuMa(String maBCC) {
        Connection con = connection.getConnection();

        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("select * from BANGCHAMCONG where BANGCHAMCONG.maBangChamCong = N'" + maBCC + "'");
            while (rs.next()) {
                BANGCHAMCONG x = new BANGCHAMCONG();

                x.setMaBangChamCong(rs.getString("maBangChamCong"));
                x.setMaNV(rs.getString("maNhanVien"));
                x.setThangChamCong(rs.getInt("thangChamCong"));
                x.setNamChamCong(rs.getInt("namChamCong"));
                x.setSoNgayLamViec(rs.getInt("soNgayLamViec"));
                x.setSoNgayNghi(rs.getInt("soNgayNghi"));
                x.setSoNgayTre(rs.getInt("soNgayTre"));
                x.setSoGioLamThem(rs.getInt("soGioLamThem"));
                x.setChiTiet(rs.getString("chiTiet"));
                connection.closeConnection(con);
                return x;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    // Lay ten nhan vien render
    public static String getTen(String maBangChamCong) {
        Connection con = connection.getConnection();

        try {
            String ten = "";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from BANGCHAMCONG join NHANVIEN on NHANVIEN.maNhanVien = BANGCHAMCONG.maNhanVien join CONNGUOI on CONNGUOI.CMND = NHANVIEN.CMND where BANGCHAMCONG.maBangChamCong = '" + maBangChamCong + "' ");

            while (rs.next()) {
                ten = rs.getString("maNhanVien") + " - " + rs.getString("hoTen");
            }

            connection.closeConnection(con);
            return ten;
        } catch (SQLException e) {
        }
        return null;
    }

    // Lay ma PB tu ten PB
    public static String getMaPBTuTen(String ten) {
        Connection con = connection.getConnection();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select maPhong from PHONGBAN where tenPhong = N'" + ten + "'");

            while (rs.next()) {
                return rs.getString("maPhong");
            }

            connection.closeConnection(con);
        } catch (SQLException e) {
        }

        connection.closeConnection(con);
        return null;
    }

    // Lay BCC tu ma phong
    public static ArrayList<BANGCHAMCONG> getBangChamCongTheoMaPhong(String maPhong) {
        Connection con = connection.getConnection();

        try {
            ArrayList<BANGCHAMCONG> list = new ArrayList<>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select * from BANGCHAMCONG BCC join NHANVIEN NV on BCC.maNhanVien = NV.maNhanVien join PHONGBAN PB on NV.maPhong = PB.maPhong where PB.maPhong = '" + maPhong + "'");

            while (rs.next()) {
                BANGCHAMCONG x = new BANGCHAMCONG();
                x.setMaBangChamCong(rs.getString("maBangChamCong"));
                x.setMaNV(rs.getString("maNhanVien"));
                x.setThangChamCong(rs.getInt("thangChamCong"));
                x.setNamChamCong(rs.getInt("namChamCong"));
                x.setSoNgayLamViec(rs.getInt("soNgayLamViec"));
                x.setSoNgayNghi(rs.getInt("soNgayNghi"));
                x.setSoNgayTre(rs.getInt("soNgayTre"));
                x.setSoGioLamThem(rs.getInt("soGioLamThem"));
                x.setChiTiet(rs.getString("chiTiet"));
                list.add(x);
            }

            connection.closeConnection(con);
            return list;

        } catch (SQLException e) {
        }
        return null;
    }
    public static ArrayList<BANGCHAMCONG> getBangChamCongTheoMaNhanVien(String maNhanVien) {
        Connection con = connection.getConnection();

        try {
            ArrayList<BANGCHAMCONG> list = new ArrayList<>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select * from BANGCHAMCONG BCC join NHANVIEN NV on BCC.maNhanVien = NV.maNhanVien join PHONGBAN PB on NV.maPhong = PB.maPhong where NV.maNhanVien = '" + maNhanVien + "'");

            while (rs.next()) {
                BANGCHAMCONG x = new BANGCHAMCONG();
                x.setMaBangChamCong(rs.getString("maBangChamCong"));
                x.setMaNV(rs.getString("maNhanVien"));
                x.setThangChamCong(rs.getInt("thangChamCong"));
                x.setNamChamCong(rs.getInt("namChamCong"));
                x.setSoNgayLamViec(rs.getInt("soNgayLamViec"));
                x.setSoNgayNghi(rs.getInt("soNgayNghi"));
                x.setSoNgayTre(rs.getInt("soNgayTre"));
                x.setSoGioLamThem(rs.getInt("soGioLamThem"));
                x.setChiTiet(rs.getString("chiTiet"));
                list.add(x);
            }

            connection.closeConnection(con);
            return list;

        } catch (SQLException e) {
        }
        return null;
    }
    public static void themBangChamCongDatabase(String maBCC, String maNV, int thang, int nam, int soNgayLam, int soNgayNghi, int soNGayTre, int soGioLamThem, String chiTiet) {
        Connection con = connection.getConnection();

        try {
            PreparedStatement pst = con.prepareStatement("insert BANGCHAMCONG values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, maBCC);
            pst.setString(2, maNV);
            pst.setInt(3, thang);
            pst.setInt(4, nam );
            pst.setInt(5, soNgayLam );
            pst.setInt(6, soNgayNghi );
            pst.setInt(7, soNGayTre );
            pst.setInt(8, soGioLamThem );
            pst.setString(9, chiTiet+ "");
            int rs = pst.executeUpdate();

            connection.closeConnection(con);
        } catch (SQLException e) {
        }
    }
    public static void insertBCC(BANGCHAMCONG bcc) {
        Connection con = connection.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("insert BANGCHAMCONG values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, bcc.getMaBangChamCong());
            pst.setString(2, bcc.getMaNV());
            pst.setInt(3, bcc.getThangChamCong());
            pst.setInt(4, bcc.getNamChamCong() );
            pst.setInt(5, bcc.getSoNgayLamViec() );
            pst.setInt(6, bcc.getSoNgayNghi() );
            pst.setInt(7, bcc.getSoNgayTre() );
            pst.setInt(8, bcc.getSoGioLamThem());
            pst.setString(9, bcc.getChiTiet());
            int rs = pst.executeUpdate();

            connection.closeConnection(con);
        } catch (SQLException e) {
        }
    }
    public static void updateBANGCHAMCONG(BANGCHAMCONG x) {
		Connection con = connection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("update BANGCHAMCONG set soNgayLamViec = ?, soNgayNghi = ?, soNgayTre = ?, soGioLamThem = ?,chiTiet = ? where maBangChamCong = ? ");
			pst.setInt(1, x.getSoNgayLamViec());
			pst.setInt(2, x.getSoNgayNghi());
			pst.setInt(3, x.getSoNgayTre());
			pst.setInt(4, x.getSoGioLamThem());
			pst.setString(5, x.getChiTiet());
			pst.setString(6, x.getMaBangChamCong());
			pst.executeUpdate();
			connection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
