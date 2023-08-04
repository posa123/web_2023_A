package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;

public class MainPage {
	private static MainPage mainPage = new MainPage();
	public static MainPage getInstance() {return mainPage; }
	private MainPage() {};
	
	// 0.
	private Scanner sc = new Scanner(System.in);
	
	// 1. 메인메뉴
	public void mainView() {
		while(true) {
			System.out.println("\n\n ======== 회원제 커뮤니티 =========");
			System.out.print("1.회원가입 2.로그인 선택 : ");
			try {
				int ch = sc.nextInt();	// 만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException
				if( ch == 1 ) {signupView();}
				if( ch == 2 ) {loginView();}
			}catch( Exception e) {
				System.out.println("경고] 잘못 입력했습니다.");
				sc = new Scanner(System.in); // 입력객체의 메모리를 새롭게 만들어주기
			}
		}
	} // f end
	
	// 2. 회원가입
	public void signupView() {
		System.out.println("-------- 회원가입 페이지 ---------");
		System.out.print("아이디 > "); String id = sc.next();
		System.out.print("비밀번호 > "); String pw = sc.next();
		System.out.print("이름 > "); String name = sc.next();
		System.out.print("전화번호[-포함] > "); String phone = sc.next();
		// 2. 입력받은 값을 컨트롤에게 전달
		boolean result = MemberController.getInstance().signupLogic( id , pw , name, phone);
		// 3. 결과에 출력
		if( result ) { System.out.println("안내] 회원가입이 성공했습니다. 감사합니다. ");}
		else { System.out.println("경고] 회원가입시 실패. 관리자에게 문의");}
	}
	
	// 3. 로그인
	public void loginView() {
		System.out.println("---------- 로그인 페이지 ------------");
		System.out.print("아이디 > "); String id = sc.next();
		System.out.print("비밀번호 > "); String pw = sc.next();
		boolean result = MemberController.getInstance().loginLogic( id , pw );
		if( result ) { System.out.println("안내) 로그인성공");}
		else {System.out.println("경고] 로그인실패");}
		
	}
}
