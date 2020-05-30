package puzzle;


public class Test2 {
	static String[] random = new String[16];
	static int random()
	{
		int i = (int) ((Math.random())*15); //0~14 랜덤
		return i;
	}
	
//	static boolean trueOrFalse(int num, int i)
//	{
//		for(int j = 0; j < i; j++)
//		{
//			if(random[j].equals(String.valueOf(num)))
//			{
//				return false;
//			}
//			else
//			{
//				if(j == i-1)
//					return true;
//				else
//					continue;
//			}
//		}
//		return false;
//	}
	
	public static void main(String[] args) {
		int number = 2;
		random[0] = String.valueOf(number)+1;
		random[15] = "";
//		boolean breakWhile = true;
		for(int i = 1; i < 15; i++)
		{
			random[i] = random()+1 + "";
			for(int j = 0; j < i; j++)
			{
				if(random[i].equals(random[j]))
					i--;
			}
		}
		for(int i = 0; i < 16; i++)
		{
			System.out.println(i + " : " + random[i]);
		}

	}

}
