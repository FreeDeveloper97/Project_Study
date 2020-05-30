package Week9;

class Cup {
	private Object beverage;
	public Object getBeverage() {
		return beverage;
	}
	public void setbeverage(Object beverage) {
		this.beverage = beverage;
	}
}

class Beer {
	
}
class Boricha {
	
}
public class EX7_GenericClass1Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cup c = new Cup();
		c.setbeverage(new Boricha());
		c.setbeverage(new Beer());
		Beer b1 = (Beer) c.getBeverage();
		Boricha b2 = (Boricha) c.getBeverage(); //Boricah <- Beer 오류발생
	}

}
