package ch10_extends.Extends;

public class Undead extends WarCraftUnit {
	
	private String type;
	private int dark;
	
	// from super
	// 부모에서 따와서 생성자 생성
	public Undead(int dark, String name, int hp, int mp, int damage, int armor, double attackSpeed, double attackRange,
			double moveSpeed) {
		super(name, hp, mp, damage, armor, attackSpeed, attackRange, moveSpeed);
		this.type = "언데드";
		this.dark = dark;
	}
	
	
	
	
	
	
	
	
	
	// toString
	@Override
	public String toString() {
		return "[" + type + "]" + " 어둠(" + dark +")\n" + super.toString();
	}
	// getter setter
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDark() {
		return dark;
	}

	public void setDark(int dark) {
		this.dark = dark;
	}

	
	
	
	
	
	
	
	
	

}
