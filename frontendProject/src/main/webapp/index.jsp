<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 다른 JSP 파일 호출 -->
	<%@include file = "header.jsp" %>
	<p>
		대문입니다.
		코드변경되면 저장후에 [Ctrl+f5 : 강력새로고침]
	</p>
	<%@include file = "footer.jsp" %>
</body>
</html>