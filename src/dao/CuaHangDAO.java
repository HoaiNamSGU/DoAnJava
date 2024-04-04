package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.CuaHang;
import model.Laptop;

public class CuaHangDAO implements DAOInterface<CuaHang>{
	
	public static CuaHangDAO getintance() {
		return new CuaHangDAO();
	}@Override
	public int insert(CuaHang t) {
		// TODO Auto-generated method stub
		return 0;
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
		ArrayList<CuaHang> CH=new ArrayList<CuaHang>();
		try {
			Connection cnt=JDBCUtil.getConnection();
			String sql = "select * from cuahang";
			PreparedStatement pst = cnt.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String MaCH = rs.getString("MaCuaHang");
				String TenCH = rs.getString("TenCH");
				String DiaChi = rs.getString("DiaChi");
				String SDT = rs.getString("SDT");
				CuaHang lt = new CuaHang(MaCH, TenCH, DiaChi, SDT);
				System.out.println(lt.getMaCH());
				CH.add(lt);
			}
			JDBCUtil.closeConnection(cnt);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CH;
	}

	@Override
	public CuaHang selectById(CuaHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CuaHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	
}



