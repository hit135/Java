package ch08_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PlayList {

	public static void main(String[] args) {
		// 자동 import 단축키 [Ctrl + Shift + o]
		ArrayList<String> playList = new ArrayList<String>(Arrays.asList("INVU: 태연", "사랑은 늘 도망가: 임영웅", "취중고백: 멜로망스",
				"언제나 사랑해: 케이시", "듣고 싶을까: MSG워너비", "ELEVEN: IVE", "Step Back: GOT the beat", "abcdefu: GAYLE",
				"회전목마: sokodomo", "너, 너: 휘인", "SMILEY: YENA", "호랑수월가: 탑현", "리무진: 비오", "RUN2U: STAYC", "눈이 오잖아: 이무진",
				"Counting Stars: 비오", "신호등: 이무진", "어제처럼: 폴킴", "잊었니: 임영웅", "잊을 수 있을까: 노을", "HERO: 임영웅",
				"Can't Control Myself: 태연", "Next Level: aespa", "strawberry moon: 아이유", "겨울잠: 아이유", "끝사랑: 임영웅",
				"드라마: 아이유", "Bk Love: 임영웅", "만남은 쉽고 이별은 어려워: 베이식", "Weekend: 태연", "Savage: aespa", "Butter: 방탄소년단",
				"Dynamite: 방탄소년단", "OHAYO MY NIGHT: 디핵", "사랑인가 봐: 멜로망스", "라일락: 아이유", "Celebrity: 아이유", "낙하: 악동뮤지션",
				"Blueming: 아이유", "롤린: 브레이브걸스", "고백: 멜로망스", "그런 밤: 태연"));

		System.out.println("몇개있지? " + playList.size());

		// 42개가 있는데
		// 페이징해서 보여주기
		// 단축키 [Ctrl + H]

		// 페이징 처리해서 출력
		showPlayList(playList);
		
		
		System.out.println("\n============================= 정렬 =============================\n");
		
		// String 타입의 경우 영어 'abc' 순 정렬 후 
		// 한글 '가나다' 순으로 정렬된다.
		// 오름차순
		Collections.sort(playList);
		showPlayList(playList);
		// 내림차
		Collections.sort(playList, Collections.reverseOrder());
		showPlayList(playList);
		
		System.out.println("\n============================= 검색 =============================\n");
		
		// 검색어를 입력받으면 playList에서 해당 검색어를
		// 포함하는 값만 따로 ArrayList에 담아서 리턴하는 메소드
		ArrayList<String> searchList = searchMusic(playList, "아이유");
		showPlayList(searchList);
		
		System.out.println("\n==========================================================\n");
		
		// 가수 검색
		searchList = searchMusic(playList, "I", "가수");
		showPlayList(searchList);
		
		// split로 나누면 되나?
		
		
		// 노래제목 검색
		searchList = searchMusic(playList, "I", "제목");
		showPlayList(searchList);
		
		
		
		

	} // main 끝
	
	/**
	 * ArrayList에서 keword 검색
	 * 가수와 제목 타입이 있음!
	 */
	static ArrayList<String> searchMusic(ArrayList<String> p_list, String keyword, String type) {
		ArrayList<String> result = new ArrayList<>();

		// playList를 for문으로 돌리면서 각각의 요소 중에
		// keyword를 포함하고 있는 요소를 result에 담기
		// 그런데, :을 기준으로 나누고
		// 타입이 가수면 왼쪽
		// 타입이 노래면 오른쪽

		for (int i = 0; i < p_list.size(); i++) {

			String[] splitRst = p_list.get(i).split(":");

			if (type.equals("가수")) {
				if (splitRst[1].contains(keyword)) {
					result.add(p_list.get(i));
				}
			}else if (type.equals("제목")) {
				if (splitRst[0].contains(keyword)) {
					result.add(p_list.get(i));
				}
			}
		}
		return result;
	}
	
	
	/**
	 * ArrayList에서 keword 검색
	 */
	static ArrayList<String> searchMusic(ArrayList<String> p_list, String keyword){
		ArrayList<String> result = new ArrayList<>();
		
		// playList를 for문으로 돌리면서 각각의 요소 중에
		// keyword를 포함하고 있는 요소를 result에 담기
		
		for(int i = 0; i < p_list.size(); i++) {
			if(p_list.get(i).contains(keyword)) {
				result.add(p_list.get(i));
			}
		}
		return result;
	}
	
	/**
	 * 게시판 페이징 구현
	 */
	static void showPlayList(ArrayList<String> p_list) {
		// 게시판 페이징 구현
		int totalCountMusic = p_list.size(); // 총 음악 개수
		int showCountOnePage = 10; // 한 페이지에 노출될 음악의 수

		// 총 페이지 수
		// 42 / 10 = 4.2 >> 올림처리 해야지 5 >> Math.ceil은 올림처 더블로 리턴한다.
//				double countPage =Math.ceil((double) totalCountGul / showCountOnePage);
		int countPage = (int) (Math.ceil((double) totalCountMusic / showCountOnePage));

		// 마지막 페이지에 있는 글의 수
		// = 42를 10으로 나눈 나머지
		int countLastPageMusic = totalCountMusic % showCountOnePage;

		// 10개 출력 후 줄긋기(1페이지), 그 다음 10개 출력 후 줄긋기(2페이지) .... 5페이지 끝까지

		// 나의 풀

//				System.out.println((int)Math.ceil(5 / 10.0) * 10);
//				
//				for(int i = 1; i <= playList.size(); i++) {
//					if((int)Math.floor(i / 10.0) * 10 < i && i < (int)Math.ceil(i / 10.0) * 10 ) {
//						System.out.println(i + ". " + playList.get(i-1));
//					}
//					else if(i % showCountOnePage == 0) {
//						System.out.println(i + ". " + playList.get(i-1));
//						System.out.println("===========================================================");
//					}
//				}
//				

		// 선생님

		for (int i = 0; i < countPage; i++) {
			System.out.println(i + 1 + " 페이지");

			// i = 0 일때 1페이지이고, playList 0~9까지 출력
			// i = 1 일때 2페이지이고, playList 10~19까지 출력
			// i = 2 일때 3페이지이고, playList 20~29까지 출력
			// i = 3 일때 4페이지이고, playList 30~39까지 출력
			// i = 4 일때 5페이지이고, playList 40~ 나머지까지 출력

			int start = i * showCountOnePage;
			int end = (i + 1) * showCountOnePage;

			// countPage - 1은 마지막 페이지!!
			if (i == countPage - 1) {
				end = totalCountMusic;
			}

			for (int k = start; k < end; k++) {
				System.out.println(p_list.get(k));
			}

			System.out.println("=======================================");

		}

	}
	
	
	
	
	
	
	
	

}
