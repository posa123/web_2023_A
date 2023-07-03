
// 누구를~~
// 1. 조작/제어할 HTML 태그 DOM객체 호출
let userbox = document.querySelector('.userbox')

// 유저 위치 = x 좌표
let u_left = 50;

// 어떻게~~ : 페이제전체(body)키보드를 누를때 = keydown
	// DOM객체명.addEventListener('이벤트명' , ()=>{ })
document.body.addEventListener('keydown' , (e)=>{
	console.log('키눌림')
	// 1. 눌린 키 상태 확인 e.keyCode
	console.log( e ); // keydown 이벤트 상태 객체
	// 2. 만약에 왼쪽/오른쪽 키를 눌렀을때 css left 변경
	if( e.keyCode == 37 ){
		console.log('왼쪽으로 이동'); // css left 차감
		u_left -= 10; // 10 차감
		// * 유효성 검사 [배경 밖을 못나가게]
		if( u_left < 0 ){ u_left = 0 }; // 만약에 위치가 0보다 작아지면 0으로 고정
	}else if( e.keyCode == 39 ){
		console.log('오른쪽으로 이동'); // css left 증가
		u_left += 10; // 10 증가
		if( u_left > 900 ){ u_left = 900 }; // 만약에 위치가 930보다 
		userbox.style.backgroundImage = `url(img/캐릭터2.png)`; // 배경변경 // 이동 이미지 출력
	}else if( e.keyCode == 65){ // a키 눌렀을때
		console.log('공격');
		userbox.style.backgroundImage = `url(img/캐릭터_공격.png)`; // 공격 이미지 출력
	}
	// 3. 현재 위치값을 대입
	userbox.style.left = `${u_left}px`
	// 확인
	console.log( userbox.style.left );
}) 

// 2. 키 누르고 떼었을때. = keyup
document.body.addEventListener('keyup' ,(e)=>{ 
	// 원래 기본 이미지 변경
	userbox.style.backgroundImage = `url(img/캐릭터1.png)`;
})