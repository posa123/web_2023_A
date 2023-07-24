package 복습.part1;

import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int 콜라재고 = 10; int 환타재고 = 3; int 사이다재고 = 2;
		int 콜라바구니 = 0; int 환타바구니 = 0; int 사이다바구니 = 0;
		int 콜라가격 = 300; int 환타가격 = 200; int 사이다가격 = 100;
		
		while(true) {
		System.out.println("----------------메뉴---------------");
		System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
		System.out.print(">>>>>> 선택 : ");	int num = scanner.nextInt();
		if( num == 1) {
			콜라재고--;
			콜라바구니++;
		}
		if( num == 2) {
			환타재고--;
			환타바구니++;
		}
		if( num == 3 ) {
			사이다재고--;
			사이다바구니++;
			
		}
		if( num == 4) {
			
		}
		System.out.println("제품명 수량 가격");
		System.out.printf("%d %d %d",콜라바구니 ,사이다바구니 ,환타바구니);
		}
	}
}
