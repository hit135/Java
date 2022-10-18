package park_hyunggoo.classCafe;

import java.util.ArrayList;

public class Cafe {
	
	// 카페의 이름을 입력하면
	// 카페 이름을 가진 list가 생겨야함
	

	private String cafeName;
	private ArrayList<Menus> cafeList;
	
	
	// 생성자
	public Cafe() {}
	
	// 생성자
	public Cafe(String cafeName) {
		this(cafeName, new ArrayList<Menus>());
	}
	
	// 생성자
	public Cafe(String cafeName, ArrayList<Menus> cafeList) {
		this.cafeName = cafeName;
		this.cafeList = new ArrayList<Menus>();
	}
	
	// 카페에 메뉴 추가
	public void addMenus(Menus p_menus) {
		this.getCafeList().add(p_menus);
	}
	
	// 카페의 모든 리스트 출력
	public static void showMenus(Cafe p_name) {
		for(int i = 0; i < p_name.getCafeList().size(); i++) {
			System.out.println( (i+1) + ". " + p_name.getCafeList().get(i));
		}
	}
	
	// 카페 주문한 것 출력
	public static void orderMenus(Cafe p_name, int p_num) {
		System.out.println(p_name.getCafeList().get(p_num - 1) + "을 구입하셨습니다!");
	}

	// 카페 메뉴 잘 주문했는지 불리언값 확인
	public static boolean checkMenus(Cafe p_name, int p_num) {
		return (p_num -1 < p_name.getCafeList().size()); 
	}
	
	
	
	// 출력자
	@Override
	public String toString() {
		return "Cafe [cafeName=" + cafeName + ", cafeList=" + cafeList + "]";
	}

	
	// getter setter
	public String getCafeName() {
		return cafeName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public ArrayList<Menus> getCafeList() {
		return cafeList;
	}

	public void setCafeList(ArrayList<Menus> cafeList) {
		this.cafeList = cafeList;
	}
	
	

	


	

	
	
	
	
	
	
	
	
	
}
