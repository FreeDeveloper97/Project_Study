package week7;

import java.util.Scanner;

public class Week7Mission_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//셋팅
		int[][] array = new int[10][10];
		for(int i = 0; i < 10; i++)
			array[0][i] = 1; //1행을 1로 셋팅
		
		for(int i = 1; i < 10; i++) //i행 반복
		{
			array[i][0] = 1; //1열 1로 셋팅
			for(int j = 1; j < 10; j++) //j열 반복
			{
				array[i][j] = array[i][j-1] + array[i-1][j]; //각숫자 셋팅
			}
		}
		
		//입력
		int input = in.nextInt();
		
		//과제 출력
		for (int i = 0; i < input; i++)
		{
			System.out.println(array[i][input-i-1]);
		}
		
//		//파스칼 삼각형 출력 내용 구현
//		for (int i = 0; i < input; i++)
//		{
//			for(int j = 0; j <= i; j++)
//			{
//				System.out.printf("%-5d",array[j][i-j]);
//			}
//			System.out.println();
//		}
		
	}

}
