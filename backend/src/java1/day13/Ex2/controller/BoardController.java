package java1.day13.Ex2.controller;

import java1.day13.Ex1.Board;
import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class BoardController {
	
	// 싱글톤(공유)O : 게시물마다 가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() { return boardController; }
	private BoardController() {}
	
	// 글쓰기 처리 기능할수[ C ]
	public boolean writeLogic( String content , String writer ) {
		
		// 1. 매개변수로 부터 전달 받은 content , write 를 하나의 객체로 선언
		BoardDto boardDto = new BoardDto(content , writer);
		// 2. 객체를 배열에 저장 [ 빈공간을 찾아서 빈공간 저장 ]
		for( int i=0; i<BoardDao.getInstance().boardDtoArray.length; i++) {
			if( BoardDao.getInstance().boardDtoArray[i] == null) {
				BoardDao.getInstance().boardDtoArray[i] = boardDto;
			}
		}
		// 2. 객체를 리스트에 저장 .add( 저장할객체명 );
		BoardDao.getInstance().boardDtoList.add(boardDto);	
		
		// 3. 성공[true] 또는 실패[false]
		return true;
		
	}
	// 글출력 처리 기능함수[ R ]
	public BoardDto printLogic( int index ) {
		// 1. 리스트 안에 있는 객체 호출 .get( 인덱스 ) : 해당 인덱스의 객체 호출
		BoardDto boardDto = BoardDao.getInstance().boardDtoList.get(index);
		return boardDto;
	}	
	// 글수정 처리 기능함수[ U ]
	public boolean updateLogic( int index , String content , String writer) {
		// 1. 입력받은 인덱스의 게시물을 호출해서 새로운 입력받은 값으로 대입
		BoardDao.getInstance().boardDtoList.get(index).setContent(content);
		BoardDao.getInstance().boardDtoList.get(index).setWriter(writer);
		
		return true;
	}
	// 글삭제 처리 기능함수[ D ]
	public boolean deleteLogic( int index ) {
		// 1. 리스트 안에 있는 객체 삭제 .get(인덱스)
		BoardDao.getInstance().boardDtoList.remove(index);
		// 2. 삭제 여부 반환
		return true;
	}
}
