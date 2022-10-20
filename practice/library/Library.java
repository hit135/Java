package review.library;

import java.util.ArrayList;

import ch09_class.homepage.BoardDB;

public class Library {
	
	// 싱글턴 패턴 적용 (중요!!)
	private Library() {}
	
	// 나만 생성할 수 있다
	// 다른데서 접근 가능하게 static에 저장
	// .instance로 접근하지 못하도록(수정 못하게) private 추가
	private static Library instance = new Library();
	
	// 다른곳에서 instance로 접근 가능한 public하나 열어주기
	public static Library getInstance() {
		return instance;
	}
	
	private static ArrayList<Book> bookList = new ArrayList<>();


	// 리스트에 책 추가
	public void addBook(Book p_book) {
		bookList.add(p_book);
	}
	// 리스트 사이즈
	public int bookListSize() {
		return bookList.size();
	}
	// 리스트 보여주기
	public void showList() {
		for(Book temp : bookList) {
			System.out.println(temp);
		}
	}
	// 포함된 문자 출력
	public void searchShow(String keyword) {
		for(Book temp : bookList) {
			String bookName = temp.getName();
			if(bookName.contains(keyword)) {
				System.out.println(temp);
			}
		}
	}
	
	
	
	// 포함된 문자의 출력하나 단일이면 빌리고 없으면 없다고 출력
	public void selectShow(String keyword) {
		ArrayList<Book> containKey = new ArrayList<>();
		for(Book temp : bookList) {
			String bookName = temp.getName();	// 리스트에 담김 책 이름들 리턴
			
			if(bookName.contains(keyword)){
				containKey.add(temp);
				System.out.println(temp);
			}
		}
		if(containKey.size() == 1) {
			Book currentBook = containKey.get(0);
			currentBook.setRental(true);
			System.out.println(currentBook.getName() + "을(를) 대여하셨습니다!");
			
		}else if(containKey.size() == 0) {
			System.out.println("입력하신 글자를 포함한 책이 없습니다!!");
		}
	}
	
	// 문자를 포함하는 책이 몇개냐?
	public int containBook(String keyword) {
		int count = 0;
		for(Book temp : bookList) {
			if(temp.getName().contains(keyword)) {
				count ++;
			}
		}
		return count;
	}
	// 책 입고 >> 불리언 디폴트로
	public void inputBook(int num) {
		for(Book temp : bookList) {
			int bookNum = temp.getNumber();
			if(bookNum == num) {
				if(temp.isRental()) {
					temp.setRental(false);
				}else {
					temp.setRental(false);
				}
			}
		}
	}
	//  책 대여 >> 불리언 트루로
	public void rentBook(int num) {
		for(Book temp : bookList) {
			int bookNum = temp.getNumber();
			if(bookNum == num) {
				if(!temp.isRental()) {
					temp.setRental(true);
				}
			}
		}
	}
	
	// 책 번호 입력시 책의 제목 리턴
	public String inputNum(int num) {
		String name = "";
		for(Book temp : bookList) {
			if(temp.getNumber() == num) {
				name = temp.getName();
			}
		}
		return name;
	}
	
	
	
	// toString
	@Override
	public String toString() {
		return bookList +"";
	}
	
	// getter setter
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	
	
	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	
	
	
	
	
	
	
	

}
