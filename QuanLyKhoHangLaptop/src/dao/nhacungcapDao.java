package duan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Nhacungcap;



public class nhacungcapDao implements DAOInterface<Nhacungcap>{
	public static nhacungcapDao getInstance() {
		return new nhacungcapDao();
	}
	@Override
	public int insert(Nhacungcap t) {
		int ketqua=0;
		try {
			// TODO Auto-generated method stub
//		BƯỚC 1: TẠO KẾT NỐI ĐẾN CSDL
			Connection con=JDBCUtil.getConnection();
			
//		BƯỚC 2: TẠO RA ĐỐI TƯỢNG STATEMENT
			String sql="INSERT INTO nhacungcap(MaNhaCungCap,TenNhaCungCap,DiaChi,SDT,Email)\r\n"
					+ "VALUES (?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,t.getManhacungcap());
			pst.setString(2,t.getTennhacungcap());
			pst.setString(3,t.getDiachi());
			pst.setInt(4,t.getSdt());
			pst.setString(5, t.getEmail());
//		BƯỚC 3: THỰC THI CÂU LỆNH SQL
		ketqua=pst.executeUpdate();
		// BƯỚC 4 XỬ LÝ KẾT QUẢ
		System.out.println("BẠN ĐÃ THỰC THI : "+sql);
		System.out.println("Số dòng thay đổi: "+ketqua);
		if(ketqua>0) System.out.println("Thêm dữ liệu thành công");
		else System.out.println("Thêm dữ liệu thất bại");
		
		
//		BƯỚC 5: NGẮT KẾT NỐI
		JDBCUtil.closeConnection(con);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int update(Nhacungcap t) {
		// TODO Auto-generated method stub
		int ketqua=0;
		try {
			// TODO Auto-generated method stub
//		BƯỚC 1: TẠO KẾT NỐI ĐẾN CSDL
			Connection con=JDBCUtil.getConnection();
			
//		BƯỚC 2: TẠO RA ĐỐI TƯỢNG STATEMENT
			Statement st=con.createStatement();
			String sql="UPDATE nhacungcap"+
					" SET " +
					" MaNhaCungCap='"+ t.getManhacungcap()+"'"+
					", TenNhaCungCap='"+ t.getTennhacungcap()+"'"+
					", DiaChi='"+ t.getDiachi()+"'"+
					", SDT='"+ t.getSdt()+"'"+
					", Email='"+ t.getEmail()+"'"+
					" WHERE MaNhaCungCap='"+ t.getManhacungcap()+"'";
//			PreparedStatement stFind = con.prepareStatement("SELECT ten_nhan_vien FROM nhan_vien WHERE ma_nhan_vien = ?");
//			String sql="INSERT INTO nhacungcap(manhacungcap,tennhacungcap,diachi,sdt,email)\r\n"

//		BƯỚC 3: THỰC THI CÂU LỆNH SQL
		ketqua=st.executeUpdate(sql);
		// BƯỚC 4 XỬ LÝ KẾT QUẢ
		System.out.println("BẠN ĐÃ THỰC THI : "+sql);
		System.out.println("Số dòng thay đổi: "+ketqua);
		if(ketqua>0) System.out.println("Thêm dữ liệu thành công");
		else System.out.println("Thêm dữ liệu thất bại");
		
		
//		BƯỚC 5: NGẮT KẾT NỐI
		JDBCUtil.closeConnection(con);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int delete(Nhacungcap t) {
		// TODO Auto-generated method stub
				int ketqua=0;
				try {
					// TODO Auto-generated method stub
//				BƯỚC 1: TẠO KẾT NỐI ĐẾN CSDL
					Connection con=JDBCUtil.getConnection();
					
//				BƯỚC 2: TẠO RA ĐỐI TƯỢNG STATEMENT
					Statement st=con.createStatement();
					String sql="DELETE from nhacungcap"+
							" WHERE MaNhaCungCap='"+t.getManhacungcap()+"'";
		
//				BƯỚC 3: THỰC THI CÂU LỆNH SQL
				ketqua=st.executeUpdate(sql);
				// BƯỚC 4 XỬ LÝ KẾT QUẢ
				System.out.println("BẠN ĐÃ THỰC THI : "+sql);
				System.out.println("Số dòng thay đổi: "+ketqua);
				if(ketqua>0) System.out.println("Thêm dữ liệu thành công");
				else System.out.println("Thêm dữ liệu thất bại");
				
				
//				BƯỚC 5: NGẮT KẾT NỐI
				JDBCUtil.closeConnection(con);
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ketqua;
	}

	@Override
	public ArrayList<Nhacungcap> selectAll() {
		ArrayList<Nhacungcap> ketqua=new ArrayList<Nhacungcap>();
		try {
//		BƯỚC 1: TẠO KẾT NỐI ĐẾN CSDL
			Connection con=JDBCUtil.getConnection();
//		BƯỚC 2: TẠO RA ĐỐI TƯỢNG STATEMENT
			String sql="SELECT * FROM nhacungcap";
			PreparedStatement pst=con.prepareStatement(sql);
//		BƯỚC 3: THỰC THI CÂU LỆNH SQL
//		System.out.println(sql);
		ResultSet rs=pst.executeQuery(sql);
		// BƯỚC 4 XỬ LÝ KẾT QUẢ
//		String manhacungcap, String tennhacungcap, String diachi, String sdt, String email
		while(rs.next()) {
			String mncc=rs.getString("MaNhaCungCap");
			String tm=rs.getString("TenNhaCungCap");
			String dc=rs.getString("DiaChi");
			int sdt=rs.getInt("SDT");
			String em=rs.getString("Email");
			Nhacungcap sp=new Nhacungcap(mncc,tm,dc,sdt,em);
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
	public Nhacungcap selectById(Nhacungcap t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Nhacungcap> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Nhacungcap selectById(String T) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
}
