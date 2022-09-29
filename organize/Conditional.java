package ch04_Conditional;

public class Conditional {

	public static void main(String[] args) {
		
		// 조건문
		
		// if 문
		int price = 30000;
		int myMoney = 10000;
		
		if(myMoney < price) {
			System.out.println("돈이 부족합니다.");
		}
		
		// 한줄로 써도 된다. 하지만 지양된다.
		if(myMoney < price) {System.out.println("돈이 부족합니다.");}
		
		System.out.println("\n=================================================\n");
		
		// 변수의 사용범위(Scope)
		// 블록{} 중괄호 안에 선언된 변수는
		// 해당 중괄호 바깥에선 사용할 수 없다. (지역 변수)
		
		String review = "맛없어요!";
		String warning = "";
		if(review.length() < 10 ) {
			warning = "리뷰는 10글자 이상 작성해주세요";
		}
		
		System.out.println(warning); // 위의 if 중괄호 안에서만 유효하기 때문에 인식 못한다.
		// 그러니 전체 지역에 warning을 empty로 선언한 다음에
		// if문을 써준다.
		
		System.out.println("\n===================================================\n");
		
		// else와 else if
		
		int numZero = 0;
		
		if(numZero < 0) {
			System.out.println("numZero가 0보다 작습니다.");
		} else {System.out.println("numZero가 0 이상입니다.");
		}
		
		if(numZero < 0 ) {
			System.out.println("numZero가 0보다 작아요");
		}else if(numZero == 0) {
			System.out.println("numZero가 0이에용");
		}else {
			System.out.println("numZero가 0보다 커용");
		}
		
		System.out.println("\n===================================================\n");
		
		
		// 삼항연산자와의 차이
		String inputData = "100";
		
		String state = "";
		if(inputData.isEmpty()) {
			state = "비어있음";
		}else {
			state = "들어있음";
		}
		System.out.println(state);
		
		// 조건에 따라서 변수에 값을 담는 경우는
		// 삼항연산자가 조금 더 편리하다.
		String state2 = (inputData.isEmpty()) ? ("비어있음") : ("들어있음");
		System.out.println(state2);
		
		System.out.println("\n===================================================\n");
		
		
		// 리모콘의 전원 버튼의 경우
		// 버튼 하나로 on/off가 다 가능하다.
		
		boolean isPowerOn = false;
																//if(true){} else(false){}
		// 전원 버튼을 눌렀을때의 로직
		
		// boolean의 true/false를 스위치의 on/off처럼
		// 사용하는 경우 해당 boolean 변수를
		// 토글(toggle) 혹은 플래그(flag) 변수라고도 한다.
		if(isPowerOn) {
			System.out.println("TV를 끕니다.");
			isPowerOn = false;		//isPowerOn = !isPowerOn
		}else {
			System.out.println("TV를 켭니다.");
			isPowerOn = true;		//isPowerOn = !isPowerOn
		}
		
		System.out.println("\n===================================================\n");
		
		// 주민번호 뒷자리의 첫번째 숫자로 성별 구분
		String idBack = "2345123";
		int first = Integer.parseInt(idBack.substring(0,1));
		
		if(first % 2 == 0) {
			System.out.println("여자");
		}else {
			System.out.println("남자");
		}
		
		// 이중 삼항연산자
		int score = 85;
		String grade = "";
		if(score >= 90) {
			grade = "A";
		}else if(score >= 80) {
			grade = "B";
		}else {
			grade = "C";
		}
		
		System.out.println(grade);
		
		grade = "C";
		if(score >= 90) {
			grade = "A";
		}else if(score >= 80) {
			grade = "B";
		}
		System.out.println(grade);
		
		score = 92;
		
		// 순서에 유의하자!!!!!!!!!!!!!!
		if(score >= 80) {
			grade = "B";
		}else if(score >= 90) {
			grade = "A";
		}else {
			grade = "C";
		}
		System.out.println(grade);						// 값이 B가 나온다.
		
		// 아니면
		if(score >= 80 && score <90) {					// 이렇게 빡세게 조건을 준다.
			grade = "B";
		}else if(score >= 90) {
			grade = "A";
		}else {
			grade = "C";
		}
		
		System.out.println(grade);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
