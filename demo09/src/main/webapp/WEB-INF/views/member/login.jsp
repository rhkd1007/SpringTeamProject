<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../includes/header.jsp"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="container">
	<br/>
	<h3>로그인</h3><br/>
	<form action="/member/login" method="post">
		<div class="form-group">
			<label for="username">아이디:</label> <input type="text" id="username"
				name="username" class="form-control" placeholder="Enter ID" />
		</div>
		<div class="form-group">
			<label for="pass">비밀번호:</label> <input type="password"
				class="form-control" id="pass" placeholder="Enter password"
				name="password"><br/>
		</div>
		<button class="btn btn-primary">로그인</button>
    <br/>
	<br/>
    <a href="/oauth2/authorization/google">
    <img src="../assets/img/btn_google.png">
    </a>

    </form>

    </div>


</div>
<%@ include file="../includes/footer.jsp"%>