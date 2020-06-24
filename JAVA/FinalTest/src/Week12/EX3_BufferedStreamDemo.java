package Week12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EX3_BufferedStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long start, end, duration;
		String beforeBuffer = "/Users/min_macbookpro/before.txt";
		String afterBuffer = "/Users/min_macbookpro/after.txt";
		
		//버퍼있이 시간
		start = System.nanoTime();	//시간을 저장하는 값
		try(BufferedInputStream b_in = new BufferedInputStream(new FileInputStream(beforeBuffer));
				BufferedOutputStream b_out = new BufferedOutputStream(new FileOutputStream(afterBuffer));) {
			while (b_in.available() > 0) {
				int b = b_in.read();
				b_out.write(b);
			}
			b_out.flush();
		}
		catch (IOException e) {}
		
		end = System.nanoTime();
		duration = end - start;
		System.out.println("버퍼있이 : " + duration);
		//버퍼없이 시간
		start = System.nanoTime();
		try(FileInputStream f_in = new FileInputStream(beforeBuffer);
				FileOutputStream f_out = new FileOutputStream(afterBuffer);) {
			while(f_in.available() > 0) {
				int b = f_in.read();
				f_out.write(b);
			}
			f_out.flush();
		}
		catch(IOException e) {}
		
		end = System.nanoTime();
		duration = end - start;
		System.out.println("버퍼없이 : " + duration);
	}

}
