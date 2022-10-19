package review.ideal;

import java.util.ArrayList;


public class Menu {
	
	// 캡슐화
	private static ArrayList<String> menuList;
	
	// 생성자
	public Menu() {
		menuList = new ArrayList<String>();
	}
	
	public Menu(ArrayList<String> menuList) {
		this.menuList = menuList;
	}

	// to String
	@Override
	public String toString() {
		return "메뉴리스트: " + menuList;
	}
	
	// getter setter
	public ArrayList<String> getMenuList() {
		return menuList;
	}
	
	public void setMenuList(ArrayList<String> menuList) {
		this.menuList = menuList;
	}
	
	// menu를 menuList에 추가
	public void addMenu(String menu) {
		menuList.add(menu);
	}
	// menu를 menuList에서 삭제
	public void removeMenu(String menu) {
		menuList.remove(menu);
	}
	// menuList에서 끝에서 두개를 출력
	public void showMenu(int i) {
		System.out.println("1." + menuList.get(i - 1) + " | "  + "2. " + menuList.get(i));
	}
	// menulist의 size
	public int menuListSize() {
		return menuList.size();
	}
	// menulist에서 index값에 따른 메뉴 출력
	public String whatMenu(int i) {
		return menuList.get(i);
	}
	
	
	
	
	
	
	
	
	

}
