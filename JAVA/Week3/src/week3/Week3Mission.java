package week3;

import java.util.Scanner;

public class Week3Mission {

	public static void main(String[] args) {
		//입력받은 숫자만큼 *을 출력하는 프로그램을 작성하시오 (switch) 활용
		//12171571 강민상
		Scanner in = new Scanner(System.in);
		
		int num = 0;
		String print = "";
		
		System.out.print("1~10 사이의 숫자를 입력해 주세요 : ");
		num = in.nextInt();
		
		switch(num)
		{
		case 10:
			print += "*";
		case 9:
			print += "*";
		case 8:
			print += "*";
		case 7:
			print += "*";
		case 6:
			print += "*";
		case 5:
			print += "*";
		case 4:
			print += "*";
		case 3:
			print += "*";
		case 2:
			print += "*";
		case 1:
			print += "*";
			break;
		default:
			print = "Error";
			break;
		}
		System.out.println(print);
	}
}
