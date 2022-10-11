package park_hyunggoo.submit08;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		
		// Q1 로또 번호 생성기
		// 1~45 까지의 랜덤한 숫자를 출력(중복된 숫자 x)
		// 6개 숫자를 배열에 중복되지 않게 담음
		// 이 배열을 리턴하는 makeLotto() 만들기
		
		
		
		// 배열에 담으나 숫자가 중복되지는 않게
		int[] randomArr = new int[6];
		int randomNum = (int)(Math.random() *45) +1;
		randomArr[0] = randomNum;
		
		for(int i = 1; i < randomArr.length; i++) {
			randomNum = (int)(Math.random() *45) +1;
			
			for(int k = 0; k < i; k++) {
				if(randomNum == randomArr[k]) {
					randomNum = (int)(Math.random() *45) +1;
					k = 0;
				}else {
					randomArr[i] = randomNum;
				}
			}
		}
		int[] myLotto = makeLotto();
		System.out.print("중복없는 랜덤한 숫자 오른차순 배열 = ");
		printArr(myLotto);
		
		
		
		
		
		System.out.println("\n==============================================================\n");
		
		// Q2 선택 정렬 알고리즘!
		
		int[] intArray = {23, 456, 213, 32, 464, 1, 2, 4};
		
		// 1. 최댓값을 찾아 
		// 해당 위치의 값과 배열의 제일 마지막 값을 스왑!
		// 일단 최댓값부터 출력 후에
		// 마지막 값과 스왑한다.
		
		int temp = 0;
		for(int i = 0; i < intArray.length; i++) {
			for(int j = 0; j < i; j++) {
				if(temp > intArray[j]) {
				}else if(temp < intArray[j]) {
					temp = intArray[j];
				}
			}
		}
		
		System.out.println("배열에서의 최댓값 = " + temp);
		for(int i = 0; i < intArray.length; i++) {
			if(intArray[i] == temp) {
				intArray[i] = intArray[i] + intArray[intArray.length -1];
				intArray[intArray.length -1] = intArray[i] - intArray[intArray.length -1];
				intArray[i] = intArray[i] - intArray[intArray.length -1];
				break;
			}
		}
		System.out.print("최댓값만 마지막 항과 바꾼 배열 = ");
		printArr(intArray);
		System.out.println();
		
		// 이제 위 과정을 반복!
		// 하지만 마지막 항은 뺀다!
		
		// 2. 배열의 마지막 값을 제외한
		// 나머지 값들 중 최댓값을 찾아
		// 해당 위치의 값과 배열 마지막 전의 값과 스왑!
		
		// 위 과정을 반복
		for(int k = 0; k < intArray.length; k++) {
			temp = 0;
			for(int i = 0; i < intArray.length - k; i++) {
				for(int j = 0; j <= i; j++) {
					if(temp > intArray[j]) {
					}else if(temp < intArray[j]) {
						temp = intArray[j];
					}
				}
			}
			System.out.println("index[0]부터 " + "index[" + (intArray.length -1 -k) + "]까지 중 최댓값 = " + temp);
			for(int i = 0; i < intArray.length; i++) {
				if(intArray[i] == temp) {
					if(intArray[i] > intArray[intArray.length -1 - k]) {
						intArray[i] = intArray[i] + intArray[intArray.length -1 - k];
						intArray[intArray.length -1 - k] = intArray[i] - intArray[intArray.length -1 - k];
						intArray[i] = intArray[i] - intArray[intArray.length -1 - k];
						break;
					}
				}
			}
		}
		System.out.print("최댓값을 이용해 오름차순 정리 = ");
		printArr(intArray);
		System.out.println();
		
		// @... 이제 반대로 최댓값을 찾아서 내림차순으로 정리
		
		for(int k = 0; k < intArray.length; k++) {
			temp = 0;
			for(int i = k; i < intArray.length; i++) {
				for(int j = k; j <= i; j++) {
					if(temp > intArray[j]) {
					}else if(temp < intArray[j]) {
						temp = intArray[j];
					}
				}
			}
			
			System.out.println("index[" + k + "]부터 index[" + (intArray.length -1) + "]까지 중 최댓값 = " + temp);
			for(int i = 0; i < intArray.length; i++) {
				if(intArray[i] == temp) {
					if(intArray[i] > intArray[k]) {
						intArray[i] = intArray[i] + intArray[k];
						intArray[k] = intArray[i] - intArray[k];
						intArray[i] = intArray[i] - intArray[k];
						break;
					}
				}
			}
		}
		System.out.print("최댓값을 이용해 내림차순 정리 = ");
		printArr(intArray);
		
		
		
		
		

	}	// main 끝
	
	
	static void printArr(int[] p_Arr) {
		for(int i = 0; i < p_Arr.length; i++) {
			if(i == p_Arr.length-1) {
				System.out.println(p_Arr[i]);
			}else {
				System.out.print(p_Arr[i] + ", ");
			}
			
		}
	}
	
	static int[] makeLotto() {
		int[] randomArr = new int[6];
		int randomNum = (int)(Math.random() *45) +1;
		randomArr[0] = randomNum;
		
		for(int i = 1; i < randomArr.length; i++) {
			randomNum = (int)(Math.random() *45) +1;
			
			for(int k = 0; k < i; k++) {
				if(randomNum == randomArr[k]) {
					randomNum = (int)(Math.random() *45) +1;
					k = 0;
				}else {
					randomArr[i] = randomNum;
				}
			}
		}
		Arrays.sort(randomArr);
		return randomArr;
		
	}
	
	
	
	
	
	
	
	
	
	

}
