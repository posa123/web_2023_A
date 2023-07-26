package java1.day10.Ex3;

public class Car {
	// 1.필드
	int gas; // 현재 객체의 gas 데이터를 저장하는 곳
	// 2.생성자
	// 3.메소드 // 관례적으로 메소드명은 필드에 저장하는 용도의 함수는 set필드명
		// 1. 리턴X매개변수1개 : 매개변수로 부터 전달받은 gas값을 필드gas 저장하는 함수
	void setGas( int gas ) {
		this.gas = gas; // this : 현재객체 [매개변수와 필드와 이름 동일할때 식별용 ]
		
	}
		// 2. 리턴O매개변수X	: 현재 객체의 gas필드가 0이면 false리턴 아니면 true 리턴 함수
	boolean isLeftGas() {
		if( this.gas == 0 ) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
		
	}
		// 3. 리턴x매개변수x
	void run() {
		while(true) {
			if( this.gas > 0 ) {
				System.out.println("달립니다.가스 잔량 : "+ this.gas);
				this.gas--;
			}
			else {
				System.out.println("멈춥니다.가스잔량 : " +this.gas);
				return; // 메소드 강제종료
			}
		}
	}
}
