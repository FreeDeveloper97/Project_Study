package Week12;

import java.io.IOException;

public class EX1_IOStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int b, len = 0;
		int ba[] = new int[100];
		
		System.out.println("--- 입력 스트림 ---");
		while((b = System.in.read()) != '\n') {		//입력된 값이 엔터가 아닐경우
			System.out.printf("%c(%d)", (char)b, b);
			ba[len++] = b;
		}
		//입력된 b -> ba[]에 들어간다
		
		System.out.println("\n\n--- 출력 스트림 ---");
		for(int i = 0; i < len; i++)
		{
			System.out.write(ba[i]);	//ba[] -> b로 변환하여 출력헌다
		}
		System.out.flush();	//버퍼를 비운다
		
		System.out.close();	//출력 스트림 종료

	}

}
