package Week12;

import java.io.File;

public class EX5_FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("/System/Applications");
		File[] fs = file.listFiles();
		
		for(File f : fs)
			if(f.isDirectory())	//폴더가 있는지 판별
				System.out.printf("dir : %s\n",f);	//폴더 출력
			else
				System.out.printf("file : %s(%d bytes)\n",f,f.length());	//파일 출력
	}

}
