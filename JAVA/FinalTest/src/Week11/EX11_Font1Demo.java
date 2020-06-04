package Week11;

import java.awt.GraphicsEnvironment;

public class EX11_Font1Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		String[] fontNames = e.getAvailableFontFamilyNames();
		for(String s : fontNames)
			System.out.println(s);

	} 

}
