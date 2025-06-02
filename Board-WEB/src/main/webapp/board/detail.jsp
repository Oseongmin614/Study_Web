<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@page import="kr.ac.kopo.board.dao.BoardDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
    // http://localhost:8080/Board-WEB/board/detail.jsp?no=3 요청
    int no = Integer.parseInt(request.getParameter("no"));
    BoardDAO boardDao = new BoardDAOImpl();
    BoardVO board = boardDao.selectBoardByNo(no);
    request.setAttribute("board", board);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세게시글</title>
<link rel="stylesheet" href="/Board-WEB/resources/css/layout.css">
<link rel="stylesheet" href="/Board-WEB/resources/css/my_css.css">
<style>
    #content > * {
        width: 60%;
    }
    td {
        padding-left: 10px;
    }
    .button-group {
        display: flex;
        gap: 10px;
        justify-content: center;
        margin-top: 10px;
    }
    /* 모달 스타일 */
    .modal {
        position: fixed; left: 0; top: 0; width: 100vw; height: 100vh;
        background: rgba(0,0,0,0.3); display: none; align-items: center; justify-content: center; z-index: 1000;
    }
    .modal-content {
        background: #fff; padding: 30px 40px; border-radius: 12px; text-align: center;
        box-shadow: 0 2px 16px rgba(0,0,0,0.2);
    }
</style>
<script>
    function openDeleteModal() {
        document.getElementById('deleteModal').style.display = 'flex';
    }
    function closeDeleteModal() {
        document.getElementById('deleteModal').style.display = 'none';
    }

    window.onload = function() {
        // 목록 이동
        let listBtn = document.querySelector('#listBtn');
        if (listBtn) {
            listBtn.addEventListener('click', function() {
                location.href = 'list.do';
            });
        }
        // 수정 이동
        let updateBtn = document.querySelector('#updateBtn');
        if (updateBtn) {
            updateBtn.addEventListener('click', function() {
                location.href = 'update.do?no=${board.no}';
            });
        }
        // 삭제 모달 열기
        let delBtn = document.querySelector('#delBtn');
        if (delBtn) {
            delBtn.addEventListener('click', function() {
                openDeleteModal();
            });
        }
        // 모달
        let modalYes = document.getElementById('modalYes');
        let modalNo = document.getElementById('modalNo');
        if (modalYes) {
            modalYes.addEventListener('click', function() {
            	   location.href = 'delete.jsp?no=${board.no}';
            });
        }
        if (modalNo) {
            modalNo.addEventListener('click', function() {
                closeDeleteModal();
            });
        }
    }
</script>
</head>
<body>
    <div align="center" id="content">
        <hr>
        <h2>상세게시글</h2>
        <hr>
        <table border="1">
            <tr>
                <th width="27%">번호</th>
                <td>${board.no}</td>
            </tr>
            <tr>
                <th width="27%">제목</th>
                <td><c:out value="${board.title}" /></td>
            </tr>
            <tr>
                <th width="27%">작성자</th>
                <td>${board.writer}</td>
            </tr>
            <tr>
                <th width="27%">내용</th>
                <td><c:out value="${board.content}" /></td>
            </tr>
            <tr>
                <th width="27%">조회수</th>
                <td>${board.viewCnt}</td>
            </tr>
            <tr>
                <th width="27%">등록일</th>
                <td>${board.regDate}</td>
            </tr>
        </table>
        <br>
        <div class="button-group">
            <button id="listBtn" class="button">목록</button>
            <button id="updateBtn" class="button">수정</button>
            <button id="delBtn" class="button">삭제</button>
        </div>
    </div>
    <!-- 삭제 모달창 -->
    <div id="deleteModal" class="modal">
        <div class="modal-content">
            <p>현재 글을 삭제 하시겠습니까?</p>
            <button id="modalYes" class="button">예</button>
            <button id="modalNo" class="button">아니오</button>
        </div>
    </div>
</body>
</html>
