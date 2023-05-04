package tuan03_16_JTree;

import java.util.ArrayList;

public class PhongBan {
	private String maPhongBan, tenPhongBan;
	private ArrayList<NhanVien> pb;
	
	public PhongBan() {
		
		pb = new ArrayList<NhanVien>();
	}
	
	public PhongBan(String maPhongBan, String tenPhongBan) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		pb = new ArrayList<NhanVien>();
	}
	
	

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public ArrayList<NhanVien> getPb() {
		return pb;
	}
	public int getLength() {
		return pb.size();
	}
	public boolean them(NhanVien nv) {
		if (pb.contains(nv))
			return false;
		pb.add(nv);
		return true;
	}
	public void xoa(int pos) {
		 pb.remove(pos);
	}
	public int tim(String manv) {
		for (NhanVien i : pb) {
			if (i.getMaNV().equalsIgnoreCase(manv))
				return pb.indexOf(i);
		}
		return -1;
	}

	@Override
	public String toString() {
		return tenPhongBan;
	}	
}
