package java1.day16.Ex2_매개변수의다형성;

public class Driver {
	// 매개변수의 다형성 예제의 메소드 선언
	public void drive(int value , Vehicle vehicle) { // 매개변수 타입 과 자식타입 포함
		// 매개변수에 부모객체와 다양한 자식객체들이 자동타입변환해서 매개변수 들어온 상태
		System.out.println( vehicle instanceof Bus );
		
		vehicle.run();
	}
}
