/*
       조건 : 반복문X 입력:prompt 출력 : console 
       문제 1 : 2개의 정수 를 입력받아서 가장 큰수를 출력 
       문제 2 : 3개의 정수 를 입력받아서 가장 큰수를 출력     [ max 함수 x ]
       문제 3 : 4개의 정수 를 입력받아서 가장 큰수를 출력    [ max 함수 x ]
       
       문제 4 : 3개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
       문제 5 : 4개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
       
       문제 6 : 점수를 입력받아 점수 90점이상 합격 출력 아니면 탈락 출력 
       문제 7 : 점수를 입력받아 점수 90점이상 A등급 출력 
                            80점이상 B등급 출력 
                            70점이상 C등급 출력  
                            그외 재시험
       문제 8 : 아이디와 비밀번호 입력받기 
             회원아이디가 admin 이고 비밀번호가 1234 이면 로그인 성공 출력 
                                     아니면 로그인실패 출력
 */
//문제1
	// 1. 2개 입력받아 각 변수에 저장
		// 1. 첫번째 값을 입력받기
		// 2. 입력받은 값을 변수에 저장 num1
		// 3. 두번째 값을 입력받기
		// 4. 입력받은 값을 변수에 저장 num2
		// 5. 가장큰수?? 비교/논리/조건/판단 => 연산자
		// 6. >= <= > < 연산자 선택
		// 7. if 이용한 출력
let num1= Number(prompt('정수1입력 : '));
let num2= Number(prompt('정수2입력 : '));
	//2. if 이용한 논리제어
if( num1 > num2 ){ console.log( num1 ) }
else if(num1 < num2) {console.log(num2) }
else{ console.lof('같다')}
//문제2
let num3= Number(prompt('정수1입력 : '));
let num4= Number(prompt('정수2입력 : '));
let num5= Number(prompt('정수3입력 : '));
let max1 = num3

if( max1 < num4 ){ max1 = num4 }
if( max1 < num5 ){ max1 = num5 }
console.log( max1 )
//문제3 
let num6= Number(prompt('정수1입력 : '));
let num7= Number(prompt('정수2입력 : '));
let num8= Number(prompt('정수3입력 : ')); 
let num9= Number(prompt('정수4입력 : '));
let max2 = num6
if ( max2 < num7 ){ max2 = num7}
if ( max2 < num8 ){ max2 = num8}
if ( max2 < num9 ){ max2 = num9}
console.log( max2 )

//문제4
let int1= Number(prompt('정수1입력 : '));
let int2= Number(prompt('정수2입력 : '));
let int3= Number(prompt('정수3입력 : '));
// 정렬 = 하나씩 비교 해서 자리 교체
	// 만약에 첫번째 값이 두번째 값보다 크면
if( int1 > int2 ){ //조건 1 : > 오름차순 < 내림차순
	// *스왑/교체
	let temp1 = int1 ;//1. 임시변수에 3 저장
	int1 = int2; // 2. 3있던 변수에 5 저장
	int2 = temp1; // 3. 5있던 변수에 3저장
}
if( int1 > int3 ){ // 조건2
	let temp1 = int1;
	int1 = int3;
	int3 = temp1;
}
if( int2 > int3){ // 조건3
	let temp1 = int2;
	int2 = int3;
	int3 = temp1;
}
console.log( int1 + '' +int2+ '' +int3)
//문제5


// 문제 6 : 점수를 입력받아 점수 90점이상 합격 출력 아니면 탈락 출력

let score = Number(prompt('점수 : ')) // 1.입력받은 값을 변수에 저장
if( score >= 90){ console.log('합격')}
else{ console.log ('탈락') }


/*
문제 7 : 점수를 입력받아 점수 90점이상 A등급 출력 
                            80점이상 B등급 출력 
                            70점이상 C등급 출력  
                            그외 재시험
*/
if( score >= 90){console.log('A등급'); }
else if( score >= 80){console.log('B등급'); }
else if( score >= 70){console.log('c등급'); }
else{ console.log('재시험'); }
/*문제 8 : 아이디와 비밀번호 입력받기 
회원아이디가 admin 이고 
비밀번호가 1234 이면 로그인 성공 출력 
아니면 로그인실패 출력
*/
let id = prompt('아이디 : ')
let pw = prompt( '비밀번호 : ')
// 만약에 입력받은 id가 저장된 변수가 'admin' 문자열과 같으면
// ctrl+shift+f 코드 탭 간격 자동맞춤 ( 이클립스 )
if( id == 'admin' ){
	//true [참]
	if( pw == '1234'){ //비밀번호일치하면
		// true[참]
		console.log('[로그인성공] 안녕하세요.')
	}
	else{ //비밀번호 일치하지 않으면
		console.log('비밀번호가 일치하지않습니다.')
	}
}
else{ // false [거짓]
	console.log('없는 아이디 입니다.')
}





