console.log('JS실행')
let boardlist = []
// * JS열렸을때 최초 1번 실행
onPrint()
function onwirte(){ console.log('등록함수실행')
	
	let name = document.querySelector('#name').value;
	let pw = document.querySelector('#pw').value;
	let title = document.querySelector('#title').value;
	let content = document.querySelector('#content').value;

		// 날짜 모양으로 출력
		let now = new Date(); // 1. 현재 시스템(pc)의 날짜/시간 호출
		let year = now.getFullYear(); 	console.log('yeat : ' +year) 		// 현재 연도
		let month = now.getMonth(); 	console.log('yeat : ' +month)		// 현재 월 0~11[ 0:1월] 
		let week = now.getDay(); 		console.log('yeat : ' +week)		// 현재 요일 0~6 [ 0:일요일 ]
		let day = now.getDate(); 		console.log('yeat : ' +day)			// 현재 일
		let hour = now.getHours(); 		console.log('yeat : ' +hour)		// 현재 시
		let minute = now.getMinutes();  console.log('yeat : ' +minute)		// 현재 분
		let second = now.getSeconds();  console.log('yeat : ' +second)		// 현재 초

	// 2. 게시물1개당 = 객체1개 선언/만들기 = 각 input로 입력받은 값들을 각 속성명별로 대입해서 객체 생성
	let board = { name : name , 
					pw : pw , 
					title:title, 
					content:content ,
					date : `${now.getFullYear()}년 ${ now.getMonth()+1}월 ${ now.getDate()}일` ,
					view : 0
				}
	console.log( board ) ; //board 생성 확인
	
	//-------------- 등록전에 유효성검사 ----------------//
	
	//---------------------------------------------//
	
	//3. 현재 { } 안에서 선언된 board 는 } 끝나면 사라짐[지역변수] ---> 전역변수/배열에 저장하자
	boardlist.push(board); console.log( boardlist ); // 배열 확인
	
	//* 새로운 게시물이 등록되었으니까 게시물 출력 화면 업데이트
	onPrint()
}

// 2. 출력함수 [ 실행조건 : 1.JS열렸을때 2.등록했을때 3.삭제했을때 4.수정했을때 5.조회수증가할때]

function onPrint(){console.log('onPrint함수실행')

	// 1. 어디에 출력할건지
	let boardTable = document.querySelector('#boardTable')
	
	// 2. 테이블 무엇을 대입/출력할건지 객체에 정보들을 객체 1개당 한줄씩<tr> 출력
	let html = `<tr> <th> 번호 </th> <th> 제목 </th> <th> 작성일 </th> <th> 조회수 </th> </tr>`
	// 3. 대입
	boardTable.innerHTML = html
	// 배열내 순차적으로 하나씩 열어보자
	for( let i=0 ; i<boardlist.length ; i++){
	let board =boardlist[i];	// i번째 배열 인덱스의 객체 호출
		html += ` <tr>
					<td> ${ i+1 } </td>
					<td onclick="onView( ${ i })"> ${ board.title } </td>
					<td> ${ board.date } </td>
					<td> ${ board.view } </td>
				 </tr>`
	
	}
	
	// 3. 대입
	boardTable.innerHTML = html

}
function onView( index ){ console.log('onView()함수' +index)
	let viewbox = document.querySelector('#viewbox')
	
	
	let board = boardlist[index] //인수로 전달받은 인덱스의 객체를 1개 꺼내기
	let html = `<div> 제목 : ${board.title} </div>
				<div> 내용 : ${board.content} </div>
				<div> 작성자 : ${board.name} </div>
				<button>수정</button>
				<button onclick="onDelete(${ index })">삭제</button>`
	
	viewbox.innerHTML = html
	
	// 조회수 증가(JS변경) 하고 화면 새로고침(HTML변경)
	board.view++; onPrint();
}
function onDelete( index ){ console.log('onDelete()함수' +index)
	// 1. 삭제할 인덱스의 객체 호출
	let board = boardlist[index];
	
	// 2. prompt() 함수로 입력받은 값을 password 변수에 저장
	let password = prompt('비밀번호 : ')
	
	// 3. 비교 [ 삭제할 객체내 비밀번호와 입력받은 비밀번호와 일치하면 삭제 성공 ]
	if( board.pw == password){
		boardlist.splice( index , 1 );
		onPrint();
		document.querySelector('#viewbox').innerHTML = `` // 현재 삭제된 개별 게시물 출력 화면 없애기
		alert('[삭제성공] 게시물이 삭제 되었습니다.')
	}else{
		alert('[삭제실패]비밀번호가 일치하지않습니다.')
	}
	
}