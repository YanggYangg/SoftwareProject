/**
 * STT16_Nguyễn Thị Quỳnh Giang_21034451_DHKTPM17B
 */
package tuanOnTap_16_qlyVDV_entity;

public class CauLacBo {
	private String maCLB;
	private String tenCLB;
	
	public CauLacBo(String maCLB, String tenCLB) {
		this.maCLB = maCLB;
		this.tenCLB = tenCLB;
	}

	public CauLacBo(String maCLB) {
		this.maCLB = maCLB;
	}

	public String getMaCLB() {
		return maCLB;
	}

	public void setMaCLB(String maCLB) {
		this.maCLB = maCLB;
	}

	public String getTenCLB() {
		return tenCLB;
	}

	public void setTenCLB(String tenCLB) {
		this.tenCLB = tenCLB;
	}

	@Override
	public String toString() {
		return "CauLacBo [maCLB=" + maCLB + ", tenCLB=" + tenCLB + "]";
	}

}
