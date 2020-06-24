package FinalProject;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

class setLayoutClass extends JFrame implements ActionListener
{
	//10 10 / 20 10 / 30 20
	int row = 20, colum = 10;
	JFrame frame = new JFrame("test frame");
	GridLayout grid = new GridLayout();
	JButton[][] bt1 = new JButton[10][10];
	JButton[][] bt2 = new JButton[20][10];
	setLayoutClass()
	{
		setMenu();
		setGridLayout2();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	ActionListener action = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object o = e.getSource();
			for(int i=0;i<20;i++)
			{
				for(int j=0;j<10;j++)
				{
					if(bt2[i][j] == o)
					{
						frame.remove(bt2[i][j]);
					}
				}
			}
		}
		
	};
	
	void setGridLayout1()
	{
		row = 10; colum = 10;
		
		frame.setLayout(new GridLayout(10,10));
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				bt1[i][j] = new JButton(i+","+j);
				frame.add(bt1[i][j]);
			}
		}
		frame.setSize(400,420);
		frame.setVisible(true);
	}
	
	void setGridLayout2()
	{
		row = 20; colum = 10;
		frame.setLayout(new GridLayout(20,10));
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				bt2[i][j] = new JButton(i+","+j);
				bt2[i][j].addActionListener(action);
				frame.add(bt2[i][j]);
			}
		}
		frame.setSize(800,420);
		frame.setVisible(true);
	}
	
	void deleteGridLayout2()
	{
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				frame.remove(bt2[i][j]);
			}
		}
	}
	
	void setMenu()
	{
		JMenuBar mb = new JMenuBar();
		JMenu menu1 = new JMenu("클릭");
		
		JMenuItem item = new JMenuItem("크기 변경");
		item.addActionListener(this);
		menu1.add(item);
		mb.add(menu1);
		frame.setJMenuBar(mb);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem mi = (JMenuItem) (e.getSource());
		switch(mi.getText()) {
		case "크기 변경":
			deleteGridLayout2();
			setGridLayout1();
			break;
		}
	}
}

public class TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new setLayoutClass();
		
	}

}
