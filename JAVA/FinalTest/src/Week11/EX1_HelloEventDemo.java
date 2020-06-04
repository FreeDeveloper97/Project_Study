package Week11;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EX1_HelloEventDemo extends JFrame {

	EX1_HelloEventDemo() {
		setTitle("이벤트 데모");
		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	//이벤트 발생시에 적어야되는 메소드, 오버라이딩이 필요한 부분이다
				// TODO Auto-generated method stub
				System.out.println("버튼을 클릭했습니다.");
				
			}
			
		};
		
		JButton b = new JButton("클릭");
		b.addActionListener(l);		//버튼에 리스너함수와 연동을 추가한다 : addListener 함수
		
		add(b);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(260,100);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EX1_HelloEventDemo();
	}

}
