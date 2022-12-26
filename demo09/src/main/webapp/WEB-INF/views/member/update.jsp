<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<div class="container">
	<br/>
	<h3>회원정보 수정</h3>
	<br/>
	<form action="/member/update/${principal.member.num }" method="post">
	
	<input type="hidden" id="num" value="${principal.member.num }">
	<%-- <input type="hidden" id="passCheck" value="${principal.member.pwd }"> --%>
	
	<div class="form-group">
				<label for="id">이름:</label> <input type="text"
					class="form-control" id="id" value="${principal.member.id }"
					name="id">
			</div>
			<br/>
			
	     <div class="form-group">
				<label for="username">아이디:</label> <input type="text"
					class="form-control" id="username" value="${principal.member.username }"
					name="username" readonly="readonly">
			</div>
			<br/>
			
		<div class="form-group">
			<label for="password">비밀번호:</label> <input type="password"
				class="form-control" id="password" value="" name="password">
		</div>
		<br/>
		
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
			<label for="email">이메일:</label> <input type="text" id="email"
				name="email" class="form-control" value="${principal.member.email }">
		</div>
		<br/>
		
		<div class="form-group">
			<label for="city">주소:</label> <input type="text" id="city"
				name="city" class="form-control" value="${principal.member.city }">
		</div>
		<br>
		
		<button type="button" class="btn btn-secondary" id="btnUpdate">회원수정</button>
	</form>
</div>	

	<script>
	$("#btnUpdate").click(function(){
		   //유효성검사
		if($("#id").val()==""){
			alert("이름을 입력하세요");
			$("#id").focus();
			return false;
		}
		if($("#password").val()==""){
			alert("비밀번호를 입력하세요");
			$("#password").focus();
			return false;
		}
		 /* if($("#passCheck").val()!=$("#password").val()){
			alert("비번이 맞지 않습니다.");
			$("#password").focus();
			return false;
		} */
		/*if($("#name").val()==""){
			alert("이름을 입력하세요");
			$("#name").focus();
			return false;
		} */
		if($("#email").val()==""){
			alert("이메일을 입력하세요");
			$("#email").focus();
			return false;
		}
		if($("#city").val()==""){
			alert("주소를 입력하세요");
			$("#city").focus();
			return false;
		}
		  data = {
				  "num" : $("#num").val(),
				  "id" : $("#id").val(),
				  "username" : $("#username").val(),
				  "pwd" : $("#password").val(),
				  "email" : $("#email").val(),
				  "city" : $("#city").val()
		  } 
			$.ajax({  //post  join
				type:"put",
				url :"/member/memberUpdate",
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

<%@ include file="../includes/footer.jsp"%>