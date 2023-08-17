package java2.day22;

import java.awt.Toolkit;

public class 비프음 implements Runnable {
			// implements : 구현하다.
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	@Override
	public void run() {  // 추상메소드 구현
		for( int i = 5; i<5 ; i++) {
			toolkit.beep();
			try {Thread.sleep(500);} 
			catch (Exception e) {System.out.println(e);}
		}
		
	}
}
