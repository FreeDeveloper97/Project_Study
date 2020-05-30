package week6;
//12171571 강민상
class Vehicle {
	String name = "탈 것";	// 부모클래스의 필드값
	void whoami() {
		System.out.println("나는 탈 것이다.");	// 부모클래스의 메소드
	}
	static void move() {
		System.out.println("이동하다.");	// static 즉 정적으로 정의했기 때문에 변경없이 "이동하다."
	}
}

class Car extends Vehicle {
	String name = "자동차"; // 자식클래스의 필드값
	void whoami() {
		System.out.println("나는 자동차이다.");	// 자식클래스의 메소드 (오버라이딩)
	}
	static void move() {
		System.out.println("달리다.");	// 부모클래스에서 정적으로 정의했기 때문에 무의미
	}
}
public class OverTypeDemo_Week6Mission_2 {

	public static void main(String[] args) {
		Vehicle v = new Car();	// 객체는 자식클래스를 생성했지만, 시야는 부모클래스로 좁힌다.
		System.out.println(v.name);	// 부모클래스의 필드값을 출력한다.
		v.whoami();	//가장 헷갈리는 부분, 자식클래스의 메소드까지 볼 수 있기 때문에 자식클래스의 메소드 실행
		v.move();	//동적으로 정의한 내용 출력
	}
}
