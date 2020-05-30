package week6;

public interface Controllable {
	default void repair() {
		System.out.println("장비를 수리한다.");	// 디펄트 함수이므로 자식에서 오버라이드 안해도 된다.
	}
	
	static void reset() {
		System.out.println("장비를 초기화한다.");	// 스태틱 함수이므로 오버라이드 불가.
	}
	
	void turnOn();	//추상함수이므로 자식에서 오버라이딩 해줘야 한다.
	void turnOff();	//추상함수이므로 자식에서 오버라이딩 해줘야 한다.

}
