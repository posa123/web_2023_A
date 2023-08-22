package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao { // DB에 연동하는 상위 클래스
	// 1.필드
	public Connection conn;			// 연동 DB의 객체
	public PreparedStatement ps;	// 연동된 DB에서 SQL 조작( 매개변수대입 , SQL실행/결과 ) 하는 객체
	public ResultSet rs;			// SQL결과 조작하는 객체
	
	// 2.생성자
	public Dao() { // 자식객체가 생성되면 부모객체도 같이 생성!!! [ * 객체 생성된다는것은 생성자 호출된다 ]
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb", "root", "1234");
			
		} catch (Exception e) { System.out.println(e); }
	}
}
