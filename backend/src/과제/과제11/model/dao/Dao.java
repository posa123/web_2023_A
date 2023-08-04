package 과제.과제11.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Dao {	// 각종Dao 클래스를 대표하는 부모클래스
	
	// 1.필드
	public Connection conn; 		// DB연동 객체
	public PreparedStatement ps; 	// 연동된 DB조작 객체
	public ResultSet rs;			// SQL 조작 결과를 가져오는객체
	// 2.생성자
		// 기본생성자에 DB연동 코드 작성 *DAO객체생성시 바로 DB연동
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web", "root", "1234");
			
			System.out.println("안내] DB연동성공");
		}catch(Exception e) {System.out.println("경고] DB연동성공실패" +e);}
		
	}
}
