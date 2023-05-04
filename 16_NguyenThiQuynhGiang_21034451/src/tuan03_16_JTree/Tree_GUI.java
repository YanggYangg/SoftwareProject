package tuan03_16_JTree;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;


public class Tree_GUI extends JFrame implements TreeSelectionListener, MouseListener {
	private JTree tree;
	private DefaultMutableTreeNode root;
	private ArrayList<PhongBan> cty;

	public Tree_GUI(ArrayList<PhongBan> cty) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(700, 800);
		this.setTitle("Tuần 3");
		
		root = new DefaultMutableTreeNode("Danh sách phòng ban");
		this.cty = cty;
		
		tree = new JTree(root);
		tree.setShowsRootHandles(true);
		
		for (PhongBan i : cty) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(i);
			root.add(node);
		}
		
		this.add(new JScrollPane(tree), BorderLayout.CENTER);
		
		tree.addMouseListener(this);
		this.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 2) {
			DefaultMutableTreeNode select = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
			if (select != null) {
//				TreePath path = tree.getSelectionPath();
//				if (path.toString().equalsIgnoreCase((PhongBan) select.getUserObject().toString())) {
//					PhongBan pb = (PhongBan) select.getUserObject();
//					ArrayList<NhanVien> list = pb.getPb();
//					new frameNhanVien(list, pb.getTenPB());
//				}
				if (select.getUserObject() instanceof PhongBan) {
					PhongBan pb = (PhongBan) select.getUserObject();
					ArrayList<NhanVien> list = pb.getPb();
					new NhanVien_GUI(list, pb.getTenPhongBan());
				}
			}
		}
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
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		DanhSachPhongBan cty = new DanhSachPhongBan();
		PhongBan tc, kt;
		cty.addPB(kt = new PhongBan("KT", "Phòng kĩ thuật"));
		cty.addPB(tc = new PhongBan("TC", "Phòng tổ chức"));
	

		kt.them(new NhanVien("KT001", "Nguyễn Thị", "Quỳnh Giang", "Nữ", 20, 3000));
		tc.them(new NhanVien("TC001", "Lâm Văn", "B", "Nam", 25, 4000));
		ArrayList<PhongBan> list = cty.getDs();
		new Tree_GUI(list);
	}
}
