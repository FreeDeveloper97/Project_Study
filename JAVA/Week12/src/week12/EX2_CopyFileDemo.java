package week12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EX2_CopyFileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "/Users/min_macbookpro/test.txt";
		String output = "/Users/min_macbookpro/out.txt";
		
		try (FileInputStream fis = new FileInputStream(input);
				FileOutputStream fos = new FileOutputStream(output)) {
			int c;
			
			while ((c = fis.read()) != -1)
				fos.write(c);
		} catch (IOException e) {}
		System.out.close();
	}

}
