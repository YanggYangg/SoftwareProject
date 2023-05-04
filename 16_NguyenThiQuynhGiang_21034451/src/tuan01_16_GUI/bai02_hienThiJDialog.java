package tuan01_16_GUI;

import javax.swing.JFrame;

public class bai02_hienThiJDialog extends JFrame  {

	public bai02_hienThiJDialog() {
		setTitle("Demo JDialog");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 200);
		setResizable(false);
	}
	public static void main(String[] args) {
		new bai02_hienThiJDialog().setVisible(true);
	}
}
