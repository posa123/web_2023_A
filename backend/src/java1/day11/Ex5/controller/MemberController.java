package java1.day11.Ex5.controller;

import java1.day11.Ex5.model.dao.MemberDao;
import java1.day11.Ex5.model.dto.MemberDto;

public class MemberController { // 기능처리(로직) 담당하는 클래스 // controller
	// 1. 싱글톤 생성 [ private static ]
	private static MemberController memberController = new MemberController();
	// 2. 외부로부터 싱글톤 호출할수 있도록 get~~
	public static MemberController getInstance() { return memberController;}
	// 3. 외부에서 객체 생성 차단 위한 생성자 잠금
	private MemberController() {}
	
	public boolean singupLogic( String id , String password , String name , String phone , int age) {
		MemberDto m = new MemberDto( id ,password , name , phone , age );
		for( int i=0; i<MemberDao.memberList.length; i++) {
			if( MemberDao.memberList[i] == null) {
				MemberDao.memberList[i] = m; return true;
				
			}
		}
		return false;
	}
	void loginLogic() {}
	void findIdLogic() {}
	void findPwLogic() {}
}
