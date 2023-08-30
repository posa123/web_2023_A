<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="../css/hrm.css" rel="stylesheet">
</head>
<body>
	<div>
		<form class="sumitForm">
			<input name="himg" class="himg" type="file" accept="image/*">직원사진
			<input name="hname" class="hname" type="text">직원명
			<input name="hphone" class="hphone" type="text">직원전화번호
			<select name="hposition" class="hposition">
				<option>사원</option>
				<option>주임</option>
				<option>대리</option>
				<option>팀장</option>
				<option>부장</option>
				<option>사장</option>
			</select>
			<button onclick="sumit()" type="button">등록</button>
		</form>
	</div>
	
	<script src="../js/hrm.js" type="text/javascript"> </script>
</body>
</html>