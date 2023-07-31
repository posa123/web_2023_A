package java1.day13.Ex2.model.dao;

import java.util.ArrayList;

import java1.day13.Ex2.model.dto.BoardDto;

public class BoardDao {
	// 싱글톤(공유)O : 게시물마다 가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() {return boardDao;}
	private BoardDao() {}
	// 게시물 여러개 저장하는곳
		// 1. 배열 
	public BoardDto[] boardDtoArray = new BoardDto[100]; 
		// 2. 리스트 : 배열처럼 쉽게 사용할수 있도록 *다양한 함수 제공
	public ArrayList<BoardDto> boardDtoList = new ArrayList<>();
		// ArrayList : 배열처럼 사용가능한 클래스 객체 선언
			// <클래스> : 리스트안에 여러개 객체를 저장할 객체타입
				// boardList : 리스트객체변수명
		
	

}
