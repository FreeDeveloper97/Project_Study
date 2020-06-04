package Week10;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class EX5_JFrame4Demo extends JFrame {
	EX5_JFrame4Demo() {
		setTitle("안녕, 스윙!");
		
		JPanel p = new JPanel();
		JLabel l = new JLabel("안녕, 스윙!");
		JButton b = new JButton("버튼");
		
		p.add(l);
		p.add(b);
		
		add(p);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EX5_JFrame4Demo();
	}

}
