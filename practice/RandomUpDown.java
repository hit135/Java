package park_hyunggoo.submit05;

import java.util.Scanner;

public class RandomUpDown {

	public static void main(String[] args) {

		// 랜덤한 수 업, 다운
		// 1~50 사이의 랜덤한 수
		// 업, 다운
		// 단, 기회는 5번
		
		
		int ranNum = (int) (Math.random() * 50) + 1;
		System.out.println(ranNum);

		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			System.out.print("숫자를 입력해주세요 : ");
			int input = Integer.parseInt(scan.nextLine());
			
			if (i < 4) {
				if (input > ranNum) {
					System.out.println("다운!! 기회가 " + (4 - i) + "번 남았습니다.");
				} else if (input < ranNum) {
					System.out.println("업!! 기회가 " + (4 - i) + "번 남았습니다.");
				} else if (input == ranNum) {
					System.out.println("정답입니다.");
					break;
				}
			} else {
				System.out.println("실패하였습니다. 정답은 " + ranNum + "입니다.");
			}
		}
		
		
		
		
		
	}
}
