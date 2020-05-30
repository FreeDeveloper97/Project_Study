package week6;

//import 뜻이 맞으나, 같은 package 상태라 안해도 돌아간다.
import week6.Controllable;
import week6.TV;
import week6.Computer;

public class ControllableDemo_Week6Mission_3 {
	//12171571 강민상
	public static void main(String[] args) {
		Controllable[] controllable = {new TV(), new Computer()};	//배열을 생성 후, TV, Computer 객체를 넣는다.
		
		for (Controllable c : controllable) {	//배열을 c 이름으로 사용한다.
			//	배열의 각 요소, 즉 TV 객체로 반복문 실행 후 Computer 객체로 반복문 실행한다.
			c.turnOn();		// 1. TV의 오바리이드 된 메소드 실행한다.
			c.turnOff();	// 2. TV의 오버라이드 된 메소드 실행한다.
			c.repair();		// 3. TV의 부모(인터페이스) 메소드를 실행한다.
			
			// 4. Computer의 오바리이드 된 메소드 실행한다.
			// 5. Computer의 오버라이드 된 메소드 실행한다.
			// 6. Computer의 부모(인터페이스) 메소드를 실행한다.
		}
		Controllable.reset();	//7. 정적메소드 이므로 부모(인터페이스)의 메소드를 실행한다.
	}
}
