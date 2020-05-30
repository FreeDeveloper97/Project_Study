package week7;

import java.util.Scanner;

public class Blalala {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("정수를 입력하시오 : ");
		int num = in.nextInt();
		for(int i=1; i <= num; i++)
		{
			if(num % i == 0) //나누어 떨어지는 경우 : 약수일때
			{
				System.out.printf("%3d",i);
			}
		}
	}

}
