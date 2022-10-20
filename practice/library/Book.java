package review.library;

public class Book {
	// 캡슐화
	private int number;
	private String name;
	private boolean rental;
	
	// 생성자
	public Book() {}
	
	public Book(String name) {
		Library bookList = Library.getInstance();
		this.number = bookList.bookListSize() + 1;
		this.name = name;
		this.rental = false;
	}
	
	
	public Book(int number, String name, boolean rental) {
		super();
		this.number = number;
		this.name = name;
		this.rental = rental;
	}
	
	// toString
	@Override
	public String toString() {
		if(rental) {
			return "[책번호: " + number + ", 책 제목: " + name + ", 대여상태: 대여중]"; 
		}else {
			return "[책번호: " + number + ", 책 제목: " + name + ", 대여상태: 입고중]";
		}
	}

	
	// Getter Setter
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isRental() {
		return rental;
	}
	
	public void setRental(boolean rental) {
		this.rental = rental;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
