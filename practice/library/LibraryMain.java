package review.library;

import java.util.Scanner;

public class LibraryMain {

	public static void main(String[] args) {
		
		Library bookListMain = Library.getInstance();
		Scanner scan = new Scanner(System.in);
		
		
		// DB 배열에 형식대로 집어넣는것은 완료
		
		String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, 해리포터와 혼혈왕자, 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, 이것이 자바다, 좋은생각, 반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";
		
		String[] strBooksArray = strBooks.split(",");
		for(int i = 0; i < strBooksArray.length; i++) {
			strBooksArray[i] = strBooksArray[i].trim();
			System.out.println(strBooksArray[i]);
			bookListMain.addBook(new Book(strBooksArray[i]));
		}
		
		// 다 담음
		

		while(true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 책 입고 | 2. 책 대여 | 3. 책 목록 | 4. 책 검색 | 5. 종료");
			System.out.print(">>> ");
			int command = Integer.parseInt(scan.nextLine());
			
			if(command == 1) {
				System.out.print("책 번호를 입력해주세요: ");
				int inputBook = Integer.parseInt(scan.nextLine());
				bookListMain.inputBook(inputBook);
				String bookName = bookListMain.inputNum(inputBook);
				System.out.println(bookName + "이(가) 입고되었습니다!");
			}else if(command == 2) {
				System.out.print("책 이름을 입력해주세요: ");
				String keyword = scan.nextLine();
				
				if(bookListMain.containBook(keyword) > 1) {
					bookListMain.selectShow(keyword);
					System.out.print("빌리실 책번호를 입력해주세요: ");
					int rentBook = Integer.parseInt(scan.nextLine());
					bookListMain.rentBook(rentBook);
					String bookName = bookListMain.inputNum(rentBook);
					System.out.println(bookName + "을(를) 대여하셨습니다.");
				}else if(bookListMain.containBook(keyword) == 1) {
					bookListMain.selectShow(keyword);
				}else if(bookListMain.containBook(keyword) == 0){
					bookListMain.selectShow(keyword);
					System.out.println("책 이름을 다시 확인해주세요!");
				}
			}else if(command == 3) {
				bookListMain.showList();
			}else if(command == 4) {
				System.out.println("책 이름을 입력해주세요!");
				System.out.print(">>> ");
				String keyword = scan.nextLine();
				if(bookListMain.containBook(keyword) > 0) {
					bookListMain.searchShow(keyword);
				}else if(bookListMain.containBook(keyword) == 0) {
					System.out.println("해당 책이 없습니다! 책 이름을 다시 확인해주세요!");
				}
			}else if(command == 5) {
				System.out.println("종료합니다!");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
		}
		
		
		
		
	}

}
