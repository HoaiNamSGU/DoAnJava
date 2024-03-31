package model;

import java.sql.Date;

public class PhieuXuat {
	
	private String MaPhieuXuat;
	private String MaCuaHang;
	private String MaNhanVien;
	private Date NgayXuat;
	private double TongTien;
	
	public PhieuXuat() {
		
	}

	public PhieuXuat(String maPhieuXuat, String maCuaHang, String maNhanVien, Date ngayXuat, double tongTien) {
		super();
		MaPhieuXuat = maPhieuXuat;
		MaCuaHang = maCuaHang;
		MaNhanVien = maNhanVien;
		NgayXuat = ngayXuat;
		TongTien = tongTien;
	}

	public String getMaPhieuXuat() {
		return MaPhieuXuat;
	}

	public void setMaPhieuXuat(String maPhieuXuat) {
		MaPhieuXuat = maPhieuXuat;
	}

	public String getMaCuaHang() {
		return MaCuaHang;
	}

	public void setMaCuaHang(String maCuaHang) {
		MaCuaHang = maCuaHang;
	}

	public String getMaNhanVien() {
		return MaNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}

	public Date getNgayXuat() {
		return NgayXuat;
	}

	public void setNgayXuat(Date ngayXuat) {
		NgayXuat = ngayXuat;
	}

	public double getTongTien() {
		return TongTien;
	}

	public void setTongTien(double tongTien) {
		TongTien = tongTien;
	}

	@Override
	public String toString() {
		return "PhieuXuat [MaPhieuXuat=" + MaPhieuXuat + ", MaCuaHang=" + MaCuaHang + ", MaNhanVien=" + MaNhanVien
				+ ", NgayXuat=" + NgayXuat + ", TongTien=" + TongTien + "]";
	}
	
	
}
