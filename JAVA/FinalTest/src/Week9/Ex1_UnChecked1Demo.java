package Week9;

import java.util.StringTokenizer;

public class Ex1_UnChecked1Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Time is money";
		StringTokenizer st = new StringTokenizer(s);
		
		while(st.hasMoreElements()) {
			System.out.print(st.nextToken() + "+");
			//NoSuchElementException 발생
		}
		System.out.print(st.nextToken());

	}

}
