package Week5;

class Square {
	private String color;
	private int Area;
	
	public Square(String color_input, int Area_input)
	{
		color = color_input;
		Area = Area_input;
	}
	public Square(String color_input)
	{
		color = color_input;
		Area = 1;
	}
	public Square(int Area_input)
	{
		color = "하얀";
		Area = Area_input;
	}
	public Square()
	{
		color = "하얀";
		Area = 1;
	}
	void printSquare()
	{
		System.out.println("이 정사각형은 넓이가 " + Area + "인 " + color + "색 입니다.");
	}
}

public class Week5Mission {
	//12171571 강민상
	public static void main(String[] args) {
		Square s1 = new Square("빨강", 5);
		Square s2 = new Square("주황");
		Square s3 = new Square(3);
		Square s4 = new Square();
		
		s1.printSquare();
		s2.printSquare();
		s3.printSquare();
		s4.printSquare();
	}
}
