package tuan01_16_GUI;

import javax.swing.JFrame;

public class bai01_hienThiJFrame extends JFrame {

	public bai01_hienThiJFrame(){
		setTitle("Demo JFrame");
		setSize(300,260);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public static void main(String[] args) {
		new bai01_hienThiJFrame().setVisible(true);
	}
	
}
