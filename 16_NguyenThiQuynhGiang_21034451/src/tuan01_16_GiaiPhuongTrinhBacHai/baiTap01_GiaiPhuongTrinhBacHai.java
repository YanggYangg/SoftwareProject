package tuan01_16_GiaiPhuongTrinhBacHai;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class baiTap01_GiaiPhuongTrinhBacHai extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton buttonGiai;
	private JButton buttonXoaRong;
	private JButton buttonThoat;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtKQ;
	
	public baiTap01_GiaiPhuongTrinhBacHai() {
		setTitle("^-^");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		createGUI();
		
	}
	
	private void createGUI() {
		JPanel panelNorth;
		add(panelNorth = new JPanel(),BorderLayout.NORTH);
		panelNorth.setBackground(Color.CYAN);
		
		JLabel lblTieuDe;
		panelNorth.add(lblTieuDe = new JLabel("GIAI PHUONG TRINH BAC HAI"));
		lblTieuDe.setFont(new Font("Arial",Font.BOLD, 20));
		
		//
		JPanel panelCenter;
		add(panelCenter = new JPanel(), BorderLayout.CENTER);
		panelCenter.setLayout(null);//Absolute layout
		
		JLabel lblNhapA, lblNhapB, lblNhapC, lblNhapKetQua;
		panelCenter.add(lblNhapA = new JLabel("Nhap a: "));
		int x = 20, y = 40, width = 100, height = 30;
		lblNhapA.setBounds(x, y, width, height);
		
		panelCenter.add(lblNhapB = new JLabel("Nhap b: "));
		y += 50;
		lblNhapB.setBounds(x, y, width, height);
		
		panelCenter.add(lblNhapC = new JLabel("Nhap c: "));
		y += 50;
		lblNhapC.setBounds(x, y, width, height);
		
		panelCenter.add(lblNhapKetQua = new JLabel("Nhap ket qua: "));
		y += 50;
		lblNhapKetQua.setBounds(x, y, width, height);
		
		
		panelCenter.add(txtA = new JTextField());
		x += 100; y = 40; width = 300;
		txtA.setBounds(x, y, width, height);
		
		panelCenter.add(txtB = new JTextField());
		y += 50;
		txtB.setBounds(x, y, width, height);
		
		panelCenter.add(txtC = new JTextField());
		y += 50;
		txtC.setBounds(x, y, width, height);
		
		panelCenter.add(txtKQ = new JTextField());
		y += 50;
		txtKQ.setBounds(x, y, width, height);
		txtKQ.setEditable(false);
		
		//
		JPanel  panelSouth;
		add(panelSouth = new JPanel(),BorderLayout.SOUTH);
		panelSouth.setBorder(BorderFactory.createTitledBorder("Chon tac vu"));
		
		//Default layout cho JPanel 
		panelSouth.add(buttonGiai = new JButton("Giai"));
		panelSouth.add(buttonXoaRong = new JButton("Xoa rong"));
		panelSouth.add(buttonThoat = new JButton("Thoat"));
		
		buttonGiai.addActionListener((ActionListener) this);
		buttonThoat.addActionListener((ActionListener) this);
		buttonXoaRong.addActionListener((ActionListener) this);
	}

	public static void main(String[] args) {
		new baiTap01_GiaiPhuongTrinhBacHai().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
