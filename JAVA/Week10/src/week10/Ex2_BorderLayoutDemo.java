package week10;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Ex2_BorderLayoutDemo extends JFrame {

	Ex2_BorderLayoutDemo() {
		setTitle("보더 레이아웃!");
		setLayout(new BorderLayout());
		
		add("East", new JButton("동"));
		add("West", new JButton("서"));
		add("South", new JButton("남"));
		add(new JButton ("북"), BorderLayout.NORTH);
		add(new JButton ("중앙"), BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex2_BorderLayoutDemo();
	}

}
