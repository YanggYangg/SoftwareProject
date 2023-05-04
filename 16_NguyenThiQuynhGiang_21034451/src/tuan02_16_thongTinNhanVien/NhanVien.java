package tuan02_16_thongTinNhanVien;

public class NhanVien {
	private String maNV;
	private String ho;
	private String ten;
	private String gt;
	private int tuoi;
	private double luong;
	
	public NhanVien(String maNV, String ho, String ten, String gt, int tuoi, double luong) {
		this.maNV = maNV;
		this.ho = ho;
		this.ten = ten;
		this.gt = gt;
		this.tuoi = tuoi;
		this.luong = luong;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getGt() {
		return gt;
	}

	public void setGt(String gt) {
		this.gt = gt;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", ho=" + ho + ", ten=" + ten + ", gt=" + gt + ", tuoi=" + tuoi + ", luong="
				+ luong + "]";
	}

}
