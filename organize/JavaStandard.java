package organize;

import java.util.Scanner;

public class JavaStandard {

	public static void main(String[] args) {
		
		/* Day 3
		 * 구글링 하는 방법
		 * 자바 코드 한 줄로 표현하기
		 * 자바 표준 - 출력과 제어문자
		 * 표준입력
		 * 연산자
		 */
		
		
		/* 구글링 하는 방법
		 * stackoverflow를 활용
		 * "(검색어)"를 넣는 항상 포함 사용
		 * -(검색어) 검색어를 제외하기 사용
		 * site : (사이트 url) url 사이트 내에서 검색하기
		 * after : (시간) 시간 이후로의 글 검색하기
		 */
		
		
		// java 한 줄로 표현하기
		String enigma = "너오구늘리뭐너먹구지리";
		String enigmaOne = enigma.replace("너","");
		String enigmaTwo = enigmaOne.replace("리","");
		String enigmaTre = enigmaTwo.replace("구","");
		System.out.println(enigmaTre);
		
		String enigmaRst = enigmaOne + enigmaTwo + enigmaTre;
		System.out.println(enigmaRst);
		
		String Rst = enigma.replace("너", "").replace("리", "").replace("구", "");
		System.out.println(Rst);
		
		System.out.println("\n========================================\n");
		
		/* 자바 표준
		 * 텍스트 출력
		 	* println / print / printf(포멧 문자열, 값)의 차이
		 	* 제어문자 ( \t , \n , \\ \" \')
		 	* 특수문자 출력가능
		 * 표준 입력
		 	* scan
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("나이를 입력해 주세요");
		System.out.print(">>>> ");
		String age = scan.nextLine();
		System.out.println(age + "살 입니다.");
		// scan 기능을 쓸 대는 .nextLine을 활용한다.
		// .nextInt는 \n를 남기기 때문에
		// 후에 .nextLine을 입력한다면 앞의 \n을 인식해서 값이 비게 된다.
		// 숫자를 가져오고 싶다면 .Integar.parseInt(scan.nextLine())를 붙이고 가져온다.
		
		
		System.out.println("\n========================================\n");
		
		/* 연산자
		 	* 증감 연산자
		 	* 대입 연산자
		 	* 산술 연산자
		 	* 문자열 연산
		 	* 비교 연산자
		 */
		
		// 증감 연산자
		int NumFour = 4;
		NumFour++;
		NumFour--;
		System.out.println(NumFour++);
		System.out.println(++NumFour);
		// 순서 차이가 중요하다. 출력되고 증가 , 증가하고 출력
		
		// 대입 연산
		NumFour += 3;
		NumFour -= 3;
		NumFour *= 3;
		NumFour /= 3; // 나누고 몫만 추출
		NumFour %= 3; // 나누고 나머지만 추출
		
		// 산술 연산자
		int numA = 10;
		int numB = 3;
		
		numA = numA + 1;
		System.out.println(numA);
		
		System.out.println("더하기: " + numA + numB); // 문자열로 변환된다.
		System.out.println("더하기: " + (numA + numB));
		System.out.println("빼기: " + (numA - numB));
		System.out.println("곱하기: " + (numA * numB));
		System.out.println("나누기: " + (numA / numB));
		System.out.println("나머지: " + (numA % numB));
		
		// 정수를 나누었을때, 소수점 자리까지 출력되길 원한다면
		double divRst = (double) numA / numB;
		System.out.println(divRst);
		
		
		// 나머지 연산자(%) 쓰는 경우
		
		// 홀수 짝수 판별 시
		int anyNum = 243;
		int remain = anyNum % 2;
		System.out.println(remain);
		
		// 게시판 페이징 구현
		int totalCountGul = 32;  // 게시판에 작성된 총 글의 수
		int showCountOnePage = 10; // 한 게시판에 노출될 글의 수
		
		// 총 페이지 수
		// 32 / 10 = 3.2 >> 올림처리 해야지 4    >> Math.ceil은 올림처 더블로 리턴한다.
//		double countPage =Math.ceil((double) totalCountGul / showCountOnePage);
		int countPage =(int)(Math.ceil((double) totalCountGul / showCountOnePage));
		System.out.println(countPage);
		
		// 마지막 페이지에 있는 글의 수
		// = 32를 10으로 나눈 나머지
		int countLastPageGul = totalCountGul % showCountOnePage;
		System.out.println(countLastPageGul);
		
		// 문자열은 더하면 된다. (이 때, 대입 연산자도 가능)
		
		// 비교 연산자는 true or false
		// == 같은지 != 다른지
		// 한글은 유니코드를 비교해서 글자의 순서를 파악할 수 있다.
		
		// 자바에서는 유독 문자열 파악시 .equals를 써야한다.
		// 스택과 힙의 괴리때문이다.
		String ship = "배";
		String stomach = "배";
		String pear = new String("배");
		
		System.out.println(ship == stomach); // true
		System.out.println(ship == pear); // false
		
		System.out.println(ship.equals(pear)); // true
		
		
		
		
		
		
		
		

	}

}
