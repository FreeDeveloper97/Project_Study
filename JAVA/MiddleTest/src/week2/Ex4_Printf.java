package week2;

public class Ex4_Printf {

	public static void main(String[] args) {
		int i=97;
		String s = "Java";
		double f = 3.14f;
		System.out.printf("%d\n", i);		//97
		System.out.printf("%o\n", i);		//141
		System.out.printf("%x\n", i);		//61
		System.out.printf("%c\n", i);		//a
		System.out.printf("%5d\n", i);		//   97
		System.out.printf("%05d\n", i);		//00097
		System.out.printf("%s\n", s);		//Java
		System.out.printf("%5s\n", s);		// Java
		System.out.printf("%-5s\n", s);		//Java
		System.out.printf("%f\n", f );		//3.140000
		System.out.printf("%e\n", f );		//3.140000e+00
		System.out.printf("%4.1f\n", f );	// 3.1
		System.out.printf("%04.1f\n", f );	//03.1
		System.out.printf("%-4.1f\n", f );	//3.1
		
		String str = Integer.toHexString(i);
		System.out.println(str);
	}

}
