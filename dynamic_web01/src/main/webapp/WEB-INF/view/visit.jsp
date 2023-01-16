<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.dto.VisitDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<div>
		<a href="./">메인으로</a> <!-- 현재 페이지는 visit 이고 ./로 현재 폴더(위치=web01)로 갈 수 있다 -->
	</div>
	<h2>방명록</h2>
	<form action="./visit" method="post"> <!-- 주소를 입력한것은 GET요청이고 사용자가 방명록에 데이터를 입력하는 것은 post방식 -->
		<div>
			<input type="text" name="nickname">
		</div>
		<div>
			<textarea rows="3" cols="25" name="context"></textarea>
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
	<ul>
		<% for(VisitDTO d: (List<VisitDTO>)request.getAttribute("data")) { %>
			<li>
				<%=d.getNickname() %> | <%=d.getContext() %>
				<button type="button" onclick="location.href='./visit/update?id=<%=d.getId() %>'">수정</button>
				<button type="submit" form="deleteForm">삭제</button>
				<form id="deleteForm<%=d.getId() %>" action="./visit/delete" method="post">
					<input type="hidden" name="id" value="<%=d.getId() %>">
				</form>
			</li>
		<% } %>
	</ul>
</body>
</html>