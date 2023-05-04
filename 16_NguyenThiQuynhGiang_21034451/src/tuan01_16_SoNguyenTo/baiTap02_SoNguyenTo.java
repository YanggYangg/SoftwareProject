package tuan01_16_SoNguyenTo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class baiTap02_SoNguyenTo  extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField txtN;
	private JButton buttonGenerate;
	private JTextArea taPrimes;
	
	
	
	public baiTap02_SoNguyenTo() {
		setTitle("Primes");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		createGUI();
	}
	
	private void createGUI() {
		setLayout(null);//Absolute layout
		add(txtN = new JTextField());
		txtN.setBounds(50, 30, 200, 30);
		txtN.setToolTipText("Nhap so nguyen to can hien thi");
		
		add(buttonGenerate = new JButton("Generate"));
		buttonGenerate.setBounds(250, 30, 100, 30);
		
		JScrollPane scroll;
		add(scroll = new JScrollPane(taPrimes = new JTextArea()));
		scroll.setBounds(50, 70, 300, 170);
		
		taPrimes.setToolTipText("Danh sach cac so nguyen to.");
		taPrimes.setEditable(false);
		
		//buttonGenerate.addActionListener(new ActionListener());
		
	}
	public static void main(String[] args) {
		new baiTap02_SoNguyenTo().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
