package ch08_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

public class CollectionList_Git {

	public static void main(String[] args) {
		
		
		// 리스트(ArrayList) 선언 
		
		// 자바 유틸 불러와야함
		
		// 1. 제너릭 양쪽에 타입을 적어주기
		ArrayList<String> testStr = new ArrayList<String>();
		// 2. 왼쪽의 제너릭에는 넣지 않기
		ArrayList<Integer> testInt = new ArrayList<>();
		
		
		// 알아만 두기
		// 오토 박싱으로
		// Wrapper class의 기본타입 데이터를
		// 객체(참조타입 변수, 인스턴스)로 변환
		// 마찬가지로 오토 언박싱으로
		// 참조타입 변수를 기본타입 변수로 변환
		// 이덕에 Integer와 Int를 신경 안쓰고 쓸 수 있다.
		
		System.out.println("\n================================================================================\n");
		
		// ArrayList의 다양한 함수
		
		// .add(value);
		// 리스트에 값 담기
		testStr.add("테스트1");
		testStr.add("테스트2");
		testStr.add("테스트3");
		testStr.add("테스트4");
		testStr.add("테스트5");
		
		// .size()
		// 배열의 .length와 같음
		System.out.println(".size : " + testStr.size());
		
		// .set(Index, value)
		// 해당 인덱스 안의 값을 value로 교체
		testStr.set(1, "집어넣기");
		System.out.println(".set : " + testStr);
		
		// .get(Index)
		// 해당 인덱스의 값을 리턴
		System.out.println(".get : " + testStr.get(0));
		
		// .contains(value)
		// 리스트 안에 해당 값이 존재하면 true, 존재하지 않으면 false
		System.out.println(".contains : " + testStr.contains("테스트3"));
		
		// .indexOf(value)
		// 리스트에서 해당 값이 존재하는 인덱스 값을 리턴
		System.out.println(".indexOf : " + testStr.indexOf("테스트3"));
		
		// .isEmpty()
		// .size()가 0인지 아닌지 판별 >> 0이면 true
		System.out.println(".isEmpty : " + testStr.isEmpty());
		
		// .remove(Index)
		// 해당 인덱스의 값을 제거
		testStr.remove(0);
		System.out.println(".remove(Index) : " + testStr);
		
		// .remove(value)
		// 리스트에서 해당 값을 제거
		// 리스트에 해당 값이 존재하지 않아도 에러가 뜨지 않는다.
		testStr.remove("집어넣기");
		System.out.println(".remove(value) : " + testStr);
		
		// .clear()
		// 해당 리스트를 비움 (size()가 0이 된다)
		testStr.clear();
		System.out.println(".clear() : " + testStr);
		
		// .clear()를 안쓰고 그냥 리스트를 초기화(Init)해도 된다.
		testStr = new ArrayList<String>();
		
		System.out.println("\n================================================================================\n");
		
		// 배열처럼 for문으로 각 인덱스에 접근 가능
		
		// 배열을 선언하면서 값을 넣을 수 있다.
		testStr = new ArrayList<>(Arrays.asList("test1", "test2", "test3", "test4", "test5", "test6"));
		System.out.println(testStr);
		
		
		// 리스트 복사
		
		// 1. .addAll을 써서
		ArrayList<String> copyList = new ArrayList<>();
		copyList.addAll(testStr);
		System.out.println("copyList = " + copyList);
		
		// 2. 선언하면서
		ArrayList<String> copyList2 = new ArrayList<>(testStr);
		System.out.println("copyList2 = " + copyList2);
		
		// 3. for문을 써서
		ArrayList<String> copyList3 = new ArrayList<>();
		for(int i = 0; i < testStr.size(); i++) {
			copyList3.add(testStr.get(i));
		}
		System.out.println("copyList3 = " + copyList3);
		
		
		System.out.println("\n================================================================================\n");
		
		// 자바에서 foreach문...!
		testStr.forEach(new Consumer<String>() {

			@Override
			public void accept(String testN) {
				System.out.print(testN + " ");
			}
		});
		System.out.println();
		// 복잡하기 때문에 잘 안쓴다.
		
		// 그래서 람다식을 많이 씀
		
		// 람다식
		// 리스트명.forEach(변수명 -> {실행문})
		testStr.forEach(testN -> System.out.print(testN + " "));
		testStr.forEach(testN -> {
			System.out.print("테스트 : ");
			System.out.println(testN);
		});
		
		System.out.println("\n================================================================================\n");
		
		// ArrayList에서 정렬
		testInt = new ArrayList<>(Arrays.asList(1, 42, 546, 765, 12, 54, 2, 5, 62));
		
		// 오름차순
		Collections.sort(testInt);
		System.out.println("오름차순 : " + testInt);
		
		// 내림차순
		Collections.sort(testInt, Collections.reverseOrder());
		System.out.println("내림차순 : " + testInt);
		
		// 정렬에서는?
		int[] testArr = {1,2,3,4,5, 65, 75,234,123};
		Arrays.sort(testArr);
		// Arrays.sort(testArr, Collections.reverseOrder());
		// Integer로 박싱해줘야 한다.
		
		// ArrayList 버블정렬
		
		for(int i = 0; i < testInt.size() -1 ; i++) {
			for(int j = 0; j < testInt.size() -1 -i; j++) {
				// 내림차순은 여기의 부등호만 바꿔주면 된다
				if(testInt.get(j) > testInt.get(j+1)) {
					swap(testInt, j, j+1);
				}
			}
		}
		System.out.println("버블정렬로 오름차순 : " + testInt);
		
		
		
		
	} // main 끝
	
	// 자리바꾸기
	static void swap(ArrayList<Integer> p_array, int indexA, int indexB) {
		p_array.set(indexA, p_array.get(indexA) + p_array.get(indexB));
		p_array.set(indexB, p_array.get(indexA) - p_array.get(indexB));
		p_array.set(indexA, p_array.get(indexA) - p_array.get(indexB));
	}
	
	
	
	
	
	

}
