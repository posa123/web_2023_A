package controller.member;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;
import model.dto.MpointDto;

/**
 * Servlet implementation class PointCotroller
 */
@WebServlet("/PointCotroller")
public class PointCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointCotroller() {
        super();
        // TODO Auto-generated constructor stub
    }
    // 9.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mpno = UUID.randomUUID().toString();	// 포인트내역 식별 번호 구성 [ UUID ]
			// UUID.randomUUID() : (s) UUID 고유성을 보장하는 ID[식별자] 만들기 위한 표준규약
			System.out.println(mpno);
			
		// 2. 로그인된[세션의저장된] 회원정보에서 회원번호만 출력
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		// 3. 포인트 수량 / 지급내역	
		long mpamount = Long.parseLong(request.getParameter("mpamount")) ;
		String mpcomment = request.getParameter("mpcomment");;
		
		// ------Dto
		MpointDto mpointDto = new MpointDto(mpno,mno,mno,mpcomment,null);
		
		// -----DAO
		boolean result = MemberDao.getInstance().setPoint(mpointDto);
		// 응답
		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(result);
		
		
	}

	// 10. 11. -- 하나의 함수에서 2개이상의 기능 처리 type 분류
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 서로 다른 함수/기능 를 실행 하기 위한 분류
		String type = request.getParameter("type");
		
		// -
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		// 2. 분류
		if( type.equals("findByPoint")) {
			long result = MemberDao.getInstance().getPoint(mno);
			json = mapper.writeValueAsString(result);
		}else if(type.equals("findByAll")) {
			List<MpointDto> result = MemberDao.getInstance().getPointList(mno);
			json = mapper.writeValueAsString(result);
		}
		
		response.setCharacterEncoding("UTF-8");;
   		response.getWriter().print(json);
		
		
		
		
	}

	

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
