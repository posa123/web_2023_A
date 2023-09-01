<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="../css/write.css" rel="stylesheet">
</head>
<body>

	<%@include file="../header.jsp" %>
	<div class="webcontainer">
		<h3> 글 쓰기 페이지 </h3>
		<a href="list.jsp"> 목록보기 </a>
		<form class="writeForm"> <!-- 쓰기 입력 구역 -->
			카테고리 : <select name="bcno" class="bcno">
						<!-- 게시물에 저장되는 카테고리정보는 카테고리이름X 카테고리번호 [FK] -->
						<option value="1"> 공지사항 </option>
						<option value="2"> 자유게시판 </option>
						<option value="3"> 노하우 </option>
					</select>
			제목 : <input type="text" name="btitle" class="btitle">
			내용 : <textarea name="bcontet" class="bcontent"></textarea>
			첨부파일 : <input type="file" name="bfile" class="bfile">
			<button onclick="write()" type="button">글등록</button>
			<a href="list.jsp">목록보기</a>
			<button type="reset">다시쓰기</button>
		</form>
	</div>
	<script src="../js/write.js" type="text/javascript"> </script>
</body>
</html>