package park_hyunggoo.submit05;

import java.util.Scanner;

public class Elevator02 {

	public static void main(String[] args) {
		
		
		// elevator01과 elevator02의 차이점
		// elevator01은 사용자 입력을 while문 다수를 사용해 코드가 불필요하게 길어짐
		// elevator02는 상위의 for문으로 빼서 코드를 한번만 작성했다.
		
		

		// 엘리베이터 구동 로직
		
		// 절대값은 Math.abs()

		// 엘리베이터가 두개가 있다.
		// 즉 변수는 2개 left(A) 엘리베이터, right(B) 엘리베이터

		// 사용자와 가까운 엘리베이터가 사용자의 값(X)과 치환

		// 하지만 만약, (A - X) = (B - X)가 같다면
		// A와 B값 중 큰 값이 내려온다.

		// 종료는 q, Q, exit, EXIT, Exit 중 하나를 입력

		// @. 사용자가 엘리베이터를 호출 후
		// 위 까지의 코드가 호출 코드
		// 이제 사용자가 탄 후에 가고 싶은 층을 입력!
		// 그럼 호출 됐던 A나 B가 사용자가 입력한 층으로 이동
		// 몇 층까지 있는지는 상관 x

		// 희영빌딩은 1 ~ 20층까지 있다고 가정

		int A = 10;
		int B = 4;
		Scanner scan = new Scanner(System.in);

		outer: while (true) {

			System.out.println("\n================== 희영빌딩 엘리베이터 ==================\n");
			System.out.println("승강기 A의 현재 위치: " + A + "층");
			System.out.println("승강기 B의 현재 위치: " + B + "층");
			System.out.print("몇층에 계시나요?[종료하시려면 q 또는 exit 입력]: ");
			String input = scan.nextLine();

			// input.equalsIgnoreCase("q") >> 대소문자를 무시하고 같은지 비 >> Q도 같다고 본다.
			if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("exit")) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
				
			} else {
				System.out.println(input + "층에서 엘리베이터를 호출합니다.");
				int intInput = Integer.parseInt(input);
				if (Math.abs(A - intInput) > Math.abs(B - intInput)) { // b가 더 가까울 때
					B = intInput;
					System.out.println("승강기 B가 " + B + "층으로 이동하였습니다.");
				} else if (Math.abs(A - intInput) < Math.abs(B - intInput)) { // a가 더 가까울 때
					A = intInput;
					System.out.println("승강기 A가 " + A + "층으로 이동하였습니다.");
				} else if (Math.abs(A - intInput) == Math.abs(B - intInput)) { // a와 b가 같은 거리에 있을 때
					if (A > B) { // A가 위층에 있을 때
						A = intInput;
						System.out.println("승강기 A가 " + A + "층으로 이동하였습니다.");
					} else if (B > A) { // B가 위층에 있을 때
						B = intInput;
						System.out.println("승강기 B가 " + B + "층으로 이동하였습니다.");
					} else {
						A = intInput;
						System.out.println("승강기 A가 " + A + "층으로 이동하였습니다.");
					}
				}
			}
			
			while (true) {
				int intInput = Integer.parseInt(input);
				if (intInput == A) {
					System.out.print("몇층으로 가시나요?: ");
					int inputFloor = Integer.parseInt(scan.nextLine());
					if (0 < inputFloor && inputFloor <= 20) {
						A = inputFloor;
						System.out.println("승강기가 " + A + "층으로 이동합니다!");
						break;
					} else {
						System.out.println("잘못 입력하셨습니다. 희영빌딩은 20층까지 있습니다.");
					}
					
				} else if (intInput == B) {
					System.out.print("몇층으로 가시나요?: ");
					int inputFloor = Integer.parseInt(scan.nextLine());
					if (0 < inputFloor && inputFloor <= 20) {
						B = inputFloor;
						System.out.println("승강기가 " + B + "층으로 이동합니다!");
						break;
					} else {
						System.out.println("잘못 입력하셨습니다. 희영빌딩은 20층까지 있습니다.");
					}
				}
			}

		}

	}

}
