package ch08_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayMap {

	public static void main(String[] args) {

		ArrayList<String> playList = new ArrayList<String>(Arrays.asList("INVU: 태연", "사랑은 늘 도망가: 임영웅", "취중고백: 멜로망스",
				"언제나 사랑해: 케이시", "듣고 싶을까: MSG워너비", "ELEVEN: IVE", "Step Back: GOT the beat", "abcdefu: GAYLE",
				"회전목마: sokodomo", "너, 너: 휘인", "SMILEY: YENA", "호랑수월가: 탑현", "리무진: 비오", "RUN2U: STAYC", "눈이 오잖아: 이무진",
				"Counting Stars: 비오", "신호등: 이무진", "어제처럼: 폴킴", "잊었니: 임영웅", "잊을 수 있을까: 노을", "HERO: 임영웅",
				"Can't Control Myself: 태연", "Next Level: aespa", "strawberry moon: 아이유", "겨울잠: 아이유", "끝사랑: 임영웅",
				"드라마: 아이유", "Bk Love: 임영웅", "만남은 쉽고 이별은 어려워: 베이식", "Weekend: 태연", "Savage: aespa", "Butter: 방탄소년단",
				"Dynamite: 방탄소년단", "OHAYO MY NIGHT: 디핵", "사랑인가 봐: 멜로망스", "라일락: 아이유", "Celebrity: 아이유", "낙하: 악동뮤지션",
				"Blueming: 아이유", "롤린: 브레이브걸스", "고백: 멜로망스", "그런 밤: 태연"));
		
		
		// 노래제목을 key, 가수명을 Value로
		// HashMap에 담아보세요
		
		HashMap<String, String> musicMap = new HashMap<>();
		
		for(int i = 0; i < playList.size(); i++) {
			String[] listSplit = playList.get(i).split(": ");
			musicMap.put(listSplit[0], listSplit[1]);
		}
		
		showPlayMap(musicMap);
		
		System.out.println("\n=============================== 검색 ===============================\n");
		
		// 노랙 검색할 때, 가수 검색할 때
		HashMap<String, String> searchMap = searchSong(musicMap, "사랑", "노래");
		showPlayMap(searchMap);
		
		searchMap = searchSong(musicMap, "영웅", "가수");
		showPlayMap(searchMap);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	// main 끝
	
	
	static HashMap<String, String> searchSong(HashMap<String, String> p_map
			, String keyword, String option){
		
		Set<String> keySet = p_map.keySet();
		HashMap<String, String> result = new HashMap<>();
		
		for(String key : keySet) {
			if(option.equals("노래")) {
				if(key.contains(keyword)) {
					result.put(key, p_map.get(key));
				}
			}else if(option.equals("가수")) {
				String val = p_map.get(key);
				if(val.contains(keyword)) {
					result.put(key, val);
				}
				
			}
			
			
		}
		return result;
	}
	
	
	
//	.contains안하고 .equals해서 틀림
//	static HashMap<String, String> searchSong(HashMap<String, String> p_map, String text, String type){
//		HashMap<String, String> result = new HashMap<>();
//		
//		Set<String> keySet = p_map.keySet();
//		
//		
//		if(type.equals("노래")) {	// p_map의 key에서만 검색
//			for(String key : keySet) {	// tempSet의 모든 key에 접근함
//				if(key.contains(text)) {
//					result.put(key, p_map.get(key));
//				}
//			}
//			
//		}else if(type.equals("가수")) {	 // p_map의 value에서만 검색
//			for(String key: keySet) {
//				if(p_map.get(key).contains(text)) {
//					result.put(key, p_map.get(key));
//				}
//			}
//			
//		}
//		
//		
//		return result;
//		
//	}
	
	
	
	
	
	/**
	 * 입력받은 Map을 페이징 처리
	 * 이때 각 항은 key: value로 표시된다.
	 * @param p_map
	 */
	static void showPlayMap(HashMap<String, String> p_map) {
		// 페이징 처리해서 출력
		Set<String> keySet = p_map.keySet();
		
		int count = 0;
		for(String key : keySet) {
			if(count % 10 == 0) {
				System.out.println("===" + ((count / 10) + 1) + " 페이지 ==================================================");
			}
			
			System.out.println(key + ": " + p_map.get(key));
			
			count++;
			
		}
		System.out.println(p_map);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
