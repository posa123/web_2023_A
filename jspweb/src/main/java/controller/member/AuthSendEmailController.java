package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmailService;


@WebServlet("/AuthSendEmailController")
public class AuthSendEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AuthSendEmailController() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청하기
		String memail = request.getParameter("memail");
		
		// 1. 인증번호 생성 [ 난수 6자리 ]
		String auth = ""; // 인증번호를 저장할 문자열
		for( int i = 0; i<6 ; i++) {
			Random random = new Random();
			
			auth += random.nextInt(10);
		}; System.out.println("생성된 6자리 난수 : " +auth);
		
		EmailService emailService = new EmailService();
		
		emailService.authsend( memail , auth );
		
		response.getWriter().print(auth);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
