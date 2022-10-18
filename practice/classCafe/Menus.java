package park_hyunggoo.classCafe;

public class Menus {
	
	// 캡슐화
	private String menu;
	private int price;
	
	
	// 생성자
	public Menus() {}
	
	public Menus(String menu, int price) {
		this.menu = menu;
		this.price = price;
	}

	@Override
	public String toString() {
		return  menu + ": " + price;
	}
	
	

}
