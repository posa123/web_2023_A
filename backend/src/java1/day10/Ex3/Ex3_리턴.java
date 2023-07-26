package java1.day10.Ex3;

public class Ex3_리턴 {
	public static void main(String[] args) {
		
		// 1. 자동차 객체 생성
		Car myCar = new Car();
		myCar.setGas( 5 );
		if( myCar.isLeftGas()) {
			System.out.println("출발합니다.");
			myCar.run();
		}
		System.out.println("gas를 주입하세요.");
	}
}
