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
	 <!-- <link href="../css/board.css" rel="stylesheet" /> -->
	
</head>
<body>
<div class="container">
	<br/><br/>
	<h3>자유게시판</h3>
	<form action="/freeboard/insert" method="post" enctype="multipart/form-data">
	<div class="form-group">
			<label for="free">말머리 :</label> 
			<select name="free">
			<option value="자유게시판">자유게시판</option>
			<option value="관광추천">관광추천</option>
			<option value="숙박추천">숙박추천</option>
			<option value="맛집추천">맛집추천</option>
			</select>
		</div>
	
		<div class="form-group">
			<label for="title">제목 :</label> <input type="text"
				class="form-control" id="title" placeholder="Enter title"
				name="title"><br/>
		</div>
		<div class="form-group">
			<label for="writer">작성자:</label> <input type="text"
				class="form-control" id="writer" name="writer" 
				value="<sec:authentication 	property='principal.member.username' />" 
				readonly="readonly"
 				 /><br/>
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<textarea class="form-control" rows="5" id="content" name="content"></textarea>
		</div>
		<div class="form-group">
      <label for="upload">파일:</label>
      <input type="file" class="form-control" id="upload" placeholder="Enter file" name="upload"  />
    </div>
    <br/>
		<button type="submit" class="btn btn-primary btn-sm">글쓰기</button>
	</form>
</div>



<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript"></script>

</body>
<%@ include file="../includes/footer.jsp"%>
</html>