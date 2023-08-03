package java1.day11.Ex5.view;

import java.util.Scanner;

import java1.day11.Ex5.controller.MemberController;

public class MainPage { // 입출력 담당하는 클래스
	// 0. 싱글톤 생성
		// 1. 현재 클래스로 static 객체 생성
	public static MainPage mainPage = new MainPage();
		// 2. 외부 객체에서 해당 싱글톤 호출하기 위한 메소드
	public static MainPage getInstance() { return mainPage; }
		// 3. 객체 외부에서 해당 클래스로 객체 생성 잠금 , 생성자를 private
	private MainPage() {}
	
	// 1. 필드
	private Scanner sc = new Scanner(System.in);
	// 2. 생성자
	// 3. 함수
	public void mainPage() {
		while(true) {
			
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");
			int ch = sc.nextInt(); 
			
			if( ch == 1 ) {singupPage();}
			else if( ch == 2 ) {loginPage();} 
			else if( ch == 3 ) { findIdPage();} 
			else if( ch == 4 ) { findPwPage();} 
			
		} // w e
	}
	void singupPage() {
		System.out.print("아이디 : "); 
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		// ---> 컨트롤러/서빙 에게 전달 // 컨트롤 클래스내 메소드 호출
		boolean result = MemberController.getInstance().singupLogic( id , password , name, phone ,age );
		if( result )System.out.println("안내)회원가입성공");
		else System.out.println("안내)회원가입실패");
	}
	void loginPage() {
		System.out.print("아이디 : ");	String id = sc.next();
		System.out.print("비밀번호 :");	String password = sc.next();
		boolean result =  MemberController.getInstance().loginLogic( id , password);
		if( result ) System.out.println("안내)로그인 성공했습니다.");
		else System.out.println("안내) 로그인 실패했습니다.");
	}
	void findIdPage() {}
	void findPwPage() {}
}
