package model;

import java.sql.Date;

public class NhanVien {

	private String MaNhanVien;
	private String TenNhanVien;
	private Date NgaySinh;
	private int GioiTinh;
	private String DiaChi;
	private String SDT;
	private String Email;
	private String MaNguoiDung;
	
	public NhanVien() {
		
	};

	public NhanVien(String maNhanVien, String tenNhanVien, Date ngaySinh, int gioiTinh, String diaChi, String sDT,
			String email, String maNguoiDung) {
		super();
		MaNhanVien = maNhanVien;
		TenNhanVien = tenNhanVien;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		DiaChi = diaChi;
		SDT = sDT;
		Email = email;
		MaNguoiDung = maNguoiDung;
	}

	public String getMaNhanVien() {
		return MaNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return TenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public int getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMaNguoiDung() {
		return MaNguoiDung;
	}

	public void setMaNguoiDung(String maNguoiDung) {
		MaNguoiDung = maNguoiDung;
	}

	@Override
	public String toString() {
		return "NhanVien [MaNhanVien=" + MaNhanVien + ", TenNhanVien=" + TenNhanVien + ", NgaySinh=" + NgaySinh
				+ ", GioiTinh=" + GioiTinh + ", DiaChi=" + DiaChi + ", SDT=" + SDT + ", Email=" + Email
				+ ", MaNguoiDung=" + MaNguoiDung + "]";
	}
	
	
}
