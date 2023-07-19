package 과제.과제3;

import java.util.Scanner;

public class If문제7문제 {
	public static void main(String[] args) {
		// 입력
				// 1. Scanner 객체 생성
		Scanner scanner = new Scanner(System.in);
				// 2. scanner 객체를 이용한 입력한 데이터 형변환해서 호출
						// .next~~~();
		/* ------문제1------- */
		/*
		System.out.println("------- 문제1 ---------");
		System.out.print("정수1 : "); int 문제1_1 = scanner.nextInt(); // 입력값을 int형으로 호출 // 변수에 대입
		System.out.print("정수2 : "); int 문제1_2 = scanner.nextInt();
		// 만약에 첫번째수가 더 크면
		if( 문제1_1 > 문제1_2 ) System.out.println("더 큰수 : " +문제1_1 );
		// 아니고 두번째수가 더 크면
		else if( 문제1_1 < 문제1_2 ) System.out.println("더 큰수 : " +문제1_2);
		// 둘다 아니면
		else System.out.println("동일한 수");
		
		/* ------문제2-------- 
		System.out.println("------- 문제2 ---------");
		System.out.print("정수1: "); int 문제2_1 = scanner.nextInt();
		System.out.print("정수2: "); int 문제2_2 = scanner.nextInt();
		System.out.print("정수3: "); int 문제2_3 = scanner.nextInt();
		// 1안
		int max = 문제2_1; // 가장 큰수를 저장하는 임시변수 이용
		if( max < 문제2_2 ) max = 문제2_2;
		if( max < 문제2_3 ) max = 문제2_3;
		System.out.println("문제2 : " +max);
		
		System.out.println("-------문제3---------");
		// > : 오름차순 <: 내림차순
		if( 문제2_1 > 문제2_2) { int temp = 문제2_1; 문제2_1 = 문제2_2; 문제2_2 = temp; } // 만약에 조건이 충족하면
		if( 문제2_1 > 문제2_3) { int temp = 문제2_1; 문제2_1 = 문제2_2; 문제2_3 = temp; } // 만약에 조건이 충족하면
		if( 문제2_2 > 문제2_3) { int temp = 문제2_2; 문제2_2 = 문제2_3; 문제2_3 = temp; } // 만약에 조건이 충족하면
		System.out.printf("문제3: %3d %3d %3d \n", 문제2_1 , 문제2_2 , 문제2_3 );
		/* --------문제4----------- 
		System.out.println("----------문제4------------");
		System.out.println("점수 : "); int 점수 = scanner.nextInt();
		if( 점수 >= 90 ) System.out.println("합격");
		else System.out.println(" 불합격 ");
		// 조건식에 들어갈수 있는 경우 : 1. true/false 결과를 갖는 비교/논리 계산식
		//												2. true/false 를 저장하고 있는 변수
		// 												3. true/false 리터럴(직접 적은 데이터)
	
		System.out.println("----------문제5----------");
		if( 점수 >= 90 ) {System.out.println("A등급");}
		else if( 점수 >= 80 ) {System.out.println("B등급");}
		else if( 점수 >= 70 ) {System.out.println("C등급");}
		else { System.out.println("재시험"); }
		
		/*----------문제6-----------*/
		System.out.println("------------문제6------------");
		System.out.print("국어 : ");	int 국어 = scanner.nextInt();
		System.out.print("영어 : ");	int 영어 = scanner.nextInt();
		System.out.print("수학 : ");	int 수학 = scanner.nextInt();
		double 평균 = (국어+영어+수학)/3.0; // 값/3 vs 값/3.0
		if( 평균 >= 90) {
			if( 국어 == 100 )		System.out.println("국어우수");
			if( 영어 == 100 )		System.out.println("영어우수");
			if( 수학 == 100 )		System.out.println("수학우수");
		}
		else if( 평균 >= 80 ) {
			if( 국어 >= 90 )		System.out.println("국어장려");
			if( 영어 >= 90 )		System.out.println("영어장려");
			if( 수학 >= 90 )		System.out.println("수학장려");
		}
		else { System.out.println("재시험"); }

	}
}
