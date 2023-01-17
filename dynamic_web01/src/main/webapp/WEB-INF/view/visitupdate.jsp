<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.dto.VisitDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 수정</title>
<c:url var="staticUrl" value="/static" />
<link type="text/css" rel="stylesheet" href="${staticUrl }/bs5/css/bootstrap.min.css">
<script type="text/javascript" src="${staticUrl }/bs5/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div>
		<c:url var="visitUrl" value="/visit" />
		<a href="${visitUrl }">돌아가기</a>
	</div>
	<h2>방명록 수정</h2>
	<form action="${visitUrl }/update" method="post">
		<div>
			<input type="hidden" name="id" value="${requestScope.data.id }">
		</div>
		<div>
			<input type="text" name="nickname" value="${requestScope.data.nickname }">
		</div>
		<div>
			<textarea rows="3" cols="25" name="context">${requestScope.data.context }</textarea>
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
</body>
</html>