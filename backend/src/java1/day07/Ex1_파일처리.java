package java1.day07;

import java.io.IOException;
import java.util.Scanner;

public class Ex1_파일처리 { // class s
	public static void main(String[] args) throws IOException{ // main s
		
		// 스택영역 : 함수는 호출'{'시 메모리할당 종료 '}'시 메모리초기화 * 지역변수
		// 힙영역 : 객체/배열은 참조하는 스택이 없으면 자동으로 메모리가 초기화
		
			// ---> RAM 주기억장치 : 현재 처리된 명령어 저장 --> 전기X저장X  -> 휘발성[ 타서 날라감 ]
		
		// 영구저장
		
			// ---> c: ,usb , cd 보조기억장치 : 명령어 영구 저장 ---> 전기X저장O			-> 비휘발성
		
		// Ex1_파일처리.java
		
			// 저장위치 : 내가 작성한 코드/문법 c:~~~ 보조기억장치
			// 실행[Ctrl+F11] : 실행중에 필요한 메모리( 변수,객체,배열 등 ) -> 주기억장치
			// 실행중인 메모리를 다음에 또 사용할려면 주기억장치 메모리를 보조기억장치 저장 / 불러오기
		
			// String a = scanner.next(); ---------------> c: 저장	[파일처리 , 데이터베이스]
			// 컴퓨터 종료후 다음날
			// String b = 				<--------------- c: 불러오기	[파일처리 , 데이터베이스]
		
		// 파일처리 라이브러리( 미리 만들어진 클래스/메소드 )
		
			// * 스트림 : 자바 외부와 통신할때 사용 통로 [ *바이트단위 ]
				// * 통신하다가 갑자기 오류 발생할수도 있음 [ *필수 : 예외처리/오류처리 ]
		
			// 1. FileOutputStrem : 파일 내보내기/저장 관련된 메소드 제공하는 클래스
				// new FileOutputStrem("파일경로"); : 해당파일과 연동/연결
				// 파일경로 : 
					// 상대경로 : 프로젝트명생략 -> ./src/패키지명/파일명
					// 절대경로 : 
			
		
			// 2. 제공하는 함수
				//1. .write( 바이트배열 )	: 1바이트=영문	바이트배열 = 여러글자
				// 2. 문자열.getBytes()해당 문자열을 바이트배열 반환
		
		Scanner scanner = new Scanner(System.in);	// 입력객체 = 입력한 값이 바이트로 들어옴
		String instr = scanner.next();	// 객체 입력받은 값의 바이트열을 문자열로 반환
		
		// 1. 파일처리 [ 저장 ]
			// 1. 파일출력스트림 객체 선언 [ 파일경로 ]
		FileOutputStrem fileOutputStrem = new FileOutputStrem("./src/java1/day07/로또.csv");
			// 2. 파일출력스트림 객체를 이용한 내보내기 메소드 사용 [ 바이트 단위 ]
		byte[] instrArray = instr.getBytes();
		fileOutputStrem.write( instrArray );	// 문자열 --> 바이트배열 변환후
		
		
	} // main e
} // class e
