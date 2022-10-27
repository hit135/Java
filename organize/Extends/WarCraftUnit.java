package ch10_extends.Extends;

public class WarCraftUnit {
	private String Name;
	private int Hp;
	private int Mp;
	private int damage;
	private int armor;
	private double attackSpeed;
	private double attackRange;
	private double moveSpeed;
	
	// 생성자
	public WarCraftUnit() {}
	public WarCraftUnit(String name, int hp, int mp, int damage, int armor, double attackSpeed, double attackRange,
			double moveSpeed) {
		super();
		Name = name;
		Hp = hp;
		Mp = mp;
		this.damage = damage;
		this.armor = armor;
		this.attackSpeed = attackSpeed;
		this.attackRange = attackRange;
		this.moveSpeed = moveSpeed;
	}
	
	// toString
	@Override
	public String toString() {
		return "이름 : " + Name + " | 체력 : " + Hp + " | 마나 : " + Mp + " | 데미지 : " + damage + " | 방어력 : " + armor
				+ " | 공속 : " + attackSpeed + " | 사정거리 : " + attackRange + " | 이속 : " + moveSpeed;
	}
	
	// getter setter
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getHp() {
		return Hp;
	}
	public void setHp(int hp) {
		Hp = hp;
	}
	public int getMp() {
		return Mp;
	}
	public void setMp(int mp) {
		Mp = mp;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public double getAttackSpeed() {
		return attackSpeed;
	}
	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	public double getAttackRange() {
		return attackRange;
	}
	public void setAttackRange(double attackRange) {
		this.attackRange = attackRange;
	}
	public double getMoveSpeed() {
		return moveSpeed;
	}
	public void setMoveSpeed(double moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	
	
	
	
	
	
	
	
	

}
