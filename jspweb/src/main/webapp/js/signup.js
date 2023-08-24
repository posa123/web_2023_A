
/* onchange : 포커스(커서) 변경될때 */
/* onkeyup : 키보드에서 키를 누르고 떼었을때 */
/* onkeydown : 키보드에서 키를 눌렀을때 */

/*
	정규표현식 : 문자열에 특정 규칙/패턴 집합 표현할때 사용되는 언어
		문법
			/^ : 정규표현식 시작 알림.
			$/ : 정규표현식 끝 알림.
			[a-z]	: 소문자 a-z 패턴 검색
			[A-Z]	: 대문자 A-Z 패턴 검색
			[0-9] 	: 숫자 0~9 패턴 검색
			[가-힣]	: 한글 패턴
			{ 최소길이 , 최대길이 } : 문자열 길이 패턴
			
			
			예시]
				1. [a-z]			: 소문자a-z 검색
				2. [a-zA-Z]		 	: 영문(대,소) 검색
				3. [a-zA-Z0-9] 		: 영문 + 숫자 조합 검색
				4. [a-zA-Z0-9가-힣] 	: 영문 + 숫자 + 한글 조합 패턴
				5. [ac]				: a와c 패턴
			1. /^[a-z0-9]{5,30}$/	: 영문(소) + 숫자 조합 5~30글자 패턴
			
		패턴 검사
			"패턴".test( 검사할데이터 ) 	: 해당 데이터가 해턴에 일치하면 true/ 아니면 false
 */

// 1. 아이디 유효성검사.
function idcheck(){ /* 실행조건 : 아이디 입력창에 입력할때마다 */
	
	// 1. 값 호출
	let mid = document.querySelector('.mid').value;
	let idcheckbox =document.querySelector('.idcheckbox')
	// 2. 유효성검사
		// 제어문 이용한 검사 if( mid.length < 5 && mid.length >= 30 ) {}
		// 1. 아이디는 영문+숫자 조합의 5~30글자 사이 이면
			// 1. 정규표현식 작성.
		let midj = /^[a-z0-9]{5,30}$/
			// 2. 정규표현식 검사.
			console.log(midj.test(mid))
		if(midj.test(mid)){ // 입력한 값이 패턴과 일치하면
			// -- [아이디중복검사]입력한 아이디가 패턴과 일치하면
			$.ajax({
				url : "/jspweb/MemberFindController" ,
				method: "get" ,
				data : { mid : mid },
				success : r => {
					if( r ){
						idcheckbox.innerHTML='사용중인 아이디 입니다.'
					}else{ idcheckbox.innerHTML = '사용가능한 아이디 입니다. '}
				} ,
				error : e => {}
			})
			
		}else{ // 입력한 값이 패턴과 일치하지 않으면
			idcheckbox.innerHTML ='영문(소문자)+숫자 조합의 5~30글자 가능합니다.'
		}
		
	// 3. 결과 출력
	
	
}




// 1. 회원가입 메소드
function signup(){
	// 1. HTML에 가져올 데이터의 tag객체호출 [DOM객체 : html 태그를 객체화]
	let midInput = document.querySelector('.mid');
	let mpwdInput = document.querySelector('.mpwd');
	let mpwdconfirmInput = document.querySelector('.mpwdconfirm');
	let meamilInput = document.querySelector('.meamil');
	let mimgInput = document.querySelector('.mimg');
	
	
	// 2. (객체화)
	let info ={
		mid : midInput.value,
		mpwd : mpwdInput.value,
		meamil : meamilInput.value,
		mimg : mimgInput.value
	}
	// 3. 유효성검사
	
	
	
	
	// 4. AJAX메소드를 이용한 JAVA와 통신
	$.ajax({
		url : "/jspweb/MemberInfoController" ,
		method :"post",
		data : info,
		success : r => { 
			
			if( r == true ){
				console.log('회원가입 성공');
			}else{
				console.log('회원가입 실패');
			}
			
		},
		error : e => {console.log('통신실패')}
	})	
		// 5. Servlet 의 응답에 따른 제어
}