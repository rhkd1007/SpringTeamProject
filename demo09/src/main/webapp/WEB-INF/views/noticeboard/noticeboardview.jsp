<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp"%>

<br><br>
<div class="container">
	<h2>공지사항 상세보기</h2>

	<div class="form-group">
		<label for="nbtitle">제목:</label> <input type="text"
			class="form-control" id="nbtitle" placeholder="Enter title"
			name="nbtitle" value="${nboard.nbtitle }" readonly="readonly">
	</div>

	<div class="form-group">
		<label for="writer">작성자:</label> <input type="text"
			class="form-control" id="writer" placeholder="Enter writer"
			name="writer" value="${nboard.member.username }" readonly="readonly">
	</div>

	<div class="form-group">
		<label for="nbcontent">내용:</label>
		<textarea class="form-control" rows="5" id="nbcontent" name="nbcontent"
			readonly="readonly">${nboard.nbcontent }</textarea><br>
	</div>
<div>
<sec:authorize access="isAuthenticated()">
<c:if test="${principal.member.role=='admin'}">
	<input type="button" class="btn btn-primary btn-sm"value="수정" id="nbtnUpdate">
	<input type="button" class="btn btn-primary btn-sm" value="삭제" id="nbtnDelete"> 	
</c:if>
</sec:authorize>
<button type="button" class="btn btn-primary btn-sm" id="btnList">목록</button><br><br>
</div>


	
</div>


<%@ include file="../includes/footer.jsp"%>

<script>
$("#btnList").click(function(){
	location.href="/noticeboard/nboard";
})

//수정폼
$("#nbtnUpdate").click(function(){
	if(confirm("정말 수정할까요?")){
		location.href="/noticeboard/update/${nboard.nbnum}"
	}
})

//삭제
$("#nbtnDelete").click(function(){
	if(!confirm("정말 삭제할까요?"))return
	$.ajax({
		type:"delete",
		url:"/noticeboard/delete/${nboard.nbnum}",
		success:function(resp){
			if(resp=="success"){
				alert("삭제성공")
				location.href="/noticeboard/nboard"
			}
		},
		error:function(e){
			alert("삭제실패 : "+e)
		}
	})//ajax
})//btnDelete

init();

</script>