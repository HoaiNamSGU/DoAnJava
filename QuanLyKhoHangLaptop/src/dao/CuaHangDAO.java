package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.CuaHang;

public class CuaHangDAO implements DAOInterface<CuaHang> {
	private Connection con = JDBCUtil.getConnection();

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public static CuaHangDAO getintance() {
		return new CuaHangDAO();
	}

	@Override
	public int insert(CuaHang CH) {
		return 0;
	}

	@Override
	public int update(CuaHang CH) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(CuaHang CH) {
		return 0;
	}

	@Override
	public ArrayList<CuaHang> selectAll() {
		ArrayList<CuaHang> CH = new ArrayList<CuaHang>();
		try {

			String sql = "select * from cuahang";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				CH.add(selectById(rs.getString("MaCuaHang")));
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			System.out.println(e);
		}
		return CH;
	}

	@Override
	public CuaHang selectById(String MaCuaHang) {
		try {
			String sql = "SELECT * FROM cuahang WHERE MaCuaHang = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, MaCuaHang);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String MaCH = rs.getString("MaCuaHang");
				String TenCH = rs.getString("TenCH");
				String DiaChi = rs.getString("DiaChi");
				String SDT = rs.getString("SDT");
				int isDelete = rs.getInt("isDelete");
				return new CuaHang(MaCH, TenCH, DiaChi, SDT, isDelete);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null; // Trả về null nếu không có kết quả
	}

	@Override
	public ArrayList<CuaHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CuaHang selectById(CuaHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Boolean isMaCHExists(String MaCH) {

		return selectById(MaCH) != null;
	}

	public Boolean insertCuaHang(CuaHang CH) {
		try {

			String sql = "INSERT INTO cuahang (MaCuaHang, TenCH, DiaChi, SDT) " + " VALUES (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, CH.getMaCH());
			pst.setString(2, CH.getTenCH());
			pst.setString(3, CH.getDiaChi());
			pst.setString(4, CH.getSDT());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// cập nhật
	/*
	 * public Boolean updateCuaHang(String old_MaCH, CuaHang CH) { try { if
	 * (deleteCuaHang(old_MaCH)) insert(CH); return true; } catch (Exception e) { //
	 * TODO: handle exception return false; } }
	 */
	public Boolean updateCuaHang(String old_MaCH, CuaHang CH) {
		try {

			String sql = "UPDATE cuahang SET MaCuaHang=?, TenCH=?, DiaChi=?, SDT=?, isDelete=?  WHERE MaCuaHang = ? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, CH.getMaCH());
			pst.setString(2, CH.getTenCH());
			pst.setString(3, CH.getDiaChi());
			pst.setString(4, CH.getSDT());
			pst.setInt(5, CH.getIsDelete());
			pst.setString(6, old_MaCH);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// xóa thật :))
	public Boolean deleteCuaHang(String MaCH) {
		try {

			String sql = "DELETE FROM cuahang WHERE MaCuaHang = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, MaCH);
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	// xóa ảo
	public Boolean soft_deleteCuaHang(String MaCH) {
		try {

			String sql = "UPDATE cuahang SET isDelete = 1 WHERE MaCuaHang = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, MaCH);
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// khôi phục cửa hàng đã xóa
	public Boolean restoreCuaHang(String MaCH) {
		try {

			String sql = "UPDATE cuahang SET isDelete = 0 WHERE MaCuaHang = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, MaCH);
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// tìm kiếm đựa trên điều kiện cột và điều kiện chuỗi cần tìm
	public ArrayList<CuaHang> Select_search(String NameColumn, String condition) {
	    ArrayList<CuaHang> kq = new ArrayList<CuaHang>();
	    try {
	        String sql;
	        PreparedStatement pst;
	        if (NameColumn.equals("*")) {
	            sql = "SELECT * FROM cuahang WHERE MaCuaHang LIKE ? OR TenCH LIKE ? OR DiaChi LIKE ? OR SDT LIKE ?";
	            pst = con.prepareStatement(sql);
	            for (int i = 1; i <= 4; i++) {
	                pst.setString(i, "%" + condition + "%");
	            }
	        } else {
	            sql = "SELECT * FROM cuahang WHERE " + NameColumn + " LIKE ?";
	            pst = con.prepareStatement(sql);
	            pst.setString(1, "%" + condition + "%");
	        }
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	            String MaCH = rs.getString("MaCuaHang");
	            String TenCH = rs.getString("TenCH");
	            String DiaChi = rs.getString("DiaChi");
	            String SDT = rs.getString("SDT");
	            int isDelete = rs.getInt("isDelete");
	            CuaHang CH = new CuaHang(MaCH, TenCH, DiaChi, SDT, isDelete);
	            kq.add(CH);
	        }
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return kq;
	}


	// tìm kiếm dựa trên 2 điều kiện địa chỉ
	public ArrayList<CuaHang> advancedSearch(String condition1, String condition2) {
		ArrayList<CuaHang> kq = new ArrayList<CuaHang>();
		try {
			String sql = "SELECT * FROM cuahang WHERE DiaChi LIKE ? AND DiaChi LIKE ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%" + condition1 + "%");
			pst.setString(2, "%" + condition2 + "%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String MaCH = rs.getString("MaCuaHang");
				String TenCH = rs.getString("TenCH");
				String DiaChi = rs.getString("DiaChi");
				String SDT = rs.getString("SDT");
				int isDelete = rs.getInt("isDelete");
				CuaHang CH = new CuaHang(MaCH, TenCH, DiaChi, SDT, isDelete);
				kq.add(CH);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

}
