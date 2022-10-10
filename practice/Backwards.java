package review;

import java.util.Scanner;

public class Backwards {

	public static void main(String[] args) {
		
		
		// 사용자에게 입력받은 문자열을 뒤집어서 출력
		// 로꾸꺼 로꾸꺼 >>> 꺼꾸로 꺼꾸로
		
		// 일단 문자열을 입력받는다
		// 그 후에 입력받은 문자열을 subString을 이용해 뒤집는다.
		// 뒤집은 문자열을 다시 출력
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("거꾸로 뒤집을 문자열 입력: ");
		String input = scan.nextLine();
		
		
		// 반복문을 써서 output에 뒤에서 부터 담는다.
		// 뒤에서 부터는 .length를 이용
		
		
		// 이것은 for문
//				for(int i = input.length(); i > 0; i --) {
//					System.out.print(input.substring(i-1 , i));
//				}
		
		
		
		// 이것은 charAt()
		for(int i = (input.length() - 1); i >= 0; i --) {
			System.out.print((input.charAt(i)+ ""));
		}

	}

}
