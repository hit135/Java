package practice;

public class Racing {

	public static void main(String[] args) throws InterruptedException {

//		Thread.sleep(400);  // for문을 돌 때 0.4초  << 재밌는 기능

		// 1번마, 2번마, 3번마, 4번마가 있다.
		// 4마리 말은 랜덤으로 수가 증가한다.
		// 결승선에 한 말이라도 도달하면 끝!

		// 4마리 말에 랜덤값을 준다.
		// 랜덤값을 받았을 때 일정 수 이상이면 =를 출력

		// 여기서 한마리의 말이라도 =를 일정 수 이상 출력했다면
		// 모두 break


		// 일단 1번마부터 생각해보자

		String first = "";
		String second = "";
		String third = "";
		String fourth = "";

		outer: while (true) {
			
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("================== 경마장 ==================");
			
			int go = (int) (Math.random() * 12) + 1;

			if (1 <= go && go <= 3 ) {
				first += ">";
			} else {
			}
			System.out.println("1번마: " + first);


			if (4 <= go && go <= 6 ) {
				second += ">";
			} else {
			}
			System.out.println("2번마: " + second);


			if (7 <= go && go <= 9 ) {
				third += ">";
			} else {
			}
			System.out.println("3번마: " + third);
			

			if (10 <= go && go <= 12 ) {
				fourth += ">";
			} else {
			}
			System.out.println("4번마: " + fourth);

			if (first.length() >= 30) {
				System.out.print("1번마 승리");
				break outer;
			} else if (second.length() >= 30) {
				System.out.print("2번마 승리");
				break outer;
			} else if (third.length() >= 30) {
				System.out.print("3번마 승리");
				break outer;
			} else if (fourth.length() >= 30) {
				System.out.print("4번마 승리");
				break outer;
			}
			
			
			Thread.sleep(50);
			
			for(int i = 0; i< 10; i++) {
				System.out.println("\n");
			}

		}

	}

}
