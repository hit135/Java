package ch07_array;

public class Array_Git {

	public static void main(String[] args) {
		
		// 배열 (Array)
		// 자바에서 배열의 선언 두가지 방법
		
		// 하나 하나 선언해서 담기
		String apple = "사과";
		String banana = "바나나";
		String melon = "멜론";
		String watermelon = "수박";
		
		// 형식[] name = new 형식[길이];
		String[] fruitArr = new String[4];
		fruitArr[0] = apple;
		fruitArr[1] = banana;
		fruitArr[2] = melon;
		fruitArr[3] = watermelon;
		
		// 한번에 선언해서 담기
		String[] fruitArr2 = { "체리", "앵두", "무화과"};
		
		printArr(fruitArr);
		printArr(fruitArr2);
		
		// 메소드 오버로딩
		int[] num = {22, 33, 44, 11, 52, 31};
		// 오버로딩을 안하면 형식이 바뀌면 오류를 내뱉는다.
		printArr(num);
		
		// 자바에서 배열은 길이가 정해지면
		// 절대...! 바뀌지 않는다.
		// 그리고 배열을 선언한 후 값을 출력하면 
		// default 값을 뱉는다.
		
		String[] dft = new String[3];
		printArr(dft);
		int[] intDft = new int[5];
		printArr(intDft);
		boolean[] boolDft = new boolean[2];
		System.out.println(boolDft[1]);
		double[] douDft = new double[5];
		System.out.println(douDft[4]);
		
		// 기본값(default)
		// 참조타입: null
		// 기본타입(숫자, boolean 값만 있다) << 숫자와 불리언타입 빼고는 전부 참조 타입이라고 이해하면 쉽다.
		// 숫자의 default: 정수 0, 소수 0.0
		// boolean의 default: false
		
		System.out.println("\n============================================================\n");
		
		// 배열의 장점
		// 배열의 내용을 한번에 수정할 수 있다.
		// for문을 이용해 모든 배열을 불러온 다음 수정하면 된다.
		// 이건 쉬우니 패스
		
		// 배열에서 찾아바꿔서 배열을 수정할 수 있다.
		
		// '바나나'를 '참외'로 바꿔라
		
		// 1번째 >>> .contains("")를 이용한 방법
		for(int i = 0; i < fruitArr.length; i++) {
			if(fruitArr[i].contains("바나나")) {
				fruitArr[i] = fruitArr[i].replace("바나나", "참외");
			}
		}
		printArr(fruitArr);
		// 2번째 >>> .indexOf[]를 이용한 방법
		for(int i = 0; i < fruitArr.length; i++) {
			if(fruitArr[i].indexOf("사과") != -1) {
				fruitArr[i] = fruitArr[i].replace("사과", "자두");
			}
		}
		printArr(fruitArr);
		
		System.out.println("\n============================================================\n");
		
		// 받은 문자를 배열로 담기
		
		String nameList = "박형구, 강인구, 이창헌 , 김철우 ,김진우";
		String[] nameListArr = nameList.split(",");
		printArr(nameListArr);
		// 공백이 마음에 들지 않으면 .trim()을 써준다.
		for(int i = 0; i < nameListArr.length; i++) {
			nameListArr[i] = nameListArr[i].trim();
		}printArr(nameListArr);
		
		// 배열의 복사
		// 배열을 String[] newName = fruitArr;
		// 이렇게 해도 newName에 배열이 그대로 담긴다.
		// 하지만 스택에서 얻는 힙 값이 같아지기 때문에
		// newName의 값을 변경하면 fruitArr도 값이 변하게 된다.
		// 그래서 .clone()을 사용!
		String[] newName = fruitArr.clone();
		newName[2] = "새로운 값";
		printArr(newName);
		printArr(fruitArr);
		
		// .clone()을 안쓰고 포문으로 새로운 배열[i] = 기존 배열[i]
		// 을 써서 담을 수도 있다.
		
		
		

	}	// main 끝
	
	static void printArr(String str[]) {
		for(int i = 0; i < str.length; i ++) {
			if(i == str.length - 1) {
				System.out.println(str[i]);
			}else {
				System.out.print(str[i] + ", ");
			}
		}
	}
	static void printArr(int num[]) {
		for(int i = 0; i < num.length; i ++) {
			if(i == num.length - 1) {
				System.out.println(num[i]);
			}else {
				System.out.print(num[i] + ", ");
			}
		}
	}
	
	
	

}
