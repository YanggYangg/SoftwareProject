package tuan02_16_TableBoSung;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class bai01_JTableDonGian extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnAdd, btnRemove, btnExit;
	JTextField txtName, txtFirstname;
	DefaultTableModel model;
	JTable tblSV;
	
	public bai01_JTableDonGian() {
		super("Table Demo");
		String [] cols = {"Ho Sinh vien", "Ten Sinh vien"};
		model = new DefaultTableModel(cols, 0);
		tblSV = new JTable(model);
		
		JScrollPane pane = new JScrollPane(tblSV);
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Ho"));
		txtFirstname = new JTextField(20);
		p1.add(txtFirstname);
		p1.add(new JLabel("Ten"));
		txtName = new JTextField(20);
		p1.add(txtName);
		
		JPanel p2 = new JPanel();
		btnAdd = new JButton("Thêm");
		btnRemove = new JButton("Xóa");
		btnExit = new JButton("Thoát");
		
		p2.add(btnAdd);
		p2.add(btnRemove);
		p2.add(btnExit);
		
		JPanel pTop, pBottom;
		pTop = new JPanel();
		add(p1, BorderLayout.NORTH);
		add(pane, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		btnExit.addActionListener(this);
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		
		setSize(600, 420);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnAdd)) {
			if(txtName.getText().equals("") || txtFirstname.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Phải nhập dữ liệu trước !");
			else {
				Object[] obj = new Object[2];
				obj[0] = txtFirstname.getText();
				obj[1] = txtName.getText();
				model.addRow(obj);
				this.txtName.setText("");
				this.txtFirstname.setText("");
			}
		}
		else if(o.equals(btnRemove)){
			if(tblSV.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Phải chọn dòng cần xóa !");
			else {
				if(JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa dòng này hay không ?","Cảnh báo",
						JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION)
					model.removeRow(tblSV.getSelectedRow());
			}
		}
		else if(o.equals(btnExit)) {
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		new bai01_JTableDonGian().setVisible(true);
	}
}
