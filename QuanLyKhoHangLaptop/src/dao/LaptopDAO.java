package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Laptop;

public class LaptopDAO implements DAOInterface<Laptop>{

	public static LaptopDAO getintance() {
		return new LaptopDAO();
	}

	@Override
	public int insert(Laptop t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO laptop (MaLaptop, TenLaptop, CPU, GPU, Ram, Rom, HeDieuHanh, ManHinh, Hang, NamSanXuat, SoLuong, Gia ) "+
						" VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaLaptop());
			pst.setString(2, t.getTenLaptop());
			pst.setString(3, t.getCPU());
			pst.setString(4, t.getGPU());
			pst.setString(5, t.getRam());
			pst.setString(6, t.getRom());
			pst.setString(7, t.getHeDieuHanh());
			pst.setString(8, t.getManHinh());
			pst.setString(9, t.getHang());
			pst.setInt(10, t.getNamSanXuat());
			pst.setInt(11, t.getSoLuong());
			pst.setDouble(12, t.getGia());
			
			ketqua = pst.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int update(Laptop t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE laptop "+
						"SET "+
						"MaLaptop=? "+
						",TenLaptop=? "+
						",CPU=? "+
						",GPU=? "+
						",Ram=? "+
						",Rom=? "+
						",HeDieuHanh=? "+
						",ManHinh=? "+
						",Hang=? "+
						",NamSanXuat=? "+
						",SoLuong=? "+
						",Gia=? "+ 
						"WHERE MaLaptop = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaLaptop());
			pst.setString(2, t.getTenLaptop());
			pst.setString(3, t.getCPU());
			pst.setString(4, t.getGPU());
			pst.setString(5, t.getRam());
			pst.setString(6, t.getRom());
			pst.setString(7, t.getHeDieuHanh());
			pst.setString(8, t.getManHinh());
			pst.setString(9, t.getHang());
			pst.setInt(10, t.getNamSanXuat());
			pst.setInt(11, t.getSoLuong());
			pst.setDouble(12, t.getGia());
			pst.setString(13,t.getMaLaptop());
			
			ketqua = pst.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int delete(Laptop t) {
		int kq = 0;
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "DELETE FROM Laptop "+
						"WHERE MaLapTop = ?";
			PreparedStatement pts = c.prepareStatement(sql);
			pts.setString(1, t.getMaLaptop());
			kq = pts.executeUpdate();
			
			JDBCUtil.closeConnection(c);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	@Override
	public ArrayList<Laptop> selectAll() {
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from laptop";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString("MaLaptop");
				String ten = rs.getString("TenLaptop");
				String cpu = rs.getString("CPU");
				String gpu = rs.getString("GPU");
				String ram = rs.getString("Ram");
				String rom = rs.getString("Rom");
				String hdh = rs.getString("HeDieuHanh");
				String man = rs.getString("ManHinh");
				String hang = rs.getString("Hang");
				int namsx = rs.getInt("NamSanXuat");
				int soluong = rs.getInt("SoLuong");
				double gia = rs.getDouble("Gia");
				Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia);
				kq.add(lt);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public Laptop selectById(Laptop t) {
		
		Laptop kq  = new Laptop();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from laptop where MaLaptop = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaLaptop());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String ma = rs.getString("MaLaptop");
				String ten = rs.getString("TenLaptop");
				String cpu = rs.getString("CPU");
				String gpu = rs.getString("GPU");
				String ram = rs.getString("Ram");
				String rom = rs.getString("Rom");
				String hdh = rs.getString("HeDieuHanh");
				String man = rs.getString("ManHinh");
				String hang = rs.getString("Hang");
				int namsx = rs.getInt("NamSanXuat");
				int soluong = rs.getInt("SoLuong");
				double gia = rs.getDouble("Gia");
				kq = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public ArrayList<Laptop> selectByCondition(String condition) {
		
		return null;
	}
	
	
	public ArrayList<String> getColumn_0()
	{
		ArrayList<String> column = new ArrayList<String>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select MaLaptop from laptop";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				column.add(rs.getString("MaLaptop"));
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return column; 
	}
	
	
	public int updateALL(Laptop t, String maOld) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE laptop "+
						"SET "+
						"MaLaptop=? "+
						",TenLaptop=? "+
						",CPU=? "+
						",GPU=? "+
						",Ram=? "+
						",Rom=? "+
						",HeDieuHanh=? "+
						",ManHinh=? "+
						",Hang=? "+
						",NamSanXuat=? "+
						",SoLuong=? "+
						",Gia=? "+ 
						"WHERE MaLaptop = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaLaptop());
			pst.setString(2, t.getTenLaptop());
			pst.setString(3, t.getCPU());
			pst.setString(4, t.getGPU());
			pst.setString(5, t.getRam());
			pst.setString(6, t.getRom());
			pst.setString(7, t.getHeDieuHanh());
			pst.setString(8, t.getManHinh());
			pst.setString(9, t.getHang());
			pst.setInt(10, t.getNamSanXuat());
			pst.setInt(11, t.getSoLuong());
			pst.setDouble(12, t.getGia());
			pst.setString(13,maOld);
			
			ketqua = pst.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	
	
	@Override
	public Laptop selectById(String T) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

		public int update1dulieu(String mm,long sl) {
		// TODO Auto-generated method stub
				int ketqua=0;
				try {
					// TODO Auto-generated method stub
//				BƯỚC 1: TẠO KẾT NỐI ĐẾN CSDL
					Connection con=JDBCUtil.getConnection();
					
//				BƯỚC 2: TẠO RA ĐỐI TƯỢNG STATEMENT
					Statement st=con.createStatement();
					String sql1 = "SELECT soluong FROM laptop WHERE id='" + mm + "'";
					String sql = "UPDATE laptop " +
				             " SET SoLuong = soluong + " + sl +
				             " WHERE MaLaptop = '" + mm + "'";

				
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
	
	public ArrayList<Laptop> Select_search(String NameColumn,String conditon) {
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from laptop where "+NameColumn+" like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,"%"+conditon+"%");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString("MaLaptop");
				String ten = rs.getString("TenLaptop");
				String cpu = rs.getString("CPU");
				String gpu = rs.getString("GPU");
				String ram = rs.getString("Ram");
				String rom = rs.getString("Rom");
				String hdh = rs.getString("HeDieuHanh");
				String man = rs.getString("ManHinh");
				String hang = rs.getString("Hang");
				int namsx = rs.getInt("NamSanXuat");
				int soluong = rs.getInt("SoLuong");
				double gia = rs.getDouble("Gia");
				Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia);
				kq.add(lt);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Laptop> arr = LaptopDAO.getintance().Select_search("MaLaptop","aS");
		for (Laptop laptop : arr) {
			System.out.println(laptop.toString());
		}
	}

	
}



