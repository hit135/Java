package park_hyunggoo.submit09;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionList {

	public static void main(String[] args) {

		// Q. 01 10~20의 랜덤한 숫자 10개를 담고 리스트
		// 리스트를 뽑은 후 중복된 숫자 제거
		// 오름차순
		// 내림차순

		ArrayList<Integer> randomList = new ArrayList<>();

		// 1. 10~20의 랜덤한 숫자
		for (int i = 0; i < 10; i++) {
			int randomNum = (int) (Math.random() * 11) + 10;
			randomList.add(randomNum);
		}
		// 2. 랜덤 숫자를 담은 정수형 리스트
		System.out.println("랜덤수를 담은 배열 = " + randomList);

		// 3. 정수형 리스트에서 중복된 숫자 삭제
		ArrayList<Integer> randomListRst = new ArrayList<>();
		for (int i = 0; i < randomList.size(); i++) {
			randomListRst.add(randomList.get(i));
		}
		for (int i = 0; i < randomListRst.size(); i++) {
			for (int j = 0; j < randomListRst.size(); j++) {
				if (i != j) {
					if (randomListRst.get(i) == randomListRst.get(j)) {
						randomListRst.set(j, 0);
					}
				}
			}
		}
		randomListRst.removeAll(Arrays.asList(0)); // 구글링
		System.out.println("중복X 랜덤한 수 배열 = " + randomListRst);

		// 4. 정수형 리스트를 오름차순 정리
		for (int i = 0; i < randomListRst.size() - 1; i++) {
			for (int j = 0; j < randomListRst.size() - 1 - i; j++) {
				if (randomListRst.get(j) > randomListRst.get(j + 1)) {
					swap(randomListRst, j, j + 1);
				}
			}
		}
		System.out.println("오름차순한 램덤수 배열 = " + randomListRst);

		// 5. 정수형 리스트를 내림차순 정리
		for (int i = 0; i < randomListRst.size() - 1; i++) {
			for (int j = 0; j < randomListRst.size() - 1 - i; j++) {
				if (randomListRst.get(j) < randomListRst.get(j + 1)) {
					swap(randomListRst, j, j + 1);
				}
			}
		}
		System.out.println("내림차순한 램덤수 배열 = " + randomListRst);
		
		
		System.out.println("\n=========================Q2=========================\n");

		// Q. 02
		// 냉장고, 세탁기, 에어컨을 리스트에 담고
		// 노트북, TV, 에어컨을 다른 리스트에 담는다.

		ArrayList<String> wife = new ArrayList<>(Arrays.asList("냉장고", "세탁기", "에어컨"));
		ArrayList<String> husband = new ArrayList<>(Arrays.asList("노트북", "TV", "에어컨"));

		ArrayList<String> intersection = new ArrayList<>();
		ArrayList<String> union = new ArrayList<>();

		// 1. 교집합을 새로운 배열에 담아 콘솔에 출력
		for (int i = 0; i < wife.size(); i++) {
			for (int j = 0; j < husband.size(); j++) {
				if (wife.get(i) == husband.get(j)) {
					intersection.add(wife.get(i));
				}
			}
		}
		System.out.println("교집합 = " + intersection);

		// 2. 합집합을 새로운 배열에 담아 콘솔에 출력
		// 먼저 와이프 리스트를 담고
		// 그다음 허스밴드 리스트를 담는데
		// 이미 담긴거에 중복이 있으면 빼준다.

		for (int i = 0; i < wife.size(); i++) {
			union.add(wife.get(i));
		}
		boolean sum = false;
		for (int i = 0; i < husband.size(); i++) {
			for (int j = 0; j < union.size(); j++) {
				if (husband.get(i) == union.get(j)) {
					sum = true;
					break;
				} else {
					sum = false;
				}
			}
			if (sum == false) {
				union.add(husband.get(i));
			} else if (sum == true) {
			}
		}
		System.out.println("합집합 = " + union);

		// Q2의 2번을 써서 Q1의 3번을 풀어보면

		sum = false;
		
		randomListRst = new ArrayList<>();
		
		for (int i = 0; i < randomList.size(); i++) {
			for (int j = 0; j < randomListRst.size(); j++) {
				if (randomListRst.get(j) == randomList.get(i)) {
					sum = true;
					break;
				} else {
					sum = false;
				}
			}
			
			if (sum == true) {
			} else if (sum == false) {
				randomListRst.add(randomList.get(i));
			}
		}
		System.out.println("Q2-2을 이용한 Q1-3 풀이 : " + randomListRst);
		
		
		
		
	} // main 끝

	static void swap(ArrayList<Integer> p_list, int indexA, int indexB) {
		p_list.set(indexA, p_list.get(indexA) + p_list.get(indexB));
		p_list.set(indexB, p_list.get(indexA) - p_list.get(indexB));
		p_list.set(indexA, p_list.get(indexA) - p_list.get(indexB));

		
		
	}

}
