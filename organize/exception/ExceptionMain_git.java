package ch12_exception_git;

import java.util.Scanner;

public class ExceptionMain_git {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 에러에는 컴파일 할 때 발생하는 컴파일 오류와
		// 우리가 동작할 때 발생하는 런타임 오류가 있다.
		// 컴파일 오류는 실행하기 전에 알려주므로 잡아내기 쉽다.
		// 하지만 런타임 오류는 잡아내기 어렵다..
		// 이 까다로운 런타임 오류를 자바에서는 에러(Error)와 예외(Exception)으로 보고 있다.
		// 그 중 예외를 처리 하는 것은?
		// try {} catch(){} finally{} 문!
		int a = 10;
		int b = 0;
		
		try {
			int c = a/b;
			// 에러가 발생하면 try의 밑의 줄은 넘어가버린다!
			System.out.println(c);
		}catch(ArithmeticException exception){
			System.err.println("0으로 나눌 수 없습니다!");
			exception.printStackTrace();
		}finally {
			System.out.println("finally");
		}
		
		// ArithmeticException를 타고 가다 보면
		// Exception이 예외처리문들의 최상위 클래스 이다.
		// 그래서 try catch를 할 때
		// 내가 예상하는 예외를 모두 처리하고 마지막에 최상위 클래스 예외처리도 해준다. << 보통 그럼
		
		String[] arrTestStr = {"나는", "박형구", "입니다"};
		try {
			System.out.println(arrTestStr[3]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("인덱스 오류 발생!!");
			e.printStackTrace();
			// 어디서 예외가 발생했는지 출력해주는 함수
		}catch(Exception e) {
			System.out.println("최상위 클래스 오류 발생");
			e.printStackTrace();
		}
		
		
		System.out.println("\n========================================================================================\n");
		
		// 그렇다면 아이디를 만들때 조건을 줘서
		// 예외처리를 해보자
		
		// 아이디는 숫자와 영문의 조합으로 8자 이하로
		// 1. 아이디를 얻는 메소드를 만드는 클래스가 필요하고,
		// 2. 그 메소드안에서 예외처리를 할 나의 예외처리가 필요하고
		// 3. 그 예외처리가 무슨 예외인지 지정하고 알려줄 상수 클래스가 필요하다.
		while(true) {
			
			boolean check = false;
			System.out.println("회원가입할 아이디를 입력해주세요!");
			System.out.print("\n\n>>> ");
			String checkId = scan.nextLine();
			
			try {
				check = RegisteMethod.idCheck(checkId);
			} catch (MyException e) {
				System.out.println("에러코드 : " + e.getErrCode());
				System.out.println("에러메세지 : " + e.getMessage() );
				e.printStackTrace();
			} finally {
				// 보통 finally에는 전에 썼던 객체를 닫아준다
				if(check == true) {
					scan.close();
					break;
				}
			}
		}
		
		// try-with-resource 구문
		// finally를 붙이지 않고 닫기
		// 닫아야할 객체를 try() 괄호 안에 선언 후
		// try 블록{} 내에서 해당 객체를 사용
		// 해당 객체의 클래스가 AutoCloseable 인터페이스를
		// 구현(implements)하고 있어야 한다.
		// catch를 붙이지 않아도 사용 가능

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("아무말이나 입력!");
			System.out.print(">>> ");
			String inputText = sc.nextLine();
			System.out.println(inputText);
		}

		// try() 괄호 안에 객체를 여러개 선언
		try (Scanner sc2 = new Scanner(System.in); Scanner sc3 = new Scanner(System.in)) {
			System.out.print("아무말 두번째: ");
			System.out.println(sc2.nextLine());
			System.out.println("아무말 세번째: ");
			System.out.println(sc3.nextLine());
			// 이후 sc2.close()와 sc3.close()가 자동으로 실행됨
		}

	}

}
