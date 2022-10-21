package review.gamble;

import java.util.ArrayList;
import java.util.Scanner;

public class GambleMain {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner scan = new Scanner(System.in);
		
		GambleDB horseList = GambleDB.getInstance();
		ArrayList<Integer> enterTeam = new ArrayList<>();
		ArrayList<Gamble> teamHorse = new ArrayList<>();
		
		Gamble testHorse = new Gamble("마치카네 후루키타루", "R", 1);
		
		// 랜덤 말 뽑는것 까지 구현함
		// 팀수에 따라 말 뽑기
		
		System.out.println("경마 게임에 참가하신 것을 환영합니다!");
		System.out.println("=======================================");
		System.out.println("경마를 시작하기에 앞서서");
		System.out.print("참가할 팀 수를 입력해주세요 ");
		System.out.print(">>> ");
		int teamNum = Integer.parseInt(scan.nextLine());
		// 참가하는 팀 DB를 만들어야 하나..
		for(int i = 0; i < teamNum; i++) {
			Thread.sleep(1000);
			enterTeam.add(i+1);
			System.out.println();
			System.out.println("총 " + teamNum + "팀이 게임에 참가합니다!");
			System.out.println(i+1 + "팀의 말 추첨을 시작합니다..");
			System.out.println();
			Gamble selectHorse = new Gamble();
			selectHorse = horseList.gambleHorse();
			teamHorse.add(selectHorse);
			System.out.println(""
					+ "   \\  :  /       \\  :  /       \\  :  /       \\  :  /       \\  :  /\n" + 
					"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
					"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
					"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
					" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
					"   /  |  \\       /  :  \\       /  :  \\       /  :  \\       /  |  \\\n" + 
					"                                                   \n" + 
					"                                              \n" + 
					"            " + enterTeam.get(i) + "팀의 말은                    \n" + 
					"    " + teamHorse.get(i) + "입니다!"    + "\n"  +
					"                                            \n" + 
					"                                               \n" + 
					"                                                     |\n" + 
					"   \\  |  /       \\  :  /       \\  :  /       \\  :  /       \\  |  /\n" + 
					"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
					"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
					"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
					" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
					"   /  :  \\       /  :  \\       /  :  \\       /  :  \\       /  :  \\");
			
		}
		
		// 입력받은 팀 마다 랜덤한 말을 뽑는 것 까지는 구현
		// 그럼 등급에 따라 차등하게 경주마가 달린다
		horseList.runTeam(teamHorse);
		
		
		
		
		
		
		
		
		
		
		
	}

}
