package ch10_extends_interface.abstract_interface;

public class Constants_Callback {
	
	// 클래스에서 일정한 값은 보통 Constants라는 클래스를 파서 한번에 관리한다.
	// 여기서 상수들을 관리
	// 예시
	
	// 버서커
	// static은 객체로 등록을 안해도 꺼내 갈 수 있도록!!!!
	public static final int JOB_WARRIOR_BERSERKER = 200;
	// 버서커 스킬 데미지
	public static final int SKILL_DAMAGE_BERSERKER = 100;
	// 팔라딘
	public static final int JOB_WARRIOR_PALADIN = 201;
	// 팔라딘 스킬 데미지
	public static final int SKILL_DAMAGE_PALADIN = 50;
	
	// db에 id값 주는거랑 비슷하다고 처음에는 생각했다.
	// 하지만 enum을 이용해 id값 같이 의미없는 숫자도 쓰지 않도록 하기도 한다.
	// 의미있는 숫자들만 남김
	
	// 콜백함수는 함수를 실행한 클래스(A클래스)에서
	// 받고 싶은 값(B클래스에 있음)이 없을 때
	// 보통 실행부에서 재정의..
	// 이렇게 해서 다른 클래스(B클래스)의 받고싶은 값을 넣어서
	// 함수를 실행시킨다!

}
