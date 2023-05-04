/**
 * STT16_Nguyễn Thị Quỳnh Giang_21034451_DHKTPM17B
 */
package tuanOnTap_16_qlyVDV_entity;

public class VanDongVien {
	private String maVDV;
	private String tenVDV;
	private int tuoi;
	private CauLacBo clb;
	
	public VanDongVien(String maVDV, String tenVDV, int tuoi, CauLacBo clb) {
		this.maVDV = maVDV;
		this.tenVDV = tenVDV;
		this.tuoi = tuoi;
		this.clb = clb;
	}

	public VanDongVien(String maVDV) {
		this.maVDV = maVDV;
	}

	public VanDongVien(String maVDV, String tenVDV) {
		this.maVDV = maVDV;
		this.tenVDV = tenVDV;
	}

	public String getMaVDV() {
		return maVDV;
	}

	public void setMaVDV(String maVDV) {
		this.maVDV = maVDV;
	}

	public String getTenVDV() {
		return tenVDV;
	}

	public void setTenVDV(String tenVDV) {
		this.tenVDV = tenVDV;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public CauLacBo getClb() {
		return clb;
	}

	public void setClb(CauLacBo clb) {
		this.clb = clb;
	}

	@Override
	public String toString() {
		return "VanDongVien [maVDV=" + maVDV + ", tenVDV=" + tenVDV + ", tuoi=" + tuoi + ", clb=" + clb + "]";
	}
}
