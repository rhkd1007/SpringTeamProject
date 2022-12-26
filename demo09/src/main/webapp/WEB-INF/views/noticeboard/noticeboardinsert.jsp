<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kor">
<head>       
	<title>Forum post list - Bootdey.com</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<!-- 	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"> -->
	 <link href="../css/board.css" rel="stylesheet" />
	
</head>
<body>
<div class="container">
	<br/><br/>
	<h3>공지사항</h3>
	<form action="/noticeboard/insert" method="post">
		<div class="form-group">
			<label for="nbtitle">제목 :</label> <input type="text"
				class="form-control" id="nbtitle" placeholder="Enter title"
				name="nbtitle"><br/>
		</div>
		<div class="form-group">
			<label for="writer">작성자:</label> <input type="text"
				class="form-control" id="writer" name="writer" 
				value="<sec:authentication 	property='principal.member.username' />" 
				readonly="readonly"
 				 /><br/>
		</div>
		<div class="form-group">
			<label for="nbcontent">내용:</label>
			<textarea class="form-control" rows="5" id="nbcontent" name="nbcontent"></textarea>
		</div>
		
		<button type="submit" class="btn btn-primary btn-sm">글쓰기</button>
	</form>
</div>
<%@ include file="../includes/footer.jsp"%>


<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript"></script>

</body>
<%@ include file="../includes/footer.jsp"%>
</html>