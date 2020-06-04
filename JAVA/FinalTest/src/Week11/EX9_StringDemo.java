package Week11;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EX9_StringDemo extends JFrame {

	class MyPanel extends JPanel {
		protected void painComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawString("문자열을 그렴보자", 0, 20);
			g.drawString("너만 그리니? 나도 그려 보자!", 50, 50);
		}
	}
	
	EX9_StringDemo() {
		setTitle("문자열 그리기");
		add(new MyPanel());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,450);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EX9_StringDemo();
	}

}
