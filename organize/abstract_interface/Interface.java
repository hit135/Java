package ch10_extends_interface.abstract_interface;

public interface Interface {
	
	// 인터페이스도 추상함수와 같은 기능을 함
	// 차이점은 인터페이스로 선언하면
	// abstract를 안 써줘도 된다.
	
	public void before();
	
	// 그리고 클래스 상속은 하나만 할 수 있지만
	// 인터페이스는 ,를 이용해 여러가지 가능하다.

	// 이것도 실무에서는 콜백함수를 위해 사용한다.
	
	// 랜덤말 경마(우마무스메)에 콜백함수 구현함
	// 참고 >>> Callback.java , GambleDB 67, GambleDB 315, GambleMain 114
}
