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
<c:url var="staticUrl" value="/static" />
<link type="text/css" rel="stylesheet" href="${staticUrl }/bs5/css/bootstrap.min.css">
<script type="text/javascript" src="${staticUrl }/bs5/js/bootstrap.bundle.min.js"></script>
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
	<div>
		<form action="${visitUrl }">
			<select name="c" onchange="submit();"> <%--submit 하면 폼 안의 내용 전달 --%>
				<option value="5" ${requestScope.cnt eq 5 ? "selected" : "" }>5개</option>
				<option value="10" ${requestScope.cnt eq 10 ? "selected" : "" }>10개</option>
				<option value="15" ${requestScope.cnt eq 15 ? "selected" : "" }>15개</option>
				<option value="20" ${requestScope.cnt eq 20 ? "selected" : "" }>20개</option>
				<option value="25" ${requestScope.cnt eq 25 ? "selected" : "" }>25개</option>
			</select>
		</form>
	</div>
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
	<div>
		<c:set var="pageNumber" value="${empty param.p ? 1 : param.p }" />
		<c:choose>
			<c:when test="${pageNumber eq 1 }">
				<a>prev</a>	
			</c:when>
			<c:otherwise>
				<a href="./visit?p=${pageNumber - 1 }">prev</a>
			</c:otherwise>
		</c:choose>
		<%--목록 추가/삭제 할 때마다 페이지 번호 추가/삭제 됨 --%>
		<c:forEach var="num" items="${requestScope.pageList }">
			<a href="${visitUrl }?p=${num }">${num }</a>
		</c:forEach>
		<c:choose>               
			<c:when test="${pageNumber eq lastPageNumber }"> 
				<a>next</a>	
			</c:when>
			<c:otherwise>
				<a href="./visit?p=${pageNumber + 1 }">next</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>