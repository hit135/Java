package ch07_array;

import java.util.Arrays;
import java.util.Collections;

public class Array2 {

	public static void main(String[] args) {
		
		// 배열 두번째
		System.out.println();
		System.out.println("Call by Value 와 Call by Reference");
		
		// Call by Value 와
		// Call by Reference
		
		// Call by Value는 스택에 저장된 값만을 바꾸는 것이다.
		// Call by Reference는 힙의 값을 바꾸기 때문에 배열이 바뀐다.
		
		// 기본타입은 힙의 내용을 출력
		// 참조타입은 스택의 내용을 출력
		
		// 이게 무슨 말이냐.
		
		int a = 10;
		int b = a;
		
		System.out.println(b);
		a= 20;
		System.out.println(b);
		swap(a, b);
		System.out.println("a는 " + a);
		System.out.println("b는 " + b);
		
		int[] numArr = {0, 1, 2, 3, 4, 5, 6};
		swap(numArr[2] , numArr[3]);
		System.out.println("numArr[2]는" + numArr[2]);
		System.out.println("numArr[3]은" + numArr[3]);
		
		// Call by Value
		// 배열이 아닌(참조타입이 아닌) 값만(기본타입)을 함수에 받아와서
		// 변수에 들어간 값은 변하지 않는다. 
		
		swap(numArr, 2, 3);
		System.out.println("numArr[2]는" + numArr[2]);
		System.out.println("numArr[3]은" + numArr[3]);
		
		// Call by Reference
		// 값이 아닌(기본타입이 아닌) 배열(참조타입 >> 기본타입을 뺀 나머지)을
		// 함수에 받아왔기 때문에
		// 변수에 들어간 값은 변한다.
		
		System.out.println("\n============================================================\n");
		
		// 버블 정렬
		int[] randomArr = {123, 4, 543, 12, 45, 65, 78, 4545};
		System.out.println("버블 정렬");
		
		for(int i = 0; i < randomArr.length -1; i ++) {
			// 마지막 값에는 이미 최댓값이 들어갔으므로
			// 굳이 마지막 항까지 반복 할 필요가 없다.
			for(int k = 0; k < randomArr.length - 1 - i; k++) {
				if(randomArr[k] > randomArr[k+1]) {
					swap(randomArr, k, k+1);
					// k번을 빼는 이유는
					// 뒤에서 k번째의 값들에는 정렬된 값이 들어가므로
					// 비교할 필요가 없기 때문이다.
				}
			}
		}
		printArray(randomArr);
		
		System.out.println("\n============================================================\n");
		System.out.println("Arrays함수를 이용해 오름차순 정리");
		int[] anyNum = {23, 54, 675, 1235, 6575, 2, 45};
		Arrays.sort(anyNum);
		printArray(anyNum);
		
		System.out.println("\n============================================================\n");
		
		System.out.println("내림차순");
		// 내림차순
		//Arrays.sort(ages, Collections.reverseOrder());
		
		// 위 방법은 객체(참조타입 변수)를 담은 배열일 경우에만 가능
		// 기본타입인 int배열이 아닌, 참조타입인 Integer 배열은 가능
		// 일단 숫자로 이루어진 참조타입이라고 이해(객체 함수를 사용하기 위해)
		Integer[] integerArr = {23, 42, 125, 65, 21, 87};
		Arrays.sort(integerArr, Collections.reverseOrder());
		
		System.out.print("참조타입(Integer)배열 내림차순 = ");
		for(int i = 0; i < integerArr.length; i++) {
			System.out.print(integerArr[i] + " ");
		}
		
		System.out.println();
		
		// 내림차순 간단하게 하기
		for(int i = 0; i < anyNum.length; i ++) {
			anyNum[i] *= -1;
		}
		Arrays.sort(anyNum);
		for(int i = 0; i < anyNum.length; i ++) {
			anyNum[i] = anyNum[i] * -1;
		}
		System.out.print("-1과 Arrays를 이용한 내림차순 = ");
		printArray(anyNum);
		
		
		System.out.println("\n============================================================\n");

		System.out.println("다차원 배열");
		// 다차원 배열
		// 다차원 배열
		int[] oneDArr = {1, 2, 3};	// 1D
		// 2값을 꺼내자
		System.out.println(oneDArr[1]);
		
		int[][] twoDArr = {{1,2,3}, {4,5,6}, {7,8,9}};	// 2D
		// 1행 1 2 3
		// 2행 4 5 6
		// 3행 7 8 9
		
		// 2행인 {4,5,6}을 꺼내자
		int[] tempArr = twoDArr[1];
		printArray(tempArr);
		
		// 3행의 {7,8,9}에서 2열인 8의 값을 뽑고 싶다
		System.out.println(twoDArr[2][1]);
		
		// 3차원
		int[][][] threeDArr = { {{1,2,3}, {4,5,6}, {7,8,9}}		// 3D
							   ,{{10,11,12}, {13,14,15}, {16,17,18}}
							   ,{{19,20,21}, {22,23,24}, {25,26,27}} };

		// 0층에 행렬
		// 1 2 3
		// 4 5 6
		// 7 8 9
		// 1층에 행렬
		// 10 11 12
		// 13 14 15
		// 16 17 18
		// 2층에 행렬
		// 19 20 21
		// 22 23 24
		// 25 26 27
		
		// 24를 꺼내려면?
		System.out.println(threeDArr[2][1][2]);
		// 8을 꺼내려면?
		System.out.println(threeDArr[0][2][1]);
		

	}	// main 끝
	
	static void printArray(int[] intArray) {
		for(int i = 0; i < intArray.length; i++) {
			if(i == intArray.length - 1) {
				System.out.println(intArray[i]);
			}else {
				System.out.print(intArray[i] + ", ");
			}
		}
	}
	
	
	static void swap(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
	}
	
	static void swap(int[] p_Arr, int indexA, int indexB) {
		p_Arr[indexA] = p_Arr[indexA] + p_Arr[indexB];
		p_Arr[indexB] = p_Arr[indexA] - p_Arr[indexB];
		p_Arr[indexA] = p_Arr[indexA] - p_Arr[indexB];
	}
	
	
	
	
	
	

}
