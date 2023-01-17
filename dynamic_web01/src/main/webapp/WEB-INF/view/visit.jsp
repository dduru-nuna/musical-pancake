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
<title>방명록</title>
</head>
<body>
	<div>
	<!--<a href="./">메인으로</a> - 현재 페이지는 visit 이고 ./로 현재 폴더(위치=web01)로 갈 수 있다 -->
		<c:url var="mainUrl" value="/" />
		<a href="${mainUrl }">메인으로</a>
	</div>
	<h2>방명록</h2>
	<c:url var="visitUrl" value="/visit" />
	<form action="${visitUrl }" method="post"> <!-- 주소를 입력한것은 GET요청이고 사용자가 방명록에 데이터를 입력하는 것은 post방식 -->
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
<%--<ul>
		<% for(VisitDTO d: (List<VisitDTO>)request.getAttribute("data")) { %>
			<li>
				<%=d.getNickname() %> | <%=d.getContext() %>
				<button type="button" onclick="location.href='./visit/update?id=<%=d.getId() %>'">수정</button>
				<button type="submit" form="deleteForm<%=d.getId() %>">삭제</button>
				<form id="deleteForm<%=d.getId() %>" action="./visit/delete" method="post">
					<input type="hidden" name="id" value="<%=d.getId() %>">
				</form>
			</li>
		<% } %>
	</ul>
--%>	
	<ul>
		<c:forEach var="d" items="${requestScope.data }">
			<c:url var="visitUpdateUrl" value="/visit/update">
				<c:param name="id" value="${d.id }" />
			</c:url>
			<c:set var="formId" value="deleteForm${d.id }" />
			<li>
				${d.nickname } | ${d.context } <!-- 메서드 호출 필요없이 visitDTO 의 멤버변수 쓰면 됨 -->
				<button type="button" onclick="location.href='${visitUpdateUrl}'">수정</button>
				<button type="submit" form="${formId }">삭제</button>
				<form id="${formId }" action="${visitUrl }/delete" method="post">
					<input type="hidden" name="id" value="${d.id }">
				</form>
			</li>
		</c:forEach>
	</ul>
</body>
</html>