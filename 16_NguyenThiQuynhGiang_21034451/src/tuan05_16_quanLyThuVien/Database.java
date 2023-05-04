package tuan05_16_quanLyThuVien;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Database {
	private static final String FILENAME = "data/DanhMucSach.txt";

	public static void ghiXuongFile(ArrayList<Sach> dsSach) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(FILENAME));
			bw.write("MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN\n");
			for (Sach s : dsSach) {
				bw.write(s.toString() + "\n");
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Sach> docTuFile() {
		ArrayList<Sach> temp = new ArrayList<Sach>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(FILENAME));
			br.readLine();
			while (br.ready()) {
				String line = br.readLine();
				if (line != null && !line.trim().equals("")) {
					String[] a = line.split(";");
					Sach s = new Sach(a[0], a[1], a[2], Integer.parseInt(a[3]), a[4], Integer.parseInt(a[5]),
							Double.parseDouble(a[6]), a[7]);
					temp.add(s);
				}
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
}
