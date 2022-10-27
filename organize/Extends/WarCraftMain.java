package ch10_extends.Extends;

import java.util.ArrayList;

public class WarCraftMain {

	public static void main(String[] args) {
		
		// 최상위 부모 (가장 기본)
		WarCraftUnit base = new WarCraftUnit("기본", 0, 0, 0, 0, 0, 0, 0);
		System.out.println(base);
		// 상위 부모
		NightElf night = new NightElf(0, "나엘", 100, 100, 0, 0, 0, 0, 0);
		System.out.println(night);
		// 상위 부모
		Orc orc1 = new Orc(0, "오크", 200, 0, 0, 0, 5.0, 0, 0);
		System.out.println(orc1);
		// 상위 부모
		Undead undead = new Undead(0, "언데드", 125, 75, 0, 0, 0, 0, 0);
		System.out.println(undead);
		orc1.berserk();
		
		// 최하위 자식 (가장 확장)
		Troll troll1 = new Troll(2, "트롤", 350, 0, 20, 3, 2.0, 1.2, 3.0);
		Troll troll2 = new Troll(2, "트롤", 350, 0, 20, 3, 2.0, 1.2, 3.0);
		Troll troll3 = new Troll(2, "트롤", 350, 0, 20, 3, 2.0, 1.2, 3.0);
		System.out.println(troll1);
		troll1.regen();
		
		System.out.println("\n==============================================\n");
		
		// 다형성
		
		// 1. 부모 >> 자식
		// 안됨!
//		Orc baseOrc = (Orc) base;
//		System.out.println(baseOrc);
		// 오류가 안나는 것처럼 보이지만 런타임 오류남!
		
		
		// 2. 자식 >> 부모
		// 자동 형변환
		Orc orcTroll = troll2;
		System.out.println(orcTroll);
		// toString을 재정의 했기 때문에 재생력이 표기된다.
//		orcTroll.regen();
		// 하지만 트롤 클래스 안의 함수는 사용하지 못함!
		
		// 3. 형변환된 부모 >> 자식
		// 강제 형변환
		Troll troll4 = (Troll)orcTroll;
		troll4.regen();
		
		System.out.println("\n");
		// 4. 타입이 다른 자식들 배열에 담기
		ArrayList<WarCraftUnit> unitList = new ArrayList<>();
		unitList.add(troll1);
		unitList.add(orc1);
		unitList.add(night);
		unitList.add(undead);
		
		for(WarCraftUnit temp : unitList) {
			System.out.println(temp);
		}
		// 인덱스 0은 트롤
//		unitList.get(0).regen() >>> 안된다!
		// 배열에 담기면서 자동 형변환 됐기 때문..!
		// 강제 형변환 해줘야 한다..
		((Troll)unitList.get(0)).regen();
		
		// 여담으로 트롤은 부모인 오크도 되고 그 부모인 워크유닛도 가능
		
		System.out.println("\n\n");
		
		// 객체 instanceof 클래스Name
		// 가능하면 true/ 불가능하면 false
		System.out.println(troll2 instanceof Orc);
		System.out.println(troll2 instanceof WarCraftUnit);
		System.out.println(orc1 instanceof Troll);
		
		
		
		
		
		
	}

}
