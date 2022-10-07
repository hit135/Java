package ch07_array;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;import sun.misc.BASE64Decoder;

public class EncryptionDecryption {

	public static void main(String[] args) {
		
		// 문자의 암호화와 복호화
		
		String[] passwordArr = {"이것은", "암호화", "복호화를", "위한", "배열", "입니다."};
		System.out.println(passwordArr);
		
		// 배열을 바로 프린트하면
		// [Ljava.lang.String;@2a139a55 이런식으로 출력된다.
		// 여기서 @ 앞은 해당 객채의 타입을 말하고
		// @ 뒤는 hashCode를 16진수를 나타내는 것이다.
		// 16진수 관련은 밑에!
		
		// 그럼 해쉬코드(hashCode)란?
		// 객체의 메모리 주소값(스택에서 받아오는 힙 안의 주소)
		// 을 이용해서 해쉬를 적용한 코드
		
		// 그렇다면 해쉬란?
		// 해쉬함수(암호의 알고리즘)를 이용해서
		// 데이터를 암호화하는 기법 중에 하나(RSA, SHA, base64 등...)
		
		// 그럼 암호화 복호화는 어떻게 할까?
		
		// 암호화 (Encryption)
		Encoder base64Encoder = Base64.getEncoder();	// Scanner scan 같은 받아오는 기능
		
		String password = "3q2t6w2";
		// 문자열을 바로 암호화 할 수 없으니 byte 배열로 변환
		byte[] pwByte = password.getBytes();
		String encryption = new String(base64Encoder.encode(pwByte));
		System.out.println(encryption);
		
		// 복호화 (Decryption)
		Decoder base64Decoder = Base64.getDecoder();	// 인코더처럼 디코더 불러오기
		String decryption = new String(base64Decoder.decode(encryption));
		System.out.println(decryption);
		
		
		System.out.println("\n=====================================================\n");
		
		
		// 2진수 10진수 16진수
		System.out.println(passwordArr.hashCode());
		System.out.println(Integer.toHexString(passwordArr.hashCode()));
		String hexPass = Integer.toHexString(passwordArr.hashCode());
		// 2진수로 변화 toBinaryString
		// 16진수로 변화 toHexString
		// 10진수로 변화는 Integer.parseInt(string, 16 or 2)
		System.out.println(Integer.parseInt(hexPass, 16));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
