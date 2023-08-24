package java2.day25_제네릭2.Ex1;

public class Ex1_제한된타입파라미터 {
	// p. 582
	
	// - 제네릭 메소드 정의 [ 제한된 타입 파라미터 ]
	public static < T extends Number > boolean compare( T t1 , T t2 ) {
		System.out.println( t1.getClass().getSimpleName());
		System.out.println( t2.getClass().getSimpleName());
		
		double v1 = t1.doubleValue(); System.out.println( v1 );
		double v2 = t2.doubleValue(); System.out.println( v2 );
		
		return ( v1 == v2 );
	}
	public static void main(String[] args) {
		// - 제네릭 메소드 사용
		boolean result1 =compare( 10 , 20 ); System.out.println(result1);
		boolean result2 =compare( 4.5,4.5); System.out.println(result2);
		Integer i = 1;
		Double d = 3.0;
		String s = "aa";
		
		
	}
}

/*
	제네릭 : 결정되지 않은 타입을 파라미터 처리하고 실제 사용할때 파라티머를 구체적인타입으로 대체 <>
		1. <  > : 파라티머 이름은 알파벳 대문자 A~Z
		2. 사용처
			1. 클래스 : public class 클래스명 < T > {}
					-- 1. 클래스 정의시
					public class 클래스명 < T > {
						T t;
					}
					-- 2. 객체 생성시
					클래스명<구체적인타입> 객체명 = new 생성자<>();
					
			2. 메소드 : public <T> 리턴타입 메소드명 ( ) { } 
			
  					-- 1. 메소드 정의
  					public < T > boolean 메소드명( T t ) {
  						int value = t;
  						return true;
  					}
  					
  					-- 2. 메소드 호출
 */
