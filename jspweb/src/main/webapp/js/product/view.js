
// * 게시판상세페이지 , 제품상세페이지 등등에서는 클릭된 식별자[제품번호]
//URL(인터넷주소) 에서 매개변수(쿼리스트링) 가져오기
let pno = new URL( location.href ).searchParams.get("pno")


// 1. pno에 해당하는 제품 1개 호출
findByPno( pno );
function findByPno( pno ){
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		method : "get" ,
		data : { type : "findByPno" , pno : pno } ,
		success : jsonObject => { console.log (jsonObject)
			// 캐러셀에 이미지 여러개 대입
			let imgbox = document.querySelector('.imgbox')
			
			let html = ``;
			
			Object.values( jsonObject.imgList ).forEach((img,i)=>{
				// 첫번째 이미지에만 active클래스 삽입
				html +=`
					<div class="carousel-item ${i==0? 'active' : '' }">	<!-- carousel-inner : 이미지1개당 / active : 현재 보고있는 이미지 -->
			      <img src="/jspweb/product/img/${img}" class="d-block w-100" alt="...">
			    </div>
				`;
			})
			
			imgbox.innerHTML = html;
			
			// --------------------------- 각 위치에 데이터 넣어주기 ---------------------------//
			document.querySelector('.mid').innerHTML = `판매자 : ${jsonObject.mid}`
			document.querySelector('.pcname').innerHTML = `카테고리 : ${jsonObject.pcname}`
			document.querySelector('.pdate').innerHTML = `등록일 : ${jsonObject.pdate}`
			document.querySelector('.pname').innerHTML = `${jsonObject.pname}`
			document.querySelector('.pprice').innerHTML = `${jsonObject.pprice.toLocaleString()}원`
			document.querySelector('.pcontent').innerHTML = `${jsonObject.pcontent}`
		
		}
	})
}

// 2. 찜하기 등록[ 비회원제 : ip주소/디바이스식별번호 , 회원제 : header.js ]
function setWish(){
	if( loginState == false ){ alert('로그인후 가능한 기능입니다.'); return; }
	// 2. 
	$.ajax({
		url : "/jspweb/PwishListController",
		method : "post",
		async : false , 
		data : { pno : pno } ,
		success : result => { console.log(result);
			if(result){ getWish(); }
			else{}
		} 

	})
}
// 3. 찜하기 상태 호출
getWish();
function getWish(){
	let wish = document.querySelector('.wish'); // 하트 구역 가져오기
	// 1. 비회원이면
	if( loginState == false ){ wish.innerHTML = '♡'}
	// 2. 회원이면
	$.ajax({
		url : "/jspweb/PwishListController",
		method : "get",
		data : { type : "findByWish" , pno : pno } ,
		success : result => { console.log(result);
			if(result){wish.innerHTML='♥'}
			else{wish.innerHTML='♡'}
		}
})
}















