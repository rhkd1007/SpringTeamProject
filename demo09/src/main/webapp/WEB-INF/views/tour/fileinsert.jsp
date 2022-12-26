<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<div class="container">
<h3>File Board Insert</h3>

<form action="fileInsert/insert" method="post" enctype="multipart/form-data">

        <div class="form-group">
      <label for="ttitle">제목:</label>
      <input type="text" class="form-control" id="ttitle" placeholder="Enter title" name="ttitle">
    </div>
    
    <div class="form-group">
      <label for="twriter">작성자:</label>
      <input type="text" class="form-control" id="twriter" placeholder="Enter writer" name="twriter"  />
    </div>
    <div class="form-group">
      <label for="tregion">지역:</label>
      <textarea class="form-control" rows="5" id="tregion" name="tregion"></textarea>
    </div>
<div class="form-group">
      <label for="tupload">파일:</label>
      <input type="file" class="form-control" id="tupload" placeholder="Enter file" name="tupload"  />
    </div>
        <div class="form-group">
      <label for="tcontent">내용:</label>
      <textarea class="form-control" rows="5" id="tcontent" name="tcontent"></textarea>
    </div>
    
    <div align="right">
    	<button type="submit" class="btn btn-info">글쓰기</button>
    	</div>
    	
</form>

</div>