<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!-- 사이드바 컨테이너 -->
<div class="sidebar">
  <!-- 사이드바 헤더 (로고) -->
  <div class="sidebar-header">
    <a href="/index.jsp">
      <div class="sidebar-logo">
        <img src="/images/cream.png" alt="또또와 로고">
      </div>
      <span>또또와</span>
    </a>
  </div>

  <!-- 네비게이션 메뉴 -->
  <nav class="sidebar-nav">
    <div class="nav-section">
      <!-- 홈 -->
      <div class="nav-item">
        <a href="/index.jsp" class="nav-link active">
          <div class="nav-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor">
              <path d="m3 9 9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"/>
              <polyline points="9,22 9,12 15,12 15,22"/>
            </svg>
          </div>
          홈
        </a>
      </div>

      <!-- 마이페이지 -->
      <div class="nav-item">
        <a href="/profile.jsp" class="nav-link">
          <div class="nav-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor">
              <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"/>
              <circle cx="12" cy="7" r="4"/>
            </svg>
          </div>
          마이페이지
        </a>
      </div>

      <!-- 피드 -->
      <div class="nav-item">
        <a href="/feed.jsp" class="nav-link">
          <div class="nav-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor">
              <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"/>
              <polyline points="14,2 14,8 20,8"/>
              <line x1="16" y1="13" x2="8" y2="13"/>
              <line x1="16" y1="17" x2="8" y2="17"/>
              <polyline points="10,9 9,9 8,9"/>
            </svg>
          </div>
          피드
          <span class="nav-badge">5</span>
        </a>
      </div>

      <!-- 인기글 -->
      <div class="nav-item">
        <a href="/popular.jsp" class="nav-link">
          <div class="nav-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor">
              <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"/>
            </svg>
          </div>
          인기글
        </a>
      </div>

      <!-- 좋아요 -->
      <div class="nav-item">
        <a href="/likes.jsp" class="nav-link">
          <div class="nav-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor">
              <path d="M20.84 4.61a5.5 5.5 0 0 0-7.78 0L12 5.67l-1.06-1.06a5.5 5.5 0 0 0-7.78 7.78l1.06 1.06L12 21.23l7.78-7.78 1.06-1.06a5.5 5.5 0 0 0 0-7.78z"/>
            </svg>
          </div>
          좋아요
        </a>
      </div>

      <!-- 검색 -->
      <div class="nav-item">
        <a href="/search.jsp" class="nav-link">
          <div class="nav-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor">
              <circle cx="11" cy="11" r="8"/>
              <path d="m21 21-4.35-4.35"/>
            </svg>
          </div>
          검색
        </a>
      </div>

      <!-- 채팅 -->
      <div class="nav-item">
        <a href="/chat.jsp" class="nav-link">
          <div class="nav-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor">
              <path d="M21 15a2 2 0 0 1-2 2H7l-4 4V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2z"/>
            </svg>
          </div>
          채팅
          <span class="nav-badge">3</span>
        </a>
      </div>
    </div>
  </nav>

  <!-- 사이드바 푸터 (사용자 프로필) -->
  <div class="sidebar-footer">
    <div class="user-profile" onclick="toggleUserMenu()">
      <div class="user-avatar">
        또
      </div>
      <div class="user-info">
        <div class="user-name">또또와 사용자</div>
        <div class="user-status">온라인</div>
      </div>
      <div class="nav-icon">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor">
          <polyline points="6 9 12 15 18 9"/>
        </svg>
      </div>
    </div>
  </div>
</div>

<!-- 모바일 메뉴 토글 버튼 -->
<button class="mobile-menu-toggle" onclick="toggleSidebar()">
  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
    <line x1="3" y1="6" x2="21" y2="6"/>
    <line x1="3" y1="12" x2="21" y2="12"/>
    <line x1="3" y1="18" x2="21" y2="18"/>
  </svg>
</button>

<script>
// 사이드바 토글 (모바일)
function toggleSidebar() {
  const sidebar = document.querySelector('.sidebar');
  sidebar.classList.toggle('open');
}

// 사용자 메뉴 토글
function toggleUserMenu() {
  // 사용자 메뉴 드롭다운 기능 구현
  console.log('사용자 메뉴 클릭됨');
}

// 현재 페이지에 따른 active 클래스 설정
document.addEventListener('DOMContentLoaded', function() {
  const currentPath = window.location.pathname;
  const navLinks = document.querySelectorAll('.nav-link');
  
  navLinks.forEach(link => {
    link.classList.remove('active');
    if (link.getAttribute('href') === currentPath) {
      link.classList.add('active');
    }
  });
});

// 사이드바 외부 클릭 시 닫기 (모바일)
document.addEventListener('click', function(e) {
  const sidebar = document.querySelector('.sidebar');
  const toggleBtn = document.querySelector('.mobile-menu-toggle');
  
  if (window.innerWidth <= 1024 && 
      !sidebar.contains(e.target) && 
      !toggleBtn.contains(e.target)) {
    sidebar.classList.remove('open');
  }
});
</script>