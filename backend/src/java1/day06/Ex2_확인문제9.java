package java1.day06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2_확인문제9 {	// class s
	public static void main(String[] args) { // main s
		// [p.199] 확인문제9

		int count = 0; // 모든 경우의수 if { } 에서 공유하기 위해 if { } 밖에서 선언
		int[] scores = new int[count]; // // 모든 경우의수 if { } 에서 공유하기 위해 if { } 밖에서 선언 
		while(true) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료 ");
			System.out.println("-------------------------------------------------");
			System.out.print("선택> ");			
			Scanner scanner = new Scanner(System.in);
			
			String ch = scanner.nextLine();
			
			if( ch.equals("1")) {
				System.out.println("학생수>");
				
				// 1. 입력받은 데이터를 문자열로 가져와서 정수형으로 변환후 정수 변수에 저장/대입
				count = Integer.parseInt( scanner.nextLine() );
					System.out.print("입력한 학생수 : " +count);
				// 2. 입력받은 수 만큼 배열 변경
					// 1. = { } 저장할 값을 아는경우 
					// 2. new 타입[길이] 저장할 값을 몰라서 길이만큼 기본값으로 생성
				scores = new int[count];
					System.out.println(Arrays.toString(scores));
			}
			if( ch.equals("2")) {
				// 1번기능에서 입력받은 수만큼
				System.out.println( count ); System.out.println( Arrays.toString(scores) );
				
				// 1. 0부터 입력받은 수만큼 점수(정수) 입력받기
					//Integer.parseInt( scanner.nextLine() ); // 정수 입력받기  vs scanner.nextLine();
				for( int i = 0; i<count ; i++) { 
					System.out.print( i + "번째 학생점수 입력 :");
					scores[i] = Integer.parseInt( scanner.nextLine() ); // 입력받은 정수를 각 배열내 각 인덱스에 저장/변경
				}
					System.out.println(Arrays.toString(scores));
			}
			if( ch.equals("3")) {
				for( int i = 0 ; i<scores.length ; i++) {
					System.out.println(i + "인덱스 의 저장된 학생점수 : " +scores[i]);
				}
			}
			if( ch.equals("4")) {
				int sum = 0; // 배열내 데이터를 모두 더한(누계) 값을 저장하는 변수
				int max = 0; // 배열내 데이터중에 가장 큰 값을 저장하는 변수
				
				// 배열내 모든 데이터 호출[ 0인덱스 마지막인덱스까지 호출 ]
				for( int i = 0 ; i<scores.length ; i++) {
					// 1. sum
					sum += scores[i]; // i번째 데이터를 sum 변수에 추가/누계;
					// 2. max
					if( max < scores[i] ) max = scores[i]; // 만약에 i번쨰 데이터가 max보다 크면
				}
				System.out.println(" 최고점수 : " +max);
				System.out.println(" 평균 : " +( (double)sum/count ));
				
			}
			if( ch.equals("5")) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
		
	} //main e
} // class e
