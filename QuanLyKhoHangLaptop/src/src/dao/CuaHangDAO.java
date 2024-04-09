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
	public int insert(CuaHang t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO laptop (MaCuaHang, TenCH, DiaChi, SDT) " + " VALUES (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaCH());
			pst.setString(2, t.getTenCH());
			pst.setString(3, t.getDiaChi());
			pst.setString(4, t.getSDT());
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int update(CuaHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(CuaHang t) {
		// TODO Auto-generated method stub
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
			Connection cnt = JDBCUtil.getConnection();
			String sql = "select * from cuahang where MaCuaHang = ?";
			PreparedStatement pst = cnt.prepareStatement(sql);
			pst.setString(1, MaCuaHang);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String MaCH = rs.getString("MaCuaHang");
				String TenCH = rs.getString("TenCH");
				String DiaChi = rs.getString("DiaChi");
				String SDT = rs.getString("SDT");
				CH.Update(MaCH, TenCH, DiaChi, SDT);
			}
			JDBCUtil.closeConnection(cnt);
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
}
