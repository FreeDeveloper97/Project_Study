package week6;

public class Computer implements Controllable {	//인터페이스를 상속받는다.

	
	public void turnOn() {
		System.out.println("컴퓨터를 켠다.");	//부모클래스에서 추상함수로 만든함수를 오버라이딩 한다.
		
	}

	
	public void turnOff() {
		System.out.println("컴퓨터를 끈다.");	//부모클래스에서 추상함수로 만든함수를 오버라이딩 한다.
		
	}
	

}
