package park_hyunggoo.classCafe;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.webkit.ContextMenu.ShowContext;

public class CafeMain {

	public static void main(String[] args) {
		
		// 1. 행동 선택
		// >>> 1. 스타벅스 방문 | 2. 꽁떼 방문 | 3. 사무실 복귀
		// 2. 카페별 메뉴판 출력
		// >>> 1 방문시
		// 1. 아메리카노: 5000  2. 카푸치노: 6000  3. 오곡라떼: 7000
		

		
		Scanner scan = new Scanner(System.in);
		
		// 카페 배열을 만든다
		
		Cafe starbuck = new Cafe("스타벅스");
		starbuck.addMenus(new Menus("아메리카노", 5000));
		starbuck.addMenus(new Menus("라떼", 5500));
		starbuck.addMenus(new Menus("자바칩프라프치노", 6500));
		System.out.println(starbuck.getCafeList().get(0));
		
		Cafe ggongttae = new Cafe("꽁떼");
		ggongttae.addMenus(new Menus("아메리카노", 3000));
		ggongttae.addMenus(new Menus("아이스라떼", 3500));
		ggongttae.addMenus(new Menus("아이스초코", 4000));
		System.out.println(ggongttae);
		
		
		// 스타벅스를 선택하면
		// 스타벅스의 메뉴가 출력
		
		// 꽁떼를 선택하면
		// 꽁떼의 메뉴가 출력
		
		
		
		
		
		
		while(true) {
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 스타벅스 방문 | 2. 꽁떼 방문 | 3. 사무실 복귀...");
			System.out.print(">>> ");
			int whatPlay = Integer.parseInt(scan.nextLine());
			
			if(whatPlay == 1) {
				// 스타벅스라는 카페가 있고
				// 그 카페의 메뉴판
				// 카페와 메뉴판이 연계돼야 한다.
				while(true) {
					Cafe.showMenus(starbuck);
					System.out.println("주문하실 음료를 선택해주세요");
					int order = Integer.parseInt(scan.nextLine());
					if(Cafe.checkMenus(starbuck, order)){
						Cafe.orderMenus(starbuck, order);
						break;
					}else {
						System.out.println("없는 메뉴입니다!!!!!");
					}
				}
			}else if(whatPlay == 2) {
				// 꽁떼라는 카페가 있고
				// 그 카페의 메뉴판
				while(true) {
					Cafe.showMenus(ggongttae);
					System.out.println("주문하실 음료를 선택해주세요");
					int order = Integer.parseInt(scan.nextLine());
					if(Cafe.checkMenus(ggongttae, order)){
						Cafe.orderMenus(ggongttae, order);
						break;
					}else {
						System.out.println("없는 메뉴입니다!!!!!");
					}
				}
			}else if(whatPlay == 3) {
				System.out.println("사무실로 복귀합니다...");
				break;
			}else {
				System.out.println("다시 입력해주세요!");
			}
		}
		
		
		
	}

}
