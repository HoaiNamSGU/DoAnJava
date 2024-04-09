package model;

public class ChiTietPhieuNhap {
	
	private String MaPhieuNhap;
	private String MaLaptop;
	private String SoLuong;
	
	public ChiTietPhieuNhap() {
		
	}

	public ChiTietPhieuNhap(String maPhieuNhap, String maLaptop, String soLuong) {
		MaPhieuNhap = maPhieuNhap;
		MaLaptop = maLaptop;
		SoLuong = soLuong;
	}

	public String getMaPhieuNhap() {
		return MaPhieuNhap;
	}

	public void setMaPhieuNhap(String maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
	}

	public String getMaLaptop() {
		return MaLaptop;
	}

	public void setMaLaptop(String maLaptop) {
		MaLaptop = maLaptop;
	}

	public String getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(String soLuong) {
		SoLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuNhap [MaPhieuNhap=" + MaPhieuNhap + ", MaLaptop=" + MaLaptop + ", SoLuong=" + SoLuong + "]";
	}
	
	
}
