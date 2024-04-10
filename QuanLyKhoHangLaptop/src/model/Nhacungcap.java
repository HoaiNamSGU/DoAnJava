package duan;
public class Nhacungcap {
//	"Mã NCC","Tên nhà cung cấp","Số điện thoại", "Địa chỉ"
	private String manhacungcap,tennhacungcap,diachi,email;
	private int sdt;
	public Nhacungcap(String manhacungcap, String tennhacungcap, String diachi, int sdt, String email) {
		super();
		this.manhacungcap = manhacungcap;
		this.tennhacungcap = tennhacungcap;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
	}
	
	public Nhacungcap() {
		this.manhacungcap="";
		this.tennhacungcap="";
		this.diachi="";
		this.sdt=0;
		this.email="";
	}

	public String getManhacungcap() {
		return manhacungcap;
	}

	public void setManhacungcap(String manhacungcap) {
		this.manhacungcap = manhacungcap;
	}

	public String getTennhacungcap() {
		return tennhacungcap;
	}

	public void setTennhacungcap(String tennhacungcap) {
		this.tennhacungcap = tennhacungcap;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return manhacungcap+", "+tennhacungcap+", "+diachi+", "+sdt+", "+email;
	}
	
	
}
