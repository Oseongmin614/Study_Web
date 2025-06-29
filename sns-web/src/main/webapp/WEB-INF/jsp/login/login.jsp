<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("pageTitle", "로그인 - MySNS");
%>
<jsp:include page="/WEB-INF/jsp/include/header.jsp" />
<jsp:include page="/WEB-INF/jsp/include/sidebar.jsp" />

<div class="container" style="max-width:400px; margin:60px auto;">
    <div class="card">
        <div class="card__body">
            <h2 class="text-center mb-16">로그인</h2>
            <form method="post" action="${pageContext.request.contextPath}/login.do">
                <div class="mb-16">
                    <label for="email" class="mb-8">이메일</label>
                    <input type="email" id="email" name="email" class="search-input" required placeholder="이메일을 입력하세요">
                </div>
                <div class="mb-16">
                    <label for="password" class="mb-8">비밀번호</label>
                    <input type="password" id="password" name="password" class="search-input" required placeholder="비밀번호를 입력하세요">
                </div>
                <button type="submit" class="btn btn--primary w-100 mb-16">로그인</button>
            </form>
            <div class="text-center">
                <a href="${pageContext.request.contextPath}/signup.jsp" class="text-muted">회원가입</a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/include/footer.jsp" />
