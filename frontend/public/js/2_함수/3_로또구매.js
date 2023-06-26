console.log('js 실행')
// * 선택된 번호를 저장하는 배열
let 선택번호목록 = []
let 추첨번호목록 = []
// 1. 로또 구매 함수 정의 [ 실행조건 : 로또구매 버튼 클릭시 ]
function 로또구매(){
	console.log('로또구매() 실행');
	// 1. 1~45개의 button 생성
	let buttonHTML = ``;
	for( let i = 1 ; i<=45 ; i++){ // for s
		//i는 1부터 45까지 1씩증가 반복
		//버튼 하나씩 변수에 추가
		buttonHTML += `<button onclick="숫자버튼( ${ i })" > ${ i } </button>` // i 번쨰 버튼생성
										// i로 출력된 숫자(1~45 사이 1개) 중 클릭된 숫자를 숫자버튼함수()에게 전달
		// 만약에 i가 5의 배수이면
		if(i % 5 == 0) buttonHTML+= '<br/>'
	} //for end
	// 2. for에서 생성된 45개 버튼을해당 div에 대입
	document.querySelector('.버튼목록구역').innerHTML = buttonHTML;
} // F END
// 2. 숫자 (선택) 버튼 [ 실행조건 : 1~45 중 1개의버튼 클릭시 ]
function 숫자버튼( 선택된번호 ){
	console.log(선택된번호 + '을 숫자버튼을 클릭했군요.')
	// < push > 배열에 저장하기전에 유효성검사 
	// 1. 중복검사 = 배열명.indexOf
	if( 선택번호목록.indexOf( 선택된번호 ) != -1 ){ // -1 : 동일한 데이커가 배열내 없음 뜻
											// != -1 : 배열내 존재하면
		alert(' 이미 선택된 번호 입니다.[해당 숫자는 취소 합니다.] '); // 안내문구
		// * 취소기능 : 배열내 해당 인덱스의 데이터 제거
		선택번호목록.splice( 선택번호목록.indexOf(선택된번호) , 1); //선택된번호 인덱스 1개 삭제
		선택번호출력(); // 삭제후 배열 상태 출력함수
		return; // 함수 강제 종료
	} //if end
	
	// 2. 6개 초과인지 검사 = 배열명.length : 배열내 데이터 총개수/길이
	if( 선택번호목록.length == 6 ){
		alert(' 이미 6개 번호 모두 선택하셨습니다.');
		return; //  함수 강제 종료 // return 안했을경우 아래코드 실행
	}//if end
	
	// * 배열에 저장 ( 2개의 유효성검사를 모두 통과했을때 배열에 저장 )
	선택번호목록.push( 선택된번호 ); console.log( 선택번호목록 )
	선택번호출력(); // 추가후 배열 상태 출력함수
}// fend

// 3. 선택된 번호들 출력 하는 함수 [ 실행조건 : 배열에 변화가 있으면(1.추가 / 2.삭제 / 3.수정)]
function 선택번호출력(){
	document.querySelector('.선택번호출력구역').innerHTML = 선택번호목록;
	if( 선택번호목록.length == 6){
		document.querySelector('.추첨결과버튼구역').innerHTML =
										`<button onclick="추첨결과()">추첨결과보기 </button>`
	}
	// 모두 선택 안했으면
	else{
		document.querySelector('.추첨결과버튼구역').innerHTML = ``
	}
}
// 4. 추첨 결과 함수
function 추첨결과(){
	alert('로또 추첨 진행 합니다. [ 잠시 대기 ]");
}











