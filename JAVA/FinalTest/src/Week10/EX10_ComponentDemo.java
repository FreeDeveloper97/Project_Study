package Week10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EX10_ComponentDemo extends JFrame {
	EX10_ComponentDemo() {
		setTitle("원 넓이 구하기");
		setLayout(new BorderLayout(10,10));	//10,10 간격의 보더레이아웃 설정
		
		showNorth();	//북쪽 패널 추가
		showCenter();	//중앙 패널 추가
		showSouth();	//남쪽 패널 추가
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,220);
		setVisible(true);
	}
	
	void showNorth() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel panel = new JPanel(new GridLayout(2,0));	//패널 안에 2행의 그리드레이아웃을 넣는다
		
		JLabel l1 = new JLabel("원의 반지름");
		JLabel l2 = new JLabel("원의 넓이");
		
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		t2.setEnabled(false);
		
		p1.add(l1);	//패널에 반지름 추가
		p1.add(t1);	//패널에 입력칸 추가
		
		p2.add(l2);	//패널에 넓이 추가
		p2.add(t2);	//패널에 입력칸 추가
		
		panel.add(p1);	//한행의 패널을 패널에 추가
		panel.add(p2);	//한행의 패널을 패널에 추가
		
		add(panel, BorderLayout.NORTH); //2행짜리의 내용의 패널을 보더레이아웃의 북쪽에 위치한다
	}
	
	void showCenter() {
		JPanel panel = new JPanel();
		
		JTextArea area = new JTextArea(30,20);	//30,20 크기의 텍스트 영역 생성한다
		area.setText("이 영역에 원의 넓이를\n계산하는 과정이 나타납니다");
		area.setEditable(false);	//수정 불가하게 설정
		area.setForeground(Color.RED);
		
		panel.add(area);	//패널에 텍스트 영역을 추가한다
		add(panel, BorderLayout.CENTER);	//보더레이아웃의 중앙에 패널을 추가 한다
	}
	
	void showSouth() {
		String[] color = {"RED", "BLUE"};
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));	//페날에 중앙위치, 여백이 10인 플로우레이아웃을 추가한다
		
		JButton cal = new JButton("계산");
		JComboBox<String> cb = new JComboBox<>(color);	//콤보박스 안에 배열 형태인 RED, BLUE가 들어간다
		JButton reset = new JButton("리셋");
		
		panel.add(cal);	//페널에 계산버튼 추가한다
		panel.add(cb);	//패널에 콤포박스를 추가한다
		panel.add(reset);	//패널에 리셋 버튼을 추가한다
		
		add(panel, BorderLayout.SOUTH);	//보더레이아웃의 남쪽에 위치한다
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EX10_ComponentDemo();

	}

}
