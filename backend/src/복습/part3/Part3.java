package 복습.part3;

import java.util.Scanner;

public class Part3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] 재고관리 = {"10,0,300,콜라" , "10,0,200,환타" , "10,0,100,사이다"};
		
		while(true) {
		System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제 ");
		System.out.print(">>>>>> 선택 : "); int ch = sc.nextInt();
		
		if( ch == 1 || ch == 2 || ch == 3 ) { // 콜라 메뉴선택번호 = 1 // 콜라가 저장된 배열의 인덱스 = 0
			// 1. 배열변수명 호출
			String product = 재고관리[ch-1];
				System.out.println( ch + "번 제품 : " +product);
			// 2. 배열내 데이터[문자열] 분리
			int stock = Integer.parseInt(product.split(",")[0]);
			int basket = Integer.parseInt(product.split(",")[1]);
			int price = Integer.parseInt(product.split(",")[2]);
			String name = product.split(",")[3];
			
			// 3. 유효성검사를 통한 상태 변경
			if( stock > 0) {
				stock--;	basket++; System.out.println( name+ "바구니 담았습니다.");
			}
			else {System.out.println("재고부족");}
			// 4. 재고관리 업데이트
			재고관리[ch-1] = stock+","+basket+","+price+","+name;
		}
		else if( ch == 4) {
			System.out.printf("%10s %10s %10s \n" , "제품명" , "수량" , "가격");
			for( int i = 0; i<재고관리.length ; i++) {
				int basket = Integer.parseInt(재고관리[i].split(",")[1]);
				int price = Integer.parseInt( 재고관리[i].split(",")[2]);
				String name = 재고관리[i].split(",")[3];
				
				if( basket > 0 ) {
					System.out.printf( "%10s %10s %10s \n" ,name , basket ,basket*price );
					
				}
			}
			
		}
	}
	
		
	}
}
