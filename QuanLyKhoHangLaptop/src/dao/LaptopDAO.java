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
			String sql = "INSERT INTO laptop (MaLaptop, TenLaptop, CPU, GPU, Ram, Rom, HeDieuHanh, ManHinh, Hang, NamSanXuat, SoLuong, Gia, MaNhaCungCap) "+
						" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			pst.setString(13, t.getMaNhaCungCap());
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
						",MaNhaCungCap=?"+
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
			pst.setString(13, t.getMaNhaCungCap());
			pst.setString(14,t.getMaLaptop());
			ketqua = pst.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
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
			String sql = "select * from laptop where isDelete = 0";
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
				String maNCC = rs.getString("MaNhaCungCap");
				int isDelete = rs.getInt("isDelete");
				Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC,isDelete);
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
				String maNCC = rs.getString("MaNhaCungCap");
				int isDelete = rs.getInt("isDelete");
				kq = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
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
	
	
	public ArrayList<String> getColumn(String ColumnName)
	{
		ArrayList<String> column = new ArrayList<String>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select distinct "+ColumnName+" from laptop";
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
						",MaNhaCungCap=?"+
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
			pst.setString(13, t.getMaNhaCungCap());
			pst.setString(14,maOld);
			
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
		int kq = 0;
		try {
			Connection c = JDBCUtil.getConnection();
			String sql = "update laptop set isDelete = ? where MaLaptop = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, 1);
			pst.setString(2, t);
			kq = pst.executeUpdate();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	
	public ArrayList<Laptop> Select_search(String NameColumn,String conditon) {
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from laptop where "+NameColumn+" like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,conditon);
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
				String maNCC = rs.getString("MaNhaCungCap");
				int isDelete = rs.getInt("isDelete");
				Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
				kq.add(lt);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	public ArrayList<Laptop> Select_search_HDH(String conditon) {
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from laptop where HeDieuHanh like ?";
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
				String maNCC = rs.getString("MaNhaCungCap");
				int isDelete = rs.getInt("isDelete");
				Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
				kq.add(lt);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	public ArrayList<Laptop> Select_search_2Column(String column1, String column2, String conditon1, String condition2)
	{
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		try {
			Connection c = JDBCUtil.getConnection();
			String sql = "select * from laptop where "+column1+" like ? and "+column2+" like ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, "%"+conditon1+"%");
			pst.setString(2, condition2);
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
				String maNCC = rs.getString("MaNhaCungCap");
				int isDelete = rs.getInt("isDelete");
				Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
				kq.add(lt);
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	
	
	public ArrayList<Laptop> Select_search_2Column(String column1, String Gia, String condition1 ,int giaMin, int giaMax)
	{
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		if(giaMin == 0 && giaMax == 10000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setInt(2, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setInt(2, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		else if(giaMin == 10000000 && giaMax == 15000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setInt(2, giaMin);
					pst.setInt(3, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setInt(2, giaMin);
					pst.setInt(3, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		else if(giaMin == 15000000 && giaMax == 20000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setInt(2, giaMin);
					pst.setInt(3, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setInt(2, giaMin);
					pst.setInt(3, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 20000000 && giaMax == 30000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setInt(2, giaMin);
					pst.setInt(3, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setInt(2, giaMin);
					pst.setInt(3, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 30000000 && giaMax == 50000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setInt(2, giaMin);
					pst.setInt(3, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setInt(2, giaMin);
					pst.setInt(3, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 50000000 && giaMax == 0)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+Gia+" >= ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setInt(2, giaMin);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" = ? and "+Gia+" >= ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setInt(2, giaMin);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		return kq;
	}
	
	
	public ArrayList<Laptop> Select_search_3Column(String column1, String column2, String column3, String conditon1, String condition2, String condition3)
	{
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		try {
			Connection c = JDBCUtil.getConnection();
			String sql = "select * from laptop where "+column1+" like ? and "+column2+" like ? and "+column3+" like ? ";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, "%"+conditon1+"%");
			pst.setString(2, condition2);
			pst.setString(3,condition3);
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
				String maNCC = rs.getString("MaNhaCungCap");
				int isDelete = rs.getInt("isDelete");
				Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
				kq.add(lt);
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	
	
	public ArrayList<Laptop> Select_search_3Column(String column1, String column2, String Gia, String condition1, String condition2, int giaMin, int giaMax)
	{
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		if(giaMin == 0 && giaMax == 10000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+" like ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2,condition2);
					pst.setInt(3, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"= ? and "+column2+"= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setInt(3, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		else if(giaMin == 10000000 && giaMax == 15000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+" = ? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setInt(3, giaMin);
					pst.setInt(4, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setInt(3, giaMin);
					pst.setInt(4, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		else if(giaMin == 15000000 && giaMax == 20000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+" = ? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setInt(3, giaMin);
					pst.setInt(4, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setInt(3, giaMin);
					pst.setInt(4, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 20000000 && giaMax == 30000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2,condition2);
					pst.setInt(3, giaMin);
					pst.setInt(4, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+" = ? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setInt(3, giaMin);
					pst.setInt(4, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 30000000 && giaMax == 50000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+" = ? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setInt(3, giaMin);
					pst.setInt(4, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+" = ? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setInt(3, giaMin);
					pst.setInt(4, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 50000000 && giaMax == 0)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+" = ? and "+Gia+" >= ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setInt(3, giaMin);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+" = ? and "+Gia+" >= ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setInt(3, giaMin);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		return kq;
	}
	
	
	
	public ArrayList<Laptop> Select_search_4Column(String column1, String column2, String column3, String Gia, String condition1, String condition2, String conditon3, int giaMin, int giaMax)
	{
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		if(giaMin == 0 && giaMax == 10000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+" like ? and "+column3+"= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2,condition2);
					pst.setString(3,conditon3);
					pst.setInt(4, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"= ? and "+column2+"=? and "+column3+"=? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setInt(4, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		else if(giaMin == 10000000 && giaMax == 15000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+"=? and "+column3+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setInt(4, giaMin);
					pst.setInt(5, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+"=? and "+column3+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setInt(4, giaMin);
					pst.setInt(5, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		else if(giaMin == 15000000 && giaMax == 20000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+"=? and "+column3+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setInt(4, giaMin);
					pst.setInt(5, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+"=? and "+column3+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setInt(4, giaMin);
					pst.setInt(5, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 20000000 && giaMax == 30000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+"=? and "+column3+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2,condition2);
					pst.setString(3, conditon3);
					pst.setInt(4, giaMin);
					pst.setInt(5, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+" =? and "+column3+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setInt(4, giaMin);
					pst.setInt(5, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 30000000 && giaMax == 50000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+" = ? and "+column3+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setInt(4, giaMin);
					pst.setInt(5, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+" = ? and "+column3+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setInt(4, giaMin);
					pst.setInt(5, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 50000000 && giaMax == 0)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+" = ? and "+column3+"=? and "+Gia+" >= ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setInt(4, giaMin);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+" = ? and "+column3+"=? and "+Gia+" >= ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setInt(4, giaMin);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		return kq;
	}
	
	
	public ArrayList<Laptop> Select_search_4Column(String column1, String column2, String column3, String column4, String conditon1, String condition2, String condition3, String condition4)
	{
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		try {
			Connection c = JDBCUtil.getConnection();
			String sql = "select * from laptop where "+column1+" like ? and "+column2+" like ? and "+column3+" like ? and "+column4+"=? ";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, "%"+conditon1+"%");
			pst.setString(2, condition2);
			pst.setString(3,condition3);
			pst.setString(4, condition4);
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
				String maNCC = rs.getString("MaNhaCungCap");
				int isDelete = rs.getInt("isDelete");
				Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
				kq.add(lt);
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	
	public ArrayList<Laptop> Select_search_5Column(String column1, String column2, String column3, String column4, String column5, String conditon1, String condition2, String condition3, String condition4, String condition5)
	{
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		try {
			Connection c = JDBCUtil.getConnection();
			String sql = "select * from laptop where "+column1+" like ? and "+column2+" like ? and "+column3+" like ? and "+column4+"=? and "+column5+"=? ";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, "%"+conditon1+"%");
			pst.setString(2, condition2);
			pst.setString(3,condition3);
			pst.setString(4, condition4);
			pst.setString(5, condition5);
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
				String maNCC = rs.getString("MaNhaCungCap");
				int isDelete = rs.getInt("isDelete");
				Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
				kq.add(lt);
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	
	
	
	
	public ArrayList<Laptop> Select_search_5Column(String column1, String column2, String column3, String column4, String Gia, String condition1, String condition2, String conditon3, String condition4, int giaMin, int giaMax)
	{
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		if(giaMin == 0 && giaMax == 10000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+" like ? and "+column3+"= ? and "+column4+"=? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2,condition2);
					pst.setString(3,conditon3);
					pst.setString(4, condition4);
					pst.setInt(5, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"= ? and "+column2+"=? and "+column3+"=? and "+column4+"=? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setInt(5, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		else if(giaMin == 10000000 && giaMax == 15000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+"=? and "+column3+"=? and "+column4+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setInt(5, giaMin);
					pst.setInt(6, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+"=? and "+column3+"=? and "+column4+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setInt(5, giaMin);
					pst.setInt(6, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		else if(giaMin == 15000000 && giaMax == 20000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+"=? and "+column3+"=? and "+column4+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setInt(5, giaMin);
					pst.setInt(6, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+"=? and "+column3+"=? and "+column4+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setInt(5, giaMin);
					pst.setInt(6, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 20000000 && giaMax == 30000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+"=? and "+column3+"=? and "+column4+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2,condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setInt(5, giaMin);
					pst.setInt(6, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+" =? and "+column3+"=? and "+column4+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4,condition4);
					pst.setInt(5, giaMin);
					pst.setInt(6, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 30000000 && giaMax == 50000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+" = ? and "+column3+"=? and "+column4+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setInt(5, giaMin);
					pst.setInt(6, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+" = ? and "+column3+"=? and "+column4+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setInt(5, giaMin);
					pst.setInt(6, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 50000000 && giaMax == 0)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+" = ? and "+column3+"=? and "+column4+"=? and "+Gia+" >= ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setInt(5, giaMin);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+" = ? and "+column3+"=? and "+column4+"=? and "+Gia+" >= ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setInt(5, giaMin);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		return kq;
	}
	
	
	
	public ArrayList<Laptop> Select_search_6Column(String column1, String column2, String column3, String column4, String column5, String Gia, String condition1, String condition2, String conditon3, String condition4, String condition5, int giaMin, int giaMax)
	{
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		if(giaMin == 0 && giaMax == 10000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+" like ? and "+column3+"= ? and "+column4+"=? and "+column5+"=? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2,condition2);
					pst.setString(3,conditon3);
					pst.setString(4, condition4);
					pst.setString(5, condition5);
					pst.setInt(6, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"= ? and "+column2+"=? and "+column3+"=? and "+column4+"=? and "+column5+"=? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setString(5, condition5);
					pst.setInt(6, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		else if(giaMin == 10000000 && giaMax == 15000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+"=? and "+column3+"=? and "+column4+"=? and "+column5+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setString(5, condition5);
					pst.setInt(6, giaMin);
					pst.setInt(7, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+"=? and "+column3+"=? and "+column4+"=? and "+column5+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setString(5, condition5);
					pst.setInt(6, giaMin);
					pst.setInt(7, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		else if(giaMin == 15000000 && giaMax == 20000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+"=? and "+column3+"=? and "+column4+"=? and "+column5+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setString(5, condition5);
					pst.setInt(6, giaMin);
					pst.setInt(7, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+"=? and "+column3+"=? and "+column4+"=? and "+column5+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setString(5, condition5);
					pst.setInt(6, giaMin);
					pst.setInt(7, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 20000000 && giaMax == 30000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+"=? and "+column3+"=? and "+column4+"=? and "+column5+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2,condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setString(5, condition5);
					pst.setInt(6, giaMin);
					pst.setInt(7, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+" =? and "+column3+"=? and "+column4+"=? and "+column5+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4,condition4);
					pst.setString(5, condition5);
					pst.setInt(6, giaMin);
					pst.setInt(7, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 30000000 && giaMax == 50000000)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+" = ? and "+column3+"=? and "+column4+"=? and "+column5+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setString(5, condition5);
					pst.setInt(6, giaMin);
					pst.setInt(7, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+" = ? and "+column3+"=? and "+column4+"=? and "+column5+"=? and "+Gia+" >= ? and "+Gia+" < ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setString(5, condition5);
					pst.setInt(6, giaMin);
					pst.setInt(7, giaMax);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
		}
		else if(giaMin == 50000000 && giaMax == 0)
		{	
			if(column1.equals("HeDieuHanh"))
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+" like ? and "+column2+" = ? and "+column3+"=? and "+column4+"=? and "+column5+"=? and "+Gia+" >= ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, "%"+condition1+"%");
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setString(5, condition5);
					pst.setInt(6, giaMin);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();} 
					catch (Exception e) {
						e.printStackTrace();
					}
			}
			else 
			{
				try {
					Connection c = JDBCUtil.getConnection();
					String sql = "select * from laptop where "+column1+"=? and "+column2+" = ? and "+column3+"=? and "+column4+"=? and "+column5+"=? and "+Gia+" >= ?";
					PreparedStatement pst = c.prepareStatement(sql);
					pst.setString(1, condition1);
					pst.setString(2, condition2);
					pst.setString(3, conditon3);
					pst.setString(4, condition4);
					pst.setString(5, condition5);
					pst.setInt(6, giaMin);
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
						String maNCC = rs.getString("MaNhaCungCap");
						int isDelete = rs.getInt("isDelete");
						Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
						kq.add(lt);
					}
					c.close();
					} 
					catch (Exception e) {
						e.printStackTrace();
					}	
			}
			
		}
		return kq;
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<Laptop> lt = LaptopDAO.getintance().Select_search_6Column("HeDieuHanh","Hang","CPU","Ram","Rom","Gia","Windows","ASUS","Ryzen, 57535HS","16 GB","512 GB",20000000,30000000);
		for (Laptop laptop : lt) {
			System.out.println(laptop.toString());
		}
	}

	
}




