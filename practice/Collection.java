package park_hyunggoo.submit10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Collection {

	public static void main(String[] args) {
		
		// 로또만들기 ArrayList와 HashSet을 이용해 만들기
		// 오히려 쉽다...!
		// ArrayList에 1~45사이의 랜덤 숫자 6개 넣고
		// HashSet으로 변환하면 중복x이기 때문에!
		
		

		ArrayList<Integer> lottoList = new ArrayList<>();
		
		// 6개를 담지만 중복되면 안담기기 때문에
		// while문을 돌려서 만족하면 break
		
		while(true) {
			int lottoNum = (int)((Math.random() * 45) +1);
			lottoList.add(lottoNum);
			
			HashSet<Integer> lottoSet = new HashSet<>(lottoList);
			
			if(lottoSet.size() == 6) {
				lottoList = new ArrayList<>(lottoSet);
				Collections.sort(lottoList);
				break;
			}
		}
		System.out.println(lottoList);
		
		System.out.println("\n=====================================================\n");
		
		
		/*
		 * infoMap의 Key는 사용자의 아이디, Value는 사용자의 비밀번호
		 * 사용자가 아이디와 비밀번호를 입력! (Scanner 쓰겠다)
		 * infoMap의 key와 Value를 비교한다.
		 * 결과는 3가지 key, Value 모두 같거나
		 * key만 틀리거나
		 * Value만 틀리거
		 */
		
		HashMap<String, String> infoMap = new HashMap<>();
		
		infoMap.put("a001", "1234a");
		infoMap.put("b001", "1234b");
		infoMap.put("c001", "1234c");
		infoMap.put("d001", "1234d");
		infoMap.put("e001", "1234e");
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("아이디를 입력해주세요");
		System.out.print(">>> ");
		String id = scan.nextLine();
		System.out.println("비밀번호를 입력해주세요");
		System.out.print(">>> ");
		String password = scan.nextLine();
		
		// 3가지 조건을 넣어주면 끝
		// 그전에 infoMap에 각각에 접근해야 한다!
		Set<String> infoKey = infoMap.keySet();	// key값
		
		
		for(String key : infoKey) {
			if(key.equals(id)) {
				String val = infoMap.get(key);
				if(val.equals(password)) {
					System.out.println("로그인 성공");
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
			}
		}
		if(!infoKey.contains(id)) {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		
//		if(infoKey.contains(id)) {
//			for(String key : infoKey) {
//				String val = infoMap.get(key);
//				if(val.contains(password)) {
//					System.out.println("로그인 성공");
//				}else {
//					System.out.println("비밀번호가 틀렸습니다.");
//				}
//			}
//			
//		}else {
//			System.out.println("존재하지 않는 아이디입니다.");
//		}
		
		
		
		
		
		
		
		
		
		
		
		

	}	// main 끝
	
	
	

}
