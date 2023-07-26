package java1.day10.Ex2;

public class Computer { // class s
	// 1. 필드
	// 2. 생성자
	// 3. 메소드
		// 1. 가변(정해져있지 않는)길이
	int sum( int ...values ) {	// ... 키워드 이용한
			// 타입 ...배열변수명
		
		int sum = 0; // 매개변수로 들어온 여러개의 변수를 더한 변수
		
		for( int i = 0; i<values.length; i++) {
			sum +=values[i]; // 배열내 하나씩 누적합계
		}
		
		return sum;
	}
}
