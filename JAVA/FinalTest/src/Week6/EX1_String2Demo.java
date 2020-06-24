package Week6;

public class EX1_String2Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "ab";
		String s2 = new String("Ji, Java!");
		String s3 = "aa";
		String s4 = "aac";
		
		System.out.println(s1.equalsIgnoreCase(s4));
		System.out.println(s1.compareTo(s3));
		System.out.println(s1.compareToIgnoreCase(s4));
		System.out.println(s3.compareTo(s4));
	}

}
