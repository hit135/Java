package ch09_class.homepage;

import java.util.ArrayList;

public class HomeMemberDB {
	
	// 싱글톤 패턴 적용
	// 객체를 이 프로젝트 내에서 딱 하나만 만들어서 사용
	// new해서 다른 곳에서 생성하지 못하도록
	// 1. 기본 생성자를 private로 막는다.
	private HomeMemberDB() {
		memList.add(new HomeMember("a001", "1234a", "김예준"));
		memList.add(new HomeMember("b001", "1234b", "박형구"));
		memList.add(new HomeMember("c001", "1234c", "김성식"));
	}
	
	// 참조타입 객체 = instance라고 부름
	// static으로 열어줘야
	// 다른곳에서 쓸 수 있다.
	// 2. 자신의 필드에 자기 자신을 객체로 만들어 준다.
	private static HomeMemberDB instance = new HomeMemberDB();
	
	// 3. 객체로 만든 instance를 제공하는 함수 (Getter) 만들기
	public static HomeMemberDB getInstance() {
		return instance;
	}
	
	private ArrayList<HomeMember> memList = new ArrayList<>();
	
	
	
	
	/** 
	 * 로그인 체크
	 * @param p_id 사용자가 입력한 아이디
	 * @param p_pw 사용자가 입력한 비밀번호
	 * @return 아이디와 비밀번호가 모두 같으면 true, 하나라도 틀리면 false
	 */
	public boolean checkLogin(String p_id, String p_pw) {
		// 향상된 포문 쓰면 더 편한듯
		// 객체 넣을때 향상된 포문 편한듯!
		for(int i = 0; i < this.memList.size(); i++) {
			if(this.memList.get(i).getId().equals(p_id) && this.memList.get(i).getPassword().equals(p_pw)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * MeberDB의 리스트에서 id를 입력시
	 * @param p_id ArrayList의 id
	 * @return ArrayList name
	 */
	public String returnName(String p_id) {
		String name = "";
		for(HomeMember mem : memList) {
			if(mem.getId().equals(p_id)) {
				name = mem.getName();
			}
		}
		return name;
	}
	
	
	/**
	 * 선생님의 id에 따라 DB 배열 따오기
	 * @param p_id
	 * @return
	 */
	public HomeMember loginMen(String p_id) {
		for(HomeMember mem : memList) {
			if(mem.getId().equals(p_id)) {
				return mem;
			}
		}
		return null;
	}
	
	
	
	
	/**
	 * 아이디 등록
	 * @param p_mem 사용자가 입력한 정보
	 */
	public void registMem(HomeMember p_mem) {
		memList.add(p_mem);
	}
	
	/** 
	 * 중복된 아이디 체크
	 * @param id 사용자가 입력한 id
	 * @return 중복되면 true, 아니라면 false 리턴
	 */
	public boolean checkDuple(String id) {
		for(int i = 0; i < this.memList.size(); i++) {
			if(this.memList.get(i).getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public void showMemberList() {
		for(int i = 0; i < this.memList.size(); i++) {
			System.out.println(this.memList.get(i));
		}
	}
	
	
	
	
	

}
