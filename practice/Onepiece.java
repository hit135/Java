package ch15_inout;

import java.io.File;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;

public class Onepiece {

	public static void main(String[] args) {
		

		// 왜 금방 풀지 못했나..
		// 재귀함수로 포문이 파고파고 들어가도
		// 포문이 끝난다면 다음 반본을 실행한다는 구조를 바로 파악하지 못함
		// 포문이 들어갔다가 빠져나올 구조를 생각하다
		// 그 생각에 함몰됨

		
		// /home/pcXX/fire/Onepiece 폴더 안에 있는
		// 파일을 찾아 해당 파일명을 복호화
		// 총 6개를 다 찾으시고 읽어주시면 >> 파일 이름이 암호화
		// 복호화

		File onePiece = new File("/home/pc32/fire/Onepiece");
		
		String location = "/home/pc32/fire/Onepiece";
		
		ArrayList<String> result = new ArrayList<>();
		
		result = checkFolder(location, result);
		
		for(int i = 0; i < result.size(); i ++) {
			
			Decoder base64Decoder = Base64.getDecoder();
			String decryption = new String(base64Decoder.decode(result.get(i)));
			System.out.println(decryption);
		}
		
		
		
		
		
		
		
	} // main 끝
	
	// 파일 리스트가 들어왔을 때 그 안의 내용을 폴더임을 확임
	// true면 폴더 x / false 면 폴더
	static ArrayList<String> checkFolder(String location, ArrayList<String> result) {
		File temp = new File(location);
		File[] list = temp.listFiles();
		for(int i = 0; i < list.length; i++) {
			if(list[i].isDirectory()) {
				String locationUnder = location + "/" + i;
				checkFolder(locationUnder, result);
			}else {
				result.add(list[i].getName());
			}
		}
		return result;
	}
		
	
	// 모두가 폴더인 파일 리스트가 들어왔을 때
	// 폴더 안의 내용들이 폴더인지 확인해주는 함수

	
	

}
