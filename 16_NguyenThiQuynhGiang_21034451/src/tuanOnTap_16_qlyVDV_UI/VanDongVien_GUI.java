package tuanOnTap_16_qlyVDV_UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import tuanOnTap_16_qlyVDV_ConnectDB.ConnectDB;
import tuanOnTap_16_qlyVDV_DAO.CauLacBo_DAO;
import tuanOnTap_16_qlyVDV_DAO.VanDongVien_DAO;
import tuanOnTap_16_qlyVDV_entity.CauLacBo;
import tuanOnTap_16_qlyVDV_entity.VanDongVien;

public class VanDongVien_GUI extends JFrame  implements ActionListener, MouseListener {

	private static final long serialVersionUID = -1554680235689968471L;

	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnKetThuc;

	private DefaultTableModel dataModel;
	private JTable table;

	private JScrollPane scroll;

	private JComboBox<String> cboCauLB;
	private JTextField txtMaVDV;
	private JTextField txtTenVDV;
	private JTextField txtTuoi;

	private JButton btnLoc;
	
	private VanDongVien_DAO vdv_dao;
	private CauLacBo_DAO clb_dao;
	

	public VanDongVien_GUI() {
		
		//Khởi tạo kết nối đến CSDL
				try {
					ConnectDB.getInstance().connect();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
				vdv_dao = new VanDongVien_DAO();
				clb_dao = new CauLacBo_DAO();
		
		setSize(630, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Box b, b1, b2, b3, b4, b5, b6, b7, b8;
		add(b = Box.createVerticalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b8 = Box.createHorizontalBox());

		b.add(Box.createVerticalStrut(10));
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b7 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b8 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		JLabel lblTieuDe, lblMaVDV, lblTenVDV, lblTuoi, lblCLB;
		b1.add(lblTieuDe = new JLabel("-THÔNG TIN VẬN ĐỘNG VIÊN- ", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTieuDe.setForeground(Color.BLUE);

		b2.add(lblMaVDV = new JLabel("  Mã số vận động viên:  ", JLabel.RIGHT));
		b2.add(txtMaVDV = new JTextField());
		b2.add(Box.createHorizontalStrut(50));
		b3.add(lblTenVDV = new JLabel("Tên Vận động viên:  ", JLabel.RIGHT));
		b3.add(txtTenVDV = new JTextField());
		b3.add(Box.createHorizontalStrut(50));
		b4.add(lblTuoi = new JLabel("Câu lạc bộ:  ", JLabel.RIGHT));
		b4.add(cboCauLB = new JComboBox<String>());
		b4.add(Box.createHorizontalStrut(300));

		b5.add(lblCLB = new JLabel("Tuổi:  ", JLabel.RIGHT));
		b5.add(txtTuoi = new JTextField());
		b5.add(Box.createHorizontalStrut(50));

		DefaultComboBoxModel<String> dataModelLop = new DefaultComboBoxModel<String>();

		cboCauLB.setModel(dataModelLop);

		lblTuoi.setPreferredSize(lblMaVDV.getPreferredSize());
		lblTenVDV.setPreferredSize(lblMaVDV.getPreferredSize());
		lblCLB.setPreferredSize(lblMaVDV.getPreferredSize());

		b6.add(Box.createHorizontalStrut(40));
		b6.add(btnThem = new JButton("Thêm Mới "));
		b6.add(Box.createHorizontalStrut(10));
		b6.add(btnLuu = new JButton("Lưu "));
		b6.add(Box.createHorizontalStrut(10));
		b6.add(btnXoa = new JButton("Xóa"));
		b6.add(Box.createHorizontalStrut(50));
		b6.add(btnKetThuc = new JButton("Kết Thúc"));

		String[] tieuDe = { "Mã Số", "Tên vận động viên", "Tuổi", "Câu Lạc Bộ" };
		b7.add(scroll = new JScrollPane(table = new JTable(dataModel = new DefaultTableModel(tieuDe, 0))));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách vận động viên:"));

		DocDuLieuDatabaseVaoTable();
		
		JLabel lblName;
		b8.add(lblName = new JLabel("Họ tên sv: Nguyễn Thị Quỳnh Giang massv: 21034451"));
		lblName.setFont(new Font("Times", Font.ITALIC, 12));
		lblName.setForeground(Color.RED);
		b8.add(Box.createHorizontalStrut(50));
		b8.add(btnLoc= new JButton("   Lọc danh sách VĐV theo câu lạc bộ "));
		btnLoc.setFont(new Font("Times New Roman", Font.ITALIC,14 ));
		btnLoc.setForeground(Color.BLUE);
		table.addMouseListener(this);
		btnKetThuc.addActionListener(this);
		btnLoc.addActionListener(this);
		btnLuu.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			String maVDV = txtMaVDV.getText().trim();
		    String tenVDV = txtTenVDV.getText().trim();
		    int tuoi = Integer.parseInt(txtTuoi.getText().trim());
		    String maCLB = cboCauLB.getSelectedItem().toString();

		    CauLacBo clb = new CauLacBo(maCLB);
		    VanDongVien vdv = new VanDongVien(maVDV, tenVDV, tuoi, clb);

		    try {
		        vdv_dao.createVDV(vdv);
		       dataModel.addRow(new Object[] {vdv.getMaVDV(),vdv.getTenVDV(),vdv.getTuoi(),vdv.getClb().getMaCLB()});
		    } catch (Exception ex) {
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
		    }
		}
		
		if(o.equals(btnXoa)) {
			
		}
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void DocDuLieuDatabaseVaoTable() {
		ArrayList<VanDongVien> list = vdv_dao.getalltbVDV();
		for(VanDongVien vdv : list) {
			dataModel.addRow(new Object[] {
					vdv.getMaVDV(), vdv.getTenVDV(), vdv.getTuoi(), vdv.getClb().getMaCLB()
			});
		}
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
