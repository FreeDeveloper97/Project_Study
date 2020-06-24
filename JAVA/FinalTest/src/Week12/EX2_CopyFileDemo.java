package Week12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EX2_CopyFileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "/Users/min_macbookpro/before.txt";
		String output = "/Users/min_macbookpro/after.txt";
		
		try(FileInputStream f_in = new FileInputStream(input);
				FileOutputStream f_out = new FileOutputStream(output);) {
			int c;
			
			while((c = f_in.read()) != -1)		//더이상 자료가 없는 경우 -1을 반환한다
				f_out.write(c);
			System.out.println("성공!");
		}
		catch(IOException e) {}
	}

}
