console.log('visitlog.js 열림');

// 1. Create ( 저장 )
function vwrite() {
	// 1. HTML input 태그 호출
		// document.querySelector('.vwriter')
	let vwriterInput = document.querySelector('.vwriter'); console.log('vwriterInput : '+ vwriterInput);
	let vpwdInput = document.querySelector('.vpwd'); console.log('vpwdInput : '+ vpwdInput);
	let vcontentInput = document.querySelector('.vcontent'); console.log('vcontentInput : '+ vcontentInput);
	
	// 2. 객체화
		// let 변수명 = { 속성명 : 데이터 , 속성명 : 데이터 }
	let info = {
		vwriter : vwriterInput.value ,
		vpwd : vpwdInput.value ,
		vcontent : vcontentInput.value ,
		
	}; console.log( info );
	// 3. 유효성검사
	
	// 4. AJAX ( HTML에 JQUERY 라이브러리 필수로 호출 )
	$.ajax({
		url : "/jspweb/VisitLogController",
		method : "post",
		data : info,
		success : function f(r){ console.log(r);
			if( r == true){ 
				alert('등록성공');  vread();
				vwriterInput.value = ''; vpwdInput.value = ''; vcontentInput.value = '';
			}
			else{alert('등록실패');}
		},
		error : function f(r){} 
	})
		// 5. 결과에 따른 코드
	
}// f e
 
// 1. Read( 호출 )
vread();
function vread() { // 실행조건 : JS 열릴때 1번 실행 , 등록 , 수정 , 삭제 => 최신화[ 화면 새로고침 ]
	
	$.ajax({
		url : "/jspweb/VisitLogController",
		method : "get",
		data : "" ,
		success : function f(r){ console.log(r) 
		
			// - 응답 받은 객체를 HTML에 출력
			// 1.[어디에] 출력할 구역의 객체 호출
			let output = document.querySelector('.visit_Bottom')
			// 2.[무엇을] 반복문을 이용한 데이터를 HTML 형식으로 만들기
			let html = ``; // 백틱
				// 리스트내 모든 데이터를
				for( let i = 0; i<r.length ; i++){
					// 객체를 HTML형식으로 누적더하기
					html += `<div class="visitbox"> <!-- 방문록 1개의 표시구역 -->
								<div class="visitbox_top">
									<div> ${ r[i].vwriter } </div>
									<div class="visitdate"> ${ r[i].vdate } </div>
								</div>
								<div class="visitbox_center"> ${ r[i].vcontent } </div>
								<div class="visitbox_bottom">
									<button onclick="vupdate(${ r[i].vno })" type="button">수정</button>
									<button onclick="vdelete(${ r[i].vno })" type="button">삭제</button>
								</div>
							</div>`
				}
			// 3.[대입] 출력객체 HTML형식 대입
			output.innerHTML = html;
		},
		error : function f(r){}
	})
	
}// f e

// 1. update( 수정 )
function vupdate( vno) {console.log('Opne:' +vno);
	// 1. 수정할 내용 입력
	let vcontent = prompt('수정할 방문록내용 : ');				// alert(); : 확인알림창 confirm(); : 확인/취소알림창 prompt(); : 알림창에서 입력받기
	// 2.비밀번호가 일치할 경우에도 수정하므로 체크할 확인용 비밀번호 입력받기
	let vpwd = prompt("방문록비밀번호 : ")
	// 수정 준비물 : vno(누구를) , vcontent(어떤내용으로) , vpwd(조건용:비밀번호일치여부)
	$.ajax({
		url : "/jspweb/VisitLogController" , // 통신할 백엔드(컨트롤러 서블릿 주소)
		method : "put" ,
		data : { vno : vno , vcontent : vcontent , vpwd : vpwd } ,
		success : function f(r){ console.log("통신성공");
			if( r == true ){ alert('수정성공'); vread();}
			else{ alert('수정실패] 비밀번호가 일치하지 않습니다. ')}

		} ,
		error : function f(r){ console.log(r); }
		
	})
	
}// f e

// 1. delete( 삭제 )
function vdelete( vno ) {console.log('Opne:' +vno);
	// 1. 비밀번호가 일치할 경우에 수정하므로 확인용 비밀번호 입력받기
	let vpwd = prompt("방문록비밀번호 : ")
	
	// 수정 준비물 : vno(누구를) , vpwd
	$.ajax({
		url : "/jspweb/VisitLogController" ,
		method : "delete" ,
		data : { vno : vno ,  vpwd : vpwd } ,
		success : function f(r){ console.log("통신성공"); 
			if( r == true ){ alert('삭제성공'); vread();}
			else{ alert('삭제실패] 비밀번호가 일치하지 않습니다. ')}
		
		
		} ,
		error : function f(r){ console.log(r); }
		
	})
	
}// f e