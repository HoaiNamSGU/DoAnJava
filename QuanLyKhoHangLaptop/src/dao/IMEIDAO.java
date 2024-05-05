package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import database.JDBCUtil;
import model.IMEI;


public class IMEIDAO implements DAOInterface<IMEI>{

	public static IMEIDAO getintance() {
		return new IMEIDAO();
	}
	
	@Override
	public int insert(IMEI t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "insert into IMEI (IMEI,MaPhieuNhap,isDelete) "+
						"values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getIMEI());
			pst.setString(2, t.getMaPhieuNhap());
			pst.setInt(3, t.getIsDelete());
			kq = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int update(IMEI t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(IMEI t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<IMEI> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMEI selectById(IMEI t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMEI selectById(String T) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<IMEI> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void insert(ArrayList<IMEI> arr , String MaPhieuNhap)
	{
		
	}
	
	
	
	
	public void InsertALL(String maphieunhap, int SoLuongSP)
	{
		ArrayList<String> arrMa = generateUniqueCodes(SoLuongSP,20);
		for(int i=0;i<SoLuongSP;i++)
		{
			IMEI imei = new IMEI();
			imei.setIMEI(arrMa.get(i));
			imei.setMaPhieuNhap(maphieunhap);
			imei.setIsDelete(0);
			insert(imei);
		}
	}
	
	
	public static ArrayList<String> generateUniqueCodes(int count, int length) {
        ArrayList<String> uniqueCodes = new ArrayList<>();
        Random random = new Random();

        while (uniqueCodes.size() < count) {
            StringBuilder codeBuilder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                // Random một ký tự từ '0' đến '9' hoặc từ 'a' đến 'z'
                char randomChar = (char) (random.nextInt(26) + 'a');
                if (random.nextBoolean()) { // 50% khả năng chọn số hoặc chữ cái
                    randomChar = (char) (random.nextInt(10) + '0');
                }
                codeBuilder.append(randomChar);
            }
            String code = codeBuilder.toString();
            if (!uniqueCodes.contains(code)) { // Kiểm tra mã đã tồn tại chưa
                uniqueCodes.add(code);
            }
        }

        return uniqueCodes;
    }
	
	
	public int KTIMEI(String imei)
	{
		int kq = 0 ;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select* from imei where IMEI like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, imei);
			ResultSet rs = pst.executeQuery(); 
	        if (rs.next()) { 
	            kq = 1; 
	        }
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	
	public static void main(String[] args) {
		/*try {
			IMEIDAO.getintance().InsertALL("PN4",10 );
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		int t = IMEIDAO.getintance().KTIMEI("isaa8hidsy7s4lksm77x");
		System.out.println(t);
		
	}
}
