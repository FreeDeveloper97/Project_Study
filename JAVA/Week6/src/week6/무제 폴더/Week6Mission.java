package week6;

interface Grade{
	void setScore();
	default void JOptionPane()
	{
		
	}
}

class MiddeGrade implements Grade{
	static char math;
	static char english;
	static char science;
	
	public void setScore()
	{
		math = JOptionPane.showInputDialog(null,"수학 등급을 입력하세요.","중학교", JOptionPane.INFORMATION_MESSAGE).charAt(0);
	}

}

class HighGrade implements Grade{

}


class UnivGrade implements Grade{

	
}

public class Week6Mission {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Grade grade[] = {new MiddeGrade(), new HighGrade(), new UnivGrade()};
				for (Grade g : grade) {
					g.setScore();
				}
				for (Grade g : grade) {
					g.printScore();
				}

	}

}
