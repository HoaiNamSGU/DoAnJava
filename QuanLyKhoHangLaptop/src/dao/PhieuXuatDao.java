package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

import database.JDBCUtil;
import model.ChiTietPhieuNhap;
import model.ChiTietPhieuXuat;
import model.PhieuNhap;
//public PhieuXuat(String maPhieuXuat, String maCuaHang, String maNhanVien, Date ngayXuat, double tongTien, int isDelete) {
import model.PhieuXuat;

public class PhieuXuatDao implements DAOInterface<PhieuXuat>{
	public static PhieuXuatDao getInstance() {
		return new PhieuXuatDao();
	}
	
	public void inchitietphieu(ChiTietPhieuXuat t) {
		try {
//			public ChiTietPhieuXuat(String maPhieuXuat, String maLaptop, int soLuong, Double thanhTien, int isDelete) {

			Connection con=JDBCUtil.getConnection();
//			System.out.println(t.toString());
			String sql="INSERT INTO chitietphieuxuat(MaPhieuXuat,MaLapTop,SoLuong,ThanhTien,isDelete)\r\n"
					+ "VALUES (?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,t.getMaPhieuXuat());
			pst.setString(2,t.getMaLaptop());
			pst.setLong(3,t.getSoLuong());
			pst.setDouble(4,t.getThanhTien());
			pst.setLong(5, t.getIsDelete());
		pst.executeUpdate();
		JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(PhieuXuat t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="INSERT INTO phieuxuat(MaPhieuXuat,MaCuaHang,TongTien,NgayXuat,MaNhanVien,isDelete)\r\n"
					+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,t.getMaPhieuXuat());
			pst.setString(2,t.getMaCuaHang());
			pst.setDouble(3,t.getTongTien());
			pst.setDate(4,t.getNgayXuat());
			pst.setString(5, t.getMaNhanVien());
			pst.setLong(6, t.getIsDelete());
		ketqua=pst.executeUpdate();
		// BƯỚC 4 XỬ LÝ KẾT QUẢ
		System.out.println("BẠN ĐÃ THỰC THI : "+sql);
		System.out.println("Số dòng thay đổi: "+ketqua);
		if(ketqua>0) System.out.println("Thêm dữ liệu thành công");
		else System.out.println("Thêm dữ liệu thất bại");
		JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	
	
	@Override
	public int update(PhieuXuat t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(PhieuXuat t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deletetheoma(String masp) {
		try {
			Connection con=JDBCUtil.getConnection();
			Statement st=con.createStatement();
			Statement st1=con.createStatement();
			String sql="UPDATE phieuxuat"+
					" SET " +
					" isDelete='"+1+""+"'"+
					" WHERE MaPhieuXuat='"+ masp+"'";
			String sql1="UPDATE chitietphieuxuat"+
					" SET " +
					" isDelete='"+1+""+"'"+
					" WHERE MaPhieuXuat='"+ masp+"'";
		st.executeUpdate(sql);
		st1.execute(sql1);
		JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void inchitietphieu(ChiTietPhieuNhap t) {
		try {
			Connection con=JDBCUtil.getConnection();
//			System.out.println(t.toString());
			String sql="INSERT INTO chitietphieuxuat(MaPhieuXuat,MaLaptop,SoLuong,ThanhTien,isDelete)\r\n"
					+ "VALUES (?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,t.getMaPhieuNhap());
			pst.setString(2,t.getMaLaptop());
			pst.setString(3,t.getSoLuong());
			pst.setDouble(4,t.getThanhTien());
			pst.setLong(5, t.getIsDelete());
		pst.executeUpdate();
		JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<ChiTietPhieuXuat> laydulieutuphieu(String masp) {
		ArrayList<ChiTietPhieuXuat> ketqua=new ArrayList<ChiTietPhieuXuat>();
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="SELECT * FROM chitietphieuxuat WHERE  MaPhieuXuat = '"+masp+"'";
			PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery(sql);
		while(rs.next()) {
			String mpn=rs.getString("MaPhieuXuat");
		String masanp=rs.getString("MaLaptop");
		int tt=rs.getInt("SoLuong");
		double mnv=rs.getDouble("ThanhTien");
  	int xoa=rs.getInt("isDelete");
//	public ChiTietPhieuXuat(String maPhieuXuat, String maLaptop, int soLuong, Double thanhTien, int isDelete) {

    ChiTietPhieuXuat ahh=new ChiTietPhieuXuat(mpn,masanp,tt,mnv,xoa) ;
			ketqua.add(ahh);
		}
//		BƯỚC 5: NGẮT KẾT NỐI
		JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}
	
	@Override
	public ArrayList<PhieuXuat> selectAll() {
		ArrayList<PhieuXuat> ketqua=new ArrayList<PhieuXuat>();
//String maPhieuXuat,String maCuaHang,String maNhanVien,Date ngayXuat,double tongTien, int isDelete) {
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="SELECT * FROM phieuxuat WHERE  isDelete = 0";
			PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery(sql);
		while(rs.next()) {
			String mpn=rs.getString("MaPhieuXuat");
			String mncc=rs.getString("MaCuaHang");
			String tt=rs.getString("TongTien");
			  Date nn = rs.getDate("NgayXuat");
			String mnv=rs.getString("MaNhanVien");
			String xoa=rs.getString("isDelete");
			DecimalFormat df2 = new DecimalFormat("#");
		     String formattedNumber2 = df2.format(Double.parseDouble(tt));
		     PhieuXuat sp=new PhieuXuat(mpn, mncc,mnv,nn,Double.parseDouble(formattedNumber2),0) ;
			ketqua.add(sp);
		}
//		BƯỚC 5: NGẮT KẾT NỐI
		JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public PhieuXuat selectById(PhieuXuat t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhieuXuat selectById(String T) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PhieuXuat> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
