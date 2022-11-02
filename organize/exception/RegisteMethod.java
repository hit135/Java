package ch12_exception_git;

import java.util.regex.Pattern;

public class RegisteMethod {
	
	public static boolean idCheck(String p_id) throws MyException {
		boolean check = false;
		
		if(!Pattern.matches("^.*[0-9].*$", p_id)) {
			// 오류를 다른곳에서 처리하도록 던져준다
//			throw new MyException("숫자가 존재하지 않음!", "에러코드 001");
			// 에러코드는 보통 상수 클래스를 파서 주석을 달아준다!
			throw new MyException("숫자가 존재하지 않음!", ErrConstants.API_0001);
		}else if(!Pattern.matches("^.*[a-zA-Z].*$", p_id)) {
			throw new MyException("영어가 존재하지 않음!", ErrConstants.API_0002);
		}else if(!Pattern.matches("^.{0,8}$", p_id)) {
			throw new MyException("0자리 이상 8자리 이하이지 않음!", ErrConstants.API_0003);
		}else {
			System.out.println(p_id + "는 유효한 아이디 입니다!");
			return check = true;
		}
		
	}
	
	
	
	
	
	

}
