package model;

public class ChiTietPhieuXuat {

	private String MaPhieuXuat;
	private String MaLaptop;
	private int SoLuong;
	
	public ChiTietPhieuXuat() {
		
	}

	public ChiTietPhieuXuat(String maPhieuXuat, String maLaptop, int soLuong) {
		super();
		MaPhieuXuat = maPhieuXuat;
		MaLaptop = maLaptop;
		SoLuong = soLuong;
	}

	public String getMaPhieuXuat() {
		return MaPhieuXuat;
	}

	public void setMaPhieuXuat(String maPhieuXuat) {
		MaPhieuXuat = maPhieuXuat;
	}

	public String getMaLaptop() {
		return MaLaptop;
	}

	public void setMaLaptop(String maLaptop) {
		MaLaptop = maLaptop;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuXuat [MaPhieuXuat=" + MaPhieuXuat + ", MaLaptop=" + MaLaptop + ", SoLuong=" + SoLuong + "]";
	}
	
	
}
