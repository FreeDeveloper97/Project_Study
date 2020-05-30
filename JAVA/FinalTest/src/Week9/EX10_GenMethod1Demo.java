package Week9;


class Utils {
	public static <T> void showArray(T[] a) {
		for(T t : a)
			System.out.printf("%s ", t);
		System.out.println();
	}
	
	public static <T> T getLast(T[] a) {
		return a[a.length - 1];
	}
}

public class EX10_GenMethod1Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] ia = {1,2,3,4,5};
		Character[] ca = {'H','E','L','L','O'};
		
		Utils.showArray(ia);
		Utils.<Character>showArray(ca);
		
		System.out.println(Utils.getLast(ia));
	}

}
