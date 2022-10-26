package park_hyunggoo.submit13;

import java.util.ArrayList;

public class MyCareer {
	
	GambleDB horseList = GambleDB.getInstance();
	
	// 캡슐화
	private int AP;
	private int Lv;
	private Gamble myHorse;
	
	// 생성자
	public MyCareer() {
		this(4, 0, new Gamble());
	}
	
	
	public MyCareer(int ap, int lv, Gamble myHorse) {
		AP = ap;
		Lv = lv;
		this.myHorse = myHorse;
	}

	// toString
	@Override
	public String toString() {
		return "나의 현재 상태 : Ap = " + AP + " | Lv = " + Lv + " | 나의 말 : " + myHorse;
	}

	// 레벨업 정보 표기
	public void fn_lvInfo(MyCareer myInfo) {
		int myLv = myInfo.getLv();
		if(myLv < 5) {
			System.out.println("\n나의 현재 Lv : " + myLv);
			System.out.println(
					" ........................................................\n" + 
					" :   ,-.      ,-.      ,-.      ,-.      ,-.      ,-.   :\n" + 
					" : _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_ :\n" + 
					" :(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _):\n" + 
					" :  / o \\    / o \\    / o \\    / o \\    / o \\    / o \\  :\n" + 
					" : (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_) :\n" + 
					" :   ,-.   ....................................   ,-.   :\n" + 
					" : _(*_*)_ :                                  : _(*_*)_ :\n" + 
					" :(_  o  _):     Lv 0 ~ 4의 레벨업 확률은    :(_  o  _):\n" + 
					" :  / o \\  :            80%입니다!            :  / o \\  :\n" + 
					" : (_/ \\_) :..................................: (_/ \\_) :\n" + 
					" :   ,-.      ,-.      ,-.      ,-.      ,-.      ,-.   :\n" + 
					" : _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_ :\n" + 
					" :(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _):\n" + 
					" :  / o \\    / o \\    / o \\    / o \\    / o \\    / o \\  :\n" + 
					" : (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_) :\n" + 
					" :......................................................:"
					);
			System.out.println("LvUp을 진행하시겠습니까?");
			System.out.print("1. 진행한다. | 2. 그만둔다 >>>> ");
		}else if(myLv >= 5 && myLv < 10) {
			System.out.println(
					" ........................................................\n" + 
					" :   ,-.      ,-.      ,-.      ,-.      ,-.      ,-.   :\n" + 
					" : _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_ :\n" + 
					" :(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _):\n" + 
					" :  / o \\    / o \\    / o \\    / o \\    / o \\    / o \\  :\n" + 
					" : (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_) :\n" + 
					" :   ,-.   ....................................   ,-.   :\n" + 
					" : _(*_*)_ :                                  : _(*_*)_ :\n" + 
					" :(_  o  _):     Lv 5 ~ 9의 레벨업 확률은    :(_  o  _):\n" + 
					" :  / o \\  :            65%입니다!            :  / o \\  :\n" + 
					" : (_/ \\_) :..................................: (_/ \\_) :\n" + 
					" :   ,-.      ,-.      ,-.      ,-.      ,-.      ,-.   :\n" + 
					" : _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_ :\n" + 
					" :(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _):\n" + 
					" :  / o \\    / o \\    / o \\    / o \\    / o \\    / o \\  :\n" + 
					" : (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_) :\n" + 
					" :......................................................:"
					);
			System.out.println("LvUp을 진행하시겠습니까?");
			System.out.print("1. 진행한다. | 2. 그만둔다 >>>> ");
		}else if(myLv >= 10 && myLv < 15) {
			System.out.println(
					" ........................................................\n" + 
					" :   ,-.      ,-.      ,-.      ,-.      ,-.      ,-.   :\n" + 
					" : _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_ :\n" + 
					" :(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _):\n" + 
					" :  / o \\    / o \\    / o \\    / o \\    / o \\    / o \\  :\n" + 
					" : (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_) :\n" + 
					" :   ,-.   ....................................   ,-.   :\n" + 
					" : _(*_*)_ :                                  : _(*_*)_ :\n" + 
					" :(_  o  _):     Lv 10 ~ 14의 레벨업 확률은  :(_  o  _):\n" + 
					" :  / o \\  :            50%입니다!            :  / o \\  :\n" + 
					" : (_/ \\_) :..................................: (_/ \\_) :\n" + 
					" :   ,-.      ,-.      ,-.      ,-.      ,-.      ,-.   :\n" + 
					" : _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_ :\n" + 
					" :(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _):\n" + 
					" :  / o \\    / o \\    / o \\    / o \\    / o \\    / o \\  :\n" + 
					" : (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_) :\n" + 
					" :......................................................:"
					);
			System.out.println("LvUp을 진행하시겠습니까?");
			System.out.print("1. 진행한다. | 2. 그만둔다 >>>> ");
		}else {
			System.out.println(
					" ........................................................\n" + 
					" :   ,-.      ,-.      ,-.      ,-.      ,-.      ,-.   :\n" + 
					" : _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_ :\n" + 
					" :(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _):\n" + 
					" :  / o \\    / o \\    / o \\    / o \\    / o \\    / o \\  :\n" + 
					" : (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_) :\n" + 
					" :   ,-.   ....................................   ,-.   :\n" + 
					" : _(*_*)_ :                                  : _(*_*)_ :\n" + 
					" :(_  o  _):     Lv 15 ~ 20의 레벨업 확률은  :(_  o  _):\n" + 
					" :  / o \\  :            30%입니다!            :  / o \\  :\n" + 
					" : (_/ \\_) :..................................: (_/ \\_) :\n" + 
					" :   ,-.      ,-.      ,-.      ,-.      ,-.      ,-.   :\n" + 
					" : _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_  _(*_*)_ :\n" + 
					" :(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _)(_  o  _):\n" + 
					" :  / o \\    / o \\    / o \\    / o \\    / o \\    / o \\  :\n" + 
					" : (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_)  (_/ \\_) :\n" + 
					" :......................................................:"
					);
			System.out.println("LvUp을 진행하시겠습니까?");
			System.out.print("1. 진행한다. | 2. 그만둔다 >>>> ");
		}
	}
	
