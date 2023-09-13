
// 1.
function register1(){
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method : "post" ,
		data : {
			pname1 : document.querySelector('.pname1').value ,
			pcontent1 : document.querySelector('.pcontent1').value 
		},
		success : r => { console.log(r) }
	})
}

function register2(){
	
	let registerForm1 = document.querySelectorAll('.registerForm1')[0];
	let formData = new FormData( registerForm1 );
	
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method : "post",
		data : formData,
		contentType : false ,			
		processData : false ,
		success : r => { console.log(r) }
	})
}