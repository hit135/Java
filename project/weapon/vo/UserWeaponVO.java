package weapon.vo;

public class UserWeaponVO {
	private String userId;
	private String weaponType;
	private String weaponName;
	private int weaponEnforce;
	private int weaponStr;
	private int weaponSpd;
	private int weaponBlk;
	private String weaponSkill;
	
	public UserWeaponVO() {}
	
	public UserWeaponVO(String userId) {
		this.userId = userId;
		this.weaponType = "";
		this.weaponName = "없음";
		this.weaponEnforce = 0;
		this.weaponStr = 0;
		this.weaponSpd = 0;
		this.weaponBlk = 0;
		this.weaponSkill = "";
	}

	public UserWeaponVO(String userId, String weaponType, String weaponName, int weaponEnforce, int weaponStr, int weaponSpd,
			int weaponBlk, String weaponSkill) {
		super();
		this.userId = userId;
		this.weaponType = weaponType;
		this.weaponName = weaponName;
		this.weaponEnforce = weaponEnforce;
		this.weaponStr = weaponStr;
		this.weaponSpd = weaponSpd;
		this.weaponBlk = weaponBlk;
		this.weaponSkill = weaponSkill;
	}

	@Override
	public String toString() {
		return "무기 정보 [" + "타입 = " + weaponType + ", 이름 = " + weaponName + ", 강화 +" + weaponEnforce + " ]"
				+ "\n\t   공격력 = " + weaponStr + ", 속도 = " + weaponSpd + ", 방어력 = " + weaponBlk
				+ "\n\t   스킬 = " + weaponSkill;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public int getWeaponStr() {
		return weaponStr;
	}

	public void setWeaponStr(int weaponStr) {
		this.weaponStr = weaponStr;
	}

	public int getWeaponSpd() {
		return weaponSpd;
	}

	public int getWeaponEnforce() {
		return weaponEnforce;
	}

	public void setWeaponEnforce(int weaponEnforce) {
		this.weaponEnforce = weaponEnforce;
	}

	public void setWeaponSpd(int weaponSpd) {
		this.weaponSpd = weaponSpd;
	}

	public int getWeaponBlk() {
		return weaponBlk;
	}

	public void setWeaponBlk(int weaponBlk) {
		this.weaponBlk = weaponBlk;
	}

	public String getWeaponSkill() {
		return weaponSkill;
	}

	public void setWeaponSkill(String weaponSkill) {
		this.weaponSkill = weaponSkill;
	}
	
	

}
