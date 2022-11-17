package weapon.vo;

public class WeaponVO {
	private String weaponType;
	private String weaponName;
	private int weaponStr;
	private int weaponSpd;
	private int weaponBlk;
	private String weaponSkill;
	
	public WeaponVO() {}
	
	public WeaponVO(String weaponType, String weaponName, int weaponStr, int weaponSpd, int weaponBlk,
			String weaponSkill) {
		super();
		this.weaponType = weaponType;
		this.weaponName = weaponName;
		this.weaponStr = weaponStr;
		this.weaponSpd = weaponSpd;
		this.weaponBlk = weaponBlk;
		this.weaponSkill = weaponSkill;
	}

	@Override
	public String toString() {
		return "무기 정보 [타입= " + weaponType + ", 이름= " + weaponName + ", 공격력= " + weaponStr
				+ ", 속도= " + weaponSpd + ", 방어력= " + weaponBlk + ", 스킬= " + weaponSkill + "]";
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
