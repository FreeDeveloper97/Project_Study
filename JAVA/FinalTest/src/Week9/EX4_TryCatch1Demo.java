package Week9;

public class EX4_TryCatch1Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {0,1,2};
		try {
			System.out.println("마지막 원소 => " + array[3]);
			System.out.println("첫 번째 원소 => " + array[0]);
		}catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("원소가 존재하지 않습니다.");
		}
		System.out.println("어이쿠!!!"); //항상 실행
	}

}
