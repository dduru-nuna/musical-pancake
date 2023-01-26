<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:url var="staticUrl" value="/static" />
<link type="text/css" rel="stylesheet" href="${staticUrl }/bs5/css/bootstrap.min.css">
<script type="text/javascript" src="${staticUrl }/bs5/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<c:url var="mainUrl" value="/" />
	<h1>Hello JSP/Servlet</h1>
	<a href="${mainUrl }visit">방명록</a>
	<a href="${mainUrl }bookmark">즐겨찾기 링크 모음</a>
	<a href="${mainUrl }board">게시판</a>
	<c:choose>
		<c:when test="${sessionScope.login }">
			<a href="${mainUrl }logout">로그아웃</a>
			<a href="${mainUrl }myinfo">개인정보</a>
		</c:when>
		<c:otherwise>
			<a href="${mainUrl }login">로그인</a>
			<a href="${mainUrl }join">회원가입</a>
		</c:otherwise>
	</c:choose>
</body>
</html>
