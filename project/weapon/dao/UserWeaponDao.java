package weapon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import weapon.vo.UserVO;
import weapon.vo.UserWeaponVO;


public class UserWeaponDao {
	
	private UserWeaponDao() {}
	private static UserWeaponDao instance = new UserWeaponDao();
	public static UserWeaponDao getInstance() {
		return instance;
	}
	
	// 회원들 무기 조회
	public ArrayList<UserWeaponVO> getWeaponList(Connection conn) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("SELECT							");
		query.append("		user_id			AS id		");
		query.append("	 ,	weapon_type		AS type		");
		query.append("	 ,	weapon_name		AS name		");
		query.append("	 ,	weapon_enforce	AS enforce	");
		query.append("	 ,	weapon_str		AS str		");
		query.append("	 ,	weapon_spd		AS spd		");
		query.append("	 ,	weapon_blk		AS blk		");
		query.append("	 ,	weapon_skill	AS skill	");
		query.append("FROM								");
		query.append("	  user_weapon					");
		query.append("ORDER BY user_id					");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<UserWeaponVO> result = new ArrayList<>();
		
		while(rs.next()) {
			UserWeaponVO userWeapon = new UserWeaponVO();
			userWeapon.setUserId(rs.getString("id"));
			userWeapon.setWeaponType(rs.getString("type"));
			userWeapon.setWeaponName(rs.getString("name"));
			userWeapon.setWeaponEnforce(rs.getInt("enforce"));
			userWeapon.setWeaponStr(rs.getInt("str"));
			userWeapon.setWeaponSpd(rs.getInt("spd"));
			userWeapon.setWeaponBlk(rs.getInt("blk"));
			userWeapon.setWeaponSkill(rs.getString("skill"));
			
			result.add(userWeapon);
		}
		if(ps != null) ps.close();
		if(rs != null) rs.close();
		
		return result;
	}
	
	// 회원에 따른 무기 조회 >> 개인 무기 정보 조회
	public UserWeaponVO getWeaponById(Connection conn, UserVO user) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("SELECT							");
		query.append("	 	user_id			AS id		");
		query.append("	 ,	weapon_type		AS type		");
		query.append("	 ,	weapon_name		AS name		");
		query.append("	 ,	weapon_enforce	AS enforce	");
		query.append("	 ,	weapon_str		AS str		");
		query.append("	 ,	weapon_spd		AS spd		");
		query.append("	 ,	weapon_blk		AS blk		");
		query.append("	 ,	weapon_skill	AS skill	");
		query.append("FROM								");
		query.append("	  user_weapon					");
		query.append("WHERE 1=1							");
		query.append("  AND user_id = ?					");
		
		String id = user.getUserId();
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, id);
		
		ResultSet rs = ps.executeQuery();
		
		UserWeaponVO result = null;
		
		while(rs.next()) {
			String userId = rs.getString("id");
			String weaponType = rs.getString("type");
			String weaponName = rs.getString("name");
			int weaponEnforce = rs.getInt("enforce");
			int weaponStr = rs.getInt("str");
			int weaponSpd = rs.getInt("spd");
			int weaponBlk = rs.getInt("blk");
			String weaponSkill = rs.getString("skill");
			
			result = new UserWeaponVO(userId, weaponType, weaponName, weaponEnforce,  weaponStr, weaponSpd, weaponBlk, weaponSkill);
		}
		if(ps != null) ps.close();
		if(rs != null) rs.close();
		
		return result;
	}
	
	// 처음 시작시 무기 뽑기 >> DB에 등록
	public int registUserWeapon(Connection conn, UserWeaponVO userWeapon) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO				");
		query.append("		user_weapon			");
		query.append("		(					");
		query.append("			user_id			");
		query.append("		  ,	weapon_type		");
		query.append("		  ,	weapon_name		");
		query.append("		  ,	weapon_enforce	");
		query.append("		  ,	weapon_str		");
		query.append("		  ,	weapon_spd		");
		query.append("		  ,	weapon_blk		");
		query.append("		  ,	weapon_skill	");
		query.append("		) VALUES (			");
		query.append("			?				");
		query.append("		  ,	?				");
		query.append("		  ,	?				");
		query.append("		  ,	?				");
		query.append("		  ,	?				");
		query.append("		  ,	?				");
		query.append("		  ,	?				");
		query.append("		  ,	?				");
		query.append("		)					");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, userWeapon.getUserId());
		ps.setString(idx++, userWeapon.getWeaponType());
		ps.setString(idx++, userWeapon.getWeaponName());
		ps.setInt(idx++, userWeapon.getWeaponEnforce());
		ps.setInt(idx++, userWeapon.getWeaponStr());
		ps.setInt(idx++, userWeapon.getWeaponSpd());
		ps.setInt(idx++, userWeapon.getWeaponBlk());
		ps.setString(idx++, userWeapon.getWeaponSkill());
		
		int result = ps.executeUpdate();
		if(ps != null) ps.close();
		
		return result;
	}
	
	// 업데이트
	public int updateUserWeapon(Connection conn, UserWeaponVO userWeapon) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("UPDATE					");
		query.append("		user_weapon			");
		query.append("SET						");
		query.append("	 	weapon_type = ?		");
		query.append("	 ,	weapon_name = ?		");
		query.append("	 ,	weapon_enforce = ?	");
		query.append("	 ,	weapon_str = ?		");
		query.append("	 ,	weapon_spd = ?		");
		query.append("	 ,	weapon_blk	 = ?	");
		query.append("	 ,	weapon_skill = ?	");
		query.append("WHERE 1=1					");
		query.append("	AND	user_id = ?			");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, userWeapon.getWeaponType());
		ps.setString(idx++, userWeapon.getWeaponName());
		ps.setInt(idx++, userWeapon.getWeaponEnforce());
		ps.setInt(idx++, userWeapon.getWeaponStr());
		ps.setInt(idx++, userWeapon.getWeaponSpd());
		ps.setInt(idx++, userWeapon.getWeaponBlk());
		ps.setString(idx++, userWeapon.getWeaponSkill());
		ps.setString(idx++, userWeapon.getUserId());
		
		int result = ps.executeUpdate();
		if(ps != null) ps.close();
		
		return result;
		
	}
	
	// 무기 판매시 테이블에서 정보 지우기
	public void deleteWeapon(Connection conn, UserWeaponVO userWeapon) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("DELETE					");
		query.append("  FROM					");
		query.append("  	 user_weapon		");
		query.append(" WHERE 1=1				");
		query.append(" 	 AND user_id = ?		");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		
		ps.setString(idx++, userWeapon.getUserId());
		ps.executeUpdate();
		if(ps != null) ps.close();
	}
	
	
	
	
	
}
