package ch06_method;

public class Method01 {

	public static void main(String[] args) {

		// Q.01 명함 만들기

		makeCard("박형구", "010-1234-5678", "hit135@naver.com");
		
		System.out.println("\n================================================\n");

		// Q.02 for문에서 썼던 트리만들기
		// 함수를 이용해 값을 입력하면 그 층의 트리를 만들기

		makeTree(8);
		
		System.out.println("\n================================================\n");

		// Q. 03 십진수로 이진수를 리턴
		// 이진수 (String 타입)
		// makeBinary() 함수.. 근데 함수 안에 넣는 값은 int값
		
		String myBinaryStr = makeBinary(23);
		System.out.println(myBinaryStr);
		System.out.println(makeBinary(46));



	} // main 끝!

	/**
	 * 입력받은 값을 명함 형식으로 출력
	 * 
	 * @param name   입력할 이름
	 * @param phone  입력할 핸드폰 번호
	 * @param e_mail 입력할 이메일
	 */
	static void makeCard(String name, String phone, String e_mail) {
		System.out.println("\n===============================");
		System.out.println("이름 : " + name);
		System.out.println("연락처 : " + phone);
		System.out.println("이메일 : " + e_mail);
		System.out.println("===============================");
	}
	
	/**
	 * 입력한 층수의 트리를 출력
	 * @param floor 출력할 층수
	 */
	
	static void makeTree(int floor) {
		String tree = "";
		for (int i = 0; i <= floor; i++) {
			for (int k = 0; k < (floor - i); k++) {
				tree += " ";
			}

			for (int j = 0; j < ((2 * i) - 1); j++) {
				tree += "*";
			}
			tree += "\n";
		}
		System.out.println(tree);
	}
	
	/**
	 * 십진수 값을 이진수로 변화
	 * @param ten 이진수로 변화시킬 십진수 값
	 * @return 스트링 타입의 이진수 값
	 */
	static String makeBinary(int ten) {

		// 십진수 수를 2로 나눠서
		// 나머지가 홀수면 1을 붙이고
		// 나머지가 짝수면 0을 붙이면 된다!
		// 그런데 십진수 2를 나누면 그 수는 변해야 한다.
		
		String ivsBinaryStr = "";
		
		while (true) {
			if (ten % 2 == 1) { // 홀수일때
				ivsBinaryStr += "1";
			} else if (ten % 2 == 0) { // 짝수일때
				ivsBinaryStr += "0";
			}
			
			if (ten / 2 == 1) {
				ivsBinaryStr += 1;
				break;
			}
			ten = ten / 2;				// 아직도 등호가 같다고 생각을 가지고 있어서 늦게 풀음..
										// 등호는 오른쪽 값이 왼쪽 값이 들어가는 것!
		}
		
		String mybinaryStr = "";
		for(int i = ivsBinaryStr.length() ; i > 0 ; i--) {
			mybinaryStr += ivsBinaryStr.substring(i-1, i);
		}

		return mybinaryStr;
	}

	

}
