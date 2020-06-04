package Week10;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EX4_JFrame3Demo extends JFrame {
	EX4_JFrame3Demo() {
		setTitle("안녕, 스윙!");
		JButton b = new JButton("버튼");
		add(b);	//프레임에 버튼 하나 추가
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EX4_JFrame3Demo();
	}

}
