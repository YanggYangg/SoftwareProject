package tuan02_16_qlyNhanVien_entity;

public class NhanVien {
	private int maNV;
	private String hoNV;
	private String tenNV;
	private int tuoi;
	private boolean phai;
	private double tienLuong;
	private PhongBan pBan;
	
	public NhanVien(int maNV, String hoNV, String tenNV, int tuoi, boolean phai, double tienLuong, PhongBan pBan) {
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.tuoi = tuoi;
		this.phai = phai;
		this.tienLuong = tienLuong;
		this.pBan = pBan;
	}

	public NhanVien(int maNV) {
		this.maNV = maNV;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public String getHoNV() {
		return hoNV;
	}

	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public boolean isPhai() {
		return phai;
	}

	public void setPhai(boolean phai) {
		this.phai = phai;
	}

	public double getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
	}

	public PhongBan getpBan() {
		return pBan;
	}

	public void setpBan(PhongBan pBan) {
		this.pBan = pBan;
	}

	
}