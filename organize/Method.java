package review;

public class Method {

	public static void main(String[] args) {

		// 함수 function 혹은 메소드 Method
		// 굳이 둘을 구분하자면 method는 클래스에 종속된 함수
		// function은 클래스에 독립된 함수

		// 함수를 쓰는 이유는
		// 실행부의 코드가 간결해지며
		// 중복된 코드를 한 곳에서 관리할 수 있으므로
		// 수정에 용이하기 때문에 사용한다!

		// 예시로 1부터 100까지 더하는 결과 값,
		// 30부터 60까지 더하는 결과 값
		// 25부터 50까지 더하는 결과 값등을 구하려면
		// 코드를 다 따로 짜줘야 되며 중복된다.
		// 이를 함수로 한방에 가능

		printSum(0, 100);

		// 이때 함수를 정의할 때
		// 자바는 스트링 인트 더블 등 변수의 모양에 따라
		// 함수를 다 설정해줘야 한다.

		// 그런데 편의상 한 클래스 내에 이름이 같은 메소드들을
		// 파라미터를 다르게 하여 정의하는데
		// 이를 메소드 오버로딩이라 한다.

		print(23);
		print("이십삼");
		print(23.0);

		// 인트값을 리턴하는 절대값 함수
		absolute(-29);
		// 이러면 출력하지 않음
		int absolute = absolute(-29);
		System.out.println(absolute);
		System.out.println(absolute(28));

	} // main 끝

	static void printSum(int a, int b) {
		int sum = 0;
		for (int i = a; i <= b; i++) {
			sum += i;
		}
		System.out.println(sum);
	} // 리턴이 없고 출력에만 필요한 함수에는 void를 명시한다.

	// 메소드 오버로딩
	static void print(int num) {
		System.out.println(num);
	}

	static void print(String srt) {
		System.out.println(srt);
	}

	static void print(Double dbl) {
		System.out.println(dbl);
	}

	// 리턴이 있는 함수는 리턴할 형식을 명시해 준다.
	// 인트값을 리턴하는 절대값 함수
	static int absolute(int num) {
		if (num < 0) {
			num *= -1;
		}
		return num;
	}

	// 부록
	// while문에서 상위의 while문을 종료하기 위해서는
	// 이름을 지어주고 break name; 으로 종료했었다.
	// 하지만 이를 함수로도 가능하게 해준다.
	// 리턴 타입이 없는 void의 경우
	// return을 하게되면 메소드가 종료된다.
	// 즉, break name;을 return;이 대신함

}
