package week11;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex1_ColorDemo extends JFrame {

	Ex1_ColorDemo() {
		setTitle("색상 변환하기");
		JButton b = new JButton("색상 변환");
		Color color = new Color(64,64,64);
		
		b.addActionListener(e -> {
			b.setBackground(color);
		});
		
		add(b);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex1_ColorDemo();
	}

}
