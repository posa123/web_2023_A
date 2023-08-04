package 과제.과제11.model.dao;

import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao{
	
	// 0. 싱글톤 객체
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {return memberDao; }
	private MemberDao() {};
	// 2. 회원가입SQL
	public boolean signupSQL(MemberDto dto) {
		System.out.println("--- signupSQL 다오 도착");
		System.out.println( dto );
		// 1. 회원가입 필요한 SQL 작성
			// 테이블에 레코드 삽입 : insert into 테이블명() values ();
		String sql = "insert into member( mid , mpw , mname , mphone) values( ? , ? , ? , ? )";
		
		try {
			// 2. 위에서 작성한 SQL를 DB연동객체에 대입 [ conn.prepareStatement(sql); ]	
			// 3. 대입된 SQL 조작하기 위해 반환된prepareStatement 를 ps 대입
			ps = conn.prepareStatement(sql);
			 // DB연동객체.prepareStatement( 조작할SQL문자열 )
			// conn , ps 필드는 Dao 부모클래스에게 물려받음
			
			// 4. SQL에서 작성한 매개변수(?) 에 대해 값 대입
			ps.setString( 1 ,dto.getMid());
			ps.setString( 2 ,dto.getMpw());
			ps.setString( 3 ,dto.getMname());
			ps.setString( 4 ,dto.getMphone());
			
			// 5. SQL 실행
			ps.executeUpdate();
			return true;
		}catch(Exception e) { System.out.println("경고] 회원가입실패 사유" +e );}
		return false;
	}
	
	// 3. 로그인SQL
	public boolean loginSQL(String id , String pw) {
		try {
			// 1단계 : SQL 작성한다. [ 추천 : MSYQL 워크벤치에서 임의의값으로 테스트하고 ]
			String sql = "select * from member where mid = ? and mpw=?";
			// 2단계 : SQL 조작할수 있는 객체 필요함으로 prepareStatement 반환받기
			
			ps = conn.prepareStatement(sql);
			// 3단계 : SQL 조작 [ SQL안에 있는 매개변수[?]에 값 대입 ]
			ps.setString(1, id);
			ps.setString(2, pw);
			// 4단계 : SQL실행해서 그 결과객체 를 rs객체에 대입 [ *ps는 결과를 조작할수 없다. ]
				// [ insert : ps.executeUpdate(); / select : ps.executeQuery(); ]
			rs = ps.executeQuery();
			// 5단계 : SQL 실행 결과 조작 [ rs.next() : 결과중에서 다음 레코드객체 호출 ]
				// 만약에 결과의 레코드 3개 가정 [	rs = null -> 레코드1 -> 레코드2 -> 레코드3 ]
				//										.next()		.next()		.next()
			if( rs.next() ) {	// 로그인은 레코드가 1개 또는 0개 이므로 if 사용해서 .next() 1번 호출
				return true;	// 로그인성공
				
			}
		}catch(Exception e) {System.out.println(e);}
		return false; // 로그인 실패
	}
}
