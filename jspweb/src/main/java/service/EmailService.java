package service;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





public class EmailService {
	
	// 1. 필드
	private String fromEmail = "";
	private String fromEmailPwd="";
	
	// 2. 생성자
	public EmailService(  ) { }
	
	// 3. 메소드
	public boolean authsend(String toEmail , String contentHTML) {
		
		// 1. 호스팅 설정[ 네이버 기준 ]
		Properties Properties = new Properties();// Properties : 키와 값으로 구성된 map 컬렉션 중하나. [ 설정 관련된 데이터 객체화 ]
		Properties.put( "mail.smtp.host" , "smtp.naver.com");
		Properties.put( "mail.smtp.port" , 587 );
		Properties.put( "mail.smtp.auth", true);
		Properties.put( "mail.smtp.ssl.protolcols","TLSv1.2") ;
		
		// 2. 인증처리 [ 네이버 에 보내는사람의 정보가 맞는지 ]
			// 1. Authenticator 인증할 객체
		Authenticator authenticator = new Authenticator() {
			// 패스워드 검증 함수 [ 구현 ]
			protected PasswordAuthentication  getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail , fromEmailPwd );
			}
			
		};
		Session session = Session.getDefaultInstance( Properties , authenticator );
		
		
		
		try {
			MimeMessage message = new MimeMessage( session );
			message.setFrom( new InternetAddress(fromEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress( toEmail ));
			message.setSubject("Ezen JSP회원가입 인증코드 발송");
			message.setText("안녕하세요. 이메일 인증코드 : " +contentHTML);
			Transport.send(message);
			return true;
		} catch (Exception e) { System.out.println(e); }
		return false; // 메일 전송 실패
	}
}
