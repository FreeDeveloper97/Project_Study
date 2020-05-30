package Week5;

class Circle
{
	double radius;
	String color;
	public Circle(double r, String c)
	{
		radius = r;
		color = c;
	}
	public Circle(double r)
	{
		radius = r;
		color = "파랑";
	}
	public Circle(String c)
	{
		radius = 10.0;
		color = c;
	}
	public Circle()
	{
		radius = 10.0;
		color = "빨강";
	}
	public void printCircle()
	{
		System.out.println("radius : " + radius + ", color : " + color);
	}
}
public class Ex3_ConstructorOverloading {

	public static void main(String[] args) {
		Circle c1 = new Circle(10.0,"빨강");
		Circle c2 = new Circle(5.0);
		Circle c3 = new Circle("노랑");
		Circle c4 = new Circle();
		
		c1.printCircle();
		c2.printCircle();
		c3.printCircle();
		c4.printCircle();

	}

}
