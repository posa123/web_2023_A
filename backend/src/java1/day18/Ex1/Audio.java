package java1.day18.Ex1;

public class Audio implements RemoteControl{
	private int volume;
	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다.");
		
	}
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
