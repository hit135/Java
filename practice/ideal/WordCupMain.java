package review.ideal;

import java.util.Collections;
import java.util.Scanner;

public class WordCupMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Menu menuList = new Menu();

		menuList.addMenu("김치찌개");
		menuList.addMenu("짜장면");
		menuList.addMenu("햄버거");
		menuList.addMenu("피자");
		menuList.addMenu("된장찌개");
		menuList.addMenu("삼겹살");
		menuList.addMenu("소고기");
		menuList.addMenu("초밥");
		menuList.addMenu("국수");
		menuList.addMenu("냉면");
		menuList.addMenu("돈가스");
		menuList.addMenu("카레");
		menuList.addMenu("치킨");
		menuList.addMenu("빵");
		menuList.addMenu("케이크");
		menuList.addMenu("라면");
		
		
		System.out.println("음식 이상형 월드컵 16강!!");
		Collections.shuffle(menuList.getMenuList());
		Outer:while(true) {
			int minor = 1;
			int menuSize = (menuList.menuListSize());
			if(menuSize == 2) {
				System.out.println("결승!!!!");
			}else {
				System.out.println(menuList.menuListSize() + "강!!!!");
			}
			while(true) {
				int changeSize = menuList.menuListSize();
				System.out.println("메뉴를 선택해주세요");
				menuList.showMenu(changeSize - minor);
				System.out.print(">>> ");
				int select = Integer.parseInt(scan.nextLine());
				if(select == 1) {
					menuList.removeMenu(menuList.whatMenu(changeSize - minor));
					minor += 1;
				}else if(select == 2) {
					menuList.removeMenu(menuList.whatMenu(changeSize - minor - 1));
					minor += 1;
				}else {
					System.out.println("다시 입력해주세요");
				}
				if(changeSize == 2) {
					System.out.println(menuList.whatMenu(changeSize - 2) + "가 우승했습니다!!!");
					break Outer;
				}
				if(minor == (menuSize / 2) + 1) {
					break;
				}
			}
		}
		
		
		// 반복되는 것 줄이자
//		System.out.println("8강!!!!");
//		minor = 1;
//		while(true) {
//			System.out.println("메뉴를 선택해주세요");
//			menuList.showMenu(menuList.menuListSize() - minor);
//			System.out.print(">>> ");
//			int select = Integer.parseInt(scan.nextLine());
//			if(select == 1) {
//				menuList.removeMenu(menuList.whatMenu(menuList.menuListSize() - minor));
//				minor += 1;
//			}else if(select == 2) {
//				menuList.removeMenu(menuList.whatMenu(menuList.menuListSize() - minor -1));
//				minor += 1;
//			}else {
//				System.out.println("다시 입력해주세요");
//			}
//			if(minor == 5) {
//				break;
//			}
//		}
//		System.out.println("4강!!!!");
//		minor = 1;
//		while(true) {
//			System.out.println("메뉴를 선택해주세요");
//			menuList.showMenu(menuList.menuListSize() - minor);
//			System.out.print(">>> ");
//			int select = Integer.parseInt(scan.nextLine());
//			if(select == 1) {
//				menuList.removeMenu(menuList.whatMenu(menuList.menuListSize() - minor));
//				minor += 1;
//			}else if(select == 2) {
//				menuList.removeMenu(menuList.whatMenu(menuList.menuListSize() - minor -1));
//				minor += 1;
//			}else {
//				System.out.println("다시 입력해주세요");
//			}
//			if(minor == 3) {
//				break;
//			}
//		}
//		System.out.println("결승!!!!");
//		minor = 1;
//		while(true) {
//			System.out.println("메뉴를 선택해주세요");
//			menuList.showMenu(menuList.menuListSize() - minor);
//			System.out.print(">>> ");
//			int select = Integer.parseInt(scan.nextLine());
//			if(select == 1) {
//				menuList.removeMenu(menuList.whatMenu(menuList.menuListSize() - minor));
//				System.out.println(menuList.whatMenu(menuList.menuListSize() - 1) 
//									+ "가 우승했습니다!!");
//				break;
//			}else if(select == 2) {
//				menuList.removeMenu(menuList.whatMenu(menuList.menuListSize() - minor - 1));
//				System.out.println(menuList.whatMenu(menuList.menuListSize() - 1) 
//									+ "가 우승했습니다!!");
//				break;
//			}else {
//				System.out.println("다시 입력해주세요");
//			}
//			
//		}
//		

	}
	
	
	
	
	
	
	
	
	
	
	

}
