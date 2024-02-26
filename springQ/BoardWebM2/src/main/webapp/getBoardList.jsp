<%-- <%@ page import = "java.util.List" %>
<%@ page import = "com.springbook.biz.board.impl.BoardDAO" %>
<%@ page import = "com.springbook.biz.board.BoardVO" %> --%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix = "c" %>
    
<%-- <%
	// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
	// 2. DB 연동 처리
	BoardVO vo = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> boardList = boardDAO.getBoardList(vo);
	
	// 3. 응답화면 구성
%> --%>
<%-- <%
	// 세션에 저장된 글 목록을 꺼낸다.
	List<BoardVO> boardList = (List) session.getAttribute("boardList");
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
</head>
<body>
<center>
<h1>글 목록</h1>
<h3>테스트님 환영합니다...<a href="logout.do">Log-out</a></h3>

<!-- 검색 시작 -->
<form action="getBoardList.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<td align="right">
		<select name="searchCondition">
		<option value="TITLE">제목
		<option value="CONTENT">내용
		</select>
		<input name="searchKeyword" type="text"/>
		<input type="submit" value="검색" />
	</td>
</tr>
</table>
</form>
<!-- 검색 종료 -->

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="ADD8E6" width="100">번호</th>
	<th bgcolor="ADD8E6" width="200">제목</th>
	<th bgcolor="ADD8E6" width="150">작성자</th>
	<th bgcolor="ADD8E6" width="150">등록일</th>
	<th bgcolor="ADD8E6" width="100">조회수</th>
</tr>

<c:forEach items="${boardList }" var="board">
<tr>
	<td>${board.seq }</td>
	<td align="left"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
	<td>${board.writer }</td>
	<td>${board.regDate }</td>
	<td>${board.cnt }</td>
</tr>
</c:forEach>

<%-- <% for(BoardVO board : boardList) {%>
<tr>
	<td><%= board.getSeq() %> </td>
	<td align="left"><a href="getBoard.do?seq=<%= board.getSeq() %>">
					 <%= board.getTitle() %></a></td>
	<td><%= board.getWriter() %></td>
	<td><%= board.getRegDate() %></td>
	<td><%= board.getCnt() %></td>
</tr>
<% } %> --%>
</table>
<br>
<a href="insertBoard.jsp">새글 등록</a>
</center>
</body>
</html>