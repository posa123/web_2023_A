<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- css import -->
	<link href="visitlog.css" rel="styleheet" />
</head>
	
<body>
	<!-- CRUP 기반의 비회원 게시판 구현 -->
	<div> <!-- 전체 구역 -->
		<div> <!-- 쓰기 구역 -->
			<input class="vwriter" type="text" placeholder="작성자">
			<input class="vpwd" type="text" placeholder="비밀번호">
			<textarea class="vcontent"></textarea>
			<button onclick="vwrite()" type="button">등록</button>
		</div>
		
		<div> <!-- 출력 구역 -->
			
		</div>	
	</div>


	<!-- 최신 JQUERY import ( ajax() 사용할) -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- js import  -->
	<script src="visitlog.js" type="text/javascript"></script>
</body>

	
</html>