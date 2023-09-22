function setPoint( mpamount , mpcomment ){
	if( loginState == false ) { return; }
	let returnData = false;
	
	$.ajax({
		url : "/jspweb/PointCotroller",
		method : "post" , 
		async : false , /* ajax가 응답이 올떄까지 대기상태 = 동기식 , 반대말 */
		data : { mpamount : mpamount , mpcomment : mpcomment },
		success : result => { console.log(result); 
			returnData = result;
			
		},
		error : e => { console.log(e) }
		
	})
		 
	return returnData;
}

// 2. 내 포인트 확인 함수
function getPoint(){
	if(login == false ) { return; }
	$.ajax({
		url : "/jspweb/PointCotroller" ,
		method : "get" ,
		data : { type : 'findByPoint' } ,
		success : result => { console.log (result) } ,
		error : e => { console.log(e) }

		
		
	})

	
}

// 3. 내 포인트 내역 전체 출력 함수
function getPointList(){
	if( loginState == false ){ return; }
	$.ajax({
		url : "/jspweb/PointCotroller" ,
		method : "get" ,
		data : { type : 'findByAll' } ,
		success : result => { console.log(result) } ,
		error : e =>{ console.log(e) }
		
		
		
	})
}

// ------------------------- 결제 연동 -------------------------------//
// 1. 아임포트 관리자 식별키 
IMP.init('imp20546863') // 예: 'imp00000000a'


// 2. 결제 함수
 function requestPay() {
	 
	 // 2-1 : 만약에 결제방식을 선택을 안했으면
	 if(pay_method == '' ){alert('결제방식을 선택해주세요.'); return;}
	 if(amount == 0 ){ alert('결제금액을 선택해주세요. '); return; }
	 
	 
	 	let now = new Date(); console.log(now); // 현재날짜
	 	let time = now.getTime(); console.log(time); // 현재시간[밀리초]
	 	let merchant_uid = time+"-p-"+loginMid; console.log(merchant_uid);
	 
    IMP.request_pay({
      pg: "html5_inicis.INIBillTst",
      pay_method: pay_method ,
      merchant_uid: merchant_uid ,   // 주문번호
      name: "포인트결제",
      amount: amount ,                         // 숫자 타입
      buyer_email: "gildong@gmail.com",
      buyer_name: "홍길동",
      buyer_tel: "010-4242-4242",
      buyer_addr: "서울특별시 강남구 신사동",
      buyer_postcode: "01181"
    }, function (rsp) { // callback
    	console.log(rsp);
    		if(rsp.success){ // 결제성공
				
			}else{ // 결제 실패 [ 테스트 : 실패가 성공이라는 가정 ]
				alert('결제성공');
				
				// 1. 포인트 적립 기능처리
				setPoint( amount , '포인트결제' );
				
				// 2. 결제내역 테이블 기능처리 [구현X]
				
			}
      
    });
  }
// 3. 결제 방식 선택 함수
let pay_method = '';
function onPayMethod(method) {
	pay_method = method;
}
let amount = 0; // 결제 금액
function onAmount( value ){
	amount = value;
} 










