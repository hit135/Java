package weapon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import weapon.vo.UserVO;

public class UserDao {
	
	private UserDao() {}
	
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	// 회원 목록 조회(SELECT)
	public ArrayList<UserVO> getUserList(Connection conn) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("SELECT							");
		query.append("		user_id			AS id		");
		query.append("	 ,	user_name		AS name		");
		query.append("	 ,	user_password	AS pw		");
		query.append("	 ,	user_score		AS score	");
		query.append("	 ,	user_lv			AS lv		");
		query.append("	 ,	user_exp		AS exp		");
		query.append("	 ,	user_hp			AS hp		");
		query.append("	 ,	user_str		AS str		");
		query.append("	 ,	user_spd		AS spd		");
		query.append("	 ,	user_blk		AS blk		");
		query.append("	 ,	user_money		AS money	");
		query.append("	 ,	user_weapon		AS weapon	");
		query.append("FROM								");
		query.append("	  users							");
		query.append("ORDER BY user_score DESC			");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<UserVO> result = new ArrayList<>();
		
		while(rs.next()) {
			UserVO user = new UserVO();
			user.setUserId(rs.getString("id"));
			user.setUserName(rs.getString("name"));
			user.setUserPassword(rs.getString("pw"));
			user.setUserScore(rs.getInt("score"));
			user.setUserLv(rs.getInt("lv"));
			user.setUserExp(rs.getInt("exp"));
			user.setUserHp(rs.getInt("hp"));
			user.setUserStr(rs.getInt("str"));
			user.setUserSpd(rs.getInt("spd"));
			user.setUserBlk(rs.getInt("blk"));
			user.setUserMoney(rs.getInt("money"));
			user.setUserWeapon(rs.getString("weapon"));
			
			result.add(user);
		}
		
		if(ps != null) ps.close();
		if(rs != null) rs.close();
		
		return result;
	}
	
	// 로그인
	public UserVO loginUser(Connection conn, String id) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("SELECT							");
		query.append("		user_id			AS id		");
		query.append("	 ,	user_name		AS name		");
		query.append("	 ,	user_password	AS pw		");
		query.append("	 ,	user_score		AS score	");
		query.append("	 ,	user_lv			AS lv		");
		query.append("	 ,	user_exp		AS exp		");
		query.append("	 ,	user_hp			AS hp		");
		query.append("	 ,	user_str		AS str		");
		query.append("	 ,	user_spd		AS spd		");
		query.append("	 ,	user_blk		AS blk		");
		query.append("	 ,	user_money		AS money	");
		query.append("	 ,	user_weapon		AS weapon	");
		query.append("FROM								");
		query.append("	  users							");
		query.append("WHERE 1=1							");
		query.append("  AND user_id = ?					");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, id);
		
		ResultSet rs = ps.executeQuery();
		
		UserVO result = null;
		
		while(rs.next()) {
			String userId = rs.getString("id");
			String userName = rs.getString("name");
			String userPw = rs.getString("pw");
			int userScore = rs.getInt("score");
			int userLv = rs.getInt("lv");
			int userExp = rs.getInt("exp");
			int userHp = rs.getInt("hp");
			int userStr = rs.getInt("str");
			int userSpd = rs.getInt("spd");
			int userBlk = rs.getInt("blk");
			int userMoney = rs.getInt("money");
			String userWeapon = rs.getString("weapon");
			
			result = new UserVO(userId, userName, userPw, userScore, userLv, userExp, userHp, userStr, userSpd, userBlk, userMoney, userWeapon);
		}
		
		if(ps != null) ps.close();
		if(rs != null) rs.close();
		
		return result;
		
	}
	
	// 회원가입
	public int registUser(Connection conn, UserVO user) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO				");
		query.append("		users				");
		query.append("		(					");
		query.append("			user_id			");
		query.append("		  ,	user_name		");
		query.append("		  ,	user_password	");
		query.append("		  ,	user_score		");
		query.append("		  ,	user_lv			");
		query.append("		  ,	user_exp		");
		query.append("		  ,	user_hp			");
		query.append("		  ,	user_str		");
		query.append("		  ,	user_spd		");
		query.append("		  ,	user_blk		");
		query.append("		  ,	user_money		");
		query.append("		  ,	user_weapon		");
		query.append("		) VALUES (			");
		query.append("			?				");
		query.append("		  ,	?				");
		query.append("		  ,	?				");
		query.append("		  ,	?				");
		query.append("		  ,	?				");
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
		ps.setString(idx++, user.getUserId());
		ps.setString(idx++, user.getUserName());
		ps.setString(idx++, user.getUserPassword());
		ps.setInt(idx++, user.getUserScore());
		ps.setInt(idx++, user.getUserLv());
		ps.setInt(idx++, user.getUserExp());
		ps.setInt(idx++, user.getUserHp());
		ps.setInt(idx++, user.getUserStr());
		ps.setInt(idx++, user.getUserSpd());
		ps.setInt(idx++, user.getUserBlk());
		ps.setInt(idx++, user.getUserMoney());
		ps.setString(idx++, user.getUserWeapon());
		
		int result = ps.executeUpdate();
		if(ps != null) ps.close();
		
		return result;
	}
	
	// 업데이트
	public int updateUser(Connection conn, UserVO user) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("UPDATE					");
		query.append("		users				");
		query.append("SET						");
		query.append("	 	user_name = ?		");
		query.append("	 ,	user_password = ?	");
		query.append("	 ,	user_score = ?		");
		query.append("	 ,	user_lv = ?			");
		query.append("	 ,	user_exp = ?		");
		query.append("	 ,	user_hp	 = ?		");
		query.append("	 ,	user_str = ?		");
		query.append("	 ,	user_spd = ?		");
		query.append("	 ,	user_blk = ?		");
		query.append("	 ,	user_money = ?		");
		query.append("	 ,	user_weapon = ?		");
		query.append("WHERE 1=1					");
		query.append("	AND	user_id = ?			");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, user.getUserName());
		ps.setString(idx++, user.getUserPassword());
		ps.setInt(idx++, user.getUserScore());
		ps.setInt(idx++, user.getUserLv());
		ps.setInt(idx++, user.getUserExp());
		ps.setInt(idx++, user.getUserHp());
		ps.setInt(idx++, user.getUserStr());
		ps.setInt(idx++, user.getUserSpd());
		ps.setInt(idx++, user.getUserBlk());
		ps.setInt(idx++, user.getUserMoney());
		ps.setString(idx++, user.getUserWeapon());
		ps.setString(idx++, user.getUserId());
		
		int result = ps.executeUpdate();
		if(ps != null) ps.close();
		
		return result;
	}
	
	
}
