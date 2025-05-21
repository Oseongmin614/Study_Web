<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.ac.kopo.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%
	Connection conn = new ConnectionFactory().getConnection();

	StringBuilder sql = new StringBuilder();
	sql.append("select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') reg_date ");
	sql.append("  from tbl_board ");
	sql.append(" order by no desc ");
	
	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	ResultSet rs = pstmt.executeQuery();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판리스트</title>
</head>
<body>
	<div align="center">
		<hr>
		<h2>전체게시판</h2>
		<hr>
		<br>
		
		<table border="1" style="width: 80%;">
			<tr>
				<th width="7%">번호</th>
				<th>제목</th>
				<th width="15%">작성자</th>
				<th width="17%">등록일</th>
			</tr>
			<%
				while(rs.next()){
			%>
					<tr>
						<td><%= rs.getInt("no") %></td>
						<td><%= rs.getString("title") %></td>
						<td><%= rs.getString("writer") %></td>
						<td><%= rs.getString("reg_date") %></td>
					</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>

<%
	pstmt.close();
	conn.close();
%>