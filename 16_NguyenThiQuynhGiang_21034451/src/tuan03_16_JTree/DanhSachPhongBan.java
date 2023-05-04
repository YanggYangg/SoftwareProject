package tuan03_16_JTree;

import java.util.ArrayList;

public class DanhSachPhongBan {
	private ArrayList<PhongBan> dsPhongBan;
	
	public DanhSachPhongBan() {
		// TODO Auto-generated constructor stub
		dsPhongBan = new ArrayList<PhongBan>();
	}
	
	public void addPB(PhongBan pb) {
		dsPhongBan.add(pb);
	}
	
	public ArrayList<PhongBan> getDs(){
		return dsPhongBan;
	}
}
