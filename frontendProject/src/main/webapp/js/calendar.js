console.log('calendar.js')

// 0 . 현재 연도/월 [초기값]
	// new Date() : 현재 날짜/시간 반환해주는 클래스
	// new Date( 연도 , 월 , 일 ) : 사용자 정의 날짜 반환해주는 클래스
let year = new Date().getFullYear();	// 현재 연도
let month = new Date().getMonth()+1;	// 현재 월[ 0~11 ] +1
console.log( year ); console.log( month );

// 1. 현재 연도/월 기준으로 달력 출력 하는 함수
calPrint();
function calPrint(){
	// 1. 현재 연도와 월 을 해당 구역에 출력하기
	document.querySelector('.caldate').innerHTML = `${year}년 ${month}월`;
	// 1. 요일 과 일 출력
		/*
			1.시작요일
			2.현재 월 마지막 일
		*/
	// 현재 보고 있는 캘린더의 날짜 
	let now = new Date( year , month-1 , 1 );
	let sWeek = now.getDay(); console.log( sWeek );
	let now2 = new Date( year , month , 0);
	let eDay = now2.getDate(); console.log(eDay);
	
	let calendar = document.querySelector('.calendar');
	let html = '';
		html+=`			<div class="weak sunday"> 일 </div>
			<div class="weak"> 월 </div>
			<div class="weak"> 화 </div>
			<div class="weak"> 수 </div>
			<div class="weak"> 목 </div>
			<div class="weak"> 금 </div>
			<div class="weak"> 토 </div>`
	// **** 현재 달력 1일의 요일까지 공백 출력
	for( let b = 1 ; b<=sWeek ; b++){ // 1부터 1일의요일까지 공백 구역 출력
		html+=`<div></div>`
	}
	// 2. 일수
	for( let day = 1 ; day<=31 ; day++){
		html+=`<div onclick="openModal()">${day}</div>`
	}
	calendar.innerHTML = html;
}
// 2. 버튼을 클릭했을때 현재 월 변화해주는 함수
function onNext( check ){
	console.log(check)
	if( check == 0 ){
		month--; // 현재보고있는 월 1차감
		//만약에 월이 차감했는데 1보다 작아지면 12월 변경하되 연도 1차감
			// 2023년도 1월 --> 1차감 --> 2022년 12월
			if( month < 1 ){ month=12; year--; }
	}else if( check == 1 ){
		month++; // 현재보고있는 월 1증감
		if( month > 12 ){month = 1; year++; }
	}
	// 2. 월 증감후 새로고침
	calPrint();
}
// 3. 모달 열기 // 날짝 클릭했을때
function openModal(){
	document.querySelector('.modalwrap').style.display = 'flex';
}
// 4. 모달 닫기 // 닫기 버튼 클릭했을때
function closeModal(){
	document.querySelector('.modalwrap').style.display = 'none';
}





















