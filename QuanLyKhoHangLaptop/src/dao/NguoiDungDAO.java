package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.NguoiDung;

public class NguoiDungDAO implements DAOInterface<NguoiDung>{

	public static NguoiDungDAO getintance() {
		return new NguoiDungDAO();
	}

	@Override
	public int insert(NguoiDung t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO nguoidung (MaNguoiDung,TaiKhoan,MatKhau,PhamViTruyCap) "+
						" VALUES (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiDung());
			pst.setString(2, t.getTaiKhoan());
			pst.setString(3, t.getMatKhau());
			pst.setInt(4, t.getPhamViTruyCap());
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int update(NguoiDung t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE nguoidung "+
						"SET "+
						"MaNguoiDung=?"+
						",TaiKhoan=? "+
						",MatKhau=? "+
						",PhamViTruyCap=? "+
						",isDelete=? "+
						"WHERE MaLaptop = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiDung());
			pst.setString(2, t.getTaiKhoan());
			pst.setString(3, t.getMatKhau());
			pst.setInt(4,t.getPhamViTruyCap());
			pst.setInt(5, t.getIsDelete());
			pst.setString(6, t.getMaNguoiDung());
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	public int updateByCondition(String MaND, String pass, String newPass) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE nguoidung "+
						"SET "+
						"MatKhau=? "+
						"WHERE MaNguoiDung = ? and MatKhau= ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, newPass);
			pst.setString(2, MaND);
			pst.setString(3, pass);
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	@Override
	public int delete(NguoiDung t) {
		
		return 0;
	}

	@Override
	public int delete(String t) {
		
		return 0;
	}

	@Override
	public ArrayList<NguoiDung> selectAll() {
		ArrayList<NguoiDung> kq = new ArrayList<NguoiDung>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from nguoidung where isDelete = 0 ";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString("MaNguoiDung");
				String tk = rs.getString("TaiKhoan");
				String mk = rs.getString("MatKhau");
				int phamvi = rs.getInt("PhamViTruyCap");
				int isdelete = rs.getInt("isDelete");
				NguoiDung nd = new NguoiDung();
				nd.setMaNguoiDung(ma);
				nd.setTaiKhoan(tk);
				nd.setMatKhau(mk);
				nd.setPhamViTruyCap(phamvi);
				nd.setIsDelete(isdelete);
				kq.add(nd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public NguoiDung selectById(NguoiDung t) {
		
		return null;
	}

	@Override
	public NguoiDung selectById(String T) {
		
		return null;
	}

	@Override
	public ArrayList<NguoiDung> selectByCondition(String condition) {
		return null;
	}
	
	
	public ArrayList<NguoiDung> selectByCondition() {
		ArrayList<NguoiDung> kq = new ArrayList<NguoiDung>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from nguoidung where isDelete = 0 and PhamViTruyCap = 0";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString("MaNguoiDung");
				String tk = rs.getString("TaiKhoan");
				String mk = rs.getString("MatKhau");
				int phamvi = rs.getInt("PhamViTruyCap");
				int isdelete = rs.getInt("isDelete");
				NguoiDung nd = new NguoiDung();
				nd.setMaNguoiDung(ma);
				nd.setTaiKhoan(tk);
				nd.setMatKhau(mk);
				nd.setPhamViTruyCap(phamvi);
				nd.setIsDelete(isdelete);
				kq.add(nd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
	

	public static void main(String[] args) {
		ArrayList<NguoiDung> nd = NguoiDungDAO.getintance().selectByCondition();
		for (NguoiDung nguoiDung : nd) {
			System.out.println(nguoiDung.toString());
		}
	}
}
