<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>
        <c:choose>
            <c:when test="${not empty pageTitle}">
                ${pageTitle}
            </c:when>
            <c:otherwise>
                MySNS
            </c:otherwise>
        </c:choose>
    </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
</head>
<!-- Header -->
<header class="header">
    <div class="header-content">
        <div class="header-left">
            <!-- Mobile Menu Toggle -->
            <button class="menu-toggle" id="menuToggle">
                <span></span>
                <span></span>
                <span></span>
            </button>
            <!-- Logo -->
            <h1 class="logo">Ananas</h1>
        </div>
        
        <!-- Search Bar (Desktop) -->
        <div class="header-center">
            <div class="search-box">
                <input type="text" class="search-input" placeholder="검색어를 입력하세요...">
                <button class="search-btn">🔍</button>
            </div>
        </div>
        
        <!-- User Actions -->
        <div class="header-right">
            <div class="user-actions">
                <button class="action-btn" title="메시지">📬</button>
                <button class="action-btn" title="알림">🔔</button>
                
                <!-- User Profile -->
                <div class="user-profile">
                <img src="${pageContext.request.contextPath}/images/Ananas.JPG" 
                             alt="내 프로필" class="composer-avatar">
                   
                    <span class="profile-name">로그인</span>
                </div>
            </div>
        </div>
    </div>
</header>
