<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>메인페이지</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/boara/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/boara/resources/css/user.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="/boara/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/boara/resources/js/whistle/main.js"></script>
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

   <!-- Navbar -->
   <div class="w3-top">
     <div class="w3-bar w3-indigo w3-card w3-left-align w3-large">
       <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
       <a class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" id="main">메인</a>
       <a class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" id="collection">컬렉션</a>
       <a class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" id="reveiw">리뷰</a>
       <a class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" id="contact">외주</a>
        <h4 style="float: right; padding-right:40px;">Boara</h4>
     </div>
   </div>
   
   <!-- Header -->
   <header class="w3-container w3-indigo w3-center" style="padding:128px 16px">
     <h1 class="w3-margin w3-jumbo">Boara</h1>
<c:if test="${empty SID}">
     <button class="w3-button w3-black w3-padding-large w3-large w3-margin-top" id="login">Login</button>
</c:if>   
<c:if test="${not empty SID}">
     <button class="w3-button w3-indigo w3-padding-large w3-large w3-margin-top" id="sid">${SID}</button>     
</c:if>   
   </header>
   
   <!-- First Grid -->
   <div class="w3-row-padding w3-padding-64 w3-container">
      <div class="w3-col w3-display-container">
         <div>
            <div>
               <h3 class="w3-padding" id="hot">HOT!</h3>
            </div>
         </div>
         <div class="w3-col m2 w3-center">
            <div>
               <img class="w3-card-4" src="/boara/resources/img/avatar/img_avatar4.png" id="">
            </div>
            <div class="w3-padding">
               <div>작품 제목</div>
            </div>
         </div>
         <div class="w3-col m2 w3-center">
            <div>
               <img class="w3-card-4" src="/boara/resources/img/avatar/img_avatar4.png" id="">
            </div>
            <div class="w3-padding">
               <div>작품 제목</div>
            </div>
         </div>
         <div class="w3-col m2 w3-center">
            <div>
               <img class="w3-card-4" src="/boara/resources/img/avatar/img_avatar4.png" id="">
            </div>
            <div class="w3-padding">
               <div>작품 제목</div>
            </div>
         </div>
         <div class="w3-col m2 w3-center">
            <div>
               <img class="w3-card-4" src="/boara/resources/img/avatar/img_avatar4.png" id="">
            </div>
            <div class="w3-padding">
               <div>작품 제목</div>
            </div>
         </div>
         <div class="w3-col m2 w3-center">
            <div>
               <img class="w3-card-4" src="/boara/resources/img/avatar/img_avatar4.png" id="">
            </div>
            <div class="w3-padding">
               <div>작품 제목</div>
            </div>
         </div>
         <div class="w3-col m2 w3-center">
            <div>
               <img class="w3-card-4" src="/boara/resources/img/avatar/img_avatar4.png" style="width: 150px; height: 200px;" id="">
            </div>
            <div class="w3-padding">
               <div>작품 제목</div>
            </div>
         </div>
      </div> 
   </div>
   
   <!-- Footer -->
   <footer class="w3-container w3-padding-64 w3-center w3-opacity">
   		<p>(주)보아라</p>
   </footer>

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