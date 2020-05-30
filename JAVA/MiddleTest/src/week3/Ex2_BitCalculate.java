package week3;

public class Ex2_BitCalculate {

	public static void main(String[] args) {
		System.out.printf("%x\n", 0b0101 & 0b0011);				//1
		//0101
		//0011
		//0001 -> 1
		System.out.printf("%x\n", 0b0101 | 0b0011);				//7
		//0101
		//0011
		//0111 -> 7
		System.out.printf("%x\n", 0b0101 ^ 0b0011);				//6
		//0101
		//0011
		//0110 -> 6
		System.out.printf("%x\n", (byte) ~0b00000001);			//fe
		//00000001
		//11111110 -> fe
		System.out.printf("%x\n", 0b0110 >> 2);					//1
		//0110 -> 0011 -> 0001 -> 1
		System.out.printf("%x\n", 0b0110 << 2);					//18
		//0110 -> 1100 -> 11000 -> 16+8 = 24 = 18(16진수)
		int i1 = -10;
		//fffffff6
		//10 : 1010 -> 0101 + 1 -> 0110 : 6
		int i2=i1>>1;
		//0110 -> 1011
		System.out.printf("%x\n", i2);
		int i3=i1>>>1; System.out.printf("%x -> %d\n", i1, i1);	//fffffff6 -> -10
		System.out.printf("%x -> %d\n", i2, i2);				//fffffffb -> -5
		System.out.printf("%x -> %d\n", i3, i3);				//7ffffffb -> 2147483643

	}

}
