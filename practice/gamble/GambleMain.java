package park_hyunggoo.submit13;

import java.util.ArrayList;
import java.util.Scanner;

public class GambleMain {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner scan = new Scanner(System.in);
		
		GambleDB horseList = GambleDB.getInstance();
		ArrayList<Integer> enterTeam = new ArrayList<>();
		ArrayList<Gamble> starting = new ArrayList<>();
		MyCareer myInfo = new MyCareer();
		
		Gamble testHorse = new Gamble("마치카네 후루키타루", "R", 1);
		
		int turn = 7;
		
		// 랜덤 말 뽑는것 까지 구현함
		// 팀수에 따라 말 뽑기
		
		System.out.println("경마 게임에 참가하신 것을 환영합니다!");
		System.out.println("=======================================");
		System.out.println("게임을 시작하기에 앞서서 나의 스타팅 말을 뽑겠습니다.");
		System.out.println("스타팅 말은 총 10번을 뽑아서 한마리 말만 데리고 갈 수 있습니다!");
		System.out.println("게임 끝날 때까지 함께하는 말이니 신중하게 골라주십시오!");
		System.out.println("\n ======================= 스타팅 말 목록 ======================= \n");
		for(int i = 0; i < 10; i ++) {
			Thread.sleep(1000);
			Gamble start = horseList.startHorse();
			starting.add(start);
			System.out.println( (i+1) + "번 말 : " + start );
		}
		System.out.println("게임을 함께 할 말 번호를 입력해주세요!");
		System.out.print(">>>> ");
		int strNum = Integer.parseInt(scan.nextLine()) -1;
		System.out.println(starting.get(strNum) + "을 선택하셨습니다!");
		myInfo.setMyHorse(starting.get(strNum));
		// 내가 선택한 말 DB에서 제거
		horseList.removeHorse(starting.get(strNum));
		outer:while(true) {
			if(turn == 0) {
				System.out.println("모든 턴을 소비하셔서 겜을 종료합니다..!");
				break;
			}
			System.out.println(
					"  (¯`·.¸¸.·´¯`·.¸¸.·´¯)\n" + 
					"  ( \\                 / )\n" + 
					" ( \\ )               ( / )\n" + 
					"( ) (   남은 턴 : " + turn +"  ) ( )\n" + 
					" ( / )               ( \\ )\n" + 
					"  ( /                 \\ )\n" + 
					"   (_.·´¯`·.¸¸.·´¯`·.¸_)");
			System.out.println("행동을 선택해 주십시오!");
			System.out.println("1. 내 정보 확인 | 2. 강화(3AP) | 3. 레벨업(1AP) | 4. 그랑프리로..");
			System.out.print(">>>>> ");
			int beNum = Integer.parseInt(scan.nextLine());
			if(beNum == 1) {
				System.out.println(myInfo + "\n");
			}else if(beNum == 2) {
				while(true) {
					if(myInfo.getAp() >= 3) {
						myInfo.fn_enforceInfo(myInfo);
						int beEnforce = Integer.parseInt(scan.nextLine());
						if (beEnforce == 1) {
							System.out.println("강화를 진행합니다!!");
							myInfo.fn_Enforce(myInfo);
						} else if (beEnforce == 2) {
							System.out.println("강화를 그만둡니다!\n");
							break;
						} else {
							System.out.println("잘못 입력하셨습니다! 다시 입력해주세요!\n");
						}
					}else {
						System.out.println("행동포인트(AP)가 부족합니다!!");
						System.out.println("다른 행동을 선택해주세요!!\n");
						break;
					}
				}
			}else if(beNum == 3) {
				// Lv Up
				while (true) {
					if (myInfo.getAp() >= 1) {
						myInfo.fn_lvInfo(myInfo);
						int beLvUp = Integer.parseInt(scan.nextLine());
						if (beLvUp == 1) {
							System.out.println("레벨업을 진행합니다!!");
							myInfo.fn_lvUp(myInfo);

						} else if (beLvUp == 2) {
							System.out.println("레벨업을 그만둡니다!\n");
							break;
						} else {
							System.out.println("잘못 입력하셨습니다! 다시 입력해주세요!\n");
						}
					}else {
						System.out.println("행동포인트(AP)가 부족합니다!!");
						System.out.println("다른 행동을 선택해주세요!!\n");
						break;
					}
				}
				
			}else if(beNum == 4) {
				System.out.println(
						"   _.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._\n" + 
						".-'---      - ---     --     ---   -----   - --       ----  ----   -     ---`-.\n" + 
						" )                                                                           (\n" + 
						"(                                                                             )\n" + 
						" )                                                                           (\n" + 
						"(                                                                             )\n" + 
						" )    # 비기너              # 익스퍼트               # 파이널               (\n" + 
						"(     ~ 참가말 : 4마리      ~ 참가말 : 6마리         ~ 참가말 : 9마리       )\n" + 
						" )    ~ 상금                 ~ 상금                    ~ 상금               (\n" + 
						"(       우승   : 3AP           우승     : 6AP            우승    : GameClear )\n" + 
						" )      2 ~ 3등 : 1AP          2 ~ 3등  : 4AP            2 ~ 3등  : 5AP      (\n" + 
						"(                              5등 이하 : GameOver      5등 이하 : GameOver  )\n" + 
						" )                                                                           (\n" + 
						"(                                                                             )\n" + 
						" )                                                                           (\n" + 
						"(___       _       _       _       _       _       _       _       _       ___)\n" + 
						"    `-._.-' (___ _) `-._.-' `-._.-' )     ( `-._.-' `-._.-' (__ _ ) `-._.-'\n" + 
						"            ( _ __)                (_     _)                (_ ___)\n" + 
						"            (__  _)                 `-._.-'                 (___ _)\n" + 
						"            `-._.-'                                         `-._.-'");
				System.out.println("참가할 그랑프리를 선택해주세요!");
				System.out.println("1. 비기너 | 2. 익스퍼트 | 3. 파이널");
				System.out.print(">>>>> ");
				int grang = Integer.parseInt(scan.nextLine());
				if(grang == 1) {
					// 비기너 리스트
					ArrayList<Gamble> beginer = new ArrayList<>();
					// 말 추가
					beginer = myInfo.beginerHos(myInfo);
					// 말 달리기
					horseList.runTeam(beginer);
					// 내 말의 등수 구하기
					int myRank = horseList.myRank(beginer);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("         내 말의 등수는 " + myRank + "등입니다!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					// 내 말의 등수에 따라 차등한 AP 지급
					myInfo.beginRank(myRank, myInfo);
					// 그랑프리 뛴 말들 초기화
					horseList.resetDis(beginer);
					horseList.inputHorse(beginer);
					// 턴 감소
					turn --;
				}else if(grang == 2) {
					ArrayList<Gamble> expert = new ArrayList<>();
					expert = myInfo.exHos(myInfo);
					horseList.runTeam(expert);
					// 내 말의 등수 구하기
					int myRank = horseList.myRank(expert);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("         내 말의 등수는 " + myRank + "등입니다!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					myInfo.exRank(myRank, myInfo);
					horseList.resetDis(expert);
					horseList.inputHorse(expert);
					turn --;
					if(myRank == 5 || myRank == 6) {
						System.out.println("고생하셨습니다..");
						break outer;
					}
				}else if(grang == 3) {
					ArrayList<Gamble> finalG = new ArrayList<>();
					finalG = myInfo.finalHos(myInfo);
					horseList.runTeam(finalG);
					// 내 말의 등수 구하기
					int myRank = horseList.myRank(finalG);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("         내 말의 등수는 " + myRank + "등입니다!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					myInfo.finalRank(myRank, myInfo);
					horseList.resetDis(finalG);
					horseList.inputHorse(finalG);
					turn--;
					if(myRank >= 5) {
						System.out.println("고생하셨습니다..");
						break outer;
					}
					
				}else {
					System.out.println("잘못입력하셨습니다! 다시 입력해주세요!");
				}
				
			}else {
				System.out.println("잘못 입력하셨습니다!");
				System.out.println("다시 입력해주세요!!");
			}
			
			
		}
		
		
		
		
//		System.out.print(">>> ");
//		int teamNum = Integer.parseInt(scan.nextLine());
//		// 참가하는 팀 DB를 만들어야 하나..
//		for(int i = 0; i < teamNum; i++) {
//			Thread.sleep(1000);
//			enterTeam.add(i+1);
//			System.out.println();
//			System.out.println("총 " + teamNum + "팀이 게임에 참가합니다!");
//			System.out.println(i+1 + "팀의 말 추첨을 시작합니다..");
//			System.out.println();
//			Gamble selectHorse = new Gamble();
//			selectHorse = horseList.gambleHorse();
//			teamHorse.add(selectHorse);
//			System.out.println(""
//					+ "   \\  :  /       \\  :  /       \\  :  /       \\  :  /       \\  :  /\n" + 
//					"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
//					"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
//					"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
//					" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
//					"   /  |  \\       /  :  \\       /  :  \\       /  :  \\       /  |  \\\n" + 
//					"                                                   \n" + 
//					"                                              \n" + 
//					"            " + enterTeam.get(i) + "팀의 말은                    \n" + 
//					"    " + teamHorse.get(i) + "입니다!"    + "\n"  +
//					"                                            \n" + 
//					"                                               \n" + 
//					"                                                     |\n" + 
//					"   \\  |  /       \\  :  /       \\  :  /       \\  :  /       \\  |  /\n" + 
//					"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
//					"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
//					"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
//					" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
//					"   /  :  \\       /  :  \\       /  :  \\       /  :  \\       /  :  \\");
//			
//		}
		
		// 입력받은 팀 마다 랜덤한 말을 뽑는 것 까지는 구현
		// 그럼 등급에 따라 차등하게 경주마가 달린다
		
//		horseList.runTeam(teamHorse);
		
		
		
		
		
		
		
		
		
		
		
	}

}
