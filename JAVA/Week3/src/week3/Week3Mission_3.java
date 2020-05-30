package week3;

import java.util.Scanner;

public class Week3Mission_3 {

	public static void main(String[] args) {
		//1:정수(2~9) : 구구단 출력
		//2:x,y 나머지 구하기
		// 12171571 강민상
		int choice;
		Scanner in = new Scanner(System.in);
		System.out.println("수행할 작업을 선택하세요. 1 : 구구단 출력, "
				+ "2 : 두 정수 x,y에 대한 x를 y로 나눈 나머지 출력.");
		choice = in.nextInt();
		
		switch(choice)
		{
		case 1:
			int i = 1, dan = 0;
			System.out.println("몇단을 출력하실건가요 : ");
			dan = in.nextInt();
			
			if(dan >= 2 && dan <= 9) //예외상황 거르기
			{
				System.out.println(dan + " * " + i + " = " + dan*i++);
				System.out.println(dan + " * " + i + " = " + dan*i++);
				System.out.println(dan + " * " + i + " = " + dan*i++);
				System.out.println(dan + " * " + i + " = " + dan*i++);
				System.out.println(dan + " * " + i + " = " + dan*i++);
				System.out.println(dan + " * " + i + " = " + dan*i++);
				System.out.println(dan + " * " + i + " = " + dan*i++);
				System.out.println(dan + " * " + i + " = " + dan*i++);
				System.out.println(dan + " * " + i + " = " + dan*i);
				
				i = 1;
			}
			else //예외상황일 경우 출력
			{
				System.out.println("입력이 잘못 되었습니다.");
			}
			break;
		case 2:
			int x = 0,y = 0;
			System.out.println("x를 입력하세요 : ");
			x = in.nextInt();
			System.out.println("y를 입력하세요 : ");
			y = in.nextInt();
			
			if(y!=0) //예외상황 거르기
			{
				System.out.println("x를 y로 나눈 나머지는 " + x%y + "입니다.");
				x = 0; y = 0;
			}
			else //예외상황일 경우 출력
			{
				System.out.println("입력이 잘못 되었습니다.");
			}
			break;
		default: //잘못입력 경우
			System.out.println("입력이 잘못 되었습니다.");
				
		}

	}

}
