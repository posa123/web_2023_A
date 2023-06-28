console.log('JS실행')
let 글목록 = []
function 글내용(){ console.log('등록함수실행')
	
	let name = document.querySelector('#name').value;
	let pw = document.querySelector('#pw').value;
	let title = document.querySelector('#title').value;
	let data = document.querySelector('#data').value;
	console.log(''+name)
	console.log(''+pw)
	console.log(''+title)
	console.log(''+data)
	
	let sum = { 작성자 : name , 비밀번호 : pw , 제목 : title , 내용 : data }
	console.log(sum)


	글목록.push(sum)

}
console.log(글목록)
function 출력(){
	
}