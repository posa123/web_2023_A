package java2.day24.Ex3;

public class GenericExample {
	public static void main(String[] args) {
		
		// 1. 홈 렌탈 구현체
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLigth();
		
		// 2. 자동차 렌탈 구현체
		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();
	}
}
