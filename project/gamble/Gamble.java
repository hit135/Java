package review.gamble;

public class Gamble {
	
	private String name;
	private String grade;
	private int type;
	private String distance;
	private double time;
	
	// 생성자
	public Gamble() {}
	
	public Gamble(String name, String grade, int type) {
		this.name = name;
		this.grade = grade;
		this.type = type;
		this.distance = "--ㅁ";
		this.time = 0.0;
	}
	
	// toString
	@Override
	public String toString() {
		if(type == 0) {
			return "[" + "등급 : " + grade + " >>> " + name + " | 도주]";
		}else if(type == 1) {
			return "[" + "등급 : " + grade + " >>> " + name + " | 선행]";
		}else if(type == 2) {
			return "[" + "등급 : " + grade + " >>> " + name + " | 선입]";
		}else {
			return "[" + "등급 : " + grade + " >>> " + name + " | 추입]";
		}
	}

	// getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
	
	public double getTime() {
		return time;
	}
	
	public void setTime(double time) {
		this.time = time;
	}
	
	
	
	
	
	
	
	

}
