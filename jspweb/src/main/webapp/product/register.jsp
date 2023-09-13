<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file ="../header.jsp" %>
	<div class="webcontainer">
		<h3> 제품 등록 페이지 </h3>
		<div>
			제품명 : <input class="pname1" type="text">
			제품설명 : <textarea class="pcontent1"></textarea>
			<button onclick="register1()" type="button">등록1</button>
		</div>
		<h3> 제품 등록 페이지 [ form 태크 이용하는 경우 ]</h3>
		<form class="registerForm1">
			제품명 : <input name="pname2" type="text">
			제품설명 : <textarea name="pcontent2"></textarea>
			<button onclick="register2()" type="button">등록1</button>
		</form>
	</div>
	<script src="../js/product/register.js" type="text/javascript"> </script>
</body>
</html>