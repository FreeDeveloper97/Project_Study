package Week4;

import java.util.Scanner;

public class Week4Mission_2 {

	// 12171571 강민상
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("*을 이용하여 출력할 모양을 입력하세요.");
		System.out.println("1: 왼쪽으로 치우친 아래쪽이 큰 삼각형");
		System.out.println("2: 오른쪽으로 치우친 아래쪽이 큰 삼각형");
		System.out.println("3: 우상단에서 좌하단 부분이 비어있는 정사각형");
		System.out.println("이외의 입력인 경우 종료.");
		int type = in.nextInt(), line;

		while (type >= 1 && type <= 3) {
			System.out.print("출력할 줄의 개수를 입력하세요 : ");
			line = in.nextInt();
			printStar(type, line);

			System.out.println("*을 이용하여 출력할 모양을 입력하세요.");
			System.out.println("1: 왼쪽으로 치우친 아래쪽이 큰 삼각형");
			System.out.println("2: 오른쪽으로 치우친 아래쪽이 큰 삼각형");
			System.out.println("3: 우상단에서 좌하단 부분이 비어있는 정사각형");
			System.out.println("이외의 입력인 경우 종료.");
			type = in.nextInt();
		}
		System.out.println("프로그램이 종료되었습니다.");

	}

	public static void printStar(int type, int line) {
		switch (type) {
		case 1:
			// *
			// **
			for (int i = 1; i <= line; i++) {
				for (int s = 1; s <= i; s++) {
					System.out.print("*");
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 2:
			// *
			//**
			for (int i = 1; i <= line; i++) {
				for (int space = line - i; space > 0; space--) {
					System.out.print(" ");
				}
				for (int s = 1; s <= i; s++) {
					System.out.print("*");
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 3:
			// **
			// * *
			// **
			for (int i = line; i >= 1; i--) {
				for (int s = 1; s <= i - 1; s++) {
					System.out.print("*");
				}
				System.out.print(" ");
				for (int S = 1; S <= line - i; S++) {
					System.out.print("*");
				}
				System.out.println();
			}
			System.out.println();
			break;
		default:
			System.out.println();
		}
	}

}
