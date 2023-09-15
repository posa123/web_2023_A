package model.dao;

import java.sql.Statement;
import java.util.List;

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
	public List<ProductDto> findByTop(int count){return null;}
	public List<ProductDto> findByLatLng( String east  , String west ,  String south ,  String north){return null;}
	public ProductDto findByPno( int pno ){ return null ;}
	public List<ProductDto> findByAll(){return null;}
	// 3. 제품 개별 조회
	
	// 4. 제품 수정
	
	// 5. 제품 삭제
	
}
