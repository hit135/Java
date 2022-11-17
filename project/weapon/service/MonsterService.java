package weapon.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import weapon.Color;
import weapon.dao.MonsterDao;
import weapon.jdbc.ConnectionPool;
import weapon.vo.MonsterVO;
import weapon.vo.UserVO;
import weapon.vo.UserWeaponVO;
import weapon.vo.WeaponVO;

public class MonsterService {
	private MonsterDao dao = MonsterDao.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	UserService userService = UserService.getInstance();
	
	private MonsterService() {}
	private static MonsterService instance = new MonsterService();
	public static MonsterService getInstance() {
		return instance;
	}
	
	// 모든 몬스터 조회
	public ArrayList<MonsterVO> getMonsterList(){
		Connection conn = cp.getConnection();
		
		ArrayList<MonsterVO> result = new ArrayList<>();
		try {
			result = dao.getMonsterList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 몬스터 이름에 따른 한마리 추출
	// 피라미터는 몬스터 이름!!
	public MonsterVO getMonsetrByName(String monster) {
		Connection conn = cp.getConnection();
		
		MonsterVO result = new MonsterVO();
		
		try {
			result = dao.getMonsterByName(conn, monster);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 몬스터 정보 업데이트
	public void updateMonster(MonsterVO monster) {
		Connection conn = cp.getConnection();
		try {
			dao.updateMonster(conn, monster);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) cp.releaseConnection(conn);
		}
		
	}
	
	
	// 몬스터 값에 랜덤한 값 부여
	// 레벨 + 1 ~ 3 랜덤한 값
	// 공격력 속도 방어력에 랜덤한 값 1 ~ 3 증가
	// 레벨에 따라 hp + (lv * 10)
	// 피라미터는 몬스터 이름!!
	public MonsterVO randomMonster(String mon) {
		MonsterVO monster = getMonsetrByName(mon);
		int randInt = (int)(Math.ceil(Math.random() * 3));
		
		// 레벨에 + 1 ~ 3
		monster.setLv(monster.getLv() + randInt);
		// 레벨에 따라 hp ++
		monster.setHp(monster.getHp() + (monster.getLv() * 10) );
		// 랜덤한 스텟부여
		for(int i = 0; i < randInt; i ++) {
			int randStat = (int)(Math.ceil(Math.random() * 3));
			if(randStat == 1) {
				monster.setStr(monster.getStr() + 1);
			}else if(randStat == 2) {
				monster.setSpd(monster.getSpd() + 1);
			}else if(randStat == 3) {
				monster.setBlk(monster.getBlk() + 1);
			}
		}
		return monster;
	}
	// 몬스터 hp바 출력
	// max hp가 있고 현재 hp에 따라 hp바가 변한다!
	public void printHp(MonsterVO monster, int maxHp) {
		int nowHp = monster.getHp();
		
		System.out.println("\n\t\t\t\t\t\t\t\t\t" + nowHp + " / " + maxHp);
		
		int hpPer = (int)((nowHp / (maxHp * 1.0)) * 10);
		// 이러면 hpPer는 1~10으로 나올것이다
		
		if(hpPer <= 10 && hpPer > 8) {
			System.out.println(Color.red +
					"\t\t\t\t\t  @@   @@                                    \n" + 
					"\t\t\t\t\t @ .@ @ .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t\t\t\t\t @   @  .@|||||||||||||||||||||||||||||||||||||||||||||||||||||||||@ \n" + 
					"\t\t\t\t\t @      .@|||||||||||||||||||||||||||||||||||||||||||||||||||||||||@ \n" + 
					"\t\t\t\t\t @      .@|||||||||||||||||||||||||||||||||||||||||||||||||||||||||@ \n" + 
					"\t\t\t\t\t  @:   ;@||||||||||||||||||||||||||||||||||||||||||||||||||||||||||@ \n" + 
					"\t\t\t\t\t   @; ;@|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||@ \n" + 
					"\t\t\t\t\t    @:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t\t\t\t\t     @                                       " + Color.exit );
		}else if(hpPer <= 8 && hpPer > 6) {
			System.out.println(Color.red +
					"\t\t\t\t\t  @@   @@                                    \n" + 
					"\t\t\t\t\t @ .@ @ .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t\t\t\t\t @   @  .@||||||||||||||||||||||||||||||||||||||||||||||           @ \n" + 
					"\t\t\t\t\t @      .@||||||||||||||||||||||||||||||||||||||||||||||           @ \n" + 
					"\t\t\t\t\t @      .@||||||||||||||||||||||||||||||||||||||||||||||           @ \n" + 
					"\t\t\t\t\t  @:   ;@|||||||||||||||||||||||||||||||||||||||||||||||           @ \n" + 
					"\t\t\t\t\t   @; ;@||||||||||||||||||||||||||||||||||||||||||||||||           @ \n" + 
					"\t\t\t\t\t    @:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t\t\t\t\t     @                                       " + Color.exit );
		}else if(hpPer <= 6 && hpPer > 4) {
			System.out.println(Color.red +
					"\t\t\t\t\t  @@   @@                                    \n" + 
					"\t\t\t\t\t @ .@ @ .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t\t\t\t\t @   @  .@||||||||||||||||||||||||||||||||                         @ \n" + 
					"\t\t\t\t\t @      .@||||||||||||||||||||||||||||||||                         @ \n" + 
					"\t\t\t\t\t @      .@||||||||||||||||||||||||||||||||                         @ \n" + 
					"\t\t\t\t\t  @:   ;@|||||||||||||||||||||||||||||||||                         @ \n" + 
					"\t\t\t\t\t   @; ;@||||||||||||||||||||||||||||||||||                         @ \n" + 
					"\t\t\t\t\t    @:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t\t\t\t\t     @                                       " + Color.exit );
		}else if(hpPer <= 4 && hpPer > 2) {
			System.out.println(Color.red +
					"\t\t\t\t\t  @@   @@                                    \n" + 
					"\t\t\t\t\t @ .@ @ .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t\t\t\t\t @   @  .@||||||||||||||||||                                      @ \n" + 
					"\t\t\t\t\t @      .@||||||||||||||||||                                      @ \n" + 
					"\t\t\t\t\t @      .@||||||||||||||||||                                      @ \n" + 
					"\t\t\t\t\t  @:   ;@|||||||||||||||||||                                      @ \n" + 
					"\t\t\t\t\t   @; ;@||||||||||||||||||||                                      @ \n" + 
					"\t\t\t\t\t    @:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t\t\t\t\t     @                                       " + Color.exit );
		}else if(hpPer <= 2 && hpPer > 0) {
			System.out.println(Color.red +
					"\t\t\t\t\t  @@   @@                                    \n" + 
					"\t\t\t\t\t @ .@ @ .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t\t\t\t\t @   @  .@|||||||||                                               @ \n" + 
					"\t\t\t\t\t @      .@|||||||||                                               @ \n" + 
					"\t\t\t\t\t @      .@|||||||||                                               @ \n" + 
					"\t\t\t\t\t  @:   ;@||||||||||                                               @ \n" + 
					"\t\t\t\t\t   @; ;@|||||||||||                                               @ \n" + 
					"\t\t\t\t\t    @:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t\t\t\t\t     @                                       " + Color.exit );
		}else if(hpPer == 0) {
			System.out.println(Color.red +
					"\t\t\t\t\t  @@   @@                                    \n" + 
					"\t\t\t\t\t @ .@ @ .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t\t\t\t\t @   @  .@                                                       @ \n" + 
					"\t\t\t\t\t @      .@                                                       @ \n" + 
					"\t\t\t\t\t @      .@                                                       @ \n" + 
					"\t\t\t\t\t  @:   ;@                                                        @ \n" + 
					"\t\t\t\t\t   @; ;@                                                         @ \n" + 
					"\t\t\t\t\t    @:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t\t\t\t\t     @                                       " + Color.exit );
		}
		
		
	}

	// 유저 hp바 출력
	public void printHp(UserVO user, int maxHp) {
		int nowHp = user.getUserHp();
		
		System.out.println("\n\t\t" + nowHp + " / " + maxHp);
		
		int hpPer = (int)((nowHp / (maxHp * 1.0)) * 10);
		// 이러면 hpPer는 1~10으로 나올것이다
		
		if(hpPer <= 10 && hpPer > 8) {
			System.out.println(Color.green +
					"\t  @@   @@                                    \n" + 
					"\t @ .@ @ .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t @   @  .@|||||||||||||||||||||||||||||||||||||||||||||||||||||||||@ \n" + 
					"\t @      .@|||||||||||||||||||||||||||||||||||||||||||||||||||||||||@ \n" + 
					"\t @      .@|||||||||||||||||||||||||||||||||||||||||||||||||||||||||@ \n" + 
					"\t  @:   ;@||||||||||||||||||||||||||||||||||||||||||||||||||||||||||@ \n" + 
					"\t   @; ;@|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||@ \n" + 
					"\t    @:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t     @                                       " + Color.exit );
		}else if(hpPer <= 8 && hpPer > 6) {
			System.out.println(Color.green +
					"\t  @@   @@                                    \n" + 
					"\t @ .@ @ .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t @   @  .@||||||||||||||||||||||||||||||||||||||||||||||           @ \n" + 
					"\t @      .@||||||||||||||||||||||||||||||||||||||||||||||           @ \n" + 
					"\t @      .@||||||||||||||||||||||||||||||||||||||||||||||           @ \n" + 
					"\t  @:   ;@|||||||||||||||||||||||||||||||||||||||||||||||           @ \n" + 
					"\t   @; ;@||||||||||||||||||||||||||||||||||||||||||||||||           @ \n" + 
					"\t    @:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t     @                                       " + Color.exit );
		}else if(hpPer <= 6 && hpPer > 4) {
			System.out.println(Color.green +
					"\t  @@   @@                                    \n" + 
					"\t @ .@ @ .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t @   @  .@||||||||||||||||||||||||||||||||                         @ \n" + 
					"\t @      .@||||||||||||||||||||||||||||||||                         @ \n" + 
					"\t @      .@||||||||||||||||||||||||||||||||                         @ \n" + 
					"\t  @:   ;@|||||||||||||||||||||||||||||||||                         @ \n" + 
					"\t   @; ;@||||||||||||||||||||||||||||||||||                         @ \n" + 
					"\t    @:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t     @                                       " + Color.exit );
		}else if(hpPer <= 4 && hpPer > 2) {
			System.out.println(Color.green +
					"\t  @@   @@                                    \n" + 
					"\t @ .@ @ .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t @   @  .@||||||||||||||||||                                      @ \n" + 
					"\t @      .@||||||||||||||||||                                      @ \n" + 
					"\t @      .@||||||||||||||||||                                      @ \n" + 
					"\t  @:   ;@|||||||||||||||||||                                      @ \n" + 
					"\t   @; ;@||||||||||||||||||||                                      @ \n" + 
					"\t    @:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t     @                                       " + Color.exit );
		}else if(hpPer <= 2 && hpPer > 0) {
			System.out.println(Color.green +
					"\t  @@   @@                                    \n" + 
					"\t @ .@ @ .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t @   @  .@|||||||||                                               @ \n" + 
					"\t @      .@|||||||||                                               @ \n" + 
					"\t @      .@|||||||||                                               @ \n" + 
					"\t  @:   ;@||||||||||                                               @ \n" + 
					"\t   @; ;@|||||||||||                                               @ \n" + 
					"\t    @:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t     @                                       " + Color.exit );
		}else if(hpPer == 0) {
			System.out.println(Color.green +
					"\t  @@   @@                                    \n" + 
					"\t @ .@ @ .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t @   @  .@                                                       @ \n" + 
					"\t @      .@                                                       @ \n" + 
					"\t @      .@                                                       @ \n" + 
					"\t  @:   ;@                                                        @ \n" + 
					"\t   @; ;@                                                         @ \n" + 
					"\t    @:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \n" + 
					"\t     @                                       " + Color.exit );
		}
	}
	
	// 몬스터 타입에 따른 이미지 출력
	public void printMonsterByType(MonsterVO monster, int maxHp) {
		String monsterType = monster.getType();
		if(monsterType.equals("슬라임")) {
			System.out.println("\t\t\t" +monster.getName() + monster.getLv());
			printColor(monster);
			System.out.println(
					"\t\t\t\t\t\t                     .*;;;;*;                \n" + 
					"\t\t\t\t\t\t                    :;      ,*               \n" + 
					"\t\t\t\t\t\t                   -:         ;              \n" + 
					"\t\t\t\t\t\t                 ..;          .:             \n" + 
					"\t\t\t\t\t\t                 -,, -         ;             \n" + 
					"\t\t\t\t\t\t                ~ ~-. -        -~            \n" + 
					"\t\t\t\t\t\t               ~ ,:,.          .*            \n" + 
					"\t\t\t\t\t\t             ,, ,~~,.  ,        *            \n" + 
					"\t\t\t\t\t\t           :,  ,~:-,,   ,,      =            \n" + 
					"\t\t\t\t\t\t        ,,-  ,~::~,..     -     :            \n" + 
					"\t\t\t\t\t\t      -:  .-:::~-,.         ,   :            \n" + 
					"\t\t\t\t\t\t    -, .-~::::-,..           .  ~            \n" + 
					"\t\t\t\t\t\t  ., .~;;::~-,..             ,- ~            \n" + 
					"\t\t\t\t\t\t .- !:$!:~-,..                ,.~            \n" + 
					"\t\t\t\t\t\t - -$ !@~-,..     ,.           ,~            \n" + 
					"\t\t\t\t\t\t~  ;.  :-,,.    .#;*=          ,~            \n" + 
					"\t\t\t\t\t\t. ,!@ @=,,.     ;=,-=.          *            \n" + 
					"\t\t\t\t\t\t~ -!***-,,-     ~-  ~,          !            \n" + 
					"\t\t\t\t\t\t, -!!:~,,;# -.  ~@:;@           ~!           \n" + 
					"\t\t\t\t\t\t, -!!:~-,,.~-    ~:;,         .  *           \n" + 
					"\t\t\t\t\t\t- -;!;:-,,.                  .. ~,!       ~. \n" + 
					"\t\t\t\t\t\t~ -;!!:~-,,.   .            .~  ~ ,!    -. . \n" + 
					"\t\t\t\t\t\t- .~!!;:-,,........       ..,,  ~  .;;;.,   -\n" + 
					"\t\t\t\t\t\t.. -:!!;:-,,....,,,......,,,-  .      --:...~\n" + 
					"\t\t\t\t\t\t - .-:;;;:~-,,,,,,,,,,,,,,~-.  ~        ;~~::\n" + 
					"\t\t\t\t\t\t  . .-~:;;::~~--,,,,,,,-~-,.  -          ~-- \n" + 
					"\t\t\t\t\t\t   .  ,-~:::::::::::::~-,.   ~               \n" + 
					"\t\t\t\t\t\t    --  ,-~--~~~----,,..   ,.                \n" + 
					"\t\t\t\t\t\t     ..-   .,,,,,....   ,,,                  \n" + 
					"\t\t\t\t\t\t        .;  ~~-,,,,,~. ;                     ");
			System.out.print(Color.exit);
			printHp(monster, maxHp);
		}
		
	}
	
	// 몬스터 이름에 따른 색깔변환 열기
	public void printColor(MonsterVO monster) {
		if(monster.getName().contains("초록")) {
			System.out.print(Color.green);
		}else if(monster.getName().contains("파란")) {
			System.out.print(Color.blue);
		}else if(monster.getName().contains("빨간")) {
			System.out.print(Color.red);
		}else if(monster.getName().contains("보스")) {
			System.out.print(Color.yellow);
		}
	}
	
	// 몬스터가 유저를 공격하는 함수
	public int attack(MonsterVO monster, UserVO user, UserWeaponVO weapon) {
		int result = 0;
		
		// (몬스터 공격력 - 유저 blk) x 10 만큼의 데미  
		int monAttack = (monster.getStr() - (user.getUserBlk() + weapon.getWeaponBlk())) * 10;
		result = monAttack;
		// 유저 db에 반영
		user.setUserHp(user.getUserHp() - monAttack);
		userService.updateUser(user);
		
		return result;
	}
	
	// 유저가 몬스터를 공격하는 함수
	public int attack(UserVO user, MonsterVO monster, UserWeaponVO weapon) {
		int result = 0;
		
		// (유저 공격력 + 무기 공격력 - 몬스터 blk) x 10 만큼의 데미  
		int userAttack = ((user.getUserStr() + weapon.getWeaponStr()) - monster.getBlk()) * 10;
		result = userAttack;
		// 몬스터 db에 반영
		monster.setHp(monster.getHp() - userAttack);
		updateMonster(monster);
		
		return result;
	}
	
	// 몬스터 hp가 0 이하면 경험치, 돈 획득
	public void dieMon(MonsterVO monster, UserVO user) {
		if(monster.getHp() <= 0) {
			System.out.println(monster.getName() + "을 잡았습니다!!!");
			int getExp = getExp(monster, user);
			System.out.println(getExp + "의 경험치를 획득했습니다!!");
			int getGold = monster.getLv() * 100;
			System.out.println(getGold + "의 골드를 획득했습니다!!");
			
			// DB에 반영
			user.setUserExp(user.getUserExp() + getExp);
			user.setUserMoney(user.getUserMoney() + getGold);
			userService.updateUser(user);
		}
		
	}
	// 레벨에 따른 경험치 획득
	public int getExp(MonsterVO monster, UserVO user) {
		int monLv = monster.getLv();
		int userLv = user.getUserLv();
		int result = 0;
		
		if(monLv < userLv) {
			return 0;
		}else {
			result = (userLv - monLv) * 10;
			return result;
		}
	}
	
	// 유저 hp가 0 이하면 아무것도 얻지못하고 끝
	public void dieUser(MonsterVO monster, UserVO user) {
		if(user.getUserHp() <= 0) {
			System.out.println(monster.getName() + "의 공격을 받고..");
			System.out.println("유저가 죽었습니다..");
			System.out.println("재정비 후 다시 도전해주세요...!");
		}
		
	}
	
	
	
	
	
	
	
	
}
