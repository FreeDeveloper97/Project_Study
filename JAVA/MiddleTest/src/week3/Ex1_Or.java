package week3;

public class Ex1_Or {

	public static void main(String[] args) {
		int x = 0, y = 1;
		System.out.println((x < 1) || (y-- < 1));		//true || (y = 1) 유지
		System.out.println("x = " + x + ", y = " + y);	//0, 1
		
		x = 0;
		y = 1;
		
		System.out.println((x < 1) | (y-- < 1));		//true(1) | true(1), y = 0
		System.out.println("x = " + x + ", y = " + y);	//0, 0

	}

}
