package java1.day18.Ex1;

// 클래스에서 인터페이스를 구현하기
public class Television implements RemoteControl{
	// 클래스명 implements 인터페이스명
	// 인터페이스가 선언한 추상메소를 해당 클래스가 구현 대신 하기.
	// 해당 추상메소드를 구현하기 전까지 오류
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다. ");
		
	}
}
