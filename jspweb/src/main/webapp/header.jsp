<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/header.css" rel="stylesheet">
</head>
<body>

	<!-- 헤더 -->
	<div id="header">	
		<div class="mainlogo"><!-- 로고 -->
			<a href="/jspweb/index.jsp">
				<img alt="" src="/jspweb/img/logo.png"/>
			</a>
		
		</div>
		<ul class="mainmenu"><!-- 본메뉴 -->

			<li> <a href="/jspweb/visitlog/visitlog.jsp">방문록</a> </li>	
			<li> <a href="/jspweb/board/list.jsp">게시판</a> </li>
			<li> <a href="/jspweb/datago/datago.jsp">공공데이터</a> </li>
			<li> <a href="/jspweb/chatting/chatting.jsp">채팅</a> </li>
			<li> <a href="/jspweb/product/register.jsp">제품등록</a> </li>
			<li> <a href="/jspweb/product/list.jsp">제품찾기</a> </li>
			<li> <a href="/jspweb/accountbook/accountbook.jsp">(과1):가계부</a></li>
			<li> <a href="/jspweb/library/library.jsp">(과2):독서실</a> </li>
			<li> <a href="#">(과3)</a> </li>
		</ul>
		<ul class="submenu"><!-- 서브메뉴 -->	

			

			
		</ul>
		<ul>
		
			
			
		
			
		</ul>
	</div>
	<!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/jspweb/js/header.js"></script>
</body>
</html>