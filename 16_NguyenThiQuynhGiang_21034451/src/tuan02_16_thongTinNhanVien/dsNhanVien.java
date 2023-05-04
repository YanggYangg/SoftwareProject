package tuan02_16_thongTinNhanVien;

import java.util.ArrayList;

public class dsNhanVien {

	private ArrayList<NhanVien> ls;

	public dsNhanVien(ArrayList<NhanVien> ls) {
		this.ls = ls;
	}

	public dsNhanVien() {
		this.ls = new ArrayList<NhanVien>();
	}
	
	public ArrayList<NhanVien> getNhanVien(){
		return ls;
	}

	public boolean them(NhanVien nv) {
		for (NhanVien nhanVien : ls) {
			if(nv.getMaNV().equalsIgnoreCase(nhanVien.getMaNV()))
				return false;
		}
		ls.add(nv);
		return true;
	}
	
	public boolean xoaViTri(int i) {
		if(i >=0 && i <=ls.size()-1) {
			ls.remove(i);
			return true;
		}else
			return false;
	}
	
	public int timKiemNV(String manv) {
		for(int i=0;i<ls.size();i++) {
			if(ls.get(i).getMaNV().equalsIgnoreCase(manv))
				return i;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "dsNhanVien [ls=" + ls + "]";
	}
}
