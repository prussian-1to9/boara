<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>컬렉션 리스트</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/boara/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/boara/resources/css/user.css">
<link rel="stylesheet" type="text/css" href="/boara/resources/css/c/ez.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="/boara/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/boara/resources/js/main.js"></script>
<script type="text/javascript" src="/boara/resources/js/c/collec.js"></script>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-bar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}
img {
   width: 150px; 
   height: 200px;
}
</style>
</head>
<body>

	<%-- Navbar --%>
	<div class="w3-top">
		<div class="w3-bar w3-indigo w3-card w3-left-align w3-large">
			<a class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" id="main">메인</a>
			<a class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" id="collection">컬렉션</a>
<c:if test="${not empty SID}">
			<a class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" id="mwrite">글작성</a>
			<a class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" id="mcoll">새 컬렉션</a>
</c:if>
			<h4 style="float: right; padding-right:40px;">Boara</h4>
		</div>
	</div>
   
   <%-- Header --%>
	<header class="w3-container w3-indigo w3-center" style="padding:128px 16px">
<c:if test="${empty CID}">
     <h1 class="w3-margin w3-jumbo">Collection List</h1>
</c:if>
<c:if test="${not empty CID}">
     <h1 class="w3-margin w3-jumbo">${CID}'s Collection</h1>
</c:if>
<c:if test="${empty SID}">
		<button class="w3-button w3-black w3-padding-large w3-large w3-margin-top" id="mlogin">Login</button>
</c:if>
<c:if test="${not empty SID}">
		<button class="w3-button w3-indigo w3-padding-large w3-large w3-margin-top" id="msid">${SID}</button>     
		<button class="w3-button w3-indigo w3-padding-large w3-large w3-margin-top" id="mlogout">Logout</button>     
</c:if>
	</header>
   
	<%-- First Grid --%>
	<div class="w3-row-padding w3-padding-64 w3-container">

<%--컬렉션 리스트 --%>
<c:if test="${not empty LIST}">
	<c:forEach var="data" items="${LIST}">

		<div class="w3-col w3-display-container w3-center">
			<div class="w3-pale-blue collbox w3-center w3-margin-bottom">
				<div class="thumbbox w3-border-right w3-col m2 cbox" id="${data.cno}">
				<%-- 이미지 작업 --%>
		<c:if test="${not empty data.list}">
			<c:forEach var="thumb" items="${data.list}">
					<div class="thbox">
						<img class="thumb" src="/boara${thumb.dir}${thumb.savename}">
					</div>
			</c:forEach>
		</c:if>
		<c:if test="${empty data.list}">
					<div class="thbox">
						<img class="thumb" src="/boara/resources/img/noimage.jpg">
					</div>
		</c:if>
					<h4 class="inline nomg">${data.id}</h4>
				</div>
				<div class="colldetail w3-margin-left w3-col m7 cbox" id="${data.cno}">
					<div class="w3-padding w3-left w3-col h100" id="${data.cno}">
			 			<h1 class="w3-left inline mgt30">${data.cname}</h1>
					</div>
			<c:if test="${not empty data.genre}">
				<c:forEach var="genr" items="${data.genre}">
						<div class="genre w3-round w3-left">${genr}</div>
				</c:forEach>
			</c:if>
			<c:if test="${not empty data.descr}">
					<h4 class="w3-left-align c-left pdt20">${data.descr}</h4>
			</c:if>
				</div>
				<div class="w3-col m2" id="${data.cno}">
		<c:if test="${data.id eq SID}">
						<div class="noti w3-right ebtn w3-round">수정</div>
						<div class="noti w3-right dbtn w3-round">삭제</div>
		</c:if>
				</div>
			</div>
		</div>
	
	</c:forEach>
</c:if>
<c:if test="${empty LIST}">
	<div class="w3-center w3-content">
		<p>불러올 컬렉션이 없습니다.</p>
	</div>
</c:if>
	</div>
   
   
   <%-- 페이지 처리 --%>
   <div class="w3-center">
			<div class="w3-bar w3-border w3-round-medium w3-card w3-margin-top w3-margin-bottom">
	<c:if test="${PAGE.startPage eq 1}">
				<div class="w3-bar-item w3-light-grey">&laquo;</div>
	</c:if>
	<c:if test="${PAGE.startPage ne 1}">
				<div class="w3-bar-item w3-button w3-hover-blue cpbtn" id="${PAGE.startPage - 1}">&laquo;</div>
	</c:if>
	<c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}">
			<c:if test="${page eq PAGE.nowPage}">
				<div class="w3-bar-item w3-orange">${page}</div>
			</c:if>
			<c:if test="${page ne PAGE.nowPage}">
				<div class="w3-bar-item w3-button w3-hover-blue cpbtn" id="${page}">${page}</div>
			</c:if>
	</c:forEach>
			<c:if test="${PAGE.endPage eq PAGE.totalPage}">
				<div class="w3-bar-item w3-light-grey">&raquo;</div>
			</c:if>
			<c:if test="${PAGE.endPage ne PAGE.totalPage}">
				<div class="w3-bar-item w3-button w3-hover-blue cpbtn" id="${PAGE.endPage + 1}">&raquo;</div>
			</c:if>
			</div>
		</div>
   
	<%-- Footer --%>
	<footer class="w3-container w3-padding-64 w3-center w3-opacity w3-border-top">
		<p>(주)보아라</p>
	</footer>
	
	<%-- 메세지창 --%>
	<c:if test="${not empty MSG}">
		<div id="modal" class="w3-modal" style="display: block;">
			<div class="w3-modal-content mxw650 w3-animate-top w3-card-4">
				<header class="boablue w3-container">
					<span onclick="document.getElementById('modal').style.display='none'"
						class="w3-button w3-display-topright">&times;</span>
						<h2>실행 결과</h2>
				</header>
				<div class="w3-container w3-center">
					<h4>${MSG}</h4>
				</div>
			</div>
		</div>
</c:if>
	
	<%-- 데이터 전송용 폼 --%>
	<form method="POST" name="frm" id="frm" action="/boara/collection/collecList.boa">
		<input type="hidden" name="nowPage" id="nowPage" value="${PAGE.nowPage}">
		<input type="hidden" name="cno" id="cno">
<c:if test="${not empty CID}">
		<input type="hidden" name="cid" id="cid" value="${CID}">
</c:if>
	</form>

<script>
// Used to toggle the menu on small screens when clicking on the menu button
function myFunction() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}
</script>

</body>
</html>