package week11;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;



class ImageDemo extends JFrame {
	ImageDemo() {
		setTitle("2020년도 달력");
		add(new MyPanel());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(920,304);
		setVisible(true);
	}
}

class MyPanel extends JPanel {
	BufferedImage[] img = new BufferedImage[12];
	public MyPanel() {
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
		for(int i=0;i<6;i++)
		{
			g.drawImage(img[i], i*154, 0, 150, 150, null);
		}
		for(int i=0;i<6;i++)
		{
			g.drawImage(img[i+6], i*154, 154, 150, 150, null);
		}
	}
}

public class Week11Mission_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ImageDemo();
	}
}
