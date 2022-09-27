package park_hyunggoo.submit01;

public class Assignment01 {

	public static void main(String[] args) {
		
		String name = "박형구";
		int age = 30;
		double height = 179.2;
		String phone = "010-4403-9382";
		String email = "hit135@naver.com";
		
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("키: " + height);
		System.out.println("연락처: " + phone);
		System.out.println("이메일: " + email);
		
		System.out.println("\n==========================================\n");
		
		String enigma = "너오구늘리뭐너먹구지리";
		
		String enigmaOne = enigma.replace("너", "");
		System.out.println(enigmaOne);
		
		String enigmaTwo = enigmaOne.replace("구", "");
		System.out.println(enigmaTwo);
		
		String enigmaThree = enigmaTwo.replace("리", "");
		System.out.println(enigmaThree);
		
		System.out.println("\n==========================================\n");
		
		int example = 278;
		
		String exampleStr = example + "";
		
		char exampleOneChar = exampleStr.charAt(0);
//		System.out.println(exampleOneChar);
		char exampleTwoChar = exampleStr.charAt(1);
//		System.out.println(exampleTwoChar);
		char exampleThreeChar = exampleStr.charAt(2);
//		System.out.println(exampleThreeChar);
		
		String exampleOneStr = exampleOneChar + "";
		String exampleTwoStr = exampleTwoChar + "";
		String exampleThreeStr = exampleThreeChar + "";
		
		int exampleOne = Integer.parseInt(exampleOneStr);
		int exampleTwo = Integer.parseInt(exampleTwoStr);
		int exampleThree = Integer.parseInt(exampleThreeStr);
		
		System.out.println(exampleOne + exampleTwo + exampleThree);


		
		
		
		

	}

}
