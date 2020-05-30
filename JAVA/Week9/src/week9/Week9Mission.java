package week9;

class Ticket implements Comparable {
	int no;
	
	public Ticket (int no) {
		this.no = no;			// 5 3 10 7 4 가 여기에 들어가진다
	}
	
	public int compareTo (Object o) {		// <5> <8> 7과 비교
		Ticket t = (Ticket) o;
		return no < t.no ? -1 : (no > t.no ? 1 : 0);	// 5<7, 3<7, 10>7, 7=7, 4<7  
														// -1, -1, 1, 0, -1 반환
	}
}

public class Week9Mission {

	public static <T extends Comparable> int countGT (T[] a, T elem) {		// <3> a : 5,3,10,7,4  elem : 7
		int count = 0;
		for (T e : a) {
			System.out.print(e.compareTo(elem) + " ");	// <4> a와 7을 비교하는메소드 실행
														// <6> 출력 : -1 -1 1 0 -1
			if (e.compareTo(elem) < 0) {	// <7> -1인 경우 카운트
											// <9> -1, -1, 1, 0, -1 각각 비교
				++count;					// <10> 3 저장
			}
		}
		System.out.println();
		return count;						// <11> 3 반환
	}
	public static void main(String[] args) {
		Ticket[] a = { new Ticket(5), new Ticket(3), new Ticket(10), new Ticket(7), new Ticket(4) };
		
		for (Ticket t : a)
			System.out.printf("%d ", t.no);	// <1> 5, 3, 10, 7, 4
		System.out.println();
		
		System.out.println(countGT(a,a[3]));	// <2> T : Ticket형태로 countGT 메소드 실행
												// <6> 출력 : -1 -1 1 0 -1
												// <12> 출력 : 3

	}

}
