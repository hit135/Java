package ch10_extends.Extends;

public class NightElf extends WarCraftUnit {
	
	private String type;
	private int light;
	
	// from super
	// 부모에서 따와서 생성자 생성
	public NightElf(int light, String name, int hp, int mp, int damage, int armor, double attackSpeed, double attackRange,
			double moveSpeed) {
		super(name, hp, mp, damage, armor, attackSpeed, attackRange, moveSpeed);
		this.type = "나이트엘프";
		this.light = light;
	}
	
	
	
	
	
	
	
	
	
	// toString
	@Override
	public String toString() {
		return "[" + type + "]" + " 빛(" + light +")\n" + super.toString();
	}
	// getter setter
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLight() {
		return light;
	}

	public void setLight(int light) {
		this.light = light;
	}
	
	
	
	
	

}
