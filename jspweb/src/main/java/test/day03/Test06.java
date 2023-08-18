package test.day03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test06")
public class Test06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Test06() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("[JS]통신 보내옴..");
		// 1. 요청 request
		String value1 = request.getParameter("value1"); // ajax data속성의 객체내 value1 속성의 값을 요청
			System.out.println("[JS]AJAX가 보내온 데이터 : " +value1 );
		// 2. 응답 response
		response.getWriter().print(true);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
