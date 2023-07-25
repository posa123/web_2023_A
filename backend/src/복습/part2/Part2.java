package 복습.part2;

import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n";
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("--------------메뉴-------------");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>>> 선택 : "); int ch = sc.nextInt();
			if( ch == 1) {
		
				System.out.println("안내) 콜라 담았습니다.");
			}
			else if( ch == 2) {

				System.out.println("안내) 환타 담았습니다.");
			}
			else if( ch == 3) {
				
			}
			else if( ch == 4) {
				
			}
		}
		
	}
}
