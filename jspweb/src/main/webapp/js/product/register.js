

function register2(){
	
	let registerForm1 = document.querySelectorAll('.registerForm1')[0];
	let formData = new FormData( registerForm1 );
	
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method : "post",
		data : formData,
		contentType : false ,			
		processData : false ,
		success : r => { console.log(r) }
	})
} // f end

// 2. 드래그 앤 드랍
	// 1. 드래그 앤 드랍 할 구역 dom객체 호출
let fileDropBox = document.querySelector('.fileDropBox');

	// 2. 해당 dom객체에 구역내 드래그가 들어왔을때.
fileDropBox.addEventListener( "dragenter" , (e)=>{ 
	e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트 우선 점유 
	console.log( '드래그가 들어왔어' );
	
} );
	// 3. 해당 dom객체에 구역내 드래그가 올라왔을때.
fileDropBox.addEventListener( "dragover" , (e) => {
	e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트 우선 점유
	console.log( '현재구역에 드래그가 위치중.' )
	fileDropBox.style.backgroundColor='#e8e8e8';
});
	// 4. 해당 dom객체에 구역내 드래그가 나갔을때
fileDropBox.addEventListener( "dragleave" , (e) => {
	e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트 우선 점유
	console.log(' 드래그가 나갔을때.' )
	fileDropBox.style.backgroundColor='#ffffff';
});
	// 5. 해당 dom객체에 구역내 드래그가 
fileDropBox.addEventListener( "drop" , (e) => {
	console.log( '해당 드래그가 드랍했어.' );
	console.log(e);
	// * 브라우저 자체적으로 'drop' 이벤트 우선적으로 실행되므로 해당 이벤트실행 불가능
	// - 해결방안 : 기존 상위(브라우저) 이벤트 무시
	e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트 우선 점유
	
	// -------------- 드랍된 파일의 정보??? ----------------- //
		// 1. 드랍된 데이터 정보를 이벤트 결과에서 찾기
		console.log( e.dataTransfer )
		console.log( e.dataTransfer.files )
		console.log( e.dataTransfer.files[0] )
		console.log( e.dataTransfer.files[0].name )
		
});






/*
	dom객체 이벤트 추가하는 방법 2가지 .
		가정 : 특정 구역에 클릭(onclick) 이벤트 추가
		1. <button onclick="" type="button"> </button>
		
		2.	.addEventListener( '이벤트명' , 함수 ) : 사용하는 방법
			let button = document.querySeletor('button');
			button.addEventListener('onclick' , 함수);	




	드래그 앤 드랍 관련 이벤트
		1. dregenter
	
*/