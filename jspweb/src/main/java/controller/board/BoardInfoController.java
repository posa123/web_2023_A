package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;
import model.dto.MemberDto;

/**
 * Servlet implementation class BoardInfoController
 */
@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BoardInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }
    


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청
		
		// 2. 유효성검사
		
		// 3. DAO
		ArrayList<BoardDto> result = BoardDao.getInstance().getList(); System.out.println(result);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
			
		// 4. 응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
	}
	// 쓰기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 첨부파일 업로드 [ cos.jar -> MultipartRequest]
		MultipartRequest multi = new MultipartRequest(
				request, // 요청방식
				request.getServletContext().getRealPath("/board/upload"),
				1024*1024*1024 ,
				"UTF-8" ,
				new DefaultFileRenamePolicy()); // 만약에 업로드 파일명이 서버내 존재하면(중복) 자동으로 파일명뒤에 숫자 붙이기
		// * 업로드가 잘 되었는지 확인하기 위한 업로드 서버경로 확인
		
		System.out.println(request.getServletContext().getRealPath("/board/upload"));
		// 1. ( 입력받은 매개변수 ) 요청
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		

		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();
		int bcno = Integer.parseInt(multi.getParameter("bcno"));
		// 2. 유효성검사 / 객체화
		BoardDto boardDto = new BoardDto(btitle, bcontent, bfile, mno, bcno); System.out.println( boardDto );
		// 3. Dao 처리
		
		boolean result = BoardDao.getInstance().bwrite(boardDto);
		// 4. 응답
		response.setContentType("application/json; charset=UTF-8"); 
		response.getWriter().print(result);
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
