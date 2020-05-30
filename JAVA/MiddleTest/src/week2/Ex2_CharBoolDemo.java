package week2;

public class Ex2_CharBoolDemo {

	public static void main(String[] args) {
		char ga1 = '가';
		char ga2 = '\uac00';
		boolean cham = true;
		boolean geojit = false;
		
		System.out.println(ga1);	// 가
		System.out.println(ga2);	// 가
		System.out.println(cham + "가 아니면 " + geojit + "입니다.");	//true, false
	}

}
