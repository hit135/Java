package ch05_control;

public class LoopFor_반복문 {

	public static void main(String[] args) {
		
		// 반복문
		
		// for문
		// for(초기값; 조건문; 초기값에 줄 행동){반복되면서 할 행동}
		// for문은 반복문이다.
		// 여기서 "반복"이 중요하다.
		// 숫자값의 덧셈이 아니라
		// 행동을 더 하는 반복행동을 하는 기
		
		int Num = 10;
		for(int i = 1; i <= Num; i ++) {
			System.out.println(i);
		}
		
		// 내가 초기에 만든 for문
		// i = 1 이라는 초기값을 많이 줬는데
		// 문자열의 시작은 0부터이기 때문에
		// 보통 i = 0 이라는 초기값을 주는게 좋다고 생각한다.
		// 필요할 때만 i = 1 값을 주자.
		
		
		System.out.println("\n=============================================\n");
		
		// for문 + if문
		
		int bound = 40;
		int add = 0;
		for(int i = 1; i<= bound; i++) {	// i++ 형식을 많이 쓰긴 한다.
			if(i % 2 == 0) {
				add += i;
			}
		}
		System.out.println(add);
		
		System.out.println("\n=============================================\n");
		
		// for문이 유용한 이유
		// 앞서 각 자리수의 덧셈을 하려면
		// .substring 이나 charAt으로 식을 여러개를 만들어서 값을 구했다.
		// for문을 쓰면 깔끔하게 구할 수 있다.
		
		String example = "23234231231515";
		
		int addRst = 0;
		for(int i = 0; i < example.length(); i++ ) {
			String str = example.substring(i, i + 1);
			int temp = Integer.parseInt(str);
			addRst += temp;
		}
		System.out.println(addRst);
		
		System.out.println("\n=============================================\n");
		
		// break 문
		// break; 를 컴퓨터가 인식하는 순간
		// 반복문 종료
		
		// i가 1부터 10까지 증가하는 for문에서
		// i가 5보다 커지게 되는 순간 for문을 종료
		
		for(int i = 1; i <= 10; i++) {
			
			if(i > 5) {
				break;
			}System.out.println(i);
		}
		
		System.out.println("\n=============================================\n");
		
		// continue 문
		// continue가 달려있는 반복문에서는
		// continue 이하의 반복 행동(태그들)을 시행하지 않고
		// 다음 행동(for문)으로 넘어간다
		
		for(int i = 1; i <= 9; i ++) {
			
			if(i < 4) {
				// 컴퓨터가 실행 시
				// continue 아래 코드는 무시하고
				// 바로 다음 for문으로 진행한다.
				continue;
			}
			
			System.out.println("7 x " + i + " = " + (7 * i));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
