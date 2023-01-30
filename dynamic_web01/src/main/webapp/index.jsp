<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈 화면</title>
<%@ include file="/WEB-INF/view/module/bootstrap.jsp" %>
<%--액션태그 <jsp:include page="/WEB-INF/view/module/bootstrap.jsp" /> 이미 실행된채로(HTML코드로) 반환되기 때문에 제대로 반영 안됨 --%>
</head>
<body>
	<div>
		<%@ include file="/WEB-INF/view/module/topnav.jsp" %>
	</div>
	<h1>Hello JSP/Servlet</h1>
	<p>${sessionScope.role.type }</p>
</body>
</html>
