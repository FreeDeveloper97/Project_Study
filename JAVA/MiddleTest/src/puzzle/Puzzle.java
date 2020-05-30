package puzzle;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Puzzle extends JFrame{
	/**
	 * 
	 */
	static int[] randomArray = new int[15];
	private static final long serialVersionUID = 1L;
	int idx=15;
	Puzzle(){
		setLayout(new GridLayout(4,4));
		JButton j[] = new JButton[16];
		//참고하여 수정 1 
		// -> randomArray를 생성하여 random() 함수를 통해 배열 저장
		// -> randomArray 각 인덱스 내용을 JButton에 저장
		setRandom();
		for (int i=0;i<16;i++) {
			if(i==15)
				j[i] = new JButton("");
			else
				j[i] = new JButton("" + randomArray[i]);
				
			
			
			j[i].addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					int key = e.getKeyCode();
					//0  1  2  3
					//4  5  6  7
					//8  9  10 11
					//12 13 14 15
					if(key == 37) {//left
						if (idx%4 != 0)	//가장 왼쪽 idx 값들은 4의배수이기 때문에 아닐경우만 왼쪽이동
						{
							String target = j[idx-1].getText(); //왼쪽값 : target 저장
							j[idx].setText(target);	//기준위치 : target 으로 수정
							j[idx-1].setText("");	//왼쪽칸 : 빈칸으로 수정
							idx=idx-1;	//빈칸위치 : 왼쪽으로 수정
						}
					}
					else if(key == 38) {//up
						if (idx > 3)	//가장 윗행이 아닌경우만 위로이동
						{
							String target = j[idx-4].getText();
							j[idx].setText(target);
							j[idx-4].setText("");
							idx=idx-4;	
						}
											
					}
					else if(key==39) {//right
						if ((idx+1)%4 != 0)	//가장 오른쪽 idx 값들은 4배수-1 이기 때문에 아닐경우만 오른쪽 이동
						{
							String target = j[idx+1].getText();
							j[idx].setText(target);
							j[idx+1].setText("");
							idx=idx+1;
						}
						
					}
					else if(key==40) {//down
						if (idx < 12)	//가장 아래쪽 행이 아닌경우만 아래로 이동
						{
							String target = j[idx+4].getText();
							j[idx].setText(target);
							j[idx+4].setText("");
							idx=idx+4;
						}
						
					}
//					//esc 종료코드
//					else if(key==27){
//						System.exit(0);
//					}
					for (int i = 0; i < 15; i++)
					{
						if (j[i].getText().equals(""+(i+1)))
						{
							if (i == 14)
								System.exit(0);
							else
								continue;
						}
						else
							break;
					}

				} 
			});
			
			
			add(j[i]);
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400,420);
		setVisible(true);
		
		
	}
	public static void main(String[] args) throws IOException {
		
		Puzzle p =new Puzzle();
		int i = (int) ((Math.random())*15); //0~14 랜덤
		System.out.println(i);
		
		// 랜덤하게 생성 
		// 게임 종료 조건 구현 
		// 좌우 이동에 관한 처리 +  위아래 이동에 관한 처리
		
	}
	
	static int random()
	{
		int i = (int) ((Math.random())*15); //0~14 랜덤
		return i+1;
	}
	static void setRandom()
	{
		randomArray[0] = random();
		for(int i = 1; i < 15; i++)
		{
			randomArray[i] = random();
			for(int j = 0; j < i; j++)
			{
				if(randomArray[i] == (randomArray[j]))
					i--;
			}
		}
		
//		//종료 테스트를 위한 내용 (시계방향으로 한바퀴 돌리면 종료)
//		for(int i = 0; i < 8; i++)
//		{
//			randomArray[i] = i+1;
//		}
//		randomArray[8] = 13;
//		randomArray[9] = 9;
//		randomArray[10] = 10;
//		randomArray[11] = 11;
//		randomArray[12] = 14;
//		randomArray[13] = 15;
//		randomArray[14] = 12;
	}
}