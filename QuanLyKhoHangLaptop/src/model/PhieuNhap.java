package model;

import java.sql.Date;

public class PhieuNhap {

	private String MaPhieuNhap;
	private String MaNhaCungCap;
	private String MaNhanVien;
	private double TongTien;
	private Date NgayNhap;
	
	public PhieuNhap() {
		
	};

	public PhieuNhap(String maPhieuNhap, String maNhaCungCap, String maNhanVien, double tongTien, Date ngayNhap) {
		MaPhieuNhap = maPhieuNhap;
		MaNhaCungCap = maNhaCungCap;
		MaNhanVien = maNhanVien;
		TongTien = tongTien;
		NgayNhap = ngayNhap;
	}

	public String getMaPhieuNhap() {
		return MaPhieuNhap;
	}

	public void setMaPhieuNhap(String maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
	}

	public String getMaNhaCungCap() {
		return MaNhaCungCap;
	}

	public void setMaNhaCungCap(String maNhaCungCap) {
		MaNhaCungCap = maNhaCungCap;
	}

	public String getMaNhanVien() {
		return MaNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}

	public double getTongTien() {
		return TongTien;
	}

	public void setTongTien(double tongTien) {
		TongTien = tongTien;
	}

	public Date getNgayNhap() {
		return NgayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}

	@Override
	public String toString() {
		return "PhieuNhap [MaPhieuNhap=" + MaPhieuNhap + ", MaNhaCungCap=" + MaNhaCungCap + ", MaNhanVien=" + MaNhanVien
				+ ", TongTien=" + TongTien + ", NgayNhap=" + NgayNhap + "]";
	};
	
	
}
