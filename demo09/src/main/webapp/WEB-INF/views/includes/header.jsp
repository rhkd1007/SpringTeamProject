<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
     	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="kor">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Landing Page - Start Bootstrap Theme</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="/assets/img/부산광역시.gif" />
        <!-- Bootstrap icons-->
        <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" type="text/css" /> -->
        <!-- Google fonts-->
        <!-- <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" /> -->
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/css/styles.css?after" rel="stylesheet" />
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

    </head>
    <body>
        <!-- Navigation-->
            	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="principal" />
		</sec:authorize>
        <nav class="navbar navbar-light bg-light static-top">
        	<div class="container">
        	
        	<div class=" dropdown ">
        	
  <button class=" btn btn-sm dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
  <img src="/assets/img/부산광역시.gif" alt="Bootstrap" width="25" height="25">
  	부산광역시
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
    <li><a class="dropdown-item" href="/tour/gangseo"><img src="/assets/img/부산 강서구.jpg" alt="Bootstrap" width="20" height="20">강서구</a></li>
    <li><a class="dropdown-item" href="/tour/geomjung"><img src="/assets/img/부산 금정구.jpg" alt="Bootstrap" width="20" height="20">금정구</a></li>
    <li><a class="dropdown-item" href="/tour/gijang"><img src="/assets/img/부산 기장군.jpg" alt="Bootstrap" width="20" height="20">기장군</a></li>
    <li><a class="dropdown-item" href="/tour/namgu"><img src="/assets/img/부산 남구.jpg" alt="Bootstrap" width="20" height="20">남구</a></li>
    <li><a class="dropdown-item" href="/tour/donggu"><img src="/assets/img/부산 동구.jpg" alt="Bootstrap" width="20" height="20">동구</a></li>
    <li><a class="dropdown-item" href="/tour/dongrae"><img src="/assets/img/부산 동래구.jpg" alt="Bootstrap" width="20" height="20">동래구</a></li>
    <li><a class="dropdown-item" href="/tour/jingu"><img src="/assets/img/부산 진구.jpg" alt="Bootstrap" width="20" height="15">부산진구</a></li>
    <li><a class="dropdown-item" href="/tour/bukgu"><img src="/assets/img/부산 북구.jpg" alt="Bootstrap" width="20" height="20">북구</a></li>
    <li><a class="dropdown-item" href="/tour/sasang"><img src="/assets/img/부산 사상구.jpg" alt="Bootstrap" width="20" height="20">사상구</a></li>
    <li><a class="dropdown-item" href="/tour/saha"><img src="/assets/img/부산 사하구.png" alt="Bootstrap" width="20" height="20">사하구</a></li>
    <li><a class="dropdown-item" href="/tour/seogu"><img src="/assets/img/부산 서구.png" alt="Bootstrap" width="20" height="20">서구</a></li>
    <li><a class="dropdown-item" href="/tour/suyoung"><img src="/assets/img/부산 수영구.jpg" alt="Bootstrap" width="20" height="20">수영구</a></li>
    <li><a class="dropdown-item" href="/tour/yeonje"><img src="/assets/img/부산 연제구.gif" alt="Bootstrap" width="20" height="20">연제구</a></li>
    <li><a class="dropdown-item" href="/tour/youngdo"><img src="/assets/img/부산 영도구.jpg" alt="Bootstrap" width="20" height="20">영도구</a></li>
    <li><a class="dropdown-item" href="/tour/junggu"><img src="/assets/img/부산 중구.png" alt="Bootstrap" width="20" height="20">중구</a></li>
    <li><a class="dropdown-item" href="/tour/haeundae"><img src="/assets/img/부산 해운대구.png" alt="Bootstrap" width="20" height="20">해운대구</a></li>
  </ul>
  </div>
  

<div class="dropdown ">
  <button class="btn btn-sm dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
  	게시판
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
    <li><a class="dropdown-item" href="/noticeboard/nboard">공지사항</a></li>
    <li><a class="dropdown-item" href="/freeboard/board"">자유게시판</a></li>
  </ul>
</div>
           <a class="navbar-brand text-center" href="/"><h1>Busan tour　</h1></a>
                <div>
                <sec:authorize access="isAnonymous()">
                <a class="btn btn-primary" href="/member/login">로그인</a>
                <a class="btn btn-primary" href="/member/signup">회원가입</a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                <a class="btn btn-primary" href="/member/update/${principal.member.num }">(<sec:authentication
								property="principal.member.id" />)님 회원수정</a>
                <a class="btn btn-primary" href="/logout">로그아웃</a>
                </sec:authorize>
                </div>
                </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead">
            <div class="container position-relative">
                <div class="row justify-content-center">
                    <div class="col-xl-6">
                        <div class="text-center text-white">
                            <!-- Page heading-->
                            <h1 class="mb-5">부산 관광지 소개 사이트</h1>
                            
                        </div>
                    </div>
                </div>
            </div>
        </header>
