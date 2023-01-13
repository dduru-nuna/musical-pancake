<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.dto.BookmarkDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 수정</title>
</head>
<body>
	<div>
		<a href="../bookmark">돌아가기</a> 
	</div>
	<h2>즐겨찾기 수정</h2>
	<form action="./update" method="post">
		<div> <!-- 어떤 것을 수정해야하는지 식별하기 위해 id 를 넣어준다. 사용자한테 보여줄 필요는 없으니 숨김 처리 -->
			<input type="hidden" name="id" value="<%=((BookmarkDTO)request.getAttribute("data")).getId() %>">
		</div>
		<div>
			<input type="text" name="url" value="<%=((BookmarkDTO)request.getAttribute("data")).getUrl() %>">
		</div>
		<div>
			<input type="text" name="name" value="<%=((BookmarkDTO)request.getAttribute("data")).getName() %>">
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
	
</body>
</html>