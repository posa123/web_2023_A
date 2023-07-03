/*

	함수 : 미리 정의된 코드의집합
		1.내장함수 : JS언어 기본적으로 사용할수 있는 함수
			1. console.log('하고싶은말')  		: F12개발자도구 console탭 출력되는 함수 [*]
			2. alert('하고싶은말')		   		: 알람 메시지 출력하는 함수
			3. confirm ('하고싶은말' )			: 확인 메시지[확인/취소]	출력하는 함수
			4. prompt ('하고싶은말')			: 입력 메시지 출력하는 함수 
			
		2.정의함수 : 개발자 정의해서 사용하는 함수 	

*/ 
// 1. document 객체 이용한 태그를 객체로 호출
	// querySelector vs 
console.log( document ) 		// 현재 js가 포함된 HTML 문서의 전체
console.log( document.body )	// <body> 호출
console.log( document.head )	// <head> 호출
console.log( document.div )		// <div> 중복 가능한 태그 이므로 제공 x
console.log( document.querySelector('div')) // <div> 태그 호출[]
console.log( document.querySelector('.box1')) // <div> 태그 호출[]
console.log( document.querySelector('#box2')) // <div> 태그 호출[]
console.log( document.querySelectorAll('div')) // 
let div배열 = document.querySelectorAll('div');
console.log( div배열[2] ) // [0] 안녕하세요1 [1]안녕하세요2 [2]안녕하세요3
	// 2. innerHTML 속성 : <태그> innerHTML </태그> 
div배열[2].innerHTML = '안녕하세요3 수정HTML' ;		// = 대입(기존데이터사라짐) += 추가(기존데이터 이어서)
document.body.innerHTML = ''; //body내 모든 html 지우기
document.body.innerHTML += '<h3> 추가HTML </h3> ';
let html = '<p> 변수로 작성한 HTML 형식의 문자열 데이터</p>'; // 모양/형식 은 HTML 이고 자료형/타입 '문자열'
// 자료형/타입 : 숫자형,문자형,논리형,배열,객체,함수
document.body.innerHTML = html;

	// 3. style 속성 : <태그 style="css작성"> </태그>
document.body.style= `background-color : blue; font-size : 20px;`;

	// 4. addEventListener('이벤트명' , 함수 );
	/*
		1. 
			function 함수명(){}
			addEventListener('이벤트명' , 함수 );
		2. - 익명함수[ 이름 이 없는 함수 (인수)=>{실행코드} ]를 이용한 이벤트 추가
			addEventListener('이벤트명' , ()=>{} );
	*/
	/*
		이벤트명
			1. DOMContentLoaded : HTML이 완전히 열렸을때[모두 로드되었을때] 실행되는 이벤트
			2. window.onload	: 해당 객체가 호출 되었을때
			3. 
	*/
	
// 1. HTML이 완전히 열렸을때

document.addEventListener('DOMContentLoaded' , () => { 
	console.log('JS에서 이벤트 실행');
});
// 2. 해당 객체가 호출 되었을때
window.onload = () => { console.log('JS에서 이벤트 실행2'); }

// 3. JS 열렸을때 이벤트 1번 실행
console.log('JS에서 이벤트 실행3');

// 4. 
let p = document.querySelector('p'); console.log(p);

// 5. 
p.addEventListener('click',() =>{
	console.log('p 태그 클릭했다.')
} )

