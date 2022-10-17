package review;

import java.util.ArrayList;

public class ClassOrganize {
	
	// ClassOrganize의 상태를 필드변수로 선언
	// 값을 초기화 하지 않아도 된다.
	// 기본값을 주는 3가지 방법
	
	// 기본값을 주는 1번째 방법
	// 필드변수를 선언하면서 주기
	// age에 기본값 30을 줬다.
	
	String name;
	int age = 30;
	int height;
	
	
	// 생성자를 따로 선언을 하면 기본 생성자를 다시 선언해줘야 한다.
	public ClassOrganize(String name, int age, int height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	// 기본값을 주는 2번째 방법
	public ClassOrganize() {
		this.name = "이름 없음";
	}
	
	// 기본값을 주는 3번째 방법
	// height 파라미터를 안 받고
	// 3개의 파라미터를 받는 함수에 집어넣어서 기본값을 넣음
	public ClassOrganize(String name, int age) {
		this(name, age, 170); 
	}
	
	public ClassOrganize(String name) {
		this(name, 30, 170);
	}

	
	// Generate toString
	// Override는 부모 클래스의 메소드를
	// 자식 클래스에서 재정의 하는 것을 의미한다.
	// 무슨 소리인지 확실히 모르겠음..
	// 부모 자식 java 수업 들을 때 집중 필요
	@Override
	public String toString() {
		return "이름: " + name + "\n나이: " + age + "\n키: "+ height;
	}
	
	
	// 접근 제어자
	// 함수 앞에 static을 붙이는 이유를 몰랐다.
	// 하지만 이를 접근 제어자라고 부르며
	// 기입하지 않을 경우 default 접근제어자 등록

	// default는 동일한 패키지(폴더) 내에서만 접근이 가능 (= protected)
	// public은 어디서나 사용 가능
	// private 현재 클래스 내에서만 사용 가능

	// static은 메모리의 hip과 stac과 static이 있는데
	// static에 저장하는 것이다.
	
	/**
	 * 객체의 height에 랜덤한 키 더하기
	 */
	public void heightUp() {
		int randInt = (int)(Math.random() * 10) +1;
		height += randInt;
	}
	/**
	 * 스태틱에 선언된 출력
	 */
	static void printInfo() {
		System.out.println("내 친구들 중 제일 키 큰 사람 찾기");
	}
	
	/**
	 * 정렬을 위한 함수
	 * @param p_class ClassOrganize를 담은 리스트 
	 * @param indexA indexA번째의 값
	 * @param indexB indexB번째의 값
	 * 을 비교해서 indexA가 크면 indexA의 자리와 indexB의 자리를 바꿈
	 */
	static void swap(ArrayList<ClassOrganize> p_class, int indexA, int indexB) {
		ClassOrganize temp = p_class.get(indexA);
		p_class.set(indexA, p_class.get(indexB));
		p_class.set(indexB, temp);
	}
	
	
	
	
	
	
	
}
