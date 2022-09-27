package ch02_variable;

public class VariableMain {

	public static void main(String[] args) {
		// 변수의 선언
		// [변수 타입] [변수명] 의 형태
		int myMoney;
		
		// 값을 담지 않은 경우 사용할 수 없다. (오류가 난다)
//		System.out.println(myMoney);
		
		// 변수에 값 할당
		// 변수에 값을 할당하는 작업에 대해
		// 변수 초기화(Initialization = init) 라고 함
		myMoney = 10_000_000; // 숫자의 세자리마다 , 기능을 언더바로 대체
		System.out.println(myMoney);
		
		// 변수의 선언과 함께 값을 할당
		int numOne = 1;
		double pi = 3.14;
		System.out.println(pi);
		
		// 변수의 다중 선언
		int numTwo, numThree; // = int numTwo; int numThree;
		numTwo = 2;
		numThree = 3;
		System.out.println(numTwo + numThree);
		
		// 값을 넣어주면서 다중 선언할 수는 없다.
//		int a, b, c = 1, 2, 3; // 이게 가능한 프로그래밍 언어도 존재
		
		// 변수에 담긴 값 확인
		System.out.println(numThree);
		System.out.println(numThree+numOne);
		
		// 변수의 값 변경
		// 등호(=)를 이용하여 변수에 값을 변경할 수 있다.
		// 등호의 의미는 등호 오른쪽의 값을 왼쪽에 담는다는 의미이다. << 입문자에게 헷갈린다.
		// 등호(=)는 담는다. 등호 두 개(==)는 같다.
		numOne = 10;
		System.out.println(numThree+numOne);
		
		// 상수의 선언
		final double MATH_PI = 3.141592;
//		MATH_PI = 3.2; // 앞에 final을 붙이지 않으면 변수로 적용된다.
		// 따라서 상수로 적용을 하려면 final을 붙여야 한다.
		// 값을 바꿀 일이 없는 경우 상수로 담아서 사용한다.
		
		System.out.println(MATH_PI);
		
		System.out.println("\n==============================================\n");
		
		
		// 변수를 사용하는 이유
		
		// 값이 여러곳에 사용되는 경우
		// 변수에 담아서 사용하면
		// 수정이 용이하다.
		
		System.out.println(11);
		System.out.println(11);
		System.out.println(11);
		System.out.println(11);
		System.out.println(11);
		System.out.println(11);
		System.out.println(11);
		System.out.println(11);
		System.out.println(11);
		System.out.println(11);
		
		int printNum = 10;
		
		System.out.println(printNum);
		System.out.println(printNum);
		System.out.println(printNum);
		System.out.println(printNum);
		System.out.println(printNum);
		System.out.println(printNum);
		System.out.println(printNum);
		System.out.println(printNum);
		System.out.println(printNum);
		System.out.println(printNum);
		System.out.println(printNum);
		
		// 변수를 이용하면 값에 이름을 부여할 수 있다.
		System.out.println(24);
		int yejunAge = 24;
		System.out.println(yejunAge);
		
		// 어떠한 값에 대해 이름을 붙여주기 때문에 
		// 어떤 값인지 인지한 상태로 개발할 수 있다.
		// 나중에 해당 코드를 다시 찾아볼 때에도
		// 어떤 값인지 바로 알 수 있을 정도로 변수명을 지어야한다.
		
		System.out.println("\n=============================================================\n");
		
		// String은 많이 쓴다.
		// 문자열 String
		// 문자열은 클래스이므로, 다양한 메소드를 내장하고 있다.
		// 문자열은 쌍따옴표("") 안에 있는 문자들을 말한다.
		// char 타입의 '가'는 String 타입의 "가"와 타입이 다르다.
		String fruits = "Apple, Banana, Cherry";
		System.out.println(fruits);
		
		// .length()
		// 해당 문자열의 길이를 리턴
		System.out.println(fruits.length());
		System.out.println("abcde".length()); // 굳이 변수를 사용하지 않고 해도 되지만, 대부분 변수를 사용한다.
		
		// .charAt(인덱스)
		// 인덱스는 배열에서 몇 번째에 해당하는 숫자를 의미한다.
		// 인덱스는 0부터 시작 (인덱스 0 = 첫번째)
		// 해당 문자열에서 인덱스에 해당하는 문자(char)를 리턴
		char alphaB = fruits.charAt(7);
		System.out.println(alphaB);
		
		// 해당문자열.indexOf(문자열)
		// 해당 문자열에서 괄호 안에 있는 문자열의 인덱스를 리턴한다.
		System.out.println(fruits.indexOf("B"));
		System.out.println(fruits.indexOf("Banana"));
		// 괄호 안의 문자열을 포함하지 않는다면 -1을 리턴한다.
		System.out.println(fruits.indexOf("Melon"));
		// 대소문자를 구분하고, 처음 감지한 인덱스를 리턴한다.
		System.out.println(fruits.indexOf("a"));
		
		// .substring(시작 인덱스, 끝 인덱스)
		// 해당 문자열을 시작 인덱스에서 끝 인덱스 전까지 자른다.
		System.out.println(fruits.substring(7, 13));
		// 원본이 변하진 않는다.
		System.out.println(fruits);
		// 괄호안에 시작 인덱스만 넣으면, 시작 인덱스에서 끝까지 자른다.
		System.out.println(fruits.substring(15));
		
		// .replace(바뀔 문자열, 바꾸고 싶은 문자열)
		// 해당 문자열에서 바뀔 문자열을 바꾸고 싶은 문자열로 대체한다.
		System.out.println(fruits.replace("Cherry", "Coconut"));
		// 이또한 원본이 바뀌지 않는다.
		// 그렇다면 원본을 바꾸려면 어떻게 하느냐
		fruits = fruits.replace("Cherry", "Coconut");
		System.out.println(fruits);
		
		// .trim()  >> 다듬다
		// 해당 문자열의 양끝에 존재하는 모든 공백문자를 제거해준다.
		String hello = "      Hello World!!          ";
		// 리플레이스로 공백을 지울 수 있으나 모든 공백을 지운다.
		System.out.println(hello.replace(" ", ""));
		System.out.println(hello.trim());
		System.out.println(hello);
		
		// .toUpperCase()
		// .toLowerCase()
		// 해당 문자열에 존재하는 알파벳들을 전부 대/소문자로 바꿔준다.
		System.out.println(fruits.toUpperCase());
		System.out.println(fruits.toLowerCase());
		
		// .concat(문자열)
		// 해당 문자열 뒤에 괄호 안 무자열을 붙인다.
		System.out.println(fruits.concat(", Durian"));
		System.out.println(fruits + ", Durian"); // concat 대신 다들 이렇게 쓴다.
		fruits = fruits + ", Durian";
		fruits = "과일목록 : " + fruits;
		System.out.println(fruits);
		
		
		System.out.println("\n=======================================================\n");
		
		// String은 클래스 참조타입이므로 null 값을 가질 수 있다.
		// 참조 타입의 변수를 객체 또는 인스턴스라고 부른다.
		
		// 빈값은 null이 아니라 empty라고 부른다.
		String nothing = "";
		System.out.println(nothing);
		
		String nullthing = null;
		System.out.println(nullthing);
		
		// 둘 다 빈 값이지만, 데이터가 없는 null과
		// 빈 데이터를 가진 "" (empty)는 엄연히 다르다.
		
//		int temp = null; 기본 타입들은 null 값을 가지지 못한다.
		
		System.out.println("\n===============================\n");
		
		// 문자(char)
		// 작은 따옴표('') 안에 한 문자를 담을 수 있으며
		// 숫자 또한 담을 수 있다.
		// 이때의 숫자는 유니코드에 등록된 각 문자들에 대한 넘버링이다.
		
		char wordA = 'A';
		System.out.println(wordA);
		char numA = 65; // A는 유니코드에서 65번째에 위치한다.
		System.out.println(numA);
		
		// 한글 '가'는 유니코드에서 44032번째에 위치
		char hangul = 44032;
		System.out.println(hangul);
		
		hangul++;
		System.out.println(hangul);
		
		// byte는 -128부터 127까지 담을 수 있다.
		byte byteNum = 127;
		byteNum++;
		System.out.println(byteNum);
		byteNum += 5;
		System.out.println(byteNum);
		
		
		System.out.println("\n===============================\n");
		
		
		// 형변환(Casting)
		// 형변환이 가능한 경우, 형변환을 이용해서 적절히 사용할 수 있다.
		int intVal = 15;
		double doubVal = 1.23;
		
		System.out.println(intVal * doubVal);
		
		// int 곱하기 double은 double 타입으로 자동 형변환 된다.
		double mulRst = intVal * doubVal;
		
		System.out.println(mulRst);
		
		// int 곱하기 float은 float 타입으로 자동 형변환 된다.
		float floatVal = 2.34F;
		float floatRst = intVal * floatVal;
		float floatSt = intVal * 3.14F;
		System.out.println(floatRst);
		System.out.println(floatSt);
		
		// int 타입 20000이 long 타입으로 자동 형변환돼서 담긴 것
		long longVal = 20000;
		long longVal2 = 2000042141241561561L;
		System.out.println(longVal);
		System.out.println(longVal2);
		
		// 숫자 더하기(+) 문자열(String)을 하면
		// 숫자가 문자열로 자동 형변환이 돼서
		// 문자열 이어붙이기가 된다.
		String name = "형구 나이";
		String nameAge = name + 30;
		System.out.println(nameAge);
		
		// 강제 형변환
		// (타입) 값 을 이용하면 값을 해당 타입으로 강제 형변환 한다.
		// (가능한 경우에만)
		int intMultiple = (int) (10 * 3.45);
		System.out.println(intMultiple);
		
		// 주의해야할 점 ()로 잘 묶어줘야 한다.
//		intMultiple = (int) 10 * 3.45;  
		intMultiple = 10 * (int) 3.45;
		System.out.println(intMultiple);
		
		// 가장 많이 하는 실수
		double result = 10 / 3; // int와 int가 연산 됐을 때 결과 값은 int가 된다.
		System.out.println(result);
		
		// result가 3.33333... 로 출력될 수 있도록 바꿔보세요.
		result = (double) 10 / (double) 3;
		System.out.println(result);
		result = (double) (10 / 3);
		System.out.println(result);
		
		result = (double) 10 / 3;
		System.out.println(result);
		result = 10.0 / 3;
		System.out.println(result); // 뒤에 5는 컴퓨터는 2진수를 사용하기 때문이다.
		
		// 숫자 문자열과 숫자간의 형변환 (중요)
		String strNum = "123";
		System.out.println(strNum + 10); // 자동으로 숫자가 문자열로 형변환되면서 12310이 출력된다.
		
		// 숫자 문자열을 정수로 형변환
		int intNum = Integer.parseInt(strNum);
		System.out.println(intNum + 10);
		
		// 정수를 문자열로 형변환
		String strNumCast = Integer.toString(intNum); // 굳이 이 방법 보다는
		strNumCast = intNum + ""; // 빈 문자열과 합쳐져서 문자열이 된다.
		System.out.println(strNumCast);
		
		// 소수 문자열을 소수로 형변환
		strNum = "33.54";
		double doubleNum = Double.parseDouble(strNum);
		System.out.println(doubleNum + 5.2);
		
		
		
		
		
		
		
		
	}
	
	
}
