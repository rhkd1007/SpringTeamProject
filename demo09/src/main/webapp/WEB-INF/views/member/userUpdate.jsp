<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<div class="container">
<br>
	<input type = "hidden" id="num" value="${member.num }" >
	     <div class="form-group">
				<label for="id">이름:</label> <input type="text"
					class="form-control" id="id" value="${member.id }"
					name="id" >
			</div>
			<div class="form-group">
				<label for="username">아이디:</label> <input type="text"
					class="form-control" id="username" value="${member.username }"
					name="username" readonly="readonly">
			</div>
		<div class="form-group">
			<label for="pwd">비밀번호:</label> <input type="password"
				class="form-control" id="pwd" value="" name="pwd">
		</div>
		
	<%-- <div class="form-group">
			<label for="pass_check">비밀번호 확인:</label> 
			<input type="password" class="form-control" id="pass_check" placeholder="Enter pass_check"
				name="pass_check">
		</div> 

		<div class="form-group">
			<label for="name">이름:</label> <input type="text" id="name"
				name="name" class="form-control" value="${sMember.name }">
		</div> --%>

		<div class="form-group">
			<label for="email">주소:</label> <input type="text" id="email"
				name="email" class="form-control" value="${member.email }">
		</div>
		<br>
		<div class="form-group text-right">
		<button type="button" class="btn btn-secondary" id="btnUpdate">회원수정</button>
	</div>
	</div>
	<script>
	$("#btnUpdate").click(function(){

		  data = {
				  
				  "num" : $("#num").val(),
				  "id" : $("#id").val(),
				  "username" : $("#username").val(),
				  "pwd" : $("#pwd").val(),
				  "email" : $("#email").val()
		  } 
			$.ajax({  //post  join
				type:"put",
				url :"/member/update",
				contentType: "application/json;charset=utf-8",
				data: JSON.stringify(data)
			})
			.done(function(resp){
					if(resp=="success"){
						alert("회원변경 성공")
						location.href="/member/login";
					}
			})
			. fail(function(e){
					alert("회원변경실패")
			}) //ajax
				
	}) //btnJoin
	
	
	</script>
