<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>         
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
  
  <html>
<head>
	<mata charset="UTF-8">
		<meta name="viewport" content="width=device-width" intial-scale="1">
	<title>studymate</title>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="resources/css/index.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
   <!-- 
   <script src="resources/js/header.js"></script>
  -->
  <script>
    $(document).ready(function(){
      $('.slider').bxSlider();
    });
  </script>
	

	
</head>
<body>
	<div class="header">

   <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/portpolio/index"><img src="resources/img/logo.png" width="50px"><span class=brand-logo>StudyMate</span></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
 
 
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item ">
        <a class="nav-link" href="/portpolio/studyboard?subject=main">スタディー参加 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item ">
        <a class="nav-link" href="/portpolio/studyregister">スタディー作り</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="/portpolio/review?subject=main">レビュー</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="/portpolio/detail">MyPage</a>
      </li>
     </ul>
  </div>
   <div class="enter">
   		<!-- 세션갑이 없으면(null) -->
   	<c:choose>
   		<c:when test="${sessionScope.userInpo!= null}">
      	<span class="text-center">ようこそ  ${sessionScope.userInpo.name} 様 </span>	
      	<a class="logout" href="/portpolio/logout" >ログアウト</a>  
      
      
      </c:when>
      <c:otherwise>
      <!-- 세션값이 있으면(null아닌)--> 
      <a class="login" href="/portpolio/login" id="login">ログイン</a><a class="register"href="/portpolio/register">会員登録</a>
      </c:otherwise>
    </c:choose>
    
   </div>
   
</nav>
   </div>   