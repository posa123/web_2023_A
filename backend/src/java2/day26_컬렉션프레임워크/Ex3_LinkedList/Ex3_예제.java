package java2.day26_컬렉션프레임워크.Ex3_LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Ex3_예제 {
	public static void main(String[] args) {
	// ArrayList 객체
	List<String> list1 = new ArrayList<>();
		// ArrayList vs LinkedList
		// 사용방법 동일 , 내부구조 설계 다르다.
		// 배열에 객체저장 , 객체를 체인처럼 연결
	
	// LinkedList 객체
	List<String> list2 = new ArrayList<>();
	
	// 두 객체의 저장 속도 체크
	long startTime; // 시작시간
	long endTime; // 끝시간
	
	// 밀리초( 1000/1 초 ) 나노초( 1/10000000 초)
	startTime = System.nanoTime(); // 현재시간을 나노시간
	for( int i = 0; i<10000; i++) { list1.add(i+"");}
	endTime = System.nanoTime(); // 현재시간을 나노시간 으로 호출/반환받기
	
	System.out.println("ArrayList 10000개를 저장하는데 걸리는 시간 : " +(endTime-startTime));
	
	
	startTime = System.nanoTime(); // 현재시간을 나노시간
	for( int i = 0; i<10000; i++) { list2.add(i+"");}
	endTime = System.nanoTime(); // 현재시간을 나노시간 으로 호출/반환받기
	
	System.out.println("LinkedList 10000개를 저장하는데 걸리는 시간 : " +(endTime-startTime));
	}
	
}
