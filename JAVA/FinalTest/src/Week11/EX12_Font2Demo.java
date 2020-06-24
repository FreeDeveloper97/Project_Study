package Week11;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		Font f1 = new Font("TimesRoman", Font.PLAIN, 10);
		Font f2 = new Font("TimesRoman", Font.BOLD, 12);
		Font f3 = new Font("TimesRoman", Font.ITALIC, 14);
		Font f4 = new Font("TimesRoman", Font.BOLD + Font.ITALIC, 16);
		Font f5 = new Font("Helvetica", Font.PLAIN, 18);
		Font f6 = new Font("Courier", Font.PLAIN, 20);
		Font f7 = new Font("Dialog", Font.PLAIN, 22);
		
		g.setFont(f1);
		g.drawString("안녕하세요", 10, 25);
		g.setFont(f2);
		g.drawString("안녕하세요", 10, 50);
		g.setFont(f3);
		g.drawString("안녕하세요", 10, 75);
	}
	MyPanel() {
		
	} 
}
public class EX12_Font2Demo extends JFrame {
	EX12_Font2Demo() {
		setTitle("폰트 설정하기");
		add(new MyPanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,230);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EX12_Font2Demo();
	}

}
