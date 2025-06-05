<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<table style="width:100%" id="topMenu">
	<tr>
		<td rowspan="2" style="width: 240px; height: 80px;">
			<img src="/Board-WEB/resources/images/logo.png" style="width: 240px; height: 80px;">
		</td>
		<td align="right">${ empty userVO ? "GUEST" : userVO.name }님 환영합니다</td>
	</tr>
	<tr>
		<td>
			<nav>
				<c:if test="${ userVO.type eq 'S' }">
					회원관리 |
				</c:if>
				<a href="/Board-WEB/board/list.do">게시판</a> |
				<c:choose>
					<c:when test="${ empty userVO }">
						회원가입 |
						<a href="/Board-WEB/login.do">로그인</a> |
					</c:when>
					<c:otherwise>
						마이페이지 |
						<a href="/Board-WEB/logout.do">로그아웃</a> 
				</c:otherwise>
				</c:choose>
			</nav>
		</td>
	</tr>
</table>