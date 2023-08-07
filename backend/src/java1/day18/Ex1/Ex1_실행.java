package java1.day18.Ex1;

public class Ex1_실행 {
	public static void main(String[] args) {
		
		// 1. 인터페이스타입의 변수 선언
		RemoteControl rc;
		
		// 2. 변수에 텔레비전 객체의 대입 [ 주소대입 ]
		rc = new Television();
		
		// 3. 인터페이스로 메소드 실행
		rc.turnOn();
		
		// 4. 리모컨을 오디오 변경
		rc = new Audio();
		
		rc.turnOn();
		/*
		 		인터페이스			vs		상속
		 		implements  	vs		extends
		 		구현하다					연장하다
		 		여러개 구현				1개 상속
		 		추상메소드					메소드
		 		*버전[다양한 메소드 제공]
		 		목적 : 메소드 통합			빠른 개발 / 설계 모듈화[쪼개서]
				게임패드					직급별 사원
				
				
		  */
	}
}
