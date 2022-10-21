package review.gamble;

import java.util.ArrayList;
import java.util.Collections;

public class GambleDB {
	
	// 싱글턴
	private GambleDB() {
		// ssr
		horseList.add(new Gamble("매지로 맥퀸", "SSR", 1));
		horseList.add(new Gamble("스페셜 위크", "SSR", 1));
		horseList.add(new Gamble("골드 쉽", "SSR", 3));
		horseList.add(new Gamble("사일런트 스즈카", "SSR", 0));
		horseList.add(new Gamble("토카이 테이오", "SSR", 2));
		
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
	
	
	// 확률에 의거해 말 하나 뽑기
	public Gamble gambleHorse() {
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
	
	// 말들의 기본값
	String ssr_horse = "ㅁ";
	String sr_horse = "ㅁ";
	String s_horse = "ㅁ";
	String r_horse = "ㅁ";
	String forword = "--";
	int goal = 0;
	int randInt = 0;
	// 등급에 따라 경주마 달리는 로직
	// 말을 받으면 그 등급을 뽑아내서 달리자
	// 한번만 달리는 로직
	public void runHorse(Gamble horse){
		// 각 말의 거리
		String horseDis = horse.getDistance();
		
		if(horse.getGrade() == "SSR") {
			if(randInt >= 1 && randInt < 90) {
				horse.setDistance(forword + horseDis);
				System.out.println(horseDis);
				goal++;
			}else {
				System.out.println(horseDis);
			}
		}else if(horse.getGrade() == "SR") {
			if(randInt >= 1 && randInt < 60) {
				horse.setDistance(forword + horseDis);
				System.out.println(horseDis);
				goal++;
			}else {
				System.out.println(horseDis);
			}
		}else if(horse.getGrade() == "S") {
			if(randInt >= 1 && randInt < 50) {
				horse.setDistance(forword + horseDis);
				System.out.println(horseDis);
				goal++;
			}else {
				System.out.println(horseDis);
			}
		}else {
			if(randInt >= 1 && randInt < 20) {
				horse.setDistance(forword + horseDis);
				System.out.println(horseDis);
				goal++;
			}else {
				System.out.println(horseDis);
			}
		}
	}
	
	// 입력받은 말 리스트들 순서대로 달리기
	public void runTeam(ArrayList<Gamble> p_list) throws InterruptedException {
		goal = 0;
 		outer:while(true) {
 			Thread.sleep(100);
 			System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
 							  +"\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
 			System.out.println("===================================== 팀 정보 ===================================== \n");
			for(int i = 0; i < p_list.size(); i++) {
				System.out.println( (i+1) + "번팀 : " +p_list.get(i));
			}
 			System.out.println("\n===================================== 경마장 ===================================== \n");
			for(int i = 0; i < p_list.size(); i++) {
				randInt = (int) Math.ceil( Math.random() * 100 );
				System.out.print( (i+1) + "번마 | " );
				runHorse(p_list.get(i));
			}
			if(goal > 100) {
				int max = 0;
				for(int i = 0; i < p_list.size() - 1; i++) {
					// 모든 p_list.get(i).getDistance()를 비교해 우승 출력
					if(countDis(p_list.get(i)) > countDis(p_list.get(i+1))) {
						max = countDis(p_list.get(i));
					}else if(countDis(p_list.get(i)) < countDis(p_list.get(i+1))) {
						max = countDis(p_list.get(i+1));
					}
				}
				
				break outer;
			}
		}
	}
	
	// 움직인 거리 구하기
	public int countDis (Gamble p_horse) {
		return p_horse.getDistance().length();
	}
	
	// 경주 끝난 말들 중에서 맥스값으로 우승말 구하기
	// 리스트랑 max담기
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
