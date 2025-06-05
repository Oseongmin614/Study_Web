<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#content > * {
		width: 80%;
	}
</style>
<script>
	let checkForm = function() {
		let f = document.wForm
		if(f.title.value == '') {
			alert('제목을 입력해주세요')
			f.title.focus()
			return false
		}
		
		if(f.writer.value == '') {
			alert('작성자를 입력해주세요')
			f.writer.focus()
			return false
		}
		
		if(f.content.value == '') {
			alert('내용을 입력해주세요')
			f.content.focus()
			return false
		}
		return true
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
		<div align="center" id="content">
			<hr>
			<h2>새글등록</h2>
			<hr>
			<br>
			<form name="wForm" action="/Board-WEB/board/write.do" method="post" onsubmit="return checkForm()">
				<input type="hidden" name="writer" value="${ userVO.id }" />
				<table style="width: 100%;">
					<tr>
						<th width="25%">제목</th>
						<td><input type="text" name="title" > </td>
					</tr>
					<tr>
						<th width="25%">작성자</th>
						<td><c:out value="${ userVO.id }" /></td>
						
						<%-- <td><input type="text" name="writer" value="${ userVO.id }" readonly> </td> --%>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content" rows="8" cols="50"></textarea></td>
					</tr>
				</table>
				<br>
				<button type="submit">등록</button>
			</form>
		</div>
	</section>
	<footer>
		<%@ include file="/include/footer.jsp" %>
	</footer>
</body>
</html>




















