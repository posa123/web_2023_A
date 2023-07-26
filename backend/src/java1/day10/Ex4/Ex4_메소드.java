package java1.day10.Ex4;

import java.util.Scanner;

public class Ex4_메소드 {
	public static void main(String[] args) {
		// ------------------- 메소드 사용/호출 ------------------//
		// 1. 객체 필요!!!
		Member m = new Member();
		// 2. 객체내 .(도트연산자) 이용한 필드/메소드 호출
			// 1. 리턴x매개변수x 함수 호출
		m.singUp();
			// 2. 리턴x매개변수o 함수 호출
		// m.login("qwe", "1234"); // 오류 : 문자1개 정수1개 순서로 전달하는걸로 약속/선언했는데 문자2개주니까 거부/오류
		m.login("qwe", 1234);
			// 3. 리턴o매개변수x 함수 호출
		m.findId();
		// int result1 = m.findId();
		String result2 = m.findId();
			// 4. 리턴o매개변수o 함수 호출
		String[] result3 = m.findPw("qwe", "qwe");
			// 5. 가변길이
		m.delete("안녕","하세요");
		m.delete("안녕","하세요","!");
		
			// 6. 오버로딩
		m.delete( 1, "안녕" ,"하세요","!");
		
		
	}
}
