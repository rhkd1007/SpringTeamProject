<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kor">
   <%@ include file="../includes/header.jsp"%>  
   
       


<body>
<br/><br/>
 <div class="demo">
        <div class="container">
            <div class="row text-center"> 
                                             
                <h1 class="heading-title"> ${tboard.galTitle } </h1>
                <h3><div class= "c" style="font-size:20px;"> ${tboard.galPhotographyLocation }</div></h3>
            </div>
            <div class="row">
           
           
                <div class="k">
                    <div class="testimonial-bg">
                        <div id="testimonial-slider" class="owl-carousel">
                            <div class="testimonial">
                            <div class="pic image-center">
                            <div align ="center">
                                    <img src="${tboard.galWebImageUrl }" alt=""
                                  style="width:1168px;"/></div>
                                </div>
                                <br/>
                                <div align="center">
                                   <a href="javascript:history.back();"><button type="button" class="btn btn-secondary btn-sm">목록</button></a>
                        </div> </div>
                </div>
            </div>
        </div>
    </div>
 </div>
 </div>



</body>
<%@ include file="../includes/footer.jsp"%>
</html>
