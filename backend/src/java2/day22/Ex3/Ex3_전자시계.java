package java2.day22.Ex3;

import java.time.LocalTime;
import java.util.Scanner;

public class Ex3_전자시계 {
	public static void main(String[] args) {
		
		// 자동으로 현재시간 실행
		현재시간기능 현재시간 = new 현재시간기능();
		Thread thread = new Thread(현재시간);
		thread.start();
		
		// [main스레드] 타이머 사용여부는 입력 받아 
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("1.타이머시작 2.타이머중지 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) { System.out.println("타이머시작");}
			else if( ch == 2 ) { System.out.println("타이머중지");}
		}
	}
}
