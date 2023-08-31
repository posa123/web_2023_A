console.log("js")
// 등록
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
aread()
function aread(){
	$.ajax({
		url :"/jspweb/Accountbook" ,
		method : "get",
		data : "",
		success : r=> {
			let output = document.querySelector('.accountbottom')
			let html = ``;
			for( let i = 0; i<r.length ; i++){
				html +=``
			}
		},
		error : e=>{}
	});
}
function aupdate(){
	
}
function adelete(){
	
}