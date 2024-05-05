package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import database.JDBCUtil;
import model.NguoiDung;
import model.NhanVien;
public class NhanVienDAO implements DAOInterface<NhanVien>{

	public static NhanVienDAO getintance()
	{
		return new NhanVienDAO();
	}


public String laymanhanvien(String manhanv) {
		String s=null;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="SELECT * FROM nhanvien WHERE  TenNhanVien='" + manhanv + "'";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery(sql);
			while(rs.next()) {
				s=rs.getString("MaNhanVien");
			}
			JDBCUtil.closeConnection(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public ArrayList<String> Layalltennv() {
		ArrayList<String> ketqua=new ArrayList<String>();
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="SELECT TenNhanVien FROM nhanvien";
			PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery(sql);
		while(rs.next()) {
			String tnv=rs.getString("TenNhanVien");
			ketqua.add(tnv);
		}
//		BƯỚC 5: NGẮT KẾT NỐI
		JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public String laytennhanvien(String manhanv) {
		String s=null;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="SELECT * FROM nhanvien WHERE  MaNhanVien='" + manhanv + "'";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery(sql);
			while(rs.next()) {
				s=rs.getString("TenNhanVien");
			}
			JDBCUtil.closeConnection(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
	public ArrayList<NhanVien> ReadExcelKetHop(String filePath)
	{
		ArrayList<NhanVien> arr = new ArrayList<NhanVien>();
		if(filePath.endsWith(".xlsx"))
		{
			FileInputStream fis = null;
	        Workbook workbook = null;
	         try {
	             fis = new FileInputStream(filePath);
	             workbook = WorkbookFactory.create(fis);

	             Sheet sheet = workbook.getSheetAt(0);
	             int count = 0;
	             for (Row row : sheet) {
	                 if (count == 0) {
	                     count++;
	                     continue;
	                 }
	                 String ma = row.getCell(0).getStringCellValue();
	                 String ten = row.getCell(1).getStringCellValue();
	                 String ngaysinh = row.getCell(2).getStringCellValue();
	                 String gioitinh = row.getCell(3).getStringCellValue();
	                 String SDT = row.getCell(4).getStringCellValue();
	                 String mand = row.getCell(5).getStringCellValue();
	                 int isDelete = 0;
	                 NhanVien nv = new NhanVien();
	                 nv.setMaNhanVien(ma);
	                 nv.setTenNhanVien(ten);
	                 nv.setNgaySinh(ngaysinh);
	                 if(gioitinh.equals("nam"))
	                 {
	                	 nv.setGioiTinh(1);
	                 }
	                 else if(gioitinh.equals("nữ"))
	                 {
	                	 nv.setGioiTinh(0);
	                 }
	                 nv.setSDT(SDT);
	                 nv.setMaNguoiDung(mand);
	                 nv.setIsDelete(isDelete);
	                 arr.add(nv);

	             }
	             workbook.close();
	             fis.close();

	         } catch (Exception e) {
	             e.printStackTrace();
	         }
		}
		return arr;
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
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE nhanvien "+
						"SET "+
						"MaNhanVien=?"+
						",TenNhanVien=? "+
						",NgaySinh=? "+
						",GioiTinh=? "+
						",SDT=? "+
						",MaNguoiDung=? "+
						",isDelete=? "+
						"WHERE MaNhanVien = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaNhanVien());
			pst.setString(2, t.getTenNhanVien());
			pst.setDate(3, t.getNgaySinh());
			pst.setInt(4,t.getGioiTinh());
			pst.setString(5, t.getSDT());
			pst.setString(8,t.getMaNhanVien());
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	public int updateBoMaVaMaNDvaDL(NhanVien t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE nhanvien "+
						"SET "+
						"TenNhanVien=? "+
						",NgaySinh=? "+
						",GioiTinh=? "+
						",SDT=? "+
						"WHERE MaNhanVien = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getTenNhanVien());
			pst.setDate(2, t.getNgaySinh());
			pst.setInt(3,t.getGioiTinh());
			pst.setString(4, t.getSDT());
			pst.setString(5,t.getMaNhanVien());
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	@Override
	public int delete(NhanVien t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE nhanvien "+
						"SET "+
						"isDelete=1 "+
						"WHERE MaNhanVien = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,t.getMaNhanVien());
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int delete(String t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE nhanvien "+
						"SET "+
						"isDelete=1 "+
						"WHERE MaNhanVien = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,t);
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
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
			JDBCUtil.closeConnection(con);
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
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}

	public NhanVien selectByCondition(String nameColumn, String conditon) {
		NhanVien nv = new NhanVien();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from nhanvien where "+nameColumn+" like ? and isDelete=0";
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
			JDBCUtil.closeConnection(con);
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
	
	
	public ArrayList<NhanVien> select_search(String s)
	{	
		ArrayList<NhanVien> arr = NhanVienDAO.getintance().selectAll();
		ArrayList<NguoiDung> nd = NguoiDungDAO.getintance().selectAll();
		
		s = s.toUpperCase();
		ArrayList<NhanVien> kq = new ArrayList<NhanVien>();
		for (NhanVien nhanVien : arr) {
			String tmp = nhanVien.getMaNhanVien()+nhanVien.getTenNhanVien()+nhanVien.getSDT()+nhanVien.getNgaySinh()+"";
			if(nhanVien.getGioiTinh()==1)
			{
				tmp = tmp+"nam";
			}
			else if(nhanVien.getGioiTinh()==0)
			{
				tmp = tmp+"nữ";
			}
			tmp = tmp.toUpperCase();
			if (tmp.indexOf(s) != -1 ) {
				for(NguoiDung nguoidung : nd)
				{
					if(nhanVien.getMaNguoiDung().equals(nguoidung.getMaNguoiDung()) && nguoidung.getPhamViTruyCap()==0)
						
					{
						kq.add(nhanVien);
					}
				}
			}
		}
		return kq;
	}
	
	
	public ArrayList<NhanVien> select_nhanvienThuong()
	{
		ArrayList<NguoiDung> nd = NguoiDungDAO.getintance().select_search("");
		ArrayList<NhanVien> arr = new ArrayList<NhanVien>();
		for(int i=0;i<nd.size();i++)
		{
			NhanVien nv = NhanVienDAO.getintance().selectByCondition("MaNguoiDung",nd.get(i).getMaNguoiDung());
			arr.add(nv);
		}
		return arr;
	}
	
	public ArrayList<NhanVien> select_search(String name1, String name2)
	{
		int gt = -1;
		if(name2.equals("nam"))
		{
			gt = 1;
		}
		else if(name2.equals("nữ"))
		{
			gt = 0;
		}
		ArrayList<NhanVien> kq = new ArrayList<NhanVien>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql;
	
			if(name1.equals("Tất cả")&&name2.equals("Tất cả"))
			{
				kq = NhanVienDAO.getintance().select_nhanvienThuong();
				return kq;
			}
			else if(!name1.equals("Tất cả")&&!name2.equals("Tất cả"))
			{
				sql = "select* from nhanvien where MaNguoiDung like ? and GioiTinh=?";
			}
			else
			{
				sql = "select* from nhanvien where MaNguoiDung like ? or GioiTinh=? ";
				
			}
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, name1);
			pst.setInt(2, gt);
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
				ArrayList<NguoiDung> nd = NguoiDungDAO.getintance().selectAll();
				for (NguoiDung ngd : nd) {
					if(nv.getMaNguoiDung().equals(ngd.getMaNguoiDung())&&ngd.getPhamViTruyCap()==0 &&ngd.getIsDelete()==0)
					{
						kq.add(nv);
					}
				}
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	
	public static void main(String[] args) {
		ArrayList<NhanVien> nv = NhanVienDAO.getintance().select_nhanvienThuong();
		for (NhanVien nhanVien : nv) {
			System.out.println(nhanVien.toString());
		}
	}
}
