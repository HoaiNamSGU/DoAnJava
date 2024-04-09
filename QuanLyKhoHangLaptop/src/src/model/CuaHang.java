
package model;

public class CuaHang {
	
	private String MaCH;
	private String TenCH;
	private String DiaChi;
	private String SDT;
	
	public CuaHang() {
		
	}

	public CuaHang(String MaCH, String TenCH, String DiaChi, String SDT) {
		this.MaCH = MaCH;
		this.TenCH = TenCH;
		this.DiaChi = DiaChi;
		this.SDT = SDT;
	}

	public String getMaCH() {
		return this.MaCH;
	}

	public void setMaCH(String MaCH) {
		this.MaCH = MaCH;
	}

	public String getTenCH() {
		return this.TenCH;
	}

	public void setTenCH(String TenCH) {
		this.TenCH = TenCH;
	}

	public String getDiaChi() {
		return this.DiaChi;
	}

	public void setDiaChi(String DiaChi) {
		this.DiaChi = DiaChi;
	}

	public String getSDT() {
		return this.SDT;
	}

	public void setSDT(String SDT) {
		this.SDT = SDT;
	}
	public void Update(String MaCH, String TenCH, String DiaChi, String SDT) {
		this.MaCH = MaCH;
		this.TenCH = TenCH;
		this.DiaChi = DiaChi;
		this.SDT = SDT;
	}
	@Override
	public String toString() {
		return "CuaHang [MaCH=" + this.MaCH + ", TenCH=" + this.TenCH + ", DiaChi=" + this.DiaChi + ", SDT="
				+ this.SDT + "]";
	}
		
	
}
