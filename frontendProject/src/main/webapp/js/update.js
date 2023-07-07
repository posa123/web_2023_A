console.log( 'update.js 실행' )

// 1. 썸머노트 실행할때 사용되는 코드
&(document).ready(function(){
	//$('#summernote').summernote({설정객체});
	$('summernote').summernote({
		lang : 'ko-kr', // 한글 적용
		height : 500 ,
		placeholder : '여기에 내용작성'
	});	
});
// 2. 수정/삭제 할 게시물 = 클릭된 게시물 = 현재 보고있는 게시물 [ 게시물 번호는 = 세션 ]
let no = sessionStorage.getItem( 'no' ); console.log(no);
let boardList = JSON.parse(localStorage.getItem('boardList'));


// 2 . 수정할 게시물을 출력
function onView(){
	let title = document.querySelector('.title')
	let content = document.querySelector('#summernote')
	
	for( i=0 ; i<boardList.length ; i++){
		let b = boardList[i]
		if( b.no == no ){
			title.value=b.title
			content.value=b.content
			break;
		}
	}
}
//3. 수정 함수 [ 실행조건 : 등록 버튼을 클릭했을때]
function onUpdate(){
	
}