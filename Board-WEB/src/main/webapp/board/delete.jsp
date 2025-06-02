<%@page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@page import="kr.ac.kopo.board.dao.BoardDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 1. 파라미터 추출
    String noStr = request.getParameter("no");
    int no = Integer.parseInt(noStr);

    // 2. DAO를 이용해 DB에서 게시글 삭제
    BoardDAO boardDao = new BoardDAOImpl();
    boardDao.deleteBoardByNo(no); // deleteBoardByNo 메서드는 게시글 번호로 삭제

    // 3. 목록 페이지로 리다이렉트
    response.sendRedirect("list.do");
%>
