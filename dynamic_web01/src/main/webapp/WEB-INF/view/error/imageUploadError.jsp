<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 업로드</title>
<%@ include file="/WEB-INF/view/module/bootstrap.jsp" %>
</head>
<body>
	<c:choose>
		<c:when test="${errorType eq 'fileExtError' }">
			<h1>잘못된 파일 포맷입니다.</h1>
			<p>허용된 파일 포맷은 ${initParam.permitFileExt } 입니다.</p>	<!-- web.xml 에 설정했던 값 initParam으로 가져오면 됨 -->
		</c:when>
		<c:when test="${errorType eq 'fileTypeError' }">
			<h1>잘못된 파일 종류 입니다.</h1>
			<p>허용된 파일 포맷은 ${initParam.permitFileType } 입니다.</p>	
		</c:when>
		<c:when test="${errorType eq 'fileSizeError' }">
			<h1>파일의 크기가 너무 큽니다.</h1>
			<p>파일 크기는 ${initParam.maxFileSize } 바이트 보다 작아야 합니다.</p>	
		</c:when>
	</c:choose>
</body>
</html>