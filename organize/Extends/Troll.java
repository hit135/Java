package ch10_extends.Extends;

public class Troll extends Orc{
	
	private double regenerative;

	// 부모에서 끌어온 생성자
	public Troll(int nature, String name, int hp, int mp, int damage, int armor, double attackSpeed, double attackRange,
			double moveSpeed) {
		super(nature, name, hp, mp, damage, armor, attackSpeed, attackRange, moveSpeed);
		this.regenerative = 1.5;
	}

	public void regen() {
		System.out.println("재생력 증가");
		regenerative += 5;
		super.setHp(super.getHp() * 2);
		System.out.println(this);
	}
	
	
	
	
	// toString
	@Override
	public String toString() {
		return super.toString() + " | 재생력 : " + regenerative;
	}
	// Getter Setter
	public double getRegenerative() {
		return regenerative;
	}
	public void setRegenerative(double regenerative) {
		this.regenerative = regenerative;
	}
	
	
	
	
	
	
	
	
	
	
	

}
