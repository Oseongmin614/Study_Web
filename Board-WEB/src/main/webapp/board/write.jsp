<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 파라미터 추출
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	// DB 저장
	Connection conn = new ConnectionFactory().getConnection();
	
	StringBuilder sql = new StringBuilder();
	sql.append("insert into tbl_board(no, title, writer, content) ");
	sql.append(" values(seq_tbl_board_no.nextval, ?, ?, ?) ");
	
	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	pstmt.setString(1, title);
	pstmt.setString(2, writer);
	pstmt.setString(3, content);
	
	pstmt.executeUpdate();
	
	pstmt.close();
	conn.close();
%>

<script>
	alert('새글등록이 완료되었습니다')
	location.href = 'list.do'
</script>








