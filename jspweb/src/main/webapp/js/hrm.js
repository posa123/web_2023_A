function sumit(){
	console.log('등록')

   $.ajax({
      	url : "/jspweb/HrmController" , 
        method: "post" ,
        data : "" ,
        success : r => { console.log('통신성공') } ,
        error : e => { console.log('통신실패') } ,
    })
	
}
/*
    $.ajax({
      	url : "" , 
        method: "" ,
        data : "" ,
        contentType : "" ,
        processData : "" ,
        success : r => { console.log(r) } ,
        error : e => { console.log(e) } ,
    })




*/
