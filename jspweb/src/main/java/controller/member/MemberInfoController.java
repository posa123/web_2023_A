package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		String meamil = request.getParameter("meamil");
		String mimg = request.getParameter("mimg");
		// 2. (선택) 객체화
		MemberDto memberDto = new MemberDto(mid, mpwd, meamil, mimg);
		
		
		
		// 3. Dao 에게 전달하고 결과 받는다.
		boolean result = MemberDao.getInstance().signup(memberDto);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
