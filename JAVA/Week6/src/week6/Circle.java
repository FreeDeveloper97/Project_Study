package week6;

class Circle extends Shape{

	int radius;
	
	public Circle(int radius)
	{
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		System.out.println("원을 그리다.");
		
	}
	
	public double findArea() {
		return pi * radius * radius;
	}
	

}
