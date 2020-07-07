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
	
	JFrame frame = new JFrame();	//�ֻ��� ū Ʋ
	JPanel north = new JPanel();	//��ܿ� ���ڼ�, Ÿ�̸� ���� �г�
	JPanel center = new JPanel();	//�߰��� �׸��� ���̾ƿ� ���� �г�
	JLabel l1 = new JLabel();		//���ڼ�
	JLabel l2 = new JLabel();		//���ӻ���
	JLabel l3 = new JLabel();		//Ÿ�̸�
	
	int arrayIndex[][] = new int[20][30];		//���� : -1, �׿� : ���ڱ�ó ī��Ʈ��
	int arrayBlue[][] = new int[20][30];		//�ʱⰪ : 0, ��Ŭ�� : 1, Ŭ�� : 2
	JButton j2[][] = new JButton[20][30];		//�׸��� ���̾ƿ��� ���� ��ư
	
	int row=10, colum=20;				//������ ������ ���� ��İ�
	int status = 2;						//������ ������ ���Ѱ�, 1 : �ʱ�, 2 : �߱�, 3 : ���
	int bomCount = 0;					//���ڼ�
	int timer = 0;						//Ÿ�̸�
	boolean start = true;				//Ÿ�̸� ù �۵�����
	boolean statusTimer = true;			//Ÿ�̸� ���Ῡ��
	boolean end = true;					//���� ���Ῡ�� (���ӽ��� ���� �Ǻ���)
	int	howSelect = 200 - bomCount;		//���ڸ� ������ ������ ������ �ִ� ��ư��
	
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
		frame.setTitle("����ã��");
		//JMenuBar > JMenu > JMenuItem
		JMenuBar mb = new JMenuBar();
		JMenu menu1 = new JMenu("����");
		JMenu menu2 = new JMenu("����");
		JMenu menu3 = new JMenu("����");
		JMenuItem item;
		JMenu subMenu = new JMenu("���� ����");
		
		//menu1
		item = new JMenuItem("�� ����");
		item.addActionListener(this);
		menu1.add(item);
		
		//���� ����
		item = new JMenuItem("�ʱ�");
		item.addActionListener(this);
		subMenu.add(item);
		
		item = new JMenuItem("�߱�");
		item.addActionListener(this);
		subMenu.add(item);
		
		item = new JMenuItem("���");
		item.addActionListener(this);
		subMenu.add(item);
		
		menu1.add(subMenu);
		
		menu1.addSeparator();		//����ĭ �߰�
		
		item = new JMenuItem("�����ϱ�");
		item.addActionListener(this);
		menu1.add(item);
		
		//menu2
		item = new JMenuItem("����");
		item.addActionListener(this);
		menu2.add(item);
		
		item = new JMenuItem("�ҷ�����");
		item.addActionListener(this);
		menu2.add(item);
		
		//menu3
		item = new JMenuItem("����");
		item.addActionListener(this);
		menu3.add(item);
		
		//�޴��ٿ� �޴� �߰�
		mb.add(menu1);
		mb.add(menu2);
		mb.add(menu3);
		
		frame.setJMenuBar(mb);
	}
	
	//��ܿ� ���ڼ�, ���ӻ���, Ÿ�̸Ӹ� ǥ���ϴ� �޼ҵ�
	void setNorth()
	{
		north.setLayout(new FlowLayout(FlowLayout.CENTER,60,10));
		l1.setText("���ڼ� : " + bomCount);
		l2.setText("^^");
		l3.setText("�����ð� : " + timer);
		north.add(l1);
		north.add(l2);
		north.add(l3);
		frame.add(north, BorderLayout.NORTH);
	}
	
	//������ ������ ���� �޼ҵ�
	void settingSize()
	{
		switch(status)
		{
		case 1:
			row=10;
			colum=10;
			center.setSize(500,500);
			frame.setSize(500,540);
			break;
		case 2:
			row=10;
			colum=20;
			center.setSize(1000,500);
			frame.setSize(1000,540);
			break;
		case 3:
			row=20;
			colum=30;
			center.setSize(1500,1000);
			frame.setSize(1500,1040);
			break;
		}
	}
	
	//���� ������ Ŭ���� �� �ִ� ��ư�� ���� �޼ҵ�
	void setHowSelect()
	{
		switch(status)
		{
		case 1:
			howSelect = 100-bomCount; break;
		case 2:
			howSelect = 200-bomCount; break;
		case 3:
			howSelect = 600-bomCount; break;
		}
	}
	
	//�׸��� ���̾ƿ��� ��ư�� �ְ��ϴ� �޼ҵ�, �׼Ǹ����׳�, ���콺�����׳� �߰�
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
										//ó�� ��Ŭ���� ���
										if(arrayBlue[i][j] != 1)
										{
											j2[i][j].setBackground(Color.BLUE);
											bomCount--;
											l1.setText("���ڼ� : " + bomCount);
											arrayBlue[i][j]=1;
											System.out.println("bomCount : " + bomCount);
										}
										else
										{
											j2[i][j].setBackground(null);
											bomCount++;
											l1.setText("���ڼ� : " + bomCount);
											arrayBlue[i][j]=0;
											System.out.println("bomCount : " + bomCount);
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
	
	//��ư ���������� �׼� �����׳�
	ActionListener action = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//�ʱ⿡ start���� true�� 1���� ����
			if(start)
			{
				statusTimer = true;
				setTimer();
			}
			//��ư Ŭ���� ����
			for(int i=0; i<row; i++)
			{
				for(int j=0; j<colum;j++)
				{
					if(e.getSource().equals(j2[i][j]))
					{
						if(arrayIndex[i][j] != -1) {
							if(arrayBlue[i][j] != 1)
							{
								j2[i][j].setEnabled(false);
								howSelect--;
								System.out.println("howSelect : " + howSelect);
								if(arrayIndex[i][j]==0) {
									j2[i][j].setText("");
									arrayBlue[i][j]=2;
								}
								else {
									j2[i][j].setText(arrayIndex[i][j]+"");
									arrayBlue[i][j]=2;
								}
								if(howSelect == 0)
								{
									endGame();
//									if(end)
//										endGame2();
								}
							}
						}
						else
						{
							if(arrayBlue[i][j] != 1)
							{
								j2[i][j].setBackground(Color.red);
								endGame2();
							}
						}
						
					}
				}
			}
		}
	};
	
	//�������� �޼ҵ�
	void endGame() {
		System.out.println("endGame()");
		for(int i=0; i<row; i++)
		{
			for(int j=0; j<colum; j++)
			{
				j2[i][j].setEnabled(false);
				if(arrayIndex[i][j] == -1)
				{
					j2[i][j].setText("@");
				}
			}
		}
		l2.setText("CLEAR!!");
		statusTimer = false;
		end = false;
	}
	
	void endGame2()
	{
		for(int i=0; i<row; i++)
		{
			for(int j=0; j<colum; j++)
			{
				j2[i][j].setEnabled(false);
				//������ ���
				if(arrayIndex[i][j] == -1)
				{
					j2[i][j].setText("@");
				}
				//���ڰ� �ƴѵ� ��Ŭ�� �� ���
				else if(arrayBlue[i][j] == 1)
				{
					j2[i][j].setText("X");
				}
			}
		}
		l2.setText("���� ����");
		statusTimer = false;
	}
	
	//���� ��ư���� �����ϴ� �޼ҵ�
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
	
	
	
	//���� ���۽� ���� �������� ���ϴ� �޼ҵ�
	void setArrayRandom() {
		for(int i=0;i<row;i++)
		{
			for(int j=0; j<colum; j++)
			{
				j2[i][j].setBackground(null);
				arrayBlue[i][j] = 0;
				//0~14���� �������ڸ� �̾� 14�ΰ�츸 ���ڷ� �����Ѵ�
				arrayIndex[i][j] = (int) ((Math.random())*15);
				
				if (arrayIndex[i][j] == 14) {
					arrayIndex[i][j] = -1;
					bomCount++;
				}
				else {
					arrayIndex[i][j] = 0;
				}
			}
		}
		
		//-1,0 ���� ���� ���ڿ� �� ���� ���� ī��Ʈ�Ͽ� arrayIndex ������Ʈ�� �Ѵ�
		for(int i=0;i<row;i++)
		{
			for(int ii=0;ii<colum;ii++)
			{
				//�����ΰ�� ����
				if(arrayIndex[i][ii] == -1)
				{
					setRound(i,ii);
				}
			}
		}
	}
	
	//���� �������� �����ϴ� �޼ҵ�
	private void setRound(int I,int J)
	{
		//�������� ���ڰ� �ƴѰ��,�ε����� ������ �ƴѰ�츸 �Ǻ��ϸ� �ȴ�
		for(int i = I-1; i <= I+1; i++)
		{
			for(int j = J-1; j <= J+1; j++)
			{
				//���������� �ε����� ��������� ��
				if((i>=0 && i<=row-1) && (j>=0 && j<=colum-1))
				{
					if(arrayIndex[i][j] != -1)
						arrayIndex[i][j]++;
				}
			}
		}
	}
	
	//������ arrayIndex ���� JButton�� �ִ� �޼ҵ�
	//���尪 �ҷ��� �����ִ� �޼ҵ�
	private void setArray() {
		for(int i=0;i<row;i++) {
			for(int j=0;j<colum;j++) {
				
				j2[i][j].setVisible(true);
//				�ּ� ������ ��ĭ �Ⱥ��̱� ���� (�Ʒ��� �ּ��� ���� ���� �Ͽ��� �Ѵ�!)
//				if(arrayIndex[i][j] == 0) {
//					j2[i][j].setVisible(false);
//				}
//				else {
					if(arrayBlue[i][j]==1) {
						j2[i][j].setBackground(Color.BLUE);
//						//�ּ� ������ ����ǥ�� ����
//						j2[i][j].setText(arrayIndex[i][j]+"");
					}
					else if(arrayBlue[i][j]==2) {
						j2[i][j].setEnabled(false);
						if(arrayIndex[i][j] == 0)
							j2[i][j].setText("");
						else
							j2[i][j].setText(arrayIndex[i][j]+"");
					}
					else {
//						//�ּ� ������ ����ǥ�� ����
//						j2[i][j].setText(arrayIndex[i][j]+"");
						j2[i][j].setText("");
					}
//				�ּ� ������ ��ĭ �Ⱥ��̱� ���� (�� �ּ��� ���� ���� �Ͽ��� �Ѵ�!)
//				}
			}
		}
		
	}
	
	//���� �������� ����Ǵ� �޼ҵ�
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
			dos.writeInt(howSelect);
			System.out.printf("WRITE COMPLITE   :   howSelect[%d]\n",howSelect);
		} catch (IOException e) {}
	}
		
	//�ҷ����� �������� ����Ǵ� �޼ҵ�
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
			System.out.printf("READ COMPLITE   :   status[%d]\n",status);
			howSelect = dis.readInt();
			System.out.printf("READ COMPLITE   :   howSelect[%d]\n",howSelect);
		} catch (IOException e) {}
	}
	
	//�޴����� Ŭ���� ���� ������ �޼ҵ� ����
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem mi = (JMenuItem) (e.getSource());
		
		switch(mi.getText()) {
		case "�� ����" :
			deleteGridLayout();
			restart();
			System.out.println("�� ����"); break;
		case "���� ����" :
			System.out.println("���� ����"); break;
		case "�ʱ�":
			deleteGridLayout();
			status = 1;
			restart();
			System.out.println("�ʱ�"); break;
		case "�߱�":
			deleteGridLayout();
			status = 2;
			restart();
			System.out.println("�߱�"); break;
		case "���":
			deleteGridLayout();
			status = 3;
			restart();
			System.out.println("���"); break;
		case "�����ϱ�" :
			System.exit(0);
			System.out.println("�����ϱ�"); break;
		case "����" :
			saveData();
			l2.setText("���� �Ϸ�");
			System.out.println("����"); break;
		case "�ҷ�����" :
			System.out.println("�ҷ�����");
			deleteGridLayout();
			readData();
			setNorth();
			settingSize();
			setGridLayout();
			setArray();
			start = true;
			statusTimer = true;
			break;
		case "����" :
			System.out.println("����"); break;
		}
	}
	
	//���ø޼ҵ� ���� �޼ҵ�
	void restart() {
		statusTimer = false;
		start = true;
		bomCount = 0;
		timer = 0;
		settingSize();
		setGridLayout();
		setArrayRandom();
		setArray();
		setHowSelect();
		setNorth();
	}
	
	//Ÿ�̸� ���� �޼ҵ�
	void setTimer()
	{
		new Thread(new Runnable() {
			public void run() {
				while(statusTimer)
				{
					l3.setText("�����ð� : " + timer++);
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
	//12171571 ���λ�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFraim();

	}
}

