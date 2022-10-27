package ch10_extends.Extends;

public class Orc extends WarCraftUnit {
	
	private String type;
	private int nature;
	
	// from super
	// 부모에서 따와서 생성자 생성
	public Orc(int nature, String name, int hp, int mp, int damage, int armor, double attackSpeed, double attackRange,
			double moveSpeed) {
		super(name, hp, mp, damage, armor, attackSpeed, attackRange, moveSpeed);
		this.type = "오크";
		this.nature = nature;
	}
	
	
	public void berserk() {
		System.out.println("광폭화!");
		super.setHp(super.getHp() / 2);
		super.setAttackSpeed(super.getAttackSpeed() * 2);
		System.out.println(this);
	}
	
	
	
	
	
	
	// toString
	@Override
	public String toString() {
		return "[" + type + "]" + " 자연(" + nature +")\n" + super.toString();
	}
	// getter setter
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNature() {
		return nature;
	}

	public void setNature(int nature) {
		this.nature = nature;
	}
	
	
	
	
	
	
	
	
	
	
	

}
