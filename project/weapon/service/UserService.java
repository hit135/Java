package weapon.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import weapon.dao.UserDao;
import weapon.jdbc.ConnectionPool;
import weapon.vo.UserVO;

public class UserService {
	private UserDao dao = UserDao.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	private UserService() {}
	private static UserService instance = new UserService();
	public static UserService getInstance() {
		return instance;
	}
	
	// 유저 목록 조회
	public ArrayList<UserVO> getUserList(){
		Connection conn = cp.getConnection();
		
		ArrayList<UserVO> result = new ArrayList<UserVO>();
		try {
			result = dao.getUserList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) cp.releaseConnection(conn);
		}
		
		return result;
		
	}
	
	// 로그인
	public UserVO loginUser(String id) {
		Connection conn = cp.getConnection();
		
		UserVO result = null;
		try {
			result = dao.loginUser(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 회원가입
	public int registUser(UserVO user) {
		Connection conn = cp.getConnection();
		int result = 0;
		
		try {
			result = dao.registUser(conn, user);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("중복된 아이디 입니다!!");
		} finally {
			if(conn != null) cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 업데이트
	public int updateUser(UserVO user) {
		Connection conn = cp.getConnection();
		int result = 0;
		
		try {
			result = dao.updateUser(conn, user);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("업데이트에 실패했습니다..");
		} finally {
			if (conn != null) cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 무기 뽑기 >> 문자만 추출
	public String gachaWeapon(UserVO user, int weapon) {
		String result = user.getUserWeapon();
		int randInt = (int)(Math.ceil(Math.random() * 1000));
		
		if(result.equals("없음")) {
			switch(weapon) {
			case 1 :
				if(randInt >= 1 && randInt < 6) {
					result = "검(신화)";
				}else if(randInt >= 6 && randInt < 50) {
					result = "검(전설)";
				}else if(randInt >= 50 && randInt < 200) {
					result = "검(레어)";
				}else {
					result = "검(일반)";
				}
				break;
			case 2 :
				if(randInt >= 1 && randInt < 6) {
					result = "활(신화)";
				}else if(randInt >= 6 && randInt < 50) {
					result = "활(전설)";
				}else if(randInt >= 50 && randInt < 200) {
					result = "활(레어)";
				}else {
					result = "활(일반)";
				}
				break;
			case 3 :
				if(randInt >= 1 && randInt < 6) {
					result = "방패(신화)";
				}else if(randInt >= 6 && randInt < 50) {
					result = "방패(전설)";
				}else if(randInt >= 50 && randInt < 200) {
					result = "방패(레어)";
				}else {
					result = "방패(일반)";
				}
				break;
			}
			
		}else {
			return result;
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
}
