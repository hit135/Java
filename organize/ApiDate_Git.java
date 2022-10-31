package ch11_java_api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class apiDate_Git {

	public static void main(String[] args) throws ParseException {
		
	// 현재 시간 구하기 3가지 방법
		
		// 1. Date 클래스를 이용
		Date today = new Date();
		System.out.println(today);
		
		// 2. Calendar 클래스를 이용
		Calendar calToday = Calendar.getInstance();
		System.out.println(calToday.getTime());
		
		// 3. System을 이용
		// 1970년 1월 1일 09시 00분 부터의 밀리세컨드
		long nowTime = System.currentTimeMillis();
		System.out.println(nowTime);
		
		
	// 내가 원하는 날짜 타입 출력
		// SimpleDateFormat
		SimpleDateFormat sdf 
			= new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		System.out.println(sdf.format(today));
		System.out.println(sdf.format(calToday.getTime()));
		System.out.println(sdf.format(nowTime));
		
		
	// 문자열 -> Date
	// Date -> 문자열
		// SimpleDateFormat이 Date객체를 받아서 문자열로 만듬
		// 그렇다면 문자열을 Date로 어떻게 만들까?
		String someDate = "1993.10.14";
		sdf = new SimpleDateFormat("yyyy.MM.dd");
		// 타임쓰래드나 SimpleDateFormat.parse는 오류가 날 수 있으니 조심하라고
		// 이클립스에서 알려준다!
		Date someDay = sdf.parse(someDate);
		System.out.println(someDay);
		
		
	// Calendar -> Date
		// .getTime()을 하면 Date타입으로 변환
		calToday.getTime();
	// Date -> Calendar
		calToday.setTime(someDay);
		System.out.println(sdf.format(calToday.getTime()));
		
	// 특정 날짜 꺼내기
		// Calendar를 이용!
		int someYear = calToday.get(Calendar.YEAR);
		int someMonth = calToday.get(Calendar.MONTH);
		int someCalDate = calToday.get(Calendar.DATE);
		int someHour = calToday.get(Calendar.HOUR);
		int someMin = calToday.get(Calendar.MINUTE);
		System.out.println(someYear + "년 " + someMonth + "월 " + someCalDate + "일 " + someHour + "시 " + someMin + "분");
		
		
	// 날짜연산
		// toDay에서 someDay까지 며칠이나 지났나?
		// Calendar -> Date -> Mills
		// Mills로 바꿀때는 Date객체에 .getTime()
		long someMills = (calToday.getTime()).getTime();
		nowTime = System.currentTimeMillis();
		long afterSomeDay = nowTime - someMills;
		System.out.println(afterSomeDay);
		System.out.println(afterSomeDay / 1000 + "초 지남\n"
						 + afterSomeDay / (1000 * 60) + "분 지남\n"
						 + afterSomeDay / (1000 * 60 * 60) + "시간 지남\n"
						 + afterSomeDay / (1000 * 60 * 60 * 24) + "날 지남\n"
						 + afterSomeDay / (1000 * 60 * 60 * 24 * 365L) + "년 지남");
		// Long와 int의 함정에 빠지지 말자!
		
	// 디데이 구하기
		// 위의 날짜 연산에서 시간에 주의해서 구하면 된다!
		
		
	// 기준 날짜에 연산
		// 기준 날짜를 정하고 그 날짜에 더하거나 뺄때는
		// Calendar가 많이 편하다.
		// 1993.10.14에서 3년 65일후는?
		calToday.add(Calendar.DATE, 65);
		System.out.println(sdf.format(calToday.getTime()));
		calToday.add(Calendar.YEAR, 3);
		System.out.println(sdf.format(calToday.getTime()));
		// 1996. 12. 18에서 90일 전은?
		calToday.add(Calendar.DATE, -90);
		System.out.println(sdf.format(calToday.getTime()));
		
		
	// 달력만들기
		// 구하고자 하는 달력 날짜 세팅
		int year = 2022;
		int month = 9;
		Calendar newCalendar = Calendar.getInstance();
		newCalendar.set(year, month - 1, 1);
		// 여기서 주의!
		// Calendar.set을 할때 month는 0이 1월이다!!!
		System.out.println(newCalendar.getTime());
	// 시작 날 요일 찾기
		int startDay = newCalendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(startDay);
		// 1 : 일요일, 2 : 월요일, 3: 화요일, ... 7 : 토요일
		
	// 그 달의 끝나는 날 찾기
		int lastDay = newCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastDay);
		
		
		// 달력 그리기
		// 포문의 최대값은 42이다!
		// 왜냐? 달력의 틀을 가장 크게 맞들었을 때 6열 X 7행이므로
		
		System.out.println("\t\t" + year + "년 " + month + "월 달력!\n");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("===================================================");
		for(int i = 1; i <= 42; i++) {
			// for문은 일요일의 가장 첫번째 항목부터 시작...!
			if(i == lastDay + startDay) {
				break;
			}
			if(i < startDay) {
				System.out.print("\t");
			}else if(i >= startDay) {
				if(i % 7 == 0) {
					System.out.println((i - startDay) + 1 + "\n");
				}else if(i % 7 != 0) {
					System.out.print((i - startDay) + 1 + "\t" );
				}
			}
			
		}
	}

}
