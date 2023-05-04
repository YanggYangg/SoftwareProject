package entity;

public class CauThu {
	private String maSoCauThu;
	private String tenCauThu;
	private int tuoi;
	
	private ViTriThiDau vtri;
	
	
	public CauThu(String maSoCauThu, String tenCauThu,  int tuoi, ViTriThiDau vtri) {
		this.maSoCauThu = maSoCauThu;
		this.tenCauThu = tenCauThu;
		this.tuoi = tuoi;
		this.vtri = vtri;
	}

	public CauThu(String maSoCauThu) {
		this.maSoCauThu = maSoCauThu;
	}

	public String getMaSoCauThu() {
		return maSoCauThu;
	}

	public void setMaSoCauThu(String maSoCauThu) {
		this.maSoCauThu = maSoCauThu;
	}

	public String getTenCauThu() {
		return tenCauThu;
	}

	public void setTenCauThu(String tenCauThu) {
		this.tenCauThu = tenCauThu;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public ViTriThiDau getVtri() {
		return vtri;
	}

	public void setVtri(ViTriThiDau vtri) {
		this.vtri = vtri;
	}
	
	
	

}
