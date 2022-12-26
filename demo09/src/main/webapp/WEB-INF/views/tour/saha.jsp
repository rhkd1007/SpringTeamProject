<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../includes/header.jsp"%>
<!DOCTYPE html><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="kor">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Stylish Portfolio - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Simple line icons-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/gijang/styles.css" rel="stylesheet" />
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Landing Page - Start Bootstrap Theme</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" type="text/css" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />



  
        
    </head>

    <body>
    	<p id="count"></p>
           <section class="content-section" id="portfolio">
        
            <div class="container px-4 px-lg-5"> 
            
                <div class="content-section-heading text-center">
                
                 <img class="gimg" src="/assets/img/부산 사하구.png" alt="..." / > 
                    <div class = gi >사하구</div>
                    <h2 class="mb-5">유명 관광지</h2>
                </div>
                <div class="row gx-0" id="gijangtour">
                
                 <c:forEach items="${saha.content}" var="tboard" varStatus="st">
                    <div class="col-lg-6">
                        <a class="portfolio-item" href="/freeboard/saha/${tboard.galContentId  }">
                            <div class="caption">
                                <div class="caption-content">
                                    <div class="h3">${tboard.galTitle }</div>
                                    <p class="mb-0">${tboard.galPhotographyLocation }</p>
                                </div>
                            </div>
                            <img class="img-fluid" src="${tboard.galWebImageUrl }" alt="..." />
                        </a>
                    </div></c:forEach>

		</div>
		</div>
		<br/>
		<br/>
		<div class="container" align="center">
		<div align="center">
		<ul class="pagination mt-3">
			<!-- 이전 -->
			<c:if test="${saha.first==false }">
				<li class="page-item" ><a class="page-link"
					href="saha?page=0">첫페이지</a></li>
			</c:if>
			<!-- 페이지 -->
			<c:forEach begin="${startPage }" end="${endPage }" var="i">
				<c:if test="${currentpage == i }">
					<li class="page-item active"><a class="page-link" href="saha?page=${i} }">${i}</a></li>
				</c:if>
				<c:if test="${currentpage != i }">
		 <li class="page-item"><a class="page-link" href="saha?page=${i-1}">${i}</a></li>
				
				</c:if>
			</c:forEach>
			<!-- 다음 -->
			<c:if test="${saha.last==false }">
				<li class="page-item"><a class="page-link"
					href="saha?page=${countpge-1}">끝페이지</a></li>
			</c:if>

		</ul>
		</div>
		</div>
		
	
		</section>

     
        
   
        </html>
        
    </body>

</html>
     <footer class="footer bg-light">
                      <div class="card text-white bg-secondary my-5 py-4 text-center">
                <div class="card-body"><p class="text-white m-0">제공 - 한국관광공사 관광사진 정보</p></div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 h-100 text-center text-lg-start my-auto">
                        <ul class="list-inline mb-2">
                            <li class="list-inline-item"><a href="#!">About</a></li>
                            <li class="list-inline-item"></li>
                            <li class="list-inline-item"><a href="#!">Contact</a></li>
                            <li class="list-inline-item"></li>
                            <li class="list-inline-item"><a href="#!">Terms of Use</a></li>
                            <li class="list-inline-item"></li>
                            <li class="list-inline-item"><a href="#!">Privacy Policy</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-6 h-100 text-center text-lg-end my-auto">
                        <ul class="list-inline mb-0">
                            <li class="list-inline-item me-4">
                                <a href="#!"><i class="bi-facebook fs-3"></i></a>
                            </li>
                            <li class="list-inline-item me-4">
                                <a href="#!"><i class="bi-twitter fs-3"></i></a>
                            </li>
                            <li class="list-inline-item">
                                <a href="#!"><i class="bi-instagram fs-3"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>




        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
