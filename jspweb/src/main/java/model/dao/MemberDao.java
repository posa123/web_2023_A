package model.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.dto.MemberDto;
import model.dto.MpointDto;

public class MemberDao extends Dao{
	private static MemberDao memberDao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {return memberDao;}
	
	// 1. 회원가입
	public boolean signup( MemberDto dto ) {
		try {
			String sql = "insert into member( mid , mpwd , memail , mimg ) values( ? , ? , ? , ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMimg());
			int row = ps.executeUpdate();
			if( row == 1 ) return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 2. 로그인
	public boolean login( String mid , String mpwd ) {
		try {
			String sql ="select * from member where mid=? and mpwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid); ps.setString(2, mpwd);
			rs = ps.executeQuery();
			if(rs.next()) return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
		
	}
	// 3. 아이디찾기
	
	// 4. 비밀번호찾기
	
	// 5. 내정보 호출
	public MemberDto info( String mid ) {
		try {
			String sql = "select mno , mid , memail , mimg from member where mid =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				MemberDto memberDto = new MemberDto(
						LocalDateTime.now().toString() ,
						rs.getInt(1), rs.getString(2) , 
						rs.getString(3), rs.getString(4));
				return memberDto;
			}
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	
	// 6. 아이디/이메일 중복검사
	public boolean findIdOrEmail( String type , String data ) {
		try {
			String sql = "select * from member where "+type+" = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, data);
			rs = ps.executeQuery();
			// [ while : 결과 레코드 여러개 vs if : 결과 레코드 한개 검사 ]
			if( rs.next() ) 
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 7. 회원수정
	public boolean mupdate( int mno , String mimg ) {
		try {
			String sql = "update member set mimg = ? where mno = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mimg); ps.setInt(2, mno);
			int count = ps.executeUpdate();
			if( count == 1) return true;
			
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 8. 회원탈퇴 [ 삭제할회원번호 , 검증할패스워드 ]
	public boolean mdelete( int mno , String mpwd) {
		try {
			
			String sql = "delete from member where mno = ? and mpwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno); ps.setString(2,mpwd);
			int count = ps.executeUpdate();
			if(count == 1)return true;
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 9. 포인트 지급/사용에 대한 함수
	public boolean setPoint( MpointDto dto ) {
		try {
			
			String sql = "insert into mpoint(mpno,mno,mpamount,mpcomment)values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getMpno());
			ps.setInt(2, dto.getMno());
			ps.setLong(3, dto.getMpamount());
			ps.setString(4, dto.getMpcomment());
			int count = ps.executeUpdate();
			if( count == 1 ) {return true;} 
			
		} catch (Exception e) {e.getStackTrace();}
		return false;
	}
	// 10. 내 포인트 확인 [ 로그인한 사람의 현재 포인트 합계 ] 
	public long getPoint( int mno ) {
		try {	// sum( 필드명 ) : 총합계를 계산할 필드명 인수로 대입 // avg // count
			
			String sql = "select sum( mpamount ) from mpoint where mno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,mno);
			rs = ps.executeQuery();
			if(rs.next()) {return rs.getInt(1);}
			
		} catch (Exception e) {e.getStackTrace();}
		return 0;
	}
	// 11. 내 포인트 사용 내역 전체 출력하는 함수
	public List<MpointDto> getPointList( int mno ){
		List<MpointDto> list = new ArrayList<>();
		try {
			
			String sql = "select * from mpoint where mno =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,mno);
			rs = ps.executeQuery();
			while( rs.next()) { 
				MpointDto dto = new MpointDto(rs.getString(1),rs.getInt(2), rs.getLong(3), rs.getString(4), rs.getString(5));
				list.add(dto);
				
			}
		} catch (Exception e) {e.getStackTrace();}
		return list;
	}
}
