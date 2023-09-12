package controller.chatting;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDto;
import model.dto.MsgDto;

@ServerEndpoint("/ServerSocket/{mid}")
public class ServerSocket {
	
	// 0. 접속된 클라이언트소켓들의 저장소
	public static List< ClientDto > clientList = new ArrayList<>();
	
	
	// 1. 클라이언트소켓으로부터 접속받았을때.
	@OnOpen
	public void onOpen( Session session , @PathParam("mid") String mid ) {
		System.out.println("클라이언트 소켓이 입장했습니다." +session );
		System.out.println("접속한 회원아이디: "+mid);
		
		ClientDto clientDto = new ClientDto(session , mid);
		clientList.add(clientDto);
		System.out.println("접속된 클라이언트들 : " + clientDto);
	}

	// 2.
		@OnError
		public void onError( Session session , Throwable throwable ) { }
		// 3. 클라이언트소켓 과 서버소켓이 연결이 끊겼을때.
		@OnClose
		public void onClose( Session session ) { 
			// * 접속목록에서 세션 제거 
			for( ClientDto clientDto : clientList ) { // 접속목록에서 연결이 끊긴 세션 찾기 
				if( clientDto.getSession() == session ) {
					// 클라이언트소켓의 세션과 연결이 끊긴 세션과 같으면 해당 dto를 제거하기.
					clientList.remove( clientDto );
					break;
				}
			}
		}
		// 4. 
		@OnMessage	// 매개변수 : 1. 메시지를 보낸 클라이언트소켓(세션) 2.메시지 내용 [문자열]
		public void onMessage( Session session , String msg ) throws Exception { 
			System.out.println( "보낸 클라이언트소켓[누가] : " + session +"      보낸 내용[무엇을] : " + msg  );
			
				// 2-2 메시지를 보낼 내용 구성. [ 보낸사람 , 보낸내용 ]
			MsgDto msgDto = null;
					// - 보낸사람 찾기 [ 보낸 세션 을 이용한 보낸 mid 찾기 ]
					for( ClientDto clientDto : clientList ) {
						if( clientDto.getSession() == session ) {
							// 회원목록중에 보낸세션과 일치하면 보낸사람mid와 내용으로 dto 구성 
							msgDto = new MsgDto(  clientDto.getMid()  , msg);
							break;
						}
					}
					// - msgDto를 JSON 사용할수 있도록 형변환
			ObjectMapper objectMapper = new  ObjectMapper();
			String jsonMsg = objectMapper.writeValueAsString(msgDto);
					
			// 2-1 받은 메시지를 접속된 회원들에게 모두 전송 
			for( ClientDto clientDto : clientList ) { // 회원목록에서 하나씩 회원 꺼내기 
				clientDto.getSession().getBasicRemote().sendText( jsonMsg ); // 예외처리 필수!!
			}
		} 
	
}
/*
	
	* WebSocket 서버 소켓 라이브러리 제공
		1. 서버소켓 클래스 생성
		@OnOpen
			public void onOpen( Session session ) { }
				- Session : 서버소켓의 접속된 클라이언트소켓 정보
		@OnClose
		@OnError
		@OnMessage
  
  
  
 */
 