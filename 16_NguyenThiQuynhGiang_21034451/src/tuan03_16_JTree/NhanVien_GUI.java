package tuan03_16_JTree;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class NhanVien_GUI extends JFrame{
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<NhanVien> pb;
	
	public NhanVien_GUI(ArrayList<NhanVien> pb, String title) {
		setTitle(title);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.pb = pb;
		String[] cols = {"Mã", "Họ", "Tên", "Phòng ban", "Tuổi", "Tiền lương"};
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		
		for (NhanVien i : pb) {
			String[] rows = {i.getMaNV(), i.getHo(), i.getTen(), i.getPhai(), String.valueOf(i.getTuoi()), String.valueOf(i.getTienLuong())};
			model.addRow(rows);
		}
		table.setRowHeight(15);
		
		this.add(new JScrollPane(table), BorderLayout.CENTER);
		this.setVisible(true);
	}
}