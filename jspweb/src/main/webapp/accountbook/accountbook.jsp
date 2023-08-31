<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- css import -->
	<link href="accountbook.css" rel="stylesheet" />
</head>
<body>
	<div> <!-- wrap전체구역  -->
		<div> <!-- 등록구역 -->
			<input class="atext" type="text" placeholder="항목내용">
			<input class="anumber" type="text" placeholder="금액">
			<input class="adate" type="date">
			<button onclick="awriter()">등록</button>
		</div> <!-- 등록구역end -->
		<div class="accountbottom"> <!-- 출력구역 -->
			
		</div> <!-- 출력구역 end -->
	</div> <!-- wrap전체구역 end -->


	<!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- js호출 -->
	<script src="accountbook.js" type="text/javascript"></script>
</body>
</html>