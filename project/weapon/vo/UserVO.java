package weapon.vo;

public class UserVO {
	private String userId;
	private String userName;
	private String userPassword;
	private int userScore;
	private int userLv;
	private int userExp;
	private int userHp;
	private int userStr;
	private int userSpd;
	private int userBlk;
	private int userMoney;
	private String userWeapon;
	
	public UserVO() {}
	
	public UserVO(String userId, String userName, String userPassword, int userScore, int userLv, int userExp
			, int userHp, int userStr,int userSpd, int userBlk, int userMoney, String userWeapon) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userScore = userScore;
		this.userLv = userLv;
		this.userExp = userExp;
		this.userHp = userHp;
		this.userStr = userStr;
		this.userSpd = userSpd;
		this.userBlk = userBlk;
		this.userMoney = userMoney;
		this.userWeapon = userWeapon;
	}

	@Override
	public String toString() {
		return "유저 아이디: " + userId + "\n유저 닉네임: " + userName + "\n유저 점수: " + userScore + "\n유저Lv: "
				+ userLv  + "\n유저Exp: " + userExp + "\n스탯 - HP : " + userHp + ", STR : " + userStr + ", SPD : " + userSpd + ", BLK : " + userBlk
				+ "\n유저가 지닌 돈 : " + userMoney + "\n유저 무기 : " + userWeapon;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserLv() {
		return userLv;
	}

	public void setUserLv(int userLv) {
		this.userLv = userLv;
	}

	public int getUserExp() {
		return userExp;
	}

	public int getUserHp() {
		return userHp;
	}

	public void setUserHp(int userHp) {
		this.userHp = userHp;
	}

	public int getUserBlk() {
		return userBlk;
	}

	public void setUserBlk(int userBlk) {
		this.userBlk = userBlk;
	}

	public int getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(int userMoney) {
		this.userMoney = userMoney;
	}

	public String getUserWeapon() {
		return userWeapon;
	}

	public void setUserWeapon(String userWeapon) {
		this.userWeapon = userWeapon;
	}

	public void setUserExp(int userExp) {
		this.userExp = userExp;
	}

	public int getUserStr() {
		return userStr;
	}

	public void setUserStr(int userStr) {
		this.userStr = userStr;
	}

	public int getUserSpd() {
		return userSpd;
	}

	public void setUserSpd(int userSpd) {
		this.userSpd = userSpd;
	}

	public int getUserScore() {
		return userScore;
	}

	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}
	
	
	
	

}
