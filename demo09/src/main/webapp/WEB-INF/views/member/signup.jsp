<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<div class="container">
	<br/>
	<h3>회원가입</h3>
	<br/>
	<div class="form-group">
		<label for="id">이름:</label> <input type="text"
			class="form-control" id="id" placeholder="Enter ID"
			name="id">
	</div><br/>
	<div class="form-group">
		<label for="username">id:</label> <input type="text"
			class="form-control" id="username" placeholder="Enter username"
			name="username">
	</div><br/>
	<div class="form-group">
		<label for="password">비밀번호:</label> <input type="password"
			class="form-control" id="password" placeholder="Enter password"
			name="password">
	</div><br/>
	<div class="form-group">
		<label for="password">비밀번호 확인:</label> <input type="password"
			class="form-control" id="password_chk" placeholder="Enter password"
			name="password_chk">
	</div><br/>
	<div class="form-group">
		<label for="age">나이:</label> <input type="text"
			class="form-control" id="age" placeholder="Enter age"
			name="age">
	</div><br/>
	<div class="form-group">
		<label for="email">이메일:</label> <input type="text"
			class="form-control" id="email" placeholder="Enter email"
			name="email">
	</div><br/>
	<div class="form-group">
		<label for="city">사는 곳:</label> <input type="text"
			class="form-control" id="city" placeholder="Enter city"
			name="city">
	</div><br/>
	<button class="btn btn-secondary" id="btnSignup">회원가입</button>
</div>

	<script>
		$("#btnSignup").click(function() {
			if ($("#id").val() == "") {
				alert("아이디를 입력하세요")
				$("#id").focus();
				return false;
			}
			if ($("#username").val() == "") {
				alert("이름을 입력하세요")
				$("#username").focus();
				return false;
			}
			if ($("#password").val() == "") {
				alert("비밀번호를 입력하세요")
				$("#password").focus();
				return false;
			}
			if ($("#password").val() !=$("#password_chk").val()) {
				alert("비밀번호가 일치하지않습니다")
				$("#password").focus();
				return false;
			}
			if ($("#email").val() == "") {
				alert("이메일을 입력하세요")
				$("#email").focus();
				return false;
			}
			if ($("#age").val() == "") {
				alert("나이를 입력하세요")
				$("#age").focus();
				return false;
			}
			if ($("#city").val() == "") {
				alert("사는곳을 입력하세요")
				$("#city").focus();
				return false;
			}
			var dataParam = {
					"id":$("#id").val(),
				"username" : $("#username").val(),
				"pwd" : $("#password").val(),
				"email" : $("#email").val(),
				"age" : $("#age").val(),
				"city" : $("#city").val()
			}
			$.ajax({
				type : "POST",
				url : "/member/signup",
				contentType : "application/json;charset=utf-8",
				data : JSON.stringify(dataParam)
			}).done(function(resp) {
				if (resp == "success") {
					alert("회원가입성공")
					location.href="/member/login"
				} else if (resp == "fail") {
					alert("아이디가 중복입니다")
					$("#id").val("")
				}
			}) //done
			.fail(function() {
				alert("회원가입실패")
			})
		})
	</script>

<%@ include file="../includes/footer.jsp"%>