<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href ="../css/member.css" rel = "stylesheet">

</head>
<body>
	<%@include file = "../header.jsp" %>
	
	<div> <!-- 회원가입 전체구역 -->
		아이디 : <input onkeydown="idcheck()" class="mid" type="text"/> <br/>
		<span class="idcheckbox"></span>
		비밀번호 : <input onkeyup="pwcheck()" class="mpwd" type="password"/> 
		비밀번호 확인 : <input onkeyup="pwcheck()" class="mpwdconfirm" type="password"/><br/>
		
		<span class="pwcheckbox"></span>
		이메일 : <input onkeyup="emailcheck()" class="memail" type="text"/> <button class="authReqBtn" onclick="authReq()"disabled type="button">인증요청</button><br/>
		<div class="authbox">
		
		
		</div>
	
		
		<span class="emailcheckbox"></span>
		프로필 : <input class="mimg" type="file"/><br/>
		<button onclick="signup()" type ="button"> 회원가입 </button>
	</div>
	
	<script src="../js/signup.js" type="text/javascript"></script>
	
</body>
</html>