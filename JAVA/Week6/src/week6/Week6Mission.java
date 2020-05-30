package week6;

import javax.swing.JOptionPane;

interface Grade{
	void setScore();
	void printScore();
}



class MiddeGrade implements Grade{
	static char math;
	static char english;
	static char science;
	public void setScore()
	{
		math = JOptionPane.showInputDialog(null,"수학 등급을 입력하세요.","중학교", JOptionPane.INFORMATION_MESSAGE).charAt(0);
		english = JOptionPane.showInputDialog(null,"영어 등급을 입력하세요.","중학교", JOptionPane.INFORMATION_MESSAGE).charAt(0);
		science = JOptionPane.showInputDialog(null,"과학 등급을 입력하세요.","중학교", JOptionPane.INFORMATION_MESSAGE).charAt(0);
	}
	public void printScore()
	{
		System.out.println("MiddeGrade [ 수학=" + math + ", 영어=" + english + ", 과학=" + science + " ]");
	}

}

class HighGrade implements Grade{
	static int math1;
	static int math2;
	static int english;
	static int physics;
	public void setScore()
	{
		math1 = Integer.parseInt(JOptionPane.showInputDialog(null,"수학1 점수를 입력하세요.","고등학교", JOptionPane.INFORMATION_MESSAGE));
		math2 = Integer.parseInt(JOptionPane.showInputDialog(null,"수학2 점수를 입력하세요.","고등학교", JOptionPane.INFORMATION_MESSAGE));
		english = Integer.parseInt(JOptionPane.showInputDialog(null,"영어 점수를 입력하세요.","고등학교", JOptionPane.INFORMATION_MESSAGE));
		physics = Integer.parseInt(JOptionPane.showInputDialog(null,"물리 점수를 입력하세요.","고등학교", JOptionPane.INFORMATION_MESSAGE));
	}
	public void printScore()
	{
		System.out.println("HighGrade [ 수학1=" + math1 + ", 수학2=" + math2 + ", 영어=" + english + ", 물리=" + physics + " ]");
	}
}


class UnivGrade implements Grade{
	static String java;
	static String english;
	static String oop;
	static String algo;
	public void setScore()
	{
		java = JOptionPane.showInputDialog(null,"자바 학점을 입력하세요.","대학점수", JOptionPane.INFORMATION_MESSAGE);
		english = JOptionPane.showInputDialog(null,"대학영어 학점을 입력하세요.","대학점수", JOptionPane.INFORMATION_MESSAGE);
		oop = JOptionPane.showInputDialog(null,"객체지향 학점을 입력하세요.","대학점수", JOptionPane.INFORMATION_MESSAGE);
		algo = JOptionPane.showInputDialog(null,"자료구조 학점을 입력하세요.","대학점수", JOptionPane.INFORMATION_MESSAGE);
	}
	public void printScore()
	{
		System.out.println("UnivGrade [ 자바=" + java + ", 대학영어=" + english + ", 객체지향=" + oop + ", 자료구조=" + algo + " ]");
	}
	
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
