<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

   <link href="library.css" rel="stylesheet" />
</head>
<body>
	<%@include file = "../header.jsp" %>
   <div class = "info">
      <div class = "info_button">
         <button onclick ="getValue(this)" type="button">1</button>
         <button onclick ="getValue(this)" type="button">2</button>
         <button onclick ="getValue(this)" type="button">3</button>
         <button onclick ="getValue(this)" type="button">4</button>
         <button onclick ="getValue(this)" type="button">5</button>
         <button onclick ="getValue(this)" type="button">6</button>
         <button onclick ="getValue(this)" type="button">7</button>
         <button onclick ="getValue(this)" type="button">8</button>
      </div>
      <div class = "info_input">
         <input class="lname" type="text">
         <input class="lphone" type="text">
      </div>
    </div>
      
    <div class = "inout_button">
      <button onclick="inroom()" type="button">입실</button>
      <button class="out" onclick="outroom()" type="button">퇴실</button>
      
      
   </div>



   <!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
   <!-- js import -->
   <script src="library.js" type="text/javascript"></script>
</body>
</html>