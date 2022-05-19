<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="current"%>

<c:url value="/ex01/board/list" var="listUrl"></c:url>
<c:url value="/ex01/board/write" var="writeUrl"></c:url>

<nav class="navbar navbar-expand-sm navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="${listUrl }">
			<i class="fa-solid fa-house"></i>
		</a>
		<div class="navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link ${current == 'list' ? 'active' : '' }"
						href="${listUrl}">목록보기</a>
				</li>
				<li class="nav-item">
					<a class="nav-link ${current == 'write' ? 'active' : '' }"
						href="${writeUrl}">글쓰기</a>
				</li>
			</ul>

		
		<!-- 검색 -->
		<!-- 	<form class="" role="search">
				<select name="searchType">
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="title_content">제목+내용</option>
					<option value="writer">작성자</option>
				</select>

				<input class="form-control me-2" name="keyword" id="keyword"
					type="search" placeholder="Search" aria-label="Search"/>

				<button class="btn btn-outline-success" name="btnSearch"
					id="btnSearch" type="submit">검색</button>			
			</form> -->

		</div>
	</div>
</nav>
