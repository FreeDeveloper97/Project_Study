package FinalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.KeyEvent;

class MainFraim extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame();	//최상위 큰 틀
	JPanel north = new JPanel();	//상단에 지뢰수, 타이머 넣을 패널
	JPanel center = new JPanel();	//중간에 그리드 레이아웃 넣을 패널
	JLabel l1 = new JLabel();		//지뢰수
	JLabel l2 = new JLabel();		//게임상태
	JLabel l3 = new JLabel();		//타이머
	
	int arrayIndex[][] = new int[20][30];		//지뢰 : -1, 그외 : 지뢰근처 카운트수
	int arrayBlue[][] = new int[20][30];		//초기값 : 0, 우클릭 : 1, 클릭 : 2s
	JButton j2[][] = new JButton[20][30];		//그리드 레이아웃에 들어가는 버튼
	
	int row=10, colum=20;				//사이즈 조절을 위한 행렬값
	int status = 2;						//사이즈 조절을 위한값, 1 : 초급, 2 : 중급, 3 : 고급
	int bomCount = 0;					//지뢰수
	int timer = 0;						//타이머
	boolean start = true;				//타이머 첫 작동여부
	boolean statusTimer = true;			//타이머 종료여부
	
	MainFraim() {
		
		setLayout(new BorderLayout());
		setMenu();
		settingSize();
		setGridLayout();
		setArrayRandom();
		setArray();
		setNorth();
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	};
	
	void setMenu() {
		frame.setTitle("지뢰찾기");
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
	
	//상단에 지뢰수, 게임상태, 타이머를 표기하는 메소드
	void setNorth()
	{
		north.setLayout(new FlowLayout(FlowLayout.CENTER,60,10));
		l1.setText("지뢰수 : " + bomCount);
		l2.setText("^^");
		l3.setText("누적시간 : " + timer);
		north.add(l1);
		north.add(l2);
		north.add(l3);
		frame.add(north, BorderLayout.NORTH);
	}
	
	//사이즈 조절을 위한 메소드
	void settingSize()
	{
		switch(status)
		{
		case 1:
			row=10;
			colum=10;
			center.setSize(450,450);
			frame.setSize(450,490);
			break;
		case 2:
			row=10;
			colum=20;
			center.setSize(900,450);
			frame.setSize(900,490);
			break;
		case 3:
			row=20;
			colum=30;
			center.setSize(1350,900);
			frame.setSize(1350,940);
			break;
		}
	}
	
	//그리드 레이아웃에 버튼을 주가하는 메소드, 액션리스테너, 마우스리스테너 추가
	void setGridLayout() {
		center.setLayout(new GridLayout(row,colum));
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<colum;j++)
			{
				j2[i][j] = new JButton();
				
				j2[i][j].addActionListener(action);
				j2[i][j].addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {
						for(int i=0; i<row; i++)
						{
							for(int j=0; j<colum; j++)
							{
								if(j2[i][j]==e.getSource())
								{
									if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
										j2[i][j].setEnabled(false);
										j2[i][j].setBackground(Color.BLUE);
										arrayBlue[i][j]=1;
										bomCount--;
										l1.setText("지뢰수 : " + bomCount);
										if(bomCount < 1)
										{
											endGame();
										}
							        }
								}
							}
						}
					}
					@Override
					public void mousePressed(MouseEvent e) { }
					@Override
					public void mouseReleased(MouseEvent e) { }
					@Override
					public void mouseEntered(MouseEvent e) { }
					@Override
					public void mouseExited(MouseEvent e) { }
				});
				
				center.add(j2[i][j]);
			}
			
		}
		frame.add(center, BorderLayout.CENTER);
	}
	
	//버튼 눌렀을때의 액션 리스테너
	ActionListener action = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//초기에 start값이 true인 1번만 실행
			if(start)
			{
				statusTimer = true;
				setTimer();
			}
			//버튼 클릭시 실행
			for(int i=0; i<row; i++)
			{
				for(int j=0; j<colum;j++)
				{
					if(e.getSource().equals(j2[i][j]))
					{
						j2[i][j].setEnabled(false);
						if(arrayIndex[i][j] != -1)
						{
							if(arrayIndex[i][j]==0) {
								j2[i][j].setText("");
							}
							else {
								j2[i][j].setText(arrayIndex[i][j]+"");
								arrayBlue[i][j]=2;
							}
							
						}
						else
						{
							endGame();
							j2[i][j].setBackground(Color.red);
						}
					}
				}
			}
			//
			if(bomCount < 1)
			{
				endGame();
			}
		}
	};
	
	//게임종료 메소드
	void endGame() {
		for(int i=0; i<row; i++)
		{
			for(int j=0; j<colum; j++)
			{
				if(arrayIndex[i][j] == -1)
				{
					j2[i][j].setText("*");
				}
				j2[i][j].setEnabled(false);
				
			}
		}
		l2.setText("게임 종료");
		statusTimer = false;
	}
	
	//기존 버튼들을 제거하는 메소드
	void deleteGridLayout() {
		for(int i=0; i<row; i++)
		{
			for(int j=0; j<colum; j++)
			{
				j2[i][j].setEnabled(true);
				center.remove(j2[i][j]);
			}
		}
	}
	
	
	
	//게임 시작시 숫자 랜덤으로 정하는 메소드
	void setArrayRandom() {
		for(int i=0;i<row;i++)
		{
			for(int j=0; j<colum; j++)
			{
				j2[i][j].setBackground(null);
				arrayBlue[i][j] = 0;
				//0~9까지 랜점숫자를 뽑아 9인경우만 지뢰로 설정한다
				arrayIndex[i][j] = (int) ((Math.random())*10);
				
				if (arrayIndex[i][j] == 9) {
					arrayIndex[i][j] = -1;
					bomCount++;
				}
				else {
					arrayIndex[i][j] = 0;
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
	
	//지뢰 주위값들 설정하는 메소드
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
	
	//설정된 arrayIndex 값을 JButton에 넣는 메소드
	//저장값 불러와 보여주는 메소드
	private void setArray() {
		for(int i=0;i<row;i++) {
			for(int j=0;j<colum;j++) {
				
				j2[i][j].setVisible(true);
//				if(arrayIndex[i][j] == 0) {
//					j2[i][j].setVisible(false);
//				}
//				else {
					if(arrayBlue[i][j]==1) {
						j2[i][j].setEnabled(false);
						j2[i][j].setBackground(Color.BLUE);
					}
					else if(arrayBlue[i][j]==2) {
						j2[i][j].setEnabled(false);
						j2[i][j].setText(arrayIndex[i][j]+"");
					}
					else
						j2[i][j].setText("");
//				}
			}
		}
		
	}
	
	//저장 눌렀을시 실행되는 메소드
	private void saveData() {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\Users\\Min_Windows\\Downloads\\GameSaveData.dat"));) {
			
			for(int i=0;i<20;i++)
			{
				for(int j=0;j<30;j++)
				{
					int temp = arrayIndex[i][j];
					dos.writeInt(temp);
					System.out.printf("WRITE COMPLITE   :   arrayIndex[%d][%d] : %d\n",i,j,temp);
				}
			}
			for(int i=0;i<20;i++)
			{
				for(int j=0;j<30;j++)
				{
					int temp = arrayBlue[i][j];
					dos.writeInt(temp);
					System.out.printf("WRITE COMPLITE   :   arrayBlue[%d][%d] : %d\n",i,j,temp);
				}
			}
			dos.writeInt(bomCount);
			System.out.printf("WRITE COMPLITE   :   bomCount[%d]\n",bomCount);
			dos.writeInt(timer);
			System.out.printf("WRITE COMPLITE   :   timer[%d]\n",timer);
			dos.writeInt(status);
			System.out.printf("WRITE COMPLITE   :   status[%d]\n",status);
		} catch (IOException e) {}
	}
		
	//불러오기 눌렀을시 실행되는 메소드
	private void readData() {
		try (DataInputStream dis = new DataInputStream(new FileInputStream("C:\\Users\\Min_Windows\\Downloads\\GameSaveData.dat"));) {

			for(int i=0;i<20;i++)
			{
				for(int j=0;j<30;j++)
				{
					int temp = dis.readInt();
					arrayIndex[i][j] = temp;
					System.out.printf("READ COMPLITE   :   arrayIndex[%d][%d] : %d\n",i,j,temp);
				}
			}
			for(int i=0;i<20;i++)
			{
				for(int j=0;j<30;j++)
				{
					int temp = dis.readInt();
					arrayBlue[i][j] = temp;
					System.out.printf("READ COMPLITE   :   arrayBlue[%d][%d] : %d\n",i,j,temp);
				}
			}
			bomCount = dis.readInt();
			System.out.printf("READ COMPLITE   :   bomCount[%d]\n",bomCount);
			timer = dis.readInt();
			System.out.printf("READ COMPLITE   :   timer[%d]\n",timer);
			status = dis.readInt();
			System.out.printf("READ COMPLITE   :   timer[%d]\n",status);
		} catch (IOException e) {}
	}
	
	//메뉴에서 클릭시 각각 실행할 메소드 정의
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem mi = (JMenuItem) (e.getSource());
		
		switch(mi.getText()) {
		case "새 게임" :
			deleteGridLayout();
			restart();
			System.out.println("새 게임"); break;
		case "레벨 선택" :
			System.out.println("레벨 선택"); break;
		case "초급":
			deleteGridLayout();
			status = 1;
			restart();
			System.out.println("초급"); break;
		case "중급":
			deleteGridLayout();
			status = 2;
			restart();
			System.out.println("중급"); break;
		case "고급":
			deleteGridLayout();
			status = 3;
			restart();
			System.out.println("고급"); break;
		case "종료하기" :
			System.exit(0);
			System.out.println("종료하기"); break;
		case "저장" :
			saveData();
			l2.setText("저장 완료");
			System.out.println("저장"); break;
		case "불러오기" :
			System.out.println("불러오기");
			deleteGridLayout();
			readData();
			setNorth();
			settingSize();
			setGridLayout();
			setArray();
			start = true;
			statusTimer = true;
			break;
		case "도움말" :
			System.out.println("도움말"); break;
		}
	}
	
	//세팅메소드 모음 메소드
	void restart() {
		start = true;
		bomCount = 0;
		timer = 0;
		settingSize();
		setGridLayout();
		setArrayRandom();
		setArray();
		setNorth();
	}
	
	//타이머 설정 메소드
	void setTimer()
	{
		new Thread(new Runnable() {
			public void run() {
				while(statusTimer)
				{
					l3.setText("누적시간 : " + timer++);
					try {
						Thread.sleep(1000);
					} catch(InterruptedException e) {}
				}
			}
		}).start();
		start = false;
	}
	
	
	
} //end class


public class GameProject {
	//12171571 강민상
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFraim();

	}
}

