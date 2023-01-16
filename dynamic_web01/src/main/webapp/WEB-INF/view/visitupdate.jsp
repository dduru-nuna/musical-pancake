<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.dto.VisitDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 수정</title>
</head>
<body>
	<div>
		<a href="../visit">돌아가기</a>
	</div>
	<h2>방명록 수정</h2>
	<form action="./update" method="post">
		<div>
			<input type="hidden" name="id" value="<%=((VisitDTO)request.getAttribute("data")).getId() %>">
		</div>
		<div>
			<input type="text" name="nickname" value="<%=((VisitDTO)request.getAttribute("data")).getNickname() %>">
		</div>
		<div>
			<textarea type="text" name="context"><%=((VisitDTO)request.getAttribute("data")).getContext() %></textarea>
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
</body>
</html>