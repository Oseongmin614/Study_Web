<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>또또와 - 여름 SNS</title>
    <link rel="stylesheet" href="/css/perplexity-layout.css">
    <link rel="icon" href="/images/cream.png" type="image/png">
</head>
<body>
    <div class="app-container">
        <!-- 사이드바 include -->
        <%@ include file="/WEB-INF/jsp/include/sidebar.jsp" %>
        
        <!-- 메인 콘텐츠 영역 -->
        <main class="main-content">
            <!-- 헤더 섹션 -->
            <header style="margin-bottom: 40px;">
                <h1 style="font-size: 2.5rem; font-weight: 700; color: #1f2937; margin-bottom: 16px;">
                    환영합니다! <span style="color: #667eea;">또또와</span>에서
                </h1>
                <p style="font-size: 1.2rem; color: #6b7280; line-height: 1.8; max-width: 800px;">
                    시원하고 달콤한 여름, <strong style="color: #667eea;">또또와</strong>에서 새로운 친구들과 함께 
                    즐거운 추억을 만들어보세요. 다채로운 이야기와 생생한 소통이 여러분을 기다립니다.
                </p>
            </header>

            <!-- 피처 카드 섹션 -->
            <section style="display: grid; grid-template-columns: repeat(auto-fit, minmax(300px, 1fr)); gap: 24px; margin-bottom: 48px;">
                <!-- 피드 카드 -->
                <div style="background: white; border-radius: 16px; padding: 24px; box-shadow: 0 4px 16px rgba(0, 0, 0, 0.08); border: 1px solid #f3f4f6;">
                    <div style="display: flex; align-items: center; margin-bottom: 16px;">
                        <div style="width: 48px; height: 48px; background: linear-gradient(135deg, #667eea, #764ba2); border-radius: 12px; display: flex; align-items: center; justify-content: center; margin-right: 16px;">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="white" stroke-width="2">
                                <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"/>
                                <polyline points="14,2 14,8 20,8"/>
                                <line x1="16" y1="13" x2="8" y2="13"/>
                                <line x1="16" y1="17" x2="8" y2="17"/>
                            </svg>
                        </div>
                        <h3 style="font-size: 1.25rem; font-weight: 600; color: #1f2937;">최신 피드</h3>
                    </div>
                    <p style="color: #6b7280; line-height: 1.6;">친구들의 새로운 소식과 재미있는 이야기들을 확인해보세요.</p>
                    <a href="/feed.jsp" style="display: inline-flex; align-items: center; margin-top: 16px; color: #667eea; text-decoration: none; font-weight: 500;">
                        피드 보기 
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" style="margin-left: 4px;">
                            <polyline points="9 18 15 12 9 6"/>
                        </svg>
                    </a>
                </div>

                <!-- 인기글 카드 -->
                <div style="background: white; border-radius: 16px; padding: 24px; box-shadow: 0 4px 16px rgba(0, 0, 0, 0.08); border: 1px solid #f3f4f6;">
                    <div style="display: flex; align-items: center; margin-bottom: 16px;">
                        <div style="width: 48px; height: 48px; background: linear-gradient(135deg, #f093fb, #f5576c); border-radius: 12px; display: flex; align-items: center; justify-content: center; margin-right: 16px;">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="white" stroke-width="2">
                                <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"/>
                            </svg>
                        </div>
                        <h3 style="font-size: 1.25rem; font-weight: 600; color: #1f2937;">인기글</h3>
                    </div>
                    <p style="color: #6b7280; line-height: 1.6;">지금 가장 화제가 되고 있는 글들을 만나보세요.</p>
                    <a href="/popular.jsp" style="display: inline-flex; align-items: center; margin-top: 16px; color: #f5576c; text-decoration: none; font-weight: 500;">
                        인기글 보기 
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" style="margin-left: 4px;">
                            <polyline points="9 18 15 12 9 6"/>
                        </svg>
                    </a>
                </div>

                <!-- 채팅 카드 -->
                <div style="background: white; border-radius: 16px; padding: 24px; box-shadow: 0 4px 16px rgba(0, 0, 0, 0.08); border: 1px solid #f3f4f6;">
                    <div style="display: flex; align-items: center; margin-bottom: 16px;">
                        <div style="width: 48px; height: 48px; background: linear-gradient(135deg, #4facfe, #00f2fe); border-radius: 12px; display: flex; align-items: center; justify-content: center; margin-right: 16px;">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="white" stroke-width="2">
                                <path d="M21 15a2 2 0 0 1-2 2H7l-4 4V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2z"/>
                            </svg>
                        </div>
                        <h3 style="font-size: 1.25rem; font-weight: 600; color: #1f2937;">실시간 채팅</h3>
                    </div>
                    <p style="color: #6b7280; line-height: 1.6;">친구들과 실시간으로 대화하고 소통해보세요.</p>
                    <a href="/chat.jsp" style="display: inline-flex; align-items: center; margin-top: 16px; color: #00f2fe; text-decoration: none; font-weight: 500;">
                        채팅하기 
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" style="margin-left: 4px;">
                            <polyline points="9 18 15 12 9 6"/>
                        </svg>
                    </a>
                </div>
            </section>

            <!-- 로고 섹션 -->
            <section style="text-align: center; margin-bottom: 48px;">
                <div style="display: inline-block; padding: 32px; background: white; border-radius: 24px; box-shadow: 0 8px 32px rgba(0, 0, 0, 0.12); border: 1px solid #f3f4f6;">
                    <img src="/images/cream.png" alt="또또와 메인 로고" 
                         style="width: 120px; height: 120px; border-radius: 20px; box-shadow: 0 4px 16px rgba(0, 0, 0, 0.1); margin-bottom: 16px;">
                    <h2 style="font-size: 1.5rem; font-weight: 700; color: #1f2937; margin-bottom: 8px;">또또와</h2>
                    <p style="color: #6b7280; font-size: 1rem;">여름처럼 상쾌한 SNS</p>
                </div>
            </section>

            <!-- 통계 섹션 -->
            <section style="background: white; border-radius: 16px; padding: 32px; box-shadow: 0 4px 16px rgba(0, 0, 0, 0.08); border: 1px solid #f3f4f6;">
                <h2 style="font-size: 1.5rem; font-weight: 700; color: #1f2937; margin-bottom: 24px; text-align: center;">또또와 통계</h2>
                <div style="display: grid; grid-template-columns: repeat(auto-fit, minmax(150px, 1fr)); gap: 24px;">
                    <div style="text-align: center;">
                        <div style="font-size: 2rem; font-weight: 800; color: #667eea; margin-bottom: 8px;">1,234</div>
                        <div style="color: #6b7280; font-size: 0.9rem;">활성 사용자</div>
                    </div>
                    <div style="text-align: center;">
                        <div style="font-size: 2rem; font-weight: 800; color: #f5576c; margin-bottom: 8px;">5,678</div>
                        <div style="color: #6b7280; font-size: 0.9rem;">총 게시글</div>
                    </div>
                    <div style="text-align: center;">
                        <div style="font-size: 2rem; font-weight: 800; color: #00f2fe; margin-bottom: 8px;">9,012</div>
                        <div style="color: #6b7280; font-size: 0.9rem;">좋아요</div>
                    </div>
                    <div style="text-align: center;">
                        <div style="font-size: 2rem; font-weight: 800; color: #a8e6cf; margin-bottom: 8px;">3,456</div>
                        <div style="color: #6b7280; font-size: 0.9rem;">댓글</div>
                    </div>
                </div>
            </section>
        </main>
        
        <!-- 푸터 include -->
        <%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
    </div>
</body>
</html>