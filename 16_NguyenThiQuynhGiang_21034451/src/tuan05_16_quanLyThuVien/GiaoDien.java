package tuan05_16_quanLyThuVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GiaoDien extends JFrame implements ActionListener, MouseListener, WindowListener {

	private JTextField txtMaSach;
	private JTextField txtTuaSach;
	private JTextField txtTacGia;
	private JTextField txtNamXB;
	private JTextField txtNhaXB;
	private JTextField txtSoTrang;
	private JTextField txtDonGia;
	private JTextField txtISBN;
	private JTextField txtMess;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnSua;
	private JButton btnLuu;
	private JButton btnXoa;
	private JComboBox<String> cboMaSach;
	private JTable table;
	private SachTableModel model;
	private DanhSachCacCuonSach dsSach;

	public GiaoDien() {
		setTitle("Quáº£n lÃ½ sÃ¡ch");
		setSize(900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		createGUI();
	}

	public void createGUI() {
		JLabel lblMaSach, lblTuaSach, lblTacGia, lblNamXB, lblNhaXB, lblSoTrang, lblDonGia, lblISBN;
		lblMaSach = new JLabel("MÃ£ sÃ¡ch");
		lblTuaSach = new JLabel("Tá»±a sÃ¡ch");
		lblTacGia = new JLabel("TÃ¡c giáº£");
		lblNamXB = new JLabel("NÄƒm xuáº¥t báº£n");
		lblNhaXB = new JLabel("NhÃ  xuáº¥t báº£n");
		lblSoTrang = new JLabel("Sá»‘ trang");
		lblDonGia = new JLabel("Ä�Æ¡n giÃ¡");
		lblISBN = new JLabel("International Standard Book Number: ");
		txtMaSach = new JTextField();
		txtTuaSach = new JTextField();
		txtTacGia = new JTextField();
		txtNamXB = new JTextField();
		txtNhaXB = new JTextField();
		txtSoTrang = new JTextField();
		txtDonGia = new JTextField();
		txtISBN = new JTextField();
		txtMess = new JTextField();

		JPanel pnNorth = new JPanel();
		pnNorth.setPreferredSize(new Dimension(0, 180));
		add(pnNorth, BorderLayout.NORTH);
		pnNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		pnNorth.setLayout(null);
		pnNorth.add(lblMaSach);
		pnNorth.add(txtMaSach);
		pnNorth.add(lblTuaSach);
		pnNorth.add(txtTuaSach);
		pnNorth.add(lblTacGia);
		pnNorth.add(txtTacGia);
		pnNorth.add(lblNamXB);
		pnNorth.add(txtNamXB);
		pnNorth.add(lblNhaXB);
		pnNorth.add(txtNhaXB);
		pnNorth.add(lblSoTrang);
		pnNorth.add(txtSoTrang);
		pnNorth.add(lblDonGia);
		pnNorth.add(txtDonGia);
		pnNorth.add(lblISBN);
		pnNorth.add(txtISBN);
		pnNorth.add(txtMess);
		txtMess.setEditable(false);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);

		lblMaSach.setBounds(20, 20, 100, 20);
		txtMaSach.setBounds(120, 20, 200, 20);
		lblTuaSach.setBounds(20, 45, 100, 20);
		txtTuaSach.setBounds(120, 45, 300, 20);
		lblTacGia.setBounds(450, 45, 100, 20);
		txtTacGia.setBounds(550, 45, 300, 20);
		lblNamXB.setBounds(20, 70, 100, 20);
		txtNamXB.setBounds(120, 70, 300, 20);
		lblNhaXB.setBounds(450, 70, 100, 20);
		txtNhaXB.setBounds(550, 70, 300, 20);
		lblSoTrang.setBounds(20, 95, 100, 20);
		txtSoTrang.setBounds(120, 95, 300, 20);
		lblDonGia.setBounds(450, 95, 100, 20);
		txtDonGia.setBounds(550, 95, 300, 20);
		lblISBN.setBounds(20, 120, 250, 20);
		txtISBN.setBounds(250, 120, 170, 20);
		txtMess.setBounds(20, 145, 550, 20);

		JPanel pnCenter = new JPanel();
		add(pnCenter, BorderLayout.CENTER);
		pnCenter.add(btnThem = new JButton("ThÃªm"));
		pnCenter.add(btnXoaRong = new JButton("XÃ³a Rá»—ng"));
		pnCenter.add(btnXoa = new JButton("XÃ³a"));
		pnCenter.add(btnSua = new JButton("Sá»­a"));
		pnCenter.add(btnLuu = new JButton("LÆ°u"));
		pnCenter.add(new JLabel("TÃ¬m theo mÃ£: "));
		pnCenter.add(cboMaSach = new JComboBox<String>());
		cboMaSach.setPreferredSize(new Dimension(100, 25));

		JScrollPane scroll = new JScrollPane(table = new JTable(model), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));
		add(scroll, BorderLayout.SOUTH);

		dsSach = new DanhSachCacCuonSach();
		dsSach.napDuLieuTuFile();
		updateComboboxData();
		updateTableData(dsSach);

		addWindowListener(this);
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		table.addMouseListener(this);
		cboMaSach.addActionListener(this);
	}

	public static void main(String[] args) {
		new GiaoDien().setVisible(true);

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		if (JOptionPane.showConfirmDialog(this, "Báº¡n muá»‘n thoÃ¡t?", "XÃ¡c nháº­n thoÃ¡t",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int r = table.getSelectedRow();
		fillForm(r);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (validData()) {
				Sach s = revertSachFromFields();
				if (dsSach.themSach(s)) {
					txtMess.setText("ThÃªm thÃ nh cÃ´ng 1 cuá»‘n sach");
					updateComboboxData();
					updateTableData(dsSach);
				} else {
					showMessage("Error: TrÃ¹ng mÃ£ sÃ¡ch", txtMaSach);
				}
			}
		}
		if (o.equals(btnXoaRong))
			XoaRong();
		if (o.equals(btnXoa))
			xoa();
		if (o.equals(btnSua))
			sua();
		if (o.equals(btnLuu)) {
			Database.ghiXuongFile(dsSach.getDsSach());
			txtMess.setText("LÆ°u thÃ nh cÃ´ng");
		}
		if (o.equals(cboMaSach)) {
			String maSach = (String) cboMaSach.getSelectedItem();
			Sach s = dsSach.timKiem(maSach);
			if (s != null) {
				int index = dsSach.getDsSach().indexOf(s);
				fillForm(index);
				table.getSelectionModel().setSelectionInterval(index, index);
				table.scrollRectToVisible(table.getCellRect(index, index, true));
			}
		}
	}

	public void updateComboboxData() {
		int n = dsSach.count(); // Tá»•ng sá»‘ cÃ¡c cuá»‘n sÃ¡ch
		String[] items = new String[n];
		int i = 0;
		for (Sach s : dsSach.getDsSach()) {
			items[i] = s.getMaSach();
			i++;
		}
		cboMaSach.setModel(new DefaultComboBoxModel<String>(items));
	}

	private void updateTableData(DanhSachCacCuonSach ds) {
		model = new SachTableModel(ds.getDsSach());
		table.setModel(model);

	}

	public boolean validData() {
		String maSach = txtMaSach.getText().trim();
		String tuaSach = txtTuaSach.getText().trim();
		String tacGia = txtTacGia.getText().trim();
		String namXB = txtNamXB.getText().trim();
		String nhaXB = txtNhaXB.getText().trim();
		String soTrang = txtSoTrang.getText().trim();
		String donGia = txtDonGia.getText().trim();
		String isbn = txtISBN.getText().trim();

		if (maSach.equals("")) {
			showMessage("MÃ£ sÃ¡ch khÃ´ng Ä‘Æ°á»£c rá»—ng", txtMaSach);
			return false;
		} else if (tuaSach.equals("")) {
			showMessage("Tá»±a sÃ¡ch khÃ´ng Ä‘Æ°á»£c rá»—ng", txtTuaSach);
			return false;
		} else if (tacGia.equals("")) {
			showMessage("TÃ¡c giáº£ khÃ´ng Ä‘Æ°á»£c rá»—ng", txtTacGia);
			return false;
		} else if (isbn.equals("")) {
			showMessage("ISBN khÃ´ng Ä‘Æ°á»£c rá»—ng", txtISBN);
			return false;
		} else {
			if (!maSach.matches("^[a-zA-z]\\d{3}$")) {
				showMessage(
						"MÃ£ sÃ¡ch pháº£i theo qui Æ°á»›c sau: CÃ³ kÃ½ tá»± Ä‘áº§u lÃ  kÃ½ tá»± Ä‘áº§u cá»§a tá»±a sÃ¡ch, theo sau lÃ  3 kÃ½ sá»‘",
						txtMaSach);
				return false;
			} else if (maSach.charAt(0) != tuaSach.charAt(0)) {
				showMessage("MÃ£ sÃ¡ch pháº£i cÃ³ kÃ­ tá»± Ä‘áº§u cá»§a tá»±a sÃ¡ch", txtMaSach);
				return false;
			} else if (!isbn.matches("^\\d+-\\d+-\\d+-\\d+(-\\d+)?$")) {
				showMessage("ISBN cÃ³ máº«u dáº¡ng X-X-X-X (hoáº·c X-X-X-X-X). Trong Ä‘Ã³, X gá»“m cÃ¡c kÃ½ sá»‘, Ã­t nháº¥t lÃ  1 kÃ½ sá»‘",
						txtISBN);
				return false;
			} else
				return true;
		}
	}

	public Sach revertSachFromFields() {
		String maSach = txtMaSach.getText().trim();
		String tuaSach = txtTuaSach.getText().trim();
		String tacGia = txtTacGia.getText().trim();
		String namXB = txtNamXB.getText().trim();
		int nam = namXB.length() == 0 ? 0 : Integer.parseInt(namXB);
		String nhaXB = txtNhaXB.getText();
		String soTrang = txtSoTrang.getText().trim();
		int trang = soTrang.length() == 0 ? 0 : Integer.parseInt(soTrang);
		String donGia = txtDonGia.getText().trim();
		double gia = donGia.length() == 0 ? 0 : Double.parseDouble(donGia);
		String isbn = txtISBN.getText();
		return new Sach(maSach, tuaSach, tacGia, nam, nhaXB, trang, gia, isbn);
	}

	public void showMessage(String Mess, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(Mess);
	}

	public void XoaRong() {
		txtMaSach.setText("");
		txtTuaSach.setText("");
		txtTacGia.setText("");
		txtNamXB.setText("");
		txtNhaXB.setText("");
		txtSoTrang.setText("");
		txtDonGia.setText("");
		txtISBN.setText("");
		txtMaSach.setEditable(true);
		txtMaSach.requestFocus();
	}

	public void xoa() {
		int r = table.getSelectedRow();
		if (r == -1) {
			txtMess.setText("ChÆ°a chá»�n dÃ²ng");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Dá»¯ liá»‡u sáº½ máº¥t khi xÃ³a", "Cáº£nh bÃ¡o",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (dsSach.xoa1CuonSach(r)) {
					txtMess.setText("XÃ³a thÃ nh cÃ´ng");
					updateComboboxData();
					updateTableData(dsSach);
					XoaRong();
				}
			}
		}
	}

	public void sua() {
		int r = table.getSelectedRow();
		if (r == -1) {
			txtMess.setText("ChÆ°a chá»�n dÃ²ng");
		} else {
			String maSOld = txtMaSach.getText();
			if (validData()) {
				if (dsSach.capNhatSach(maSOld, revertSachFromFields())) {
					txtMess.setText("Cáº­p nháº­t thÃ nh cÃ´ng");
					updateTableData(dsSach);
				}
			}
		}
	}

	public void fillForm(int r) {
		txtMaSach.setEditable(false);
		txtMaSach.setText(table.getValueAt(r, 0).toString());
		txtTuaSach.setText(table.getValueAt(r, 1).toString());
		txtTacGia.setText(table.getValueAt(r, 2).toString());
		txtNamXB.setText(table.getValueAt(r, 3).toString());
		txtNhaXB.setText(table.getValueAt(r, 4).toString());
		txtSoTrang.setText(table.getValueAt(r, 5).toString());
		txtDonGia.setText(table.getValueAt(r, 6).toString());
		txtISBN.setText(table.getValueAt(r, 7).toString());
	}

}
