<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<!DOCTYPE html>
<html lang="kor">
<head>       
	<title>Forum post list - Bootdey.com</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<!-- 	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"> -->
	 <link href="css/board.css" rel="stylesheet" />
</head>
<body>


<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<div class="wrapper wrapper-content animated fadeInRight">
				<div class="ibox-content forum-container">

					<div class="forum-item">
						<div class="row">
							<div class="col-md-7">
								<div class="forum-icon">
									<i class="fa fa-bookmark"></i>
								</div>
								<a href="forum_post.html" class="forum-item-title">게시글 1</a>
								<div class="forum-sub-title">게시글 내용1</div>
							</div>
							<div class="col-md-2 forum-info">
								<div>
									<small>작성일 </small>
								</div>
                            <span class="views-number">
                                날짜
                            </span>

							</div>
							<div class="col-md-2 forum-info">
								<div>
									<small>조회수</small>
								</div>
                            <span class="views-number">
                                조회수(숫자)
                            </span>

							</div>
							<!-- <div class="col-md-1 forum-info">
                            <span class="views-number">
                              <span class="fa-stack">
										<i class="fa fa-square fa-stack-2x"></i>
										<i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
									</span>
                            </span>

							</div> -->
						</div>
					</div>
					<div class="forum-item">
						<div class="row">
							<div class="col-md-7">
								<div class="forum-icon">
									<i class="fa fa-bookmark"></i>
								</div>
								<a href="forum_post.html" class="forum-item-title">게시글 2</a>
								<div class="forum-sub-title">게시글 내용2</div>
							</div>
							<div class="col-md-2 forum-info">
								<div>
									<small>작성일</small>
								</div>
								<span class="views-number">
                                날짜
                            </span>

							</div>
							<div class="col-md-2 forum-info">
								<div>
									<small>조회수</small>
								</div>
                            <span class="views-number">
                                조회수(숫자)
                            </span>

							</div>
							<!-- <div class="col-md-1 forum-info">
                            <span class="views-number">
                              <span class="fa-stack">
										<i class="fa fa-square fa-stack-2x"></i>
										<i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
									</span>
                            </span>

							</div> -->
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>

<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
</body>
</html>