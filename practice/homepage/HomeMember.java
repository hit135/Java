package ch09_class.homepage;

public class HomeMember {

	// 1. 필드변수 만들기 (private)
	
	// 캡슐화
	private String id;
	private String password;
	private String name;
	
	// 2. 생성자(Constructor 만들기)
	public HomeMember() {}
	
	public HomeMember(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	// 3. toString 만들기
	@Override
	public String toString() {
		return "[아이디: " + id + ", 닉네임: " + name + "]";
	}
	
	
	// 4. Getter Setter 만들기
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
	
	
}