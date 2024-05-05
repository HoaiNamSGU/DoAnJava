package model;

public class IMEI {
	private String IMEI;
	private String MaPhieuNhap;
	private int isDelete;
	public IMEI()
	{
	}
	public IMEI(String iMEI, String maPhieuNhap, int isDelete) {
		super();
		IMEI = iMEI;
		MaPhieuNhap = maPhieuNhap;
		this.isDelete = isDelete;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getMaPhieuNhap() {
		return MaPhieuNhap;
	}
	public void setMaPhieuNhap(String maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "IMEI [IMEI=" + IMEI + ", MaPhieuNhap=" + MaPhieuNhap + ", isDelete=" + isDelete + "]";
	}
	
}
