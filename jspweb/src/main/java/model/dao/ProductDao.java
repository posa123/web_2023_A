package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import model.dto.ProductDto;

public class ProductDao extends Dao{
	private static ProductDao productDao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() {return productDao;}
	
	
	// 1. 제품 등록
	public boolean register( ProductDto dto ) {
		// 1-1 제픔 등록
		try {
			String sql = "insert into product( pcno , pname , pcontent , pprice , plat , plng , mno  ) "
					+ "	values( ? , ? , ? , ? , ? , ? , ?  );";
			// * sql insert 후 자동생성된 pk번호를 반환하는 방법
				// .prepareStatement(sql , Statement.RETURN_GENERATED_KEYS) : 생성된 식별키를 반환
				// ps.getGeneratedKeys()									: 식별키 반환하는 함수
			ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, dto.getPcno());
			ps.setString( 2 , dto.getPname());
			ps.setString( 3 , dto.getPcontent());
			ps.setInt(4, dto.getPprice());
			ps.setString( 5 , dto.getPlat());
			ps.setString( 6 , dto.getPlng());
			ps.setInt( 7 , dto.getMno());
			
			int count = ps.executeUpdate(); // 제품 등록
			
			rs = ps.getGeneratedKeys(); // 제품 등록시 생성된 식별키[pk] 반환해서 resultset[ps]에 대입
			rs.next();	// 반환된 식별키들 중에서 다음으로 이동
						// 반환된 결과레코드로 1번 이동 [ 하나의 제품 식별키 필요 ]
			if( count == 1 ) {
				// 1-2 제품 등록후 생성된 제품pk를 가지고 [이미지등록]
				for( String img : dto.getImgList().values() ) {
					sql = "insert into productimg( pimg , pno ) values( ? , ? )";
					ps = conn.prepareStatement(sql);
					ps.setString(1,img);
					ps.setInt( 2 , rs.getInt(1)); // 
					ps.executeUpdate();
					
				}
				return true; // 제품등록과 이미지 등록 성공 했을때
			}
		} catch (Exception e) {System.out.println(e);}
		
		
		
		return false;
	}
	// 2. 제품 전체 출력
	
		// 0. 제품의 해당하는 이미지 출력하는 함수
	public Map< Integer , String > getProductImg( int pno ){ // * 이미지테이블에서 현재 레코드의 제품 번호에 해당하는 (여러개)이미지 출력해서 map객체 담기
		try {
			Map<Integer , String > imglist = new HashMap<>();
			String sql = "select * from productimg where pno = "+pno;
			PreparedStatement ps = conn.prepareStatement(sql); // * 위에서 먼저 사용중인 rs인터페이스 객체 가 사용중 이므로[ while ] 중복 사용불가능 // 해결방안 새로운 rs 만들기 ( PreparedStatement , ResultSet 2개 사용 )
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				imglist.put(rs.getInt("pimgno"),rs.getString("pimg"));
			}
			return imglist;
		} catch (Exception e) {System.out.println(e);} 
		return null;
	}
	public ProductDto findByPno( int pno ){ 
		try {
			String sql = "select * from product p natural join pcategory pc natural join member m  where p.pno="+pno;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if( rs.next()) {
				ProductDto productDto = new ProductDto(
						rs.getInt("pcno") , rs.getString("pcname"),
						rs.getInt("pno") , rs.getString("pname"),
						rs.getString("pcontent") , rs.getInt("pprice") ,
						rs.getInt("pstate") , rs.getString("pdate"),
						rs.getString("plat") , rs.getString("plng") ,
						rs.getInt("mno") , getProductImg( rs.getInt("pno") ) ,
						rs.getString("mid"));
					return productDto;
				
			}
		} catch (Exception e) {System.out.println(e);}
		return null ;
	}
	
	

		// 1. N개 제품을 최신순으로 출력 함수
	public List<ProductDto> findByTop(int count){
		List<ProductDto> list = new ArrayList<>();
		try {
			String sql = "select * from product order by pdate desc limit "+count;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { list.add( findByPno(rs.getInt("pno")));} return list;
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
		// 2. 현재카카오지도내 보고있는 동서남북 기준내 제품들을 출력 함수
	public List<ProductDto> findByLatLng( String east  , String west ,  String south ,  String north){
		try {	// 동 경도보다 크고 서 경도보다 작고 남 위도보다 크고 북 위도 작고
			List<ProductDto> list = new ArrayList<>();
	         String sql = "select pno from product where ? >= plat and ? <= plat and ? >= plng and ? <= plng order by pdate desc";
	         
	         ps = conn.prepareStatement(sql);
	         ps.setString(1, north);
	         ps.setString(2, south);
	         ps.setString(3, east);
	         ps.setString(4, west);
	         rs = ps.executeQuery();
			while(rs.next()) { list.add(findByPno(rs.getInt("pno") ) ) ;} return list;
		} catch (Exception e) {System.out.println(e);}
		return null;
	}

		// 4. 모든 제품들을 출력하는 함수 
	public List<ProductDto> findByAll(){
		try {
			String sql ="select * from product";
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
	// 3. 제품 찜하기 등록(=찜하기상태가 아닐때=조건에따른 레코드가없을때)/취소(=찜하기상태 일때)
	public boolean setWish( int mno , int pno ) {
		try {
			
			
			String sql = getWish(mno, pno) ? 
					"delete from pwishlist where mno = ? and pno = ?" : 
					"insert into pwishlist values( ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setInt(2,pno);
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
			
			
		} catch (Exception e) {System.out.println(e);}
		return false;
	}

	// 4. 제품 찜하기 상태 출력
	public boolean getWish( int mno , int pno ) {
		try {
			String sql  = "select * from pwishlist where mno = ? and pno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno); ps.setInt(2, pno);
			rs = ps.executeQuery(); if( rs.next() ) {return true;}
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	// 5. 현재 로그인된 회원의 찜한 제품[여러개] 정보를 출력하는 함수
	public List<ProductDto> getWishProductList( int mno ){
		List<ProductDto> list = new ArrayList<>();
		try { // 현재 회원이 찜한 제품번호
			String sql = "select pno from pwishlist where mno =" +mno; // 현재 회원의 찜하기 제품번호 목록 찾기
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 현재 회원이 찜한 제품번호의 레코드반환
			while( rs.next() ) { list.add(findByPno(rs.getInt("pno"))); }
			return list;
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
}
