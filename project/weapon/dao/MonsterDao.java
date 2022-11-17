package weapon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import weapon.vo.MonsterVO;

public class MonsterDao {
	
	private MonsterDao() {}
	private static MonsterDao instance = new MonsterDao();
	public static MonsterDao getInstance() {
		return instance;
	}
	
	// 몬스터 목록 조회
	public ArrayList<MonsterVO> getMonsterList(Connection conn) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("SELECT							");
		query.append("		monster_type	AS type		");
		query.append("	 ,	monster_name	AS name		");
		query.append("	 ,	monster_hp		AS hp		");
		query.append("	 ,	monster_lv		AS lv		");
		query.append("	 ,	monster_exp		AS exp		");
		query.append("	 ,	monster_str		AS str		");
		query.append("	 ,	monster_spd		AS spd		");
		query.append("	 ,	monster_blk		AS blk		");
		query.append("	 ,	monster_skill	AS skill	");
		query.append("FROM								");
		query.append("	  monster						");
		query.append("ORDER BY user_id					");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<MonsterVO> result = new ArrayList<>();
		
		while(rs.next()) {
			MonsterVO monster = new MonsterVO();
			monster.setType(rs.getString("type"));
			monster.setName(rs.getString("name"));
			monster.setHp(rs.getInt("hp"));
			monster.setLv(rs.getInt("lv"));
			monster.setExp(rs.getInt("exp"));
			monster.setStr(rs.getInt("str"));
			monster.setSpd(rs.getInt("spd"));
			monster.setBlk(rs.getInt("blk"));
			monster.setSkill(rs.getString("skill"));
			
			result.add(monster);
		}
		if(ps != null) ps.close();
		if(rs != null) rs.close();
		
		return result;
	}
	
	// 몬스터 이름에 따라 몬스터 하나 추출
	public MonsterVO getMonsterByName(Connection conn, String monster) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("SELECT							");
		query.append("		monster_type	AS type		");
		query.append("	 ,	monster_name	AS name		");
		query.append("	 ,	monster_hp		AS hp		");
		query.append("	 ,	monster_lv		AS lv		");
		query.append("	 ,	monster_exp		AS exp		");
		query.append("	 ,	monster_str		AS str		");
		query.append("	 ,	monster_spd		AS spd		");
		query.append("	 ,	monster_blk		AS blk		");
		query.append("	 ,	monster_skill	AS skill	");
		query.append("FROM								");
		query.append("	  monster						");
		query.append("WHERE 1=1							");
		query.append("  AND monster_name = ?			");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, monster);
		
		ResultSet rs = ps.executeQuery();
		
		MonsterVO result = null;
		
		while(rs.next()) {
			String type = rs.getString("type");
			String name = rs.getString("name");
			int hp = rs.getInt("hp");
			int lv = rs.getInt("lv");
			int exp = rs.getInt("exp");
			int str = rs.getInt("str");
			int spd = rs.getInt("spd");
			int blk = rs.getInt("blk");
			String skill = rs.getString("skill");
			
			result = new MonsterVO(type, name, hp, lv, exp, str, spd, blk, skill);
		}
		if(ps != null) ps.close();
		if(rs != null) rs.close();
		
		return result;
		
	}
	
	// 업데이트
	public void updateMonster(Connection conn, MonsterVO monster) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("UPDATE					");
		query.append("		monster				");
		query.append("SET						");
		query.append("	 	monster_type = ?	");
		query.append("	 ,	monster_hp = ?		");
		query.append("	 ,	monster_lv = ?		");
		query.append("	 ,	monster_exp = ?		");
		query.append("	 ,	monster_str	 = ?	");
		query.append("	 ,	monster_spd = ?		");
		query.append("	 ,	monster_blk = ?		");
		query.append("	 ,	monster_skill = ?	");
		query.append("WHERE 1=1					");
		query.append("	AND	monster_name = ?	");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, monster.getType());
		ps.setInt(idx++, monster.getHp());
		ps.setInt(idx++, monster.getLv());
		ps.setInt(idx++, monster.getExp());
		ps.setInt(idx++, monster.getStr());
		ps.setInt(idx++, monster.getSpd());
		ps.setInt(idx++, monster.getBlk());
		ps.setString(idx++, monster.getSkill());
		ps.setString(idx++, monster.getName());
		
		ps.executeUpdate();
		if(ps != null) ps.close();
		
	}
	
	
	
	
	
	
	
	
	
}
