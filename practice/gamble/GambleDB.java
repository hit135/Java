package park_hyunggoo.submit13;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class GambleDB {
	
	// 싱글톤
	private GambleDB() {
		// ssr
		horseList.add(new Gamble("매지로 맥퀸", "SSR", 1));
		horseList.add(new Gamble("스페셜 위크", "SSR", 1));
		horseList.add(new Gamble("골드 쉽", "SSR", 3));
		horseList.add(new Gamble("사일런트 스즈카", "SSR", 0));
		horseList.add(new Gamble("토카이 테이오", "SSR", 2));
		horseList.add(new Gamble("에어 샤커", "SSR", 0));
		horseList.add(new Gamble("나리타 타이신", "SSR", 2));
		horseList.add(new Gamble("에이신 플래시", "SSR", 3));
		horseList.add(new Gamble("애스턴 마짱", "SSR", 0));
		horseList.add(new Gamble("사토노 크라운", "SSR", 1));
		
		// sr
		horseList.add(new Gamble("다이와 스칼렛", "SR", 2));
		horseList.add(new Gamble("보드카", "SR", 1));
		horseList.add(new Gamble("심볼리 루돌프", "SR", 1));
		horseList.add(new Gamble("마르젠스키", "SR", 0));
		horseList.add(new Gamble("그래스 윈더", "SR", 2));
		horseList.add(new Gamble("히시 아마존", "SR", 3));
		horseList.add(new Gamble("엘 콘도르 파사", "SR", 2));
		horseList.add(new Gamble("메이 그루브", "SR", 1));
		horseList.add(new Gamble("티엠 오페라 오", "SR", 1));
		horseList.add(new Gamble("나리타 브라이언", "SR", 2));
		
		// s
		horseList.add(new Gamble("타이키 셔틀", "S", 0));
		horseList.add(new Gamble("후지 키세키", "S", 2));
		horseList.add(new Gamble("나이스 네이처", "S", 1));
		horseList.add(new Gamble("트윈 터보", "S", 3));
		horseList.add(new Gamble("이쿠노 딕터스", "S", 0));
		horseList.add(new Gamble("마치카네 탄호이저", "S", 1));
		horseList.add(new Gamble("스마트 팔콘", "S", 2));
		horseList.add(new Gamble("미호노 부르봉", "S", 1));
		horseList.add(new Gamble("아이네스 후진", "S", 0));
		horseList.add(new Gamble("어드마이어 베가", "S", 3));
		
		// r
		horseList.add(new Gamble("위닝 티켓", "R", 2));
		horseList.add(new Gamble("라이스 샤워", "R", 1));
		horseList.add(new Gamble("마치카네 후루키타루", "R", 1));
		horseList.add(new Gamble("마야노 탑건", "R", 2));
		horseList.add(new Gamble("맨하탄 카페", "R", 3));
		horseList.add(new Gamble("슈퍼 크릭", "R", 1));
		horseList.add(new Gamble("비와 하야히데", "R", 0));
		horseList.add(new Gamble("나리타 브라이언", "R", 1));
		horseList.add(new Gamble("세이운 스카이", "R", 2));
		horseList.add(new Gamble("아그네스 타키온", "R", 3));
	}
	
	private static GambleDB instance = new GambleDB();
	
	public static GambleDB getInstance() {
		return instance;
	}
	
	// 배열 생성
	ArrayList<Gamble> horseList = new ArrayList<>();
	
	// 말 목록 출력
	public void showHorse() {
		for(Gamble hs : horseList) {
			System.out.println(hs);
		}
	}
	
	// 해당 등급의 랜덤 말 리턴
	public Gamble gradeHorse(String p_grade) {
		Collections.shuffle(horseList);
		Gamble temp = new Gamble();
		for(Gamble selectHorse : horseList) {
			if(selectHorse.getGrade() == p_grade) {
				temp = selectHorse;
				break;
			}
		}
		return temp;
	}
	
	// 해당 말을 배열에서 제거
	// 중복 방지!!!
	public void removeHorse(Gamble p_horse) {
		horseList.remove(p_horse);
	}
	
	// 확률에 의거해 말 출력 (스타팅 용)
	public Gamble startHorse() {
		int randInt = (int) Math.ceil( Math.random() * 1000 );
		if(randInt >= 1 && randInt < 6) {
			Gamble temp = gradeHorse("SSR");
			return temp;
		}else if(randInt >= 6 && randInt < 50) {
			Gamble temp = gradeHorse("SR");
			return temp;
		}else if(randInt >= 50 && randInt < 200) {
			Gamble temp = gradeHorse("S");
			return temp;
		}else {
			Gamble temp = gradeHorse("R");
			return temp;
		}
	}
	
	// 확률에 의거해 말 하나 뽑기
	public Gamble gambleHorse() {
		int randInt = (int) Math.ceil( Math.random() * 1000 );
		if(randInt >= 1 && randInt < 6) {
			Gamble temp = gradeHorse("SSR");
			removeHorse(temp);
			return temp;
		}else if(randInt >= 6 && randInt < 50) {
			Gamble temp = gradeHorse("SR");
			removeHorse(temp);
			return temp;
		}else if(randInt >= 50 && randInt < 200) {
			Gamble temp = gradeHorse("S");
			removeHorse(temp);
			return temp;
		}else {
			Gamble temp = gradeHorse("R");
			removeHorse(temp);
			return temp;
		}
	}
	
	// S, R 등급만 뽑기
	public Gamble beginHorse() {
		int randInt = (int) Math.ceil( Math.random() * 100 );
		if(randInt >= 1 && randInt < 65) {
			Gamble temp = gradeHorse("R");
			removeHorse(temp);
			return temp;
		}else{
			Gamble temp = gradeHorse("S");
			removeHorse(temp);
			return temp;
		}
	}
	// S와 SR 뽑기
	public Gamble expertHorse() {
		int randInt = (int) Math.ceil( Math.random() * 100 );
		if(randInt >= 1 && randInt < 50) {
			Gamble temp = gradeHorse("S");
			removeHorse(temp);
			return temp;
		}else{
			Gamble temp = gradeHorse("SR");
			removeHorse(temp);
			return temp;
		}
	}
	// SR과 SSR뽑기
	public Gamble finalHorse() {
		int randInt = (int) Math.ceil( Math.random() * 100 );
		if(randInt >= 1 && randInt < 50) {
			Gamble temp = gradeHorse("SR");
			removeHorse(temp);
			return temp;
		}else{
			Gamble temp = gradeHorse("SSR");
			removeHorse(temp);
			return temp;
		}
	}
	
	// 말들의 기본값
	String horseNow = "---ㅁ";
	int goal = 0;
	int randInt = 0;
	String front_Blk = "";
	String end_Blk = "";
	String end_Line = "|";
	int blank = 0;
	// 등급에 따라 경주마 달리는 로직
	// 말을 받으면 그 등급을 뽑아내서 달리자
	// 한번만 달리는 로직
	public void runHorse(Gamble horse){
		// 각 말의 거리
		String horseDis = horse.getDistance();
		front_Blk = "";
		end_Blk = "";
		blank = 0;
		
		if(horse.getGrade() == "SSR") {
			if(randInt < 75) {
				blank = horseDis.indexOf("ㅁ") - 1;
				for(int i = 0; i < blank; i++) {
					front_Blk += " ";
				}
				for(int i = 0; i < 99 - blank; i++) {
					end_Blk += " ";
				}
				horse.setDistance(front_Blk + horseNow + end_Blk + end_Line);
				System.out.println(horseDis);
				goal++;
			}else {
				System.out.println(horseDis);
			}
		}else if(horse.getGrade() == "SR") {
			if(randInt < 60) {
				blank = horseDis.indexOf("ㅁ") - 1;
				for(int i = 0; i < blank; i++) {
					front_Blk += " ";
				}
				for(int i = 0; i < 99 - blank; i++) {
					end_Blk += " ";
				}
				horse.setDistance(front_Blk + horseNow + end_Blk + end_Line);
				System.out.println(horseDis);
				goal++;
			}else {
				System.out.println(horseDis);
			}
		}else if(horse.getGrade() == "S") {
			if(randInt < 45) {
				blank = horseDis.indexOf("ㅁ") - 1;
				for(int i = 0; i < blank; i++) {
					front_Blk += " ";
				}
				for(int i = 0; i < 99 - blank; i++) {
					end_Blk += " ";
				}
				horse.setDistance(front_Blk + horseNow + end_Blk + end_Line);
				System.out.println(horseDis);
				goal++;
			}else {
				System.out.println(horseDis);
			}
		}else {
			if(randInt < 30) {
				blank = horseDis.indexOf("ㅁ") - 1;
				for(int i = 0; i < blank; i++) {
					front_Blk += " ";
				}
				for(int i = 0; i < 99 - blank; i++) {
					end_Blk += " ";
				}
				horse.setDistance(front_Blk + horseNow + end_Blk + end_Line);
				System.out.println(horseDis);
				goal++;
			}else {
				System.out.println(horseDis);
			}
		}
	}
	
	// 입력받은 말 리스트들 순서대로 달리기
	// 그리고 내 말의 등수 구하기
	public void runTeam(ArrayList<Gamble> p_list) throws InterruptedException {
		goal = 0;
 		outer:while(true) {
 			Thread.sleep(100);
 			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
 			System.out.println("===================================== 팀 정보 ===================================== \n");
			for(int i = 0; i < p_list.size(); i++) {
				System.out.println( (i+1) + "번팀 : " +p_list.get(i));
			}
 			System.out.println("\n===================================== 경마장 ===================================== \n");
			for(int i = 0; i < p_list.size(); i++) {
				randInt = (int) Math.ceil( Math.random() * 100 );
				randInt = runType(p_list.get(i), randInt);
				System.out.print( (i+1) + "번마 | " );
				runHorse(p_list.get(i));
				
				if(blank >= 100) {
					if(p_list.get(i).getDistance().indexOf("ㅁ") - 1 >= 100) {
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						System.out.println(
								"===================================== 팀 정보 ===================================== \n");
						for (int k = 0; k < p_list.size(); k++) {
							System.out.println((k + 1) + "번팀 : " + p_list.get(k));
						}
	 			System.out.println("\n===================================== 경마장 ===================================== \n");
						System.out.println( (i+1) + "번마 " + p_list.get(i) + "(이)가 우승했습니다!!!"  );
						break outer;
					}
				}
			}
		}
	}
	
	// 움직인 거리 구하기
	public int countDis (Gamble p_horse) {
		return p_horse.getDistance().indexOf("ㅁ");
	}
	
	// 말이 들어간 시간 구하기
	public int goalTime(Gamble p_horse) {
		int goalT = 0;
		while(true) {
			if(p_horse.getDistance().indexOf("ㅁ") - 1 >= 100) {
				goalT = nowTime();
				break;
			}
		}
		return goalT;
	}
	
	// 팀들 중 나의 등수 구하기 >> 나는 항상 배열의 인덱스 0번
	public int myRank (ArrayList<Gamble> p_list) {
		int rank = 0;
		// 내 말이 간 거리
		int myDis = countDis(p_list.get(0));
		ArrayList<Integer> rankHorse = new ArrayList<>();
		rankHorse.add(myDis);
		for(int i = 1; i < p_list.size(); i++) {
			int horseDis = countDis(p_list.get(i));
			rankHorse.add(horseDis);
		}
		// 배열에 말들거리 내림 차순 정리
		Collections.sort(rankHorse, Collections.reverseOrder());
		// 배열에 들어간 골인 시간 내림차순 정리
//		Collections.sort(rankHorse);
		// 배열로 돌려서 내 말의 등수 찾기
		for(int i = 0; i < rankHorse.size(); i++) {
			if(myDis == rankHorse.get(i)) {
				rank = (i + 1);
			}
		}
		return rank;
	}
	
	// 그랑프리 뛴 말들 다시 배열로 넣기
	public void inputHorse(ArrayList<Gamble> p_list) {
		for(int i = 1; i < p_list.size(); i++) {
			horseList.add(p_list.get(i));
		}
	}
	// 그랑프리 뛴 말들 거리 초기화
	public void resetDis(ArrayList<Gamble> p_list) {
		for(int i = 0; i < p_list.size(); i++) {
			p_list.get(i).setDistance("--ㅁ");
		}
	}
	
	
	
	// 경주 끝난 말들 중에서 맥스값으로 우승말 구하기
	// 리스트랑 max담기
	
	// 결승선에 우승말까지 구현
	
	// 다음 구현할 것들
	// 타입, 중복 x >> 구현
	
	// 타입
	// 랜드인트를 컨트롤
	// 도주(0) 타입 : 거리 60까지 - 15 이후 + 15
	// 선행(1) 타입 : 거리 30부터 60까지 - 10
	// 선입(2) 타입 : 거리 60부터 90까지 - 10
	// 추입(3) 타입 : 거리 70까지 + 15 70부터 - 20
	
	// 타입에 따른 달리는 유형 변화
	public int runType(Gamble p_horse , int p_num) {
		int nowHorse = p_horse.getDistance().indexOf("ㅁ");
		// 도주마
		if(p_horse.getType() == 0) {
			if(nowHorse < 50) {
				p_num -= 20;
			}else if(nowHorse >= 50) {
				p_num += 20;
			}
		}
		// 선행마
		if(p_horse.getType() == 1) {
			if(nowHorse >= 30 && nowHorse < 60) {
				p_num -= 10;
			}else {
				p_num += 10;
			}
		}
		// 선입마
		if(p_horse.getType() == 2) {
			if(nowHorse >= 60 && nowHorse < 90) {
				p_num -= 10;
			}else {
				p_num += 10;
			}
		}
		// 추입마
		if(p_horse.getType() == 3) {
			if(nowHorse < 50) {
				p_num += 10;
			}else if(nowHorse >= 50) {
				p_num -= 20;
			}
		}
		
		
		
		
		return p_num;
	}
	
	
	
	// 이제 구현할 것
	// step1 : 모든 팀에게 처음 시작시 400점을 준다
	// step2 : 3가지 선택지
	//			1. 뽑기 (비용 100p)
	//				R : 80%, S : 15%, SR : 4.5%, SSR : 0.5%;
	//			2. 강화 (비용 100p)
	//				등급 : 성공 | 2단승급 | 실패 | 터짐 
	//				R등급 : 45% | 5% | 50% | 0%
	//				S등급 : 29% | 1% | 60% | 10%
	//				SR등급 : 10% | 0| 70% | 20%
	//			3. 바로 경기로
	// step3 : 한번의 경기 승리시 200p 획득 >>> 먼저 1000p를 획득하는 팀이 우승
	
	// 이러면 팀 DB를 만들어야 하나..
	
	
	// 개인 1인 육성
	// Step 1 : 첫 시작시 10번 뽑기
	// 			그중에 골라서 시작!!!
	// Step 2 : 모든 턴은 5 turn >> 5 turn 까지 파이널 그랑프리 우승 (그랑프리는 비기너, 익스퍼트, 파이널)
	// Step 3 : 시작 행동 포인트 AP 4
	//			lvUp은 ap1
	//			강화는 ap3
	// Step 4 : 그랑프리 승리시 AP 3 획득
	//			그랑프리 패배시 AP 1 획득
	
	
	// 현재 LvUp만 구현
	
	// 강화
	// 그랑프리
	// 그랑프리 비기너 (4마리) : 우승시 3AP
	//					  		  2 ~ 3등 1AP
	// 그랑프리 익스퍼 (6마리) : 우승시 6AP
	//							  2 ~ 3등 4AP
	//							  5 ~ 6등 탈락
	// 그랑프리 파이널 (9마리) : 우승시 게임 클리어
	//							  2 ~ 3등 5AP
	//							  5 ~ 9등 탈락
	
	// 경마에서 내 등수 구현
	
	
	// 전부 구현함 이제 연속으로 그랑프리를 했을 때를 구현해야함
	// 그랑프리를 뛴 후 리스트에서 제거한 말들 추가
	// 그랑프리를 뛴 후 움직인 거리들 초기화
	
	// 이제 1등만 들어갔을 때가 아닌
	// 전체가 끝난 후 나의 등수를 알고 싶다
	
	// 현재 시간을 6자리 숫자로 출력
	public int nowTime() {
		int nowTime = 0;
		LocalTime now = LocalTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmmss");
		String formatNow = now.format(format);
		nowTime = Integer.parseInt(formatNow);
		return nowTime;
	}

}
