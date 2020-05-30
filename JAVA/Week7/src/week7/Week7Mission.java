package week7;

import java.util.ArrayList;
import java.util.Scanner;

class Student
{
	private String name = "";
	private char grade = ' ';
	
	public Student(String inputName, char inputGrade)
	{
		name = inputName;
		grade = inputGrade;
	}

	public String getName()
	{
		return name;
	}
	public char getGrade()
	{
		return grade;
	}
}

public class Week7Mission {

	public static void main(String[] args) {
		// while 문으로 exit 까지 반복한다
		// 인덱스 i에 해당하는 학생 클래스의 이름, 등급을 출력하는 시스템
		// 학생클래스를 생성 (이름, 등급)
		// 클래스를 배열에 넣어 배열을 돌리며 출력
		Scanner in = new Scanner(System.in);
		ArrayList<Student> array = new ArrayList<Student>();
		String inputName = "";
		int inputScore;
		char inputGrade = 'a';
		int i = 1;
		
		//입력
		System.out.println("--------------------입력--------------------");
		
		while(!(inputName.equals("exit")))
		{
			System.out.print("학생" + i + "의 이름을 입력하세요? : ");
			inputName = in.next();
			if(inputName.equals("exit"))
			{
				break;
			}
			else
			{
				System.out.print("점수" + i + "을 입력하세요 : ");
				inputScore = in.nextInt();
				
				inputGrade = returnGrade(inputScore);
				//배열에 입력
				array.add(new Student(inputName,inputGrade));
				i++;
			}
		}
		//출력
		System.out.println("--------------------결과--------------------");
		i = 1;
		for(Student s : array)
		{
			System.out.println(i++ + "번 학생 " + s.getName() + "의 등급은 " + s.getGrade() + "입니다.");
		}

	}
	
	public static char returnGrade(int inputGrade)
	{
		char grade;
		if(inputGrade >= 90)
			grade = 'A';
		else if(inputGrade >= 80)
			grade = 'B';
		else if(inputGrade >= 70)
			grade = 'C';
		else if(inputGrade >= 60)
			grade = 'D';
		else
			grade = 'F';
		return grade;
	}

}


