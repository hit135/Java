package ch09_class.homepage;

import java.util.Scanner;


public class HomepageMain {

	public static void main(String[] args) {
		
		HomeMemberDB memDB = HomeMemberDB.getInstance();
		BoardDB boardDB = BoardDB.getInstance();
		
		// memDB = null;
		// 이곳에서 수정이 돼버린다!
		// 그러니 DB에서 instance에 접근도 막는다
		
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 회원목록 | 4. 종료");
			System.out.print(">>>> ");
			
			int command = Integer.parseInt(scan.nextLine());
			
			if(command == 1) {
				System.out.print("아이디를 입력해주세요: ");
				String id = scan.nextLine();
				
				if(memDB.checkDuple(id)) {
					System.out.println("중복된 아이디입니다.");
				}else {
					System.out.print("비밀번호를 입력해주세요: ");
					String pw = scan.nextLine();
					System.out.print("이름을 입력해주세요: ");
					String name = scan.nextLine();
					
					HomeMember mem = new HomeMember(id, pw, name);
					memDB.registMem(mem);
					System.out.println("회원가입에 성공하셨습니다!");
				}
				
			}else if(command == 2) {
				System.out.print("아이디를 입력해주세요: ");
				String id = scan.nextLine();
				System.out.print("비밀번호를 입력해주세요: ");
				String pw = scan.nextLine();
				
				if(memDB.checkLogin(id, pw)) {
					System.out.println("로그인 성공!");
					System.out.println(memDB.returnName(id) + "님 환영합니다!");
					
					// TODO 글쓰기, 글보기
					while(true) {
						boardDB.showBoard();
						
						System.out.println("행동을 선택해주세요");
						System.out.println("1. 글쓰기 | 2. 글조회 | 3. 로그아웃");
						System.out.print(">>> ");
						
						int select = Integer.parseInt(scan.nextLine());
						
						if(select == 1) {
							// 글쓰기
							System.out.println("글 제목 입력");
							System.out.print(">>> ");
							String title = scan.nextLine();
							System.out.println("글 내용 입력");
							System.out.print(">>> ");
							String content = scan.nextLine();
							
							Board temp = new Board(title, content, memDB.returnName(id));
							boardDB.write(temp);
							
							
						}else if(select == 2) {
							// 글조회
							System.out.println("글 번호를 입력해주세요");
							
							int no = Integer.parseInt(scan.nextLine());
							
							// 없는 글이면 알려주고 싶다
							if(!boardDB.readBoard(no)) {
								System.out.println("없는 글 번호입니다.");
							}
							
						}else if(select == 3) {
							//로그아웃
							System.out.println("로그아웃하셨습니다.");
							break;
						}else {
							System.out.println("다시 입력해주세요");
						}
					}
					
				}else {
					System.out.println("아이디 혹은 비밀번호가 틀립니다");
				}
				
				
				
			}else if(command == 3) {
				memDB.showMemberList();
			}else if(command == 4) {
				System.out.println("종료합니다");
				break;
			}else {
				System.out.println("다시 입력해주세요");
			}
		
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
