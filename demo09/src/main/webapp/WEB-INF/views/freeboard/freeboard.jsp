<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>


<div class="container">
	<br/><br/>
	<h2>자유게시판(${count })</h2>
	<br/>
	<div class="form-group text-right">

	</div>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${freeboard.content}" var="board" varStatus="st">
				<tr>
					<td>${rowNo-st.index}</td>
					<td><a href="/freeboard/view/${board.num}">(${board.free }) ${board.title }[${board.replycnt }]</a></td>
					<td>${board.member.id }</td>
					<td><fmt:formatDate value="${board.regdate}"
							pattern="yyyy-MM-dd" /> <%--  /${board.regdate }  --%></td>
					<td>${board.hitcnt }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	 <sec:authorize access="isAuthenticated()">
			<a href="/freeboard/insert">
			<button type="button" class="btn btn-secondary btn-sm" id="writeBtn">글쓰기</button>
		</a>
		</sec:authorize>
		
	<div class="d-flex justify-content-between mt-5 mr-auto" align="center">
		<ul class="pagination">
			<!-- 처음페이지 -->
			<c:if test="${freeboard.first==false }">
				<li class="page-item"><a class="page-link"
					href="/freeboard/board?page=0">처음페이지</a></li>
			</c:if>
			<!-- 페이지 -->
			<c:forEach begin="${startPage }" end="${endPage }" var="i">
				<c:if test="${currentPage == i }">
					<li class="page-item active"><a class="page-link" href="#">${i}</a></li>
				</c:if>
				<c:if test="${currentPage != i }">
		 	<li class="page-item"><a class="page-link" href="board?page=${i-1 }">${i}</a></li>
				</c:if>
			</c:forEach>
			<!-- 끝페이지 -->
			<c:if test="${freeboard.last==false }">
				<li class="page-item"><a class="page-link"
					href="?page=${countPage-1 }">끝페이지</a></li>
			</c:if>
		</ul>
		
		
	
		<div>
			<form class="" action="/freeboard/board" method="get">
				<div>
				　　　　　　
				　　<select name='field' id="field" class="f
				orm-control mr-sm-1">
			         <option value="title">제목</option>
					<option value="content">내용</option>
				</select> <br/> <input type='text' name='word' class="form-control mr-sm-1" style="width:200px; height:30px;" placeholder="Search"></div>
					
				     　　　　　　　　<button class='btn btn-secondary btn-sm'>Search</button>
			</form>
		</div>
		</div>
</div>


<%@ include file="../includes/footer.jsp"%>

