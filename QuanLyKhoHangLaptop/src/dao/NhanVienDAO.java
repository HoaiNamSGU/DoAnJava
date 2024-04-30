package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import database.JDBCUtil;
import model.NguoiDung;
import model.NhanVien;
public class NhanVienDAO implements DAOInterface<NhanVien>{
	
	public static NhanVienDAO getintance()
	{
		return new NhanVienDAO();
	}
	
	
	@Override
	public int insert(NhanVien t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "insert into nhanvien (MaNhanVien,TenNhanVien,NgaySinh,GioiTinh,SDT,MaNguoiDung) "+
						"values(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setNString(1, t.getMaNhanVien());
			pst.setString(2, t.getTenNhanVien());
			pst.setDate(3, t.getNgaySinh());
			pst.setInt(4, t.getGioiTinh());
			pst.setString(5, t.getSDT());
			pst.setString(6, t.getMaNguoiDung());
			kq = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int update(NhanVien t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(NhanVien t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<NhanVien> selectAll() {
		ArrayList<NhanVien> kq = new ArrayList<NhanVien>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from nhanvien where isDelete = 0";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString("MaNhanVien");
				String ten = rs.getString("TenNhanVien");
				Date ngaysinh = rs.getDate("NgaySinh");
				int gioitinh = rs.getInt("GioiTinh");
				String sdt = rs.getString("SDT");
				String MaND = rs.getString("MaNguoiDung");
				int isdelete = rs.getInt("isDelete");
				NhanVien nv = new NhanVien();
				nv.setMaNhanVien(ma);
				nv.setTenNhanVien(ten);
				nv.setNgaySinh(ngaysinh);
				nv.setGioiTinh(gioitinh);
				nv.setSDT(sdt);
				nv.setMaNguoiDung(MaND);
				nv.setIsDelete(isdelete);
				kq.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public NhanVien selectById(NhanVien t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhanVien selectById(String T) {
		NhanVien nv = new NhanVien();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from nhanvien where MaNhanVien like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,T);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString("MaNhanVien");
				String ten = rs.getString("TenNhanVien");
				Date ngaysinh = rs.getDate("NgaySinh");
				int gioitinh = rs.getInt("GioiTinh");
				String sdt = rs.getString("SDT");
				String MaND = rs.getString("MaNguoiDung");
				int isdelete = rs.getInt("isDelete");
				nv.setMaNhanVien(ma);
				nv.setTenNhanVien(ten);
				nv.setNgaySinh(ngaysinh);
				nv.setGioiTinh(gioitinh);
				nv.setSDT(sdt);
				nv.setMaNguoiDung(MaND);
				nv.setIsDelete(isdelete);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}

	public NhanVien selectByCondition(String nameColumn, String conditon) {
		NhanVien nv = new NhanVien();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from nhanvien where "+nameColumn+" like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,conditon);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString("MaNhanVien");
				String ten = rs.getString("TenNhanVien");
				Date ngaysinh = rs.getDate("NgaySinh");
				int gioitinh = rs.getInt("GioiTinh");
				String sdt = rs.getString("SDT");
				String MaND = rs.getString("MaNguoiDung");
				int isdelete = rs.getInt("isDelete");
				nv.setMaNhanVien(ma);
				nv.setTenNhanVien(ten);
				nv.setNgaySinh(ngaysinh);
				nv.setGioiTinh(gioitinh);
				nv.setSDT(sdt);
				nv.setMaNguoiDung(MaND);
				nv.setIsDelete(isdelete);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}
	
	public ArrayList<String> getColumn(String ColumnName)
	{
		ArrayList<String> column = new ArrayList<String>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select distinct "+ColumnName+" from nhanvien";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				column.add(rs.getString(ColumnName));
			}
			
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return column; 
	}
	
	
	public ArrayList<NhanVien> selectByCondition(ArrayList<NguoiDung> nd) {
		ArrayList<NhanVien> arr = NhanVienDAO.getintance().selectAll();
		ArrayList<NhanVien> nv = new ArrayList<NhanVien>();
		for (NhanVien nhanVien : arr) {
			for (NguoiDung nguoidung : nd) {
				if(nhanVien.getMaNguoiDung().equals(nguoidung.getMaNguoiDung()))
				{
					nv.add(nhanVien);
				}
			}
		}
		return nv;
	}
	
	
	@Override
	public ArrayList<NhanVien> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		ArrayList<String> arr = NhanVienDAO.getintance().getColumn("MaNhanVien");
		for (String string : arr) {
			System.out.println(string);
		}
	}
}
