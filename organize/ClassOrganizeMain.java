package review;

import java.util.ArrayList;
import java.util.Collections;

public class ClassOrganizeMain {
	
	// 실행(main 메소드만 보유)만 하는 클래스는
	// 현업에서 전체의 프로젝트 중 하나만 존재한다.

	public static void main(String[] args) {
		
		// 클래스를 통해 객체 생성
		ClassOrganize hg = new ClassOrganize();
		System.out.println(hg);
		// 바로 syso를 찍으면 16진수의 위치값이 나온다.
		// Generate toString 선언을 해줘야함
		System.out.println(hg);
		
		// 지금은 ClassOrganize에 default값을 설정해줘서 다르게 뜨지만
		// 기본 default값은
		// 숫자 : 0, boolean : false, 참조타입 : null
		
		// 객체의 상태(state), 즉 필드 변수에 값 넣기
		hg.name = "박형구";
		hg.height = 170;
		
		System.out.println(hg.height);
		
		// 논리연산자도 가능하다
		hg.height += 1;
		System.out.println(hg.height);
		
		hg.heightUp();
		// heightUp()은 static에 등록한게 아니므로
		// 스택과 힙에서 소환해줘야 한다.
//		hg.printInfo();
		ClassOrganize.printInfo();
		// printInfo는 static에 선언했으므로
		// class의 static에 접근해서 소환한다.
		// 솔직히 이 개념이 잘 이해가 안간다.
		
		
		System.out.println();
		ClassOrganize ig = new ClassOrganize("강인구");
		ClassOrganize mj = new ClassOrganize("이민준");
		ClassOrganize ch = new ClassOrganize("이창헌");
		ClassOrganize cw = new ClassOrganize("김철우");
		
		// 각각의 객체에 행동을 취하려면
		// ArrayList를 하나 선언해서
		// 포문을 돌려 접근한다.
		
		ArrayList<ClassOrganize> friendHeight = new ArrayList<>();
		
		friendHeight.add(hg);
		friendHeight.add(ig);
		friendHeight.add(mj);
		friendHeight.add(cw);
		friendHeight.add(ch);
		
		for(ClassOrganize fri : friendHeight) {
			fri.heightUp();
		}
		
		for(int i = 0; i < friendHeight.size(); i++) {
			System.out.print(friendHeight.get(i).name + ": ");
			System.out.println(friendHeight.get(i).height);
		}
		
		// 이것들을 이제 키로 정렬
		// 1. 버블 정렬을 이용
		
		for(int i = 0; i < friendHeight.size() -1; i++) {
			for(int k = 0; k < friendHeight.size() - i -1; k++) {
				if(friendHeight.get(k).height > friendHeight.get(k+1).height) {
					ClassOrganize.swap(friendHeight, k, k+1);
				}
			}
		}
		System.out.println(friendHeight);
		
		// 2. Collections.sort를 이용
		// Collections.sort(클래스를 담은 List명, (변수명A, 변수명B) -> 변수명A.값변수명 - 변수명B.값변수명)
		
		// 오름차순 friA.height - friB.height
		Collections.sort(friendHeight, (friA, friB) -> friA.height - friB.height);
		System.out.println(friendHeight);
		
		// 내림차순 friB.height - friA.height
		Collections.sort(friendHeight, (friA, friB) -> friB.height - friA.height);
		
		for(ClassOrganize tempList : friendHeight) {
			System.out.println(tempList.name + ": " + tempList.height);
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
