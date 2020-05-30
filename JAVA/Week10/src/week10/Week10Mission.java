package week10;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Week10Mission extends JFrame {
	//12171571 강민상

	Week10Mission() {
		setTitle("지뢰찾기");
		setLayout(new GridLayout(10,20));
		JButton j[] = new JButton[200];
		for(int i=0;i<200;i++)
		{
			j[i] = new JButton();
			add(j[i]);
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Week10Mission();

	}

}
