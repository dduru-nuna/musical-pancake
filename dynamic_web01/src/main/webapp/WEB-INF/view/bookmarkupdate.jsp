<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.dto.BookmarkDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 수정</title>
<c:url var="staticUrl" value="/static" />
<link type="text/css" rel="stylesheet" href="${staticUrl }/bs5/css/bootstrap.min.css">
<script type="text/javascript" src="${staticUrl }/bs5/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div>
		<c:url var="bookmarkUrl" value="/bookmark" />
		<a href="${bookmarkUrl }">돌아가기</a> 
	</div>
	<h2>즐겨찾기 수정</h2>
	<form action="${bookmarkUrl }/update" method="post">
		<div> <!-- 어떤 것을 수정해야하는지 식별하기 위해 id 를 넣어준다. 사용자한테 보여줄 필요는 없으니 숨김 처리 -->
			
			<input type="hidden" name="id" value="${requestScope.data.id }">
		</div>
		<div>
			<input type="text" name="url" value="${requestScope.data.url }">
		</div>
		<div>       <%--여기도 ${requestScope.data.name } 으로 변경하면 됨. 일부러 예전꺼 변경 안함 --%>
			<input type="text" name="name" value="<%=((BookmarkDTO)request.getAttribute("data")).getName() %>">
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
	
</body>
</html>