package tuan02_16_thongTinNhanVien;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
public class NhanVien_GUI extends JFrame implements ActionListener{

	private JLabel lbMaNV,lbHo,lbTen,lbTuoi,lbLuong,lbMaso,lbPhai,lbTitle;
	private JTextField txtMaNV,txtHo,txtTen,txtTuoi,txtLuong,txtMaso;
	private JRadioButton nam,nu;
	private JButton btTim,btThem,btXoaTrang,btXoa,btLuu,btSua;
	private JTable table;
	private DefaultTableModel model;
	private JPanel center;
	private dsNhanVien ds;
	
	public NhanVien_GUI() {
		setTitle("Thông tin nhân viên");
		setSize(800,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		ds = new dsNhanVien();
		createGUI();
		setVisible(true);
	}
	public void createGUI() {
		JPanel border = new JPanel();
		border.setLayout(new BorderLayout());
		
		add(border,BorderLayout.CENTER);
		border.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//Title
		JPanel north = new JPanel();
		lbTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		lbTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lbTitle.setForeground(Color.BLUE);
		north.add(lbTitle);
		border.add(north,BorderLayout.NORTH);
		
		
		//center JLabel and JTextField
		//Khởi tạo và gán cho center bố cục theo chiều dài
		center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		
		//Tạo box và thêm vào center
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		
		//createVerticalStrut khoảng cách giữa các txt
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		
		center.add(b);
		center.add(Box.createVerticalStrut(10));
		
		// Thêm vào từng box các JLabel và JTextField
		//b1
		lbMaNV = new JLabel("Mã nhân viên: ");
		txtMaNV = new JTextField();
		b1.add(lbMaNV);
		b1.add(txtMaNV);
		
		//b2
		lbHo = new JLabel("Họ: ");
		txtHo = new JTextField();
		b2.add(lbHo);
		b2.add(txtHo);
		
		//Căn chỉnh cho Label Ho có độ dài thẳng hàng với JLabel maNV 
		lbHo.setPreferredSize(lbMaNV.getPreferredSize());
		
		lbTen = new JLabel("Tên nhân viên: ");
		txtTen = new JTextField();
		b2.add(lbTen);
		b2.add(txtTen);
		
		//b3
		lbTuoi = new JLabel("Tuổi: ");
		txtTuoi = new JTextField();
		b3.add(lbTuoi);
		b3.add(txtTuoi);
		lbTuoi.setPreferredSize(lbMaNV.getPreferredSize());
		
		lbPhai = new JLabel("Phái: ");
		nam = new JRadioButton("Nam");
		nam.setEnabled(true);
		nu = new JRadioButton("Nữ");
		ButtonGroup group = new ButtonGroup();
		group.add(nam);
		group.add(nu);
		b3.add(lbPhai);
		b3.add(nam);
		b3.add(nu);
		lbPhai.setPreferredSize(lbMaNV.getPreferredSize());
		
		//b4
		lbLuong = new JLabel("Lương: ");
		txtLuong = new JTextField();
		b4.add(lbLuong);
		b4.add(txtLuong);
		lbLuong.setPreferredSize(lbMaNV.getPreferredSize());
		
		createTable();
		border.add(center,BorderLayout.CENTER);
		
		//chức năng south
		// JSplitPane có thể cho người dùng kéo thả qua lại
		JSplitPane split;
		border.add(split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT),BorderLayout.SOUTH);
		// căn chỉnh cho split nằm ở giữa: 0.5
		split.setResizeWeight(0.5);
		
		//Tạo 2 JPanel để add các chức năng
		JPanel p1 = new JPanel();
		lbMaso = new JLabel("Nhập mã số cần tìm: ");
		txtMaso = new JTextField(10);
		btTim = new JButton("Tìm");
		p1.add(lbMaso);
		p1.add(txtMaso);
		p1.add(btTim);
		split.add(p1);
		
		JPanel p2 = new JPanel();
		btThem = new JButton("Thêm");
		btXoaTrang = new JButton("Xóa trắng");
		btXoa = new JButton("Xóa");
		btLuu = new JButton("Lưu");
		btSua = new JButton("Sửa");
		p2.add(btThem);
		p2.add(btXoa);
		p2.add(btSua);
		p2.add(btXoaTrang);
		p2.add(btLuu);
		split.add(p2);
		
		Border line = BorderFactory.createLineBorder(Color.BLACK);
		p1.setBorder(line);
		p2.setBorder(line);
		
		this.add(border);
		
		//Sự kiện
		btThem.addActionListener(this);
		btLuu.addActionListener(this);
		btXoaTrang.addActionListener(this);
		btXoa.addActionListener(this);
		btTim.addActionListener(this);
	}
	
