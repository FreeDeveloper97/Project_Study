package week2;

import java.util.Scanner;

public class Ex5_Scanner {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		System.out.printf("%d * %d은 %d입니다.\n", x, y, x * y);
	}

}
