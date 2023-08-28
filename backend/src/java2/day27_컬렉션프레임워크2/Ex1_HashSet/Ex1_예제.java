package java2.day27_컬렉션프레임워크2.Ex1_HashSet;

import java.util.*;

public class Ex1_예제 {
	public static void main(String[] args) {
		
		// 1. Set 컬렉션의 HashSet 객체 선언
		Set<String> set = new HashSet<>();
			// set객체(컬렉션프레임워크) 에 <String>객체를 여러개 저장
		System.out.println("set 상태 : " + set );
		// 2. set 객체에 String객체 저장
		set.add("Java");	System.out.println("set 상태 : " +set);
		set.add("JDBC");	System.out.println("set 상태 : " +set);
		set.add("JSP");		System.out.println("set 상태 : " +set);
		set.add("Java");	System.out.println("set 상태 : " +set);
		System.out.println("set 상태 : " + set );
		set.add("Spring");	System.out.println("set 상태 : " +set);
		
		// 3. 객체내 String 객체 수
		System.out.println("set객체내 객체 수 : " +set.size());
		// 4. set/list 와 for문 관계 [ * 배열/컬렉션 내 저장된 데이터들을 순회 할려고 ]
			// 1. for문 [ list 인덱스사용해서 가능하지만 , set 불가능... ]
		for( int i = 0; i<set.size(); i++) {}
		// 2. 향상된 for문 [ list , set 가능 ]
			// for( 반복변수 : 컬렉션객체 ) { }
			// 1. 반복변수란 : 컬렉션객체에 저장된 타입
		for(String s : set ) { System.out.println( s ); }
		// 3. forEach() 함수를 이용한 람다식 표현(화살표함수 = [java -> / js => ] )
		set.forEach( s -> {System.out.println(s);});
		
		// ------------------------------------------------------- //
		
			// 객체내 중복여부 체크
				// 객체 String 이면 String 기준으로 중복 제거
				// 객체[ String , int ] 가 2개 이상의 필드를 가지고 있으면 중복기준 애매
		
		// 1. set 객체 선언 
		Set<Member> set2 = new HashSet<>();
		
		// 2. set 객체에 member객체 저장
		set2.add( new Member("홍길동",30));
		set2.add( new Member("홍길동",30));
		set2.add( new Member("강호동",30));
		set2.add( new Member("홍길동",40));
		set2.add( new Member("신동엽",50));
		
		// 3. set 객체내 member 객체 수
		System.out.println("set객체내 member 객체수 : " +set2 );
		
		// 4. iterator() 메소드 제공
		Iterator<Member> iterator = set2.iterator();
		
		while( iterator.hasNext() ) {
			Member element = iterator.next();
			System.out.println(element);
			if( element.name.equals("강호동")) {
				iterator.remove();
			}
		}
		System.out.println("set객체내 member 객체수 : " + set2 );
		
		// 4. 향상된 for문( iterator 를 사용하는 배열/컬렉션프레임워크의 객체 이면 사용 가능 )
		for( Member m : set2 ) {System.out.println( m );}
		
		// 4. forEach ( iterator 를 사용하는 컬렉션프레임워크의 객체 이면 사용 가능 )
		set.forEach( m ->{System.out.println(m);});
	}
}
