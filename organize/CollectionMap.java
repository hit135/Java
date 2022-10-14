package ch08_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionMap {

	public static void main(String[] args) {
		
		// 맵(Map)
		
		// 맵의 선언
		// <>안에는 key의 타입, value의 타입
		HashMap<String, String> stuMap = new HashMap<String, String>();
		HashMap<String, Integer> coinMap = new HashMap<>();
		
		// 다형성
		Map<Integer, String> stuMap2 = new HashMap<>();
		
		// .put(key, value)
		// 맵에 데이터 추가
		// 이또한 순서를 보장하지 않는다.
		stuMap.put("첫째", "기윤");
		stuMap.put("둘째", "형구");
		stuMap.put("셋째", "성식");
		System.out.println(stuMap);
		
		// 맵 또한 Set처럼 중복된 키를 허용하지 않는다. (에러는 안남)
		// 중복된 키를 추가하게 되면 기존 키의 값을 덮어쓴다.
		stuMap.put("셋째", "예준");
		System.out.println(stuMap);
		
		coinMap.put("비트코인", 27_000_000);
		coinMap.put("이더리움", 1_800_000);
		System.out.println(coinMap);
		
		stuMap2.put(0, "희수");
		stuMap2.put(1, "준오");
		stuMap2.put(2, "호종");
		System.out.println(stuMap2);
		
		System.out.println("\n======================================================\n");
		
		// .get(key)
		// key에 해당하는 value를 리턴
		System.out.println(stuMap.get("둘째"));
		// 존재하지 않는 key를 입력하면 null 리턴
		System.out.println(stuMap.get("넷째"));
		
		System.out.println(coinMap.get("비트코인"));
		System.out.println(stuMap2.get(0));
		
		// .size()
		// 맵 안에 데이터의 개수 리턴
		System.out.println(stuMap.size());
		
		// .containsKey()
		// 맵 안에 있는 키(Key) 중에 ()안의 값인 키가
		// 있으면 true, 없으면 false
		// 인덱스는 없으니 당연히 .indexOf는 없다
		System.out.println(stuMap.containsKey("셋째"));
		
		// .containsValue()
		// 맵 안에 있는 값(Value) 중에 ()안의 값인 Value가
		// 있으면 true, 없으면 false
		System.out.println(stuMap.containsValue("재현"));
		
		// .remove(Key)
		// 해당 Key르 갖는 데이터를 삭제
		coinMap.remove("비트코인");
		System.out.println(coinMap);
		
		System.out.println("\n======================================================\n");
		
		// Map 순회
		// 1. keySet 이용
		Set<String> stuKey = stuMap.keySet();
		
		// Set을 향상된 for문으로 순회
		for(String key : stuKey) {
			System.out.println(key + " : " + stuMap.get(key));
		}
		
		
		// 2. EntrySet 이용
		// set안에 entry객체가 들어간 
		Set<Entry<String, String>> entrySet = stuMap.entrySet();
		
		for(Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		Set<Entry<Integer, String>> entrySet2 = stuMap2.entrySet();
		
		for(Entry<Integer, String> entry : entrySet2) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// 3. forEach 이용
		// forEach안에서는 지역변수는 사용불가
		// 상수는 들어갈 수 있다..
		// 전역변수도 한계... 불편하다...!
		stuMap.forEach((key, value) -> {
			System.out.println(key);
			System.out.println(value);
		});
		
		System.out.println("\n================================================================\n");
		
		// 중국집
		// 약간의 팁,, 밖에 선언하기 쉬운 배열을 만들고
		// 리스트를 선언하면서 리스트화 시켜준다.
		String[] temp = {"복록수", "쓰촨", "다온짬뽕", "초월짬뽕", "명성반점"};
		ArrayList<String> china = new ArrayList<>(Arrays.asList(temp));
		
		// 학생목록
		String[] student = {"기윤", "성식", "형구", "예준", "희수", "수현", "재현", "준오", "호종"};
		ArrayList<String> stuList = new ArrayList<>(Arrays.asList(student));
		
		// Map을 만들고, key에는 중국집 식당들이 들어가고
		// value에는 빈 배열을 세팅
		
		HashMap<String, ArrayList<String>> result = new HashMap<>();
		
		for(int i = 0; i < china.size(); i++) {
			// 빈 배열 담기
			//  ArrayList<String> empty = new ArrayList<>(); 혹은 바로 담기
			result.put(china.get(i), new ArrayList<>());
		}
		System.out.println(result);
		
		// 1 ~ 3
		// Collections.shuffle()
		// 을 하면 배열내 요소가 랜덤하게 섞인다.
		Collections.shuffle(stuList);
		System.out.println(stuList);
		
		for(int i = 0; i < china.size(); i++) {
			result.get(china.get(i)).add(stuList.get(i));
		}
		System.out.println(result);
		
		for(int i = china.size(); i < stuList.size(); i++) {
			int randInt = (int)(Math.random() * china.size());
			
			if(result.get(china.get(randInt)).size() >= 3) {
				i--;
			}else {
				result.get(china.get(randInt)).add(stuList.get(i));
			}
		}
		System.out.println(result);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
