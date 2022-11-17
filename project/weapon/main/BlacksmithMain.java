package weapon.main;

import java.util.ArrayList;
import java.util.Scanner;

import weapon.Color;
import weapon.jdbc.ConnectionPool;
import weapon.service.MonsterService;
import weapon.service.UserService;
import weapon.service.UserWeaponService;
import weapon.service.WeaponService;
import weapon.vo.MonsterVO;
import weapon.vo.UserVO;
import weapon.vo.UserWeaponVO;
import weapon.vo.WeaponVO;

public class BlacksmithMain {

	public static void main(String[] args) {
		UserService userService = UserService.getInstance();
		WeaponService weaponService = WeaponService.getInstance();
		UserWeaponService userWeaponService = UserWeaponService.getInstance();
		MonsterService monsterService = MonsterService.getInstance();
		ConnectionPool cp = ConnectionPool.getInstance();
		
		
		System.out.println(
				"                                                     ___\n" + 
				"                                             ___..--'  .`.\n" + 
				"                                    ___...--'     -  .` `.`.\n" + 
				"                           ___...--' _      -  _   .` -   `.`.\n" + 
				"                  ___...--'  -       _   -       .`  `. - _ `.`.\n" + 
				"           __..--'_______________ -         _  .`  _   `.   - `.`.\n" + 
				"        .`    _ /\\    -        .`      _     .`__________`. _  -`.`.\n" + 
				"      .` -   _ /  \\_     -   .`  _         .` |Black Smith|`.   - `.`.\n" + 
				"    .`-    _  /   /\\   -   .`        _   .`   |___________|  `. _   `.`.\n" + 
				"  .`________ /__ /_ \\____.`____________.`     ___       ___  - `._____`|\n" + 
				"    |   -  __  -|    | - |  ____  |   | | _  |   |  _  |   |  _ |\n" + 
				"    | _   |  |  | -  |   | |.--.| |___| |    |___|     |___|    |\n" + 
				"    |     |--|  |    | _ | |'--'| |---| |   _|---|     |---|_   |\n" + 
				"    |   - |__| _|  - |   | |.--.| |   | |    |   |_  _ |   |    |\n" + 
				" ---``--._      |    |   |=|'--'|=|___|=|====|___|=====|___|====|\n" + 
				" -- . ''  ``--._| _  |  -|_|.--.|_______|_______________________|\n" + 
				"`--._           '--- |_  |:|'--'|:::::::|:::::::::::::::::::::::|\n" + 
				"_____`--._ ''      . '---'``--._|:::::::|:::::::::::::::::::::::|\n" + 
				"----------`--._          ''      ``--.._|:::::::::::::::::::::::|\n" + 
				"`--._ _________`--._'        --     .   ''-----..............LGB'\n" + 
				"     `--._----------`--._.  _           -- . :''           -    ''\n" + 
				"          `--._ _________`--._ :'              -- . :''      -- . ''\n" + 
				" -- . ''       `--._ ---------`--._   -- . :''\n" + 
				"          :'        `--._ _________`--._:'  -- . ''      -- . ''\n" + 
				"  -- . ''     -- . ''    `--._----------`--._      -- . ''     -- . ''\n" + 
				"                              `--._ _________`--._\n" + 
				" -- . ''           :'              `--._ ---------`--._-- . ''    -- . ''\n" + 
				"          -- . ''       -- . ''         `--._ _________`--._   -- . ''\n" + 
				":'                 -- . ''          -- . ''  `--._----------`--._");
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("\nBlackSmithe에 다시 돌아오신 것을 환영합니다!");
			System.out.println("행동을 선택하십시오.");
			System.out.println("1. 로그인 || 2. 회원가입 || 3. 종료");
			System.out.print(">>> ");
			
			int command = 0;
			
			try {
				command = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력하십시오.");
				continue;
			}
			
			if(command == 1) {
				// 로그인
				System.out.print("아이디: ");
				String inputId = scan.nextLine();
				System.out.print("비밀번호: ");
				String inputPw = scan.nextLine();
				
				// DB에서 pw체크
				UserVO login = userService.loginUser(inputId);
				
				if (login != null) {
					System.out.println(login.getUserId());
					System.out.println(login.getUserPassword());
					
					if (inputPw.equals(login.getUserPassword())) {
						// 로그인 성공
						UserWeaponVO myWeapon = new UserWeaponVO() {};
						
						System.out.println("로그인되었습니다.");
						System.out.println(login.getUserName() + "님 반갑습니다!");
						System.out.println("현재 당신의 점수는 " + login.getUserScore() + "점 입니다.");
						System.out.println("현재 Lv " + login.getUserLv() + " 스탯 >> HP = " + login.getUserHp() + ", STR = " + login.getUserStr() 
						+ ", SPD = " + login.getUserSpd() + ", BLK = " + login.getUserBlk());
						System.out.println("현재 소지금 : " + login.getUserMoney() + "G" + "\t\t현재 무기 : " + login.getUserWeapon());
						
						
						
						while(true) {
							
							// 무기가 없을 때 무기 뽑기
							if(login.getUserWeapon().equals("없음")) {
								System.out.println("\n=====================================");
								System.out.println("현재 지닌 무기가 없기 때문에..");
								System.out.println("무기 뽑기를 진행합니다!");
								System.out.println("원하는 무기 타입을 선택해주세요!");
								System.out.println(
										"   |^^^|								 _________________________ 							\n" + 
										"    }_{				4$$-.					|<><><>     |  |    <><><>|							\n" + 
										"    }_{				4   \".					|<>         |  |        <>|							\n" + 
										"/|_/---\\_|\\			4    ^.					|           |  |          |							\n" + 
										"I _|\\_/|_ I			4     $					|  (______ <\\-/> ______)  |						\n" + 
										"\\| |   | |/			4     'b				|  /_.-=-.\\| \" |/.-=-._\\  |						\n" + 
										"   |   |			4      \"b.				|   /_    \\(o_o)/    _\\   |						\n" + 
										"   |   |			4        $				|    /_  /\\/ ^ \\/\\  _\\    |						\n" + 
										"   |   |			4        $r				|      \\/ | / \\ | \\/      |						\n" + 
										"   |   |			4        $F				|_______ /((( )))\\ _______|						\n" + 
										"   |   |		-$b========4========$b====*P=-			|      __\\ \\___/ /__      |						\n" + 
										"   |   |			4       *$$F 				|--- (((---'   '---))) ---|							\n" + 
										"   |   |			4        $$\"				|           |  |          |							\n" + 
										"   |   |			4       .$F				:           |  |          :  						\n" + 
										"   |   |			4       dP 				 \\<>        |  |       <>/ 						\n" + 
										"   |   |			4      F 				  \\<>       |  |      <>/ 							\n" + 
										"   |   |			4     @  				   \\<>      |  |     <>/ 							\n" + 
										"   |   |			4    . 					    `\\<>    |  |   <>/'  							\n" + 
										"   |   |			J.					      `\\<>  |  |  <>/'  							\n" + 
										"   \\   /			$$					        `\\<>|  |<>/'								\n" + 
										"    \\ /				 					          `-.  .-`									\n" + 
										"     Y																								");
								while(true) {
									System.out.println("신화 0.5% / 전설 4.5% / 레어 15% / 일반 80%");
									System.out.println("1. 검 | 2. 활 | 3. 방패");
									System.out.print(">>> ");
									int selectWeapon = 0;
									try {
										selectWeapon = Integer.parseInt(scan.nextLine());
									} catch (NumberFormatException e) {
										System.out.println("숫자로 입력하십시오.");
										continue;
									}
									if(selectWeapon == 1 || selectWeapon == 2 || selectWeapon == 3) {
										// 무기 타입 출력 >> 문자
										String myWeaponType = userService.gachaWeapon(login, selectWeapon);
										// 무기 DB에서 랜덤한 무기 출력
										WeaponVO myWeapontemp = weaponService.getWeaponByType(myWeaponType);
										// 유저 무기 정보 DB에 추가
										myWeapon = new UserWeaponVO(login.getUserId(), myWeapontemp.getWeaponType(), myWeapontemp.getWeaponName(), 0
												, myWeapontemp.getWeaponStr(), myWeapontemp.getWeaponSpd(), myWeapontemp.getWeaponBlk(), myWeapontemp.getWeaponSkill());
										userWeaponService.registUserWeapon(myWeapon);
										System.out.println("축하합니다! " + myWeaponType + "\t" + myWeapon.getWeaponName() + "을(를) 뽑으셨습니다!");
										login.setUserWeapon(myWeapon.getWeaponName());
										System.out.println(login);
										userService.updateUser(login);
										break;
									}else {
										System.out.println("잘못 입력하셨습니다..");
										System.out.println("다시 입력해주세요!");
									}
								}
							}else {
								// 개인 무기를 DB의 무기로 불러오기
								myWeapon = userWeaponService.getWeaponById(login);
							}
							
							// 행동 선택
							System.out.println(login.getUserName() + "님 행동을 선택해주세요");
							System.out.println("1. 내 정보 확인 | 2. 무기 강화 | 3. 무기 판매 | 4. 몬스터 사냥 | 5. 랭킹확인 | 6. 로그아웃");
							System.out.print(">>> ");
							try {
								command = Integer.parseInt(scan.nextLine());
							} catch (NumberFormatException e) {
								System.out.println("숫자로 입력하십시오.");
								continue;
							}
							// 1. 내 정보 확인
							if(command == 1) {
								System.out.println(login);
								myWeapon = userWeaponService.getWeaponById(login);
								System.out.println(myWeapon);
							
							// 2. 무기 강화
							}else if(command == 2) {
								while(true) {
									System.out.println("현재 내 무기의 강화 단계 = " + myWeapon.getWeaponEnforce());
									System.out.println((myWeapon.getWeaponEnforce() + 1) + "단계 강화에 필요한 돈은 " + ((myWeapon.getWeaponEnforce() + 1) * 100) + "G 입니다.." );
									System.out.println("\n현재 " + login.getUserMoney() + "G를 가지고 있습니다");
									System.out.println("=====================================================================");
									System.out.println("강화 성공 확률은 " + (100 - myWeapon.getWeaponEnforce()) + "% 입니다!");
									System.out.println("=====================================================================");
									System.out.println("강화 하시겠습니까?");
									System.out.println("1. 강화한다 | 2. 강화하지 않는다");
									System.out.print(">>> ");
									int enforceSel = Integer.parseInt(scan.nextLine());
									if(enforceSel == 1) {
										while(true) {
											System.out.println("강화할 스탯을 선택하세요");
											System.out.println("1. 공격력 | 2. 스피드 | 3. 방어력");
											System.out.print(">>> ");
											enforceSel = Integer.parseInt(scan.nextLine());
											if(enforceSel == 1 | enforceSel == 2 | enforceSel == 3) {
												myWeapon = userWeaponService.enforceWeapon(myWeapon, enforceSel, login);
												// DB에 반영
												userWeaponService.updateUserWeapon(myWeapon);
												userService.updateUser(login);
												break;
											}else {
												System.out.println("잘못입력하셨습니다..");
												System.out.println("다시 입력해주세요!");
											}
										}
										
									}else if(enforceSel == 2) {
										System.out.println("강화를 그만둡니다..");
										break;
									}else {
										System.out.println("잘못 입력했습니다.. 다시 입력해주세요!");
									}
								}
								// 무기 판매
							}else if(command == 3) {
								int howMuch = userWeaponService.howMuchWeapon(myWeapon);
								while(true) {
									System.out.println("내 무기의 추정 가치는 " + howMuch + "G 입니다!");
									System.out.println("무기를 판매하시겠습니까?");
									System.out.println("1. 무기 판매 | 2. 판매하지 않는다");
									System.out.print(">>> ");
									int sellSel = Integer.parseInt(scan.nextLine());
									if(sellSel == 1) {
										userWeaponService.sellWeapon(myWeapon, login);
										// db에 없데이트
										userWeaponService.deleteWeapon(myWeapon);
										userService.updateUser(login);
										// main에 갱신
										login = userService.loginUser(login.getUserId());
										myWeapon = userWeaponService.getWeaponById(login);
										System.out.println("무기를 판매하여 " + howMuch + "G를 벌었습니다");
										System.out.println("현재 남은 돈 = " + login.getUserMoney() + "G 입니다!");
										break;
									}else if(sellSel == 2) {
										System.out.println("무기를 판매하지 않습니다..");
										System.out.println("상위 메뉴로 이동합니다!");
										break;
									}else {
										System.out.println("잘못입력하셨습니다.. 다시 입력해주세요!");
									}
									
								}
								
							}else if(command == 4) {
								System.out.println(Color.green + "위대한 대장장이가 되기 위해..");
								System.out.println("나는 오늘도 열심히 일한다...!" + Color.exit);
								System.out.println("입장할 필드를 정해주세요!");
								outer:while(true) {
									System.out.println("1. 슬라임 동굴");
									System.out.println("2. 고블린의 숲");
									System.out.println("3. 악마 성");
									System.out.println("4. 드래곤 둥지");
									System.out.println("5. 사냥 종료..");
									System.out.print("어디로 입장하시겠습니까 >>> ");
									int selField = Integer.parseInt(scan.nextLine());
									if(selField == 1) {
										while(true) {
											System.out.println("스테이지를 선택해주세요!");
											System.out.println("1. 초록 슬라임 - Lv 1 ~ 4");
											System.out.println("2. 파란 슬라임 - Lv 4 ~ 7");
											System.out.println("3. 빨간 슬라임 - Lv 7 ~ 10");
											System.out.println("4. 보스 슬라임 - Lv 10 ~ 13");
											System.out.println("5. 슬라임 동굴 나가기");
											System.out.print(">>> ");
											selField = Integer.parseInt(scan.nextLine());
											if(selField == 1) {
												System.out.println("스테이지 1");
												MonsterVO slime = monsterService.getMonsetrByName("초록 슬라임");
												// 슬라임의 초기값과 나의 초기값 저장해놓기
												// 전투가 끝난후 다시 초기화 시켜야하기 때문!
												MonsterVO resetMon = slime;
												UserVO resetUser = login;
												
												// 몬스터에 랜덤 인카운터 부여
												slime = monsterService.randomMonster(slime.getName());
												int maxHp = slime.getHp();
												int userMaxHp = login.getUserHp();
												// db에 반영
												monsterService.updateMonster(slime);
												
												while(true) {
													System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
													// 몬스터랑 hp 출력
													slime = monsterService.getMonsetrByName("초록 슬라임");
													monsterService.printMonsterByType(slime, maxHp);
													// 유저 hp 출력
													login = userService.loginUser(login.getUserId());
													monsterService.printHp(login, userMaxHp);
													// switch ? : 이거였나 그거로 구현 가능할듯
													// 지금은 시간이 없으니 if문으로
													if(login.getUserSpd() >= slime.getSpd()) {
														System.out.println("행동을 선택해주세요");
														System.out.println("1. 공격한다 | 2. 스킬사용 | 3. 도망간다");
														System.out.print(">>> ");
														int selBe = Integer.parseInt(scan.nextLine());
														if(selBe == 1) {
															// 공격함수 후 슬라임 공격!
															// 유저 공격
															int userAttack = monsterService.attack(login, slime, myWeapon);
															System.out.println("나의 공격!!");
															// 시간 주기
															time(500);
															System.out.println(slime.getName() + "에게 " + userAttack + "의 피해를 입혔습니다!");
															// 시간 주기
															time(500);
															// 몬스터 hp가 0이하면 끝
															slime = monsterService.randomMonster(slime.getName());
															if(slime.getHp() <= 0) {
																monsterService.dieMon(slime, login);
																// 초기화
																slime = resetMon;
																// 유저는 exp, gold가 다르다
																login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																		, login.getUserScore(), login.getUserLv(), login.getUserExp()
																		, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																		, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																// db에 반영
																monsterService.updateMonster(slime);
																userService.updateUser(login);
																break;
															}
															// 몬스터 공격
															int monAttack = monsterService.attack(slime, login, myWeapon);
															System.out.println(slime.getName() + "의 공격!!");
															// 시간 주기
															time(500);
															System.out.println(monAttack + "의 피해를 받았습니다!");
															// 시간 주기
															time(500);
															// 유저 hp가 0이하면 끝
															login = userService.loginUser(login.getUserId());
															if(login.getUserHp() <= 0) {
																monsterService.dieUser(slime, login);
																// 초기화
																slime = resetMon;
																login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																		, login.getUserScore(), login.getUserLv(), login.getUserExp()
																		, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																		, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																// db에 반영
																monsterService.updateMonster(slime);
																userService.updateUser(login);
																break outer;
															}
														}else if(selBe == 2) {
															System.out.println("구현 안됨..");
														}else if(selBe == 3) {
															int randInt = (int)(Math.ceil(Math.random() * 50));
															if(randInt <= 50) {
																// 시간 주기
																time(500);
																System.out.println("도망에 성공하셨습니다!");
																break;
															}else {
																// 시간 주기
																time(500);
																System.out.println("도망에 실패하셨습니다...");
																// 슬라임 공격!
																int monAttack = monsterService.attack(slime, login, myWeapon);
																// 시간 주기
																time(500);
																System.out.println(slime.getName() + "의 공격!!");
																// 시간 주기
																time(500);
																System.out.println(monAttack + "의 피해를 받았습니다!");
																// 시간 주기
																time(500);
																// 유저 hp가 0이하면 끝
																login = userService.loginUser(login.getUserId());
																if(login.getUserHp() <= 0) {
																	monsterService.dieUser(slime, login);
																	// 초기화
																	slime = resetMon;
																	login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																			, login.getUserScore(), login.getUserLv(), login.getUserExp()
																			, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																			, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																	// db에 반영
																	monsterService.updateMonster(slime);
																	userService.updateUser(login);
																	break outer;
																}
															}
														}else {
															System.out.println("도망갈지.. 잘못입력했습니다.. 다시 입력해주세요..");
														}
													}else if(login.getUserSpd() < slime.getSpd()){
														// 몬스터 공격후 유저
														// 몬스터 공격
														int monAttack = monsterService.attack(slime, login, myWeapon);
														// 시간 주기
														time(500);
														System.out.println(slime.getName() + "의 공격!!");
														// 시간 주기
														time(500);
														System.out.println(monAttack + "의 피해를 받았습니다!");
														// 시간 주기
														time(500);
														// 유저 hp가 0이하면 끝
														login = userService.loginUser(login.getUserId());
														if(login.getUserHp() <= 0) {
															monsterService.dieUser(slime, login);
															// 초기화
															slime = resetMon;
															login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																	, login.getUserScore(), login.getUserLv(), login.getUserExp()
																	, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																	, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
															// db에 반영
															monsterService.updateMonster(slime);
															userService.updateUser(login);
															break outer;
														}
														
														System.out.println("행동을 선택해주세요");
														System.out.println("1. 공격한다 | 2. 스킬사용 | 3. 도망간다");
														System.out.print(">>> ");
														int selBe = Integer.parseInt(scan.nextLine());
														if(selBe == 1) {
															// 공격함수 후 슬라임 공격!
															// 유저 공격
															int userAttack = monsterService.attack(login, slime, myWeapon);
															// 시간 주기
															time(500);
															System.out.println("나의 공격!!");
															// 시간 주기
															time(500);
															System.out.println(slime.getName() + "에게 " + userAttack + "의 피해를 입혔습니다!");
															// 시간 주기
															time(500);
															// 몬스터 hp가 0이하면 끝
															slime = monsterService.randomMonster(slime.getName());
															if(slime.getHp() <= 0) {
																monsterService.dieMon(slime, login);
																// 초기화
																slime = resetMon;
																login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																		, login.getUserScore(), login.getUserLv(), login.getUserExp()
																		, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																		, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																// db에 반영
																monsterService.updateMonster(slime);
																userService.updateUser(login);
																break;
															}
															
														}else if(selBe == 2) {
															System.out.println("구현 안됨..");
														}else if(selBe == 3) {
															int randInt = (int)(Math.ceil(Math.random() * 50));
															if(randInt <= 50) {
																// 시간 주기
																time(500);
																System.out.println("도망에 성공하셨습니다!");
																break;
															}else {
																// 시간 주기
																time(500);
																System.out.println("도망에 실패하셨습니다...");
															}
														}else {
															System.out.println("도망갈지.. 잘못입력했습니다.. 다시 입력해주세요..");
														}
														
													}else {
														System.out.println("행동을.. 잘못입력했습니다.. 다시 입력해주세요..");
													}
												}
												
											}else if(selField == 2) {
												System.out.println("스테이지 2");
												MonsterVO slime = monsterService.getMonsetrByName("파란 슬라임");
												// 슬라임의 초기값과 나의 초기값 저장해놓기
												// 전투가 끝난후 다시 초기화 시켜야하기 때문!
												MonsterVO resetMon = slime;
												UserVO resetUser = login;
												
												// 몬스터에 랜덤 인카운터 부여
												slime = monsterService.randomMonster(slime.getName());
												int maxHp = slime.getHp();
												int userMaxHp = login.getUserHp();
												monsterService.updateMonster(slime);
												
												while(true) {
													System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
													// 몬스터랑 hp 출력
													slime = monsterService.getMonsetrByName("파란 슬라임");
													monsterService.printMonsterByType(slime, maxHp);
													// 유저 hp 출력
													login = userService.loginUser(login.getUserId());
													monsterService.printHp(login, userMaxHp);
													// switch ? : 이거였나 그거로 구현 가능할듯
													// 지금은 시간이 없으니 if문으로
													if(login.getUserSpd() >= slime.getSpd()) {
														System.out.println("행동을 선택해주세요");
														System.out.println("1. 공격한다 | 2. 스킬사용 | 3. 도망간다");
														System.out.print(">>> ");
														int selBe = Integer.parseInt(scan.nextLine());
														if(selBe == 1) {
															// 공격함수 후 슬라임 공격!
															// 유저 공격
															int userAttack = monsterService.attack(login, slime, myWeapon);
															// 시간 주기
															time(500);
															System.out.println("나의 공격!!");
															// 시간 주기
															time(500);
															System.out.println(slime.getName() + "에게 " + userAttack + "의 피해를 입혔습니다!");
															// 시간 주기
															time(500);
															// 몬스터 hp가 0이하면 끝
															slime = monsterService.randomMonster(slime.getName());
															if(slime.getHp() <= 0) {
																monsterService.dieMon(slime, login);
																// 초기화
																slime = resetMon;
																login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																		, login.getUserScore(), login.getUserLv(), login.getUserExp()
																		, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																		, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																// db에 반영
																monsterService.updateMonster(slime);
																userService.updateUser(login);
																break;
															}
															// 몬스터 공격
															int monAttack = monsterService.attack(slime, login, myWeapon);
															// 시간 주기
															time(500);
															System.out.println(slime.getName() + "의 공격!!");
															// 시간 주기
															time(500);
															System.out.println(monAttack + "의 피해를 받았습니다!");
															// 시간 주기
															time(500);
															// 유저 hp가 0이하면 끝
															login = userService.loginUser(login.getUserId());
															if(login.getUserHp() <= 0) {
																monsterService.dieUser(slime, login);
																// 초기화
																slime = resetMon;
																login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																		, login.getUserScore(), login.getUserLv(), login.getUserExp()
																		, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																		, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																// db에 반영
																monsterService.updateMonster(slime);
																userService.updateUser(login);
																break outer;
															}
														}else if(selBe == 2) {
															System.out.println("구현 안됨..");
														}else if(selBe == 3) {
															int randInt = (int)(Math.ceil(Math.random() * 50));
															if(randInt <= 50) {
																// 시간 주기
																time(500);
																System.out.println("도망에 성공하셨습니다!");
																break;
															}else {
																// 시간 주기
																time(500);
																System.out.println("도망에 실패하셨습니다...");
																// 슬라임 공격!
																// 시간 주기
																time(500);
																int monAttack = monsterService.attack(slime, login, myWeapon);
																System.out.println(slime.getName() + "의 공격!!");
																// 시간 주기
																time(500);
																System.out.println(monAttack + "의 피해를 받았습니다!");
																// 시간 주기
																time(500);
																// 유저 hp가 0이하면 끝
																login = userService.loginUser(login.getUserId());
																if(login.getUserHp() <= 0) {
																	monsterService.dieUser(slime, login);
																	// 초기화
																	slime = resetMon;
																	login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																			, login.getUserScore(), login.getUserLv(), login.getUserExp()
																			, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																			, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																	// db에 반영
																	monsterService.updateMonster(slime);
																	userService.updateUser(login);
																	break outer;
																}
															}
														}else {
															System.out.println("도망갈지.. 잘못입력했습니다.. 다시 입력해주세요..");
														}
													}else if(login.getUserSpd() < slime.getSpd()){
														// 몬스터 공격후 유저
														// 몬스터 공격
														// 시간 주기
														time(500);
														int monAttack = monsterService.attack(slime, login, myWeapon);
														System.out.println(slime.getName() + "의 공격!!");
														// 시간 주기
														time(500);
														System.out.println(monAttack + "의 피해를 받았습니다!");
														// 시간 주기
														time(500);
														// 유저 hp가 0이하면 끝
														login = userService.loginUser(login.getUserId());
														if(login.getUserHp() <= 0) {
															monsterService.dieUser(slime, login);
															// 초기화
															slime = resetMon;
															login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																	, login.getUserScore(), login.getUserLv(), login.getUserExp()
																	, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																	, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
															// db에 반영
															monsterService.updateMonster(slime);
															userService.updateUser(login);
															break outer;
														}
														
														System.out.println("행동을 선택해주세요");
														System.out.println("1. 공격한다 | 2. 스킬사용 | 3. 도망간다");
														System.out.print(">>> ");
														int selBe = Integer.parseInt(scan.nextLine());
														if(selBe == 1) {
															// 공격함수 후 슬라임 공격!
															// 유저 공격
															// 시간 주기
															time(500);
															int userAttack = monsterService.attack(login, slime, myWeapon);
															System.out.println("나의 공격!!");
															// 시간 주기
															time(500);
															System.out.println(slime.getName() + "에게 " + userAttack + "의 피해를 입혔습니다!");
															// 시간 주기
															time(500);
															// 몬스터 hp가 0이하면 끝
															slime = monsterService.randomMonster(slime.getName());
															if(slime.getHp() <= 0) {
																monsterService.dieMon(slime, login);
																// 초기화
																slime = resetMon;
																login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																		, login.getUserScore(), login.getUserLv(), login.getUserExp()
																		, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																		, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																// db에 반영
																monsterService.updateMonster(slime);
																userService.updateUser(login);
																break;
															}
															
														}else if(selBe == 2) {
															System.out.println("구현 안됨..");
														}else if(selBe == 3) {
															int randInt = (int)(Math.ceil(Math.random() * 50));
															if(randInt <= 50) {
																// 시간 주기
																time(500);
																System.out.println("도망에 성공하셨습니다!");
																break;
															}else {
																// 시간 주기
																time(500);
																System.out.println("도망에 실패하셨습니다...");
															}
														}else {
															System.out.println("도망갈지.. 잘못입력했습니다.. 다시 입력해주세요..");
														}
														
													}else {
														System.out.println("행동을.. 잘못입력했습니다.. 다시 입력해주세요..");
													}
												}
												
												
												
												
											}else if(selField == 3) {
												System.out.println("스테이지 3");
												MonsterVO slime = monsterService.getMonsetrByName("빨간 슬라임");
												// 슬라임의 초기값과 나의 초기값 저장해놓기
												// 전투가 끝난후 다시 초기화 시켜야하기 때문!
												MonsterVO resetMon = slime;
												UserVO resetUser = login;
												
												// 몬스터에 랜덤 인카운터 부여
												slime = monsterService.randomMonster(slime.getName());
												int maxHp = slime.getHp();
												int userMaxHp = login.getUserHp();
												monsterService.updateMonster(slime);
												
												while(true) {
													System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
													// 몬스터랑 hp 출력
													slime = monsterService.getMonsetrByName("빨간 슬라임");
													monsterService.printMonsterByType(slime, maxHp);
													// 유저 hp 출력
													login = userService.loginUser(login.getUserId());
													monsterService.printHp(login, userMaxHp);
													// switch ? : 이거였나 그거로 구현 가능할듯
													// 지금은 시간이 없으니 if문으로
													if(login.getUserSpd() >= slime.getSpd()) {
														System.out.println("행동을 선택해주세요");
														System.out.println("1. 공격한다 | 2. 스킬사용 | 3. 도망간다");
														System.out.print(">>> ");
														int selBe = Integer.parseInt(scan.nextLine());
														if(selBe == 1) {
															// 공격함수 후 슬라임 공격!
															// 유저 공격
															int userAttack = monsterService.attack(login, slime, myWeapon);
															System.out.println("나의 공격!!");
															System.out.println(slime.getName() + "에게 " + userAttack + "의 피해를 입혔습니다!");
															// 몬스터 hp가 0이하면 끝
															slime = monsterService.randomMonster(slime.getName());
															if(slime.getHp() <= 0) {
																monsterService.dieMon(slime, login);
																// 초기화
																slime = resetMon;
																login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																		, login.getUserScore(), login.getUserLv(), login.getUserExp()
																		, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																		, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																// db에 반영
																monsterService.updateMonster(slime);
																userService.updateUser(login);
																break;
															}
															// 몬스터 공격
															int monAttack = monsterService.attack(slime, login, myWeapon);
															System.out.println(slime.getName() + "의 공격!!");
															System.out.println(monAttack + "의 피해를 받았습니다!");
															// 유저 hp가 0이하면 끝
															login = userService.loginUser(login.getUserId());
															if(login.getUserHp() <= 0) {
																monsterService.dieUser(slime, login);
																// 초기화
																slime = resetMon;
																login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																		, login.getUserScore(), login.getUserLv(), login.getUserExp()
																		, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																		, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																// db에 반영
																monsterService.updateMonster(slime);
																userService.updateUser(login);
																break outer;
															}
														}else if(selBe == 2) {
															System.out.println("구현 안됨..");
														}else if(selBe == 3) {
															int randInt = (int)(Math.ceil(Math.random() * 50));
															if(randInt <= 50) {
																System.out.println("도망에 성공하셨습니다!");
																break;
															}else {
																System.out.println("도망에 실패하셨습니다...");
																// 슬라임 공격!
																int monAttack = monsterService.attack(slime, login, myWeapon);
																System.out.println(slime.getName() + "의 공격!!");
																System.out.println(monAttack + "의 피해를 받았습니다!");
																// 유저 hp가 0이하면 끝
																login = userService.loginUser(login.getUserId());
																if(login.getUserHp() <= 0) {
																	monsterService.dieUser(slime, login);
																	// 초기화
																	slime = resetMon;
																	login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																			, login.getUserScore(), login.getUserLv(), login.getUserExp()
																			, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																			, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																	// db에 반영
																	monsterService.updateMonster(slime);
																	userService.updateUser(login);
																	break outer;
																}
															}
														}else {
															System.out.println("도망갈지.. 잘못입력했습니다.. 다시 입력해주세요..");
														}
													}else if(login.getUserSpd() < slime.getSpd()){
														// 몬스터 공격후 유저
														// 몬스터 공격
														int monAttack = monsterService.attack(slime, login, myWeapon);
														System.out.println(slime.getName() + "의 공격!!");
														System.out.println(monAttack + "의 피해를 받았습니다!");
														// 유저 hp가 0이하면 끝
														login = userService.loginUser(login.getUserId());
														if(login.getUserHp() <= 0) {
															monsterService.dieUser(slime, login);
															// 초기화
															slime = resetMon;
															login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																	, login.getUserScore(), login.getUserLv(), login.getUserExp()
																	, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																	, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
															// db에 반영
															monsterService.updateMonster(slime);
															userService.updateUser(login);
															break outer;
														}
														
														System.out.println("행동을 선택해주세요");
														System.out.println("1. 공격한다 | 2. 스킬사용 | 3. 도망간다");
														System.out.print(">>> ");
														int selBe = Integer.parseInt(scan.nextLine());
														if(selBe == 1) {
															// 공격함수 후 슬라임 공격!
															// 유저 공격
															int userAttack = monsterService.attack(login, slime, myWeapon);
															System.out.println("나의 공격!!");
															System.out.println(slime.getName() + "에게 " + userAttack + "의 피해를 입혔습니다!");
															// 몬스터 hp가 0이하면 끝
															slime = monsterService.randomMonster(slime.getName());
															if(slime.getHp() <= 0) {
																monsterService.dieMon(slime, login);
																// 초기화
																slime = resetMon;
																login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																		, login.getUserScore(), login.getUserLv(), login.getUserExp()
																		, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																		, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																// db에 반영
																monsterService.updateMonster(slime);
																userService.updateUser(login);
																break;
															}
															
														}else if(selBe == 2) {
															System.out.println("구현 안됨..");
														}else if(selBe == 3) {
															int randInt = (int)(Math.ceil(Math.random() * 50));
															if(randInt <= 50) {
																System.out.println("도망에 성공하셨습니다!");
																break;
															}else {
																System.out.println("도망에 실패하셨습니다...");
															}
														}else {
															System.out.println("도망갈지.. 잘못입력했습니다.. 다시 입력해주세요..");
														}
														
													}else {
														System.out.println("행동을.. 잘못입력했습니다.. 다시 입력해주세요..");
													}
												}
												
												
												
												
												
											}else if(selField == 4) {
												System.out.println("스테이지 4");
												MonsterVO slime = monsterService.getMonsetrByName("보스 슬라임");
												// 슬라임의 초기값과 나의 초기값 저장해놓기
												// 전투가 끝난후 다시 초기화 시켜야하기 때문!
												MonsterVO resetMon = slime;
												UserVO resetUser = login;
												
												// 몬스터에 랜덤 인카운터 부여
												slime = monsterService.randomMonster(slime.getName());
												int maxHp = slime.getHp();
												int userMaxHp = login.getUserHp();
												monsterService.updateMonster(slime);
												
												while(true) {
													System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
													// 몬스터랑 hp 출력
													slime = monsterService.getMonsetrByName("보스 슬라임");
													monsterService.printMonsterByType(slime, maxHp);
													// 유저 hp 출력
													login = userService.loginUser(login.getUserId());
													monsterService.printHp(login, userMaxHp);
													// switch ? : 이거였나 그거로 구현 가능할듯
													// 지금은 시간이 없으니 if문으로
													if(login.getUserSpd() >= slime.getSpd()) {
														System.out.println("행동을 선택해주세요");
														System.out.println("1. 공격한다 | 2. 스킬사용 | 3. 도망간다");
														System.out.print(">>> ");
														int selBe = Integer.parseInt(scan.nextLine());
														if(selBe == 1) {
															// 공격함수 후 슬라임 공격!
															// 유저 공격
															int userAttack = monsterService.attack(login, slime, myWeapon);
															System.out.println("나의 공격!!");
															System.out.println(slime.getName() + "에게 " + userAttack + "의 피해를 입혔습니다!");
															// 몬스터 hp가 0이하면 끝
															slime = monsterService.randomMonster(slime.getName());
															if(slime.getHp() <= 0) {
																monsterService.dieMon(slime, login);
																// 초기화
																slime = resetMon;
																login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																		, login.getUserScore(), login.getUserLv(), login.getUserExp()
																		, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																		, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																// db에 반영
																monsterService.updateMonster(slime);
																userService.updateUser(login);
																break;
															}
															// 몬스터 공격
															int monAttack = monsterService.attack(slime, login, myWeapon);
															System.out.println(slime.getName() + "의 공격!!");
															System.out.println(monAttack + "의 피해를 받았습니다!");
															// 유저 hp가 0이하면 끝
															login = userService.loginUser(login.getUserId());
															if(login.getUserHp() <= 0) {
																monsterService.dieUser(slime, login);
																// 초기화
																slime = resetMon;
																login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																		, login.getUserScore(), login.getUserLv(), login.getUserExp()
																		, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																		, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																// db에 반영
																monsterService.updateMonster(slime);
																userService.updateUser(login);
																break outer;
															}
														}else if(selBe == 2) {
															System.out.println("구현 안됨..");
														}else if(selBe == 3) {
															int randInt = (int)(Math.ceil(Math.random() * 50));
															if(randInt <= 50) {
																System.out.println("도망에 성공하셨습니다!");
																break;
															}else {
																System.out.println("도망에 실패하셨습니다...");
																// 슬라임 공격!
																int monAttack = monsterService.attack(slime, login, myWeapon);
																System.out.println(slime.getName() + "의 공격!!");
																System.out.println(monAttack + "의 피해를 받았습니다!");
																// 유저 hp가 0이하면 끝
																login = userService.loginUser(login.getUserId());
																if(login.getUserHp() <= 0) {
																	monsterService.dieUser(slime, login);
																	// 초기화
																	slime = resetMon;
																	login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																			, login.getUserScore(), login.getUserLv(), login.getUserExp()
																			, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																			, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																	// db에 반영
																	monsterService.updateMonster(slime);
																	userService.updateUser(login);
																	break outer;
																}
															}
														}else {
															System.out.println("도망갈지.. 잘못입력했습니다.. 다시 입력해주세요..");
														}
													}else if(login.getUserSpd() < slime.getSpd()){
														// 몬스터 공격후 유저
														// 몬스터 공격
														int monAttack = monsterService.attack(slime, login, myWeapon);
														System.out.println(slime.getName() + "의 공격!!");
														System.out.println(monAttack + "의 피해를 받았습니다!");
														// 유저 hp가 0이하면 끝
														login = userService.loginUser(login.getUserId());
														if(login.getUserHp() <= 0) {
															monsterService.dieUser(slime, login);
															// 초기화
															slime = resetMon;
															login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																	, login.getUserScore(), login.getUserLv(), login.getUserExp()
																	, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																	, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
															// db에 반영
															monsterService.updateMonster(slime);
															userService.updateUser(login);
															break outer;
														}
														
														System.out.println("행동을 선택해주세요");
														System.out.println("1. 공격한다 | 2. 스킬사용 | 3. 도망간다");
														System.out.print(">>> ");
														int selBe = Integer.parseInt(scan.nextLine());
														if(selBe == 1) {
															// 공격함수 후 슬라임 공격!
															// 유저 공격
															int userAttack = monsterService.attack(login, slime, myWeapon);
															System.out.println("나의 공격!!");
															System.out.println(slime.getName() + "에게 " + userAttack + "의 피해를 입혔습니다!");
															// 몬스터 hp가 0이하면 끝
															slime = monsterService.randomMonster(slime.getName());
															if(slime.getHp() <= 0) {
																monsterService.dieMon(slime, login);
																// 초기화
																slime = resetMon;
																login = new UserVO(login.getUserId(), login.getUserName(), login.getUserPassword()
																		, login.getUserScore(), login.getUserLv(), login.getUserExp()
																		, resetUser.getUserHp(), login.getUserStr(), login.getUserSpd()
																		, login.getUserBlk(), login.getUserMoney(), login.getUserWeapon());
																// db에 반영
																monsterService.updateMonster(slime);
																userService.updateUser(login);
																break;
															}
															
														}else if(selBe == 2) {
															System.out.println("구현 안됨..");
														}else if(selBe == 3) {
															int randInt = (int)(Math.ceil(Math.random() * 50));
															if(randInt <= 50) {
																System.out.println("도망에 성공하셨습니다!");
																break;
															}else {
																System.out.println("도망에 실패하셨습니다...");
															}
														}else {
															System.out.println("도망갈지.. 잘못입력했습니다.. 다시 입력해주세요..");
														}
														
													}else {
														System.out.println("행동을.. 잘못입력했습니다.. 다시 입력해주세요..");
													}
												}
												
												
											}else if(selField == 5) {
												System.out.println("슬라임 동굴을 나갑니다!");
												break;
											}else {
												System.out.println("잘못 입력했습니다.. 다시 입력해주세요!!");
											}
										}
										
										
									}else if(selField == 2) {
										
									}else if(selField == 3) {
										
									}else if(selField == 4) {
										
									}else if(selField == 5) {
										System.out.println("사냥을 종료합니다!");
										break;
									}else {
										System.out.println("잘못 입력했습니다..");
										System.out.println("다시 입력해주세요!!");
									}
									
									
									
								}
								
							}else if(command == 5) {
								ArrayList<UserVO> userList = userService.getUserList();
								for(int i = 0; i < userList.size(); i++) {
									UserWeaponVO userWeapon = userWeaponService.getWeaponById(userList.get(i));
									System.out.println(i+1 + "등 | 닉네임 : " + userList.get(i).getUserName() 
														   + " Lv : " + userList.get(i).getUserLv() + " 무기 : "
														   + userList.get(i).getUserWeapon() + " 등급 : " + userWeapon.getWeaponType()
														   + " 점수 : " + userList.get(i).getUserScore());
								}
							}else if(command == 6) {
								System.out.println("로그아웃 합니다!");
								System.out.println(login.getUserName() + "님 플레이 해주셔서 감사합니다");
								break;
							}else {
								System.out.println("잘못 입력하셨습니다!!");
								System.out.println("다시 입력해주세요..");
							}
							
							
							
							
						}
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					// 로그인 실패
					}else {
						System.out.println("비밀번호가 틀렸습니다!");
					}
						
				}else {
					System.out.println("존재하지 않는 아이디입니다!");
				}
				
				
			}else if (command == 2) {
				System.out.println("회원가입을 진행합니다.");
				System.out.print("아이디 : ");
				String inputId = scan.nextLine();
				while (inputId.length() == 0) {
					System.out.println("아무것도 입력하지 않으셨습니다..");
					System.out.print("아이디 : ");
					inputId = scan.nextLine();
				}
				System.out.print("비밀번호 : ");
				String inputPw = scan.nextLine();
				while (inputPw.length() == 0) {
					System.out.println("아무것도 입력하지 않으셨습니다..");
					System.out.print("비밀번호 : ");
					inputPw = scan.nextLine();
				}
				System.out.print("닉네임 : ");
				String inputName = scan.nextLine();
				while (inputName.length() == 0) {
					System.out.println("아무것도 입력하지 않으셨습니다..");
					System.out.print("닉네임 : ");
					inputName = scan.nextLine();
				}
				UserVO regist = new UserVO(inputId, inputName, inputPw, 0, 1, 0, 100, 1, 1, 1, 0, "없음");
				int cnt = userService.registUser(regist);
				
				if(cnt > 0) {
					System.out.println("회원가입에 성공하셨습니다!");
				}else {
					System.out.println("회원가입에 실패하셨습니다..");
				}
				
			}else if (command == 3) {
				System.out.println("게임을 종료하겠습니다.");
				cp.destroyPool();
				scan.close();
				break;
			}else {
				System.out.println("다시 입력하십시오.");
			}
			
			
		}
		
		
		
		
		
		
		
		
	} // main 끝
	
	public static void time(int second) {
		try {
			Thread.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
