<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/product/list.css" rel="stylesheet">
	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<%@include file ="../header.jsp" %>
	<div class="mapcontent">
	

		<!-- 지도를 표시할 div 입니다 -->
		<div id="map">
		</div>
		
		<!-- 사이드바 구역 -->
		<div class="sidebar"> 
			<!-- 카드 start -->
		
			<!-- 카드 end -->
		
		</div>
		
	</div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=108c41d5fd7747457c7c80d88ab1e78d&libraries=clusterer"></script>
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script src="/jspweb/js/product/list.js" type="text/javascript"></script>
</body>
</html>