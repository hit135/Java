package weapon.vo;

public class MonsterVO {
	private String type;
	private String name;
	private int hp;
	private int lv;
	private int exp;
	private int str;
	private int spd;
	private int blk;
	private String skill;
	
	public MonsterVO() {}

	public MonsterVO(String type, String name, int hp, int lv, int exp, int str, int spd, int blk, String skill) {
		super();
		this.type = type;
		this.name = name;
		this.hp = hp;
		this.lv = lv;
		this.exp = exp;
		this.str = str;
		this.spd = spd;
		this.blk = blk;
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "MonsterVO [type=" + type + ", name=" + name + ", hp=" + hp + ", lv=" + lv + ", exp=" + exp + ", str="
				+ str + ", spd=" + spd + ", blk=" + blk + ", skill=" + skill + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public int getBlk() {
		return blk;
	}

	public void setBlk(int blk) {
		this.blk = blk;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
	

}
