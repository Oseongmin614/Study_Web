<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판리스트</title>
<script>
	window.onload = function() {
		let addBtn = document.querySelector('#addBtn')
		addBtn.addEventListener('click', function() {
			location.href = "/Board-WEB/board/writeForm.do"
		})
	}
</script>
<link rel="stylesheet" href="/Board-WEB/resources/css/layout.css">
<link rel="stylesheet" href="/Board-WEB/resources/css/my_css.css">
</head>
<body>
	<header>
		<jsp:include page="/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
			<hr>
			<h2>전체게시판</h2>
			<hr>
			<br>
			
			<table style="width: 100%;">
				<tr>
					<th width="7%">번호</th>
					<th>제목</th>
					<th width="15%">작성자</th>
					<th width="17%">등록일</th>
				</tr>
				
				<c:forEach items="${ boardList }" var="board" >
						<tr>
							<td>${ board.no }</td>
							<td>
								<a href="detail.jsp?no=${ board.no }">
									<c:out value="${ board.title }" />
								</a>
							</td>
							<td>${ board.writer }</td>
							<td>${ board.regDate }</td>
						</tr>
						
				</c:forEach>		
			</table>
			<br>
			<button id="addBtn" class="button">새글등록</button>
		</div>
	</section>
	<footer>
		<%@ include file="/include/footer.jsp" %>
	</footer>
</body>
</html>
















