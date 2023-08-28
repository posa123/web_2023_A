package java2.day27_컬렉션프레임워크2.Ex1_HashSet;

public class Member {
	public String name ;
	public int age;
	
	// 생성자
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	} 
	
	// 오버라이딩
	@Override // Object(모든 클래스는 Object로부터 자동으로 상속받음 )의 메소드를 재정의
	public int hashCode() {
		return name.hashCode()+age;
	}
	@Override
	public boolean equals(Object obj) {
		
		if( obj instanceof Member target) { // javaSE-16 이상
			// 만약에 해당 객체가 이름과 나이가 일치하면 [ 중복 = true ] 
			return target.name.equals(name) && (target.age == age);
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
}
