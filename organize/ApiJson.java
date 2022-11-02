package ch11_java_api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiJson {

	@SuppressWarnings("unchecked")
	// 노란줄 안나오게 하는 명령어
	public static void main(String[] args) throws ParseException {
		
		// maven repository(구글검색)에서 웬만한 라이브러리를 다 받을 수 있다.
		// 프로젝트에 적용하기
		// 프로젝트에 마우스 우클릭 - Build Path
		// Configure Build Path 클릭 - libraries 탭
		// Add Jars 클릭 후 프로젝트 안의 driver(생성) 폴더를
		// 찾아 해당 .jar파일을 추가해준다.
		
		// 여기서 내가 사용할 유틸을 다른 프로젝트에 만든후
		// 그 프로젝트를 jar로 뽑은 다음
		// 여기 프로젝트에서 쓸 수 있음
		// >> 스스로 라이브러리를 만들어서 쓰는것!
		
		// JSON simple 라이브러리를 추가함
		
		// JSON 객체 만들기
		// Script에서 let jsonObject = {};와 같다
		JSONObject jsonObject = new JSONObject();
		
		// JSON 객체는 내부에 이름(항상 문자열)과 값(자유)의 쌍으로
		// 구성된 데이터를 가진다.
		// 즉 Key와 Value 쌍으로 데이터를 담는
		// HashMap과 유사하다.
		// HashMap<String, Object>라고 봐도 무방하다.
		// Script에서 jsonObject.name = "아이유";
		// Script에서 jsonObject["나이"] = 30;
		jsonObject.put("name", "아이유");
		jsonObject.put("나이", 30);
		
		
		// JSONArray배열
		// let jsonArray = [];
		JSONArray jsonArray = new JSONArray();
		jsonArray.add("좋은날");
		jsonArray.add("블루밍");
		jsonArray.add("미아");
		jsonArray.add("분홍신");
		jsonArray.add("레옹");
		jsonArray.add("밤편지");
		
		jsonObject.put("노래리스트", jsonArray);
		
		System.out.println(jsonObject);
		System.out.println(jsonObject.toString());
		System.out.println(jsonObject.toJSONString());
		
		System.out.println("\n==================================================================\n");
		
		JSONObject hyoshin = new JSONObject();
		
		hyoshin.put("name", "박효신");
		hyoshin.put("age", 41);
		
		JSONArray songArray = new JSONArray();
		songArray.add("야생화");
		songArray.add("눈의꽃");
		
		hyoshin.put("songList", songArray);
		System.out.println(hyoshin);
		
		jsonObject.put("박효신", hyoshin);
		System.out.println(jsonObject);
		
		System.out.println("\n==================================================================\n");
		
		// 중요한 것은 JSON 데이터가 왔을 때
		// 키값을 가지고 원하는 정보를 집어내는 것!
		
		String serverResult = "{\"노래리스트\":[\"좋은날\",\"블루밍\",\"미아\",\"분홍신\",\"레옹\",\"밤편지\"],\"박효신\":{\"노래리스트\":[\"야생화\",\"눈의꽃\"],\"name\":\"박효신\",\"age\":41},\"name\":\"아이유\",\"나이\":30}\n";
		System.out.println(serverResult);
		
		// JSON 파싱
		JSONParser jsonParser = new JSONParser();
		// 예외처리,, SDF와 timeThread와 Parser
		// 파싱하고 형변환 시켜줘야 한다.
		// 최상위 오브젝트라 관련 명령어가 없음
		JSONObject iuJson = (JSONObject)jsonParser.parse(serverResult);
		
		// 키를 이용해 값을 꺼내기
		System.out.println(iuJson.get("name"));
		// Object(최상위 클래스)로 리턴하기 때문에 형변환 시켜줘야 한다.
		String name = (String)iuJson.get("name");
		System.out.println(name);
		
		System.out.println(iuJson.get("나이"));
		long age = (long)iuJson.get("나이");
		System.out.println(age);
		
		JSONArray iuSongs = (JSONArray) iuJson.get("노래리스트");
		System.out.println(iuSongs);
		
		for(int i = 0; i< iuSongs.size(); i++) {
			System.out.println(iuSongs.get(i));
		}
		
		JSONObject iuHyoshin = (JSONObject) iuJson.get("박효신");
		System.out.println(iuHyoshin.get("name"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
