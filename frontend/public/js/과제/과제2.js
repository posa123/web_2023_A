let 아이디 = []
let 비밀번호 = [] 
console.log( 아이디 )
console.log( 비밀번호 )
function sign_up_list(){
	alert('회원가입되었습니다.')
	let idInput = document.querySelector('.id')
	let id = idInput.value
	아이디.indexOf(id)!= -1 ? alert('이미사용중인아이디입니다.') :아이디.push (id)
	idInput.value =''
	let pwInput = document.querySelector('.pw')
	let pw = pwInput.value
	비밀번호.push(pw)
	pwInput.value =''
}
function sign_in_list(){
	아이디.indexOf( 'id' ) != 1 ? 아이디 : alert('아이디가일치하지않습니다.')
}