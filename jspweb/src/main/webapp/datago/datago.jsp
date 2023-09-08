<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file = "../header.jsp" %>
	<h3> 공공데이터 </h3>
	<div class="webcontainer">
	<div>
		<h2> - 카카오지도 - </h2>
		<div class="detailbox">
		
		</div>
		<div id="map" style="width:100%;height:400px;"></div>
	</div>
		<h6> 안산시 착한가격업소 현황 </h6>
		<table class="apiTable1">
		
		</table>
	
	
	</div>

	<!-- 카카오JS -->
	   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1ac4a57d8a5927d34020a891fcdbbcbd&libraries=clusterer"></script>
	<script src="/jspweb/js/datago/datago.js"></script>
</body>
</html>