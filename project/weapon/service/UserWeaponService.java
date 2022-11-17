package weapon.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import weapon.dao.UserWeaponDao;
import weapon.jdbc.ConnectionPool;
import weapon.vo.UserVO;
import weapon.vo.UserWeaponVO;

public class UserWeaponService {
	private UserWeaponDao dao = UserWeaponDao.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	private UserWeaponService() {}
	private static UserWeaponService instance = new UserWeaponService();
	public static UserWeaponService getInstance() {
		return instance;
	}

	// 유저들 무기 조회
	public ArrayList<UserWeaponVO> getUserWeaponList(){
		Connection conn = cp.getConnection();
		
		ArrayList<UserWeaponVO> result = new ArrayList<UserWeaponVO>();
		try {
			result = dao.getWeaponList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 개인 유저 무기 정보 조회
	public UserWeaponVO getWeaponById(UserVO user) {
		Connection conn = cp.getConnection();
		
		UserWeaponVO result = null;
		try {
			result = dao.getWeaponById(conn, user);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 첫 시작시 무기 DB에 등록
	public int registUserWeapon(UserWeaponVO userWeapon) {
		Connection conn = cp.getConnection();
		int result = 0;
		
		try {
			result = dao.registUserWeapon(conn, userWeapon);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 업데이트
	public int updateUserWeapon(UserWeaponVO userWeapon) {
		Connection conn = cp.getConnection();
		int result = 0;
		
		try {
			result = dao.updateUserWeapon(conn, userWeapon);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) cp.releaseConnection(conn);
		}
		return result;
		
	}
	
	// 정보 삭젝
	public void deleteWeapon(UserWeaponVO userWeapon) {
		Connection conn = cp.getConnection();
		try {
			dao.deleteWeapon(conn, userWeapon);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) cp.releaseConnection(conn);
		}
	}
	
	// 등급 강화
	// 1은 str, 2는 spd, 3은 blk
	public UserWeaponVO enforceWeapon(UserWeaponVO userWeapon, int state, UserVO user) {
		UserWeaponVO result = userWeapon;
		
		if(user.getUserMoney() >= ((userWeapon.getWeaponEnforce() + 1) * 100) ) {
			user.setUserMoney(user.getUserMoney() - ((userWeapon.getWeaponEnforce() + 1) * 100));
			
			if(state == 1) {
				result = randEnforceWeapon(userWeapon, state);
			}else if(state == 2) {
				result = randEnforceWeapon(userWeapon, state);
			}else if(state == 3) {
				result = randEnforceWeapon(userWeapon, state);
			}
		}else {
			System.out.println("돈이 부족합니다!!!!!!!");
			return result;
		}
		return result;
	}
	// 등급 강화 함수에 쓰이는
	// 공, 속, 방 확률에 따른 강화
	public UserWeaponVO randEnforceWeapon(UserWeaponVO userWeapon, int state) {
		UserWeaponVO result = userWeapon;
		int randInt = 0;
		
		
		if(state == 1) {
			randInt = (int)(Math.ceil(Math.random() * 100));
			if(randInt <= 100 - userWeapon.getWeaponEnforce()) {
				userWeapon.setWeaponStr(userWeapon.getWeaponStr() + 1);
				userWeapon.setWeaponEnforce(userWeapon.getWeaponEnforce() + 1);
				System.out.println("축하합니다!!");
				System.out.println("공격력 강화에 성공하셨습니다!!");
			}else {
				System.out.println("이런..");
				System.out.println("공격력 강화에 실패하셨습니다..");
			}
		}else if(state == 2) {
			randInt = (int)(Math.ceil(Math.random() * 100));
			if(randInt <= 100 - userWeapon.getWeaponEnforce()) {
				userWeapon.setWeaponSpd(userWeapon.getWeaponSpd() + 1);
				userWeapon.setWeaponEnforce(userWeapon.getWeaponEnforce() + 1);
				System.out.println("축하합니다!!");
				System.out.println("스피드 강화에 성공하셨습니다!!");
			}else {
				System.out.println("이런..");
				System.out.println("스피드 강화에 실패하셨습니다..");
			}
		}else if(state == 3) {
			randInt = (int)(Math.ceil(Math.random() * 100));
			if(randInt <= 100 - userWeapon.getWeaponEnforce()) {
				userWeapon.setWeaponBlk(userWeapon.getWeaponBlk() + 1);
				userWeapon.setWeaponEnforce(userWeapon.getWeaponEnforce() + 1);
				System.out.println("축하합니다!!");
				System.out.println("방어력 강화에 성공하셨습니다!!");
			}else {
				System.out.println("이런..");
				System.out.println("방어력 강화에 실패하셨습니다..");
			}
		}
		return result;
	}
	
	// 무기 가치 추정 함수
	public int howMuchWeapon(UserWeaponVO userWeapon) {
		int result;
		return result = (userWeapon.getWeaponEnforce() * 100);
	}
	// 무기 판매 함수
	public void sellWeapon(UserWeaponVO userWeapon, UserVO user) {
		int howMuch = howMuchWeapon(userWeapon);
		user.setUserMoney(user.getUserMoney() + howMuch);
		user.setUserWeapon("없음");
	}
	
	
	
	
}
