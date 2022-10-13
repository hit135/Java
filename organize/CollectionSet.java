package ch08_collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionSet {

	public static void main(String[] args) {
		
		// 집합(Set)의 선언
		HashSet<String> stuSet = new HashSet<String>();
		HashSet<String> stuSet2 = new HashSet<>();
		// 다형성
		Set<String> stuSet3 = new HashSet<String>();
		
		// .add() 값 추가
		stuSet.add("희수");
		stuSet.add("예준");
		stuSet.add("형구");
		stuSet.add("호종");
		
		
		// set은 집합안에 Index없이 값을 집어던져 넣는다.
		// set은 담은 데이터의 순서를 보장하지 않는다.
		System.out.println(stuSet);
		
		// 중복 값을 허용하지 않는다! (에러가 나지는 않음)
		// Index값이 없으므로 중복값을 인식 x
		stuSet.add("희수");
		System.out.println(stuSet);
		
		System.out.println("\n====================================================\n");
		
		// set의 여러 함수
		
		// .contains(값)
		// 해당 값이 Set 안에 있으면 true, 없으면, false
		System.out.println(stuSet.contains("예준"));
		
		
		// .size()
		// Set 내 데이터 개수를 리턴
		System.out.println(stuSet.size());
		
		System.out.println("\n====================================================\n");
		
		// Set 조회
		// 1. while문
		Iterator<String> iterator = stuSet.iterator();
		// Iterator는 기준선부터 차례대로 담는다
		// Iterator타입으로 선언된 name.hasNext()
		// name.next()는 기준선 옆에 값이 출력
		
		while(iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}
		
		// 2. 향상된 for문!!!
		for(String name : stuSet) {
			System.out.print(name + " ");
		}
		System.out.println();
		// 3. forEach문
		stuSet.forEach(name -> System.out.println(name));
		
		
		System.out.println("\n====================================================\n");
		
		// Set은 집합을 쓰는 경우가 아니라면 잘 쓰지 않는다!
		// 그나마 Set을 사용한다면 Set의 중복을 허용하지 않는다는
		// 특성을 이용하는 경우이다.
		
		
		ArrayList<Integer> intList = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			int randInt = (int)(Math.random() * 11) + 10;
			intList.add(randInt);
		}
		System.out.println(intList);
		
		// ArrayList를 HashSet으로 변환
		// 변환이라고 칭하기 보다는 그냥 담는 느낌
		HashSet<Integer> tempSet = new HashSet<>(intList);
		tempSet = new HashSet<>();
		
		tempSet.addAll(intList);
		// 순서가 뒤죽박죽 담긴다..
		System.out.println(tempSet);
		
		tempSet.clear();
		
		for(int i = 0; i < intList.size(); i++) {
			tempSet.add(intList.get(i));
		}
		System.out.println(tempSet);
		
		
		// HashSet을 ArrayList로 담기
		intList.clear();
		intList.addAll(tempSet);
		System.out.println(intList);
		
		intList = new ArrayList<>();
		
//		tempSet.forEach(num -> intList.add(num));
//		왜 오류가 나지?
//		변수 스코프가 작용해서 포이치는 안된다
		
		for(int setInt : tempSet) {
			intList.add(setInt);
		}
		System.out.println(intList);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
