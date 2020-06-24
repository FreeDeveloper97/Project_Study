package FinalProject;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

class MainFraim extends JFrame implements ActionListener {
	JFrame frame = new JFrame();
	int arrayIndex[][] = new int[20][10];
	JButton j2[][] = new JButton[20][10];
	int row=20, colum=10;
	
	MainFraim() {
		frame.setTitle("지뢰찾기");
		setMenu();
		
		row = 20; colum = 10;
		setGridLayout();
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	};
	
	void setGridLayout() {
		frame.setLayout(new GridLayout(row,colum));
		
		for(int i=0;i<row;i++)
		{
			for(int ii=0;ii<colum;ii++)
			{
				j2[i][ii] = new JButton();
				
				j2[i][ii].addActionListener(action);
				frame.add(j2[i][ii]);
			}
			
		}
		frame.setSize(400,840);
	}
	
	ActionListener action = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			for(int I=0;I<row;I++)
			{
				for(int II=0;II<colum;II++)
				{
					if(e.getSource().equals(j2[I][II]))
					{
						buttonClick(I,II);
					}
				}
			}
		}
	};
	
	void buttonClick(int i, int ii)
	{
		if(arrayIndex[i][ii] != -1)
		{
			j2[i][ii].setBackground(Color.blue);
			j2[i][ii].setOpaque(true);
		}
		else
		{
			j2[i][ii].setBackground(Color.red);
			j2[i][ii].setOpaque(true);
			frame.setTitle("게임 종료");
		}
		
	}
	void setMenu() {
		//JMenuBar > JMenu > JMenuItem
		JMenuBar mb = new JMenuBar();
		JMenu menu1 = new JMenu("게임");
		JMenu menu2 = new JMenu("파일");
		JMenu menu3 = new JMenu("도움말");
		JMenuItem item;
		JMenu subMenu = new JMenu("레벨 선택");
		
		//menu1
		item = new JMenuItem("새 게임");
		item.addActionListener(this);
		menu1.add(item);
		
		//레벨 선택
		item = new JMenuItem("초급");
		item.addActionListener(this);
		subMenu.add(item);
		
		item = new JMenuItem("중급");
		item.addActionListener(this);
		subMenu.add(item);
		
		item = new JMenuItem("고급");
		item.addActionListener(this);
		subMenu.add(item);
		
		menu1.add(subMenu);
		
		
		menu1.addSeparator();		//구별칸 추가
		
		item = new JMenuItem("종료하기");
		item.addActionListener(this);
		menu1.add(item);
		
		//menu2
		item = new JMenuItem("저장");
		item.addActionListener(this);
		menu2.add(item);
		
		item = new JMenuItem("불러오기");
		item.addActionListener(this);
		menu2.add(item);
		
		//menu3
		item = new JMenuItem("도움말");
		item.addActionListener(this);
		menu3.add(item);
		
		//메뉴바에 메뉴 추가
		mb.add(menu1);
		mb.add(menu2);
		mb.add(menu3);
		
		frame.setJMenuBar(mb);
	}
	
	//게임 시작시 숫자 랜덤으로 정하는 메소드
	void setArrayRandom() {
		for(int i=0;i<row;i++)
		{
			for(int ii = 0; ii<colum;ii++)
			{
				
				arrayIndex[i][ii] = (int) ((Math.random())*5);
				j2[i][ii].setBackground(null);
				j2[i][ii].setVisible(true);
			}
		}
		
		//지뢰 : -1, 나머지 : 0으로 arrayIndex 먼저 설정한다
		for(int i=0;i<row;i++)
		{
			for(int ii=0;ii<colum;ii++)
			{
				if (arrayIndex[i][ii] == 4) {
					arrayIndex[i][ii] = -1;
				}
				else {
					arrayIndex[i][ii] = 0;
				}
					
			}
		}
		
		//-1,0 값을 토대로 지뢰와 그 주위 값을 카운트하여 arrayIndex 업데이트를 한다
		for(int i=0;i<row;i++)
		{
			for(int ii=0;ii<colum;ii++)
			{
				//지뢰인경우 설정
				if(arrayIndex[i][ii] == -1)
				{
					setRound(i,ii);
				}
			}
		}
	}
	
	//메뉴에서 클릭시 각각 실행할 메소드 정의
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem mi = (JMenuItem) (e.getSource());
		
		switch(mi.getText()) {
		case "새 게임" :
			System.out.println("새 게임");
			setLayout(null);
			setArrayRandom();
			setArray();
			break;
		case "레벨 선택" :
			System.out.println("레벨 선택"); break;
		case "초급":
			setLayout(null);
			colum = 10;
			setArrayRandom();
			setArray();
			System.out.println("초급"); break;
		case "중급":
			System.out.println("중급"); break;
		case "고급":
			System.out.println("고급"); break;
		case "종료하기" :
			System.exit(0);
			System.out.println("종료하기"); break;
		case "저장" :
			System.out.println("저장");
			saveData(); 
			break;
		case "불러오기" :
			System.out.println("불러오기");
			readData(); 
			break;
		case "도움말" :
			System.out.println("도움말"); break;
		}
	}
	
	//저장 눌렀을시 실행되는 메소드
	private void saveData() {
		// 맥OS에서 돌렸던 절대위치 입니다
//		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("/Users/min_macbookpro/eclipse-workspace-1.8.0/Week12/gameData.dat"));) {
		// 윈도우에서 테스트가 불가하여 돌아가는지 확인 못했습니다..
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\Users\\Administrator\\Downloads\\data.dat"));) {
			
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<colum;j++)
				{
					int temp = arrayIndex[i][j];
					dos.writeInt(temp);
					System.out.printf("WRITE COMPLITE   :   array[%d][%d] : %d\n",i,j,temp);
				}
			}
		} catch (IOException e) {}
	}
	
	//불러오기 눌렀을시 실행되는 메소드
	private void readData() {
		// 맥OS에서 돌렸던 절대위치 입니다
//		try (DataInputStream dis = new DataInputStream(new FileInputStream("/Users/min_macbookpro/eclipse-workspace-1.8.0/Week12/gameData.dat"));) {
		// 윈도우에서 테스트가 불가하여 돌아가는지 확인 못했습니다..
		try (DataInputStream dis = new DataInputStream(new FileInputStream("C:\\Users\\Administrator\\Downloads\\data.dat"));) {
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<colum;j++)
				{
					int temp = dis.readInt();
					arrayIndex[i][j] = temp;
					System.out.printf("READ COMPLITE   :   array[%d][%d] : %d\n",i,j,temp);
				}
			}
			setArray();
		} catch (IOException e) {}
	}
	
	//랜덤으로 나열된 값들을 JButton에 넣는 메소드
	private void setArray() {
		
		for(int i=0;i<row;i++)
		{
			for(int ii=0;ii<colum;ii++)
			{
				if (arrayIndex[i][ii] == -1) {
					j2[i][ii].setText("지뢰");
				}
				else if(arrayIndex[i][ii] == 0) {
//					j[i][ii].setText("");
					j2[i][ii].setVisible(false);
				}
				else {
					j2[i][ii].setText("" + arrayIndex[i][ii]);
				}
					
			}
		}
		
	}
	
	private void setRound(int I,int J)
	{
		//주위에서 지뢰가 아닌경우,인덱스가 정상이 아닌경우만 판별하면 된다
		for(int i = I-1; i <= I+1; i++)
		{
			for(int j = J-1; j <= J+1; j++)
			{
				//지뢰주위의 인덱스가 정상범위일 때
				if((i>=0 && i<=row-1) && (j>=0 && j<=colum-1))
				{
					if(arrayIndex[i][j] != -1)
						arrayIndex[i][j]++;
				}
				
			}
		}
	}
}


public class GameProject {
	//12171571 강민상
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFraim();

	}
}

