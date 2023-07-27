package 과제.과제10;

public class Member {
	// 1. 필드 : 객체의 데이터를 저장하는 곳 = 인스턴스 vs 정적멤버static
	String id;	 
	String password;
	String name;
	String phone;
	int age;
	
	// 2. 생성자 : 객체의 초기화를 담당 역할 = 인스턴스 vs 정적멤버static
		// 1. 빈생성자
	public Member() {}
		// 2. 모든 필드를 저장하는 풀생성자 => 클래스내 빈공간을 오른쪽클릭 -> Source -> Generate Constructor using Fields
	public Member( String id, String password, String name, String phone, int age) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	
	// 3. 메소드 : 객체의 행동을 담당 역할 = 인스턴스 vs 정적멤버static

	
}
