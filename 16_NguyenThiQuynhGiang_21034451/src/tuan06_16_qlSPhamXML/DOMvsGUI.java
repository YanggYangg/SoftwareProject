package tuan06_16_qlSPhamXML;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



public class DOMvsGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 6736610855443618564L;
	private DefaultTableModel model;
	private JTable table;
	private ManageProduct dom;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnAdd;
	private TableRowSorter<TableModel> sorter;
	private JButton btnFilter;

	public DOMvsGUI() {
		setTitle("Dom parser");
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1000, 600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		String[] headers = {"productID", "name", "manufacture", "description", "sname", "country", "web", "price"};
		add(new JScrollPane(table = new JTable(model = new DefaultTableModel(headers , 0))), BorderLayout.CENTER);

		dom = new ManageProduct();
		updateTableData();

		sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);

		JPanel pnlSouth;
		add(pnlSouth = new JPanel(), BorderLayout.SOUTH);
		pnlSouth.add(btnAdd = new JButton("Add"));
		pnlSouth.add(btnDelete = new JButton("Delete"));
		pnlSouth.add(btnUpdate = new JButton("Update"));
		pnlSouth.add(btnSave = new JButton("Save"));
		pnlSouth.add(btnFilter = new JButton("Filter"));
		

		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnSave.addActionListener(this);
		btnFilter.addActionListener(this);
		btnAdd.addActionListener(this);
	}

	private void updateTableData() {

		//xoa du lieu tren table
		while(table.getRowCount() != 0)
			model.removeRow(0);
		
		ArrayList<Product> list = dom.getAllProducts();
		for(Product p : list){
			String rowData[] = {p.getProductID(), p.getName(), p.getManufacture(), p.getDescription(), p.getSupplier().getName(),
					p.getSupplier().getCountry(), p.getSupplier().getWebsite(), p.getPrice()+""};
			model.addRow(rowData);
		}
	}

	public static void main(String[] args) {
		new DOMvsGUI().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		 if(o.equals(btnAdd))
		{
			String id = JOptionPane.showInputDialog("Nhập mã sản phẩm: ");
			String name = JOptionPane.showInputDialog("Nhap tên sản phẩm: ");
			String manufacture = JOptionPane.showInputDialog("Nhập tên hãng: ");
			String description = JOptionPane.showInputDialog("Nhập mô tả: ");
			String sUpplier = JOptionPane.showInputDialog("Nhập nhà phân phối: ");
			String country = JOptionPane.showInputDialog("Nhập quốc gia: ");
			String web = JOptionPane.showInputDialog("Nhập website: ");
			String giaTien = JOptionPane.showInputDialog("Nhập giá tiền: ");
			Double gia = Double.parseDouble(giaTien);
			
			
			Supplier s=new Supplier("Nguyen Kim","Vietnam","www.nguyenkim.vn");
			Product p= new Product(id, name, "Samsung", "Mobile", s, 300);
			dom.addProduct(p);
			JOptionPane.showMessageDialog(this, "Them thanh cong");
			updateTableData();
			dom.writeXMLFile();
		}
		 else if(o.equals(btnUpdate)) {
			 String ma = JOptionPane.showInputDialog("Nhập mã sản phẩm: ");
			 String gia = JOptionPane.showInputDialog("Nhập giá tiền: ");
			 Double giaTien = Double.parseDouble(gia);
			 
			 dom.updatePrice(ma, giaTien);
			 
			 JOptionPane.showMessageDialog(this, "CẬP NHẬT THÀNH CÔNG !!!");
			 updateTableData();
			 dom.writeXMLFile();
		 }
		 else if(o.equals(btnDelete)){
			 int thongBao = JOptionPane.showConfirmDialog(this,"Chắc chắn muốn xóa ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
			 
			 if(thongBao == JOptionPane.YES_NO_OPTION) {
				 String ma = JOptionPane.showInputDialog("Nhập mã sản phẩm: ");
				 dom.deleteProduct(ma);
				 
				 JOptionPane.showMessageDialog(this, "XÓA THÀNH CÔNG !!!");
				 updateTableData();
				 dom.writeXMLFile();
			 }
		 }
	}

}
