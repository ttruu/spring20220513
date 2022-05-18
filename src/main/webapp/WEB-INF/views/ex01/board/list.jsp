<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css"
	integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	referrerpolicy="no-referrer"></script>

<title>Insert title here</title>
</head>
<body>
	<my:navBar current="list" />
	
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>글 목록</h1>

				<table class="table table-striped">
					<thead>
						<tr>
							<th>
								<i class="fa-solid fa-hashtag"></i>
							</th>
							<th>title</th>
							<th>
								<i class="fa-solid fa-calendar"></i>
							</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${boardList }" var="board">
							<tr>
								<td>${board.id }</td>
								<td>
									<c:url value="/ex01/board/${board.id }" var="link" />
									<a href="${link }"> ${board.title } </a>

									<!-- 댓글 갯수 보여주기 -->
									<c:if test="${board.numOfReply > 0}">
										<span>
											<i class="fa-solid fa-comment-dots"></i>
											[${board.numOfReply }]
										</span>
									</c:if>
								</td>

								<td>${board.inserted }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div id="mt-3">
				<ex:PageNation path="list"/>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>