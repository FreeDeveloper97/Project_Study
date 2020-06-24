package Week12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EX4_DataStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(DataOutputStream d_out = new DataOutputStream(new FileOutputStream("/Users/min_macbookpro/test.dat"));
				DataInputStream d_in = new DataInputStream(new FileInputStream("/Users/min_macbookpro/test.dat"));) {
			
			d_out.writeDouble(1.0);
			d_out.writeInt(2);
			d_out.writeUTF("three");
			
			d_out.flush();
			
			System.out.println(d_in.readDouble());
			System.out.println(d_in.readInt());
			System.out.println(d_in.readUTF());
		}
		catch(IOException e) {}
	}

}
