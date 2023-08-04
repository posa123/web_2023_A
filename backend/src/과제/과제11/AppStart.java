package 과제.과제11;

import 과제.과제11.view.MainPage;

public class AppStart {
	public static void main(String[] args) {
		MainPage.getInstance().mainView();
		// MainPage.getInstance() : MainPage 싱글톤객체 호출 ( 해당 객체의 메소드 호출 )
			// => mainPage객체가 반환된다.
	}
}
