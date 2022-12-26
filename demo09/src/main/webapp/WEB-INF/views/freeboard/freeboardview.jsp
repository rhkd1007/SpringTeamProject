<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
<input type="hidden" name="num" id="num" value="${freeboard.num }"/>
<br>
	<h3>${freeboard.member.id }의글보기</h3>
	<div class="form-group">
		<label for="title">제목:</label> <input type="text" class="form-control"
			id="title" name="title" value="(${freeboard.free})${freeboard.title }" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="pwd">작성자:</label> <input type="text" class="form-control"
			id="writer" name="writer" value="${freeboard.member.id}"
			readonly="readonly">
	</div><div class="form-group">
	<img class="card-img-top" src="/resources/img/${freeboard.fileimage }" alt="" style="max-width:1000px; max-height:1000px; width:auto; height:auto" >
	</div>
	<div class="form-group">
		<label for="content">내용:</label>
		
		<textarea class="form-control" rows="5" id="content" name="content"
			readonly="readonly">${freeboard.content }
			
			</textarea>
	</div>
	<br/>
	<div class="form-group text-right">
<c:if test="${principal.member.id==freeboard.member.id }">
	
		<br/><button type="button" class="btn btn-secondary btn-sm" id="btnUpdate">수정</button>
		<button type="button" class="btn btn-danger btn-sm" id="btnDelete">삭제</button>
	
</c:if>

<button type="button" class="btn btn-primary btn-sm" id="btnList">목록</button>
</div>
<br/>
<br/>

		
<div align="center">
	<textarea rows="3" cols="50" id="msg"></textarea>
	<button type="button" class="btn btn-secondary btn-sm" id="btnComment">댓글쓰기</button>
</div>

<div id="replyResult"></div>
</div>

<script>
//목록
$("#btnList").click(function(){
	location.href="/freeboard/board";
})

//댓글추가
var init = function(){
	$.ajax({
		type:'get',
		url:'/reply/list/'+$("#num").val()
	})
	.done(function(resp){
		var str="<table class='table table-hover'><thead><tr><th>작성자</th><th>내용</th><th>작성일</th><th>삭제</th></tr></thead>";

		$.each(resp,function(key,val){
			str+="<tbody>"
			str+="<tr>"
			str+="<td>"+val.member.id+"</td>"
			str+="<td>"+val.fcontent+"</td>"
			str+="<td>"+val.fregdate+"</td>"
			if("${principal.member.username}"==val.member.username){str+="<td><a href='javascript:fdel("+val.fcnum+")'>삭제<a/></td>"}
			str+="</tr>"
			str+="</tbody>"
		})//each
		str+="</table>"
		$("#replyResult").html(str)
	})//done
}//init
$("#btnComment").click(function(){
	if(${empty principal.member}){
		alert("로그인 하세요");
		location.href="/member/login";
		return;		
	}
	if($("#msg").val()==""){
			alert("댓글 입력하세요");
			return;
		}
		var data={
				"fbnum":$("#num").val(),
				"fcontent":$("#msg").val(),
				"user_id":$("#writer").val()
		}
		$.ajax({
			type:'POST',
			url:'/reply/insert/'+$("#num").val(),
			contentType: "application/json;charset=utf-8",
			data: JSON.stringify(data)
		})
		.done(function(resp,status){
			alert(status)
			alert("댓글추가 성공")
			init();
		})
		.fail(function(){
			alert("댓글 추가 실패");
		})
	})//btnComment

//수정폼
$("#btnUpdate").click(function(){
	if(confirm("정말 수정할까요?")){
		location.href="/freeboard/update/${freeboard.num}"
	}
})

//삭제
$("#btnDelete").click(function(){
	if(!confirm("정말 삭제할까요?"))return
	$.ajax({
		type:'delete',
		url:'/freeboard/delete/${freeboard.num}',
		success:function(resp){
			if(resp=="success"){
				alert("삭제성공")
				location.href="/freeboard/board"
			}
		},
		error:function(e){
			alert("삭제실패 : "+e)
		}
	})//ajax	
})//btnDelete



//댓글삭제
function fdel(fcnum){
	$.ajax({
		type:"DELETE",
		url:"/reply/del/"+fcnum
	})
	.done(function(resp){
		alert("댓글 삭제 성공")
		init()
	})
	.fail(function(){
		alert("댓글 삭제 실패")
	})
}init()
</script>

<%@ include file="../includes/footer.jsp"%>
