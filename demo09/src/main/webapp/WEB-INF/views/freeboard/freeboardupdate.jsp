<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<div class="container">
<br/>
<h3>${freeboard.member.id } 의 글 수정하기</h3>
<input type="hidden" name="num" id="num" value="${freeboard.num }" />
	<div class="form-group">
		<label for="title">제목:</label> <input type="text" class="form-control"
			id="title" name="title" value="${freeboard.title }">
	</div>
	<div class="form-group">
		<label for="writer">글쓴이:</label> <input type="text" class="form-control"
			id="writer" name="writer" value="${freeboard.member.id }" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="content">내용</label>
		<textarea class="form-control" rows="5" id="content" name="content">${freeboard.content }</textarea>
	</div>
	<div class="form-group">
      <label for="upload">파일:</label>
      <input type="file" class="form-control" id="upload" placeholder="Enter file" name="upload"  />
    </div>
    <br/>
	<div class="form-group text-right">
		<button type="button" class="btn btn-secondary btn-sm" id="btnModify">수정하기</button>
	</div>
</div>

 <script>
$("#btnModify").click(function(){
	data = {
			"num" : $("#num").val(),
			"title" : $("#title").val(),
			"content" : $("#content").val()
			
	}
	$.ajax({
		type:'put',
		url:"/freeboard/update",
		contentType: "application/json;charset=utf-8"  ,
		data :  JSON.stringify(data),
		success: function(resp){
			alert("수정 성공")
		   location.href="/freeboard/board"
		}
	}) //ajax
})//btnModify

</script>
<%@ include file="../includes/footer.jsp"%>