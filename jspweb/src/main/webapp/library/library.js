console.log('js open')
let lno = "";

function getValue(button) {
    lno = button.textContent;
    alert("눌린 버튼의 값: " + lno);
}

function inroom(lno){ // 입실
	
	document.querySelector('.getValue')
	let lnameInput = document.querySelector('.lname')
	let lphoneInput = document.querySelector('.lphone')
	console.log(lphoneInput)
	console.log(lnameInput)
	console.log(lno)
	let info ={ 
		lname : lnameInput.value , 
		lphone : lphoneInput.value, 
	}
	console.log(info)
	$.ajax({
		url : "/jspweb/LibraryController" ,
		method : "post",
		data : info ,
		success : r => {} ,
		error : e => {}
	})
}
