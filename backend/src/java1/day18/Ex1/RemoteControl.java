package java1.day18.Ex1;

// 인터페이스 선언
public interface RemoteControl {
	// 멤버 구성
	// 1. 상수 [ public static final ] 필드 : 프로그램내 수정 불가능한 데이터
		// [ public static final ]int MAX_VOLUME;
	public static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	// 2. 추상메소드 : 선언만 하고 { } 구현은 안하는 함수 [ 각 클래스가 구현 ]
		// [ public abstract ] 리턴타입 메소드명(매개변수1, 매개변수2);
	// 1. 선언만하는 전원켜기 함수
	public abstract void turnOn();
	// 2. 선언만하는 전원끄기 함수
	void trunOff();
	// 3. 선언만하는 불륨조절 함수
	void setVolume( int volume );
}
