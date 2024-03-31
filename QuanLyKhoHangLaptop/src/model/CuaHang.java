package model;

public class CuaHang {
	
	private String MaCuaHang;
	private String TenCuaHang;
	private String DiaChi;
	private String Email;
	
	public CuaHang() {
		
	}

	public CuaHang(String maCuaHang, String tenCuaHang, String diaChi, String email) {
		MaCuaHang = maCuaHang;
		TenCuaHang = tenCuaHang;
		DiaChi = diaChi;
		Email = email;
	}

	public String getMaCuaHang() {
		return MaCuaHang;
	}

	public void setMaCuaHang(String maCuaHang) {
		MaCuaHang = maCuaHang;
	}

	public String getTenCuaHang() {
		return TenCuaHang;
	}

	public void setTenCuaHang(String tenCuaHang) {
		TenCuaHang = tenCuaHang;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "CuaHang [MaCuaHang=" + MaCuaHang + ", TenCuaHang=" + TenCuaHang + ", DiaChi=" + DiaChi + ", Email="
				+ Email + "]";
	}
		
	
}
