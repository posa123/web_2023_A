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
		sucess : function f(r){ console.log(r)},
		error : function f(r){} 
	})
		// 5. 결과에 따른 코드
	
}// f e
 
// 1. Read( 호출 )
function vread() {
	
}// f e

// 1. update( 수정 )
function vupdate() {
	
}// f e

// 1. delete( 삭제 )
function vdelete() {
	
}// f e