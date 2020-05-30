package week2;

import java.util.Scanner;

public class week2_mission {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//직사각형의 가로와 세로를 입력 받아 넓이를 구하는 프로그램을 작성하시
		
		int width,height;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("직사각형의 가로와 세로를 입력해주세요");
		System.out.print("가로 : ");
		width = scan.nextInt();
		System.out.print("세로 : ");
		height = scan.nextInt();
		
		System.out.printf("가로 : %d, 세로 : %d, 넓이 : %d",width,height,width*height);
	}
	//12171571 강민상

}
