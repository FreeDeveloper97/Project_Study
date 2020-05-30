package Week5;

class Phone
{
	String model;
	int value;
	
	void print()
	{
		System.out.println(value + "만원 짜리 " + model + " 스마트폰");
	}
}
public class Ex1_PhoneDemo {

	public static void main(String[] args) {
	Phone myPhone = new Phone();
	myPhone.model = "iphone SE";
	myPhone.value = 62;
	myPhone.print();
	
	Phone yourPhone = new Phone();
	yourPhone.model = "iphone Xr";
	yourPhone.value = 95;
	yourPhone.print();

	}

}
