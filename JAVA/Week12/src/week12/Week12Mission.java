package week12;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

class MainFraim extends JFrame implements ActionListener {
	MainFraim() {
		setMenu();
		setGridLayout();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,440);
		setVisible(true);
	};
	void setGridLayout() {
		setTitle("지뢰찾기");
		setLayout(new GridLayout(10,20));
		JButton j[][] = new JButton[20][10];
		
		for(int i=0;i<20;i++)
		{
			for(int ii=0;ii<10;ii++)
			{
				j[i][ii] = new JButton();
				
				j[i][ii].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						for(int I=0;I<20;I++)
						{
							for(int II=0;II<10;II++)
							{
								if(e.getSource().equals(j[I][II]))
								{
									j[I][II].setBackground(Color.black);
									j[I][II].setOpaque(true);
									j[I][II].setBorderPainted(false);
								}
							}
						}
					}
					
				});
				add(j[i][ii]);
			}
			
		}

	}
	void setMenu() {
		//JMenuBar > JMenu > JMenuItem
		JMenuBar mb = new JMenuBar();
		JMenu menu1 = new JMenu("게임");
		JMenu menu2 = new JMenu("파일");
		JMenu menu3 = new JMenu("도움말");
		
		mb.add(menu1);
		mb.add(menu2);
		mb.add(menu3);
		
		JMenuItem item;
		
		item = new JMenuItem("시작하기");
		menu1.add(item);
		item.addActionListener(this);
		item = new JMenuItem("레벨 선택");
		menu1.add(item);
		item.addActionListener(this);
		item = new JMenuItem("종료하기");
		menu1.add(item);
		item.addActionListener(this);
		
		item = new JMenuItem("저장");
		menu2.add(item);
		item.addActionListener(this);
		item = new JMenuItem("불러오기");
		menu2.add(item);
		item.addActionListener(this);
		
		item = new JMenuItem("도움말");
		menu3.add(item);
		item.addActionListener(this);
		
		setJMenuBar(mb);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}


public class Week12Mission {
	//12171571 강민상
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFraim();

	}
}
