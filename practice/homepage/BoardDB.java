package ch09_class.homepage;

import java.util.ArrayList;

public class BoardDB {
	
	// 싱글톤 패턴 적용
	private BoardDB() {}
	
	// 나만 생성할 수 있다
	// 다른데서 접근 가능하게 static에 저장
	// .instance로 접근하지 못하도록(수정 못하게) private 추가
	private static BoardDB instance = new BoardDB();
	
	// 다른곳에서 instance로 접근 가능한 public하나 열어주기
	public static BoardDB getInstance() {
		return instance;
	}
	
	private ArrayList<Board> boardList = new ArrayList<>();
	
	// 글작성
	public void write(Board p_board) {
		boardList.add(p_board);
	}
	
	// 글 목록 보기
	public void showBoard() {
		for(int i = 0; i < boardList.size(); i++) {
			System.out.println(boardList.get(i));
		}
	}
	
	// 글 조회
	public boolean readBoard(int p_no) {
		for(Board bo : boardList) {
			if(bo.getNo() == p_no) {
				System.out.println("제목: " + bo.getTitle());
				System.out.println("작성자: " + bo.getAuthor());
				System.out.println("내용: " + bo.getContent());
				return true;
			}
		}
		return false;
	}
	
	// boardList 사이즈 리턴
	public int listSize() {
		return boardList.size();
	}
	
	
	
	
	
	
	

}
