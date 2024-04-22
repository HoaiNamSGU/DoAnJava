package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.CuaHang;

public class CuaHangDAO implements DAOInterface<CuaHang> {

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
			Connection cnt = JDBCUtil.getConnection();
			String sql = "select * from cuahang";
			PreparedStatement pst = cnt.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				CH.add(selectById(rs.getString("MaCuaHang")));
			}
			JDBCUtil.closeConnection(cnt);
		} catch (Exception e) {
			System.out.println(e);
		}
		return CH;
	}

	@Override
	public CuaHang selectById(String MaCuaHang) {
		CuaHang CH = new CuaHang();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from cuahang where MaCuaHang = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, MaCuaHang);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String MaCH = rs.getString("MaCuaHang");
				String TenCH = rs.getString("TenCH");
				String DiaChi = rs.getString("DiaChi");
				String SDT = rs.getString("SDT");
				CH.Update(MaCH, TenCH, DiaChi, SDT);
			}
			con.close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return CH;
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

	public Boolean insertCuaHang(CuaHang CH) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO cuahang (MaCuaHang, TenCH, DiaChi, SDT) " + " VALUES (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, CH.getMaCH());
			pst.setString(2, CH.getTenCH());
			pst.setString(3, CH.getDiaChi());
			pst.setString(4, CH.getSDT());
			pst.executeUpdate();
			con.close();
			pst.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// cập nhật
	public Boolean updateCuaHang(String old_MaCH, CuaHang CH) {
		try {
			if (deleteCuaHang(old_MaCH))
				insert(CH);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	// xóa thật :))
	public Boolean deleteCuaHang(String MaCH) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "DELETE FROM cuahang WHERE MaCuaHang = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, MaCH);
			pst.executeUpdate();
			con.close();
			pst.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	// xóa ảo
	public Boolean soft_deleteCuaHang(String MaCH) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE cuahang SET isDeleted = 1 WHERE MaCuaHang = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, MaCH);
			pst.executeUpdate();
			con.close();
			pst.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
