package java1.day18.Ex1;

// 클래스에서 인터페이스를 구현하기
public class Television implements RemoteControl{
	private int volume;
	// 클래스명 implements 인터페이스명
	// 인터페이스가 선언한 추상메소를 해당 클래스가 구현 대신 하기.
	// 해당 추상메소드를 구현하기 전까지 오류
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다. ");
		
	}
	@Override
	public void trunOff() {
		System.out.println("TV를 끕니다.");
		
	}
	@Override
	public void setVolume(int volume) {
		if( volume > RemoteControl.MAX_VOLUME  ) {
			//만약에 볼륨이 최대볼륨보다 크면 
			this.volume = RemoteControl.MAX_VOLUME;
			// 해당객체는 최대볼륨으로 대입
			
		}else if( volume  < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		
	}
}
