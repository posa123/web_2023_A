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


import model.dto.ClientDto;

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
 