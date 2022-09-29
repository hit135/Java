package ch04_Conditional;

public class OperatorOrganize {

	public static void main(String[] args) {
		
		// 삼항 연산자
		String inputId = "hit135";
		String check = (inputId.length() >= 7) ? "통과" : "아이디는 7글자 이상";
		System.out.println(check);	// 결과값은 통과 or 아이디는 7글자 이상
		
		// 선언문 + (name) = (조건문) ? (참일시) : (거짓일시);
		
		
		// 이중 삼항 연산자
		// 선언문 + (name) = (조건문) ? (참일시) : {거짓일시 + (조건문2) ? (참일시) : (거짓일시)}
		
		// 논리연산자
		// && (and) >> 전부 boolean 값이 true
		// || (or)  >> 하나만 boolean 값이 true
		
		
		
		// 회원가입 예시
		// 이름은 empty가 아니게, 폰 자릿수는 11혹은 10, 나이는 14세 이상 
		String name = "나에용";
		String phone = "01037135569";
		int age = 24;
		
		boolean checkName = !name.isEmpty();
		boolean checkPhone = phone.length() == 10 || phone.length() == 11;
		boolean checkAge = age >= 14;
		
		boolean checkRst = checkName && checkPhone && checkAge;
		System.out.println(checkRst);
		
		
		// 비트 연산자 (면접 혹은 정처기에 나온다)
		// & (비트 and) >> 이진수 자릿수마다 값을 따져서 둘다 1이면 1을 출력
		// | (비트 or) >> 이진수 자릿수마다 값을 따져서 하나라도 1이 있으면 1출력
		// ^ (비트 nor) >> 이진수 자릿수를 따져서 서로 다른 경우에만 1을 출력
		
		int ten = 10; // 1010
		int nine = 9; // 1001
		
		System.out.println(ten & nine);	// 1000
		System.out.println(ten | nine);	// 1011
		System.out.println(ten ^ nine);	// 0011
		
		
		// 16진법
		// 16진수를 10진수로 변환
		String sixteenNum = "13d"; // 10진수가 아닌 숫자는 문자열로 받는다
		int tenNum = Integer.parseInt(sixteenNum, 16);
		System.out.println(tenNum);
		
		// 10진수를 2진수로 변환
		String binaryNum = Integer.toBinaryString(tenNum);
		System.out.println(binaryNum);
		
		
		
		
		
	}

}
