package Week11;

import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class EX5_AdjustmentListenerDemo extends JFrame {
	EX5_AdjustmentListenerDemo() {
		setTitle("스크롤바 움직이기");
		
		JLabel label = new JLabel("",JLabel.CENTER);
		JScrollBar bar = new JScrollBar(JScrollBar.HORIZONTAL);
		
		bar.setValues(10, 50, 0, 250);
//		bar.setValues(50, 10, 0, 100);
		bar.addAdjustmentListener(e -> {
			int v = e.getValue();
			label.setText("위치 : " + v);
		});
		
		add("Center",label);
		add("North",bar);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EX5_AdjustmentListenerDemo();
	}

}
