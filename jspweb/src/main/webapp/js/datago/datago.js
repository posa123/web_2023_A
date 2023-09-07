console.log('js 연동')


// 1. 안산시 착한가격업소 API 호출
api1()
function api1(){
	
	$.ajax({
		url : "https://api.odcloud.kr/api/15036759/v1/uddi:577ba1b9-b79f-4865-b31e-a9dc71ce67bc_201909231019?page=1&perPage=45&serviceKey=4v1XsjmDAD%2BYvVwMtHRPr%2Be5NYMGoPj%2BBOrct4xjsJMCftn%2Bl6C3YKs1BW1DLutUJM1xAPVeNvXlSYflwr6XDg%3D%3D",
		method :  "get" ,
		data : {} ,
		success : response => { 
			console.log(response)
			let data = response.data; console.log(data);
			console.log(data[0]);
			console.log(data[0].업소명);
			
			// 1. 출력할 dom객체
			let apiTable1 = document.querySelector('.apiTable1')
			
			// 2. HTML 구성
			let html = ``;
				// 2-2
				data.forEach(( d, i )=>{
					html += `<tr>
								<th> ${i+1} </th>
								<th> ${d.업소명} </th>
								<th> ${d.소재지도로명주소} </th>
								<th> ${d.연락처} </th>
								<th> ${d.품목1} / ${d.가격1} </th>
								<th> ${d.품목2} / ${d.가격2} </th>
								<th> ${d.품목3} / ${d.가격3} </th>
							</tr>`
				})
				
				
			// 3. 출력할 위치에 HTML대입
			apiTable1.innerHTML = html;
		},
		erroe : e => {console.log(e)}
	})
	
}