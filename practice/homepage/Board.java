package ch09_class.homepage;

public class Board {
	
	// 특정지을수 있는 no를 선언해준다.
	private int no;				// 글 번호
	private String title;		// 글 제목
	private String content;		// 글 내용
	private String author;		// 글 작성자
	
	// 생성자
	public Board() {}
	
	public Board(String title, String content, String author) {
		BoardDB boDB = BoardDB.getInstance();
		this.no =  boDB.listSize() +1;
		this.title = title;
		this.content = content;
		this.author = author;

	}
	
	public Board(int no, String title, String content, String author) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	// toString
	@Override
	public String toString() {
		return "[" + no + " | " + title + " | " + author + "]";
	}
	
	// Getter Setter
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