	// 레벨업 함수
	public void fn_lvUp(MyCareer myInfo) {
		// 행동포인트 1감소
		// LV 0~4 는 80/20
		// LV 5~9 은 60/40
		// LV 10~14 는 40/60
		// LV 15~20 은 20/80
		int myLv = myInfo.getLv();
		int myAp = myInfo.getAp();
		if(myLv < 5) {
			int randInt = (int)(Math.ceil(Math.random() * 100));
			if(randInt <= 80) {
				myInfo.setLv(myLv + 1);
				myLv = myInfo.getLv();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("레벨업에 성공했습니다!");
				System.out.println("현재 레벨 : " + myLv);
				myInfo.setAp(myAp - 1);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}else {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("레벨업에 실패하셨습니다...");
				System.out.println("현재 레벨 : " + myLv);
				myInfo.setAp(myAp - 1);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
		}else if(myLv >= 5 && myLv < 10) {
			int randInt = (int)(Math.ceil(Math.random() * 100));
			if(randInt <= 65) {
				myInfo.setLv(myLv + 1);
				myLv = myInfo.getLv();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("레벨업에 성공했습니다!");
				System.out.println("현재 레벨 : " + myLv);
				myInfo.setAp(myAp - 1);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}else {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("레벨업에 실패하셨습니다...");
				System.out.println("현재 레벨 : " + myLv);
				myInfo.setAp(myAp - 1);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
		}else if(myLv >= 10 && myLv < 15) {
			int randInt = (int)(Math.ceil(Math.random() * 100));
			if(randInt <= 50) {
				myInfo.setLv(myLv + 1);
				myLv = myInfo.getLv();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("레벨업에 성공했습니다!");
				System.out.println("현재 레벨 : " + myLv);
				myInfo.setAp(myAp - 1);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}else {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("레벨업에 실패하셨습니다...");
				System.out.println("현재 레벨 : " + myLv);
				myInfo.setAp(myAp - 1);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
		}else if(myLv >= 15 && myLv < 20) {
			int randInt = (int)(Math.ceil(Math.random() * 100));
			if(randInt <= 30) {
				myInfo.setLv(myLv + 1);
				myLv = myInfo.getLv();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("레벨업에 성공했습니다!");
				System.out.println("현재 레벨 : " + myLv);
				myInfo.setAp(myAp - 1);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}else {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("레벨업에 실패하셨습니다...");
				System.out.println("현재 레벨 : " + myLv);
				myInfo.setAp(myAp - 1);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
		}else {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("최대 레벨에 도달했습니다!");
			System.out.println("현재 레벨 : " + myLv);
			System.out.println("남은 행동력 : " + myAp + "AP");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
	}
	
	// 강화 정보 표기
	//				등급 : 성공 | 2단승급 | 실패 | 터짐 
	//				R등급 : 45% | 5% | 50% | 0%
	//				S등급 : 29% | 1% | 60% | 10%
	//				SR등급: 20% | 0% | 60% | 20%
	public void fn_enforceInfo(MyCareer myInfo) {
		Gamble myHorseGrd = myInfo.getMyHorse();
		System.out.println("================================================");
		System.out.println("         강화 등급에 대한 정보입니다!");
		System.out.println("  등급 : 성공  | 2단 승급 | 실 패 | 등급 다운");
		System.out.println(" R등급 : 65(%) |    5(%)   | 30(%) |    0(%)   ");
		System.out.println(" S등급 : 49(%) |    1(%)   | 40(%) |   10(%)   ");
		System.out.println("SR등급 : 20(%) |    0(%)   | 60(%) |   20(%)   ");
		System.out.println("================================================");
		System.out.println("당신의 등급은" + myHorseGrd.getGrade() + "입니다.");
		System.out.println("강화를 계속 진행하시겠습니까?");
		System.out.print("1. 진행한다. | 2. 그만둔다 >>>> ");
	}
	
	
	// 강화 함수
	public void fn_Enforce(MyCareer myInfo) {
		int myAp = myInfo.getAp();
		Gamble myHorseGrd = myInfo.getMyHorse();
		int randInt = (int) Math.ceil( Math.random() * 100 );
		if(myHorseGrd.getGrade() == "R") {
			if(randInt <= 65) {
				myHorseGrd.setGrade("S");
				myHorseGrd = myInfo.getMyHorse();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("강화에 성공하셨습니다!");
				System.out.println("내 말의 등급은" + myHorseGrd + "입니다!");
				myInfo.setAp(myAp - 3);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}else if(randInt > 65 && randInt <= 70) {
				myHorseGrd.setGrade("SR");
				myHorseGrd = myInfo.getMyHorse();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("2단 강화에 성공하셨습니다!!!");
				System.out.println("내 말의 등급은" + myHorseGrd + "입니다!");
				myInfo.setAp(myAp - 3);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}else if(randInt > 70) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("강화에 실패하셨습니다...");
				System.out.println("내 말의 등급은" + myHorseGrd + "입니다!");
				myInfo.setAp(myAp - 3);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
			
		}else if(myHorseGrd.getGrade() == "S") {
			if(randInt <= 49) {
				myHorseGrd.setGrade("SR");
				myHorseGrd = myInfo.getMyHorse();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("강화에 성공하셨습니다!");
				System.out.println("내 말의 등급은" + myHorseGrd + "입니다!");
				myInfo.setAp(myAp - 3);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}else if(randInt > 49 && randInt <= 50) {
				myHorseGrd.setGrade("SSR");
				myHorseGrd = myInfo.getMyHorse();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("2단 강화에 성공하셨습니다!!!");
				System.out.println("내 말의 등급은" + myHorseGrd + "입니다!");
				myInfo.setAp(myAp - 3);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}else if(randInt > 50 && randInt <= 90) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("강화에 실패하셨습니다...");
				System.out.println("내 말의 등급은" + myHorseGrd + "입니다!");
				myInfo.setAp(myAp - 3);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}else if(randInt > 90) {
				myHorseGrd.setGrade("R");
				myHorseGrd = myInfo.getMyHorse();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("이런..");
				System.out.println("강화에 대실패하셨습니다...");
				System.out.println("내 말의 등급은" + myHorseGrd + "입니다!");
				myInfo.setAp(myAp - 3);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
			
		}else if(myHorseGrd.getGrade() == "SR") {
			if(randInt <= 20) {
				myHorseGrd.setGrade("SSR");
				myHorseGrd = myInfo.getMyHorse();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("축하합니다!!");
				System.out.println("최고 등급 강화에 성공합니다!!");
				System.out.println("내 말의 등급은" + myHorseGrd + "입니다!");
				myInfo.setAp(myAp - 3);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}else if(randInt > 20 && randInt <= 80) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("강화에 실패하셨습니다...");
				System.out.println("내 말의 등급은" + myHorseGrd + "입니다!");
				myInfo.setAp(myAp - 3);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}else if(randInt > 80) {
				myHorseGrd.setGrade("S");
				myHorseGrd = myInfo.getMyHorse();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("이런..");
				System.out.println("강화에 대실패하셨습니다...");
				System.out.println("내 말의 등급은" + myHorseGrd + "입니다!");
				myInfo.setAp(myAp - 3);
				myAp = myInfo.getAp();
				System.out.println("남은 행동력 : " + myAp + "AP");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
		}else if(myHorseGrd.getGrade() == "SSR") {
			System.out.println("내 말의 등급은 최대치 입니다!");
		}
	}
	
	// 비기너 참가 말들 추첨과 안내
	public ArrayList<Gamble> beginerHos(MyCareer myInfo) throws InterruptedException{
		ArrayList<Gamble> begin = new ArrayList<>();
		begin.add(myInfo.getMyHorse());
		System.out.println(""
				+ "   \\  :  /       \\  :  /       \\  :  /       \\  :  /       \\  :  /\n" + 
				"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
				"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
				"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
				" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
				"   /  |  \\       /  :  \\       /  :  \\       /  :  \\       /  |  \\\n" + 
				"                                                   \n" + 
				"                                              \n" + 
				"            " + 1 + "팀의 말은                    \n" + 
				"    " + begin.get(0) + "입니다!"    + "\n"  +
				"                                            \n" + 
				"                                               \n" + 
				"                                                     |\n" + 
				"   \\  |  /       \\  :  /       \\  :  /       \\  :  /       \\  |  /\n" + 
				"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
				"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
				"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
				" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
				"   /  :  \\       /  :  \\       /  :  \\       /  :  \\       /  :  \\");
		
		for(int i = 0; i < 3; i++) {
			Thread.sleep(700);
			begin.add(horseList.beginHorse());
			System.out.println(""
					+ "   \\  :  /       \\  :  /       \\  :  /       \\  :  /       \\  :  /\n" + 
					"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
					"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
					"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
					" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
					"   /  |  \\       /  :  \\       /  :  \\       /  :  \\       /  |  \\\n" + 
					"                                                   \n" + 
					"                                              \n" + 
					"            " + (i+2) + "팀의 말은                    \n" + 
					"    " + begin.get(i+1) + "입니다!"    + "\n"  +
					"                                            \n" + 
					"                                               \n" + 
					"                                                     |\n" + 
					"   \\  |  /       \\  :  /       \\  :  /       \\  :  /       \\  |  /\n" + 
					"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
					"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
					"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
					" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
					"   /  :  \\       /  :  \\       /  :  \\       /  :  \\       /  :  \\");
			Thread.sleep(1000);
		}
		return begin;
	}
	
	// 비기너 내 말의 등수에 따른 차등한 AP 분배
	public void beginRank(int rank, MyCareer myInfo) {
		int myAp = myInfo.getAp();
		if(rank == 1) {
			myInfo.setAp(myAp + 3);
			myAp = myInfo.getAp();
			System.out.println("비기너에서 우승하셔서 3AP를 획득합니다!");
			System.out.println("나의 남은 AP : " + myAp);
		}else if(rank == 2 || rank == 3) {
			myInfo.setAp(myAp + 1);
			myAp = myInfo.getAp();
			System.out.println("비기너에서 " + rank + "등 하셔서 1AP를 획득합니다!");
			System.out.println("나의 남은 AP : " + myAp);
		}else {
			System.out.println("이런..");
			System.out.println("꼴등하셔서 획득 AP는 없습니다..");
			System.out.println("나의 남은 AP : " + myAp);
		}
	}
	
	// 익스퍼트 참가 말들 추첨과 안내
	public ArrayList<Gamble> exHos(MyCareer myInfo) throws InterruptedException{
		ArrayList<Gamble> begin = new ArrayList<>();
		begin.add(myInfo.getMyHorse());
		System.out.println(""
				+ "   \\  :  /       \\  :  /       \\  :  /       \\  :  /       \\  :  /\n" + 
				"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
				"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
				"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
				" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
				"   /  |  \\       /  :  \\       /  :  \\       /  :  \\       /  |  \\\n" + 
				"                                                   \n" + 
				"                                              \n" + 
				"            " + 1 + "팀의 말은                    \n" + 
				"    " + begin.get(0) + "입니다!"    + "\n"  +
				"                                            \n" + 
				"                                               \n" + 
				"                                                     |\n" + 
				"   \\  |  /       \\  :  /       \\  :  /       \\  :  /       \\  |  /\n" + 
				"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
				"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
				"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
				" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
				"   /  :  \\       /  :  \\       /  :  \\       /  :  \\       /  :  \\");
		
		for(int i = 0; i < 5; i++) {
			Thread.sleep(700);
			begin.add(horseList.expertHorse());
			System.out.println(""
					+ "   \\  :  /       \\  :  /       \\  :  /       \\  :  /       \\  :  /\n" + 
					"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
					"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
					"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
					" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
					"   /  |  \\       /  :  \\       /  :  \\       /  :  \\       /  |  \\\n" + 
					"                                                   \n" + 
					"                                              \n" + 
					"            " + (i+2) + "팀의 말은                    \n" + 
					"    " + begin.get(i+1) + "입니다!"    + "\n"  +
					"                                            \n" + 
					"                                               \n" + 
					"                                                     |\n" + 
					"   \\  |  /       \\  :  /       \\  :  /       \\  :  /       \\  |  /\n" + 
					"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
					"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
					"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
					" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
					"   /  :  \\       /  :  \\       /  :  \\       /  :  \\       /  :  \\");
			Thread.sleep(1000);
		}
		return begin;
	}

	// 익스퍼트에서 내 말의 등수에 따른 차등한 AP 분배
	public void exRank(int rank, MyCareer myInfo) {
		int myAp = myInfo.getAp();
		if(rank == 1) {
			myInfo.setAp(myAp + 6);
			myAp = myInfo.getAp();
			System.out.println("익스퍼트에서 우승하셔서 6AP를 획득합니다!");
			System.out.println("나의 남은 AP : " + myAp);
		}else if(rank == 2 || rank == 3) {
			myInfo.setAp(myAp + 4);
			myAp = myInfo.getAp();
			System.out.println("익스퍼트에서 " + rank + "등 하셔서 4AP를 획득합니다!");
			System.out.println("나의 남은 AP : " + myAp);
		}else if(rank == 4) {
			System.out.println("파이널에서 " + rank + "등하셔서 포인트를 획득하지 못하셨습니다..");
			System.out.println("나의 남은 AP : " + myAp);
		}else {
			System.out.println("이런..");
			System.out.println("익스퍼트에서 " + rank + "등하셔서 게임이 종료됩니다..");
		}
	}
	
	// 파이널 참가 말들 추첨과 안내
	public ArrayList<Gamble> finalHos(MyCareer myInfo) throws InterruptedException{
		ArrayList<Gamble> begin = new ArrayList<>();
		begin.add(myInfo.getMyHorse());
		System.out.println(""
				+ "   \\  :  /       \\  :  /       \\  :  /       \\  :  /       \\  :  /\n" + 
				"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
				"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
				"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
				" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
				"   /  |  \\       /  :  \\       /  :  \\       /  :  \\       /  |  \\\n" + 
				"                                                   \n" + 
				"                                              \n" + 
				"            " + 1 + "팀의 말은                    \n" + 
				"    " + begin.get(0) + "입니다!"    + "\n"  +
				"                                            \n" + 
				"                                               \n" + 
				"                                                     |\n" + 
				"   \\  |  /       \\  :  /       \\  :  /       \\  :  /       \\  |  /\n" + 
				"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
				"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
				"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
				" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
				"   /  :  \\       /  :  \\       /  :  \\       /  :  \\       /  :  \\");
		
		for(int i = 0; i < 8; i++) {
			Thread.sleep(700);
			begin.add(horseList.finalHorse());
			System.out.println(""
					+ "   \\  :  /       \\  :  /       \\  :  /       \\  :  /       \\  :  /\n" + 
					"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
					"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
					"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
					" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
					"   /  |  \\       /  :  \\       /  :  \\       /  :  \\       /  |  \\\n" + 
					"                                                   \n" + 
					"                                              \n" + 
					"            " + (i+2) + "팀의 말은                    \n" + 
					"    " + begin.get(i+1) + "입니다!"    + "\n"  +
					"                                            \n" + 
					"                                               \n" + 
					"                                                     |\n" + 
					"   \\  |  /       \\  :  /       \\  :  /       \\  :  /       \\  |  /\n" + 
					"`. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .' `. __/ \\__ .'\n" + 
					"_ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _ _ _\\     /_ _\n" + 
					"   /_   _\\       /_   _\\       /_   _\\       /_   _\\       /_   _\\\n" + 
					" .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.   .'  \\ /  `.\n" + 
					"   /  :  \\       /  :  \\       /  :  \\       /  :  \\       /  :  \\");
			Thread.sleep(1000);
		}
		return begin;
	}
	
	// 파이널에서 AP 차등 분배와 탈락
	public void finalRank(int rank, MyCareer myInfo) {
		int myAp = myInfo.getAp();
		if(rank == 1) {
			System.out.println(
					"                     ,---.           ,---.\n" + 
					"                    / /\"`.\\.--\"\"\"--./,'\"\\ \\\n" + 
					"                    \\ \\    _       _    / /\n" + 
					"                     `./  / __   __ \\  \\,'\n" + 
					"                      /    /_O)_(_O\\    \\\n" + 
					"                      |  .-'  ___  `-.  |\n" + 
					"                   .--|       \\_/       |--.\n" + 
					"                 ,'    \\   \\   |   /   /    `.\n" + 
					"                /       `.  `--^--'  ,'       \\\n" + 
					"             .-\"\"\"\"\"-.    `--.___.--'     .-\"\"\"\"\"-.\n" + 
					".-----------/         \\------------------/         \\--------------.\n" + 
					"| .---------\\         /----------------- \\         /------------. |\n" + 
					"| |          `-`--`--'                    `--'--'-'             | |\n" + 
					"| |                                                             | |\n" + 
					"| |                                                             | |\n" + 
					"| |                                                             | |\n" + 
					"| |                                                             | |\n" + 
					"| |                        Final 우승 !                         | |\n" + 
					"| |                                                             | |\n" + 
					"| |                                                             | |\n" + 
					"| |                      Game Clear ! ! !                       | |\n" + 
					"| |                                                             | |\n" + 
					"| |                                                             | |\n" + 
					"| |                                                             | |\n" + 
					"| |                                                             | |\n" + 
					"| |_____________________________________________________________| |\n" + 
					"|_________________________________________________________________|\n" + 
					"                   )__________|__|__________(\n" + 
					"                  |            ||            |\n" + 
					"                  |____________||____________|\n" + 
					"                    ),-----.(      ),-----.(\n" + 
					"                  ,'   ==.   \\    /  .==    `.\n" + 
					"                 /            )  (            \\\n" + 
					"                 `==========='    `==========='"
					);
		}else if(rank == 2 || rank == 3) {
			myInfo.setAp(myAp + 5);
			myAp = myInfo.getAp();
			System.out.println("파이에서 " + rank + "등 하셔서 5AP를 획득합니다!");
			System.out.println("나의 남은 AP : " + myAp);
		}else if(rank >= 5) {
			System.out.println("이런..");
			System.out.println("파이널에서 " + rank + "등하셔서 게임이 종료됩니다..");
		}else {
			System.out.println("파이널에서 " + rank + "등하셔서 포인트를 획득하지 못하셨습니다..");
			System.out.println("나의 남은 AP : " + myAp);
		}
	}
	
	// getter setter
	public int getAp() {
		return AP;
	}


	public void setAp(int ap) {
		AP = ap;
	}


	public int getLv() {
		return Lv;
	}


	public void setLv(int lv) {
		Lv = lv;
	}


	public Gamble getMyHorse() {
		return myHorse;
	}


	public void setMyHorse(Gamble myHorse) {
		this.myHorse = myHorse;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
