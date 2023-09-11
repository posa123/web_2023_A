
// *ajax(기본값 비동기통신) 가 응답의 결과를 가지고 오기전에 아래코드 실행. [ loginState 변경되기전에 실행되므로 문제발생 ]
// - 해결방안 ajax 동기화 통신 하자..
// 1. 비 로그인시 입장 불가능..
if( loginState == false ){ alert('회원전용 페이지입니다.'); location.href="/jspweb/member/login.jsp"}

// 2. JS 클라이언트[유저] 소켓 만들기
console.log('채팅방에 입장한 아이디 : ' +loginMid )
let clientSocket = new WebSocket(`ws://localhost:80/jspweb/ServerSocket/${loginMid}`);
	// - 클라이언트소켓이 생성되었을때 자동으로 서버소켓에 접속 -----> 서버소켓의 @OnOpen
	// - 서버소켓URL에 매개변수 전달하기 [- 주로 식별자 전달 ] 서버소켓URL/데이터
	
	
// ----------------------------------------------------------------------------------------------------------- //

/*
	
	JS[ HTML파일 종속된 파일 - HTML 안에서 실행되는 구조 ]
	
	* 
		클라리언트 : 사용 데이터 요청하는 PC
		서버 : 데이터 제공하는 PC
	* URL[주소] 상의 매개변수 전달하는 방법
		1. 쿼리스트링 방식 : URL?매개변수1=데이터1&매개변수2=데이터2&매개변수3=데이터3
		2. 경로매개변수 : URL/데이터1/데이터2/데이터3
		
	* 소켓이란.
		- 통신의 종착점[데이터가 전달되는 위치 -받는사람 -보낸사람]
		
		[클라이언트소켓]							[서버소켓]
		JS=강호동집									우체국
			안산시 상록구[소켓]							
			
		JS=신동엽집									
			수원시 영통구[소켓]
			
	* WebSocket 웹소켓 라이브러리
		- 소켓 관련된 함수들을 제공하는 클래스
		
	* 동기화 VS 비동기화
	
	동기화								비동기화
	
	Client			Server				Client				Server
	
		------요청1----->					------요청1----->					
		
		<-----응답1-----						<-----응답1-----

*/














/*
// 1. 클라이언트 소켓 만들기
	
	// 1. JS웹소켓 객체 [ WebSocket 클래스 ]
		// new WebSocket('ws://ip주소:포트번호/프로젝트명/서버소켓 URL')
	let 클라이언트소켓 =  new WebSocket('ws://localhost:80/jspweb/ChattingSocket'); console.log(클라이언트소켓)
		// 2. onopen , onclose , send , onmessage
		
		// 내가 만든 함수를 클라이언트소켓 속성 대입
		클라이언트소켓.onmessage = (e) => onmsg(e);
	
	
	// 2. 연결된 서버소켓에게 메세지 보내기
function msgsend(){
	// 1. input 입력된 값 가져오기
	let msg = document.querySelector('.inputcontent').value;
	// 2. 클라이언트소켓 .send();
	클라이언트소켓.send(msg); // input에서 입력받은 데이터를 보내기
	
	// 3.
	document.querySelector('.inputcontent').value = '';
	
	
} // f end

// 3. 연결된 서버소켓으로 부터 메시지를 받았을때.
function onmsg(e){ 
	console.log(e) 
	console.log(e.data);
	
	document.querySelector('.contentbox').innerHTML += `<div> ${e.data}</div>`
	
	}
*/

/*
	1. AJAX
		
		발신자(보내는사람) 	: AJAX		요청
		수신자(받는사람) 	: 서블릿		응답
	
		 
		JS							JAVA[서블릿]
		
		
		AJAX
					rest			get
									post
									put
									delete
									
	2. (웹) 소켓
		소켓 : 통신의 종착점[도착위치]
		- 전체조건 : 서버가 클라인트 
		
		JS							JAVA
		[클라이언트소켓]				[서버소켓]
		websocket				

*/ 
