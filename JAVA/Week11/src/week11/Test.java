package week11;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MainFrame extends JFrame {
	MainFrame() {
		setTitle("TEST");
		setLayout(new GridLayout(2,6));
		
		add(new MyPanel(0));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(920,304);
		setVisible(true);
	}
}

class MyPanel extends JPanel {
	BufferedImage[] img = new BufferedImage[12];
	public MyPanel(int i) {
		try {
			img[0] = ImageIO.read(new File("Calendar/JAN.png"));
			img[1] = ImageIO.read(new File("Calendar/FEB.png"));
			img[2] = ImageIO.read(new File("Calendar/MAR.png"));
			img[3] = ImageIO.read(new File("Calendar/APR.png"));
			img[4] = ImageIO.read(new File("Calendar/MAY.png"));
			img[5] = ImageIO.read(new File("Calendar/JUN.png"));
			
			img[6] = ImageIO.read(new File("Calendar/JUL.png"));
			img[7] = ImageIO.read(new File("Calendar/AUG.png"));
			img[8] = ImageIO.read(new File("Calendar/SEP.png"));
			img[9] = ImageIO.read(new File("Calendar/OCT.png"));
			img[10] = ImageIO.read(new File("Calendar/NOV.png"));
			img[11] = ImageIO.read(new File("Calendar/DEC.png"));
		} catch (IOException e) {}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i=0;i<12;i++)
		{
			g.drawImage(img[i], 0, 0, null);
		}
//		for(int i=0;i<6;i++)
//		{
//			g.drawImage(img[i], 0, 0, null);
//		}
	}
	
}
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
