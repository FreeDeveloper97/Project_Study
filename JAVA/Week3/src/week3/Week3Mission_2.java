package week3;

import java.util.Scanner;

public class Week3Mission_2 {

	public static void main(String[] args) {
		// 조건식 ? 연산식1 : 연산식2
		// 12171571 강민상
		Scanner in = new Scanner(System.in);
		int score = 0;
		char grade = ' ';
		
		System.out.print("점수를 입력해 주세요 : ");
		score = in.nextInt();
		
		grade = (score >= 90) ? 'A' : 
			((score >= 80) ? 'B' : 
				((score >= 70) ? 'C' : 
					((score >= 60) ? 'D' : 'F')));
		
		System.out.println("당신의 학점은 " + grade + "입니다.");
	}

}
