package tuan05_16_quanLyThuVien;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DanhSachCacCuonSach {
	private ArrayList<Sach> dsSach;

	public DanhSachCacCuonSach() {
		dsSach = new ArrayList<Sach>();
	}

	public DanhSachCacCuonSach(ArrayList<Sach> arrayds) {
		dsSach = arrayds;
	}

	public boolean themSach(Sach s) {
		if (dsSach.contains(s))
			return false;
		return dsSach.add(s);
	}

	public boolean xoa1CuonSach(int index) {
		if (index >= 0 && index < dsSach.size()) {
			dsSach.remove(index);
			return true;
		}
		return false;
	}

	public boolean capNhatSach(String maSachCu, Sach sachMoi) {
		Sach sachCu = new Sach(maSachCu);
		if (dsSach.contains(sachCu)) {
			sachCu = dsSach.get(dsSach.indexOf(sachCu));
			sachCu.setTuaSach(sachMoi.getTuaSach());
			sachCu.setTacGia(sachMoi.getTacGia());
			sachCu.setNamXB(sachMoi.getNamXB());
			sachCu.setNhaXB(sachMoi.getNhaXB());
			sachCu.setSoTrang(sachMoi.getSoTrang());
			sachCu.setDonGia(sachMoi.getDonGia());
			sachCu.setIsbn(sachMoi.getIsbn());
			return true;
		}
		return false;
	}

	public Sach timKiem(String maSach) {
		Sach s = new Sach(maSach);
		if (dsSach.contains(s))
			return dsSach.get(dsSach.indexOf(s));
		return null;
	}

	public ArrayList<Sach> filter(String regex) {
		ArrayList<Sach> result = new ArrayList<Sach>();
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		for (Sach s : dsSach) {
			Matcher m = p.matcher(s.getTuaSach());
			if (m.find())
				result.add(s);
		}
		return result;
	}

	public void napDuLieuTuFile() {
		dsSach = Database.docTuFile();
	}

	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}

	public int count() {
		return dsSach.size();
	}
}
