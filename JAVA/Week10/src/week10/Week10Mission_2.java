package week10;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

class OddEvenCounter extends JFrame {
	CardLayout layout;
	
	public void count(int iter) {
		for(int i=0;i<iter-1;i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
			layout.next(this.getContentPane());
		}
	}
	OddEvenCounter() {
		setTitle("홀짝 카운트");
		
		layout = new CardLayout();
		setLayout(layout);
		add("0",new JButton("홀"));
		add("1",new JButton("짝"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
		setVisible(true);
	}
}

public class Week10Mission_2 {
	public static void main(String[] args) {
		new OddEvenCounter().count(5);
	}
}