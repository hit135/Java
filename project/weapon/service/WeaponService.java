package weapon.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import weapon.dao.WeaponDao;
import weapon.jdbc.ConnectionPool;
import weapon.vo.WeaponVO;

public class WeaponService {
	private WeaponDao dao = WeaponDao.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	private WeaponService() {}
	private static WeaponService instance = new WeaponService();
	public static WeaponService getInstance() {
		return instance;
	}
	
	// 무기 목록 조회
	public ArrayList<WeaponVO> getWeaponList(){
		Connection conn = cp.getConnection();
		
		ArrayList<WeaponVO> result = new ArrayList<WeaponVO>();
		try {
			result = dao.getWeaponList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) cp.releaseConnection(conn);
		}
		
		return result;
	}
	
	// 등급에 맞는 무기 하나 추출
	public WeaponVO getWeaponByType(String type) {
		WeaponVO result = new WeaponVO();
		ArrayList<WeaponVO> weaponList = new ArrayList<WeaponVO>(getWeaponList());
		ArrayList<WeaponVO> weaponByType = new ArrayList<WeaponVO>();
		int randInt = 0;
		
		// 같은 타입 배열에 담기
		for(int i = 0; i < weaponList.size(); i++) {
			if(weaponList.get(i).getWeaponType().equals(type)) {
				weaponByType.add(weaponList.get(i));
			}
		}
		// 타입 배열에서 랜덤으로 하나 뱉기
		randInt = (int)(Math.ceil(Math.random() * weaponByType.size()) - 1);
		result = weaponByType.get(randInt);
		return result;
	}
	
	

}
