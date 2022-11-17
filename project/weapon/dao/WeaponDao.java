package weapon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import weapon.vo.WeaponVO;

public class WeaponDao {
	
	private WeaponDao() {}
	
	private static WeaponDao instance = new WeaponDao();
	
	public static WeaponDao getInstance() {
		return instance;
	}
	
	
	// 무기 목록 조회
	public ArrayList<WeaponVO> getWeaponList(Connection conn) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("SELECT							");
		query.append("		weapon_type		AS type	");
		query.append("	 ,	weapon_name		AS name		");
		query.append("	 ,	weapon_str		AS str		");
		query.append("	 ,	weapon_spd		AS spd	");
		query.append("	 ,	weapon_blk		AS blk		");
		query.append("	 ,	weapon_skill	AS skill	");
		query.append("FROM								");
		query.append("	  weapons						");
		query.append("ORDER BY weapon_type				");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<WeaponVO> result = new ArrayList<>();
		
		while(rs.next()) {
			WeaponVO weapon = new WeaponVO();
			weapon.setWeaponType(rs.getString("type"));
			weapon.setWeaponName(rs.getString("name"));
			weapon.setWeaponStr(rs.getInt("str"));
			weapon.setWeaponSpd(rs.getInt("spd"));
			weapon.setWeaponBlk(rs.getInt("blk"));
			weapon.setWeaponSkill(rs.getString("skill"));
			
			result.add(weapon);
		}
		if(ps != null) ps.close();
		if(rs != null) rs.close();
		
		return result;
	}
	
	

}
