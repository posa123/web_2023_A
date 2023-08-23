console.log("js")
function awriter(){
	console.log("등록")
	let atext = document.querySelector('.atext');
	let anumber = document.querySelector('.anumber')
	let adate = document.querySelector('.adate')
	
	let info = {
		atext : atext.value ,
		anumber : anumber.value ,
		adate : adate.value
	}; console.log(info);
	$.ajax({
		url : "/jspweb/Accountbook" ,
		method : "post",
		data : info ,
		success : function f(r){ console.log(r) } ,
		error : function f(r){ console.log(r) }
	})
}
function aupdate(){
	
}
function adelete(){
	
}