	public void createTable() {
		//Khởi tạo table, add model vào table và làm việc trên model
		JPanel panelTable = new JPanel();
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã NV");
		model.addColumn("Họ");
		model.addColumn("Tên");
		model.addColumn("Phái");
		model.addColumn("Tuổi");
		model.addColumn("Tiền lương");
		
		
		TableColumn phaiColumn = table.getColumnModel().getColumn(3);
		
		//Thêm thuộc tính cho người dùng chọn lựa là Nam hoặc Nữ
		JComboBox combobox = new JComboBox();
		combobox.addItem("Nam");
		combobox.addItem("Nữ");
		phaiColumn.setCellEditor(new DefaultCellEditor(combobox));
		
		//Căn chỉnh cho độ rộng của cột
		TableColumn tableColumn = new TableColumn();
		tableColumn.setPreferredWidth(100);
		
		//Căn chỉnh vị trí của chữ, mặc định nằm bên trái
		//Phải
		DefaultTableCellRenderer table_right = new DefaultTableCellRenderer();
		table_right.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		
		//Giữa
		DefaultTableCellRenderer table_center = new DefaultTableCellRenderer();
		table_center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		
		//chọn cột cần căn chỉnh
		table.getColumnModel().getColumn(0).setCellRenderer(table_center);
		table.getColumnModel().getColumn(3).setCellRenderer(table_right);
		table.getColumnModel().getColumn(4).setCellRenderer(table_right);
		table.getColumnModel().getColumn(5).setCellRenderer(table_right);
		
		//Tạo thanh scroll khi bảng có nhiều giá trị
		JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(650,300));
		center.add(scroll);
	}
	public static void main(String[] args) {
		new NhanVien_GUI();
	}
	/**
	 * Sự kiện
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btThem)) {
			if(btThem.getText().equals("Thêm")) {
				xoatrang();
				this.txtMaNV.requestFocus();
				
				btXoa.setEnabled(false);
				btThem.setText("Hủy");
			}
			else 
			{
				btXoa.setEnabled(true);
				btThem.setText("Thêm");
			}
		}else if(o.equals(btLuu)) {
			if(txtMaNV.getText().equals("") || txtHo.getText().equals("") || txtTen.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin!");
			else {
				try {
					luu();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			xoatrang();
			this.btThem.setText("Thêm");
			this.btXoa.setEnabled(true);
		}else if(o.equals(btXoa)) {
			try {
				xoaDong();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(o.equals(btXoaTrang)) {
			xoatrang();
		}else if(o.equals(btTim)) {
			int pos = ds.timKiemNV(this.txtMaso.getText());
			if(pos == -1) {
				JOptionPane.showMessageDialog(this, "Không tồn tại nhân viên có mã này!");
			}else{
				table.setRowSelectionInterval(pos, pos);
			}
		}
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtMaNV.setText(model.getValueAt(row, 0).toString());
				txtHo.setText(model.getValueAt(row, 1).toString());
				txtTen.setText(model.getValueAt(row, 2).toString());
				if(model.getValueAt(row, 3).toString().equalsIgnoreCase("Nam")) {
					nam.setSelected(true);
					nu.setSelected(false);
				}else {
					nam.setSelected(false);
					nu.setSelected(true);
				}
				txtTuoi.setText(model.getValueAt(row, 4).toString());
				txtLuong.setText(model.getValueAt(row, 5).toString());
			}
		}
		);
	}
	private void luu() throws Exception{
		String gt = "";
		String ma = txtMaNV.getText();
		String ho = txtHo.getText();
		String ten = txtTen.getText();
		if(nam.isSelected())
			gt = nam.getText();
		if(nu.isSelected())
			gt = nu.getText();
		String tuoi = txtTuoi.getText();
		String luong = txtLuong.getText();
		
		NhanVien nv = new NhanVien(ma, ho, ten, gt, Integer.parseInt(tuoi), Double.parseDouble(luong));
		if(ds.them(nv)) {
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			String [] row = {ma,ho,ten,gt,tuoi,luong};
			model.addRow(row);
		}else {
			JOptionPane.showMessageDialog(this, "Mã này đã tồn tại");
			txtMaNV.setText("");
		}
	}
	private void xoaDong() throws Exception{
		int r = table.getSelectedRow();
		if(r != -1) {
			int thongBao = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dòng này không?","Delete",JOptionPane.YES_NO_OPTION);
			if(thongBao == JOptionPane.YES_OPTION) {
				ds.xoaViTri(r);
				model.removeRow(r);
				xoatrang();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa.");
		}
	}
	private void xoatrang() {
		txtMaNV.setText("");
		txtHo.setText("");
		txtTen.setText("");
		nam.setSelected(false);
		nu.setSelected(false);
		txtTuoi.setText("");
		txtLuong.setText("");
		txtMaso.setText("");
		txtMaNV.requestFocus();
	}
	

}
