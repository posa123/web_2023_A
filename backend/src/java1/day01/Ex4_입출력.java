package java1.day01;

import java.util.Scanner;

public class Ex4_입출력 {
	public static void main(String[] args) {
		// 1. 출력 : syso
			// 1. System.out.print("출력하고싶은말" 또는 변수명 ); : 출력만
		System.out.print(" 출력문구1 ");
		System.out.print(" 출력문구2 ");
			// 2. System.out.println("출력하고싶은말" 또는 변수명); :출력후 줄바꿈
		System.out.println(" 출력문구3 ");
		System.out.println(" 출력문구4 ");
			// 3. System.out.printf("형식/포멧 문자" , 값/변수 ); : 형식문자열에 맞추어 값 출력
			// [ p.69 ] %d:정수 %f:실수 %s:문자열 
			// %자릿수d : 오른쪽정렬	 %-자릿수d : 왼쪽정렬 	%06d : 비어있는 자릿수 0채움
		int value = 123;
		System.out.printf("상품의 가격 : %d원 \n" , value); // %d 위치에 value 변수 출력
		System.out.printf("상품의 가격 : %6d원 \n" , value); // %6d : 6칸 정수 자리에 value변수 출력[ 자릿수가 비어있으면 정수처리 ]
		System.out.printf("상품의 가격 : %-6d원 \n" , value); // %6d : 6칸 정수 자리에 value변수 출력[ 자릿수가 비어있으면 정수처리 ]
		System.out.printf("상품의 가격 : %06d원 \n" , value); // %6d : 6칸 정수 자리에 value변수 출력[ 자릿수가 비어있으면 정수처리 ]
		
		System.out.printf("반지름 파이 %f \n" ,3.14);
		System.out.printf("반지름 파이 %.2f \n" ,3.14);
		
		System.out.printf("회원 아이디 : %s \n" ,"qweqwe");
		
		// 2. 입력
			
			// 1. 입력 객체 생성한다.
			// Scanner : 클래스(설계도)
			// scanner : 객체명
			// new 연산자 : 객체에 메모리 할당/생성
			// Scanner( ) : 클래스 생성자 ( 객체 생성시 초기값 대입하는 메소드 ) = 클래스명 무조건 동일
		
		Scanner scanner = new Scanner( System.in ); // System.in : 시스템 입력 =키보드 , System.out : 시스템 출력 =콘솔창
		
			// 2. 입력 객체를 이용한 입력값 호출/가져오기
				// 1. 입력받은 문자열 가져오기 scanner.next();
				// 2. 변수에 저장
		String 문자열 = scanner.nextLine();
				// 3. 변수에 출력 확인
		System.out.println("입력된 문자열은 : " + 문자열 );
			boolean 논리 = scanner.nextBoolean();
			System.out.println("입력된 논리 : " +논리);
			
			byte 바이트 = scanner.nextByte();
			System.out.println("입력된 바이트 : " +바이트);
			
			short 쇼트 = scanner.nextShort();
			System.out.println("입력된 쇼트 : " +쇼트);
			
			int 인트 = scanner.nextInt();
			System.out.println("입력된 인트 : " +인트);
			
			long 롱 = scanner.nextLong();
			System.out.println("입력된 롱 : " +롱);
			
			float 플롯 = scanner.nextFloat();
			System.out.println("입력된 플롯 : " +플롯);
			
			double 더블 = scanner.nextDouble();
			System.out.println("입력된 더블 : " +더블);
			
			
		
		
		
		
	}
}
